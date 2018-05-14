package jd.wjlogin_sdk.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.StreamCorruptedException;

/* compiled from: TbsSdkJava */
public class LocalFileUtil {
    private static final String LOG_TAG = LocalFileUtil.class.getName();
    private static Context mcontext = null;
    private static SharedPreferences preferences = null;

    public static void initLocalFileUtil(Context context) {
        DecryptorJni.loadSo();
        if (preferences == null) {
            String jniUserFilename;
            mcontext = context;
            try {
                jniUserFilename = DecryptorJni.jniUserFilename(context);
            } catch (Exception e) {
                jniUserFilename = Config.LOCAL_FILENAME;
            }
            preferences = mcontext.getSharedPreferences(jniUserFilename, 0);
            if (!preferences.contains(Config.GUID_LOCALNAME) && !jniUserFilename.equals(Config.LOCAL_FILENAME)) {
                SharedPreferences sharedPreferences = mcontext.getSharedPreferences(Config.LOCAL_FILENAME, 0);
                Object string = sharedPreferences.getString(Config.GUID_LOCALNAME, null);
                if (!TextUtils.isEmpty(string)) {
                    Object string2 = sharedPreferences.getString(Config.USERINFO_LOCALNAME, null);
                    Object string3 = sharedPreferences.getString(Config.USERTOKENINFO_LOCALNAME, null);
                    if (!(TextUtils.isEmpty(string) && TextUtils.isEmpty(string2) && TextUtils.isEmpty(string3))) {
                        Editor edit = preferences.edit();
                        if (!TextUtils.isEmpty(string)) {
                            edit.putString(Config.GUID_LOCALNAME, string);
                        }
                        if (!TextUtils.isEmpty(string2)) {
                            edit.putString(Config.USERINFO_LOCALNAME, string2);
                        }
                        if (!TextUtils.isEmpty(string3)) {
                            edit.putString(Config.USERTOKENINFO_LOCALNAME, string3);
                        }
                        edit.commit();
                    }
                    sharedPreferences.edit().clear().commit();
                }
            }
        }
    }

    public static void deleteAllFiles() {
        String jniUserFilename;
        try {
            jniUserFilename = DecryptorJni.jniUserFilename(mcontext);
        } catch (Exception e) {
            jniUserFilename = Config.LOCAL_FILENAME;
        }
        if (jniUserFilename != null) {
            preferences = mcontext.getSharedPreferences(jniUserFilename, 0);
            preferences.edit().clear().commit();
        }
        SharedPreferences sharedPreferences = mcontext.getSharedPreferences(Config.LOCAL_FILENAME, 0);
        if (!TextUtils.isEmpty(sharedPreferences.getString(Config.GUID_LOCALNAME, null))) {
            sharedPreferences.edit().clear().commit();
        }
    }

    public static void setObject(String str, Object obj) {
        try {
            Editor edit = preferences.edit();
            OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            new ObjectOutputStream(byteArrayOutputStream).writeObject(obj);
            edit.putString(str, ByteUtil.parseByte2HexStr(byteArrayOutputStream.toByteArray()));
            edit.commit();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Object getObject(String str) {
        Object obj = null;
        try {
            if (preferences.contains(str)) {
                Object string = preferences.getString(str, null);
                if (!TextUtils.isEmpty(string)) {
                    obj = new ObjectInputStream(new ByteArrayInputStream(ByteUtil.parseHexStr2Byte(string))).readObject();
                }
            }
        } catch (StreamCorruptedException e) {
            e.printStackTrace();
        } catch (IOException e2) {
            e2.printStackTrace();
        } catch (ClassNotFoundException e3) {
            e3.printStackTrace();
        }
        return obj;
    }

    public static void setObjectJson(String str, Object obj) {
        try {
            Editor edit = preferences.edit();
            edit.putString(str, JSONHelper.toJSON(obj));
            edit.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static <T> Object getObjectJson(String str, Class<T> cls) {
        Object obj = null;
        try {
            if (preferences.contains(str)) {
                String string = preferences.getString(str, null);
                if (!TextUtils.isEmpty(string)) {
                    obj = JSONHelper.parseObject(string, (Class) cls);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return obj;
    }

    public static void setObjectJsonEncrypt(String str, Object obj) {
        try {
            Editor edit = preferences.edit();
            String toJSON = JSONHelper.toJSON(obj);
            LocalFileCryptor.getKey(mcontext);
            edit.putString(str, LocalFileCryptor.encrypt(toJSON));
            edit.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static <T> Object getObjectJsonDecrypt(String str, Class<T> cls) {
        Object obj = null;
        try {
            if (preferences.contains(str)) {
                Object string = preferences.getString(str, null);
                if (!TextUtils.isEmpty(string)) {
                    LocalFileCryptor.getKey(mcontext);
                    obj = JSONHelper.parseObject(LocalFileCryptor.decrypt(string), (Class) cls);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return obj;
    }
}
