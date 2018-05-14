package org.apache.commons.lang.enum;

import cn.jiguang.net.HttpUtils;
import org.apache.commons.lang.ClassUtils;

/* compiled from: TbsSdkJava */
public abstract class ValuedEnum extends Enum {
    private static final long serialVersionUID = -7129650521543789085L;
    private final int iValue;

    protected ValuedEnum(String str, int i) {
        super(str);
        this.iValue = i;
    }

    protected static Enum getEnum(Class cls, int i) {
        if (cls == null) {
            throw new IllegalArgumentException("The Enum Class must not be null");
        }
        for (ValuedEnum valuedEnum : Enum.getEnumList(cls)) {
            if (valuedEnum.getValue() == i) {
                return valuedEnum;
            }
        }
        return null;
    }

    public final int getValue() {
        return this.iValue;
    }

    public int compareTo(Object obj) {
        return this.iValue - ((ValuedEnum) obj).iValue;
    }

    public String toString() {
        if (this.iToString == null) {
            this.iToString = new StringBuffer().append(ClassUtils.getShortClassName(getEnumClass())).append("[").append(getName()).append(HttpUtils.EQUAL_SIGN).append(getValue()).append("]").toString();
        }
        return this.iToString;
    }
}
