package com.jingdong.jdma.minterface;

import java.util.Map;

/* compiled from: TbsSdkJava */
public class MaInitCommonInfo {
    public String app_device = "";
    public String appc = "";
    public String appv = "";
    public String build = "";
    public String channel = "";
    private OnPermissionCheckListener checkListener;
    public Map<Integer, DomainInterface> domainMap;
    public String guid = "";
    public String proj_id = "";
    public String site_id = "";
    public int zipFlag = 1;

    public void setCheckListener(OnPermissionCheckListener onPermissionCheckListener) {
        this.checkListener = onPermissionCheckListener;
    }

    public String getGuid() {
        if (this.checkListener != null) {
            return this.checkListener.updateGuid();
        }
        return this.guid;
    }
}
