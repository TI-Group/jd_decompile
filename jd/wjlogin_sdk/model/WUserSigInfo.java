package jd.wjlogin_sdk.model;

import java.io.Serializable;
import java.util.Date;

/* compiled from: TbsSdkJava */
public class WUserSigInfo implements Serializable {
    private static final long serialVersionUID = -2271219572399684330L;
    private String A2 = null;
    private Date A2CreateDate = null;
    private int A2RefreshTime = 0;
    private int A2TimeOut = 0;
    private String Account = null;
    private String Pin = null;
    private String Pwd = null;

    public String getAccount() {
        return this.Account;
    }

    public void setAccount(String str) {
        this.Account = str;
    }

    public String getPwd() {
        return this.Pwd;
    }

    public void setPwd(String str) {
        this.Pwd = str;
    }

    public String getA2() {
        return this.A2;
    }

    public void setA2(String str) {
        this.A2 = str;
    }

    public String getPin() {
        return this.Pin;
    }

    public void setPin(String str) {
        this.Pin = str;
    }

    public int getA2TimeOut() {
        return this.A2TimeOut;
    }

    public void setA2TimeOut(int i) {
        this.A2TimeOut = i;
    }

    public int getA2RefreshTime() {
        return this.A2RefreshTime;
    }

    public void setA2RefreshTime(int i) {
        this.A2RefreshTime = i;
    }

    public Date getA2CreateDate() {
        return this.A2CreateDate;
    }

    public void setA2CreateDate(Date date) {
        this.A2CreateDate = date;
    }
}
