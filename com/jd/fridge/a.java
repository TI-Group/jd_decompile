package com.jd.fridge;

import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import cn.jiguang.net.HttpConstants;
import cn.jiguang.net.HttpUtils;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response.Listener;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.jd.fridge.bean.BaseJsonBean;
import com.jd.fridge.bean.ConcernListDataBean;
import com.jd.fridge.bean.FavorMenuListDataBaseBean;
import com.jd.fridge.bean.FoodCategoryListDataBaseBean;
import com.jd.fridge.bean.FoodDishListDataBaseBean;
import com.jd.fridge.bean.FoodsAlarmListBaseBean;
import com.jd.fridge.bean.FoodsListDataBaseBean;
import com.jd.fridge.bean.FridgeControlBaseBean;
import com.jd.fridge.bean.FridgeDoorDataBaseBean;
import com.jd.fridge.bean.FridgeUserInfoBaseBean;
import com.jd.fridge.bean.GenQrResultBean;
import com.jd.fridge.bean.GetCodeBean;
import com.jd.fridge.bean.GetFaultTypeDataBean;
import com.jd.fridge.bean.GetLocationListBean;
import com.jd.fridge.bean.GetMessageDataBaseBean;
import com.jd.fridge.bean.GetPicHistoryDataBean;
import com.jd.fridge.bean.GetShareContentBean;
import com.jd.fridge.bean.HGHCDataBaseBean;
import com.jd.fridge.bean.ListFridgeDevicesBaseBean;
import com.jd.fridge.bean.MenuHotSearchListDataBaseBean;
import com.jd.fridge.bean.MenuKeyWordsSearchListDataBaseBean;
import com.jd.fridge.bean.ModifyAvatarDataBean;
import com.jd.fridge.bean.ModifyNickBaseBean;
import com.jd.fridge.bean.NotMoveDataBean;
import com.jd.fridge.bean.NutritionDetailDataBaseBean;
import com.jd.fridge.bean.NutritionDistributionDataBaseBean;
import com.jd.fridge.bean.ParamsCommonFoodDishListBean;
import com.jd.fridge.bean.ParamsFoodDishListBean;
import com.jd.fridge.bean.ResponseDataBaseBean;
import com.jd.fridge.bean.StockDataBaseBean;
import com.jd.fridge.bean.StreamsH5InfoBaseBean;
import com.jd.fridge.bean.StreamsH5InfoDataBean;
import com.jd.fridge.bean.UpdateBaseBean;
import com.jd.fridge.bean.requestBody.AddFriend;
import com.jd.fridge.bean.requestBody.AddGoodsList;
import com.jd.fridge.bean.requestBody.AlarmsBatchDeleteByUser;
import com.jd.fridge.bean.requestBody.Avatar;
import com.jd.fridge.bean.requestBody.CancelConcern;
import com.jd.fridge.bean.requestBody.CancelRegisterAudienceByUser;
import com.jd.fridge.bean.requestBody.ConcernBody;
import com.jd.fridge.bean.requestBody.CreateMessage;
import com.jd.fridge.bean.requestBody.CurrentGoodsListByUser;
import com.jd.fridge.bean.requestBody.FaultReport;
import com.jd.fridge.bean.requestBody.FavorMenu;
import com.jd.fridge.bean.requestBody.FeedId;
import com.jd.fridge.bean.requestBody.Feedback;
import com.jd.fridge.bean.requestBody.FridgeControlSendBean;
import com.jd.fridge.bean.requestBody.FridgeStatus;
import com.jd.fridge.bean.requestBody.GetHighGlucoseAndHighCalorie;
import com.jd.fridge.bean.requestBody.GetMessages;
import com.jd.fridge.bean.requestBody.GetNutritionDetail;
import com.jd.fridge.bean.requestBody.GetNutritionDistribution;
import com.jd.fridge.bean.requestBody.Location;
import com.jd.fridge.bean.requestBody.Nickname;
import com.jd.fridge.bean.requestBody.NotMoveBean;
import com.jd.fridge.bean.requestBody.PicHistory;
import com.jd.fridge.bean.requestBody.RefuseConcern;
import com.jd.fridge.bean.requestBody.RegisterAudienceByUser;
import com.jd.fridge.bean.requestBody.ResetGoodsAlarm;
import com.jd.fridge.bean.requestBody.SearchFoodsListBeanResult;
import com.jd.fridge.bean.requestBody.SearchText;
import com.jd.fridge.bean.requestBody.Share;
import com.jd.fridge.bean.requestBody.Stock;
import com.jd.fridge.bean.requestBody.StreamsAndH5Info;
import com.jd.fridge.bean.requestBody.UpdateSendBean;
import com.jd.fridge.bean.requestBody.UserPin;
import com.jd.fridge.util.a.b;
import com.jd.fridge.util.a.d;
import com.jd.fridge.util.a.e;
import com.jd.fridge.util.f;
import com.jd.fridge.util.k;
import com.jd.fridge.util.p;
import com.jd.fridge.util.r;
import com.jingdong.jdma.common.utils.CommonUtil;
import com.tencent.smtt.sdk.TbsReaderView.ReaderCallback;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.commons.lang.StringUtils;
import org.json.JSONObject;

/* compiled from: TbsSdkJava */
public final class a {
    private static a a;
    private static RequestQueue b;
    private static GlobalVariable c;
    private Gson d = new Gson();

    private a(GlobalVariable globalVariable) {
        c = globalVariable;
        b = b();
    }

    public static synchronized a a(GlobalVariable globalVariable) {
        a aVar;
        synchronized (a.class) {
            if (a == null) {
                a = new a(globalVariable);
            }
            aVar = a;
        }
        return aVar;
    }

    public static a a() {
        return c.b();
    }

    public RequestQueue b() {
        if (b == null) {
            b = Volley.newRequestQueue(c.getApplicationContext());
        }
        return b;
    }

    public <T> void a(Request<T> request) {
        b().add(request);
    }

    public String a(String str) {
        StringBuilder stringBuilder = new StringBuilder(GlobalVariable.a().e());
        stringBuilder.append(str);
        stringBuilder.append(HttpUtils.URL_AND_PARA_SEPARATOR);
        stringBuilder.append("plat=Android");
        stringBuilder.append("&hard_platform=" + Build.MODEL.replace(" ", ""));
        stringBuilder.append("&app_version=" + f.a(c));
        stringBuilder.append("&plat_version=" + VERSION.RELEASE);
        stringBuilder.append("&app_key=194");
        return stringBuilder.toString();
    }

    public void a(final Handler handler, UserPin userPin) {
        Map hashMap = new HashMap();
        hashMap.put("body", this.d.toJson((Object) userPin));
        hashMap.put("content-type", "application/json");
        hashMap.put("charset", CommonUtil.UTF8);
        String a = a("/sf/service/listFridgeDevices");
        k.a(a);
        b.add(new e(c, 1, a, ListFridgeDevicesBaseBean.class, new Listener<ListFridgeDevicesBaseBean>(this) {
            final /* synthetic */ a b;

            public /* synthetic */ void onResponse(Object obj) {
                a((ListFridgeDevicesBaseBean) obj);
            }

            public void a(ListFridgeDevicesBaseBean listFridgeDevicesBaseBean) {
                handler.obtainMessage(2000, listFridgeDevicesBaseBean.getResult()).sendToTarget();
            }
        }, new b(this, c) {
            final /* synthetic */ a b;

            public void a(VolleyError volleyError) {
                handler.sendEmptyMessage(2001);
            }
        }, hashMap));
    }

    public void b(final Handler handler, UserPin userPin) {
        Map hashMap = new HashMap();
        hashMap.put("body", this.d.toJson((Object) userPin));
        hashMap.put("content-type", "application/json");
        hashMap.put("charset", CommonUtil.UTF8);
        String a = a("/sf/service/listFridgeDevices");
        k.a(a);
        b.add(new d(c, 1, a, ListFridgeDevicesBaseBean.class, new Listener<ListFridgeDevicesBaseBean>(this) {
            final /* synthetic */ a b;

            public /* synthetic */ void onResponse(Object obj) {
                a((ListFridgeDevicesBaseBean) obj);
            }

            public void a(ListFridgeDevicesBaseBean listFridgeDevicesBaseBean) {
                handler.obtainMessage(2000, listFridgeDevicesBaseBean.getResult()).sendToTarget();
            }
        }, new com.jd.fridge.util.a.a(this, c) {
            final /* synthetic */ a b;

            public void a(VolleyError volleyError) {
                if (StringUtils.isNotEmpty(volleyError.getMessage()) && volleyError.getMessage().contains("UnknownHostException")) {
                    handler.sendEmptyMessage(2002);
                } else {
                    handler.sendEmptyMessage(2001);
                }
            }
        }, hashMap));
    }

    public void a(final Handler handler, FeedId feedId) {
        Map hashMap = new HashMap();
        hashMap.put("body", this.d.toJson((Object) feedId));
        hashMap.put("content-type", "application/json");
        hashMap.put("charset", CommonUtil.UTF8);
        String a = a("/sf/service/getNewRecognizedResultByUser");
        k.a(a);
        b.add(new d(c, 1, a, FridgeDoorDataBaseBean.class, new Listener<FridgeDoorDataBaseBean>(this) {
            final /* synthetic */ a b;

            public /* synthetic */ void onResponse(Object obj) {
                a((FridgeDoorDataBaseBean) obj);
            }

            public void a(FridgeDoorDataBaseBean fridgeDoorDataBaseBean) {
                handler.obtainMessage(2000, fridgeDoorDataBaseBean.getResult()).sendToTarget();
            }
        }, new com.jd.fridge.util.a.a(this, c) {
            final /* synthetic */ a b;

            public void a(VolleyError volleyError) {
                if (StringUtils.isNotEmpty(volleyError.getMessage()) && volleyError.getMessage().contains("UnknownHostException")) {
                    handler.sendEmptyMessage(2002);
                } else if (!TextUtils.isEmpty(volleyError.getMessage()) && (volleyError.getMessage().equals("2001") || volleyError.getMessage().equals("2003"))) {
                    handler.sendEmptyMessage(8001);
                } else if (TextUtils.isEmpty(volleyError.getMessage()) || !volleyError.getMessage().equals("-201")) {
                    handler.sendEmptyMessage(2001);
                } else {
                    handler.sendEmptyMessage(7024);
                }
            }
        }, hashMap));
    }

    public void a(final Handler handler, CurrentGoodsListByUser currentGoodsListByUser) {
        Map hashMap = new HashMap();
        hashMap.put("body", this.d.toJson((Object) currentGoodsListByUser));
        hashMap.put("content-type", "application/json");
        hashMap.put("charset", CommonUtil.UTF8);
        String str = "currentGoodsListByUser";
        b.add(new d(c, 1, a("/sf/service/currentGoodsListByUser"), FoodsAlarmListBaseBean.class, new Listener<FoodsAlarmListBaseBean>(this) {
            final /* synthetic */ a b;

            public /* synthetic */ void onResponse(Object obj) {
                a((FoodsAlarmListBaseBean) obj);
            }

            public void a(FoodsAlarmListBaseBean foodsAlarmListBaseBean) {
                Object result = foodsAlarmListBaseBean.getResult();
                com.jd.fridge.util.e.a("currentGoodsListByUser", GlobalVariable.a(), result);
                handler.obtainMessage(10001, result).sendToTarget();
            }
        }, new com.jd.fridge.util.a.a(this, c) {
            final /* synthetic */ a b;

            public void a(VolleyError volleyError) {
                handler.obtainMessage(2001, "currentGoodsListByUser").sendToTarget();
            }
        }, hashMap));
    }

    public void a(final Handler handler, AlarmsBatchDeleteByUser alarmsBatchDeleteByUser) {
        Map hashMap = new HashMap();
        hashMap.put("body", this.d.toJson((Object) alarmsBatchDeleteByUser));
        hashMap.put("content-type", "application/json");
        hashMap.put("charset", CommonUtil.UTF8);
        b.add(new d(c, 1, a("/sf/service/alarmsBatchDeleteByUser"), BaseJsonBean.class, new Listener<BaseJsonBean>(this) {
            final /* synthetic */ a b;

            public /* synthetic */ void onResponse(Object obj) {
                a((BaseJsonBean) obj);
            }

            public void a(BaseJsonBean baseJsonBean) {
                handler.obtainMessage(10002).sendToTarget();
            }
        }, new com.jd.fridge.util.a.a(this, c) {
            final /* synthetic */ a b;

            public void a(VolleyError volleyError) {
                handler.obtainMessage(10003).sendToTarget();
            }
        }, hashMap));
    }

    public void a(final Handler handler, final ResetGoodsAlarm resetGoodsAlarm) {
        Map hashMap = new HashMap();
        hashMap.put("body", this.d.toJson((Object) resetGoodsAlarm));
        hashMap.put("content-type", "application/json");
        hashMap.put("charset", CommonUtil.UTF8);
        b.add(new d(c, 1, a("/sf/service/resetGoodsAlarmByUser"), BaseJsonBean.class, new Listener<BaseJsonBean>(this) {
            final /* synthetic */ a b;

            public /* synthetic */ void onResponse(Object obj) {
                a((BaseJsonBean) obj);
            }

            public void a(BaseJsonBean baseJsonBean) {
                handler.obtainMessage(10004).sendToTarget();
            }
        }, new com.jd.fridge.util.a.a(this, c) {
            final /* synthetic */ a c;

            public void a(VolleyError volleyError) {
                p.a("APIs", "resetGoodsAlarmByUser: " + volleyError.getMessage());
                Object obj = resetGoodsAlarm.getFoods_name() + "|";
                if (volleyError.getMessage() != null) {
                    obj = obj + volleyError.getMessage();
                }
                handler.obtainMessage(10005, obj).sendToTarget();
            }
        }, hashMap));
    }

    public void a(final Handler handler, GetNutritionDistribution getNutritionDistribution) {
        Map hashMap = new HashMap();
        hashMap.put("body", this.d.toJson((Object) getNutritionDistribution));
        hashMap.put("content-type", "application/json");
        hashMap.put("charset", CommonUtil.UTF8);
        String a = a("/sf/service/getNutritionDistribution");
        k.a(a);
        b.add(new d(c, 1, a, NutritionDistributionDataBaseBean.class, new Listener<NutritionDistributionDataBaseBean>(this) {
            final /* synthetic */ a b;

            public /* synthetic */ void onResponse(Object obj) {
                a((NutritionDistributionDataBaseBean) obj);
            }

            public void a(NutritionDistributionDataBaseBean nutritionDistributionDataBaseBean) {
                handler.obtainMessage(2000, nutritionDistributionDataBaseBean.getResult()).sendToTarget();
            }
        }, new com.jd.fridge.util.a.a(this, c) {
            final /* synthetic */ a b;

            public void a(VolleyError volleyError) {
                if (StringUtils.isNotEmpty(volleyError.getMessage()) && volleyError.getMessage().contains("UnknownHostException")) {
                    handler.sendEmptyMessage(2002);
                } else {
                    handler.sendEmptyMessage(2001);
                }
            }
        }, hashMap));
    }

    public void a(final Handler handler, GetHighGlucoseAndHighCalorie getHighGlucoseAndHighCalorie) {
        Map hashMap = new HashMap();
        hashMap.put("body", this.d.toJson((Object) getHighGlucoseAndHighCalorie));
        hashMap.put("content-type", "application/json");
        hashMap.put("charset", CommonUtil.UTF8);
        String a = a("/sf/service/getHighGlucoseAndHighCalorie");
        k.a(a);
        b.add(new d(c, 1, a, HGHCDataBaseBean.class, new Listener<HGHCDataBaseBean>(this) {
            final /* synthetic */ a b;

            public /* synthetic */ void onResponse(Object obj) {
                a((HGHCDataBaseBean) obj);
            }

            public void a(HGHCDataBaseBean hGHCDataBaseBean) {
                handler.obtainMessage(2000, hGHCDataBaseBean.getResult()).sendToTarget();
            }
        }, new com.jd.fridge.util.a.a(this, c) {
            final /* synthetic */ a b;

            public void a(VolleyError volleyError) {
                if (StringUtils.isNotEmpty(volleyError.getMessage()) && volleyError.getMessage().contains("UnknownHostException")) {
                    handler.sendEmptyMessage(2002);
                } else {
                    handler.sendEmptyMessage(2001);
                }
            }
        }, hashMap));
    }

    public void a(final Handler handler, final GetNutritionDetail getNutritionDetail) {
        Map hashMap = new HashMap();
        hashMap.put("body", this.d.toJson((Object) getNutritionDetail));
        hashMap.put("content-type", "application/json");
        hashMap.put("charset", CommonUtil.UTF8);
        String a = a("/sf/service/getNutritionDetail");
        k.a(a);
        b.add(new d(c, 1, a, NutritionDetailDataBaseBean.class, new Listener<NutritionDetailDataBaseBean>(this) {
            final /* synthetic */ a c;

            public /* synthetic */ void onResponse(Object obj) {
                a((NutritionDetailDataBaseBean) obj);
            }

            public void a(NutritionDetailDataBaseBean nutritionDetailDataBaseBean) {
                if (getNutritionDetail.getStart_index() > 0) {
                    handler.obtainMessage(3000, nutritionDetailDataBaseBean.getResult()).sendToTarget();
                } else {
                    handler.obtainMessage(2000, nutritionDetailDataBaseBean.getResult()).sendToTarget();
                }
            }
        }, new com.jd.fridge.util.a.a(this, c) {
            final /* synthetic */ a c;

            public void a(VolleyError volleyError) {
                if (getNutritionDetail.getStart_index() > 0) {
                    handler.sendEmptyMessage(HttpConstants.NET_TIMEOUT_CODE);
                } else if (StringUtils.isNotEmpty(volleyError.getMessage()) && volleyError.getMessage().contains("UnknownHostException")) {
                    handler.sendEmptyMessage(2002);
                } else {
                    handler.sendEmptyMessage(2001);
                }
            }
        }, hashMap));
    }

    public void a(final Handler handler, String str, int i) {
        StringBuilder stringBuilder = new StringBuilder("https://appfridge.jd.com/api/recommend/goodsList.json");
        stringBuilder.append(HttpUtils.URL_AND_PARA_SEPARATOR);
        stringBuilder.append("keyWord=" + str);
        stringBuilder.append("&num=" + i);
        stringBuilder.append("&imgWidth=220&imgHeight=220");
        String stringBuilder2 = stringBuilder.toString();
        k.a(stringBuilder2);
        b.add(new d(c, 0, stringBuilder2, FoodsListDataBaseBean.class, new Listener<FoodsListDataBaseBean>(this) {
            final /* synthetic */ a b;

            public /* synthetic */ void onResponse(Object obj) {
                a((FoodsListDataBaseBean) obj);
            }

            public void a(FoodsListDataBaseBean foodsListDataBaseBean) {
                handler.obtainMessage(3000, foodsListDataBaseBean.getList()).sendToTarget();
            }
        }, new com.jd.fridge.util.a.a(this, c) {
            final /* synthetic */ a b;

            public void a(VolleyError volleyError) {
                handler.sendEmptyMessage(HttpConstants.NET_TIMEOUT_CODE);
            }
        }, null));
    }

    public void a(final Handler handler, RegisterAudienceByUser registerAudienceByUser) {
        Map hashMap = new HashMap();
        hashMap.put("body", this.d.toJson((Object) registerAudienceByUser));
        hashMap.put("content-type", "application/json");
        hashMap.put("charset", CommonUtil.UTF8);
        String a = a("/sf/service/registerAudienceByUser");
        k.a(a);
        b.add(new e(c, 1, a, BaseJsonBean.class, new Listener<BaseJsonBean>(this) {
            final /* synthetic */ a b;

            public /* synthetic */ void onResponse(Object obj) {
                a((BaseJsonBean) obj);
            }

            public void a(BaseJsonBean baseJsonBean) {
                handler.sendEmptyMessage(5000);
            }
        }, new b(this, c) {
            final /* synthetic */ a b;

            public void a(VolleyError volleyError) {
                handler.sendEmptyMessage(ReaderCallback.HIDDEN_BAR);
            }
        }, hashMap));
    }

    public void a(final Handler handler, CancelRegisterAudienceByUser cancelRegisterAudienceByUser) {
        Map hashMap = new HashMap();
        hashMap.put("body", this.d.toJson((Object) cancelRegisterAudienceByUser));
        hashMap.put("content-type", "application/json");
        hashMap.put("charset", CommonUtil.UTF8);
        String a = a("/sf/service/cancelRegisterAudienceByUser");
        k.a(a);
        b.add(new e(c, 1, a, BaseJsonBean.class, new Listener<BaseJsonBean>(this) {
            final /* synthetic */ a b;

            public /* synthetic */ void onResponse(Object obj) {
                a((BaseJsonBean) obj);
            }

            public void a(BaseJsonBean baseJsonBean) {
                handler.sendEmptyMessage(6000);
            }
        }, new b(this, c) {
            final /* synthetic */ a b;

            public void a(VolleyError volleyError) {
                if (volleyError == null || volleyError.getMessage() == null) {
                    handler.sendEmptyMessage(6001);
                } else if (volleyError.getMessage().equals("2001") || volleyError.getMessage().equals("2003")) {
                    handler.sendEmptyMessage(8001);
                } else {
                    handler.sendEmptyMessage(6001);
                }
            }
        }, hashMap));
    }

    public void a(CancelRegisterAudienceByUser cancelRegisterAudienceByUser) {
        Map hashMap = new HashMap();
        hashMap.put("body", this.d.toJson((Object) cancelRegisterAudienceByUser));
        hashMap.put("content-type", "application/json");
        hashMap.put("charset", CommonUtil.UTF8);
        String a = a("/sf/service/cancelRegisterAudienceByUser");
        k.a(a);
        b.add(new d(c, 1, a, BaseJsonBean.class, new Listener<BaseJsonBean>(this) {
            final /* synthetic */ a a;

            {
                this.a = r1;
            }

            public /* synthetic */ void onResponse(Object obj) {
                a((BaseJsonBean) obj);
            }

            public void a(BaseJsonBean baseJsonBean) {
                com.jd.fridge.util.e.b.a().a(false);
            }
        }, new com.jd.fridge.util.a.a(this, c) {
            final /* synthetic */ a a;

            public void a(VolleyError volleyError) {
                com.jd.fridge.util.e.b.a().a(false);
            }
        }, hashMap));
    }

    public void a(final Handler handler, Map<String, String> map) {
        String a = a("/sf/service/getFridgeUserInfo");
        k.a(a);
        b.add(new d(c, 1, a, FridgeUserInfoBaseBean.class, new Listener<FridgeUserInfoBaseBean>(this) {
            final /* synthetic */ a b;

            public /* synthetic */ void onResponse(Object obj) {
                a((FridgeUserInfoBaseBean) obj);
            }

            public void a(FridgeUserInfoBaseBean fridgeUserInfoBaseBean) {
                handler.obtainMessage(2022, fridgeUserInfoBaseBean.getResult()).sendToTarget();
            }
        }, new com.jd.fridge.util.a.a(this, c) {
            final /* synthetic */ a b;

            public void a(VolleyError volleyError) {
                handler.sendEmptyMessage(2023);
            }
        }, map));
    }

    public void b(final Handler handler, FeedId feedId) {
        Map hashMap = new HashMap();
        hashMap.put("body", this.d.toJson((Object) feedId));
        hashMap.put("content-type", "application/json");
        hashMap.put("charset", CommonUtil.UTF8);
        String a = a("/sf/service/generateQr");
        k.a(a);
        b.add(new d(c, 1, a, GenQrResultBean.class, new Listener<GenQrResultBean>(this) {
            final /* synthetic */ a b;

            public /* synthetic */ void onResponse(Object obj) {
                a((GenQrResultBean) obj);
            }

            public void a(GenQrResultBean genQrResultBean) {
                handler.obtainMessage(2004, genQrResultBean.getResult()).sendToTarget();
            }
        }, new com.jd.fridge.util.a.a(this, c) {
            final /* synthetic */ a b;

            public void a(VolleyError volleyError) {
                handler.sendEmptyMessage(2005);
            }
        }, hashMap));
    }

    public void a(final Handler handler, Stock stock) {
        Map hashMap = new HashMap();
        hashMap.put("body", this.d.toJson((Object) stock));
        hashMap.put("content-type", "application/json");
        hashMap.put("charset", CommonUtil.UTF8);
        String a = a("/sf/service/getOutStockInfoByUser");
        k.a(a);
        b.add(new d(c, 1, a, StockDataBaseBean.class, new Listener<StockDataBaseBean>(this) {
            final /* synthetic */ a b;

            public /* synthetic */ void onResponse(Object obj) {
                a((StockDataBaseBean) obj);
            }

            public void a(StockDataBaseBean stockDataBaseBean) {
                handler.obtainMessage(4000, stockDataBaseBean.getResult()).sendToTarget();
            }
        }, new com.jd.fridge.util.a.a(this, c) {
            final /* synthetic */ a b;

            public void a(VolleyError volleyError) {
                handler.sendEmptyMessage(4001);
            }
        }, hashMap));
    }

    public void a(final Handler handler, CreateMessage createMessage) {
        Map hashMap = new HashMap();
        hashMap.put("body", this.d.toJson((Object) createMessage));
        hashMap.put("content-type", "application/json");
        hashMap.put("charset", CommonUtil.UTF8);
        String a = a("/sf/service/saveTextMessage");
        k.a(a);
        b.add(new d(c, 1, a, ResponseDataBaseBean.class, new Listener<ResponseDataBaseBean>(this) {
            final /* synthetic */ a b;

            public /* synthetic */ void onResponse(Object obj) {
                a((ResponseDataBaseBean) obj);
            }

            public void a(ResponseDataBaseBean responseDataBaseBean) {
                handler.obtainMessage(2000, responseDataBaseBean).sendToTarget();
            }
        }, new com.jd.fridge.util.a.a(this, c) {
            final /* synthetic */ a b;

            public void a(VolleyError volleyError) {
                handler.sendEmptyMessage(2001);
            }
        }, hashMap));
    }

    public void a(final Handler handler, GetMessages getMessages) {
        Map hashMap = new HashMap();
        hashMap.put("body", this.d.toJson((Object) getMessages));
        hashMap.put("content-type", "application/json");
        hashMap.put("charset", CommonUtil.UTF8);
        String a = a("/sf/service/getAPPMessages");
        k.a(a);
        b.add(new d(c, 1, a, GetMessageDataBaseBean.class, new Listener<GetMessageDataBaseBean>(this) {
            final /* synthetic */ a b;

            public /* synthetic */ void onResponse(Object obj) {
                a((GetMessageDataBaseBean) obj);
            }

            public void a(GetMessageDataBaseBean getMessageDataBaseBean) {
                handler.obtainMessage(2000, getMessageDataBaseBean).sendToTarget();
            }
        }, new com.jd.fridge.util.a.a(this, c) {
            final /* synthetic */ a b;

            public void a(VolleyError volleyError) {
                handler.sendEmptyMessage(2001);
            }
        }, hashMap));
    }

    public void a(final Handler handler, Nickname nickname) {
        Map hashMap = new HashMap();
        hashMap.put("body", this.d.toJson((Object) nickname));
        hashMap.put("content-type", "application/json");
        hashMap.put("charset", CommonUtil.UTF8);
        String a = a("/sf/service/modifyNickname");
        k.a(a);
        b.add(new d(c, 1, a, ModifyNickBaseBean.class, new Listener<ModifyNickBaseBean>(this) {
            final /* synthetic */ a b;

            public /* synthetic */ void onResponse(Object obj) {
                a((ModifyNickBaseBean) obj);
            }

            public void a(ModifyNickBaseBean modifyNickBaseBean) {
                handler.obtainMessage(2000, modifyNickBaseBean).sendToTarget();
            }
        }, new com.jd.fridge.util.a.a(this, c) {
            final /* synthetic */ a b;

            public void a(VolleyError volleyError) {
                handler.sendEmptyMessage(2001);
            }
        }, hashMap));
    }

    public void a(final Handler handler, Avatar avatar) {
        Map hashMap = new HashMap();
        hashMap.put("body", this.d.toJson((Object) avatar));
        hashMap.put("content-type", "application/json");
        hashMap.put("charset", CommonUtil.UTF8);
        String a = a("/sf/service/modifyUserImage");
        k.a(a);
        b.add(new d(c, 1, a, ModifyAvatarDataBean.class, new Listener<ModifyAvatarDataBean>(this) {
            final /* synthetic */ a b;

            public /* synthetic */ void onResponse(Object obj) {
                a((ModifyAvatarDataBean) obj);
            }

            public void a(ModifyAvatarDataBean modifyAvatarDataBean) {
                handler.obtainMessage(2000, modifyAvatarDataBean).sendToTarget();
            }
        }, new com.jd.fridge.util.a.a(this, c) {
            final /* synthetic */ a b;

            public void a(VolleyError volleyError) {
                handler.sendEmptyMessage(2001);
            }
        }, hashMap));
    }

    public void a(final Handler handler, Feedback feedback) {
        Map hashMap = new HashMap();
        hashMap.put("body", this.d.toJson((Object) feedback));
        hashMap.put("content-type", "application/json");
        hashMap.put("charset", CommonUtil.UTF8);
        String a = a("/sf/service/addFeedback");
        k.a(a);
        b.add(new d(c, 1, a, ResponseDataBaseBean.class, new Listener<ResponseDataBaseBean>(this) {
            final /* synthetic */ a b;

            public /* synthetic */ void onResponse(Object obj) {
                a((ResponseDataBaseBean) obj);
            }

            public void a(ResponseDataBaseBean responseDataBaseBean) {
                handler.obtainMessage(2000, responseDataBaseBean).sendToTarget();
            }
        }, new com.jd.fridge.util.a.a(this, c) {
            final /* synthetic */ a b;

            public void a(VolleyError volleyError) {
                handler.sendEmptyMessage(2001);
            }
        }, hashMap));
    }

    public void a(final Handler handler, FavorMenu favorMenu) {
        Map hashMap = new HashMap();
        hashMap.put("body", this.d.toJson((Object) favorMenu));
        hashMap.put("content-type", "application/json");
        hashMap.put("charset", CommonUtil.UTF8);
        String a = a("/sf/service/getUserMenuFavorite");
        k.a(a);
        b.add(new d(c, 1, a, FavorMenuListDataBaseBean.class, new Listener<FavorMenuListDataBaseBean>(this) {
            final /* synthetic */ a b;

            public /* synthetic */ void onResponse(Object obj) {
                a((FavorMenuListDataBaseBean) obj);
            }

            public void a(FavorMenuListDataBaseBean favorMenuListDataBaseBean) {
                handler.obtainMessage(2006, favorMenuListDataBaseBean).sendToTarget();
            }
        }, new com.jd.fridge.util.a.a(this, c) {
            final /* synthetic */ a b;

            public void a(VolleyError volleyError) {
                handler.sendEmptyMessage(2007);
            }
        }, hashMap));
    }

    public void a(final Handler handler) {
        Map hashMap = new HashMap();
        String a = a("/sf/service/faultInfo");
        k.a(a);
        b.add(new d(c, 0, a, GetFaultTypeDataBean.class, new Listener<GetFaultTypeDataBean>(this) {
            final /* synthetic */ a b;

            public /* synthetic */ void onResponse(Object obj) {
                a((GetFaultTypeDataBean) obj);
            }

            public void a(GetFaultTypeDataBean getFaultTypeDataBean) {
                handler.obtainMessage(2008, getFaultTypeDataBean).sendToTarget();
            }
        }, new com.jd.fridge.util.a.a(this, c) {
            final /* synthetic */ a b;

            public void a(VolleyError volleyError) {
                handler.sendEmptyMessage(2009);
            }
        }, hashMap));
    }

    public void a(final Handler handler, Location location) {
        Map hashMap = new HashMap();
        hashMap.put("body", this.d.toJson((Object) location));
        hashMap.put("content-type", "application/json");
        hashMap.put("charset", CommonUtil.UTF8);
        String a = a("/sf/service/getLocation");
        k.a(a);
        b.add(new d(c, 1, a, GetLocationListBean.class, new Listener<GetLocationListBean>(this) {
            final /* synthetic */ a b;

            public /* synthetic */ void onResponse(Object obj) {
                a((GetLocationListBean) obj);
            }

            public void a(GetLocationListBean getLocationListBean) {
                handler.obtainMessage(2010, getLocationListBean).sendToTarget();
            }
        }, new com.jd.fridge.util.a.a(this, c) {
            final /* synthetic */ a b;

            public void a(VolleyError volleyError) {
                handler.sendEmptyMessage(2011);
            }
        }, hashMap));
    }

    public void a(final Handler handler, FaultReport faultReport) {
        Map hashMap = new HashMap();
        hashMap.put("body", this.d.toJson((Object) faultReport));
        hashMap.put("content-type", "application/json");
        hashMap.put("charset", CommonUtil.UTF8);
        String a = a("/sf/service/faultReport");
        k.a(a);
        b.add(new d(c, 1, a, ResponseDataBaseBean.class, new Listener<ResponseDataBaseBean>(this) {
            final /* synthetic */ a b;

            public /* synthetic */ void onResponse(Object obj) {
                a((ResponseDataBaseBean) obj);
            }

            public void a(ResponseDataBaseBean responseDataBaseBean) {
                handler.obtainMessage(2012, responseDataBaseBean).sendToTarget();
            }
        }, new com.jd.fridge.util.a.a(this, c) {
            final /* synthetic */ a b;

            public void a(VolleyError volleyError) {
                handler.sendEmptyMessage(2013);
            }
        }, hashMap));
    }

    public void a(final Handler handler, ConcernBody concernBody) {
        Map hashMap = new HashMap();
        hashMap.put("body", this.d.toJson((Object) concernBody));
        hashMap.put("content-type", "application/json");
        hashMap.put("charset", CommonUtil.UTF8);
        String a = a("/sf/service/iConcerned");
        k.a(a);
        b.add(new d(c, 1, a, ConcernListDataBean.class, new Listener<ConcernListDataBean>(this) {
            final /* synthetic */ a b;

            public /* synthetic */ void onResponse(Object obj) {
                a((ConcernListDataBean) obj);
            }

            public void a(ConcernListDataBean concernListDataBean) {
                handler.obtainMessage(2000, concernListDataBean).sendToTarget();
            }
        }, new com.jd.fridge.util.a.a(this, c) {
            final /* synthetic */ a b;

            public void a(VolleyError volleyError) {
                handler.sendEmptyMessage(2001);
            }
        }, hashMap));
    }

    public void b(final Handler handler, ConcernBody concernBody) {
        Map hashMap = new HashMap();
        hashMap.put("body", this.d.toJson((Object) concernBody));
        hashMap.put("content-type", "application/json");
        hashMap.put("charset", CommonUtil.UTF8);
        String a = a("/sf/service/concernedMe");
        k.a(a);
        b.add(new d(c, 1, a, ConcernListDataBean.class, new Listener<ConcernListDataBean>(this) {
            final /* synthetic */ a b;

            public /* synthetic */ void onResponse(Object obj) {
                a((ConcernListDataBean) obj);
            }

            public void a(ConcernListDataBean concernListDataBean) {
                handler.obtainMessage(2000, concernListDataBean).sendToTarget();
            }
        }, new com.jd.fridge.util.a.a(this, c) {
            final /* synthetic */ a b;

            public void a(VolleyError volleyError) {
                handler.sendEmptyMessage(2001);
            }
        }, hashMap));
    }

    public void a(final Handler handler, CancelConcern cancelConcern) {
        Map hashMap = new HashMap();
        hashMap.put("body", this.d.toJson((Object) cancelConcern));
        hashMap.put("content-type", "application/json");
        hashMap.put("charset", CommonUtil.UTF8);
        String a = a("/sf/service/cancelConcern");
        k.a(a);
        b.add(new d(c, 1, a, ResponseDataBaseBean.class, new Listener<ResponseDataBaseBean>(this) {
            final /* synthetic */ a b;

            public /* synthetic */ void onResponse(Object obj) {
                a((ResponseDataBaseBean) obj);
            }

            public void a(ResponseDataBaseBean responseDataBaseBean) {
                handler.obtainMessage(2014, responseDataBaseBean).sendToTarget();
            }
        }, new com.jd.fridge.util.a.a(this, c) {
            final /* synthetic */ a b;

            public void a(VolleyError volleyError) {
                handler.sendEmptyMessage(2015);
            }
        }, hashMap));
    }

    public void a(final Handler handler, RefuseConcern refuseConcern) {
        Map hashMap = new HashMap();
        hashMap.put("body", this.d.toJson((Object) refuseConcern));
        hashMap.put("content-type", "application/json");
        hashMap.put("charset", CommonUtil.UTF8);
        String a = a("/sf/service/refuseConcern");
        k.a(a);
        b.add(new d(c, 1, a, ResponseDataBaseBean.class, new Listener<ResponseDataBaseBean>(this) {
            final /* synthetic */ a b;

            public /* synthetic */ void onResponse(Object obj) {
                a((ResponseDataBaseBean) obj);
            }

            public void a(ResponseDataBaseBean responseDataBaseBean) {
                handler.obtainMessage(2016, responseDataBaseBean).sendToTarget();
            }
        }, new com.jd.fridge.util.a.a(this, c) {
            final /* synthetic */ a b;

            public void a(VolleyError volleyError) {
                handler.sendEmptyMessage(2017);
            }
        }, hashMap));
    }

    public void a(final Handler handler, NotMoveBean notMoveBean) {
        Map hashMap = new HashMap();
        hashMap.put("body", this.d.toJson((Object) notMoveBean));
        hashMap.put("content-type", "application/json");
        hashMap.put("charset", CommonUtil.UTF8);
        String a = a("/sf/service/getNotMoveRegionByUser");
        k.a(a);
        b.add(new d(c, 1, a, NotMoveDataBean.class, new Listener<NotMoveDataBean>(this) {
            final /* synthetic */ a b;

            public /* synthetic */ void onResponse(Object obj) {
                a((NotMoveDataBean) obj);
            }

            public void a(NotMoveDataBean notMoveDataBean) {
                handler.obtainMessage(2000, notMoveDataBean).sendToTarget();
            }
        }, new com.jd.fridge.util.a.a(this, c) {
            final /* synthetic */ a b;

            public void a(VolleyError volleyError) {
                handler.sendEmptyMessage(2001);
            }
        }, hashMap));
    }

    public void a(final Handler handler, PicHistory picHistory) {
        Map hashMap = new HashMap();
        hashMap.put("body", this.d.toJson((Object) picHistory));
        hashMap.put("content-type", "application/json");
        hashMap.put("charset", CommonUtil.UTF8);
        String a = a("/sf/service/getPicHistory");
        k.a(a);
        b.add(new d(c, 1, a, GetPicHistoryDataBean.class, new Listener<GetPicHistoryDataBean>(this) {
            final /* synthetic */ a b;

            public /* synthetic */ void onResponse(Object obj) {
                a((GetPicHistoryDataBean) obj);
            }

            public void a(GetPicHistoryDataBean getPicHistoryDataBean) {
                handler.obtainMessage(2000, getPicHistoryDataBean).sendToTarget();
            }
        }, new com.jd.fridge.util.a.a(this, c) {
            final /* synthetic */ a b;

            public void a(VolleyError volleyError) {
                handler.sendEmptyMessage(2001);
            }
        }, hashMap));
    }

    public void a(final Handler handler, AddFriend addFriend) {
        Map hashMap = new HashMap();
        hashMap.put("body", this.d.toJson((Object) addFriend));
        hashMap.put("content-type", "application/json");
        hashMap.put("charset", CommonUtil.UTF8);
        String a = a("/sf/service/makeFriendByQr");
        k.a(a);
        b.add(new d(c, 1, a, ResponseDataBaseBean.class, new Listener<ResponseDataBaseBean>(this) {
            final /* synthetic */ a b;

            public /* synthetic */ void onResponse(Object obj) {
                a((ResponseDataBaseBean) obj);
            }

            public void a(ResponseDataBaseBean responseDataBaseBean) {
                handler.obtainMessage(2000, responseDataBaseBean).sendToTarget();
            }
        }, new com.jd.fridge.util.a.a(this, c) {
            final /* synthetic */ a b;

            public void a(VolleyError volleyError) {
                Object obj = "";
                if (volleyError.getMessage() != null) {
                    obj = volleyError.getMessage();
                }
                handler.obtainMessage(2001, obj).sendToTarget();
            }
        }, hashMap));
    }

    public void a(final Handler handler, FridgeStatus fridgeStatus, final String str) {
        Map hashMap = new HashMap();
        hashMap.put("body", this.d.toJson((Object) fridgeStatus));
        hashMap.put("content-type", "application/json");
        hashMap.put("charset", CommonUtil.UTF8);
        String a = a("/f/service/getStreamSnapshot");
        k.a(a);
        b.add(new d(c, 1, a, FridgeControlBaseBean.class, new Listener<FridgeControlBaseBean>(this) {
            final /* synthetic */ a b;

            public /* synthetic */ void onResponse(Object obj) {
                a((FridgeControlBaseBean) obj);
            }

            public void a(FridgeControlBaseBean fridgeControlBaseBean) {
                handler.obtainMessage(2000, fridgeControlBaseBean.getResult()).sendToTarget();
            }
        }, new com.jd.fridge.util.a.a(this, c) {
            final /* synthetic */ a b;

            public void a(VolleyError volleyError) {
                handler.sendEmptyMessage(2001);
            }
        }, hashMap, new com.jd.fridge.util.a.d.a(this) {
            final /* synthetic */ a c;

            public void a(String str) {
                Message obtainMessage = handler.obtainMessage();
                obtainMessage.what = 10007;
                Bundle bundle = new Bundle();
                bundle.putString("result", str);
                bundle.putString("responesId", str == null ? "" : str);
                obtainMessage.setData(bundle);
                obtainMessage.sendToTarget();
            }
        }));
    }

    public void a(final Handler handler, FridgeControlSendBean fridgeControlSendBean, final String str) {
        Map hashMap = new HashMap();
        hashMap.put("body", this.d.toJson((Object) fridgeControlSendBean));
        hashMap.put("content-type", "application/json");
        hashMap.put("charset", CommonUtil.UTF8);
        String a = a("/f/service/controlDevice");
        k.a(a);
        b.add(new d(c, 1, a, FridgeControlBaseBean.class, new Listener<FridgeControlBaseBean>(this) {
            final /* synthetic */ a a;

            {
                this.a = r1;
            }

            public /* synthetic */ void onResponse(Object obj) {
                a((FridgeControlBaseBean) obj);
            }

            public void a(FridgeControlBaseBean fridgeControlBaseBean) {
            }
        }, new com.jd.fridge.util.a.a(this, c) {
            final /* synthetic */ a a;

            public void a(VolleyError volleyError) {
            }
        }, hashMap, new com.jd.fridge.util.a.d.a(this) {
            final /* synthetic */ a c;

            public void a(String str) {
                Message obtainMessage = handler.obtainMessage();
                obtainMessage.what = 10008;
                Bundle bundle = new Bundle();
                bundle.putString("result", str);
                bundle.putString("responesId", str);
                obtainMessage.setData(bundle);
                obtainMessage.sendToTarget();
            }
        }));
    }

    public void a(final Handler handler, FridgeControlSendBean fridgeControlSendBean) {
        Map hashMap = new HashMap();
        hashMap.put("body", this.d.toJson((Object) fridgeControlSendBean));
        hashMap.put("content-type", "application/json");
        hashMap.put("charset", CommonUtil.UTF8);
        String a = a("/f/service/controlDevice");
        k.a(a);
        b.add(new d(c, 1, a, FridgeControlBaseBean.class, new Listener<FridgeControlBaseBean>(this) {
            final /* synthetic */ a b;

            public /* synthetic */ void onResponse(Object obj) {
                a((FridgeControlBaseBean) obj);
            }

            public void a(FridgeControlBaseBean fridgeControlBaseBean) {
                if (fridgeControlBaseBean.getStatus() == 0) {
                    handler.obtainMessage(4000, fridgeControlBaseBean.getResult()).sendToTarget();
                } else {
                    handler.obtainMessage(4001, fridgeControlBaseBean.getResult()).sendToTarget();
                }
            }
        }, new com.jd.fridge.util.a.a(this, c) {
            final /* synthetic */ a b;

            public void a(VolleyError volleyError) {
                if (volleyError.getMessage() == null) {
                    handler.obtainMessage(4001, "").sendToTarget();
                } else if (volleyError.getMessage().equals("2004")) {
                    handler.obtainMessage(4002, volleyError.getMessage()).sendToTarget();
                } else {
                    handler.obtainMessage(4001, volleyError.getMessage()).sendToTarget();
                }
            }
        }, hashMap));
    }

    public void a(final Handler handler, UpdateSendBean updateSendBean) {
        Map hashMap = new HashMap();
        hashMap.put("body", this.d.toJson((Object) updateSendBean));
        hashMap.put("content-type", "application/json");
        hashMap.put("charset", CommonUtil.UTF8);
        String a = a("/sf/service/hasNewAppVersion2");
        k.a(a);
        b.add(new d(c, 1, a, UpdateBaseBean.class, new Listener<UpdateBaseBean>(this) {
            final /* synthetic */ a b;

            public /* synthetic */ void onResponse(Object obj) {
                a((UpdateBaseBean) obj);
            }

            public void a(UpdateBaseBean updateBaseBean) {
                handler.obtainMessage(9000, updateBaseBean.getResult()).sendToTarget();
            }
        }, new com.jd.fridge.util.a.a(this, c) {
            final /* synthetic */ a b;

            public void a(VolleyError volleyError) {
                handler.sendEmptyMessage(9001);
            }
        }, hashMap));
    }

    public void a(final Handler handler, Share share) {
        Map hashMap = new HashMap();
        hashMap.put("body", this.d.toJson((Object) share));
        hashMap.put("content-type", "application/json");
        hashMap.put("charset", CommonUtil.UTF8);
        String a = a("/sf/service/leaveMessage");
        k.a(a);
        b.add(new d(c, 1, a, GetShareContentBean.class, new Listener<GetShareContentBean>(this) {
            final /* synthetic */ a b;

            public /* synthetic */ void onResponse(Object obj) {
                a((GetShareContentBean) obj);
            }

            public void a(GetShareContentBean getShareContentBean) {
                handler.obtainMessage(2018, getShareContentBean).sendToTarget();
            }
        }, new com.jd.fridge.util.a.a(this, c) {
            final /* synthetic */ a b;

            public void a(VolleyError volleyError) {
                handler.sendEmptyMessage(2019);
            }
        }, hashMap));
    }

    public void b(final Handler handler) {
        String str = "https://appfridge.jd.com/api/OauthCode/getCode.json";
        k.a(str);
        b.add(new d(c, 0, str, GetCodeBean.class, new Listener<GetCodeBean>(this) {
            final /* synthetic */ a b;

            public /* synthetic */ void onResponse(Object obj) {
                a((GetCodeBean) obj);
            }

            public void a(GetCodeBean getCodeBean) {
                handler.obtainMessage(7021, getCodeBean).sendToTarget();
            }
        }, new com.jd.fridge.util.a.a(this, c) {
            final /* synthetic */ a b;

            public void a(VolleyError volleyError) {
                handler.sendEmptyMessage(7022);
            }
        }, null));
    }

    public void c(final Handler handler) {
        Map hashMap = new HashMap();
        hashMap.put("content-type", "application/json");
        hashMap.put("charset", CommonUtil.UTF8);
        String a = a("/sf/service/queryCategories");
        k.a(a);
        r.c("infos", "url==" + a);
        b.add(new d(c, 1, a, FoodCategoryListDataBaseBean.class, new Listener<FoodCategoryListDataBaseBean>(this) {
            final /* synthetic */ a b;

            public /* synthetic */ void onResponse(Object obj) {
                a((FoodCategoryListDataBaseBean) obj);
            }

            public void a(FoodCategoryListDataBaseBean foodCategoryListDataBaseBean) {
                handler.obtainMessage(2000, foodCategoryListDataBaseBean.getResult()).sendToTarget();
            }
        }, new com.jd.fridge.util.a.a(this, c) {
            final /* synthetic */ a b;

            public void a(VolleyError volleyError) {
                handler.sendEmptyMessage(2001);
            }
        }, hashMap));
    }

    public void a(final Handler handler, ParamsFoodDishListBean paramsFoodDishListBean) {
        Map hashMap = new HashMap();
        hashMap.put("body", this.d.toJson((Object) paramsFoodDishListBean));
        hashMap.put("content-type", "application/json");
        hashMap.put("charset", CommonUtil.UTF8);
        String a = a("/sf/service/getGoodsListWithAlarmByUser");
        k.a(a);
        b.add(new d(c, 1, a, FoodDishListDataBaseBean.class, new Listener<FoodDishListDataBaseBean>(this) {
            final /* synthetic */ a b;

            public /* synthetic */ void onResponse(Object obj) {
                a((FoodDishListDataBaseBean) obj);
            }

            public void a(FoodDishListDataBaseBean foodDishListDataBaseBean) {
                handler.obtainMessage(7000, foodDishListDataBaseBean.getResult()).sendToTarget();
            }
        }, new com.jd.fridge.util.a.a(this, c) {
            final /* synthetic */ a b;

            public void a(VolleyError volleyError) {
                r.c("infos", "error.msg==" + volleyError.getMessage());
                handler.sendEmptyMessage(7001);
            }
        }, hashMap));
    }

    public void a(final Handler handler, ParamsCommonFoodDishListBean paramsCommonFoodDishListBean) {
        Map hashMap = new HashMap();
        String toJson = this.d.toJson((Object) paramsCommonFoodDishListBean);
        hashMap.put("body", toJson);
        hashMap.put("content-type", "application/json");
        hashMap.put("charset", CommonUtil.UTF8);
        String a = a("/sf/service/listCommonFoodsByUser");
        k.a(a);
        r.c("infos", "url-----" + a + "---body==" + toJson);
        b.add(new d(c, 1, a, FoodDishListDataBaseBean.class, new Listener<FoodDishListDataBaseBean>(this) {
            final /* synthetic */ a b;

            public /* synthetic */ void onResponse(Object obj) {
                a((FoodDishListDataBaseBean) obj);
            }

            public void a(FoodDishListDataBaseBean foodDishListDataBaseBean) {
                handler.obtainMessage(7002, foodDishListDataBaseBean.getResult()).sendToTarget();
            }
        }, new com.jd.fridge.util.a.a(this, c) {
            final /* synthetic */ a b;

            public void a(VolleyError volleyError) {
                r.c("infos", "error.msg==" + volleyError.getMessage());
                handler.sendEmptyMessage(7003);
            }
        }, hashMap));
    }

    public void a(final Handler handler, SearchText searchText) {
        Map hashMap = new HashMap();
        hashMap.put("body", this.d.toJson((Object) searchText));
        hashMap.put("content-type", "application/json");
        hashMap.put("charset", CommonUtil.UTF8);
        String a = a("/sf/service/goodRetrieval");
        k.a(a);
        b.add(new d(c, 1, a, SearchFoodsListBeanResult.class, new Listener<SearchFoodsListBeanResult>(this) {
            final /* synthetic */ a b;

            public /* synthetic */ void onResponse(Object obj) {
                a((SearchFoodsListBeanResult) obj);
            }

            public void a(SearchFoodsListBeanResult searchFoodsListBeanResult) {
                handler.obtainMessage(7004, searchFoodsListBeanResult.getResult()).sendToTarget();
            }
        }, new com.jd.fridge.util.a.a(this, c) {
            final /* synthetic */ a b;

            public void a(VolleyError volleyError) {
                r.a("infos", "error===" + volleyError.getMessage() + "error===----" + volleyError.networkResponse);
                handler.sendEmptyMessage(7005);
            }
        }, hashMap));
    }

    public void a(final Handler handler, AddGoodsList addGoodsList) {
        Map hashMap = new HashMap();
        String toJson = this.d.toJson((Object) addGoodsList);
        r.b("infos", "bodystr==" + toJson);
        hashMap.put("body", toJson);
        hashMap.put("content-type", "application/json");
        hashMap.put("charset", CommonUtil.UTF8);
        String a = a("/sf/service/settingGoodsAlarmBatchByUser");
        k.a(a);
        b.add(new d(c, 1, a, FoodDishListDataBaseBean.class, new Listener<FoodDishListDataBaseBean>(this) {
            final /* synthetic */ a b;

            public /* synthetic */ void onResponse(Object obj) {
                a((FoodDishListDataBaseBean) obj);
            }

            public void a(FoodDishListDataBaseBean foodDishListDataBaseBean) {
                List result = foodDishListDataBaseBean.getResult();
                if (foodDishListDataBaseBean.getError() != null && foodDishListDataBaseBean.getError().getErrorCode() == HttpConstants.NET_TIMEOUT_CODE) {
                    handler.obtainMessage(7008, result).sendToTarget();
                } else if (foodDishListDataBaseBean.getError() != null && foodDishListDataBaseBean.getError().getErrorCode() == 2011) {
                    handler.obtainMessage(7018, foodDishListDataBaseBean).sendToTarget();
                } else if (foodDishListDataBaseBean.getError() != null && foodDishListDataBaseBean.getError().getErrorCode() == 2007) {
                } else {
                    if (foodDishListDataBaseBean.getError() == null || foodDishListDataBaseBean.getError().getErrorCode() != 2008) {
                        handler.obtainMessage(7006, result).sendToTarget();
                    } else {
                        handler.obtainMessage(7020, foodDishListDataBaseBean).sendToTarget();
                    }
                }
            }
        }, new com.jd.fridge.util.a.a(this, c) {
            final /* synthetic */ a b;

            public void a(VolleyError volleyError) {
                handler.sendEmptyMessage(7007);
            }

            public void a(String str) {
                if (!TextUtils.isEmpty(str)) {
                    r.c("infos", "data==" + str);
                    try {
                        String string = new JSONObject(str).getJSONObject("error").getString("errorInfo");
                        handler.obtainMessage(7019, string).sendToTarget();
                        r.c("infos", "errorInfo==" + string);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }, hashMap));
    }

    public void a(final Handler handler, StreamsAndH5Info streamsAndH5Info) {
        Map hashMap = new HashMap();
        String toJson = this.d.toJson((Object) streamsAndH5Info);
        r.b("infos", "getStreamsAndH5.bodystr==" + toJson);
        hashMap.put("body", toJson);
        hashMap.put("content-type", "application/json");
        hashMap.put("charset", CommonUtil.UTF8);
        String a = a("/f/service/getStreamsAndH5Info");
        k.a(a);
        b.add(new d(c, 1, a, StreamsH5InfoBaseBean.class, new Listener<StreamsH5InfoBaseBean>(this) {
            final /* synthetic */ a b;

            public /* synthetic */ void onResponse(Object obj) {
                a((StreamsH5InfoBaseBean) obj);
            }

            public void a(StreamsH5InfoBaseBean streamsH5InfoBaseBean) {
                StreamsH5InfoDataBean streamsH5InfoDataBean = (StreamsH5InfoDataBean) this.b.d.fromJson(streamsH5InfoBaseBean.getResult(), StreamsH5InfoDataBean.class);
                if (streamsH5InfoDataBean != null && streamsH5InfoDataBean.getH5() != null && streamsH5InfoDataBean.getH5().getUrl() != null && handler != null) {
                    handler.obtainMessage(7006, streamsH5InfoDataBean.getH5().getUrl()).sendToTarget();
                } else if (handler != null) {
                    handler.sendEmptyMessage(7007);
                }
            }
        }, new com.jd.fridge.util.a.a(this, c) {
            final /* synthetic */ a b;

            public void a(VolleyError volleyError) {
                r.b("infos", "==msg==" + volleyError.getMessage());
                handler.sendEmptyMessage(7007);
            }
        }, hashMap));
    }

    public void d(final Handler handler) {
        String str = "https://appfridge.jd.com/api/recipe/hot_keys.json";
        k.a(str);
        b.add(new d(c, 0, str, MenuHotSearchListDataBaseBean.class, new Listener<MenuHotSearchListDataBaseBean>(this) {
            final /* synthetic */ a b;

            public /* synthetic */ void onResponse(Object obj) {
                a((MenuHotSearchListDataBaseBean) obj);
            }

            public void a(MenuHotSearchListDataBaseBean menuHotSearchListDataBaseBean) {
                handler.obtainMessage(7009, menuHotSearchListDataBaseBean).sendToTarget();
            }
        }, new com.jd.fridge.util.a.a(this, c) {
            final /* synthetic */ a b;

            public void a(VolleyError volleyError) {
                handler.sendEmptyMessage(7010);
            }
        }, null));
    }

    public void a(final Handler handler, String str) {
        String str2 = "https://appfridge.jd.com/api/recipe/search_tips.json";
        String str3 = "";
        try {
            str3 = URLEncoder.encode(str, CommonUtil.UTF8);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        StringBuilder stringBuilder = new StringBuilder(str2);
        stringBuilder.append(HttpUtils.URL_AND_PARA_SEPARATOR);
        stringBuilder.append("token=" + str3);
        String stringBuilder2 = stringBuilder.toString();
        k.a(stringBuilder2);
        b.add(new d(c, 0, stringBuilder2, MenuKeyWordsSearchListDataBaseBean.class, new Listener<MenuKeyWordsSearchListDataBaseBean>(this) {
            final /* synthetic */ a b;

            public /* synthetic */ void onResponse(Object obj) {
                a((MenuKeyWordsSearchListDataBaseBean) obj);
            }

            public void a(MenuKeyWordsSearchListDataBaseBean menuKeyWordsSearchListDataBaseBean) {
                handler.obtainMessage(7011, menuKeyWordsSearchListDataBaseBean).sendToTarget();
            }
        }, new com.jd.fridge.util.a.a(this, c) {
            final /* synthetic */ a b;

            public void a(VolleyError volleyError) {
                handler.sendEmptyMessage(7012);
            }
        }, null));
    }
}
