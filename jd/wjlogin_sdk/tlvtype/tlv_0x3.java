package jd.wjlogin_sdk.tlvtype;

/* compiled from: TbsSdkJava */
public class tlv_0x3 {
    private String stError;
    private String stUError;
    private short wErrorCode;
    private short wErrorLen;
    private short wErrorVer;
    private short wUErrorLen;

    public short getwErrorVer() {
        return this.wErrorVer;
    }

    public void setwErrorVer(short s) {
        this.wErrorVer = s;
    }

    public short getwErrorCode() {
        return this.wErrorCode;
    }

    public void setwErrorCode(short s) {
        this.wErrorCode = s;
    }

    public short getwErrorLen() {
        return this.wErrorLen;
    }

    public void setwErrorLen(short s) {
        this.wErrorLen = s;
    }

    public String getStError() {
        return this.stError;
    }

    public void setStError(String str) {
        this.stError = str;
    }

    public short getwUErrorLen() {
        return this.wUErrorLen;
    }

    public void setwUErrorLen(short s) {
        this.wUErrorLen = s;
    }

    public String getStUError() {
        return this.stUError;
    }

    public void setStUError(String str) {
        this.stUError = str;
    }
}
