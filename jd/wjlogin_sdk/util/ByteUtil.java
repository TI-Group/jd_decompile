package jd.wjlogin_sdk.util;

/* compiled from: TbsSdkJava */
public class ByteUtil {
    public static byte[] longToByte(long j) {
        byte[] bArr = new byte[8];
        for (int i = 0; i < bArr.length; i++) {
            bArr[i] = new Long(255 & j).byteValue();
            j >>= 8;
        }
        return bArr;
    }

    public static byte[] intToByte(int i) {
        byte[] bArr = new byte[4];
        for (int i2 = 0; i2 < bArr.length; i2++) {
            bArr[i2] = new Integer(i & 255).byteValue();
            i >>= 8;
        }
        return bArr;
    }

    public static byte[] shortToByte(short s) {
        byte[] bArr = new byte[2];
        for (int i = 0; i < bArr.length; i++) {
            bArr[i] = new Integer(s & 255).byteValue();
            s >>= 8;
        }
        return bArr;
    }

    public static long byteToLong(byte[] bArr) {
        long j = ((long) (bArr[0] & 255)) | (((long) (bArr[1] & 255)) << 8);
        j |= ((long) (bArr[2] & 255)) << 16;
        j |= ((long) (bArr[3] & 255)) << 24;
        j |= ((long) (bArr[4] & 255)) << 32;
        j |= ((long) (bArr[5] & 255)) << 40;
        return (j | (((long) (bArr[6] & 255)) << 48)) | (((long) (bArr[7] & 255)) << 56);
    }

    public static int byteToInt(byte[] bArr) {
        int i = (bArr[0] & 255) | ((bArr[1] & 255) << 8);
        return (i | ((bArr[2] & 255) << 16)) | ((bArr[3] & 255) << 24);
    }

    public static short byteToShort(byte[] bArr) {
        return (short) (((short) (bArr[0] & 255)) | ((short) (((short) (bArr[1] & 255)) << 8)));
    }

    public static String parseByte2HexStr(byte[] bArr) {
        StringBuffer stringBuffer = new StringBuffer();
        for (byte b : bArr) {
            String toHexString = Integer.toHexString(b & 255);
            if (toHexString.length() == 1) {
                toHexString = new StringBuilder(String.valueOf('0')).append(toHexString).toString();
            }
            stringBuffer.append(toHexString);
        }
        return stringBuffer.toString();
    }

    public static byte[] parseHexStr2Byte(String str) {
        if (str.length() < 1) {
            return null;
        }
        byte[] bArr = new byte[(str.length() / 2)];
        for (int i = 0; i < str.length() / 2; i++) {
            bArr[i] = (byte) ((Integer.parseInt(str.substring(i * 2, (i * 2) + 1), 16) * 16) + Integer.parseInt(str.substring((i * 2) + 1, (i * 2) + 2), 16));
        }
        return bArr;
    }
}
