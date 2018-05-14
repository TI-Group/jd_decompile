package org.apache.http.client.entity;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.zip.GZIPInputStream;
import org.apache.http.Header;
import org.apache.http.HttpEntity;

/* compiled from: TbsSdkJava */
public class GzipDecompressingEntity extends DecompressingEntity {
    public /* bridge */ /* synthetic */ InputStream getContent() throws IOException {
        return super.getContent();
    }

    public /* bridge */ /* synthetic */ void writeTo(OutputStream outputStream) throws IOException {
        super.writeTo(outputStream);
    }

    public GzipDecompressingEntity(HttpEntity httpEntity) {
        super(httpEntity);
    }

    InputStream decorate(InputStream inputStream) throws IOException {
        return new GZIPInputStream(inputStream);
    }

    public Header getContentEncoding() {
        return null;
    }

    public long getContentLength() {
        return -1;
    }
}
