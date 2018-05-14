package com.jd.fridge.util;

import com.nostra13.universalimageloader.cache.disc.naming.FileNameGenerator;
import java.security.MessageDigest;

/* compiled from: TbsSdkJava */
public class m implements FileNameGenerator {
    public String generate(String str) {
        try {
            return y.a(MessageDigest.getInstance("MD5").digest(y.b(str)));
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }
}
