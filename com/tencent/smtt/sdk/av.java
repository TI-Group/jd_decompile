package com.tencent.smtt.sdk;

import java.io.File;
import java.io.FileFilter;

class av implements FileFilter {
    final /* synthetic */ ao a;

    av(ao aoVar) {
        this.a = aoVar;
    }

    public boolean accept(File file) {
        return file.getName().endsWith(".jar");
    }
}
