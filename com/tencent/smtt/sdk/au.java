package com.tencent.smtt.sdk;

import java.io.File;
import java.io.FileFilter;

class au implements FileFilter {
    final /* synthetic */ ao a;

    au(ao aoVar) {
        this.a = aoVar;
    }

    public boolean accept(File file) {
        return file.getName().endsWith(".jar");
    }
}
