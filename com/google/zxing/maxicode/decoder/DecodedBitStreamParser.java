package com.google.zxing.maxicode.decoder;

import com.google.zxing.common.DecoderResult;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import jd.wjlogin_sdk.util.ReplyCode;

/* compiled from: TbsSdkJava */
final class DecodedBitStreamParser {
    private static final char ECI = '￺';
    private static final char FS = '\u001c';
    private static final char GS = '\u001d';
    private static final char LATCHA = '￷';
    private static final char LATCHB = '￸';
    private static final char LOCK = '￹';
    private static final NumberFormat NINE_DIGITS = new DecimalFormat("000000000");
    private static final char NS = '￻';
    private static final char PAD = '￼';
    private static final char RS = '\u001e';
    private static final String[] SETS = new String[]{"\nABCDEFGHIJKLMNOPQRSTUVWXYZ￺\u001c\u001d\u001e￻ ￼\"#$%&'()*+,-./0123456789:￱￲￳￴￸", "`abcdefghijklmnopqrstuvwxyz￺\u001c\u001d\u001e￻{￼}~;<=>?[\\]^_ ,./:@!|￼￵￶￼￰￲￳￴￷", "ÀÁÂÃÄÅÆÇÈÉÊËÌÍÎÏÐÑÒÓÔÕÖ×ØÙÚ￺\u001c\u001d\u001eÛÜÝÞßª¬±²³µ¹º¼½¾￷ ￹￳￴￸", "àáâãäåæçèéêëìíîïðñòóôõö÷øùú￺\u001c\u001d\u001e￻ûüýþÿ¡¨«¯°´·¸»¿￷ ￲￹￴￸", "\u0000\u0001\u0002\u0003\u0004\u0005\u0006\u0007\b\t\n\u000b\f\r\u000e\u000f\u0010\u0011\u0012\u0013\u0014\u0015\u0016\u0017\u0018\u0019\u001a￺￼￼\u001b￻\u001c\u001d\u001e\u001f ¢£¤¥¦§©­®¶￷ ￲￳￹￸", "\u0000\u0001\u0002\u0003\u0004\u0005\u0006\u0007\b\t\n\u000b\f\r\u000e\u000f\u0010\u0011\u0012\u0013\u0014\u0015\u0016\u0017\u0018\u0019\u001a\u001b\u001c\u001d\u001e\u001f !\"#$%&'()*+,-./0123456789:;<=>?"};
    private static final char SHIFTA = '￰';
    private static final char SHIFTB = '￱';
    private static final char SHIFTC = '￲';
    private static final char SHIFTD = '￳';
    private static final char SHIFTE = '￴';
    private static final char THREESHIFTA = '￶';
    private static final NumberFormat THREE_DIGITS = new DecimalFormat("000");
    private static final char TWOSHIFTA = '￵';

    private DecodedBitStreamParser() {
    }

    static DecoderResult decode(byte[] bArr, int i) {
        StringBuilder stringBuilder = new StringBuilder(144);
        switch (i) {
            case 2:
            case 3:
                String format;
                if (i == 2) {
                    format = new DecimalFormat("0000000000".substring(0, getPostCode2Length(bArr))).format((long) getPostCode2(bArr));
                } else {
                    format = getPostCode3(bArr);
                }
                String format2 = THREE_DIGITS.format((long) getCountry(bArr));
                String format3 = THREE_DIGITS.format((long) getServiceClass(bArr));
                stringBuilder.append(getMessage(bArr, 10, 84));
                if (!stringBuilder.toString().startsWith("[)>\u001e01\u001d")) {
                    stringBuilder.insert(0, format + GS + format2 + GS + format3 + GS);
                    break;
                }
                stringBuilder.insert(9, format + GS + format2 + GS + format3 + GS);
                break;
            case 4:
                stringBuilder.append(getMessage(bArr, 1, 93));
                break;
            case 5:
                stringBuilder.append(getMessage(bArr, 1, 77));
                break;
        }
        return new DecoderResult(bArr, stringBuilder.toString(), null, String.valueOf(i));
    }

    private static int getBit(int i, byte[] bArr) {
        int i2 = i - 1;
        if (((1 << (5 - (i2 % 6))) & bArr[i2 / 6]) == 0) {
            return 0;
        }
        return 1;
    }

    private static int getInt(byte[] bArr, byte[] bArr2) {
        int i = 0;
        if (bArr2.length == 0) {
            throw new IllegalArgumentException();
        }
        int i2 = 0;
        while (i < bArr2.length) {
            i2 += getBit(bArr2[i], bArr) << ((bArr2.length - i) - 1);
            i++;
        }
        return i2;
    }

    private static int getCountry(byte[] bArr) {
        return getInt(bArr, new byte[]{ReplyCode.reply0x35, ReplyCode.reply0x36, (byte) 43, (byte) 44, (byte) 45, (byte) 46, (byte) 47, (byte) 48, ReplyCode.reply0x25, ReplyCode.reply0x26});
    }

    private static int getServiceClass(byte[] bArr) {
        return getInt(bArr, new byte[]{ReplyCode.reply0x37, ReplyCode.reply0x38, ReplyCode.reply0x39, (byte) 58, (byte) 59, (byte) 60, (byte) 49, ReplyCode.reply0x32, (byte) 51, ReplyCode.reply0x34});
    }

    private static int getPostCode2Length(byte[] bArr) {
        return getInt(bArr, new byte[]{ReplyCode.reply0x27, ReplyCode.reply0x28, ReplyCode.reply0x29, (byte) 42, ReplyCode.reply0x1f, ReplyCode.reply0x20});
    }

    private static int getPostCode2(byte[] bArr) {
        return getInt(bArr, new byte[]{ReplyCode.reply0x21, ReplyCode.reply0x22, ReplyCode.reply0x23, ReplyCode.reply0x24, ReplyCode.reply0x19, ReplyCode.reply0x1a, ReplyCode.reply0x1b, ReplyCode.reply0x1c, ReplyCode.reply0x1d, ReplyCode.reply0x1e, ReplyCode.reply0x13, ReplyCode.reply0x14, ReplyCode.reply0x15, ReplyCode.reply0x16, ReplyCode.reply0x17, ReplyCode.reply0x18, ReplyCode.reply0xd, ReplyCode.reply0xe, ReplyCode.reply0xf, ReplyCode.reply0x10, ReplyCode.reply0x11, ReplyCode.reply0x12, (byte) 7, (byte) 8, (byte) 9, (byte) 10, ReplyCode.reply0xb, ReplyCode.reply0xc, (byte) 1, (byte) 2});
    }

    private static String getPostCode3(byte[] bArr) {
        return String.valueOf(new char[]{SETS[0].charAt(getInt(bArr, new byte[]{ReplyCode.reply0x27, ReplyCode.reply0x28, ReplyCode.reply0x29, (byte) 42, ReplyCode.reply0x1f, ReplyCode.reply0x20})), SETS[0].charAt(getInt(bArr, new byte[]{ReplyCode.reply0x21, ReplyCode.reply0x22, ReplyCode.reply0x23, ReplyCode.reply0x24, ReplyCode.reply0x19, ReplyCode.reply0x1a})), SETS[0].charAt(getInt(bArr, new byte[]{ReplyCode.reply0x1b, ReplyCode.reply0x1c, ReplyCode.reply0x1d, ReplyCode.reply0x1e, ReplyCode.reply0x13, ReplyCode.reply0x14})), SETS[0].charAt(getInt(bArr, new byte[]{ReplyCode.reply0x15, ReplyCode.reply0x16, ReplyCode.reply0x17, ReplyCode.reply0x18, ReplyCode.reply0xd, ReplyCode.reply0xe})), SETS[0].charAt(getInt(bArr, new byte[]{ReplyCode.reply0xf, ReplyCode.reply0x10, ReplyCode.reply0x11, ReplyCode.reply0x12, (byte) 7, (byte) 8})), SETS[0].charAt(getInt(bArr, new byte[]{(byte) 9, (byte) 10, ReplyCode.reply0xb, ReplyCode.reply0xc, (byte) 1, (byte) 2}))});
    }

    private static String getMessage(byte[] bArr, int i, int i2) {
        StringBuilder stringBuilder = new StringBuilder();
        int i3 = i;
        int i4 = 0;
        int i5 = 0;
        int i6 = -1;
        while (i3 < i + i2) {
            int i7;
            char charAt = SETS[i5].charAt(bArr[i3]);
            switch (charAt) {
                case '￰':
                case '￱':
                case '￲':
                case '￳':
                case '￴':
                    i6 = 1;
                    i7 = i5;
                    i5 = i3;
                    i3 = charAt - 65520;
                    i4 = i7;
                    break;
                case '￵':
                    i6 = 2;
                    i4 = i5;
                    i5 = i3;
                    i3 = 0;
                    break;
                case '￶':
                    i6 = 3;
                    i4 = i5;
                    i5 = i3;
                    i3 = 0;
                    break;
                case '￷':
                    i5 = i3;
                    i6 = -1;
                    i3 = 0;
                    break;
                case '￸':
                    i5 = i3;
                    i6 = -1;
                    i3 = 1;
                    break;
                case '￹':
                    i6 = -1;
                    i7 = i5;
                    i5 = i3;
                    i3 = i7;
                    break;
                case '￻':
                    i3++;
                    i3++;
                    i3++;
                    i3++;
                    i3++;
                    stringBuilder.append(NINE_DIGITS.format((long) (((((bArr[i3] << 24) + (bArr[i3] << 18)) + (bArr[i3] << 12)) + (bArr[i3] << 6)) + bArr[i3])));
                    i7 = i3;
                    i3 = i5;
                    i5 = i7;
                    break;
                default:
                    stringBuilder.append(charAt);
                    i7 = i3;
                    i3 = i5;
                    i5 = i7;
                    break;
            }
            int i8 = i6 - 1;
            if (i6 == 0) {
                i3 = i4;
            }
            i6 = i8;
            i7 = i3;
            i3 = i5 + 1;
            i5 = i7;
        }
        while (stringBuilder.length() > 0 && stringBuilder.charAt(stringBuilder.length() - 1) == PAD) {
            stringBuilder.setLength(stringBuilder.length() - 1);
        }
        return stringBuilder.toString();
    }
}
