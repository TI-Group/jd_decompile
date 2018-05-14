package com.google.zxing.datamatrix.encoder;

import android.support.v4.media.TransportMediator;
import android.support.v7.widget.helper.ItemTouchHelper.Callback;
import com.tencent.smtt.sdk.TbsListener.ErrorCode;

/* compiled from: TbsSdkJava */
public final class ErrorCorrection {
    private static final int[] ALOG = new int[255];
    private static final int[][] FACTORS = new int[][]{new int[]{228, 48, 15, 111, 62}, new int[]{23, 68, 144, 134, 240, 92, 254}, new int[]{28, 24, 185, 166, ErrorCode.EXCEED_LZMA_RETRY_NUM, 248, 116, 255, 110, 61}, new int[]{175, 138, 205, 12, 194, 168, 39, 245, 60, 97, ErrorCode.DOWNLOAD_HAS_LOCAL_TBS_ERROR}, new int[]{41, 153, 158, 91, 61, 42, 142, ErrorCode.COPY_SRCDIR_ERROR, 97, 178, 100, 242}, new int[]{156, 97, 192, 252, 95, 9, 157, 119, 138, 45, 18, 186, 83, 185}, new int[]{83, 195, 100, 39, 188, 75, 66, 61, 241, ErrorCode.COPY_SRCDIR_ERROR, 109, 129, 94, 254, ErrorCode.CREATE_TEMP_CONF_ERROR, 48, 90, 188}, new int[]{15, 195, 244, 9, 233, 71, 168, 2, 188, 160, 153, 145, 253, 79, 108, 82, 27, 174, 186, 172}, new int[]{52, 190, 88, 205, 109, 39, 176, 21, 155, 197, 251, ErrorCode.EXCEED_LZMA_RETRY_NUM, 155, 21, 5, 172, 254, ErrorCode.DOWNLOAD_REDIRECT_EMPTY, 12, 181, 184, 96, 50, 193}, new int[]{ErrorCode.EXCEED_COPY_RETRY_NUM, 231, 43, 97, 71, 96, 103, 174, 37, 151, 170, 53, 75, 34, 249, ErrorCode.THREAD_INIT_ERROR, 17, 138, 110, ErrorCode.COPY_SRCDIR_ERROR, 141, 136, ErrorCode.DOWNLOAD_HAS_LOCAL_TBS_ERROR, 151, 233, 168, 93, 255}, new int[]{245, TransportMediator.KEYCODE_MEDIA_PAUSE, 242, ErrorCode.INCR_UPDATE_EXCEPTION, TransportMediator.KEYCODE_MEDIA_RECORD, Callback.DEFAULT_SWIPE_ANIMATION_DURATION, 162, 181, 102, ErrorCode.DOWNLOAD_HAS_LOCAL_TBS_ERROR, 84, 179, ErrorCode.COPY_INSTALL_SUCCESS, 251, 80, 182, 229, 18, 2, 4, 68, 33, 101, 137, 95, 119, 115, 44, 175, 184, 59, 25, ErrorCode.CREATE_TEMP_CONF_ERROR, 98, 81, 112}, new int[]{77, 193, 137, 31, 19, 38, 22, 153, 247, 105, ErrorCode.DOWNLOAD_HAS_COPY_TBS_ERROR, 2, 245, 133, 242, 8, 175, 95, 100, 9, 167, 105, ErrorCode.COPY_TMPDIR_ERROR, 111, 57, ErrorCode.THREAD_INIT_ERROR, 21, 1, 253, 57, 54, 101, 248, 202, 69, 50, 150, 177, ErrorCode.DEXOAT_EXCEPTION, 5, 9, 5}, new int[]{245, 132, 172, ErrorCode.EXCEED_LZMA_RETRY_NUM, 96, 32, 117, 22, 238, 133, 238, 231, 205, 188, 237, 87, 191, 106, 16, 147, 118, 23, 37, 90, 170, 205, 131, 88, ErrorCode.DOWNLOAD_HAS_LOCAL_TBS_ERROR, 100, 66, 138, 186, 240, 82, 44, 176, 87, 187, 147, 160, 175, 69, ErrorCode.COPY_SRCDIR_ERROR, 92, 253, ErrorCode.CREATE_TEMP_CONF_ERROR, 19}, new int[]{175, 9, ErrorCode.EXCEED_LZMA_RETRY_NUM, 238, 12, 17, ErrorCode.COPY_INSTALL_SUCCESS, ErrorCode.EXCEED_DEXOPT_RETRY_NUM, 100, 29, 175, 170, 230, 192, ErrorCode.COPY_EXCEPTION, 235, 150, 159, 36, ErrorCode.EXCEED_LZMA_RETRY_NUM, 38, 200, 132, 54, 228, 146, ErrorCode.INCR_UPDATE_EXCEPTION, 234, 117, 203, 29, 232, 144, 238, 22, 150, 201, 117, 62, 207, 164, 13, 137, 245, TransportMediator.KEYCODE_MEDIA_PAUSE, 67, 247, 28, 155, 43, 203, 107, 233, 53, 143, 46}, new int[]{242, 93, 169, 50, 144, ErrorCode.ROM_NOT_ENOUGH, 39, 118, 202, 188, 201, 189, 143, 108, 196, 37, 185, 112, 134, 230, 245, 63, 197, 190, Callback.DEFAULT_SWIPE_ANIMATION_DURATION, 106, 185, ErrorCode.INCRUPDATE_INSTALL_SUCCESS, 175, 64, 114, 71, 161, 44, 147, 6, 27, ErrorCode.INCR_UPDATE_EXCEPTION, 51, 63, 87, 10, 40, TransportMediator.KEYCODE_MEDIA_RECORD, 188, 17, 163, 31, 176, 170, 4, 107, 232, 7, 94, 166, ErrorCode.EXCEED_INCR_UPDATE, ErrorCode.DOWNLOAD_REDIRECT_EMPTY, 86, 47, 11, 204}, new int[]{ErrorCode.COPY_INSTALL_SUCCESS, 228, 173, 89, 251, 149, 159, 56, 89, 33, 147, 244, 154, 36, 73, TransportMediator.KEYCODE_MEDIA_PAUSE, ErrorCode.COPY_SRCDIR_ERROR, 136, 248, 180, 234, 197, 158, 177, 68, ErrorCode.DOWNLOAD_HAS_COPY_TBS_ERROR, 93, ErrorCode.COPY_SRCDIR_ERROR, 15, 160, ErrorCode.HOST_CONTEXT_IS_NULL, 236, 66, 139, 153, 185, 202, 167, 179, 25, ErrorCode.COPY_INSTALL_SUCCESS, 232, 96, ErrorCode.ROM_NOT_ENOUGH, 231, 136, ErrorCode.EXCEED_LZMA_RETRY_NUM, 239, 181, 241, 59, 52, 172, 25, 49, 232, ErrorCode.EXCEED_COPY_RETRY_NUM, 189, 64, 54, 108, 153, 132, 63, 96, 103, 82, 186}};
    private static final int[] FACTOR_SETS = new int[]{5, 7, 10, 11, 12, 14, 18, 20, 24, 28, 36, 42, 48, 56, 62, 68};
    private static final int[] LOG = new int[256];
    private static final int MODULO_VALUE = 301;

    static {
        int i = 1;
        for (int i2 = 0; i2 < 255; i2++) {
            ALOG[i2] = i;
            LOG[i] = i2;
            i *= 2;
            if (i >= 256) {
                i ^= 301;
            }
        }
    }

    private ErrorCorrection() {
    }

    public static String encodeECC200(String str, SymbolInfo symbolInfo) {
        if (str.length() != symbolInfo.getDataCapacity()) {
            throw new IllegalArgumentException("The number of codewords does not match the selected symbol");
        }
        StringBuilder stringBuilder = new StringBuilder(symbolInfo.getDataCapacity() + symbolInfo.getErrorCodewords());
        stringBuilder.append(str);
        int interleavedBlockCount = symbolInfo.getInterleavedBlockCount();
        if (interleavedBlockCount == 1) {
            stringBuilder.append(createECCBlock(str, symbolInfo.getErrorCodewords()));
        } else {
            int i;
            stringBuilder.setLength(stringBuilder.capacity());
            int[] iArr = new int[interleavedBlockCount];
            int[] iArr2 = new int[interleavedBlockCount];
            int[] iArr3 = new int[interleavedBlockCount];
            for (i = 0; i < interleavedBlockCount; i++) {
                iArr[i] = symbolInfo.getDataLengthForInterleavedBlock(i + 1);
                iArr2[i] = symbolInfo.getErrorLengthForInterleavedBlock(i + 1);
                iArr3[i] = 0;
                if (i > 0) {
                    iArr3[i] = iArr3[i - 1] + iArr[i];
                }
            }
            for (int i2 = 0; i2 < interleavedBlockCount; i2++) {
                StringBuilder stringBuilder2 = new StringBuilder(iArr[i2]);
                for (i = i2; i < symbolInfo.getDataCapacity(); i += interleavedBlockCount) {
                    stringBuilder2.append(str.charAt(i));
                }
                String createECCBlock = createECCBlock(stringBuilder2.toString(), iArr2[i2]);
                i = i2;
                int i3 = 0;
                while (i < iArr2[i2] * interleavedBlockCount) {
                    int i4 = i3 + 1;
                    stringBuilder.setCharAt(symbolInfo.getDataCapacity() + i, createECCBlock.charAt(i3));
                    i += interleavedBlockCount;
                    i3 = i4;
                }
            }
        }
        return stringBuilder.toString();
    }

    private static String createECCBlock(CharSequence charSequence, int i) {
        return createECCBlock(charSequence, 0, charSequence.length(), i);
    }

    private static String createECCBlock(CharSequence charSequence, int i, int i2, int i3) {
        int i4 = 0;
        int i5 = 0;
        while (i5 < FACTOR_SETS.length) {
            if (FACTOR_SETS[i5] == i3) {
                break;
            }
            i5++;
        }
        i5 = -1;
        if (i5 < 0) {
            throw new IllegalArgumentException("Illegal number of error correction codewords specified: " + i3);
        }
        int[] iArr = FACTORS[i5];
        char[] cArr = new char[i3];
        for (i5 = 0; i5 < i3; i5++) {
            cArr[i5] = '\u0000';
        }
        for (int i6 = i; i6 < i + i2; i6++) {
            int charAt = charSequence.charAt(i6) ^ cArr[i3 - 1];
            i5 = i3 - 1;
            while (i5 > 0) {
                if (charAt == 0 || iArr[i5] == 0) {
                    cArr[i5] = cArr[i5 - 1];
                } else {
                    cArr[i5] = (char) (cArr[i5 - 1] ^ ALOG[(LOG[charAt] + LOG[iArr[i5]]) % 255]);
                }
                i5--;
            }
            if (charAt == 0 || iArr[0] == 0) {
                cArr[0] = '\u0000';
            } else {
                cArr[0] = (char) ALOG[(LOG[charAt] + LOG[iArr[0]]) % 255];
            }
        }
        char[] cArr2 = new char[i3];
        while (i4 < i3) {
            cArr2[i4] = cArr[(i3 - i4) - 1];
            i4++;
        }
        return String.valueOf(cArr2);
    }
}
