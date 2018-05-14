package jd.wjlogin_sdk.model;

/* compiled from: TbsSdkJava */
public class FailResult {
    private String Message;
    private int dwLimitTime;
    private byte replyCode;
    private String softFingerprint;

    public byte getReplyCode() {
        return this.replyCode;
    }

    public void setReplyCode(byte b) {
        this.replyCode = b;
    }

    public String getMessage() {
        return this.Message;
    }

    public void setMessage(String str) {
        this.Message = str;
    }

    public int getDwLimitTime() {
        return this.dwLimitTime;
    }

    public void setDwLimitTime(int i) {
        this.dwLimitTime = i;
    }

    public String getSoftFingerprint() {
        return this.softFingerprint;
    }

    public void setSoftFingerprint(String str) {
        this.softFingerprint = str;
    }
}
