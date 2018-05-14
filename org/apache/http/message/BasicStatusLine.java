package org.apache.http.message;

import java.io.Serializable;
import org.apache.http.ProtocolVersion;
import org.apache.http.StatusLine;
import org.apache.http.annotation.Immutable;
import org.apache.http.util.Args;

@Immutable
/* compiled from: TbsSdkJava */
public class BasicStatusLine implements Serializable, Cloneable, StatusLine {
    private static final long serialVersionUID = -2443303766890459269L;
    private final ProtocolVersion protoVersion;
    private final String reasonPhrase;
    private final int statusCode;

    public BasicStatusLine(ProtocolVersion protocolVersion, int i, String str) {
        this.protoVersion = (ProtocolVersion) Args.notNull(protocolVersion, "Version");
        this.statusCode = Args.notNegative(i, "Status code");
        this.reasonPhrase = str;
    }

    public int getStatusCode() {
        return this.statusCode;
    }

    public ProtocolVersion getProtocolVersion() {
        return this.protoVersion;
    }

    public String getReasonPhrase() {
        return this.reasonPhrase;
    }

    public String toString() {
        return BasicLineFormatter.INSTANCE.formatStatusLine(null, (StatusLine) this).toString();
    }

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
