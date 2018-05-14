package jd.wjlogin_sdk.tlvtype;

/* compiled from: TbsSdkJava */
public class tlv_0x20 {
    private String accessToken;
    private short accessTokenLen;
    private String openid;
    private short openidLen;

    public short getAccessTokenLen() {
        return this.accessTokenLen;
    }

    public void setAccessTokenLen(short s) {
        this.accessTokenLen = s;
    }

    public String getAccessToken() {
        return this.accessToken;
    }

    public void setAccessToken(String str) {
        this.accessToken = str;
    }

    public short getOpenidLen() {
        return this.openidLen;
    }

    public void setOpenidLen(short s) {
        this.openidLen = s;
    }

    public String getOpenid() {
        return this.openid;
    }

    public void setOpenid(String str) {
        this.openid = str;
    }
}
