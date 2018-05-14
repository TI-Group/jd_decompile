package jd.wjlogin_sdk.tlvtype;

/* compiled from: TbsSdkJava */
public class A2 {
    private byte[] GTKey_TGT;
    private int ddwUin64;
    private int dwAppClientVer;
    private int dwAppID;
    private int dwClientIP;
    private int dwExpireTime;
    private int dwInittime;
    private int dwRandom;
    private int dwRefreshTime;
    private int wTGTVer;

    public int getwTGTVer() {
        return this.wTGTVer;
    }

    public void setwTGTVer(int i) {
        this.wTGTVer = i;
    }

    public int getDwRandom() {
        return this.dwRandom;
    }

    public void setDwRandom(int i) {
        this.dwRandom = i;
    }

    public int getDwAppID() {
        return this.dwAppID;
    }

    public void setDwAppID(int i) {
        this.dwAppID = i;
    }

    public int getDwAppClientVer() {
        return this.dwAppClientVer;
    }

    public void setDwAppClientVer(int i) {
        this.dwAppClientVer = i;
    }

    public int getDdwUin64() {
        return this.ddwUin64;
    }

    public void setDdwUin64(int i) {
        this.ddwUin64 = i;
    }

    public int getDwInittime() {
        return this.dwInittime;
    }

    public void setDwInittime(int i) {
        this.dwInittime = i;
    }

    public int getDwRefreshTime() {
        return this.dwRefreshTime;
    }

    public void setDwRefreshTime(int i) {
        this.dwRefreshTime = i;
    }

    public int getDwExpireTime() {
        return this.dwExpireTime;
    }

    public void setDwExpireTime(int i) {
        this.dwExpireTime = i;
    }

    public int getDwClientIP() {
        return this.dwClientIP;
    }

    public void setDwClientIP(int i) {
        this.dwClientIP = i;
    }

    public byte[] getGTKey_TGT() {
        return this.GTKey_TGT;
    }

    public void setGTKey_TGT(byte[] bArr) {
        this.GTKey_TGT = bArr;
    }
}
