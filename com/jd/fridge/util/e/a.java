package com.jd.fridge.util.e;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.SharedPreferences.OnSharedPreferenceChangeListener;
import android.provider.Settings.Secure;
import android.text.TextUtils;
import android.util.Base64;
import com.jd.fridge.GlobalVariable;
import com.jd.fridge.util.r;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;
import org.apache.http.protocol.HTTP;

/* compiled from: TbsSdkJava */
public class a implements SharedPreferences {
    private SharedPreferences a;
    private byte[] b;

    /* compiled from: TbsSdkJava */
    public class a implements Editor {
        final /* synthetic */ a a;
        private Editor b;

        private a(a aVar) {
            this.a = aVar;
            if (aVar.a != null) {
                this.b = aVar.a.edit();
            }
        }

        public Editor putString(String str, String str2) {
            this.b.putString(this.a.a(str), this.a.a(str2));
            return this;
        }

        @TargetApi(11)
        public Editor putStringSet(String str, Set<String> set) {
            Set hashSet = new HashSet(set.size());
            for (String a : set) {
                hashSet.add(this.a.a(a));
            }
            this.b.putStringSet(this.a.a(str), hashSet);
            return this;
        }

        public Editor putInt(String str, int i) {
            this.b.putString(this.a.a(str), this.a.a(Integer.toString(i)));
            return this;
        }

        public Editor putLong(String str, long j) {
            this.b.putString(this.a.a(str), this.a.a(Long.toString(j)));
            return this;
        }

        public Editor putFloat(String str, float f) {
            this.b.putString(this.a.a(str), this.a.a(Float.toString(f)));
            return this;
        }

        public Editor putBoolean(String str, boolean z) {
            this.b.putString(this.a.a(str), this.a.a(Boolean.toString(z)));
            return this;
        }

        public Editor remove(String str) {
            this.b.remove(this.a.a(str));
            return this;
        }

        public Editor clear() {
            this.b.clear();
            return this;
        }

        public boolean commit() {
            return this.b.commit();
        }

        @TargetApi(9)
        public void apply() {
            this.b.apply();
        }
    }

    public /* synthetic */ Editor edit() {
        return a();
    }

    public a(String str, int i) {
        this.a = GlobalVariable.B().getSharedPreferences(str, i);
        try {
            String a = a(GlobalVariable.B());
            String string = this.a.getString(a, null);
            if (string == null) {
                string = b();
                this.a.edit().putString(a, string).commit();
            }
            this.b = c(string);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Map<String, String> getAll() {
        Map all = this.a.getAll();
        Map<String, String> hashMap = new HashMap(all.size());
        for (Entry entry : all.entrySet()) {
            try {
                hashMap.put(b((String) entry.getKey()), b(entry.getValue().toString()));
            } catch (Exception e) {
            }
        }
        return hashMap;
    }

    public String getString(String str, String str2) {
        String string = this.a.getString(a(str), null);
        return string != null ? b(string) : str2;
    }

    @TargetApi(11)
    public Set<String> getStringSet(String str, Set<String> set) {
        Set<String> stringSet = this.a.getStringSet(a(str), null);
        if (stringSet != null) {
            set = new HashSet(stringSet.size());
            for (String b : stringSet) {
                set.add(b(b));
            }
        }
        return set;
    }

    public int getInt(String str, int i) {
        String string = this.a.getString(a(str), null);
        if (string != null) {
            try {
                i = Integer.parseInt(b(string));
            } catch (NumberFormatException e) {
                throw new ClassCastException(e.getMessage());
            }
        }
        return i;
    }

    public long getLong(String str, long j) {
        String string = this.a.getString(a(str), null);
        if (!(TextUtils.isEmpty(string) || "null".equals(string.toLowerCase().trim()))) {
            try {
                j = Long.parseLong(b(string));
            } catch (NumberFormatException e) {
                throw new ClassCastException(e.getMessage());
            }
        }
        return j;
    }

    public float getFloat(String str, float f) {
        String string = this.a.getString(a(str), null);
        if (string != null) {
            try {
                f = Float.parseFloat(b(string));
            } catch (NumberFormatException e) {
                throw new ClassCastException(e.getMessage());
            }
        }
        return f;
    }

    public boolean getBoolean(String str, boolean z) {
        String str2 = null;
        if (this.a != null) {
            str2 = this.a.getString(a(str), null);
        }
        if (str2 != null) {
            try {
                z = Boolean.parseBoolean(b(str2));
            } catch (NumberFormatException e) {
                throw new ClassCastException(e.getMessage());
            }
        }
        return z;
    }

    public boolean contains(String str) {
        return this.a.contains(a(str));
    }

    public a a() {
        return new a();
    }

    public void registerOnSharedPreferenceChangeListener(OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        this.a.registerOnSharedPreferenceChangeListener(onSharedPreferenceChangeListener);
    }

    public void unregisterOnSharedPreferenceChangeListener(OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        this.a.unregisterOnSharedPreferenceChangeListener(onSharedPreferenceChangeListener);
    }

    private String a(Context context) throws InvalidKeySpecException, NoSuchAlgorithmException {
        return a(SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1").generateSecret(new PBEKeySpec(context.getPackageName().toCharArray(), Secure.getString(context.getContentResolver(), "android_id").getBytes(), 1000, 256)).getEncoded());
    }

    private String b() throws NoSuchAlgorithmException {
        SecureRandom secureRandom = new SecureRandom();
        KeyGenerator instance = KeyGenerator.getInstance("AES");
        try {
            instance.init(256, secureRandom);
        } catch (Exception e) {
            try {
                instance.init(192, secureRandom);
            } catch (Exception e2) {
                instance.init(128, secureRandom);
            }
        }
        return a(instance.generateKey().getEncoded());
    }

    private String a(String str) {
        if (str == null || str.length() == 0) {
            return str;
        }
        try {
            Cipher instance = Cipher.getInstance("AES");
            instance.init(1, new SecretKeySpec(this.b, "AES"));
            return a(instance.doFinal(str.getBytes(HTTP.UTF_8)));
        } catch (Throwable e) {
            r.b(a.class.getName(), "encrypt", e);
            return null;
        }
    }

    private String b(String str) {
        if (str == null || str.length() == 0) {
            return str;
        }
        try {
            Cipher instance = Cipher.getInstance("AES");
            instance.init(2, new SecretKeySpec(this.b, "AES"));
            return new String(instance.doFinal(c(str)), HTTP.UTF_8);
        } catch (Throwable e) {
            r.b(a.class.getName(), "decrypt", e);
            return null;
        }
    }

    private String a(byte[] bArr) {
        return Base64.encodeToString(bArr, 3);
    }

    private byte[] c(String str) {
        return Base64.decode(str, 3);
    }
}
