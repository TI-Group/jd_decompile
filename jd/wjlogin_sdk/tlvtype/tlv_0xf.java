package jd.wjlogin_sdk.tlvtype;

/* compiled from: TbsSdkJava */
public class tlv_0xf {
    private byte[] sPicData;
    private String stEncryptKey;
    private short wEnLen;
    private short wPicDataLen;

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

    public short getwPicDataLen() {
        return this.wPicDataLen;
    }

    public void setwPicDataLen(short s) {
        this.wPicDataLen = s;
    }

    public byte[] getsPicData() {
        return this.sPicData;
    }

    public void setsPicData(byte[] bArr) {
        this.sPicData = bArr;
    }
}
