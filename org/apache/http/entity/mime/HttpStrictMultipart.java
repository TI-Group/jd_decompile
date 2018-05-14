package org.apache.http.entity.mime;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.List;

/* compiled from: TbsSdkJava */
class HttpStrictMultipart extends AbstractMultipartForm {
    private final List<FormBodyPart> parts;

    public HttpStrictMultipart(String str, Charset charset, String str2, List<FormBodyPart> list) {
        super(str, charset, str2);
        this.parts = list;
    }

    public List<FormBodyPart> getBodyParts() {
        return this.parts;
    }

    protected void formatMultipartHeader(FormBodyPart formBodyPart, OutputStream outputStream) throws IOException {
        Iterator it = formBodyPart.getHeader().iterator();
        while (it.hasNext()) {
            AbstractMultipartForm.writeField((MinimalField) it.next(), outputStream);
        }
    }
}
