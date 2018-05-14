package com.kepler.sdk;

import android.text.TextUtils;
import android.util.Base64;
import com.google.zxing.common.StringUtils;
import com.jingdong.jdma.common.utils.CommonUtil;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.StreamCorruptedException;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Map;

/* compiled from: TbsSdkJava */
public class aq {
    public static boolean a(Object[] objArr) {
        if (objArr == null || objArr.length == 0) {
            return true;
        }
        return false;
    }

    public static boolean a(byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            return true;
        }
        return false;
    }

    public static boolean a(String str) {
        if (str == null || str.length() == 0) {
            return true;
        }
        return false;
    }

    public static boolean b(String str) {
        if (TextUtils.isEmpty(str)) {
            return true;
        }
        return "".equals(str);
    }

    public static boolean a(String str, String str2) {
        if (b(str2)) {
            return false;
        }
        if (str2.startsWith(str)) {
            return true;
        }
        if (str2.startsWith("http:")) {
            return str2.replace("http:", "https:").startsWith(str);
        }
        if (str2.startsWith("https:")) {
            return str2.replace("https:", "http:").startsWith(str);
        }
        if (("http://" + str2).startsWith(str) || (CommonUtil.URL_HEADER + str2).startsWith(str)) {
            return true;
        }
        return false;
    }

    public static String a(List<String> list) throws IOException {
        OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
        objectOutputStream.writeObject(list);
        String str = new String(Base64.encode(byteArrayOutputStream.toByteArray(), 0));
        objectOutputStream.close();
        return str;
    }

    public static List<String> c(String str) throws StreamCorruptedException, IOException, ClassNotFoundException {
        ObjectInputStream objectInputStream = new ObjectInputStream(new ByteArrayInputStream(Base64.decode(str.getBytes(), 0)));
        List<String> list = (List) objectInputStream.readObject();
        objectInputStream.close();
        return list;
    }

    public static boolean b(String str, String str2) {
        if (str2 == str) {
            return true;
        }
        if (str == null && str2 != null) {
            return false;
        }
        if (str.equals(str2)) {
            return true;
        }
        return false;
    }

    public static String a(byte[] bArr, String str) throws UnsupportedEncodingException {
        if (a(bArr)) {
            return null;
        }
        if (b(str)) {
            str = StringUtils.GB2312;
        }
        return new String(bArr, str);
    }

    public static boolean a(Map<String, String> map) {
        if (map == null || map.size() == 0) {
            return true;
        }
        return false;
    }
}
