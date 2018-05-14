package com.kepler.jd.Listener;

/* compiled from: TbsSdkJava */
public interface OpenAppAction {
    public static final int OpenAppAction_result_APP = 3;
    public static final int OpenAppAction_result_BlackUrl = 5;
    public static final int OpenAppAction_result_H5 = 2;
    public static final int OpenAppAction_result_NoJDAPP = 4;
    public static final int OpenAppAction_start = 1;

    void onStatus(int i);
}
