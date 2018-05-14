package jd.wjlogin_sdk.model;

/* compiled from: TbsSdkJava */
public class WUserAccessToken {
    private String accessToken;
    private long expireTime;
    private String openid;
    private String refreshToken;
    private String scope;
    private String type;
    private String unionid;

    public String getScope() {
        return this.scope;
    }

    public void setScope(String str) {
        this.scope = str;
    }

    public String getAccessToken() {
        return this.accessToken;
    }

    public void setAccessToken(String str) {
        this.accessToken = str;
    }

    public long getExpireTime() {
        return this.expireTime;
    }

    public void setExpireTime(long j) {
        this.expireTime = j;
    }

    public String getOpenid() {
        return this.openid;
    }

    public void setOpenid(String str) {
        this.openid = str;
    }

    public String getRefreshToken() {
        return this.refreshToken;
    }

    public void setRefreshToken(String str) {
        this.refreshToken = str;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String str) {
        this.type = str;
    }

    public String getUnionid() {
        return this.unionid;
    }

    public void setUnionid(String str) {
        this.unionid = str;
    }
}
