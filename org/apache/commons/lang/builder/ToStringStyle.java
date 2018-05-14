package org.apache.commons.lang.builder;

import cn.jiguang.net.HttpUtils;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Map;
import org.apache.commons.lang.ClassUtils;
import org.apache.commons.lang.ObjectUtils;
import org.apache.commons.lang.SystemUtils;

/* compiled from: TbsSdkJava */
public abstract class ToStringStyle implements Serializable {
    public static final ToStringStyle DEFAULT_STYLE = new DefaultToStringStyle(null);
    public static final ToStringStyle MULTI_LINE_STYLE = new MultiLineToStringStyle(null);
    public static final ToStringStyle NO_FIELD_NAMES_STYLE = new NoFieldNameToStringStyle(null);
    public static final ToStringStyle SIMPLE_STYLE = new SimpleToStringStyle(null);
    private boolean arrayContentDetail = true;
    private String arrayEnd = "}";
    private String arraySeparator = ",";
    private String arrayStart = "{";
    private String contentEnd = "]";
    private String contentStart = "[";
    private boolean defaultFullDetail = true;
    private String fieldNameValueSeparator = HttpUtils.EQUAL_SIGN;
    private String fieldSeparator = ",";
    private boolean fieldSeparatorAtEnd = false;
    private boolean fieldSeparatorAtStart = false;
    private String nullText = "<null>";
    private String sizeEndText = ">";
    private String sizeStartText = "<size=";
    private String summaryObjectEndText = ">";
    private String summaryObjectStartText = "<";
    private boolean useClassName = true;
    private boolean useFieldNames = true;
    private boolean useIdentityHashCode = true;
    private boolean useShortClassName = false;

    /* compiled from: TbsSdkJava */
    /* renamed from: org.apache.commons.lang.builder.ToStringStyle$1 */
    static class AnonymousClass1 {
    }

    /* compiled from: TbsSdkJava */
    private static final class DefaultToStringStyle extends ToStringStyle {
        DefaultToStringStyle(AnonymousClass1 anonymousClass1) {
            this();
        }

        private DefaultToStringStyle() {
        }

        private Object readResolve() {
            return ToStringStyle.DEFAULT_STYLE;
        }
    }

    /* compiled from: TbsSdkJava */
    private static final class MultiLineToStringStyle extends ToStringStyle {
        MultiLineToStringStyle(AnonymousClass1 anonymousClass1) {
            this();
        }

        private MultiLineToStringStyle() {
            setContentStart("[");
            setFieldSeparator(new StringBuffer().append(SystemUtils.LINE_SEPARATOR).append("  ").toString());
            setFieldSeparatorAtStart(true);
            setContentEnd(new StringBuffer().append(SystemUtils.LINE_SEPARATOR).append("]").toString());
        }

        private Object readResolve() {
            return ToStringStyle.MULTI_LINE_STYLE;
        }
    }

    /* compiled from: TbsSdkJava */
    private static final class NoFieldNameToStringStyle extends ToStringStyle {
        NoFieldNameToStringStyle(AnonymousClass1 anonymousClass1) {
            this();
        }

        private NoFieldNameToStringStyle() {
            setUseFieldNames(false);
        }

        private Object readResolve() {
            return ToStringStyle.NO_FIELD_NAMES_STYLE;
        }
    }

    /* compiled from: TbsSdkJava */
    private static final class SimpleToStringStyle extends ToStringStyle {
        SimpleToStringStyle(AnonymousClass1 anonymousClass1) {
            this();
        }

        private SimpleToStringStyle() {
            setUseClassName(false);
            setUseIdentityHashCode(false);
            setUseFieldNames(false);
            setContentStart("");
            setContentEnd("");
        }

        private Object readResolve() {
            return ToStringStyle.SIMPLE_STYLE;
        }
    }

    protected ToStringStyle() {
    }

    public void appendSuper(StringBuffer stringBuffer, String str) {
        appendToString(stringBuffer, str);
    }

    public void appendToString(StringBuffer stringBuffer, String str) {
        if (str != null) {
            int indexOf = str.indexOf(this.contentStart) + this.contentStart.length();
            int lastIndexOf = str.lastIndexOf(this.contentEnd);
            if (indexOf != lastIndexOf && indexOf >= 0 && lastIndexOf >= 0) {
                String substring = str.substring(indexOf, lastIndexOf);
                if (this.fieldSeparatorAtStart) {
                    removeLastFieldSeparator(stringBuffer);
                }
                stringBuffer.append(substring);
                appendFieldSeparator(stringBuffer);
            }
        }
    }

    public void appendStart(StringBuffer stringBuffer, Object obj) {
        appendClassName(stringBuffer, obj);
        appendIdentityHashCode(stringBuffer, obj);
        appendContentStart(stringBuffer);
        if (this.fieldSeparatorAtStart) {
            appendFieldSeparator(stringBuffer);
        }
    }

    public void appendEnd(StringBuffer stringBuffer, Object obj) {
        if (!this.fieldSeparatorAtEnd) {
            removeLastFieldSeparator(stringBuffer);
        }
        appendContentEnd(stringBuffer);
    }

    protected void removeLastFieldSeparator(StringBuffer stringBuffer) {
        Object obj = null;
        int length = stringBuffer.length();
        int length2 = this.fieldSeparator.length();
        if (length > 0 && length2 > 0 && length >= length2) {
            for (int i = 0; i < length2; i++) {
                if (stringBuffer.charAt((length - 1) - i) != this.fieldSeparator.charAt((length2 - 1) - i)) {
                    break;
                }
            }
            int i2 = 1;
            if (obj != null) {
                stringBuffer.setLength(length - length2);
            }
        }
    }

    public void append(StringBuffer stringBuffer, String str, Object obj, Boolean bool) {
        appendFieldStart(stringBuffer, str);
        if (obj == null) {
            appendNullText(stringBuffer, str);
        } else {
            appendInternal(stringBuffer, str, obj, isFullDetail(bool));
        }
        appendFieldEnd(stringBuffer, str);
    }

    protected void appendInternal(StringBuffer stringBuffer, String str, Object obj, boolean z) {
        if (ReflectionToStringBuilder.isRegistered(obj) && !(obj instanceof Number) && !(obj instanceof Boolean) && !(obj instanceof Character)) {
            ObjectUtils.appendIdentityToString(stringBuffer, obj);
        } else if (obj instanceof Collection) {
            if (z) {
                appendDetail(stringBuffer, str, (Collection) obj);
            } else {
                appendSummarySize(stringBuffer, str, ((Collection) obj).size());
            }
        } else if (obj instanceof Map) {
            if (z) {
                appendDetail(stringBuffer, str, (Map) obj);
            } else {
                appendSummarySize(stringBuffer, str, ((Map) obj).size());
            }
        } else if (obj instanceof long[]) {
            if (z) {
                appendDetail(stringBuffer, str, (long[]) obj);
            } else {
                appendSummary(stringBuffer, str, (long[]) obj);
            }
        } else if (obj instanceof int[]) {
            if (z) {
                appendDetail(stringBuffer, str, (int[]) obj);
            } else {
                appendSummary(stringBuffer, str, (int[]) obj);
            }
        } else if (obj instanceof short[]) {
            if (z) {
                appendDetail(stringBuffer, str, (short[]) obj);
            } else {
                appendSummary(stringBuffer, str, (short[]) obj);
            }
        } else if (obj instanceof byte[]) {
            if (z) {
                appendDetail(stringBuffer, str, (byte[]) obj);
            } else {
                appendSummary(stringBuffer, str, (byte[]) obj);
            }
        } else if (obj instanceof char[]) {
            if (z) {
                appendDetail(stringBuffer, str, (char[]) obj);
            } else {
                appendSummary(stringBuffer, str, (char[]) obj);
            }
        } else if (obj instanceof double[]) {
            if (z) {
                appendDetail(stringBuffer, str, (double[]) obj);
            } else {
                appendSummary(stringBuffer, str, (double[]) obj);
            }
        } else if (obj instanceof float[]) {
            if (z) {
                appendDetail(stringBuffer, str, (float[]) obj);
            } else {
                appendSummary(stringBuffer, str, (float[]) obj);
            }
        } else if (obj instanceof boolean[]) {
            if (z) {
                appendDetail(stringBuffer, str, (boolean[]) obj);
            } else {
                appendSummary(stringBuffer, str, (boolean[]) obj);
            }
        } else if (obj.getClass().isArray()) {
            if (z) {
                appendDetail(stringBuffer, str, (Object[]) obj);
            } else {
                appendSummary(stringBuffer, str, (Object[]) obj);
            }
        } else if (z) {
            appendDetail(stringBuffer, str, obj);
        } else {
            appendSummary(stringBuffer, str, obj);
        }
    }

    protected void appendDetail(StringBuffer stringBuffer, String str, Object obj) {
        stringBuffer.append(obj);
    }

    protected void appendDetail(StringBuffer stringBuffer, String str, Collection collection) {
        stringBuffer.append(collection);
    }

    protected void appendDetail(StringBuffer stringBuffer, String str, Map map) {
        stringBuffer.append(map);
    }

    protected void appendSummary(StringBuffer stringBuffer, String str, Object obj) {
        stringBuffer.append(this.summaryObjectStartText);
        stringBuffer.append(getShortClassName(obj.getClass()));
        stringBuffer.append(this.summaryObjectEndText);
    }

    public void append(StringBuffer stringBuffer, String str, long j) {
        appendFieldStart(stringBuffer, str);
        appendDetail(stringBuffer, str, j);
        appendFieldEnd(stringBuffer, str);
    }

    protected void appendDetail(StringBuffer stringBuffer, String str, long j) {
        stringBuffer.append(j);
    }

    public void append(StringBuffer stringBuffer, String str, int i) {
        appendFieldStart(stringBuffer, str);
        appendDetail(stringBuffer, str, i);
        appendFieldEnd(stringBuffer, str);
    }

    protected void appendDetail(StringBuffer stringBuffer, String str, int i) {
        stringBuffer.append(i);
    }

    public void append(StringBuffer stringBuffer, String str, short s) {
        appendFieldStart(stringBuffer, str);
        appendDetail(stringBuffer, str, s);
        appendFieldEnd(stringBuffer, str);
    }

    protected void appendDetail(StringBuffer stringBuffer, String str, short s) {
        stringBuffer.append(s);
    }

    public void append(StringBuffer stringBuffer, String str, byte b) {
        appendFieldStart(stringBuffer, str);
        appendDetail(stringBuffer, str, b);
        appendFieldEnd(stringBuffer, str);
    }

    protected void appendDetail(StringBuffer stringBuffer, String str, byte b) {
        stringBuffer.append(b);
    }

    public void append(StringBuffer stringBuffer, String str, char c) {
        appendFieldStart(stringBuffer, str);
        appendDetail(stringBuffer, str, c);
        appendFieldEnd(stringBuffer, str);
    }

    protected void appendDetail(StringBuffer stringBuffer, String str, char c) {
        stringBuffer.append(c);
    }

    public void append(StringBuffer stringBuffer, String str, double d) {
        appendFieldStart(stringBuffer, str);
        appendDetail(stringBuffer, str, d);
        appendFieldEnd(stringBuffer, str);
    }

    protected void appendDetail(StringBuffer stringBuffer, String str, double d) {
        stringBuffer.append(d);
    }

    public void append(StringBuffer stringBuffer, String str, float f) {
        appendFieldStart(stringBuffer, str);
        appendDetail(stringBuffer, str, f);
        appendFieldEnd(stringBuffer, str);
    }

    protected void appendDetail(StringBuffer stringBuffer, String str, float f) {
        stringBuffer.append(f);
    }

    public void append(StringBuffer stringBuffer, String str, boolean z) {
        appendFieldStart(stringBuffer, str);
        appendDetail(stringBuffer, str, z);
        appendFieldEnd(stringBuffer, str);
    }

    protected void appendDetail(StringBuffer stringBuffer, String str, boolean z) {
        stringBuffer.append(z);
    }

    public void append(StringBuffer stringBuffer, String str, Object[] objArr, Boolean bool) {
        appendFieldStart(stringBuffer, str);
        if (objArr == null) {
            appendNullText(stringBuffer, str);
        } else if (isFullDetail(bool)) {
            appendDetail(stringBuffer, str, objArr);
        } else {
            appendSummary(stringBuffer, str, objArr);
        }
        appendFieldEnd(stringBuffer, str);
    }

    protected void appendDetail(StringBuffer stringBuffer, String str, Object[] objArr) {
        stringBuffer.append(this.arrayStart);
        for (int i = 0; i < objArr.length; i++) {
            Object obj = objArr[i];
            if (i > 0) {
                stringBuffer.append(this.arraySeparator);
            }
            if (obj == null) {
                appendNullText(stringBuffer, str);
            } else {
                appendInternal(stringBuffer, str, obj, this.arrayContentDetail);
            }
        }
        stringBuffer.append(this.arrayEnd);
    }

    protected void reflectionAppendArrayDetail(StringBuffer stringBuffer, String str, Object obj) {
        stringBuffer.append(this.arrayStart);
        int length = Array.getLength(obj);
        for (int i = 0; i < length; i++) {
            Object obj2 = Array.get(obj, i);
            if (i > 0) {
                stringBuffer.append(this.arraySeparator);
            }
            if (obj2 == null) {
                appendNullText(stringBuffer, str);
            } else {
                appendInternal(stringBuffer, str, obj2, this.arrayContentDetail);
            }
        }
        stringBuffer.append(this.arrayEnd);
    }

    protected void appendSummary(StringBuffer stringBuffer, String str, Object[] objArr) {
        appendSummarySize(stringBuffer, str, objArr.length);
    }

    public void append(StringBuffer stringBuffer, String str, long[] jArr, Boolean bool) {
        appendFieldStart(stringBuffer, str);
        if (jArr == null) {
            appendNullText(stringBuffer, str);
        } else if (isFullDetail(bool)) {
            appendDetail(stringBuffer, str, jArr);
        } else {
            appendSummary(stringBuffer, str, jArr);
        }
        appendFieldEnd(stringBuffer, str);
    }

    protected void appendDetail(StringBuffer stringBuffer, String str, long[] jArr) {
        stringBuffer.append(this.arrayStart);
        for (int i = 0; i < jArr.length; i++) {
            if (i > 0) {
                stringBuffer.append(this.arraySeparator);
            }
            appendDetail(stringBuffer, str, jArr[i]);
        }
        stringBuffer.append(this.arrayEnd);
    }

    protected void appendSummary(StringBuffer stringBuffer, String str, long[] jArr) {
        appendSummarySize(stringBuffer, str, jArr.length);
    }

    public void append(StringBuffer stringBuffer, String str, int[] iArr, Boolean bool) {
        appendFieldStart(stringBuffer, str);
        if (iArr == null) {
            appendNullText(stringBuffer, str);
        } else if (isFullDetail(bool)) {
            appendDetail(stringBuffer, str, iArr);
        } else {
            appendSummary(stringBuffer, str, iArr);
        }
        appendFieldEnd(stringBuffer, str);
    }

    protected void appendDetail(StringBuffer stringBuffer, String str, int[] iArr) {
        stringBuffer.append(this.arrayStart);
        for (int i = 0; i < iArr.length; i++) {
            if (i > 0) {
                stringBuffer.append(this.arraySeparator);
            }
            appendDetail(stringBuffer, str, iArr[i]);
        }
        stringBuffer.append(this.arrayEnd);
    }

    protected void appendSummary(StringBuffer stringBuffer, String str, int[] iArr) {
        appendSummarySize(stringBuffer, str, iArr.length);
    }

    public void append(StringBuffer stringBuffer, String str, short[] sArr, Boolean bool) {
        appendFieldStart(stringBuffer, str);
        if (sArr == null) {
            appendNullText(stringBuffer, str);
        } else if (isFullDetail(bool)) {
            appendDetail(stringBuffer, str, sArr);
        } else {
            appendSummary(stringBuffer, str, sArr);
        }
        appendFieldEnd(stringBuffer, str);
    }

    protected void appendDetail(StringBuffer stringBuffer, String str, short[] sArr) {
        stringBuffer.append(this.arrayStart);
        for (int i = 0; i < sArr.length; i++) {
            if (i > 0) {
                stringBuffer.append(this.arraySeparator);
            }
            appendDetail(stringBuffer, str, sArr[i]);
        }
        stringBuffer.append(this.arrayEnd);
    }

    protected void appendSummary(StringBuffer stringBuffer, String str, short[] sArr) {
        appendSummarySize(stringBuffer, str, sArr.length);
    }

    public void append(StringBuffer stringBuffer, String str, byte[] bArr, Boolean bool) {
        appendFieldStart(stringBuffer, str);
        if (bArr == null) {
            appendNullText(stringBuffer, str);
        } else if (isFullDetail(bool)) {
            appendDetail(stringBuffer, str, bArr);
        } else {
            appendSummary(stringBuffer, str, bArr);
        }
        appendFieldEnd(stringBuffer, str);
    }

    protected void appendDetail(StringBuffer stringBuffer, String str, byte[] bArr) {
        stringBuffer.append(this.arrayStart);
        for (int i = 0; i < bArr.length; i++) {
            if (i > 0) {
                stringBuffer.append(this.arraySeparator);
            }
            appendDetail(stringBuffer, str, bArr[i]);
        }
        stringBuffer.append(this.arrayEnd);
    }

    protected void appendSummary(StringBuffer stringBuffer, String str, byte[] bArr) {
        appendSummarySize(stringBuffer, str, bArr.length);
    }

    public void append(StringBuffer stringBuffer, String str, char[] cArr, Boolean bool) {
        appendFieldStart(stringBuffer, str);
        if (cArr == null) {
            appendNullText(stringBuffer, str);
        } else if (isFullDetail(bool)) {
            appendDetail(stringBuffer, str, cArr);
        } else {
            appendSummary(stringBuffer, str, cArr);
        }
        appendFieldEnd(stringBuffer, str);
    }

    protected void appendDetail(StringBuffer stringBuffer, String str, char[] cArr) {
        stringBuffer.append(this.arrayStart);
        for (int i = 0; i < cArr.length; i++) {
            if (i > 0) {
                stringBuffer.append(this.arraySeparator);
            }
            appendDetail(stringBuffer, str, cArr[i]);
        }
        stringBuffer.append(this.arrayEnd);
    }

    protected void appendSummary(StringBuffer stringBuffer, String str, char[] cArr) {
        appendSummarySize(stringBuffer, str, cArr.length);
    }

    public void append(StringBuffer stringBuffer, String str, double[] dArr, Boolean bool) {
        appendFieldStart(stringBuffer, str);
        if (dArr == null) {
            appendNullText(stringBuffer, str);
        } else if (isFullDetail(bool)) {
            appendDetail(stringBuffer, str, dArr);
        } else {
            appendSummary(stringBuffer, str, dArr);
        }
        appendFieldEnd(stringBuffer, str);
    }

    protected void appendDetail(StringBuffer stringBuffer, String str, double[] dArr) {
        stringBuffer.append(this.arrayStart);
        for (int i = 0; i < dArr.length; i++) {
            if (i > 0) {
                stringBuffer.append(this.arraySeparator);
            }
            appendDetail(stringBuffer, str, dArr[i]);
        }
        stringBuffer.append(this.arrayEnd);
    }

    protected void appendSummary(StringBuffer stringBuffer, String str, double[] dArr) {
        appendSummarySize(stringBuffer, str, dArr.length);
    }

    public void append(StringBuffer stringBuffer, String str, float[] fArr, Boolean bool) {
        appendFieldStart(stringBuffer, str);
        if (fArr == null) {
            appendNullText(stringBuffer, str);
        } else if (isFullDetail(bool)) {
            appendDetail(stringBuffer, str, fArr);
        } else {
            appendSummary(stringBuffer, str, fArr);
        }
        appendFieldEnd(stringBuffer, str);
    }

    protected void appendDetail(StringBuffer stringBuffer, String str, float[] fArr) {
        stringBuffer.append(this.arrayStart);
        for (int i = 0; i < fArr.length; i++) {
            if (i > 0) {
                stringBuffer.append(this.arraySeparator);
            }
            appendDetail(stringBuffer, str, fArr[i]);
        }
        stringBuffer.append(this.arrayEnd);
    }

    protected void appendSummary(StringBuffer stringBuffer, String str, float[] fArr) {
        appendSummarySize(stringBuffer, str, fArr.length);
    }

    public void append(StringBuffer stringBuffer, String str, boolean[] zArr, Boolean bool) {
        appendFieldStart(stringBuffer, str);
        if (zArr == null) {
            appendNullText(stringBuffer, str);
        } else if (isFullDetail(bool)) {
            appendDetail(stringBuffer, str, zArr);
        } else {
            appendSummary(stringBuffer, str, zArr);
        }
        appendFieldEnd(stringBuffer, str);
    }

    protected void appendDetail(StringBuffer stringBuffer, String str, boolean[] zArr) {
        stringBuffer.append(this.arrayStart);
        for (int i = 0; i < zArr.length; i++) {
            if (i > 0) {
                stringBuffer.append(this.arraySeparator);
            }
            appendDetail(stringBuffer, str, zArr[i]);
        }
        stringBuffer.append(this.arrayEnd);
    }

    protected void appendSummary(StringBuffer stringBuffer, String str, boolean[] zArr) {
        appendSummarySize(stringBuffer, str, zArr.length);
    }

    protected void appendClassName(StringBuffer stringBuffer, Object obj) {
        if (!this.useClassName) {
            return;
        }
        if (this.useShortClassName) {
            stringBuffer.append(getShortClassName(obj.getClass()));
        } else {
            stringBuffer.append(obj.getClass().getName());
        }
    }

    protected void appendIdentityHashCode(StringBuffer stringBuffer, Object obj) {
        if (this.useIdentityHashCode) {
            stringBuffer.append('@');
            stringBuffer.append(Integer.toHexString(System.identityHashCode(obj)));
        }
    }

    protected void appendContentStart(StringBuffer stringBuffer) {
        stringBuffer.append(this.contentStart);
    }

    protected void appendContentEnd(StringBuffer stringBuffer) {
        stringBuffer.append(this.contentEnd);
    }

    protected void appendNullText(StringBuffer stringBuffer, String str) {
        stringBuffer.append(this.nullText);
    }

    protected void appendFieldSeparator(StringBuffer stringBuffer) {
        stringBuffer.append(this.fieldSeparator);
    }

    protected void appendFieldStart(StringBuffer stringBuffer, String str) {
        if (this.useFieldNames && str != null) {
            stringBuffer.append(str);
            stringBuffer.append(this.fieldNameValueSeparator);
        }
    }

    protected void appendFieldEnd(StringBuffer stringBuffer, String str) {
        appendFieldSeparator(stringBuffer);
    }

    protected void appendSummarySize(StringBuffer stringBuffer, String str, int i) {
        stringBuffer.append(this.sizeStartText);
        stringBuffer.append(i);
        stringBuffer.append(this.sizeEndText);
    }

    protected boolean isFullDetail(Boolean bool) {
        if (bool == null) {
            return this.defaultFullDetail;
        }
        return bool.booleanValue();
    }

    protected String getShortClassName(Class cls) {
        return ClassUtils.getShortClassName(cls);
    }

    protected boolean isUseClassName() {
        return this.useClassName;
    }

    protected void setUseClassName(boolean z) {
        this.useClassName = z;
    }

    protected boolean isUseShortClassName() {
        return this.useShortClassName;
    }

    protected boolean isShortClassName() {
        return this.useShortClassName;
    }

    protected void setUseShortClassName(boolean z) {
        this.useShortClassName = z;
    }

    protected void setShortClassName(boolean z) {
        this.useShortClassName = z;
    }

    protected boolean isUseIdentityHashCode() {
        return this.useIdentityHashCode;
    }

    protected void setUseIdentityHashCode(boolean z) {
        this.useIdentityHashCode = z;
    }

    protected boolean isUseFieldNames() {
        return this.useFieldNames;
    }

    protected void setUseFieldNames(boolean z) {
        this.useFieldNames = z;
    }

    protected boolean isDefaultFullDetail() {
        return this.defaultFullDetail;
    }

    protected void setDefaultFullDetail(boolean z) {
        this.defaultFullDetail = z;
    }

    protected boolean isArrayContentDetail() {
        return this.arrayContentDetail;
    }

    protected void setArrayContentDetail(boolean z) {
        this.arrayContentDetail = z;
    }

    protected String getArrayStart() {
        return this.arrayStart;
    }

    protected void setArrayStart(String str) {
        if (str == null) {
            str = "";
        }
        this.arrayStart = str;
    }

    protected String getArrayEnd() {
        return this.arrayEnd;
    }

    protected void setArrayEnd(String str) {
        if (this.arrayStart == null) {
            this.arrayStart = "";
        }
        this.arrayEnd = str;
    }

    protected String getArraySeparator() {
        return this.arraySeparator;
    }

    protected void setArraySeparator(String str) {
        if (str == null) {
            str = "";
        }
        this.arraySeparator = str;
    }

    protected String getContentStart() {
        return this.contentStart;
    }

    protected void setContentStart(String str) {
        if (str == null) {
            str = "";
        }
        this.contentStart = str;
    }

    protected String getContentEnd() {
        return this.contentEnd;
    }

    protected void setContentEnd(String str) {
        if (str == null) {
            str = "";
        }
        this.contentEnd = str;
    }

    protected String getFieldNameValueSeparator() {
        return this.fieldNameValueSeparator;
    }

    protected void setFieldNameValueSeparator(String str) {
        if (str == null) {
            str = "";
        }
        this.fieldNameValueSeparator = str;
    }

    protected String getFieldSeparator() {
        return this.fieldSeparator;
    }

    protected void setFieldSeparator(String str) {
        if (str == null) {
            str = "";
        }
        this.fieldSeparator = str;
    }

    protected boolean isFieldSeparatorAtStart() {
        return this.fieldSeparatorAtStart;
    }

    protected void setFieldSeparatorAtStart(boolean z) {
        this.fieldSeparatorAtStart = z;
    }

    protected boolean isFieldSeparatorAtEnd() {
        return this.fieldSeparatorAtEnd;
    }

    protected void setFieldSeparatorAtEnd(boolean z) {
        this.fieldSeparatorAtEnd = z;
    }

    protected String getNullText() {
        return this.nullText;
    }

    protected void setNullText(String str) {
        if (str == null) {
            str = "";
        }
        this.nullText = str;
    }

    protected String getSizeStartText() {
        return this.sizeStartText;
    }

    protected void setSizeStartText(String str) {
        if (str == null) {
            str = "";
        }
        this.sizeStartText = str;
    }

    protected String getSizeEndText() {
        return this.sizeEndText;
    }

    protected void setSizeEndText(String str) {
        if (str == null) {
            str = "";
        }
        this.sizeEndText = str;
    }

    protected String getSummaryObjectStartText() {
        return this.summaryObjectStartText;
    }

    protected void setSummaryObjectStartText(String str) {
        if (str == null) {
            str = "";
        }
        this.summaryObjectStartText = str;
    }

    protected String getSummaryObjectEndText() {
        return this.summaryObjectEndText;
    }

    protected void setSummaryObjectEndText(String str) {
        if (str == null) {
            str = "";
        }
        this.summaryObjectEndText = str;
    }
}
