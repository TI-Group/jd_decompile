package org.apache.http.entity;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.nio.charset.UnsupportedCharsetException;
import org.apache.http.annotation.NotThreadSafe;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.Args;

@NotThreadSafe
/* compiled from: TbsSdkJava */
public class StringEntity extends AbstractHttpEntity implements Cloneable {
    protected final byte[] content;

    public StringEntity(String str, ContentType contentType) throws UnsupportedCharsetException {
        Args.notNull(str, "Source string");
        Charset charset = contentType != null ? contentType.getCharset() : null;
        if (charset == null) {
            charset = HTTP.DEF_CONTENT_CHARSET;
        }
        try {
            this.content = str.getBytes(charset.name());
            if (contentType != null) {
                setContentType(contentType.toString());
            }
        } catch (UnsupportedEncodingException e) {
            throw new UnsupportedCharsetException(charset.name());
        }
    }

    @Deprecated
    public StringEntity(String str, String str2, String str3) throws UnsupportedEncodingException {
        Args.notNull(str, "Source string");
        if (str2 == null) {
            str2 = HTTP.PLAIN_TEXT_TYPE;
        }
        if (str3 == null) {
            str3 = "ISO-8859-1";
        }
        this.content = str.getBytes(str3);
        setContentType(str2 + HTTP.CHARSET_PARAM + str3);
    }

    public StringEntity(String str, String str2) throws UnsupportedCharsetException {
        this(str, ContentType.create(ContentType.TEXT_PLAIN.getMimeType(), str2));
    }

    public StringEntity(String str, Charset charset) {
        this(str, ContentType.create(ContentType.TEXT_PLAIN.getMimeType(), charset));
    }

    public StringEntity(String str) throws UnsupportedEncodingException {
        this(str, ContentType.DEFAULT_TEXT);
    }

    public boolean isRepeatable() {
        return true;
    }

    public long getContentLength() {
        return (long) this.content.length;
    }

    public InputStream getContent() throws IOException {
        return new ByteArrayInputStream(this.content);
    }

    public void writeTo(OutputStream outputStream) throws IOException {
        Args.notNull(outputStream, "Output stream");
        outputStream.write(this.content);
        outputStream.flush();
    }

    public boolean isStreaming() {
        return false;
    }

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
