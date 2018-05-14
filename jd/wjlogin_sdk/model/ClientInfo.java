package jd.wjlogin_sdk.model;

/* compiled from: TbsSdkJava */
public class ClientInfo {
    private String DeviceBrand;
    private String DeviceModel;
    private String DeviceName;
    private String Reserve = "";
    private String appName;
    private String area;
    private String clientType;
    private String dwAppClientVer;
    private short dwAppID;
    private int dwGetSig;
    private String osVer;
    private String screen;
    private String uuid;

    public String getDeviceBrand() {
        return this.DeviceBrand;
    }

    public void setDeviceBrand(String str) {
        this.DeviceBrand = str;
    }

    public String getDeviceModel() {
        return this.DeviceModel;
    }

    public void setDeviceModel(String str) {
        this.DeviceModel = str;
    }

    public String getDeviceName() {
        return this.DeviceName;
    }

    public void setDeviceName(String str) {
        this.DeviceName = str;
    }

    public String getReserve() {
        return this.Reserve;
    }

    public void setReserve(String str) {
        this.Reserve = str;
    }

    public short getDwAppID() {
        return this.dwAppID;
    }

    public void setDwAppID(short s) {
        this.dwAppID = s;
    }

    public String getClientType() {
        return this.clientType;
    }

    public void setClientType(String str) {
        this.clientType = str;
    }

    public String getOsVer() {
        return this.osVer;
    }

    public void setOsVer(String str) {
        this.osVer = str;
    }

    public String getDwAppClientVer() {
        return this.dwAppClientVer;
    }

    public void setDwAppClientVer(String str) {
        this.dwAppClientVer = str;
    }

    public String getScreen() {
        return this.screen;
    }

    public void setScreen(String str) {
        this.screen = str;
    }

    public String getAppName() {
        return this.appName;
    }

    public void setAppName(String str) {
        this.appName = str;
    }

    public String getArea() {
        return this.area;
    }

    public void setArea(String str) {
        this.area = str;
    }

    public String getUuid() {
        return this.uuid;
    }

    public void setUuid(String str) {
        this.uuid = str;
    }

    public int getDwGetSig() {
        return this.dwGetSig;
    }

    public void setDwGetSig(int i) {
        this.dwGetSig = i;
    }
}
