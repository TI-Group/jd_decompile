package com.jd.fridge.bean;

import java.io.Serializable;
import java.util.List;

/* compiled from: TbsSdkJava */
public class FridgeStatusDataBean implements Serializable {
    private static final long serialVersionUID = -7357059841432992566L;
    private String digest;
    private String status;
    private List<ControlCommand> streams;

    public String getDigest() {
        return this.digest;
    }

    public String getStatus() {
        return this.status;
    }

    public List<ControlCommand> getStreams() {
        return this.streams;
    }
}
