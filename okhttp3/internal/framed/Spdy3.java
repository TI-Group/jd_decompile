package okhttp3.internal.framed;

import android.support.v4.internal.view.SupportMenu;
import android.support.v4.view.ViewCompat;
import b.c;
import b.d;
import b.e;
import b.f;
import b.g;
import b.m;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.ProtocolException;
import java.util.List;
import java.util.zip.Deflater;
import okhttp3.Protocol;
import okhttp3.internal.Util;
import okhttp3.internal.framed.FrameReader.Handler;

/* compiled from: TbsSdkJava */
public final class Spdy3 implements Variant {
    static final byte[] DICTIONARY;
    static final int FLAG_FIN = 1;
    static final int FLAG_UNIDIRECTIONAL = 2;
    static final int TYPE_DATA = 0;
    static final int TYPE_GOAWAY = 7;
    static final int TYPE_HEADERS = 8;
    static final int TYPE_PING = 6;
    static final int TYPE_RST_STREAM = 3;
    static final int TYPE_SETTINGS = 4;
    static final int TYPE_SYN_REPLY = 2;
    static final int TYPE_SYN_STREAM = 1;
    static final int TYPE_WINDOW_UPDATE = 9;
    static final int VERSION = 3;

    /* compiled from: TbsSdkJava */
    static final class Reader implements FrameReader {
        private final boolean client;
        private final NameValueBlockReader headerBlockReader = new NameValueBlockReader(this.source);
        private final e source;

        Reader(e eVar, boolean z) {
            this.source = eVar;
            this.client = z;
        }

        public void readConnectionPreface() {
        }

        public boolean nextFrame(Handler handler) throws IOException {
            boolean z = false;
            try {
                int j = this.source.j();
                int j2 = this.source.j();
                int i = (-16777216 & j2) >>> 24;
                j2 &= ViewCompat.MEASURED_SIZE_MASK;
                int i2;
                if ((Integer.MIN_VALUE & j) != 0) {
                    int i3 = (2147418112 & j) >>> 16;
                    i2 = SupportMenu.USER_MASK & j;
                    if (i3 != 3) {
                        throw new ProtocolException("version != 3: " + i3);
                    }
                    switch (i2) {
                        case 1:
                            readSynStream(handler, i, j2);
                            return true;
                        case 2:
                            readSynReply(handler, i, j2);
                            return true;
                        case 3:
                            readRstStream(handler, i, j2);
                            return true;
                        case 4:
                            readSettings(handler, i, j2);
                            return true;
                        case 6:
                            readPing(handler, i, j2);
                            return true;
                        case 7:
                            readGoAway(handler, i, j2);
                            return true;
                        case 8:
                            readHeaders(handler, i, j2);
                            return true;
                        case 9:
                            readWindowUpdate(handler, i, j2);
                            return true;
                        default:
                            this.source.h((long) j2);
                            return true;
                    }
                }
                i2 = ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED & j;
                if ((i & 1) != 0) {
                    z = true;
                }
                handler.data(z, i2, this.source, j2);
                return true;
            } catch (IOException e) {
                return false;
            }
        }

        private void readSynStream(Handler handler, int i, int i2) throws IOException {
            boolean z;
            boolean z2 = true;
            int j = this.source.j();
            int i3 = j & ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
            int j2 = this.source.j() & ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
            this.source.i();
            List readNameValueBlock = this.headerBlockReader.readNameValueBlock(i2 - 10);
            if ((i & 1) != 0) {
                z = true;
            } else {
                z = false;
            }
            if ((i & 2) == 0) {
                z2 = false;
            }
            handler.headers(z2, z, i3, j2, readNameValueBlock, HeadersMode.SPDY_SYN_STREAM);
        }

        private void readSynReply(Handler handler, int i, int i2) throws IOException {
            boolean z;
            int j = this.source.j() & ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
            List readNameValueBlock = this.headerBlockReader.readNameValueBlock(i2 - 4);
            if ((i & 1) != 0) {
                z = true;
            } else {
                z = false;
            }
            handler.headers(false, z, j, -1, readNameValueBlock, HeadersMode.SPDY_REPLY);
        }

        private void readRstStream(Handler handler, int i, int i2) throws IOException {
            if (i2 != 8) {
                throw ioException("TYPE_RST_STREAM length: %d != 8", Integer.valueOf(i2));
            }
            int j = this.source.j() & ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
            ErrorCode fromSpdy3Rst = ErrorCode.fromSpdy3Rst(this.source.j());
            if (fromSpdy3Rst == null) {
                throw ioException("TYPE_RST_STREAM unexpected error code: %d", Integer.valueOf(r1));
            } else {
                handler.rstStream(j, fromSpdy3Rst);
            }
        }

        private void readHeaders(Handler handler, int i, int i2) throws IOException {
            handler.headers(false, false, this.source.j() & ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED, -1, this.headerBlockReader.readNameValueBlock(i2 - 4), HeadersMode.SPDY_HEADERS);
        }

        private void readWindowUpdate(Handler handler, int i, int i2) throws IOException {
            if (i2 != 8) {
                throw ioException("TYPE_WINDOW_UPDATE length: %d != 8", Integer.valueOf(i2));
            }
            int j = this.source.j() & ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
            long j2 = (long) (this.source.j() & ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
            if (j2 == 0) {
                throw ioException("windowSizeIncrement was 0", Long.valueOf(j2));
            } else {
                handler.windowUpdate(j, j2);
            }
        }

        private void readPing(Handler handler, int i, int i2) throws IOException {
            boolean z = true;
            if (i2 != 4) {
                throw ioException("TYPE_PING length: %d != 4", Integer.valueOf(i2));
            }
            boolean z2;
            int j = this.source.j();
            boolean z3 = this.client;
            if ((j & 1) == 1) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (z3 != z2) {
                z = false;
            }
            handler.ping(z, j, 0);
        }

        private void readGoAway(Handler handler, int i, int i2) throws IOException {
            if (i2 != 8) {
                throw ioException("TYPE_GOAWAY length: %d != 8", Integer.valueOf(i2));
            }
            int j = this.source.j() & ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
            ErrorCode fromSpdyGoAway = ErrorCode.fromSpdyGoAway(this.source.j());
            if (fromSpdyGoAway == null) {
                throw ioException("TYPE_GOAWAY unexpected error code: %d", Integer.valueOf(r1));
            } else {
                handler.goAway(j, fromSpdyGoAway, f.EMPTY);
            }
        }

        private void readSettings(Handler handler, int i, int i2) throws IOException {
            boolean z = true;
            int j = this.source.j();
            if (i2 != (j * 8) + 4) {
                throw ioException("TYPE_SETTINGS length: %d != 4 + 8 * %d", Integer.valueOf(i2), Integer.valueOf(j));
            }
            Settings settings = new Settings();
            for (int i3 = 0; i3 < j; i3++) {
                int j2 = this.source.j();
                int i4 = (-16777216 & j2) >>> 24;
                settings.set(j2 & ViewCompat.MEASURED_SIZE_MASK, i4, this.source.j());
            }
            if ((i & 1) == 0) {
                z = false;
            }
            handler.settings(z, settings);
        }

        private static IOException ioException(String str, Object... objArr) throws IOException {
            throw new IOException(String.format(str, objArr));
        }

        public void close() throws IOException {
            this.headerBlockReader.close();
        }
    }

    /* compiled from: TbsSdkJava */
    static final class Writer implements FrameWriter {
        private final boolean client;
        private boolean closed;
        private final c headerBlockBuffer = new c();
        private final d headerBlockOut;
        private final d sink;

        Writer(d dVar, boolean z) {
            this.sink = dVar;
            this.client = z;
            Deflater deflater = new Deflater();
            deflater.setDictionary(Spdy3.DICTIONARY);
            this.headerBlockOut = m.a(new g(this.headerBlockBuffer, deflater));
        }

        public void ackSettings(Settings settings) {
        }

        public void pushPromise(int i, int i2, List<Header> list) throws IOException {
        }

        public synchronized void connectionPreface() {
        }

        public synchronized void flush() throws IOException {
            if (this.closed) {
                throw new IOException("closed");
            }
            this.sink.flush();
        }

        public synchronized void synStream(boolean z, boolean z2, int i, int i2, List<Header> list) throws IOException {
            int i3 = 0;
            synchronized (this) {
                if (this.closed) {
                    throw new IOException("closed");
                }
                writeNameValueBlockToBuffer(list);
                int a = (int) (10 + this.headerBlockBuffer.a());
                int i4 = z ? 1 : 0;
                if (z2) {
                    i3 = 2;
                }
                i3 |= i4;
                this.sink.f(-2147287039);
                this.sink.f(((i3 & 255) << 24) | (a & ViewCompat.MEASURED_SIZE_MASK));
                this.sink.f(i & ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
                this.sink.f(i2 & ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
                this.sink.g(0);
                this.sink.a(this.headerBlockBuffer);
                this.sink.flush();
            }
        }

        public synchronized void synReply(boolean z, int i, List<Header> list) throws IOException {
            if (this.closed) {
                throw new IOException("closed");
            }
            writeNameValueBlockToBuffer(list);
            int i2 = z ? 1 : 0;
            int a = (int) (this.headerBlockBuffer.a() + 4);
            this.sink.f(-2147287038);
            this.sink.f(((i2 & 255) << 24) | (a & ViewCompat.MEASURED_SIZE_MASK));
            this.sink.f(ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED & i);
            this.sink.a(this.headerBlockBuffer);
            this.sink.flush();
        }

        public synchronized void headers(int i, List<Header> list) throws IOException {
            if (this.closed) {
                throw new IOException("closed");
            }
            writeNameValueBlockToBuffer(list);
            int a = (int) (this.headerBlockBuffer.a() + 4);
            this.sink.f(-2147287032);
            this.sink.f((a & ViewCompat.MEASURED_SIZE_MASK) | 0);
            this.sink.f(ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED & i);
            this.sink.a(this.headerBlockBuffer);
        }

        public synchronized void rstStream(int i, ErrorCode errorCode) throws IOException {
            if (this.closed) {
                throw new IOException("closed");
            } else if (errorCode.spdyRstCode == -1) {
                throw new IllegalArgumentException();
            } else {
                this.sink.f(-2147287037);
                this.sink.f(8);
                this.sink.f(ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED & i);
                this.sink.f(errorCode.spdyRstCode);
                this.sink.flush();
            }
        }

        public int maxDataLength() {
            return 16383;
        }

        public synchronized void data(boolean z, int i, c cVar, int i2) throws IOException {
            sendDataFrame(i, z ? 1 : 0, cVar, i2);
        }

        void sendDataFrame(int i, int i2, c cVar, int i3) throws IOException {
            if (this.closed) {
                throw new IOException("closed");
            } else if (((long) i3) > 16777215) {
                throw new IllegalArgumentException("FRAME_TOO_LARGE max size is 16Mib: " + i3);
            } else {
                this.sink.f(ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED & i);
                this.sink.f(((i2 & 255) << 24) | (ViewCompat.MEASURED_SIZE_MASK & i3));
                if (i3 > 0) {
                    this.sink.write(cVar, (long) i3);
                }
            }
        }

        private void writeNameValueBlockToBuffer(List<Header> list) throws IOException {
            this.headerBlockOut.f(list.size());
            int size = list.size();
            for (int i = 0; i < size; i++) {
                f fVar = ((Header) list.get(i)).name;
                this.headerBlockOut.f(fVar.size());
                this.headerBlockOut.b(fVar);
                fVar = ((Header) list.get(i)).value;
                this.headerBlockOut.f(fVar.size());
                this.headerBlockOut.b(fVar);
            }
            this.headerBlockOut.flush();
        }

        public synchronized void settings(Settings settings) throws IOException {
            if (this.closed) {
                throw new IOException("closed");
            }
            int size = settings.size();
            int i = (size * 8) + 4;
            this.sink.f(-2147287036);
            this.sink.f((i & ViewCompat.MEASURED_SIZE_MASK) | 0);
            this.sink.f(size);
            for (size = 0; size <= 10; size++) {
                if (settings.isSet(size)) {
                    this.sink.f(((settings.flags(size) & 255) << 24) | (size & ViewCompat.MEASURED_SIZE_MASK));
                    this.sink.f(settings.get(size));
                }
            }
            this.sink.flush();
        }

        public synchronized void ping(boolean z, int i, int i2) throws IOException {
            boolean z2 = true;
            synchronized (this) {
                if (this.closed) {
                    throw new IOException("closed");
                }
                boolean z3;
                boolean z4 = this.client;
                if ((i & 1) == 1) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (z4 == z3) {
                    z2 = false;
                }
                if (z != z2) {
                    throw new IllegalArgumentException("payload != reply");
                }
                this.sink.f(-2147287034);
                this.sink.f(4);
                this.sink.f(i);
                this.sink.flush();
            }
        }

        public synchronized void goAway(int i, ErrorCode errorCode, byte[] bArr) throws IOException {
            if (this.closed) {
                throw new IOException("closed");
            } else if (errorCode.spdyGoAwayCode == -1) {
                throw new IllegalArgumentException("errorCode.spdyGoAwayCode == -1");
            } else {
                this.sink.f(-2147287033);
                this.sink.f(8);
                this.sink.f(i);
                this.sink.f(errorCode.spdyGoAwayCode);
                this.sink.flush();
            }
        }

        public synchronized void windowUpdate(int i, long j) throws IOException {
            if (this.closed) {
                throw new IOException("closed");
            } else if (j == 0 || j > 2147483647L) {
                throw new IllegalArgumentException("windowSizeIncrement must be between 1 and 0x7fffffff: " + j);
            } else {
                this.sink.f(-2147287031);
                this.sink.f(8);
                this.sink.f(i);
                this.sink.f((int) j);
                this.sink.flush();
            }
        }

        public synchronized void close() throws IOException {
            this.closed = true;
            Util.closeAll(this.sink, this.headerBlockOut);
        }
    }

    public Protocol getProtocol() {
        return Protocol.SPDY_3;
    }

    static {
        try {
            DICTIONARY = "\u0000\u0000\u0000\u0007options\u0000\u0000\u0000\u0004head\u0000\u0000\u0000\u0004post\u0000\u0000\u0000\u0003put\u0000\u0000\u0000\u0006delete\u0000\u0000\u0000\u0005trace\u0000\u0000\u0000\u0006accept\u0000\u0000\u0000\u000eaccept-charset\u0000\u0000\u0000\u000faccept-encoding\u0000\u0000\u0000\u000faccept-language\u0000\u0000\u0000\raccept-ranges\u0000\u0000\u0000\u0003age\u0000\u0000\u0000\u0005allow\u0000\u0000\u0000\rauthorization\u0000\u0000\u0000\rcache-control\u0000\u0000\u0000\nconnection\u0000\u0000\u0000\fcontent-base\u0000\u0000\u0000\u0010content-encoding\u0000\u0000\u0000\u0010content-language\u0000\u0000\u0000\u000econtent-length\u0000\u0000\u0000\u0010content-location\u0000\u0000\u0000\u000bcontent-md5\u0000\u0000\u0000\rcontent-range\u0000\u0000\u0000\fcontent-type\u0000\u0000\u0000\u0004date\u0000\u0000\u0000\u0004etag\u0000\u0000\u0000\u0006expect\u0000\u0000\u0000\u0007expires\u0000\u0000\u0000\u0004from\u0000\u0000\u0000\u0004host\u0000\u0000\u0000\bif-match\u0000\u0000\u0000\u0011if-modified-since\u0000\u0000\u0000\rif-none-match\u0000\u0000\u0000\bif-range\u0000\u0000\u0000\u0013if-unmodified-since\u0000\u0000\u0000\rlast-modified\u0000\u0000\u0000\blocation\u0000\u0000\u0000\fmax-forwards\u0000\u0000\u0000\u0006pragma\u0000\u0000\u0000\u0012proxy-authenticate\u0000\u0000\u0000\u0013proxy-authorization\u0000\u0000\u0000\u0005range\u0000\u0000\u0000\u0007referer\u0000\u0000\u0000\u000bretry-after\u0000\u0000\u0000\u0006server\u0000\u0000\u0000\u0002te\u0000\u0000\u0000\u0007trailer\u0000\u0000\u0000\u0011transfer-encoding\u0000\u0000\u0000\u0007upgrade\u0000\u0000\u0000\nuser-agent\u0000\u0000\u0000\u0004vary\u0000\u0000\u0000\u0003via\u0000\u0000\u0000\u0007warning\u0000\u0000\u0000\u0010www-authenticate\u0000\u0000\u0000\u0006method\u0000\u0000\u0000\u0003get\u0000\u0000\u0000\u0006status\u0000\u0000\u0000\u0006200 OK\u0000\u0000\u0000\u0007version\u0000\u0000\u0000\bHTTP/1.1\u0000\u0000\u0000\u0003url\u0000\u0000\u0000\u0006public\u0000\u0000\u0000\nset-cookie\u0000\u0000\u0000\nkeep-alive\u0000\u0000\u0000\u0006origin100101201202205206300302303304305306307402405406407408409410411412413414415416417502504505203 Non-Authoritative Information204 No Content301 Moved Permanently400 Bad Request401 Unauthorized403 Forbidden404 Not Found500 Internal Server Error501 Not Implemented503 Service UnavailableJan Feb Mar Apr May Jun Jul Aug Sept Oct Nov Dec 00:00:00 Mon, Tue, Wed, Thu, Fri, Sat, Sun, GMTchunked,text/html,image/png,image/jpg,image/gif,application/xml,application/xhtml+xml,text/plain,text/javascript,publicprivatemax-age=gzip,deflate,sdchcharset=utf-8charset=iso-8859-1,utf-,*,enq=0.".getBytes(Util.UTF_8.name());
        } catch (UnsupportedEncodingException e) {
            throw new AssertionError();
        }
    }

    public FrameReader newReader(e eVar, boolean z) {
        return new Reader(eVar, z);
    }

    public FrameWriter newWriter(d dVar, boolean z) {
        return new Writer(dVar, z);
    }
}
