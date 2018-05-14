package com.jd.fridge.bean;

import java.util.List;

/* compiled from: TbsSdkJava */
public class GetMessagesResult {
    private List<FridgeMessage> messages;
    private int total;

    public List<FridgeMessage> getMessages() {
        return this.messages;
    }

    public int getTotal() {
        return this.total;
    }
}
