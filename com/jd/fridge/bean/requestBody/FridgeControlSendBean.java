package com.jd.fridge.bean.requestBody;

import com.jd.fridge.bean.ControlCommand;
import java.util.List;

/* compiled from: TbsSdkJava */
public class FridgeControlSendBean {
    private List<ControlCommand> command;
    private long feed_id;

    public FridgeControlSendBean(long j, List<ControlCommand> list) {
        this.feed_id = j;
        this.command = list;
    }
}
