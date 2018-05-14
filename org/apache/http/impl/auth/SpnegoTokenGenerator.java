package org.apache.http.impl.auth;

import java.io.IOException;

@Deprecated
/* compiled from: TbsSdkJava */
public interface SpnegoTokenGenerator {
    byte[] generateSpnegoDERObject(byte[] bArr) throws IOException;
}
