package org.apache.commons.lang;

import java.io.PrintWriter;
import java.io.StringWriter;

/* compiled from: TbsSdkJava */
class StringPrintWriter extends PrintWriter {
    public StringPrintWriter() {
        super(new StringWriter());
    }

    public StringPrintWriter(int i) {
        super(new StringWriter(i));
    }

    public String getString() {
        flush();
        return ((StringWriter) this.out).toString();
    }
}
