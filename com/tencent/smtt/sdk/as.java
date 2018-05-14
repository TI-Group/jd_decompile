package com.tencent.smtt.sdk;

import java.io.File;
import java.io.FileFilter;

class as implements FileFilter {
    final /* synthetic */ ar a;

    as(ar arVar) {
        this.a = arVar;
    }

    public boolean accept(File file) {
        return file.getName().endsWith(".dex");
    }
}
