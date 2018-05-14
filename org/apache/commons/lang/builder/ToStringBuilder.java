package org.apache.commons.lang.builder;

import org.apache.commons.lang.BooleanUtils;
import org.apache.commons.lang.ObjectUtils;

/* compiled from: TbsSdkJava */
public class ToStringBuilder {
    private static ToStringStyle defaultStyle = ToStringStyle.DEFAULT_STYLE;
    private final StringBuffer buffer;
    private final Object object;
    private final ToStringStyle style;

    public static ToStringStyle getDefaultStyle() {
        return defaultStyle;
    }

    public static String reflectionToString(Object obj) {
        return ReflectionToStringBuilder.toString(obj);
    }

    public static String reflectionToString(Object obj, ToStringStyle toStringStyle) {
        return ReflectionToStringBuilder.toString(obj, toStringStyle);
    }

    public static String reflectionToString(Object obj, ToStringStyle toStringStyle, boolean z) {
        return ReflectionToStringBuilder.toString(obj, toStringStyle, z, null);
    }

    public static String reflectionToString(Object obj, ToStringStyle toStringStyle, boolean z, Class cls) {
        return ReflectionToStringBuilder.toString(obj, toStringStyle, z, cls);
    }

    public static void setDefaultStyle(ToStringStyle toStringStyle) {
        if (toStringStyle == null) {
            throw new IllegalArgumentException("The style must not be null");
        }
        defaultStyle = toStringStyle;
    }

    public ToStringBuilder(Object obj) {
        this(obj, getDefaultStyle(), null);
    }

    public ToStringBuilder(Object obj, ToStringStyle toStringStyle) {
        this(obj, toStringStyle, null);
    }

    public ToStringBuilder(Object obj, ToStringStyle toStringStyle, StringBuffer stringBuffer) {
        if (obj == null) {
            throw new IllegalArgumentException("The object to create a toString for must not be null");
        }
        if (toStringStyle == null) {
            toStringStyle = getDefaultStyle();
        }
        if (stringBuffer == null) {
            stringBuffer = new StringBuffer(512);
        }
        this.buffer = stringBuffer;
        this.style = toStringStyle;
        this.object = obj;
        toStringStyle.appendStart(stringBuffer, obj);
    }

    public ToStringBuilder append(boolean z) {
        this.style.append(this.buffer, null, z);
        return this;
    }

    public ToStringBuilder append(boolean[] zArr) {
        this.style.append(this.buffer, null, zArr, null);
        return this;
    }

    public ToStringBuilder append(byte b) {
        this.style.append(this.buffer, null, b);
        return this;
    }

    public ToStringBuilder append(byte[] bArr) {
        this.style.append(this.buffer, null, bArr, null);
        return this;
    }

    public ToStringBuilder append(char c) {
        this.style.append(this.buffer, null, c);
        return this;
    }

    public ToStringBuilder append(char[] cArr) {
        this.style.append(this.buffer, null, cArr, null);
        return this;
    }

    public ToStringBuilder append(double d) {
        this.style.append(this.buffer, null, d);
        return this;
    }

    public ToStringBuilder append(double[] dArr) {
        this.style.append(this.buffer, null, dArr, null);
        return this;
    }

    public ToStringBuilder append(float f) {
        this.style.append(this.buffer, null, f);
        return this;
    }

    public ToStringBuilder append(float[] fArr) {
        this.style.append(this.buffer, null, fArr, null);
        return this;
    }

    public ToStringBuilder append(int i) {
        this.style.append(this.buffer, null, i);
        return this;
    }

    public ToStringBuilder append(int[] iArr) {
        this.style.append(this.buffer, null, iArr, null);
        return this;
    }

    public ToStringBuilder append(long j) {
        this.style.append(this.buffer, null, j);
        return this;
    }

    public ToStringBuilder append(long[] jArr) {
        this.style.append(this.buffer, null, jArr, null);
        return this;
    }

    public ToStringBuilder append(Object obj) {
        this.style.append(this.buffer, null, obj, null);
        return this;
    }

    public ToStringBuilder append(Object[] objArr) {
        this.style.append(this.buffer, null, objArr, null);
        return this;
    }

    public ToStringBuilder append(short s) {
        this.style.append(this.buffer, null, s);
        return this;
    }

    public ToStringBuilder append(short[] sArr) {
        this.style.append(this.buffer, null, sArr, null);
        return this;
    }

    public ToStringBuilder append(String str, boolean z) {
        this.style.append(this.buffer, str, z);
        return this;
    }

    public ToStringBuilder append(String str, boolean[] zArr) {
        this.style.append(this.buffer, str, zArr, null);
        return this;
    }

    public ToStringBuilder append(String str, boolean[] zArr, boolean z) {
        this.style.append(this.buffer, str, zArr, BooleanUtils.toBooleanObject(z));
        return this;
    }

    public ToStringBuilder append(String str, byte b) {
        this.style.append(this.buffer, str, b);
        return this;
    }

    public ToStringBuilder append(String str, byte[] bArr) {
        this.style.append(this.buffer, str, bArr, null);
        return this;
    }

    public ToStringBuilder append(String str, byte[] bArr, boolean z) {
        this.style.append(this.buffer, str, bArr, BooleanUtils.toBooleanObject(z));
        return this;
    }

    public ToStringBuilder append(String str, char c) {
        this.style.append(this.buffer, str, c);
        return this;
    }

    public ToStringBuilder append(String str, char[] cArr) {
        this.style.append(this.buffer, str, cArr, null);
        return this;
    }

    public ToStringBuilder append(String str, char[] cArr, boolean z) {
        this.style.append(this.buffer, str, cArr, BooleanUtils.toBooleanObject(z));
        return this;
    }

    public ToStringBuilder append(String str, double d) {
        this.style.append(this.buffer, str, d);
        return this;
    }

    public ToStringBuilder append(String str, double[] dArr) {
        this.style.append(this.buffer, str, dArr, null);
        return this;
    }

    public ToStringBuilder append(String str, double[] dArr, boolean z) {
        this.style.append(this.buffer, str, dArr, BooleanUtils.toBooleanObject(z));
        return this;
    }

    public ToStringBuilder append(String str, float f) {
        this.style.append(this.buffer, str, f);
        return this;
    }

    public ToStringBuilder append(String str, float[] fArr) {
        this.style.append(this.buffer, str, fArr, null);
        return this;
    }

    public ToStringBuilder append(String str, float[] fArr, boolean z) {
        this.style.append(this.buffer, str, fArr, BooleanUtils.toBooleanObject(z));
        return this;
    }

    public ToStringBuilder append(String str, int i) {
        this.style.append(this.buffer, str, i);
        return this;
    }

    public ToStringBuilder append(String str, int[] iArr) {
        this.style.append(this.buffer, str, iArr, null);
        return this;
    }

    public ToStringBuilder append(String str, int[] iArr, boolean z) {
        this.style.append(this.buffer, str, iArr, BooleanUtils.toBooleanObject(z));
        return this;
    }

    public ToStringBuilder append(String str, long j) {
        this.style.append(this.buffer, str, j);
        return this;
    }

    public ToStringBuilder append(String str, long[] jArr) {
        this.style.append(this.buffer, str, jArr, null);
        return this;
    }

    public ToStringBuilder append(String str, long[] jArr, boolean z) {
        this.style.append(this.buffer, str, jArr, BooleanUtils.toBooleanObject(z));
        return this;
    }

    public ToStringBuilder append(String str, Object obj) {
        this.style.append(this.buffer, str, obj, null);
        return this;
    }

    public ToStringBuilder append(String str, Object obj, boolean z) {
        this.style.append(this.buffer, str, obj, BooleanUtils.toBooleanObject(z));
        return this;
    }

    public ToStringBuilder append(String str, Object[] objArr) {
        this.style.append(this.buffer, str, objArr, null);
        return this;
    }

    public ToStringBuilder append(String str, Object[] objArr, boolean z) {
        this.style.append(this.buffer, str, objArr, BooleanUtils.toBooleanObject(z));
        return this;
    }

    public ToStringBuilder append(String str, short s) {
        this.style.append(this.buffer, str, s);
        return this;
    }

    public ToStringBuilder append(String str, short[] sArr) {
        this.style.append(this.buffer, str, sArr, null);
        return this;
    }

    public ToStringBuilder append(String str, short[] sArr, boolean z) {
        this.style.append(this.buffer, str, sArr, BooleanUtils.toBooleanObject(z));
        return this;
    }

    public ToStringBuilder appendAsObjectToString(Object obj) {
        ObjectUtils.appendIdentityToString(getStringBuffer(), obj);
        return this;
    }

    public ToStringBuilder appendSuper(String str) {
        if (str != null) {
            this.style.appendSuper(this.buffer, str);
        }
        return this;
    }

    public ToStringBuilder appendToString(String str) {
        if (str != null) {
            this.style.appendToString(this.buffer, str);
        }
        return this;
    }

    public StringBuffer getStringBuffer() {
        return this.buffer;
    }

    public ToStringStyle getStyle() {
        return this.style;
    }

    public String toString() {
        this.style.appendEnd(this.buffer, this.object);
        return this.buffer.toString();
    }

    public Object getObject() {
        return this.object;
    }
}
