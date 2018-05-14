package okhttp3;

import b.c;
import b.e;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.Charset;
import okhttp3.internal.Util;

/* compiled from: TbsSdkJava */
public abstract class ResponseBody implements Closeable {
    private Reader reader;

    public abstract long contentLength();

    public abstract MediaType contentType();

    public abstract e source();

    public final InputStream byteStream() {
        return source().f();
    }

    public final byte[] bytes() throws IOException {
        long contentLength = contentLength();
        if (contentLength > 2147483647L) {
            throw new IOException("Cannot buffer entire body for content length: " + contentLength);
        }
        Closeable source = source();
        try {
            byte[] t = source.t();
            if (contentLength == -1 || contentLength == ((long) t.length)) {
                return t;
            }
            throw new IOException("Content-Length and stream length disagree");
        } finally {
            Util.closeQuietly(source);
        }
    }

    public final Reader charStream() {
        Reader reader = this.reader;
        if (reader != null) {
            return reader;
        }
        reader = new InputStreamReader(byteStream(), charset());
        this.reader = reader;
        return reader;
    }

    public final String string() throws IOException {
        return new String(bytes(), charset().name());
    }

    private Charset charset() {
        MediaType contentType = contentType();
        return contentType != null ? contentType.charset(Util.UTF_8) : Util.UTF_8;
    }

    public void close() {
        Util.closeQuietly(source());
    }

    public static ResponseBody create(MediaType mediaType, String str) {
        Charset charset = Util.UTF_8;
        if (mediaType != null) {
            charset = mediaType.charset();
            if (charset == null) {
                charset = Util.UTF_8;
                mediaType = MediaType.parse(mediaType + "; charset=utf-8");
            }
        }
        e a = new c().a(str, charset);
        return create(mediaType, a.a(), a);
    }

    public static ResponseBody create(MediaType mediaType, byte[] bArr) {
        return create(mediaType, (long) bArr.length, new c().b(bArr));
    }

    public static ResponseBody create(final MediaType mediaType, final long j, final e eVar) {
        if (eVar != null) {
            return new ResponseBody() {
                public MediaType contentType() {
                    return mediaType;
                }

                public long contentLength() {
                    return j;
                }

                public e source() {
                    return eVar;
                }
            };
        }
        throw new NullPointerException("source == null");
    }
}
