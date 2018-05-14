package org.apache.commons.lang.builder;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

/* compiled from: TbsSdkJava */
public class HashCodeBuilder {
    private final int iConstant;
    private int iTotal;

    public HashCodeBuilder() {
        this.iTotal = 0;
        this.iConstant = 37;
        this.iTotal = 17;
    }

    public HashCodeBuilder(int i, int i2) {
        this.iTotal = 0;
        if (i == 0) {
            throw new IllegalArgumentException("HashCodeBuilder requires a non zero initial value");
        } else if (i % 2 == 0) {
            throw new IllegalArgumentException("HashCodeBuilder requires an odd initial value");
        } else if (i2 == 0) {
            throw new IllegalArgumentException("HashCodeBuilder requires a non zero multiplier");
        } else if (i2 % 2 == 0) {
            throw new IllegalArgumentException("HashCodeBuilder requires an odd multiplier");
        } else {
            this.iConstant = i2;
            this.iTotal = i;
        }
    }

    public static int reflectionHashCode(Object obj) {
        return reflectionHashCode(17, 37, obj, false, null);
    }

    public static int reflectionHashCode(Object obj, boolean z) {
        return reflectionHashCode(17, 37, obj, z, null);
    }

    public static int reflectionHashCode(int i, int i2, Object obj) {
        return reflectionHashCode(i, i2, obj, false, null);
    }

    public static int reflectionHashCode(int i, int i2, Object obj, boolean z) {
        return reflectionHashCode(i, i2, obj, z, null);
    }

    public static int reflectionHashCode(int i, int i2, Object obj, boolean z, Class cls) {
        if (obj == null) {
            throw new IllegalArgumentException("The object to build a hash code for must not be null");
        }
        HashCodeBuilder hashCodeBuilder = new HashCodeBuilder(i, i2);
        Class cls2 = obj.getClass();
        reflectionAppend(obj, cls2, hashCodeBuilder, z);
        while (cls2.getSuperclass() != null && cls2 != cls) {
            cls2 = cls2.getSuperclass();
            reflectionAppend(obj, cls2, hashCodeBuilder, z);
        }
        return hashCodeBuilder.toHashCode();
    }

    private static void reflectionAppend(Object obj, Class cls, HashCodeBuilder hashCodeBuilder, boolean z) {
        AccessibleObject[] declaredFields = cls.getDeclaredFields();
        AccessibleObject.setAccessible(declaredFields, true);
        for (Field field : declaredFields) {
            if (field.getName().indexOf(36) == -1 && ((z || !Modifier.isTransient(field.getModifiers())) && !Modifier.isStatic(field.getModifiers()))) {
                try {
                    hashCodeBuilder.append(field.get(obj));
                } catch (IllegalAccessException e) {
                    throw new InternalError("Unexpected IllegalAccessException");
                }
            }
        }
    }

    public HashCodeBuilder appendSuper(int i) {
        this.iTotal = (this.iTotal * this.iConstant) + i;
        return this;
    }

    public HashCodeBuilder append(Object obj) {
        if (obj == null) {
            this.iTotal *= this.iConstant;
        } else if (!obj.getClass().isArray()) {
            this.iTotal = (this.iTotal * this.iConstant) + obj.hashCode();
        } else if (obj instanceof long[]) {
            append((long[]) obj);
        } else if (obj instanceof int[]) {
            append((int[]) obj);
        } else if (obj instanceof short[]) {
            append((short[]) obj);
        } else if (obj instanceof char[]) {
            append((char[]) obj);
        } else if (obj instanceof byte[]) {
            append((byte[]) obj);
        } else if (obj instanceof double[]) {
            append((double[]) obj);
        } else if (obj instanceof float[]) {
            append((float[]) obj);
        } else if (obj instanceof boolean[]) {
            append((boolean[]) obj);
        } else {
            append((Object[]) obj);
        }
        return this;
    }

    public HashCodeBuilder append(long j) {
        this.iTotal = (this.iTotal * this.iConstant) + ((int) ((j >> 32) ^ j));
        return this;
    }

    public HashCodeBuilder append(int i) {
        this.iTotal = (this.iTotal * this.iConstant) + i;
        return this;
    }

    public HashCodeBuilder append(short s) {
        this.iTotal = (this.iTotal * this.iConstant) + s;
        return this;
    }

    public HashCodeBuilder append(char c) {
        this.iTotal = (this.iTotal * this.iConstant) + c;
        return this;
    }

    public HashCodeBuilder append(byte b) {
        this.iTotal = (this.iTotal * this.iConstant) + b;
        return this;
    }

    public HashCodeBuilder append(double d) {
        return append(Double.doubleToLongBits(d));
    }

    public HashCodeBuilder append(float f) {
        this.iTotal = (this.iTotal * this.iConstant) + Float.floatToIntBits(f);
        return this;
    }

    public HashCodeBuilder append(boolean z) {
        this.iTotal = (z ? 0 : 1) + (this.iConstant * this.iTotal);
        return this;
    }

    public HashCodeBuilder append(Object[] objArr) {
        if (objArr == null) {
            this.iTotal *= this.iConstant;
        } else {
            for (Object append : objArr) {
                append(append);
            }
        }
        return this;
    }

    public HashCodeBuilder append(long[] jArr) {
        if (jArr == null) {
            this.iTotal *= this.iConstant;
        } else {
            for (long append : jArr) {
                append(append);
            }
        }
        return this;
    }

    public HashCodeBuilder append(int[] iArr) {
        if (iArr == null) {
            this.iTotal *= this.iConstant;
        } else {
            for (int append : iArr) {
                append(append);
            }
        }
        return this;
    }

    public HashCodeBuilder append(short[] sArr) {
        if (sArr == null) {
            this.iTotal *= this.iConstant;
        } else {
            for (short append : sArr) {
                append(append);
            }
        }
        return this;
    }

    public HashCodeBuilder append(char[] cArr) {
        if (cArr == null) {
            this.iTotal *= this.iConstant;
        } else {
            for (char append : cArr) {
                append(append);
            }
        }
        return this;
    }

    public HashCodeBuilder append(byte[] bArr) {
        if (bArr == null) {
            this.iTotal *= this.iConstant;
        } else {
            for (byte append : bArr) {
                append(append);
            }
        }
        return this;
    }

    public HashCodeBuilder append(double[] dArr) {
        if (dArr == null) {
            this.iTotal *= this.iConstant;
        } else {
            for (double append : dArr) {
                append(append);
            }
        }
        return this;
    }

    public HashCodeBuilder append(float[] fArr) {
        if (fArr == null) {
            this.iTotal *= this.iConstant;
        } else {
            for (float append : fArr) {
                append(append);
            }
        }
        return this;
    }

    public HashCodeBuilder append(boolean[] zArr) {
        if (zArr == null) {
            this.iTotal *= this.iConstant;
        } else {
            for (boolean append : zArr) {
                append(append);
            }
        }
        return this;
    }

    public int toHashCode() {
        return this.iTotal;
    }
}
