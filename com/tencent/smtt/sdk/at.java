package com.tencent.smtt.sdk;

import java.io.File;
import java.io.FileFilter;

class at implements FileFilter {
    final /* synthetic */ ar a;

    at(ar arVar) {
        this.a = arVar;
    }

    public boolean accept(File file) {
        return file.getName().endsWith("tbs.conf");
    }
}
