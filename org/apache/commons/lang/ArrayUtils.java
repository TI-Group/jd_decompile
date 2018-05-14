package org.apache.commons.lang;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

/* compiled from: TbsSdkJava */
public class ArrayUtils {
    public static final boolean[] EMPTY_BOOLEAN_ARRAY = new boolean[0];
    public static final Boolean[] EMPTY_BOOLEAN_OBJECT_ARRAY = new Boolean[0];
    public static final byte[] EMPTY_BYTE_ARRAY = new byte[0];
    public static final Byte[] EMPTY_BYTE_OBJECT_ARRAY = new Byte[0];
    public static final Character[] EMPTY_CHARACTER_OBJECT_ARRAY = new Character[0];
    public static final char[] EMPTY_CHAR_ARRAY = new char[0];
    public static final Class[] EMPTY_CLASS_ARRAY = new Class[0];
    public static final double[] EMPTY_DOUBLE_ARRAY = new double[0];
    public static final Double[] EMPTY_DOUBLE_OBJECT_ARRAY = new Double[0];
    public static final float[] EMPTY_FLOAT_ARRAY = new float[0];
    public static final Float[] EMPTY_FLOAT_OBJECT_ARRAY = new Float[0];
    public static final Integer[] EMPTY_INTEGER_OBJECT_ARRAY = new Integer[0];
    public static final int[] EMPTY_INT_ARRAY = new int[0];
    public static final long[] EMPTY_LONG_ARRAY = new long[0];
    public static final Long[] EMPTY_LONG_OBJECT_ARRAY = new Long[0];
    public static final Object[] EMPTY_OBJECT_ARRAY = new Object[0];
    public static final short[] EMPTY_SHORT_ARRAY = new short[0];
    public static final Short[] EMPTY_SHORT_OBJECT_ARRAY = new Short[0];
    public static final String[] EMPTY_STRING_ARRAY = new String[0];

    public static String toString(Object obj) {
        return toString(obj, "{}");
    }

    public static String toString(Object obj, String str) {
        return obj == null ? str : new ToStringBuilder(obj, ToStringStyle.SIMPLE_STYLE).append(obj).toString();
    }

    public static int hashCode(Object obj) {
        return new HashCodeBuilder().append(obj).toHashCode();
    }

    public static boolean isEquals(Object obj, Object obj2) {
        return new EqualsBuilder().append(obj, obj2).isEquals();
    }

    public static Map toMap(Object[] objArr) {
        if (objArr == null) {
            return null;
        }
        Map hashMap = new HashMap((int) (((double) objArr.length) * 1.5d));
        for (int i = 0; i < objArr.length; i++) {
            Object obj = objArr[i];
            if (obj instanceof Entry) {
                Entry entry = (Entry) obj;
                hashMap.put(entry.getKey(), entry.getValue());
            } else if (obj instanceof Object[]) {
                Object[] objArr2 = (Object[]) obj;
                if (objArr2.length < 2) {
                    throw new IllegalArgumentException(new StringBuffer().append("Array element ").append(i).append(", '").append(obj).append("', has a length less than 2").toString());
                }
                hashMap.put(objArr2[0], objArr2[1]);
            } else {
                throw new IllegalArgumentException(new StringBuffer().append("Array element ").append(i).append(", '").append(obj).append("', is neither of type Map.Entry nor an Array").toString());
            }
        }
        return hashMap;
    }

    public static Object[] clone(Object[] objArr) {
        if (objArr == null) {
            return null;
        }
        return (Object[]) objArr.clone();
    }

    public static long[] clone(long[] jArr) {
        if (jArr == null) {
            return null;
        }
        return (long[]) jArr.clone();
    }

    public static int[] clone(int[] iArr) {
        if (iArr == null) {
            return null;
        }
        return (int[]) iArr.clone();
    }

    public static short[] clone(short[] sArr) {
        if (sArr == null) {
            return null;
        }
        return (short[]) sArr.clone();
    }

    public static char[] clone(char[] cArr) {
        if (cArr == null) {
            return null;
        }
        return (char[]) cArr.clone();
    }

    public static byte[] clone(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        return (byte[]) bArr.clone();
    }

    public static double[] clone(double[] dArr) {
        if (dArr == null) {
            return null;
        }
        return (double[]) dArr.clone();
    }

    public static float[] clone(float[] fArr) {
        if (fArr == null) {
            return null;
        }
        return (float[]) fArr.clone();
    }

    public static boolean[] clone(boolean[] zArr) {
        if (zArr == null) {
            return null;
        }
        return (boolean[]) zArr.clone();
    }

    public static boolean isSameLength(Object[] objArr, Object[] objArr2) {
        if ((objArr != null || objArr2 == null || objArr2.length <= 0) && ((objArr2 != null || objArr == null || objArr.length <= 0) && (objArr == null || objArr2 == null || objArr.length == objArr2.length))) {
            return true;
        }
        return false;
    }

    public static boolean isSameLength(long[] jArr, long[] jArr2) {
        if ((jArr != null || jArr2 == null || jArr2.length <= 0) && ((jArr2 != null || jArr == null || jArr.length <= 0) && (jArr == null || jArr2 == null || jArr.length == jArr2.length))) {
            return true;
        }
        return false;
    }

    public static boolean isSameLength(int[] iArr, int[] iArr2) {
        if ((iArr != null || iArr2 == null || iArr2.length <= 0) && ((iArr2 != null || iArr == null || iArr.length <= 0) && (iArr == null || iArr2 == null || iArr.length == iArr2.length))) {
            return true;
        }
        return false;
    }

    public static boolean isSameLength(short[] sArr, short[] sArr2) {
        if ((sArr != null || sArr2 == null || sArr2.length <= 0) && ((sArr2 != null || sArr == null || sArr.length <= 0) && (sArr == null || sArr2 == null || sArr.length == sArr2.length))) {
            return true;
        }
        return false;
    }

    public static boolean isSameLength(char[] cArr, char[] cArr2) {
        if ((cArr != null || cArr2 == null || cArr2.length <= 0) && ((cArr2 != null || cArr == null || cArr.length <= 0) && (cArr == null || cArr2 == null || cArr.length == cArr2.length))) {
            return true;
        }
        return false;
    }

    public static boolean isSameLength(byte[] bArr, byte[] bArr2) {
        if ((bArr != null || bArr2 == null || bArr2.length <= 0) && ((bArr2 != null || bArr == null || bArr.length <= 0) && (bArr == null || bArr2 == null || bArr.length == bArr2.length))) {
            return true;
        }
        return false;
    }

    public static boolean isSameLength(double[] dArr, double[] dArr2) {
        if ((dArr != null || dArr2 == null || dArr2.length <= 0) && ((dArr2 != null || dArr == null || dArr.length <= 0) && (dArr == null || dArr2 == null || dArr.length == dArr2.length))) {
            return true;
        }
        return false;
    }

    public static boolean isSameLength(float[] fArr, float[] fArr2) {
        if ((fArr != null || fArr2 == null || fArr2.length <= 0) && ((fArr2 != null || fArr == null || fArr.length <= 0) && (fArr == null || fArr2 == null || fArr.length == fArr2.length))) {
            return true;
        }
        return false;
    }

    public static boolean isSameLength(boolean[] zArr, boolean[] zArr2) {
        if ((zArr != null || zArr2 == null || zArr2.length <= 0) && ((zArr2 != null || zArr == null || zArr.length <= 0) && (zArr == null || zArr2 == null || zArr.length == zArr2.length))) {
            return true;
        }
        return false;
    }

    public static boolean isSameType(Object obj, Object obj2) {
        if (obj != null && obj2 != null) {
            return obj.getClass().getName().equals(obj2.getClass().getName());
        }
        throw new IllegalArgumentException("The Array must not be null");
    }

    public static void reverse(Object[] objArr) {
        if (objArr != null) {
            int length = objArr.length - 1;
            for (int i = 0; length > i; i++) {
                Object obj = objArr[length];
                objArr[length] = objArr[i];
                objArr[i] = obj;
                length--;
            }
        }
    }

    public static void reverse(long[] jArr) {
        if (jArr != null) {
            int length = jArr.length - 1;
            for (int i = 0; length > i; i++) {
                long j = jArr[length];
                jArr[length] = jArr[i];
                jArr[i] = j;
                length--;
            }
        }
    }

    public static void reverse(int[] iArr) {
        if (iArr != null) {
            int length = iArr.length - 1;
            for (int i = 0; length > i; i++) {
                int i2 = iArr[length];
                iArr[length] = iArr[i];
                iArr[i] = i2;
                length--;
            }
        }
    }

    public static void reverse(short[] sArr) {
        if (sArr != null) {
            int length = sArr.length - 1;
            for (int i = 0; length > i; i++) {
                short s = sArr[length];
                sArr[length] = sArr[i];
                sArr[i] = s;
                length--;
            }
        }
    }

    public static void reverse(char[] cArr) {
        if (cArr != null) {
            int length = cArr.length - 1;
            for (int i = 0; length > i; i++) {
                char c = cArr[length];
                cArr[length] = cArr[i];
                cArr[i] = c;
                length--;
            }
        }
    }

    public static void reverse(byte[] bArr) {
        if (bArr != null) {
            int length = bArr.length - 1;
            for (int i = 0; length > i; i++) {
                byte b = bArr[length];
                bArr[length] = bArr[i];
                bArr[i] = b;
                length--;
            }
        }
    }

    public static void reverse(double[] dArr) {
        if (dArr != null) {
            int length = dArr.length - 1;
            for (int i = 0; length > i; i++) {
                double d = dArr[length];
                dArr[length] = dArr[i];
                dArr[i] = d;
                length--;
            }
        }
    }

    public static void reverse(float[] fArr) {
        if (fArr != null) {
            int length = fArr.length - 1;
            for (int i = 0; length > i; i++) {
                float f = fArr[length];
                fArr[length] = fArr[i];
                fArr[i] = f;
                length--;
            }
        }
    }

    public static void reverse(boolean[] zArr) {
        if (zArr != null) {
            int length = zArr.length - 1;
            for (int i = 0; length > i; i++) {
                boolean z = zArr[length];
                zArr[length] = zArr[i];
                zArr[i] = z;
                length--;
            }
        }
    }

    public static int indexOf(Object[] objArr, Object obj) {
        return indexOf(objArr, obj, 0);
    }

    public static int indexOf(Object[] objArr, Object obj, int i) {
        if (objArr == null) {
            return -1;
        }
        int i2;
        if (i < 0) {
            i2 = 0;
        } else {
            i2 = i;
        }
        if (obj == null) {
            while (i2 < objArr.length) {
                if (objArr[i2] == null) {
                    return i2;
                }
                i2++;
            }
        } else {
            while (i2 < objArr.length) {
                if (obj.equals(objArr[i2])) {
                    return i2;
                }
                i2++;
            }
        }
        return -1;
    }

    public static int lastIndexOf(Object[] objArr, Object obj) {
        return lastIndexOf(objArr, obj, (int) ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
    }

    public static int lastIndexOf(Object[] objArr, Object obj, int i) {
        if (objArr == null || i < 0) {
            return -1;
        }
        int length;
        if (i >= objArr.length) {
            length = objArr.length - 1;
        } else {
            length = i;
        }
        if (obj == null) {
            while (length >= 0) {
                if (objArr[length] == null) {
                    return length;
                }
                length--;
            }
            return -1;
        }
        while (length >= 0) {
            if (obj.equals(objArr[length])) {
                return length;
            }
            length--;
        }
        return -1;
    }

    public static boolean contains(Object[] objArr, Object obj) {
        return indexOf(objArr, obj) != -1;
    }

    public static int indexOf(long[] jArr, long j) {
        return indexOf(jArr, j, 0);
    }

    public static int indexOf(long[] jArr, long j, int i) {
        if (jArr == null) {
            return -1;
        }
        if (i < 0) {
            i = 0;
        }
        while (i < jArr.length) {
            if (j == jArr[i]) {
                return i;
            }
            i++;
        }
        return -1;
    }

    public static int lastIndexOf(long[] jArr, long j) {
        return lastIndexOf(jArr, j, (int) ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
    }

    public static int lastIndexOf(long[] jArr, long j, int i) {
        if (jArr == null || i < 0) {
            return -1;
        }
        if (i >= jArr.length) {
            i = jArr.length - 1;
        }
        for (int i2 = i; i2 >= 0; i2--) {
            if (j == jArr[i2]) {
                return i2;
            }
        }
        return -1;
    }

    public static boolean contains(long[] jArr, long j) {
        return indexOf(jArr, j) != -1;
    }

    public static int indexOf(int[] iArr, int i) {
        return indexOf(iArr, i, 0);
    }

    public static int indexOf(int[] iArr, int i, int i2) {
        if (iArr == null) {
            return -1;
        }
        if (i2 < 0) {
            i2 = 0;
        }
        while (i2 < iArr.length) {
            if (i == iArr[i2]) {
                return i2;
            }
            i2++;
        }
        return -1;
    }

    public static int lastIndexOf(int[] iArr, int i) {
        return lastIndexOf(iArr, i, (int) ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
    }

    public static int lastIndexOf(int[] iArr, int i, int i2) {
        if (iArr == null || i2 < 0) {
            return -1;
        }
        if (i2 >= iArr.length) {
            i2 = iArr.length - 1;
        }
        for (int i3 = i2; i3 >= 0; i3--) {
            if (i == iArr[i3]) {
                return i3;
            }
        }
        return -1;
    }

    public static boolean contains(int[] iArr, int i) {
        return indexOf(iArr, i) != -1;
    }

    public static int indexOf(short[] sArr, short s) {
        return indexOf(sArr, s, 0);
    }

    public static int indexOf(short[] sArr, short s, int i) {
        if (sArr == null) {
            return -1;
        }
        if (i < 0) {
            i = 0;
        }
        while (i < sArr.length) {
            if (s == sArr[i]) {
                return i;
            }
            i++;
        }
        return -1;
    }

    public static int lastIndexOf(short[] sArr, short s) {
        return lastIndexOf(sArr, s, (int) ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
    }

    public static int lastIndexOf(short[] sArr, short s, int i) {
        if (sArr == null || i < 0) {
            return -1;
        }
        if (i >= sArr.length) {
            i = sArr.length - 1;
        }
        for (int i2 = i; i2 >= 0; i2--) {
            if (s == sArr[i2]) {
                return i2;
            }
        }
        return -1;
    }

    public static boolean contains(short[] sArr, short s) {
        return indexOf(sArr, s) != -1;
    }

    public static int indexOf(byte[] bArr, byte b) {
        return indexOf(bArr, b, 0);
    }

    public static int indexOf(byte[] bArr, byte b, int i) {
        if (bArr == null) {
            return -1;
        }
        if (i < 0) {
            i = 0;
        }
        while (i < bArr.length) {
            if (b == bArr[i]) {
                return i;
            }
            i++;
        }
        return -1;
    }

    public static int lastIndexOf(byte[] bArr, byte b) {
        return lastIndexOf(bArr, b, (int) ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
    }

    public static int lastIndexOf(byte[] bArr, byte b, int i) {
        if (bArr == null || i < 0) {
            return -1;
        }
        if (i >= bArr.length) {
            i = bArr.length - 1;
        }
        for (int i2 = i; i2 >= 0; i2--) {
            if (b == bArr[i2]) {
                return i2;
            }
        }
        return -1;
    }

    public static boolean contains(byte[] bArr, byte b) {
        return indexOf(bArr, b) != -1;
    }

    public static int indexOf(double[] dArr, double d) {
        return indexOf(dArr, d, 0);
    }

    public static int indexOf(double[] dArr, double d, double d2) {
        return indexOf(dArr, d, 0, d2);
    }

    public static int indexOf(double[] dArr, double d, int i) {
        if (dArr == null || dArr.length == 0) {
            return -1;
        }
        if (i < 0) {
            i = 0;
        }
        while (i < dArr.length) {
            if (d == dArr[i]) {
                return i;
            }
            i++;
        }
        return -1;
    }

    public static int indexOf(double[] dArr, double d, int i, double d2) {
        if (dArr == null || dArr.length == 0) {
            return -1;
        }
        if (i < 0) {
            i = 0;
        }
        double d3 = d - d2;
        double d4 = d + d2;
        while (i < dArr.length) {
            if (dArr[i] >= d3 && dArr[i] <= d4) {
                return i;
            }
            i++;
        }
        return -1;
    }

    public static int lastIndexOf(double[] dArr, double d) {
        return lastIndexOf(dArr, d, (int) ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
    }

    public static int lastIndexOf(double[] dArr, double d, double d2) {
        return lastIndexOf(dArr, d, ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED, d2);
    }

    public static int lastIndexOf(double[] dArr, double d, int i) {
        if (dArr == null || dArr.length == 0 || i < 0) {
            return -1;
        }
        if (i >= dArr.length) {
            i = dArr.length - 1;
        }
        for (int i2 = i; i2 >= 0; i2--) {
            if (d == dArr[i2]) {
                return i2;
            }
        }
        return -1;
    }

    public static int lastIndexOf(double[] dArr, double d, int i, double d2) {
        if (dArr == null || dArr.length == 0 || i < 0) {
            return -1;
        }
        if (i >= dArr.length) {
            i = dArr.length - 1;
        }
        double d3 = d - d2;
        double d4 = d + d2;
        int i2 = i;
        while (i2 >= 0) {
            if (dArr[i2] >= d3 && dArr[i2] <= d4) {
                return i2;
            }
            i2--;
        }
        return -1;
    }

    public static boolean contains(double[] dArr, double d) {
        return indexOf(dArr, d) != -1;
    }

    public static boolean contains(double[] dArr, double d, double d2) {
        return indexOf(dArr, d, 0, d2) != -1;
    }

    public static int indexOf(float[] fArr, float f) {
        return indexOf(fArr, f, 0);
    }

    public static int indexOf(float[] fArr, float f, int i) {
        if (fArr == null || fArr.length == 0) {
            return -1;
        }
        if (i < 0) {
            i = 0;
        }
        while (i < fArr.length) {
            if (f == fArr[i]) {
                return i;
            }
            i++;
        }
        return -1;
    }

    public static int lastIndexOf(float[] fArr, float f) {
        return lastIndexOf(fArr, f, (int) ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
    }

    public static int lastIndexOf(float[] fArr, float f, int i) {
        if (fArr == null || fArr.length == 0 || i < 0) {
            return -1;
        }
        if (i >= fArr.length) {
            i = fArr.length - 1;
        }
        for (int i2 = i; i2 >= 0; i2--) {
            if (f == fArr[i2]) {
                return i2;
            }
        }
        return -1;
    }

    public static boolean contains(float[] fArr, float f) {
        return indexOf(fArr, f) != -1;
    }

    public static int indexOf(boolean[] zArr, boolean z) {
        return indexOf(zArr, z, 0);
    }

    public static int indexOf(boolean[] zArr, boolean z, int i) {
        if (zArr == null || zArr.length == 0) {
            return -1;
        }
        if (i < 0) {
            i = 0;
        }
        while (i < zArr.length) {
            if (z == zArr[i]) {
                return i;
            }
            i++;
        }
        return -1;
    }

    public static int lastIndexOf(boolean[] zArr, boolean z) {
        return lastIndexOf(zArr, z, (int) ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
    }

    public static int lastIndexOf(boolean[] zArr, boolean z, int i) {
        if (zArr == null || zArr.length == 0 || i < 0) {
            return -1;
        }
        if (i >= zArr.length) {
            i = zArr.length - 1;
        }
        for (int i2 = i; i2 >= 0; i2--) {
            if (z == zArr[i2]) {
                return i2;
            }
        }
        return -1;
    }

    public static boolean contains(boolean[] zArr, boolean z) {
        return indexOf(zArr, z) != -1;
    }

    public static long[] toPrimitive(Long[] lArr) {
        if (lArr == null) {
            return null;
        }
        if (lArr.length == 0) {
            return EMPTY_LONG_ARRAY;
        }
        long[] jArr = new long[lArr.length];
        for (int i = 0; i < lArr.length; i++) {
            jArr[i] = lArr[i].longValue();
        }
        return jArr;
    }

    public static long[] toPrimitive(Long[] lArr, long j) {
        if (lArr == null) {
            return null;
        }
        if (lArr.length == 0) {
            return EMPTY_LONG_ARRAY;
        }
        long[] jArr = new long[lArr.length];
        for (int i = 0; i < lArr.length; i++) {
            Long l = lArr[i];
            jArr[i] = l == null ? j : l.longValue();
        }
        return jArr;
    }

    public static Long[] toObject(long[] jArr) {
        if (jArr == null) {
            return null;
        }
        if (jArr.length == 0) {
            return EMPTY_LONG_OBJECT_ARRAY;
        }
        Long[] lArr = new Long[jArr.length];
        for (int i = 0; i < jArr.length; i++) {
            lArr[i] = new Long(jArr[i]);
        }
        return lArr;
    }

    public static int[] toPrimitive(Integer[] numArr) {
        if (numArr == null) {
            return null;
        }
        if (numArr.length == 0) {
            return EMPTY_INT_ARRAY;
        }
        int[] iArr = new int[numArr.length];
        for (int i = 0; i < numArr.length; i++) {
            iArr[i] = numArr[i].intValue();
        }
        return iArr;
    }

    public static int[] toPrimitive(Integer[] numArr, int i) {
        if (numArr == null) {
            return null;
        }
        if (numArr.length == 0) {
            return EMPTY_INT_ARRAY;
        }
        int[] iArr = new int[numArr.length];
        for (int i2 = 0; i2 < numArr.length; i2++) {
            Integer num = numArr[i2];
            iArr[i2] = num == null ? i : num.intValue();
        }
        return iArr;
    }

    public static Integer[] toObject(int[] iArr) {
        if (iArr == null) {
            return null;
        }
        if (iArr.length == 0) {
            return EMPTY_INTEGER_OBJECT_ARRAY;
        }
        Integer[] numArr = new Integer[iArr.length];
        for (int i = 0; i < iArr.length; i++) {
            numArr[i] = new Integer(iArr[i]);
        }
        return numArr;
    }

    public static short[] toPrimitive(Short[] shArr) {
        if (shArr == null) {
            return null;
        }
        if (shArr.length == 0) {
            return EMPTY_SHORT_ARRAY;
        }
        short[] sArr = new short[shArr.length];
        for (int i = 0; i < shArr.length; i++) {
            sArr[i] = shArr[i].shortValue();
        }
        return sArr;
    }

    public static short[] toPrimitive(Short[] shArr, short s) {
        if (shArr == null) {
            return null;
        }
        if (shArr.length == 0) {
            return EMPTY_SHORT_ARRAY;
        }
        short[] sArr = new short[shArr.length];
        for (int i = 0; i < shArr.length; i++) {
            Short sh = shArr[i];
            sArr[i] = sh == null ? s : sh.shortValue();
        }
        return sArr;
    }

    public static Short[] toObject(short[] sArr) {
        if (sArr == null) {
            return null;
        }
        if (sArr.length == 0) {
            return EMPTY_SHORT_OBJECT_ARRAY;
        }
        Short[] shArr = new Short[sArr.length];
        for (int i = 0; i < sArr.length; i++) {
            shArr[i] = new Short(sArr[i]);
        }
        return shArr;
    }

    public static byte[] toPrimitive(Byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        if (bArr.length == 0) {
            return EMPTY_BYTE_ARRAY;
        }
        byte[] bArr2 = new byte[bArr.length];
        for (int i = 0; i < bArr.length; i++) {
            bArr2[i] = bArr[i].byteValue();
        }
        return bArr2;
    }

    public static byte[] toPrimitive(Byte[] bArr, byte b) {
        if (bArr == null) {
            return null;
        }
        if (bArr.length == 0) {
            return EMPTY_BYTE_ARRAY;
        }
        byte[] bArr2 = new byte[bArr.length];
        for (int i = 0; i < bArr.length; i++) {
            Byte b2 = bArr[i];
            bArr2[i] = b2 == null ? b : b2.byteValue();
        }
        return bArr2;
    }

    public static Byte[] toObject(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        if (bArr.length == 0) {
            return EMPTY_BYTE_OBJECT_ARRAY;
        }
        Byte[] bArr2 = new Byte[bArr.length];
        for (int i = 0; i < bArr.length; i++) {
            bArr2[i] = new Byte(bArr[i]);
        }
        return bArr2;
    }

    public static double[] toPrimitive(Double[] dArr) {
        if (dArr == null) {
            return null;
        }
        if (dArr.length == 0) {
            return EMPTY_DOUBLE_ARRAY;
        }
        double[] dArr2 = new double[dArr.length];
        for (int i = 0; i < dArr.length; i++) {
            dArr2[i] = dArr[i].doubleValue();
        }
        return dArr2;
    }

    public static double[] toPrimitive(Double[] dArr, double d) {
        if (dArr == null) {
            return null;
        }
        if (dArr.length == 0) {
            return EMPTY_DOUBLE_ARRAY;
        }
        double[] dArr2 = new double[dArr.length];
        for (int i = 0; i < dArr.length; i++) {
            Double d2 = dArr[i];
            dArr2[i] = d2 == null ? d : d2.doubleValue();
        }
        return dArr2;
    }

    public static Double[] toObject(double[] dArr) {
        if (dArr == null) {
            return null;
        }
        if (dArr.length == 0) {
            return EMPTY_DOUBLE_OBJECT_ARRAY;
        }
        Double[] dArr2 = new Double[dArr.length];
        for (int i = 0; i < dArr.length; i++) {
            dArr2[i] = new Double(dArr[i]);
        }
        return dArr2;
    }

    public static float[] toPrimitive(Float[] fArr) {
        if (fArr == null) {
            return null;
        }
        if (fArr.length == 0) {
            return EMPTY_FLOAT_ARRAY;
        }
        float[] fArr2 = new float[fArr.length];
        for (int i = 0; i < fArr.length; i++) {
            fArr2[i] = fArr[i].floatValue();
        }
        return fArr2;
    }

    public static float[] toPrimitive(Float[] fArr, float f) {
        if (fArr == null) {
            return null;
        }
        if (fArr.length == 0) {
            return EMPTY_FLOAT_ARRAY;
        }
        float[] fArr2 = new float[fArr.length];
        for (int i = 0; i < fArr.length; i++) {
            Float f2 = fArr[i];
            fArr2[i] = f2 == null ? f : f2.floatValue();
        }
        return fArr2;
    }

    public static Float[] toObject(float[] fArr) {
        if (fArr == null) {
            return null;
        }
        if (fArr.length == 0) {
            return EMPTY_FLOAT_OBJECT_ARRAY;
        }
        Float[] fArr2 = new Float[fArr.length];
        for (int i = 0; i < fArr.length; i++) {
            fArr2[i] = new Float(fArr[i]);
        }
        return fArr2;
    }

    public static boolean[] toPrimitive(Boolean[] boolArr) {
        if (boolArr == null) {
            return null;
        }
        if (boolArr.length == 0) {
            return EMPTY_BOOLEAN_ARRAY;
        }
        boolean[] zArr = new boolean[boolArr.length];
        for (int i = 0; i < boolArr.length; i++) {
            zArr[i] = boolArr[i].booleanValue();
        }
        return zArr;
    }

    public static boolean[] toPrimitive(Boolean[] boolArr, boolean z) {
        if (boolArr == null) {
            return null;
        }
        if (boolArr.length == 0) {
            return EMPTY_BOOLEAN_ARRAY;
        }
        boolean[] zArr = new boolean[boolArr.length];
        for (int i = 0; i < boolArr.length; i++) {
            Boolean bool = boolArr[i];
            zArr[i] = bool == null ? z : bool.booleanValue();
        }
        return zArr;
    }

    public static Boolean[] toObject(boolean[] zArr) {
        if (zArr == null) {
            return null;
        }
        if (zArr.length == 0) {
            return EMPTY_BOOLEAN_OBJECT_ARRAY;
        }
        Boolean[] boolArr = new Boolean[zArr.length];
        for (int i = 0; i < zArr.length; i++) {
            boolArr[i] = zArr[i] ? Boolean.TRUE : Boolean.FALSE;
        }
        return boolArr;
    }
}
