package jd.wjlogin_sdk.tlvtype;

import java.io.Serializable;

/* compiled from: TbsSdkJava */
public class tlv_0x4 implements Serializable {
    private static final long serialVersionUID = -3817472191086070791L;
    private int cOSVer;
    private short cTerminalType;
    private String strHexGuid;
    private String strHexVer;
    private short wGuidVer;
    private short wNextFieldLen;

    public String getStrHexVer() {
        return this.strHexVer;
    }

    public void setStrHexVer(String str) {
        this.strHexVer = str;
    }

    public String getstrHexGuid() {
        return this.strHexGuid;
    }

    public void setstrHexGuid(String str) {
        this.strHexGuid = str;
    }

    public short getwGuidVer() {
        return this.wGuidVer;
    }

    public void setwGuidVer(short s) {
        this.wGuidVer = s;
    }

    public short getcTerminalType() {
        return this.cTerminalType;
    }

    public void setcTerminalType(short s) {
        this.cTerminalType = s;
    }

    public int getcOSVer() {
        return this.cOSVer;
    }

    public void setcOSVer(int i) {
        this.cOSVer = i;
    }

    public short getwNextFieldLen() {
        return this.wNextFieldLen;
    }

    public void setwNextFieldLen(short s) {
        this.wNextFieldLen = s;
    }

    public String toString() {
        return this.strHexVer + this.strHexGuid;
    }
}
