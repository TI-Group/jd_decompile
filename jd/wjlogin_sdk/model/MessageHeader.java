package jd.wjlogin_sdk.model;

/* compiled from: TbsSdkJava */
public class MessageHeader {
    private short AppId;
    private int ClientIp;
    private short Cmd;
    private short Len;
    private int Partition;
    private int Seq;
    private byte Status;
    private short SubCmd;
    private long Uid;
    private short Version;
    private String appid;
    private String code;
    private String grantType;
    private String redirectUri;
    private String secret;

    public String getAppid() {
        return this.appid;
    }

    public void setAppid(String str) {
        this.appid = str;
    }

    public String getSecret() {
        return this.secret;
    }

    public void setSecret(String str) {
        this.secret = str;
    }

    public String getCode() {
        return this.code;
    }

    public void setCode(String str) {
        this.code = str;
    }

    public String getGrantType() {
        return this.grantType;
    }

    public void setGrantType(String str) {
        this.grantType = str;
    }

    public String getRedirectUri() {
        return this.redirectUri;
    }

    public void setRedirectUri(String str) {
        this.redirectUri = str;
    }

    public int getPartition() {
        return this.Partition;
    }

    public void setPartition(int i) {
        this.Partition = i;
    }

    public short getAppId() {
        return this.AppId;
    }

    public void setAppId(short s) {
        this.AppId = s;
    }

    public short getLen() {
        return this.Len;
    }

    public void setLen(short s) {
        this.Len = s;
    }

    public long getUid() {
        return this.Uid;
    }

    public void setUid(long j) {
        this.Uid = j;
    }

    public int getSeq() {
        return this.Seq;
    }

    public void setSeq(int i) {
        this.Seq = i;
    }

    public int getClientIp() {
        return this.ClientIp;
    }

    public void setClientIp(int i) {
        this.ClientIp = i;
    }

    public short getCmd() {
        return this.Cmd;
    }

    public void setCmd(short s) {
        this.Cmd = s;
    }

    public short getSubCmd() {
        return this.SubCmd;
    }

    public void setSubCmd(short s) {
        this.SubCmd = s;
    }

    public short getVersion() {
        return this.Version;
    }

    public void setVersion(short s) {
        this.Version = s;
    }

    public byte getStatus() {
        return this.Status;
    }

    public void setStatus(byte b) {
        this.Status = b;
    }
}
