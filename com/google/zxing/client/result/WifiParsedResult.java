package com.google.zxing.client.result;

/* compiled from: TbsSdkJava */
public final class WifiParsedResult extends ParsedResult {
    private final boolean hidden;
    private final String networkEncryption;
    private final String password;
    private final String ssid;

    public WifiParsedResult(String str, String str2, String str3) {
        this(str, str2, str3, false);
    }

    public WifiParsedResult(String str, String str2, String str3, boolean z) {
        super(ParsedResultType.WIFI);
        this.ssid = str2;
        this.networkEncryption = str;
        this.password = str3;
        this.hidden = z;
    }

    public String getSsid() {
        return this.ssid;
    }

    public String getNetworkEncryption() {
        return this.networkEncryption;
    }

    public String getPassword() {
        return this.password;
    }

    public boolean isHidden() {
        return this.hidden;
    }

    public String getDisplayResult() {
        StringBuilder stringBuilder = new StringBuilder(80);
        ParsedResult.maybeAppend(this.ssid, stringBuilder);
        ParsedResult.maybeAppend(this.networkEncryption, stringBuilder);
        ParsedResult.maybeAppend(this.password, stringBuilder);
        ParsedResult.maybeAppend(Boolean.toString(this.hidden), stringBuilder);
        return stringBuilder.toString();
    }
}
