package org.apache.commons.lang.builder;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

/* compiled from: TbsSdkJava */
public class EqualsBuilder {
    private boolean isEquals = true;

    public static boolean reflectionEquals(Object obj, Object obj2) {
        return reflectionEquals(obj, obj2, false, null);
    }

    public static boolean reflectionEquals(Object obj, Object obj2, boolean z) {
        return reflectionEquals(obj, obj2, z, null);
    }

    public static boolean reflectionEquals(Object obj, Object obj2, boolean z, Class cls) {
        if (obj == obj2) {
            return true;
        }
        if (obj == null || obj2 == null) {
            return false;
        }
        Class cls2 = obj.getClass();
        Class cls3 = obj2.getClass();
        if (cls2.isInstance(obj2)) {
            if (cls3.isInstance(obj)) {
                cls3 = cls2;
            }
        } else if (!cls3.isInstance(obj)) {
            return false;
        } else {
            if (!cls2.isInstance(obj2)) {
                cls3 = cls2;
            }
        }
        EqualsBuilder equalsBuilder = new EqualsBuilder();
        try {
            reflectionAppend(obj, obj2, cls3, equalsBuilder, z);
            while (cls3.getSuperclass() != null && cls3 != cls) {
                cls3 = cls3.getSuperclass();
                reflectionAppend(obj, obj2, cls3, equalsBuilder, z);
            }
            return equalsBuilder.isEquals();
        } catch (IllegalArgumentException e) {
            return false;
        }
    }

    private static void reflectionAppend(Object obj, Object obj2, Class cls, EqualsBuilder equalsBuilder, boolean z) {
        AccessibleObject[] declaredFields = cls.getDeclaredFields();
        AccessibleObject.setAccessible(declaredFields, true);
        for (int i = 0; i < declaredFields.length && equalsBuilder.isEquals; i++) {
            Field field = declaredFields[i];
            if (field.getName().indexOf(36) == -1 && ((z || !Modifier.isTransient(field.getModifiers())) && !Modifier.isStatic(field.getModifiers()))) {
                try {
                    equalsBuilder.append(field.get(obj), field.get(obj2));
                } catch (IllegalAccessException e) {
                    throw new InternalError("Unexpected IllegalAccessException");
                }
            }
        }
    }

    public EqualsBuilder appendSuper(boolean z) {
        if (this.isEquals) {
            this.isEquals = z;
        }
        return this;
    }

    public EqualsBuilder append(Object obj, Object obj2) {
        if (this.isEquals && obj != obj2) {
            if (obj == null || obj2 == null) {
                this.isEquals = false;
            } else if (!obj.getClass().isArray()) {
                this.isEquals = obj.equals(obj2);
            } else if (obj instanceof long[]) {
                append((long[]) obj, (long[]) obj2);
            } else if (obj instanceof int[]) {
                append((int[]) obj, (int[]) obj2);
            } else if (obj instanceof short[]) {
                append((short[]) obj, (short[]) obj2);
            } else if (obj instanceof char[]) {
                append((char[]) obj, (char[]) obj2);
            } else if (obj instanceof byte[]) {
                append((byte[]) obj, (byte[]) obj2);
            } else if (obj instanceof double[]) {
                append((double[]) obj, (double[]) obj2);
            } else if (obj instanceof float[]) {
                append((float[]) obj, (float[]) obj2);
            } else if (obj instanceof boolean[]) {
                append((boolean[]) obj, (boolean[]) obj2);
            } else {
                append((Object[]) obj, (Object[]) obj2);
            }
        }
        return this;
    }

    public EqualsBuilder append(long j, long j2) {
        if (this.isEquals) {
            this.isEquals = j == j2;
        }
        return this;
    }

    public EqualsBuilder append(int i, int i2) {
        if (this.isEquals) {
            this.isEquals = i == i2;
        }
        return this;
    }

    public EqualsBuilder append(short s, short s2) {
        if (this.isEquals) {
            this.isEquals = s == s2;
        }
        return this;
    }

    public EqualsBuilder append(char c, char c2) {
        if (this.isEquals) {
            this.isEquals = c == c2;
        }
        return this;
    }

    public EqualsBuilder append(byte b, byte b2) {
        if (this.isEquals) {
            this.isEquals = b == b2;
        }
        return this;
    }

    public EqualsBuilder append(double d, double d2) {
        return !this.isEquals ? this : append(Double.doubleToLongBits(d), Double.doubleToLongBits(d2));
    }

    public EqualsBuilder append(float f, float f2) {
        return !this.isEquals ? this : append(Float.floatToIntBits(f), Float.floatToIntBits(f2));
    }

    public EqualsBuilder append(boolean z, boolean z2) {
        if (this.isEquals) {
            this.isEquals = z == z2;
        }
        return this;
    }

    public EqualsBuilder append(Object[] objArr, Object[] objArr2) {
        if (this.isEquals && objArr != objArr2) {
            if (objArr == null || objArr2 == null) {
                this.isEquals = false;
            } else if (objArr.length != objArr2.length) {
                this.isEquals = false;
            } else {
                for (int i = 0; i < objArr.length && this.isEquals; i++) {
                    if (!objArr[i].getClass().isInstance(objArr2[i])) {
                        this.isEquals = false;
                        break;
                    }
                    append(objArr[i], objArr2[i]);
                }
            }
        }
        return this;
    }

    public EqualsBuilder append(long[] jArr, long[] jArr2) {
        int i = 0;
        if (this.isEquals && jArr != jArr2) {
            if (jArr == null || jArr2 == null) {
                this.isEquals = false;
            } else if (jArr.length != jArr2.length) {
                this.isEquals = false;
            } else {
                while (i < jArr.length && this.isEquals) {
                    append(jArr[i], jArr2[i]);
                    i++;
                }
            }
        }
        return this;
    }

    public EqualsBuilder append(int[] iArr, int[] iArr2) {
        int i = 0;
        if (this.isEquals && iArr != iArr2) {
            if (iArr == null || iArr2 == null) {
                this.isEquals = false;
            } else if (iArr.length != iArr2.length) {
                this.isEquals = false;
            } else {
                while (i < iArr.length && this.isEquals) {
                    append(iArr[i], iArr2[i]);
                    i++;
                }
            }
        }
        return this;
    }

    public EqualsBuilder append(short[] sArr, short[] sArr2) {
        int i = 0;
        if (this.isEquals && sArr != sArr2) {
            if (sArr == null || sArr2 == null) {
                this.isEquals = false;
            } else if (sArr.length != sArr2.length) {
                this.isEquals = false;
            } else {
                while (i < sArr.length && this.isEquals) {
                    append(sArr[i], sArr2[i]);
                    i++;
                }
            }
        }
        return this;
    }

    public EqualsBuilder append(char[] cArr, char[] cArr2) {
        int i = 0;
        if (this.isEquals && cArr != cArr2) {
            if (cArr == null || cArr2 == null) {
                this.isEquals = false;
            } else if (cArr.length != cArr2.length) {
                this.isEquals = false;
            } else {
                while (i < cArr.length && this.isEquals) {
                    append(cArr[i], cArr2[i]);
                    i++;
                }
            }
        }
        return this;
    }

    public EqualsBuilder append(byte[] bArr, byte[] bArr2) {
        int i = 0;
        if (this.isEquals && bArr != bArr2) {
            if (bArr == null || bArr2 == null) {
                this.isEquals = false;
            } else if (bArr.length != bArr2.length) {
                this.isEquals = false;
            } else {
                while (i < bArr.length && this.isEquals) {
                    append(bArr[i], bArr2[i]);
                    i++;
                }
            }
        }
        return this;
    }

    public EqualsBuilder append(double[] dArr, double[] dArr2) {
        int i = 0;
        if (this.isEquals && dArr != dArr2) {
            if (dArr == null || dArr2 == null) {
                this.isEquals = false;
            } else if (dArr.length != dArr2.length) {
                this.isEquals = false;
            } else {
                while (i < dArr.length && this.isEquals) {
                    append(dArr[i], dArr2[i]);
                    i++;
                }
            }
        }
        return this;
    }

    public EqualsBuilder append(float[] fArr, float[] fArr2) {
        int i = 0;
        if (this.isEquals && fArr != fArr2) {
            if (fArr == null || fArr2 == null) {
                this.isEquals = false;
            } else if (fArr.length != fArr2.length) {
                this.isEquals = false;
            } else {
                while (i < fArr.length && this.isEquals) {
                    append(fArr[i], fArr2[i]);
                    i++;
                }
            }
        }
        return this;
    }

    public EqualsBuilder append(boolean[] zArr, boolean[] zArr2) {
        int i = 0;
        if (this.isEquals && zArr != zArr2) {
            if (zArr == null || zArr2 == null) {
                this.isEquals = false;
            } else if (zArr.length != zArr2.length) {
                this.isEquals = false;
            } else {
                while (i < zArr.length && this.isEquals) {
                    append(zArr[i], zArr2[i]);
                    i++;
                }
            }
        }
        return this;
    }

    public boolean isEquals() {
        return this.isEquals;
    }
}
