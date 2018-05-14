package com.jd.fridge;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningTaskInfo;
import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import cn.jpush.android.api.JPushInterface;
import com.android.volley.Response.Listener;
import com.android.volley.VolleyError;
import com.google.gson.Gson;
import com.jd.fridge.bean.FoodNoticeDataBean;
import com.jd.fridge.bean.GetRecommendMenuBean;
import com.jd.fridge.bean.JPushReceiverMsgDataBean;
import com.jd.fridge.bean.requestBody.GetRMenusByGoodsIds;
import com.jd.fridge.util.a.d;
import com.jd.fridge.util.c.a;
import com.jd.fridge.util.e;
import com.jd.fridge.util.e.b;
import com.jd.fridge.util.k;
import com.jd.fridge.util.r;
import com.jingdong.jdma.common.utils.CommonUtil;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: TbsSdkJava */
public class MyJPushReceiver extends BroadcastReceiver {
    NotificationManager a;
    private Gson b = new Gson();
    private Context c;

    public void onReceive(Context context, Intent intent) {
        this.c = context;
        Bundle extras = intent.getExtras();
        if (extras != null) {
            k.a("[MyJPushReceiver] onReceive - " + intent.getAction() + ", extras: " + a(extras));
            if (JPushInterface.ACTION_REGISTRATION_ID.equals(intent.getAction())) {
                k.a("[MyJPushReceiver] 接收Registration Id : " + extras.getString(JPushInterface.EXTRA_REGISTRATION_ID));
            } else if (JPushInterface.ACTION_MESSAGE_RECEIVED.equals(intent.getAction())) {
                k.a("[MyJPushReceiver] 接收到推送下来的自定义消息: " + extras.getString(JPushInterface.EXTRA_MESSAGE) + "==是否注册推送==" + b.a().e());
                if (b.a().e()) {
                    a(context, extras);
                    return;
                }
                k.a("[MyJPushReceiver] 自定义消息: ==是否注册成功==" + b.a().e());
                r.b("infos", "registerJpushSucc==" + b.a().e());
            } else if (JPushInterface.ACTION_NOTIFICATION_OPENED.equals(intent.getAction())) {
                k.a("[MyJPushReceiver]用户点击打开了通知");
                a();
            }
        }
    }

    private static String a(Bundle bundle) {
        StringBuilder stringBuilder = new StringBuilder();
        for (String str : bundle.keySet()) {
            if (str.equals(JPushInterface.EXTRA_NOTIFICATION_ID)) {
                stringBuilder.append("\nkey:" + str + ", value:" + bundle.getInt(str));
            } else if (str.equals(JPushInterface.EXTRA_CONNECTION_CHANGE)) {
                stringBuilder.append("\nkey:" + str + ", value:" + bundle.getBoolean(str));
            } else if (!str.equals(JPushInterface.EXTRA_EXTRA)) {
                stringBuilder.append("\nkey:" + str + ", value:" + bundle.getString(str));
            } else if (bundle.getString(JPushInterface.EXTRA_EXTRA).isEmpty()) {
                k.a("This message has no Extra data");
            } else {
                try {
                    JSONObject jSONObject = new JSONObject(bundle.getString(JPushInterface.EXTRA_EXTRA));
                    Iterator keys = jSONObject.keys();
                    while (keys.hasNext()) {
                        String str2 = ((String) keys.next()).toString();
                        stringBuilder.append("\nkey:" + str + ", value: [" + str2 + " - " + jSONObject.optString(str2) + "]");
                    }
                } catch (JSONException e) {
                    k.a("Get message extra JSON error!");
                }
            }
        }
        return stringBuilder.toString();
    }

    private void a(Context context, Bundle bundle) {
        this.a = ((GlobalVariable) context.getApplicationContext()).d();
        bundle.getInt(JPushInterface.EXTRA_NOTIFICATION_ID);
        String string = bundle.getString(JPushInterface.EXTRA_TITLE);
        String string2 = bundle.getString(JPushInterface.EXTRA_MESSAGE);
        bundle.getString(JPushInterface.EXTRA_CONTENT_TYPE);
        bundle.getString(JPushInterface.EXTRA_EXTRA);
        k.a("message==" + string2);
        try {
            JPushReceiverMsgDataBean jPushReceiverMsgDataBean = (JPushReceiverMsgDataBean) this.b.fromJson(string2, JPushReceiverMsgDataBean.class);
            if (jPushReceiverMsgDataBean != null && (jPushReceiverMsgDataBean.getCode().equals("cus_alarm") || jPushReceiverMsgDataBean.getCode().equals("sys_expired") || jPushReceiverMsgDataBean.getCode().equals("not_move_region"))) {
                FoodNoticeDataBean foodNoticeDataBean = new FoodNoticeDataBean();
                String string3 = bundle.getString(JPushInterface.EXTRA_MSG_ID);
                foodNoticeDataBean.setNoticeId(string3);
                foodNoticeDataBean.setTitle(string);
                foodNoticeDataBean.setMsg_content(jPushReceiverMsgDataBean);
                foodNoticeDataBean.setPin(URLEncoder.encode(a.b().getPin(), CommonUtil.UTF8));
                foodNoticeDataBean.setFeedId(GlobalVariable.C());
                Object obj = (List) e.a(b.b(), this.c, e.a.CACHE_MODEL_MAX);
                if (obj == null) {
                    obj = new ArrayList();
                }
                if (obj.size() == 100) {
                    obj.remove(obj.size() - 1);
                }
                obj.add(0, foodNoticeDataBean);
                e.a(b.b(), this.c, obj);
                k.a("fileName==" + b.b() + "===list==" + obj + "==size==" + obj.size());
                b.a().f();
                a(context, jPushReceiverMsgDataBean.getCode());
                k.a("code====" + jPushReceiverMsgDataBean.getCode() + "==goods_id==" + jPushReceiverMsgDataBean.getData().getGoods_id());
                if (jPushReceiverMsgDataBean.getCode().equals("cus_alarm")) {
                    a(jPushReceiverMsgDataBean, string3);
                }
                if (!jPushReceiverMsgDataBean.getCode().equals("not_move_region")) {
                }
            } else if (jPushReceiverMsgDataBean != null && jPushReceiverMsgDataBean.getCode().equals("message_friends")) {
                GlobalVariable.a().h();
                a(context, jPushReceiverMsgDataBean.getCode());
            }
        } catch (Exception e) {
            k.a("Unexpected: extras is not a valid json" + e);
        }
    }

    private void a(Context context, String str) {
        if (HomeActivity.a) {
            Intent intent = new Intent("com.jd.fridge.MESSAGE_RECEIVED_ACTION");
            intent.putExtra("code", str);
            context.sendBroadcast(intent);
        }
    }

    private void a(JPushReceiverMsgDataBean jPushReceiverMsgDataBean, final String str) {
        if ("0".equals(GlobalVariable.C())) {
            k.a("getFoodRecommendMenu.feedId===" + GlobalVariable.C());
            return;
        }
        Map hashMap = new HashMap();
        Object getRMenusByGoodsIds = new GetRMenusByGoodsIds();
        getRMenusByGoodsIds.setFeed_id(Long.parseLong(GlobalVariable.C()));
        getRMenusByGoodsIds.setGoods_ids("[" + jPushReceiverMsgDataBean.getData().getGoods_id() + "]");
        getRMenusByGoodsIds.setCount(2);
        String toJson = new Gson().toJson(getRMenusByGoodsIds);
        hashMap.put("body", toJson);
        hashMap.put("content-type", "application/json");
        hashMap.put("charset", CommonUtil.UTF8);
        String a = a.a().a("/sf/service/getRMenusByGoodsIds");
        k.a("push.url==" + a + "==body==" + toJson);
        a.a().a(new d(this.c, 1, a, GetRecommendMenuBean.class, new Listener<GetRecommendMenuBean>(this) {
            final /* synthetic */ MyJPushReceiver b;

            public /* synthetic */ void onResponse(Object obj) {
                a((GetRecommendMenuBean) obj);
            }

            public void a(GetRecommendMenuBean getRecommendMenuBean) {
                Object obj = (HashMap) e.a(b.d(), this.b.c, e.a.CACHE_MODEL_MAX);
                if (obj == null) {
                    obj = new HashMap();
                }
                obj.put(str, getRecommendMenuBean.getResult());
                e.a(b.d(), this.b.c, obj);
                this.b.c.sendBroadcast(new Intent("ACTION_REFRESH_FOOD_NOTICE_DATA"));
                k.a("getResult==" + getRecommendMenuBean.getResult());
            }
        }, new com.jd.fridge.util.a.a(this, this.c) {
            final /* synthetic */ MyJPushReceiver a;

            public void a(VolleyError volleyError) {
                this.a.c.sendBroadcast(new Intent("ACTION_REFRESH_FOOD_NOTICE_DATA"));
                k.a("getResult=error=");
            }
        }, hashMap));
    }

    private void a() {
        int i;
        ActivityManager activityManager = (ActivityManager) GlobalVariable.B().getSystemService("activity");
        String str = "com.jd.fridge";
        for (RunningTaskInfo runningTaskInfo : activityManager.getRunningTasks(100)) {
            if (!runningTaskInfo.topActivity.getPackageName().equals(str)) {
                if (runningTaskInfo.baseActivity.getPackageName().equals(str)) {
                }
            }
            activityManager.moveTaskToFront(runningTaskInfo.id, 0);
            i = 1;
        }
        i = 0;
        if (i == 0) {
            Intent intent = new Intent(this.c, MainActivity.class);
            intent.addCategory("android.intent.category.LAUNCHER");
            intent.setAction("android.intent.action.MAIN");
            intent.setFlags(270532608);
            this.c.startActivity(intent);
        }
    }
}
