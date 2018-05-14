package okhttp3;

import b.c;
import b.d;
import b.f;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import jd.wjlogin_sdk.util.ReplyCode;
import okhttp3.internal.Util;
import org.apache.http.entity.mime.MIME;

/* compiled from: TbsSdkJava */
public final class MultipartBody extends RequestBody {
    public static final MediaType ALTERNATIVE = MediaType.parse("multipart/alternative");
    private static final byte[] COLONSPACE = new byte[]{(byte) 58, ReplyCode.reply0x20};
    private static final byte[] CRLF = new byte[]{ReplyCode.reply0xd, (byte) 10};
    private static final byte[] DASHDASH = new byte[]{(byte) 45, (byte) 45};
    public static final MediaType DIGEST = MediaType.parse("multipart/digest");
    public static final MediaType FORM = MediaType.parse("multipart/form-data");
    public static final MediaType MIXED = MediaType.parse("multipart/mixed");
    public static final MediaType PARALLEL = MediaType.parse("multipart/parallel");
    private final f boundary;
    private long contentLength = -1;
    private final MediaType contentType;
    private final MediaType originalType;
    private final List<Part> parts;

    /* compiled from: TbsSdkJava */
    public static final class Builder {
        private final f boundary;
        private final List<Part> parts;
        private MediaType type;

        public Builder() {
            this(UUID.randomUUID().toString());
        }

        public Builder(String str) {
            this.type = MultipartBody.MIXED;
            this.parts = new ArrayList();
            this.boundary = f.encodeUtf8(str);
        }

        public Builder setType(MediaType mediaType) {
            if (mediaType == null) {
                throw new NullPointerException("type == null");
            } else if (mediaType.type().equals("multipart")) {
                this.type = mediaType;
                return this;
            } else {
                throw new IllegalArgumentException("multipart != " + mediaType);
            }
        }

        public Builder addPart(RequestBody requestBody) {
            return addPart(Part.create(requestBody));
        }

        public Builder addPart(Headers headers, RequestBody requestBody) {
            return addPart(Part.create(headers, requestBody));
        }

        public Builder addFormDataPart(String str, String str2) {
            return addPart(Part.createFormData(str, str2));
        }

        public Builder addFormDataPart(String str, String str2, RequestBody requestBody) {
            return addPart(Part.createFormData(str, str2, requestBody));
        }

        public Builder addPart(Part part) {
            if (part == null) {
                throw new NullPointerException("part == null");
            }
            this.parts.add(part);
            return this;
        }

        public MultipartBody build() {
            if (!this.parts.isEmpty()) {
                return new MultipartBody(this.boundary, this.type, this.parts);
            }
            throw new IllegalStateException("Multipart body must have at least one part.");
        }
    }

    /* compiled from: TbsSdkJava */
    public static final class Part {
        private final RequestBody body;
        private final Headers headers;

        public static Part create(RequestBody requestBody) {
            return create(null, requestBody);
        }

        public static Part create(Headers headers, RequestBody requestBody) {
            if (requestBody == null) {
                throw new NullPointerException("body == null");
            } else if (headers != null && headers.get("Content-Type") != null) {
                throw new IllegalArgumentException("Unexpected header: Content-Type");
            } else if (headers == null || headers.get("Content-Length") == null) {
                return new Part(headers, requestBody);
            } else {
                throw new IllegalArgumentException("Unexpected header: Content-Length");
            }
        }

        public static Part createFormData(String str, String str2) {
            return createFormData(str, null, RequestBody.create(null, str2));
        }

        public static Part createFormData(String str, String str2, RequestBody requestBody) {
            if (str == null) {
                throw new NullPointerException("name == null");
            }
            StringBuilder stringBuilder = new StringBuilder("form-data; name=");
            MultipartBody.appendQuotedString(stringBuilder, str);
            if (str2 != null) {
                stringBuilder.append("; filename=");
                MultipartBody.appendQuotedString(stringBuilder, str2);
            }
            return create(Headers.of(MIME.CONTENT_DISPOSITION, stringBuilder.toString()), requestBody);
        }

        private Part(Headers headers, RequestBody requestBody) {
            this.headers = headers;
            this.body = requestBody;
        }
    }

    MultipartBody(f fVar, MediaType mediaType, List<Part> list) {
        this.boundary = fVar;
        this.originalType = mediaType;
        this.contentType = MediaType.parse(mediaType + "; boundary=" + fVar.utf8());
        this.parts = Util.immutableList((List) list);
    }

    public MediaType type() {
        return this.originalType;
    }

    public String boundary() {
        return this.boundary.utf8();
    }

    public int size() {
        return this.parts.size();
    }

    public List<Part> parts() {
        return this.parts;
    }

    public Part part(int i) {
        return (Part) this.parts.get(i);
    }

    public MediaType contentType() {
        return this.contentType;
    }

    public long contentLength() throws IOException {
        long j = this.contentLength;
        if (j != -1) {
            return j;
        }
        j = writeOrCountBytes(null, true);
        this.contentLength = j;
        return j;
    }

    public void writeTo(d dVar) throws IOException {
        writeOrCountBytes(dVar, false);
    }

    private long writeOrCountBytes(d dVar, boolean z) throws IOException {
        c cVar;
        long j = 0;
        if (z) {
            c cVar2 = new c();
            cVar = cVar2;
            dVar = cVar2;
        } else {
            cVar = null;
        }
        int size = this.parts.size();
        for (int i = 0; i < size; i++) {
            Part part = (Part) this.parts.get(i);
            Headers access$000 = part.headers;
            RequestBody access$100 = part.body;
            dVar.c(DASHDASH);
            dVar.b(this.boundary);
            dVar.c(CRLF);
            if (access$000 != null) {
                int size2 = access$000.size();
                for (int i2 = 0; i2 < size2; i2++) {
                    dVar.b(access$000.name(i2)).c(COLONSPACE).b(access$000.value(i2)).c(CRLF);
                }
            }
            MediaType contentType = access$100.contentType();
            if (contentType != null) {
                dVar.b("Content-Type: ").b(contentType.toString()).c(CRLF);
            }
            long contentLength = access$100.contentLength();
            if (contentLength != -1) {
                dVar.b("Content-Length: ").l(contentLength).c(CRLF);
            } else if (z) {
                cVar.u();
                return -1;
            }
            dVar.c(CRLF);
            if (z) {
                j += contentLength;
            } else {
                access$100.writeTo(dVar);
            }
            dVar.c(CRLF);
        }
        dVar.c(DASHDASH);
        dVar.b(this.boundary);
        dVar.c(DASHDASH);
        dVar.c(CRLF);
        if (!z) {
            return j;
        }
        j += cVar.a();
        cVar.u();
        return j;
    }

    static StringBuilder appendQuotedString(StringBuilder stringBuilder, String str) {
        stringBuilder.append('\"');
        int length = str.length();
        for (int i = 0; i < length; i++) {
            char charAt = str.charAt(i);
            switch (charAt) {
                case '\n':
                    stringBuilder.append("%0A");
                    break;
                case '\r':
                    stringBuilder.append("%0D");
                    break;
                case '\"':
                    stringBuilder.append("%22");
                    break;
                default:
                    stringBuilder.append(charAt);
                    break;
            }
        }
        stringBuilder.append('\"');
        return stringBuilder;
    }
}
