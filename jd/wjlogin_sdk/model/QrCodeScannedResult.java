package jd.wjlogin_sdk.model;

/* compiled from: TbsSdkJava */
public class QrCodeScannedResult {
    private String qrCodeScannedTips;
    private byte type;

    public String getTips() {
        return this.qrCodeScannedTips;
    }

    public void setTips(String str) {
        this.qrCodeScannedTips = str;
    }

    public byte getType() {
        return this.type;
    }

    public void setType(byte b) {
        this.type = b;
    }
}
