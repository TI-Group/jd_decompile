package com.jd.fridge.util;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import android.view.WindowManager.LayoutParams;
import com.jd.fridge.HomeActivity;
import com.jd.fridge.PrivacyPolicyActivity;
import com.jd.fridge.favorMenu.MenuActivity;
import com.jd.fridge.favorMenu.MenuCategoryActivity;
import com.jd.fridge.favorMenu.MenuCategorySecondActivity;
import com.jd.fridge.favorMenu.MenuSearchActivity;
import com.jd.fridge.favorMenu.MenuSecondActivity;
import com.jd.fridge.food.FoodAddAlarmActivity;
import com.jd.fridge.food.SearchFoodActivity;
import com.jd.fridge.login.LoginActivity;
import com.jd.fridge.notice.FoodNoticeActivity;
import com.jd.fridge.nutrition.NutritionActivity;
import com.jd.fridge.switchFridge.SwitchFridgeActivity;
import com.tencent.smtt.utils.TbsLog;
import java.util.ArrayList;
import java.util.List;

/* compiled from: TbsSdkJava */
public final class aa {
    public static void a(Activity activity, boolean z) {
        Intent intent = new Intent(activity, SwitchFridgeActivity.class);
        intent.putExtra("SWITCH_FRIDGE_VIEW_MODE", z);
        activity.startActivityForResult(intent, TbsLog.TBSLOG_CODE_SDK_INIT);
    }

    public static void a(Activity activity) {
        activity.startActivity(new Intent(activity, HomeActivity.class));
    }

    public static void b(Activity activity) {
        activity.startActivity(new Intent(activity, LoginActivity.class));
    }

    public static void a(Activity activity, int i, String str) {
        Intent intent = new Intent(activity, PrivacyPolicyActivity.class);
        intent.putExtra("style", i);
        if (!TextUtils.isEmpty(str)) {
            intent.putExtra("FEED_ID_JSON_STRING", str);
        }
        activity.startActivity(intent);
    }

    public static void c(Activity activity) {
        activity.startActivity(new Intent(activity, NutritionActivity.class));
    }

    public static void d(Activity activity) {
        activity.startActivity(new Intent(activity, FoodNoticeActivity.class));
    }

    public static void b(Activity activity, int i, String str) {
        Intent intent = new Intent(activity, MenuActivity.class);
        intent.putExtra("api_name", "detail");
        intent.putExtra("menu_id", String.valueOf(i));
        intent.putExtra("title_text", str);
        activity.startActivity(intent);
    }

    public static void a(Activity activity, String str) {
        Intent intent = new Intent(activity, MenuSecondActivity.class);
        intent.putExtra("second_url", str);
        activity.startActivity(intent);
    }

    public static void e(Activity activity) {
        activity.startActivity(new Intent(activity, MenuCategoryActivity.class));
    }

    public static void b(Activity activity, String str) {
        Intent intent = new Intent(activity, MenuCategorySecondActivity.class);
        intent.putExtra("category_second_url", str);
        activity.startActivity(intent);
    }

    public static void f(Activity activity) {
        activity.startActivity(new Intent(activity, MenuSearchActivity.class));
    }

    public static void g(Activity activity) {
        activity.startActivityForResult(new Intent(activity, FoodAddAlarmActivity.class), 10000);
    }

    public static void h(Activity activity) {
        activity.startActivityForResult(new Intent(activity, SearchFoodActivity.class), 10001);
    }

    public static void a(Activity activity, float f) {
        LayoutParams attributes = activity.getWindow().getAttributes();
        attributes.alpha = f;
        activity.getWindow().setAttributes(attributes);
    }

    public static List<String> a(boolean z) {
        int i = 1;
        List<String> arrayList = new ArrayList();
        if (z) {
            while (i <= 360) {
                arrayList.add(i + "");
                i++;
            }
        } else {
            while (i <= 12) {
                arrayList.add(i + "");
                i++;
            }
        }
        return arrayList;
    }
}
