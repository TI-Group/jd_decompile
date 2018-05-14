package org.apache.http.entity.mime;

import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.content.AbstractContentBody;
import org.apache.http.entity.mime.content.ContentBody;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.Args;

/* compiled from: TbsSdkJava */
public class FormBodyPart {
    private final ContentBody body;
    private final Header header = new Header();
    private final String name;

    public FormBodyPart(String str, ContentBody contentBody) {
        Args.notNull(str, "Name");
        Args.notNull(contentBody, "Body");
        this.name = str;
        this.body = contentBody;
        generateContentDisp(contentBody);
        generateContentType(contentBody);
        generateTransferEncoding(contentBody);
    }

    public String getName() {
        return this.name;
    }

    public ContentBody getBody() {
        return this.body;
    }

    public Header getHeader() {
        return this.header;
    }

    public void addField(String str, String str2) {
        Args.notNull(str, "Field name");
        this.header.addField(new MinimalField(str, str2));
    }

    protected void generateContentDisp(ContentBody contentBody) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("form-data; name=\"");
        stringBuilder.append(getName());
        stringBuilder.append("\"");
        if (contentBody.getFilename() != null) {
            stringBuilder.append("; filename=\"");
            stringBuilder.append(contentBody.getFilename());
            stringBuilder.append("\"");
        }
        addField(MIME.CONTENT_DISPOSITION, stringBuilder.toString());
    }

    protected void generateContentType(ContentBody contentBody) {
        ContentType contentType;
        if (contentBody instanceof AbstractContentBody) {
            contentType = ((AbstractContentBody) contentBody).getContentType();
        } else {
            contentType = null;
        }
        if (contentType != null) {
            addField("Content-Type", contentType.toString());
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(contentBody.getMimeType());
        if (contentBody.getCharset() != null) {
            stringBuilder.append(HTTP.CHARSET_PARAM);
            stringBuilder.append(contentBody.getCharset());
        }
        addField("Content-Type", stringBuilder.toString());
    }

    protected void generateTransferEncoding(ContentBody contentBody) {
        addField(MIME.CONTENT_TRANSFER_ENC, contentBody.getTransferEncoding());
    }
}
