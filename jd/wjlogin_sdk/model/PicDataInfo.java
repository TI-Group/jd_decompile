package jd.wjlogin_sdk.model;

/* compiled from: TbsSdkJava */
public class PicDataInfo {
    private String authCode;
    private byte[] sPicData;
    private String stEncryptKey;

    public String getAuthCode() {
        return this.authCode;
    }

    public void setAuthCode(String str) {
        this.authCode = str;
    }

    public String getStEncryptKey() {
        return this.stEncryptKey;
    }

    public void setStEncryptKey(String str) {
        this.stEncryptKey = str;
    }

    public byte[] getsPicData() {
        return this.sPicData;
    }

    public void setsPicData(byte[] bArr) {
        this.sPicData = bArr;
    }
}
