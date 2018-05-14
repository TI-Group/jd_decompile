package com.jd.fridge.bean.requestBody;

import java.util.List;

/* compiled from: TbsSdkJava */
public class AlarmsBatchDeleteByUser {
    private String access_key;
    private List<Long> alarm_ids;
    private Long feed_id;

    public AlarmsBatchDeleteByUser(Long l, List<Long> list) {
        this.feed_id = l;
        this.alarm_ids = list;
    }

    public Long getFeed_id() {
        return this.feed_id;
    }

    public void setFeed_id(Long l) {
        this.feed_id = l;
    }

    public String getAccess_key() {
        return this.access_key;
    }

    public void setAccess_key(String str) {
        this.access_key = str;
    }

    public List<Long> getAlarm_ids() {
        return this.alarm_ids;
    }

    public void setAlarm_ids(List<Long> list) {
        this.alarm_ids = list;
    }
}
