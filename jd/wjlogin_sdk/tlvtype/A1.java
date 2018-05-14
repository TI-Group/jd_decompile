package jd.wjlogin_sdk.tlvtype;

/* compiled from: TbsSdkJava */
public class A1 {
    private byte[] GTKey_TGTGT;
    private byte[] MD5Pwd;
    private byte cSavePwd;
    private long ddwUin64;
    private int dwAppClientVer;
    private int dwAppID;
    private int dwClientIP;
    private int dwInittime;
    private int dwRandom;
    private int dwSequence;
    private short wTGTGTVer;

    public int getwTGTGTVer() {
        return this.wTGTGTVer;
    }

    public int getDwRandom() {
        return this.dwRandom;
    }

    public void setDwRandom(int i) {
        this.dwRandom = i;
    }

    public int getDwSequence() {
        return this.dwSequence;
    }

    public void setDwSequence(int i) {
        this.dwSequence = i;
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

    public void setDdwUin64(int i) {
        this.ddwUin64 = (long) i;
    }

    public int getDwInittime() {
        return this.dwInittime;
    }

    public void setDwInittime(int i) {
        this.dwInittime = i;
    }

    public int getDwClientIP() {
        return this.dwClientIP;
    }

    public void setDwClientIP(int i) {
        this.dwClientIP = i;
    }

    public int getcSavePwd() {
        return this.cSavePwd;
    }

    public byte[] getMD5Pwd() {
        return this.MD5Pwd;
    }

    public void setMD5Pwd(byte[] bArr) {
        this.MD5Pwd = bArr;
    }

    public byte[] getGTKey_TGTGT() {
        return this.GTKey_TGTGT;
    }

    public void setGTKey_TGTGT(byte[] bArr) {
        this.GTKey_TGTGT = bArr;
    }

    public long getDdwUin64() {
        return this.ddwUin64;
    }

    public void setDdwUin64(long j) {
        this.ddwUin64 = j;
    }

    public void setwTGTGTVer(short s) {
        this.wTGTGTVer = s;
    }

    public void setcSavePwd(byte b) {
        this.cSavePwd = b;
    }
}
