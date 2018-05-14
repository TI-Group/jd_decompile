package org.apache.commons.lang.builder;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Comparator;
import org.apache.commons.lang.math.NumberUtils;

/* compiled from: TbsSdkJava */
public class CompareToBuilder {
    private int comparison = 0;

    public static int reflectionCompare(Object obj, Object obj2) {
        return reflectionCompare(obj, obj2, false, null);
    }

    public static int reflectionCompare(Object obj, Object obj2, boolean z) {
        return reflectionCompare(obj, obj2, z, null);
    }

    public static int reflectionCompare(Object obj, Object obj2, boolean z, Class cls) {
        if (obj == obj2) {
            return 0;
        }
        if (obj == null || obj2 == null) {
            throw new NullPointerException();
        }
        Class cls2 = obj.getClass();
        if (cls2.isInstance(obj2)) {
            CompareToBuilder compareToBuilder = new CompareToBuilder();
            reflectionAppend(obj, obj2, cls2, compareToBuilder, z);
            while (cls2.getSuperclass() != null && cls2 != cls) {
                cls2 = cls2.getSuperclass();
                reflectionAppend(obj, obj2, cls2, compareToBuilder, z);
            }
            return compareToBuilder.toComparison();
        }
        throw new ClassCastException();
    }

    private static void reflectionAppend(Object obj, Object obj2, Class cls, CompareToBuilder compareToBuilder, boolean z) {
        AccessibleObject[] declaredFields = cls.getDeclaredFields();
        AccessibleObject.setAccessible(declaredFields, true);
        for (int i = 0; i < declaredFields.length && compareToBuilder.comparison == 0; i++) {
            Field field = declaredFields[i];
            if (field.getName().indexOf(36) == -1 && ((z || !Modifier.isTransient(field.getModifiers())) && !Modifier.isStatic(field.getModifiers()))) {
                try {
                    compareToBuilder.append(field.get(obj), field.get(obj2));
                } catch (IllegalAccessException e) {
                    throw new InternalError("Unexpected IllegalAccessException");
                }
            }
        }
    }

    public CompareToBuilder appendSuper(int i) {
        if (this.comparison == 0) {
            this.comparison = i;
        }
        return this;
    }

    public CompareToBuilder append(Object obj, Object obj2) {
        return append(obj, obj2, null);
    }

    public CompareToBuilder append(Object obj, Object obj2, Comparator comparator) {
        if (this.comparison == 0 && obj != obj2) {
            if (obj == null) {
                this.comparison = -1;
            } else if (obj2 == null) {
                this.comparison = 1;
            } else if (obj.getClass().isArray()) {
                if (obj instanceof long[]) {
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
                    append((Object[]) obj, (Object[]) obj2, comparator);
                }
            } else if (comparator == null) {
                this.comparison = ((Comparable) obj).compareTo(obj2);
            } else {
                this.comparison = comparator.compare(obj, obj2);
            }
        }
        return this;
    }

    public CompareToBuilder append(long j, long j2) {
        if (this.comparison == 0) {
            int i = j < j2 ? -1 : j > j2 ? 1 : 0;
            this.comparison = i;
        }
        return this;
    }

    public CompareToBuilder append(int i, int i2) {
        if (this.comparison == 0) {
            int i3 = i < i2 ? -1 : i > i2 ? 1 : 0;
            this.comparison = i3;
        }
        return this;
    }

    public CompareToBuilder append(short s, short s2) {
        if (this.comparison == 0) {
            int i = s < s2 ? -1 : s > s2 ? 1 : 0;
            this.comparison = i;
        }
        return this;
    }

    public CompareToBuilder append(char c, char c2) {
        if (this.comparison == 0) {
            int i = c < c2 ? -1 : c > c2 ? 1 : 0;
            this.comparison = i;
        }
        return this;
    }

    public CompareToBuilder append(byte b, byte b2) {
        if (this.comparison == 0) {
            int i = b < b2 ? -1 : b > b2 ? 1 : 0;
            this.comparison = i;
        }
        return this;
    }

    public CompareToBuilder append(double d, double d2) {
        if (this.comparison == 0) {
            this.comparison = NumberUtils.compare(d, d2);
        }
        return this;
    }

    public CompareToBuilder append(float f, float f2) {
        if (this.comparison == 0) {
            this.comparison = NumberUtils.compare(f, f2);
        }
        return this;
    }

    public CompareToBuilder append(boolean z, boolean z2) {
        if (this.comparison == 0 && z != z2) {
            if (z) {
                this.comparison = 1;
            } else {
                this.comparison = -1;
            }
        }
        return this;
    }

    public CompareToBuilder append(Object[] objArr, Object[] objArr2) {
        return append(objArr, objArr2, null);
    }

    public CompareToBuilder append(Object[] objArr, Object[] objArr2, Comparator comparator) {
        int i = -1;
        if (this.comparison == 0 && objArr != objArr2) {
            if (objArr == null) {
                this.comparison = -1;
            } else if (objArr2 == null) {
                this.comparison = 1;
            } else if (objArr.length != objArr2.length) {
                if (objArr.length >= objArr2.length) {
                    i = 1;
                }
                this.comparison = i;
            } else {
                for (i = 0; i < objArr.length && this.comparison == 0; i++) {
                    append(objArr[i], objArr2[i], comparator);
                }
            }
        }
        return this;
    }

    public CompareToBuilder append(long[] jArr, long[] jArr2) {
        int i = -1;
        if (this.comparison == 0 && jArr != jArr2) {
            if (jArr == null) {
                this.comparison = -1;
            } else if (jArr2 == null) {
                this.comparison = 1;
            } else if (jArr.length != jArr2.length) {
                if (jArr.length >= jArr2.length) {
                    i = 1;
                }
                this.comparison = i;
            } else {
                for (i = 0; i < jArr.length && this.comparison == 0; i++) {
                    append(jArr[i], jArr2[i]);
                }
            }
        }
        return this;
    }

    public CompareToBuilder append(int[] iArr, int[] iArr2) {
        int i = -1;
        if (this.comparison == 0 && iArr != iArr2) {
            if (iArr == null) {
                this.comparison = -1;
            } else if (iArr2 == null) {
                this.comparison = 1;
            } else if (iArr.length != iArr2.length) {
                if (iArr.length >= iArr2.length) {
                    i = 1;
                }
                this.comparison = i;
            } else {
                for (i = 0; i < iArr.length && this.comparison == 0; i++) {
                    append(iArr[i], iArr2[i]);
                }
            }
        }
        return this;
    }

    public CompareToBuilder append(short[] sArr, short[] sArr2) {
        int i = -1;
        if (this.comparison == 0 && sArr != sArr2) {
            if (sArr == null) {
                this.comparison = -1;
            } else if (sArr2 == null) {
                this.comparison = 1;
            } else if (sArr.length != sArr2.length) {
                if (sArr.length >= sArr2.length) {
                    i = 1;
                }
                this.comparison = i;
            } else {
                for (i = 0; i < sArr.length && this.comparison == 0; i++) {
                    append(sArr[i], sArr2[i]);
                }
            }
        }
        return this;
    }

    public CompareToBuilder append(char[] cArr, char[] cArr2) {
        int i = -1;
        if (this.comparison == 0 && cArr != cArr2) {
            if (cArr == null) {
                this.comparison = -1;
            } else if (cArr2 == null) {
                this.comparison = 1;
            } else if (cArr.length != cArr2.length) {
                if (cArr.length >= cArr2.length) {
                    i = 1;
                }
                this.comparison = i;
            } else {
                for (i = 0; i < cArr.length && this.comparison == 0; i++) {
                    append(cArr[i], cArr2[i]);
                }
            }
        }
        return this;
    }

    public CompareToBuilder append(byte[] bArr, byte[] bArr2) {
        int i = -1;
        if (this.comparison == 0 && bArr != bArr2) {
            if (bArr == null) {
                this.comparison = -1;
            } else if (bArr2 == null) {
                this.comparison = 1;
            } else if (bArr.length != bArr2.length) {
                if (bArr.length >= bArr2.length) {
                    i = 1;
                }
                this.comparison = i;
            } else {
                for (i = 0; i < bArr.length && this.comparison == 0; i++) {
                    append(bArr[i], bArr2[i]);
                }
            }
        }
        return this;
    }

    public CompareToBuilder append(double[] dArr, double[] dArr2) {
        int i = -1;
        if (this.comparison == 0 && dArr != dArr2) {
            if (dArr == null) {
                this.comparison = -1;
            } else if (dArr2 == null) {
                this.comparison = 1;
            } else if (dArr.length != dArr2.length) {
                if (dArr.length >= dArr2.length) {
                    i = 1;
                }
                this.comparison = i;
            } else {
                for (i = 0; i < dArr.length && this.comparison == 0; i++) {
                    append(dArr[i], dArr2[i]);
                }
            }
        }
        return this;
    }

    public CompareToBuilder append(float[] fArr, float[] fArr2) {
        int i = -1;
        if (this.comparison == 0 && fArr != fArr2) {
            if (fArr == null) {
                this.comparison = -1;
            } else if (fArr2 == null) {
                this.comparison = 1;
            } else if (fArr.length != fArr2.length) {
                if (fArr.length >= fArr2.length) {
                    i = 1;
                }
                this.comparison = i;
            } else {
                for (i = 0; i < fArr.length && this.comparison == 0; i++) {
                    append(fArr[i], fArr2[i]);
                }
            }
        }
        return this;
    }

    public CompareToBuilder append(boolean[] zArr, boolean[] zArr2) {
        int i = -1;
        if (this.comparison == 0 && zArr != zArr2) {
            if (zArr == null) {
                this.comparison = -1;
            } else if (zArr2 == null) {
                this.comparison = 1;
            } else if (zArr.length != zArr2.length) {
                if (zArr.length >= zArr2.length) {
                    i = 1;
                }
                this.comparison = i;
            } else {
                for (i = 0; i < zArr.length && this.comparison == 0; i++) {
                    append(zArr[i], zArr2[i]);
                }
            }
        }
        return this;
    }

    public int toComparison() {
        return this.comparison;
    }
}
