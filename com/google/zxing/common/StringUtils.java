package com.google.zxing.common;

import com.google.zxing.DecodeHintType;
import java.nio.charset.Charset;
import java.util.Map;

/* compiled from: TbsSdkJava */
public final class StringUtils {
    private static final boolean ASSUME_SHIFT_JIS;
    private static final String EUC_JP = "EUC_JP";
    public static final String GB2312 = "GB2312";
    private static final String ISO88591 = "ISO8859_1";
    private static final String PLATFORM_DEFAULT_ENCODING = Charset.defaultCharset().name();
    public static final String SHIFT_JIS = "SJIS";
    private static final String UTF8 = "UTF8";

    static {
        boolean z = SHIFT_JIS.equalsIgnoreCase(PLATFORM_DEFAULT_ENCODING) || EUC_JP.equalsIgnoreCase(PLATFORM_DEFAULT_ENCODING);
        ASSUME_SHIFT_JIS = z;
    }

    private StringUtils() {
    }

    public static String guessEncoding(byte[] bArr, Map<DecodeHintType, ?> map) {
        Object obj;
        if (map != null) {
            String str = (String) map.get(DecodeHintType.CHARACTER_SET);
            if (str != null) {
                return str;
            }
        }
        int length = bArr.length;
        Object obj2 = 1;
        Object obj3 = 1;
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        int i8 = 0;
        int i9 = 0;
        Object obj4 = (bArr.length > 3 && bArr[0] == (byte) -17 && bArr[1] == (byte) -69 && bArr[2] == (byte) -65) ? 1 : null;
        int i10 = 0;
        int i11 = 0;
        int i12 = 0;
        Object obj5 = 1;
        while (i10 < length && (obj2 != null || obj3 != null || obj5 != null)) {
            Object obj6;
            int i13;
            Object obj7;
            int i14;
            int i15;
            int i16 = bArr[i10] & 255;
            if (obj5 != null) {
                if (i > 0) {
                    if ((i16 & 128) == 0) {
                        obj6 = null;
                    } else {
                        i--;
                        obj6 = obj5;
                    }
                } else if ((i16 & 128) != 0) {
                    if ((i16 & 64) == 0) {
                        obj6 = null;
                    } else {
                        i++;
                        if ((i16 & 32) == 0) {
                            i2++;
                            obj6 = obj5;
                        } else {
                            i++;
                            if ((i16 & 16) == 0) {
                                i3++;
                                obj6 = obj5;
                            } else {
                                i++;
                                if ((i16 & 8) == 0) {
                                    i4++;
                                    obj6 = obj5;
                                } else {
                                    obj6 = null;
                                }
                            }
                        }
                    }
                }
                if (obj2 != null) {
                    if (i16 <= 127 && i16 < 160) {
                        obj2 = null;
                    } else if (i16 > 159 && (i16 < 192 || i16 == 215 || i16 == 247)) {
                        i9++;
                    }
                }
                if (obj3 != null) {
                    i13 = i7;
                    i7 = i6;
                    i6 = i5;
                    obj7 = obj3;
                    i14 = i8;
                    i8 = i12;
                    i12 = i14;
                } else if (i5 <= 0) {
                    if (i16 >= 64 || i16 == 127 || i16 > 252) {
                        i14 = i8;
                        i8 = i12;
                        i12 = i14;
                        i15 = i7;
                        i7 = i6;
                        i6 = i5;
                        obj7 = null;
                        i13 = i15;
                    } else {
                        i13 = i5 - 1;
                        obj7 = obj3;
                        i14 = i12;
                        i12 = i8;
                        i8 = i14;
                        i15 = i6;
                        i6 = i13;
                        i13 = i7;
                        i7 = i15;
                    }
                } else if (i16 != 128 || i16 == 160 || i16 > 239) {
                    i14 = i8;
                    i8 = i12;
                    i12 = i14;
                    i15 = i7;
                    i7 = i6;
                    i6 = i5;
                    obj7 = null;
                    i13 = i15;
                } else if (i16 > 160 && i16 < 224) {
                    i6++;
                    i12 = i7 + 1;
                    if (i12 > i8) {
                        i8 = 0;
                        i7 = i6;
                        i13 = i12;
                        i6 = i5;
                        obj7 = obj3;
                    } else {
                        i7 = i6;
                        i6 = i5;
                        obj7 = obj3;
                        i14 = i8;
                        i8 = 0;
                        i13 = i12;
                        i12 = i14;
                    }
                } else if (i16 > 127) {
                    i7 = i5 + 1;
                    i13 = 0;
                    i12++;
                    if (i12 > i11) {
                        i11 = i12;
                        obj7 = obj3;
                        i14 = i12;
                        i12 = i8;
                        i8 = i14;
                        i15 = i7;
                        i7 = i6;
                        i6 = i15;
                    } else {
                        obj7 = obj3;
                        i14 = i12;
                        i12 = i8;
                        i8 = i14;
                        i15 = i7;
                        i7 = i6;
                        i6 = i15;
                    }
                } else {
                    i13 = 0;
                    i7 = i6;
                    i6 = i5;
                    obj7 = obj3;
                    i12 = i8;
                    i8 = 0;
                }
                i10++;
                obj3 = obj7;
                i5 = i6;
                i6 = i7;
                i7 = i13;
                obj5 = obj6;
                i14 = i8;
                i8 = i12;
                i12 = i14;
            }
            obj6 = obj5;
            if (obj2 != null) {
                if (i16 <= 127) {
                }
                i9++;
            }
            if (obj3 != null) {
                i13 = i7;
                i7 = i6;
                i6 = i5;
                obj7 = obj3;
                i14 = i8;
                i8 = i12;
                i12 = i14;
            } else if (i5 <= 0) {
                if (i16 != 128) {
                }
                i14 = i8;
                i8 = i12;
                i12 = i14;
                i15 = i7;
                i7 = i6;
                i6 = i5;
                obj7 = null;
                i13 = i15;
            } else {
                if (i16 >= 64) {
                }
                i14 = i8;
                i8 = i12;
                i12 = i14;
                i15 = i7;
                i7 = i6;
                i6 = i5;
                obj7 = null;
                i13 = i15;
            }
            i10++;
            obj3 = obj7;
            i5 = i6;
            i6 = i7;
            i7 = i13;
            obj5 = obj6;
            i14 = i8;
            i8 = i12;
            i12 = i14;
        }
        if (obj5 == null || i <= 0) {
            obj = obj5;
        } else {
            obj = null;
        }
        if (obj3 != null && i5 > 0) {
            obj3 = null;
        }
        if (obj != null && (obj4 != null || (i2 + i3) + i4 > 0)) {
            return UTF8;
        }
        if (obj3 != null && (ASSUME_SHIFT_JIS || i8 >= 3 || i11 >= 3)) {
            return SHIFT_JIS;
        }
        if (obj2 != null && obj3 != null) {
            return (!(i8 == 2 && i6 == 2) && i9 * 10 < length) ? ISO88591 : SHIFT_JIS;
        } else {
            if (obj2 != null) {
                return ISO88591;
            }
            if (obj3 != null) {
                return SHIFT_JIS;
            }
            if (obj != null) {
                return UTF8;
            }
            return PLATFORM_DEFAULT_ENCODING;
        }
    }
}
