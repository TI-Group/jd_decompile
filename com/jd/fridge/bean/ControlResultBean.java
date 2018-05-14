package com.jd.fridge.bean;

import java.util.List;

/* compiled from: TbsSdkJava */
public class ControlResultBean extends BaseJsonBean {
    private static final long serialVersionUID = 7053486112876965952L;
    private String control_ret;
    private String digest;
    private List<ControlCommand> streams;

    public String getControl_ret() {
        return this.control_ret;
    }

    public String getDigest() {
        return this.digest;
    }

    public List<ControlCommand> getStreams() {
        return this.streams;
    }
}
