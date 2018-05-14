package org.apache.http.entity.mime;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.util.List;

/* compiled from: TbsSdkJava */
class HttpBrowserCompatibleMultipart extends AbstractMultipartForm {
    private final List<FormBodyPart> parts;

    public HttpBrowserCompatibleMultipart(String str, Charset charset, String str2, List<FormBodyPart> list) {
        super(str, charset, str2);
        this.parts = list;
    }

    public List<FormBodyPart> getBodyParts() {
        return this.parts;
    }

    protected void formatMultipartHeader(FormBodyPart formBodyPart, OutputStream outputStream) throws IOException {
        Header header = formBodyPart.getHeader();
        AbstractMultipartForm.writeField(header.getField(MIME.CONTENT_DISPOSITION), this.charset, outputStream);
        if (formBodyPart.getBody().getFilename() != null) {
            AbstractMultipartForm.writeField(header.getField("Content-Type"), this.charset, outputStream);
        }
    }
}
