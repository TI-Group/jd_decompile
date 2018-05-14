package jd.wjlogin_sdk.tlvtype;

/* compiled from: TbsSdkJava */
public class tlv_0x2 {
    private String strAccount;
    private String strPwd;
    private short strPwdLen;
    private short wStrLen;

    public short getwStrLen() {
        return this.wStrLen;
    }

    public void setwStrLen(short s) {
        this.wStrLen = s;
    }

    public String getStrAccount() {
        return this.strAccount;
    }

    public void setStrAccount(String str) {
        this.strAccount = str;
    }

    public short getStrPwdLen() {
        return this.strPwdLen;
    }

    public void setStrPwdLen(short s) {
        this.strPwdLen = s;
    }

    public String getStrPwd() {
        return this.strPwd;
    }

    public void setStrPwd(String str) {
        this.strPwd = str;
    }
}
