package jd.wjlogin_sdk.tlvtype;

/* compiled from: TbsSdkJava */
public class tlv_0x12 {
    private String authCode;
    private String stEncryptKey;
    private short wAuthCodeLen;
    private short wEnLen;

    public short getwEnLen() {
        return this.wEnLen;
    }

    public void setwEnLen(short s) {
        this.wEnLen = s;
    }

    public String getStEncryptKey() {
        return this.stEncryptKey;
    }

    public void setStEncryptKey(String str) {
        this.stEncryptKey = str;
    }

    public short getwAuthCodeLen() {
        return this.wAuthCodeLen;
    }

    public void setwAuthCodeLen(short s) {
        this.wAuthCodeLen = s;
    }

    public String getAuthCode() {
        return this.authCode;
    }

    public void setAuthCode(String str) {
        this.authCode = str;
    }
}
