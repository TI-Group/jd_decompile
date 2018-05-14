package jd.wjlogin_sdk.tlvtype;

/* compiled from: TbsSdkJava */
public class tlv_0x1d {
    private String accessToken;
    private short accessTokenLen;
    private int expireTime;
    private String openid;
    private short openidLen;
    private String refreshToken;
    private short refreshTokenLen;
    private String scope;
    private short scopeLen;
    private byte type;

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

    public short getScopeLen() {
        return this.scopeLen;
    }

    public void setScopeLen(short s) {
        this.scopeLen = s;
    }

    public String getScope() {
        return this.scope;
    }

    public void setScope(String str) {
        this.scope = str;
    }

    public byte getType() {
        return this.type;
    }

    public void setType(byte b) {
        this.type = b;
    }

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

    public int getExpireTime() {
        return this.expireTime;
    }

    public void setExpireTime(int i) {
        this.expireTime = i;
    }

    public short getRefreshTokenLen() {
        return this.refreshTokenLen;
    }

    public void setRefreshTokenLen(short s) {
        this.refreshTokenLen = s;
    }

    public String getRefreshToken() {
        return this.refreshToken;
    }

    public void setRefreshToken(String str) {
        this.refreshToken = str;
    }
}
