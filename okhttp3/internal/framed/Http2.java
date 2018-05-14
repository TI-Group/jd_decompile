package okhttp3.internal.framed;

import android.support.v4.view.ViewCompat;
import b.c;
import b.d;
import b.e;
import b.f;
import b.s;
import b.t;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import okhttp3.Protocol;
import okhttp3.internal.framed.FrameReader.Handler;

/* compiled from: TbsSdkJava */
public final class Http2 implements Variant {
    private static final f CONNECTION_PREFACE = f.encodeUtf8("PRI * HTTP/2.0\r\n\r\nSM\r\n\r\n");
    static final byte FLAG_ACK = (byte) 1;
    static final byte FLAG_COMPRESSED = (byte) 32;
    static final byte FLAG_END_HEADERS = (byte) 4;
    static final byte FLAG_END_PUSH_PROMISE = (byte) 4;
    static final byte FLAG_END_STREAM = (byte) 1;
    static final byte FLAG_NONE = (byte) 0;
    static final byte FLAG_PADDED = (byte) 8;
    static final byte FLAG_PRIORITY = (byte) 32;
    static final int INITIAL_MAX_FRAME_SIZE = 16384;
    static final byte TYPE_CONTINUATION = (byte) 9;
    static final byte TYPE_DATA = (byte) 0;
    static final byte TYPE_GOAWAY = (byte) 7;
    static final byte TYPE_HEADERS = (byte) 1;
    static final byte TYPE_PING = (byte) 6;
    static final byte TYPE_PRIORITY = (byte) 2;
    static final byte TYPE_PUSH_PROMISE = (byte) 5;
    static final byte TYPE_RST_STREAM = (byte) 3;
    static final byte TYPE_SETTINGS = (byte) 4;
    static final byte TYPE_WINDOW_UPDATE = (byte) 8;
    private static final Logger logger = Logger.getLogger(FrameLogger.class.getName());

    /* compiled from: TbsSdkJava */
    static final class ContinuationSource implements s {
        byte flags;
        int left;
        int length;
        short padding;
        private final e source;
        int streamId;

        public ContinuationSource(e eVar) {
            this.source = eVar;
        }

        public long read(c cVar, long j) throws IOException {
            while (this.left == 0) {
                this.source.h((long) this.padding);
                this.padding = (short) 0;
                if ((this.flags & 4) != 0) {
                    return -1;
                }
                readContinuationHeader();
            }
            long read = this.source.read(cVar, Math.min(j, (long) this.left));
            if (read == -1) {
                return -1;
            }
            this.left = (int) (((long) this.left) - read);
            return read;
        }

        public t timeout() {
            return this.source.timeout();
        }

        public void close() throws IOException {
        }

        private void readContinuationHeader() throws IOException {
            int i = this.streamId;
            int access$300 = Http2.readMedium(this.source);
            this.left = access$300;
            this.length = access$300;
            byte h = (byte) (this.source.h() & 255);
            this.flags = (byte) (this.source.h() & 255);
            if (Http2.logger.isLoggable(Level.FINE)) {
                Http2.logger.fine(FrameLogger.formatHeader(true, this.streamId, this.length, h, this.flags));
            }
            this.streamId = this.source.j() & ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
            if (h != (byte) 9) {
                throw Http2.ioException("%s != TYPE_CONTINUATION", Byte.valueOf(h));
            } else if (this.streamId != i) {
                throw Http2.ioException("TYPE_CONTINUATION streamId changed", new Object[0]);
            }
        }
    }

    /* compiled from: TbsSdkJava */
    static final class FrameLogger {
        private static final String[] BINARY = new String[256];
        private static final String[] FLAGS = new String[64];
        private static final String[] TYPES = new String[]{"DATA", "HEADERS", "PRIORITY", "RST_STREAM", "SETTINGS", "PUSH_PROMISE", "PING", "GOAWAY", "WINDOW_UPDATE", "CONTINUATION"};

        FrameLogger() {
        }

        static String formatHeader(boolean z, int i, int i2, byte b, byte b2) {
            String format = b < TYPES.length ? TYPES[b] : String.format("0x%02x", new Object[]{Byte.valueOf(b)});
            String formatFlags = formatFlags(b, b2);
            String str = "%s 0x%08x %5d %-13s %s";
            Object[] objArr = new Object[5];
            objArr[0] = z ? "<<" : ">>";
            objArr[1] = Integer.valueOf(i);
            objArr[2] = Integer.valueOf(i2);
            objArr[3] = format;
            objArr[4] = formatFlags;
            return String.format(str, objArr);
        }

        static String formatFlags(byte b, byte b2) {
            if (b2 == (byte) 0) {
                return "";
            }
            switch (b) {
                case (byte) 2:
                case (byte) 3:
                case (byte) 7:
                case (byte) 8:
                    return BINARY[b2];
                case (byte) 4:
                case (byte) 6:
                    return b2 == (byte) 1 ? "ACK" : BINARY[b2];
                default:
                    String str = b2 < FLAGS.length ? FLAGS[b2] : BINARY[b2];
                    if (b == (byte) 5 && (b2 & 4) != 0) {
                        return str.replace("HEADERS", "PUSH_PROMISE");
                    }
                    if (b != (byte) 0 || (b2 & 32) == 0) {
                        return str;
                    }
                    return str.replace("PRIORITY", "COMPRESSED");
            }
        }

        static {
            int i = 0;
            for (int i2 = 0; i2 < BINARY.length; i2++) {
                BINARY[i2] = String.format("%8s", new Object[]{Integer.toBinaryString(i2)}).replace(' ', '0');
            }
            FLAGS[0] = "";
            FLAGS[1] = "END_STREAM";
            int[] iArr = new int[]{1};
            FLAGS[8] = "PADDED";
            for (int i3 : iArr) {
                FLAGS[i3 | 8] = FLAGS[i3] + "|PADDED";
            }
            FLAGS[4] = "END_HEADERS";
            FLAGS[32] = "PRIORITY";
            FLAGS[36] = "END_HEADERS|PRIORITY";
            for (int i4 : new int[]{4, 32, 36}) {
                for (int i5 : iArr) {
                    FLAGS[i5 | i4] = FLAGS[i5] + '|' + FLAGS[i4];
                    FLAGS[(i5 | i4) | 8] = FLAGS[i5] + '|' + FLAGS[i4] + "|PADDED";
                }
            }
            while (i < FLAGS.length) {
                if (FLAGS[i] == null) {
                    FLAGS[i] = BINARY[i];
                }
                i++;
            }
        }
    }

    /* compiled from: TbsSdkJava */
    static final class Reader implements FrameReader {
        private final boolean client;
        private final ContinuationSource continuation = new ContinuationSource(this.source);
        final Reader hpackReader;
        private final e source;

        Reader(e eVar, int i, boolean z) {
            this.source = eVar;
            this.client = z;
            this.hpackReader = new Reader(i, this.continuation);
        }

        public void readConnectionPreface() throws IOException {
            if (!this.client) {
                f d = this.source.d((long) Http2.CONNECTION_PREFACE.size());
                if (Http2.logger.isLoggable(Level.FINE)) {
                    Http2.logger.fine(String.format("<< CONNECTION %s", new Object[]{d.hex()}));
                }
                if (!Http2.CONNECTION_PREFACE.equals(d)) {
                    throw Http2.ioException("Expected a connection header but was %s", d.utf8());
                }
            }
        }

        public boolean nextFrame(Handler handler) throws IOException {
            try {
                this.source.a(9);
                int access$300 = Http2.readMedium(this.source);
                if (access$300 < 0 || access$300 > 16384) {
                    throw Http2.ioException("FRAME_SIZE_ERROR: %s", Integer.valueOf(access$300));
                }
                byte h = (byte) (this.source.h() & 255);
                byte h2 = (byte) (this.source.h() & 255);
                int j = this.source.j() & ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
                if (Http2.logger.isLoggable(Level.FINE)) {
                    Http2.logger.fine(FrameLogger.formatHeader(true, j, access$300, h, h2));
                }
                switch (h) {
                    case (byte) 0:
                        readData(handler, access$300, h2, j);
                        return true;
                    case (byte) 1:
                        readHeaders(handler, access$300, h2, j);
                        return true;
                    case (byte) 2:
                        readPriority(handler, access$300, h2, j);
                        return true;
                    case (byte) 3:
                        readRstStream(handler, access$300, h2, j);
                        return true;
                    case (byte) 4:
                        readSettings(handler, access$300, h2, j);
                        return true;
                    case (byte) 5:
                        readPushPromise(handler, access$300, h2, j);
                        return true;
                    case (byte) 6:
                        readPing(handler, access$300, h2, j);
                        return true;
                    case (byte) 7:
                        readGoAway(handler, access$300, h2, j);
                        return true;
                    case (byte) 8:
                        readWindowUpdate(handler, access$300, h2, j);
                        return true;
                    default:
                        this.source.h((long) access$300);
                        return true;
                }
            } catch (IOException e) {
                return false;
            }
        }

        private void readHeaders(Handler handler, int i, byte b, int i2) throws IOException {
            if (i2 == 0) {
                throw Http2.ioException("PROTOCOL_ERROR: TYPE_HEADERS streamId == 0", new Object[0]);
            }
            short h;
            boolean z = (b & 1) != 0;
            if ((b & 8) != 0) {
                h = (short) (this.source.h() & 255);
            } else {
                h = (short) 0;
            }
            if ((b & 32) != 0) {
                readPriority(handler, i2);
                i -= 5;
            }
            handler.headers(false, z, i2, -1, readHeaderBlock(Http2.lengthWithoutPadding(i, b, h), h, b, i2), HeadersMode.HTTP_20_HEADERS);
        }

        private List<Header> readHeaderBlock(int i, short s, byte b, int i2) throws IOException {
            ContinuationSource continuationSource = this.continuation;
            this.continuation.left = i;
            continuationSource.length = i;
            this.continuation.padding = s;
            this.continuation.flags = b;
            this.continuation.streamId = i2;
            this.hpackReader.readHeaders();
            return this.hpackReader.getAndResetHeaderList();
        }

        private void readData(Handler handler, int i, byte b, int i2) throws IOException {
            boolean z;
            short s = (short) 1;
            short s2 = (short) 0;
            if ((b & 1) != 0) {
                z = true;
            } else {
                z = false;
            }
            if ((b & 32) == 0) {
                s = (short) 0;
            }
            if (s != (short) 0) {
                throw Http2.ioException("PROTOCOL_ERROR: FLAG_COMPRESSED without SETTINGS_COMPRESS_DATA", new Object[0]);
            }
            if ((b & 8) != 0) {
                s2 = (short) (this.source.h() & 255);
            }
            handler.data(z, i2, this.source, Http2.lengthWithoutPadding(i, b, s2));
            this.source.h((long) s2);
        }

        private void readPriority(Handler handler, int i, byte b, int i2) throws IOException {
            if (i != 5) {
                throw Http2.ioException("TYPE_PRIORITY length: %d != 5", Integer.valueOf(i));
            } else if (i2 == 0) {
                throw Http2.ioException("TYPE_PRIORITY streamId == 0", new Object[0]);
            } else {
                readPriority(handler, i2);
            }
        }

        private void readPriority(Handler handler, int i) throws IOException {
            int j = this.source.j();
            handler.priority(i, j & ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED, (this.source.h() & 255) + 1, (Integer.MIN_VALUE & j) != 0);
        }

        private void readRstStream(Handler handler, int i, byte b, int i2) throws IOException {
            if (i != 4) {
                throw Http2.ioException("TYPE_RST_STREAM length: %d != 4", Integer.valueOf(i));
            } else if (i2 == 0) {
                throw Http2.ioException("TYPE_RST_STREAM streamId == 0", new Object[0]);
            } else {
                ErrorCode fromHttp2 = ErrorCode.fromHttp2(this.source.j());
                if (fromHttp2 == null) {
                    throw Http2.ioException("TYPE_RST_STREAM unexpected error code: %d", Integer.valueOf(r0));
                } else {
                    handler.rstStream(i2, fromHttp2);
                }
            }
        }

        private void readSettings(Handler handler, int i, byte b, int i2) throws IOException {
            if (i2 != 0) {
                throw Http2.ioException("TYPE_SETTINGS streamId != 0", new Object[0]);
            } else if ((b & 1) != 0) {
                if (i != 0) {
                    throw Http2.ioException("FRAME_SIZE_ERROR ack frame should be empty!", new Object[0]);
                }
                handler.ackSettings();
            } else if (i % 6 != 0) {
                throw Http2.ioException("TYPE_SETTINGS length %% 6 != 0: %s", Integer.valueOf(i));
            } else {
                Settings settings = new Settings();
                for (int i3 = 0; i3 < i; i3 += 6) {
                    int i4 = this.source.i();
                    int j = this.source.j();
                    switch (i4) {
                        case 2:
                            if (!(j == 0 || j == 1)) {
                                throw Http2.ioException("PROTOCOL_ERROR SETTINGS_ENABLE_PUSH != 0 or 1", new Object[0]);
                            }
                        case 3:
                            i4 = 4;
                            break;
                        case 4:
                            i4 = 7;
                            if (j >= 0) {
                                break;
                            }
                            throw Http2.ioException("PROTOCOL_ERROR SETTINGS_INITIAL_WINDOW_SIZE > 2^31 - 1", new Object[0]);
                        case 5:
                            if (j >= 16384 && j <= ViewCompat.MEASURED_SIZE_MASK) {
                                break;
                            }
                            throw Http2.ioException("PROTOCOL_ERROR SETTINGS_MAX_FRAME_SIZE: %s", Integer.valueOf(j));
                        default:
                            break;
                    }
                    settings.set(i4, 0, j);
                }
                handler.settings(false, settings);
                if (settings.getHeaderTableSize() >= 0) {
                    this.hpackReader.headerTableSizeSetting(settings.getHeaderTableSize());
                }
            }
        }

        private void readPushPromise(Handler handler, int i, byte b, int i2) throws IOException {
            short s = (short) 0;
            if (i2 == 0) {
                throw Http2.ioException("PROTOCOL_ERROR: TYPE_PUSH_PROMISE streamId == 0", new Object[0]);
            }
            if ((b & 8) != 0) {
                s = (short) (this.source.h() & 255);
            }
            handler.pushPromise(i2, this.source.j() & ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED, readHeaderBlock(Http2.lengthWithoutPadding(i - 4, b, s), s, b, i2));
        }

        private void readPing(Handler handler, int i, byte b, int i2) throws IOException {
            boolean z = true;
            if (i != 8) {
                throw Http2.ioException("TYPE_PING length != 8: %s", Integer.valueOf(i));
            } else if (i2 != 0) {
                throw Http2.ioException("TYPE_PING streamId != 0", new Object[0]);
            } else {
                int j = this.source.j();
                int j2 = this.source.j();
                if ((b & 1) == 0) {
                    z = false;
                }
                handler.ping(z, j, j2);
            }
        }

        private void readGoAway(Handler handler, int i, byte b, int i2) throws IOException {
            if (i < 8) {
                throw Http2.ioException("TYPE_GOAWAY length < 8: %s", Integer.valueOf(i));
            } else if (i2 != 0) {
                throw Http2.ioException("TYPE_GOAWAY streamId != 0", new Object[0]);
            } else {
                int j = this.source.j();
                int i3 = i - 8;
                ErrorCode fromHttp2 = ErrorCode.fromHttp2(this.source.j());
                if (fromHttp2 == null) {
                    throw Http2.ioException("TYPE_GOAWAY unexpected error code: %d", Integer.valueOf(r0));
                }
                f fVar = f.EMPTY;
                if (i3 > 0) {
                    fVar = this.source.d((long) i3);
                }
                handler.goAway(j, fromHttp2, fVar);
            }
        }

        private void readWindowUpdate(Handler handler, int i, byte b, int i2) throws IOException {
            if (i != 4) {
                throw Http2.ioException("TYPE_WINDOW_UPDATE length !=4: %s", Integer.valueOf(i));
            }
            long j = ((long) this.source.j()) & 2147483647L;
            if (j == 0) {
                throw Http2.ioException("windowSizeIncrement was 0", Long.valueOf(j));
            } else {
                handler.windowUpdate(i2, j);
            }
        }

        public void close() throws IOException {
            this.source.close();
        }
    }

    /* compiled from: TbsSdkJava */
    static final class Writer implements FrameWriter {
        private final boolean client;
        private boolean closed;
        private final c hpackBuffer = new c();
        private final Writer hpackWriter = new Writer(this.hpackBuffer);
        private int maxFrameSize = 16384;
        private final d sink;

        Writer(d dVar, boolean z) {
            this.sink = dVar;
            this.client = z;
        }

        public synchronized void flush() throws IOException {
            if (this.closed) {
                throw new IOException("closed");
            }
            this.sink.flush();
        }

        public synchronized void ackSettings(Settings settings) throws IOException {
            if (this.closed) {
                throw new IOException("closed");
            }
            this.maxFrameSize = settings.getMaxFrameSize(this.maxFrameSize);
            frameHeader(0, 0, (byte) 4, (byte) 1);
            this.sink.flush();
        }

        public synchronized void connectionPreface() throws IOException {
            if (this.closed) {
                throw new IOException("closed");
            } else if (this.client) {
                if (Http2.logger.isLoggable(Level.FINE)) {
                    Http2.logger.fine(String.format(">> CONNECTION %s", new Object[]{Http2.CONNECTION_PREFACE.hex()}));
                }
                this.sink.c(Http2.CONNECTION_PREFACE.toByteArray());
                this.sink.flush();
            }
        }

        public synchronized void synStream(boolean z, boolean z2, int i, int i2, List<Header> list) throws IOException {
            if (z2) {
                throw new UnsupportedOperationException();
            } else if (this.closed) {
                throw new IOException("closed");
            } else {
                headers(z, i, list);
            }
        }

        public synchronized void synReply(boolean z, int i, List<Header> list) throws IOException {
            if (this.closed) {
                throw new IOException("closed");
            }
            headers(z, i, list);
        }

        public synchronized void headers(int i, List<Header> list) throws IOException {
            if (this.closed) {
                throw new IOException("closed");
            }
            headers(false, i, list);
        }

        public synchronized void pushPromise(int i, int i2, List<Header> list) throws IOException {
            if (this.closed) {
                throw new IOException("closed");
            }
            this.hpackWriter.writeHeaders(list);
            long a = this.hpackBuffer.a();
            int min = (int) Math.min((long) (this.maxFrameSize - 4), a);
            frameHeader(i, min + 4, (byte) 5, a == ((long) min) ? (byte) 4 : (byte) 0);
            this.sink.f(ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED & i2);
            this.sink.write(this.hpackBuffer, (long) min);
            if (a > ((long) min)) {
                writeContinuationFrames(i, a - ((long) min));
            }
        }

        void headers(boolean z, int i, List<Header> list) throws IOException {
            if (this.closed) {
                throw new IOException("closed");
            }
            this.hpackWriter.writeHeaders(list);
            long a = this.hpackBuffer.a();
            int min = (int) Math.min((long) this.maxFrameSize, a);
            byte b = a == ((long) min) ? (byte) 4 : (byte) 0;
            if (z) {
                b = (byte) (b | 1);
            }
            frameHeader(i, min, (byte) 1, b);
            this.sink.write(this.hpackBuffer, (long) min);
            if (a > ((long) min)) {
                writeContinuationFrames(i, a - ((long) min));
            }
        }

        private void writeContinuationFrames(int i, long j) throws IOException {
            while (j > 0) {
                int min = (int) Math.min((long) this.maxFrameSize, j);
                j -= (long) min;
                frameHeader(i, min, (byte) 9, j == 0 ? (byte) 4 : (byte) 0);
                this.sink.write(this.hpackBuffer, (long) min);
            }
        }

        public synchronized void rstStream(int i, ErrorCode errorCode) throws IOException {
            if (this.closed) {
                throw new IOException("closed");
            } else if (errorCode.httpCode == -1) {
                throw new IllegalArgumentException();
            } else {
                frameHeader(i, 4, (byte) 3, (byte) 0);
                this.sink.f(errorCode.httpCode);
                this.sink.flush();
            }
        }

        public int maxDataLength() {
            return this.maxFrameSize;
        }

        public synchronized void data(boolean z, int i, c cVar, int i2) throws IOException {
            if (this.closed) {
                throw new IOException("closed");
            }
            byte b = (byte) 0;
            if (z) {
                b = (byte) 1;
            }
            dataFrame(i, b, cVar, i2);
        }

        void dataFrame(int i, byte b, c cVar, int i2) throws IOException {
            frameHeader(i, i2, (byte) 0, b);
            if (i2 > 0) {
                this.sink.write(cVar, (long) i2);
            }
        }

        public synchronized void settings(Settings settings) throws IOException {
            synchronized (this) {
                if (this.closed) {
                    throw new IOException("closed");
                }
                frameHeader(0, settings.size() * 6, (byte) 4, (byte) 0);
                for (int i = 0; i < 10; i++) {
                    if (settings.isSet(i)) {
                        int i2;
                        if (i == 4) {
                            i2 = 3;
                        } else if (i == 7) {
                            i2 = 4;
                        } else {
                            i2 = i;
                        }
                        this.sink.g(i2);
                        this.sink.f(settings.get(i));
                    }
                }
                this.sink.flush();
            }
        }

        public synchronized void ping(boolean z, int i, int i2) throws IOException {
            byte b = (byte) 0;
            synchronized (this) {
                if (this.closed) {
                    throw new IOException("closed");
                }
                if (z) {
                    b = (byte) 1;
                }
                frameHeader(0, 8, (byte) 6, b);
                this.sink.f(i);
                this.sink.f(i2);
                this.sink.flush();
            }
        }

        public synchronized void goAway(int i, ErrorCode errorCode, byte[] bArr) throws IOException {
            if (this.closed) {
                throw new IOException("closed");
            } else if (errorCode.httpCode == -1) {
                throw Http2.illegalArgument("errorCode.httpCode == -1", new Object[0]);
            } else {
                frameHeader(0, bArr.length + 8, (byte) 7, (byte) 0);
                this.sink.f(i);
                this.sink.f(errorCode.httpCode);
                if (bArr.length > 0) {
                    this.sink.c(bArr);
                }
                this.sink.flush();
            }
        }

        public synchronized void windowUpdate(int i, long j) throws IOException {
            if (this.closed) {
                throw new IOException("closed");
            } else if (j == 0 || j > 2147483647L) {
                throw Http2.illegalArgument("windowSizeIncrement == 0 || windowSizeIncrement > 0x7fffffffL: %s", Long.valueOf(j));
            } else {
                frameHeader(i, 4, (byte) 8, (byte) 0);
                this.sink.f((int) j);
                this.sink.flush();
            }
        }

        public synchronized void close() throws IOException {
            this.closed = true;
            this.sink.close();
        }

        void frameHeader(int i, int i2, byte b, byte b2) throws IOException {
            if (Http2.logger.isLoggable(Level.FINE)) {
                Http2.logger.fine(FrameLogger.formatHeader(false, i, i2, b, b2));
            }
            if (i2 > this.maxFrameSize) {
                throw Http2.illegalArgument("FRAME_SIZE_ERROR length > %d: %d", Integer.valueOf(this.maxFrameSize), Integer.valueOf(i2));
            } else if ((Integer.MIN_VALUE & i) != 0) {
                throw Http2.illegalArgument("reserved bit set: %s", Integer.valueOf(i));
            } else {
                Http2.writeMedium(this.sink, i2);
                this.sink.h(b & 255);
                this.sink.h(b2 & 255);
                this.sink.f(ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED & i);
            }
        }
    }

    public Protocol getProtocol() {
        return Protocol.HTTP_2;
    }

    public FrameReader newReader(e eVar, boolean z) {
        return new Reader(eVar, 4096, z);
    }

    public FrameWriter newWriter(d dVar, boolean z) {
        return new Writer(dVar, z);
    }

    private static IllegalArgumentException illegalArgument(String str, Object... objArr) {
        throw new IllegalArgumentException(String.format(str, objArr));
    }

    private static IOException ioException(String str, Object... objArr) throws IOException {
        throw new IOException(String.format(str, objArr));
    }

    private static int lengthWithoutPadding(int i, byte b, short s) throws IOException {
        if ((b & 8) != 0) {
            short s2 = i - 1;
        }
        if (s <= s2) {
            return (short) (s2 - s);
        }
        throw ioException("PROTOCOL_ERROR padding %s > remaining length %s", Short.valueOf(s), Integer.valueOf(s2));
    }

    private static int readMedium(e eVar) throws IOException {
        return (((eVar.h() & 255) << 16) | ((eVar.h() & 255) << 8)) | (eVar.h() & 255);
    }

    private static void writeMedium(d dVar, int i) throws IOException {
        dVar.h((i >>> 16) & 255);
        dVar.h((i >>> 8) & 255);
        dVar.h(i & 255);
    }
}
