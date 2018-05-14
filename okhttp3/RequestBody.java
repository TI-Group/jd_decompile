package okhttp3;

import b.d;
import b.f;
import b.m;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import okhttp3.internal.Util;

/* compiled from: TbsSdkJava */
public abstract class RequestBody {
    public abstract MediaType contentType();

    public abstract void writeTo(d dVar) throws IOException;

    public long contentLength() throws IOException {
        return -1;
    }

    public static RequestBody create(MediaType mediaType, String str) {
        Charset charset = Util.UTF_8;
        if (mediaType != null) {
            charset = mediaType.charset();
            if (charset == null) {
                charset = Util.UTF_8;
                mediaType = MediaType.parse(mediaType + "; charset=utf-8");
            }
        }
        return create(mediaType, str.getBytes(charset));
    }

    public static RequestBody create(final MediaType mediaType, final f fVar) {
        return new RequestBody() {
            public MediaType contentType() {
                return mediaType;
            }

            public long contentLength() throws IOException {
                return (long) fVar.size();
            }

            public void writeTo(d dVar) throws IOException {
                dVar.b(fVar);
            }
        };
    }

    public static RequestBody create(MediaType mediaType, byte[] bArr) {
        return create(mediaType, bArr, 0, bArr.length);
    }

    public static RequestBody create(final MediaType mediaType, final byte[] bArr, final int i, final int i2) {
        if (bArr == null) {
            throw new NullPointerException("content == null");
        }
        Util.checkOffsetAndCount((long) bArr.length, (long) i, (long) i2);
        return new RequestBody() {
            public MediaType contentType() {
                return mediaType;
            }

            public long contentLength() {
                return (long) i2;
            }

            public void writeTo(d dVar) throws IOException {
                dVar.c(bArr, i, i2);
            }
        };
    }

    public static RequestBody create(final MediaType mediaType, final File file) {
        if (file != null) {
            return new RequestBody() {
                public MediaType contentType() {
                    return mediaType;
                }

                public long contentLength() {
                    return file.length();
                }

                public void writeTo(d dVar) throws IOException {
                    Closeable closeable = null;
                    try {
                        closeable = m.a(file);
                        dVar.a(closeable);
                    } finally {
                        Util.closeQuietly(closeable);
                    }
                }
            };
        }
        throw new NullPointerException("content == null");
    }
}
