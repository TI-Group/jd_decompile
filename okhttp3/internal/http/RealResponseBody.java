package okhttp3.internal.http;

import b.e;
import okhttp3.Headers;
import okhttp3.MediaType;
import okhttp3.ResponseBody;

/* compiled from: TbsSdkJava */
public final class RealResponseBody extends ResponseBody {
    private final Headers headers;
    private final e source;

    public RealResponseBody(Headers headers, e eVar) {
        this.headers = headers;
        this.source = eVar;
    }

    public MediaType contentType() {
        String str = this.headers.get("Content-Type");
        return str != null ? MediaType.parse(str) : null;
    }

    public long contentLength() {
        return OkHeaders.contentLength(this.headers);
    }

    public e source() {
        return this.source;
    }
}
