package com.jd.fridge.bean;

/* compiled from: TbsSdkJava */
public class Event {
    private Object object;
    private int type;

    /* compiled from: TbsSdkJava */
    public interface Type {
        public static final int NetError = 2;
        public static final int NetSuccess = 3;
        public static final int RequestData = 1;
    }

    public Event(int i, Object obj) {
        this.type = i;
        this.object = obj;
    }

    public int getType() {
        return this.type;
    }

    public Object getObject() {
        return this.object;
    }

    public static Event newEvent(int i, Object obj) {
        return new Event(i, obj);
    }
}
