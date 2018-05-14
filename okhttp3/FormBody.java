package okhttp3;

import b.c;
import b.d;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import okhttp3.internal.Util;
import org.apache.http.client.utils.URLEncodedUtils;

/* compiled from: TbsSdkJava */
public final class FormBody extends RequestBody {
    private static final MediaType CONTENT_TYPE = MediaType.parse(URLEncodedUtils.CONTENT_TYPE);
    private final List<String> encodedNames;
    private final List<String> encodedValues;

    /* compiled from: TbsSdkJava */
    public static final class Builder {
        private final List<String> names = new ArrayList();
        private final List<String> values = new ArrayList();

        public Builder add(String str, String str2) {
            this.names.add(HttpUrl.canonicalize(str, " \"':;<=>@[]^`{}|/\\?#&!$(),~", false, false, true, true));
            this.values.add(HttpUrl.canonicalize(str2, " \"':;<=>@[]^`{}|/\\?#&!$(),~", false, false, true, true));
            return this;
        }

        public Builder addEncoded(String str, String str2) {
            this.names.add(HttpUrl.canonicalize(str, " \"':;<=>@[]^`{}|/\\?#&!$(),~", true, false, true, true));
            this.values.add(HttpUrl.canonicalize(str2, " \"':;<=>@[]^`{}|/\\?#&!$(),~", true, false, true, true));
            return this;
        }

        public FormBody build() {
            return new FormBody(this.names, this.values);
        }
    }

    private FormBody(List<String> list, List<String> list2) {
        this.encodedNames = Util.immutableList((List) list);
        this.encodedValues = Util.immutableList((List) list2);
    }

    public int size() {
        return this.encodedNames.size();
    }

    public String encodedName(int i) {
        return (String) this.encodedNames.get(i);
    }

    public String name(int i) {
        return HttpUrl.percentDecode(encodedName(i), true);
    }

    public String encodedValue(int i) {
        return (String) this.encodedValues.get(i);
    }

    public String value(int i) {
        return HttpUrl.percentDecode(encodedValue(i), true);
    }

    public MediaType contentType() {
        return CONTENT_TYPE;
    }

    public long contentLength() {
        return writeOrCountBytes(null, true);
    }

    public void writeTo(d dVar) throws IOException {
        writeOrCountBytes(dVar, false);
    }

    private long writeOrCountBytes(d dVar, boolean z) {
        c cVar;
        long j = 0;
        if (z) {
            cVar = new c();
        } else {
            cVar = dVar.b();
        }
        int size = this.encodedNames.size();
        for (int i = 0; i < size; i++) {
            if (i > 0) {
                cVar.b(38);
            }
            cVar.a((String) this.encodedNames.get(i));
            cVar.b(61);
            cVar.a((String) this.encodedValues.get(i));
        }
        if (z) {
            j = cVar.a();
            cVar.u();
        }
        return j;
    }
}
