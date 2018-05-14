package com.nostra13.universalimageloader.cache.disc.naming;

/* compiled from: TbsSdkJava */
public class HashCodeFileNameGenerator implements FileNameGenerator {
    public String generate(String str) {
        return String.valueOf(str.hashCode());
    }
}
