package org.apache.http.entity.mime.content;

import java.nio.charset.Charset;
import org.apache.http.entity.ContentType;
import org.apache.http.util.Args;

/* compiled from: TbsSdkJava */
public abstract class AbstractContentBody implements ContentBody {
    private final ContentType contentType;

    public AbstractContentBody(ContentType contentType) {
        Args.notNull(contentType, "Content type");
        this.contentType = contentType;
    }

    @Deprecated
    public AbstractContentBody(String str) {
        this(ContentType.parse(str));
    }

    public ContentType getContentType() {
        return this.contentType;
    }

    public String getMimeType() {
        return this.contentType.getMimeType();
    }

    public String getMediaType() {
        String mimeType = this.contentType.getMimeType();
        int indexOf = mimeType.indexOf(47);
        if (indexOf != -1) {
            return mimeType.substring(0, indexOf);
        }
        return mimeType;
    }

    public String getSubType() {
        String mimeType = this.contentType.getMimeType();
        int indexOf = mimeType.indexOf(47);
        if (indexOf != -1) {
            return mimeType.substring(indexOf + 1);
        }
        return null;
    }

    public String getCharset() {
        Charset charset = this.contentType.getCharset();
        return charset != null ? charset.name() : null;
    }
}
