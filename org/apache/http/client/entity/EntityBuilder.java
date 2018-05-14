package org.apache.http.client.entity;

import java.io.File;
import java.io.InputStream;
import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.annotation.NotThreadSafe;
import org.apache.http.entity.BasicHttpEntity;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.FileEntity;
import org.apache.http.entity.InputStreamEntity;
import org.apache.http.entity.SerializableEntity;
import org.apache.http.entity.StringEntity;

@NotThreadSafe
/* compiled from: TbsSdkJava */
public class EntityBuilder {
    private byte[] binary;
    private boolean chunked;
    private String contentEncoding;
    private ContentType contentType;
    private File file;
    private boolean gzipCompress;
    private List<NameValuePair> parameters;
    private Serializable serializable;
    private InputStream stream;
    private String text;

    EntityBuilder() {
    }

    public static EntityBuilder create() {
        return new EntityBuilder();
    }

    private void clearContent() {
        this.text = null;
        this.binary = null;
        this.stream = null;
        this.parameters = null;
        this.serializable = null;
        this.file = null;
    }

    public String getText() {
        return this.text;
    }

    public EntityBuilder setText(String str) {
        clearContent();
        this.text = str;
        return this;
    }

    public byte[] getBinary() {
        return this.binary;
    }

    public EntityBuilder setBinary(byte[] bArr) {
        clearContent();
        this.binary = bArr;
        return this;
    }

    public InputStream getStream() {
        return this.stream;
    }

    public EntityBuilder setStream(InputStream inputStream) {
        clearContent();
        this.stream = inputStream;
        return this;
    }

    public List<NameValuePair> getParameters() {
        return this.parameters;
    }

    public EntityBuilder setParameters(List<NameValuePair> list) {
        clearContent();
        this.parameters = list;
        return this;
    }

    public EntityBuilder setParameters(NameValuePair... nameValuePairArr) {
        return setParameters(Arrays.asList(nameValuePairArr));
    }

    public Serializable getSerializable() {
        return this.serializable;
    }

    public EntityBuilder setSerializable(Serializable serializable) {
        clearContent();
        this.serializable = serializable;
        return this;
    }

    public File getFile() {
        return this.file;
    }

    public EntityBuilder setFile(File file) {
        clearContent();
        this.file = file;
        return this;
    }

    public ContentType getContentType() {
        return this.contentType;
    }

    public EntityBuilder setContentType(ContentType contentType) {
        this.contentType = contentType;
        return this;
    }

    public String getContentEncoding() {
        return this.contentEncoding;
    }

    public EntityBuilder setContentEncoding(String str) {
        this.contentEncoding = str;
        return this;
    }

    public boolean isChunked() {
        return this.chunked;
    }

    public EntityBuilder chunked() {
        this.chunked = true;
        return this;
    }

    public boolean isGzipCompress() {
        return this.gzipCompress;
    }

    public EntityBuilder gzipCompress() {
        this.gzipCompress = true;
        return this;
    }

    private ContentType getContentOrDefault(ContentType contentType) {
        return this.contentType != null ? this.contentType : contentType;
    }

    public HttpEntity build() {
        HttpEntity stringEntity;
        if (this.text != null) {
            stringEntity = new StringEntity(this.text, getContentOrDefault(ContentType.DEFAULT_TEXT));
        } else if (this.binary != null) {
            stringEntity = new ByteArrayEntity(this.binary, getContentOrDefault(ContentType.DEFAULT_BINARY));
        } else if (this.stream != null) {
            stringEntity = new InputStreamEntity(this.stream, 1, getContentOrDefault(ContentType.DEFAULT_BINARY));
        } else if (this.parameters != null) {
            Object urlEncodedFormEntity = new UrlEncodedFormEntity(this.parameters, this.contentType != null ? this.contentType.getCharset() : null);
        } else if (this.serializable != null) {
            stringEntity = new SerializableEntity(this.serializable);
            stringEntity.setContentType(ContentType.DEFAULT_BINARY.toString());
        } else if (this.file != null) {
            stringEntity = new FileEntity(this.file, getContentOrDefault(ContentType.DEFAULT_BINARY));
        } else {
            stringEntity = new BasicHttpEntity();
        }
        if (!(stringEntity.getContentType() == null || this.contentType == null)) {
            stringEntity.setContentType(this.contentType.toString());
        }
        stringEntity.setContentEncoding(this.contentEncoding);
        stringEntity.setChunked(this.chunked);
        if (this.gzipCompress) {
            return new GzipCompressingEntity(stringEntity);
        }
        return stringEntity;
    }
}
