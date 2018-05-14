package cn.jpush.android.d;

import android.text.TextUtils;
import java.util.ArrayList;
import org.json.JSONArray;

/* compiled from: TbsSdkJava */
public final class b {
    public static ArrayList<String> a(JSONArray jSONArray) {
        ArrayList<String> arrayList = new ArrayList();
        if (jSONArray == null || jSONArray.length() == 0) {
            return arrayList;
        }
        for (int i = 0; i < jSONArray.length(); i++) {
            CharSequence optString = jSONArray.optString(i);
            if (!TextUtils.isEmpty(optString)) {
                arrayList.add(optString);
            }
        }
        return arrayList;
    }
}
