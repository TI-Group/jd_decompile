package com.google.zxing.client.result;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.Result;
import com.tencent.connect.common.Constants;
import java.util.HashMap;
import java.util.Map;

/* compiled from: TbsSdkJava */
public final class ExpandedProductResultParser extends ResultParser {
    public ExpandedProductParsedResult parse(Result result) {
        if (result.getBarcodeFormat() != BarcodeFormat.RSS_EXPANDED) {
            return null;
        }
        String massagedText = ResultParser.getMassagedText(result);
        String str = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        String str6 = null;
        String str7 = null;
        String str8 = null;
        String str9 = null;
        String str10 = null;
        String str11 = null;
        String str12 = null;
        String str13 = null;
        Map hashMap = new HashMap();
        int i = 0;
        while (i < massagedText.length()) {
            String findAIvalue = findAIvalue(i, massagedText);
            if (findAIvalue == null) {
                return null;
            }
            int length = (findAIvalue.length() + 2) + i;
            String findValue = findValue(length, massagedText);
            length += findValue.length();
            Object obj = -1;
            switch (findAIvalue.hashCode()) {
                case 1536:
                    if (findAIvalue.equals("00")) {
                        obj = null;
                        break;
                    }
                    break;
                case 1537:
                    if (findAIvalue.equals("01")) {
                        obj = 1;
                        break;
                    }
                    break;
                case 1567:
                    if (findAIvalue.equals(Constants.VIA_REPORT_TYPE_SHARE_TO_QQ)) {
                        obj = 2;
                        break;
                    }
                    break;
                case 1568:
                    if (findAIvalue.equals(Constants.VIA_REPORT_TYPE_SHARE_TO_QZONE)) {
                        obj = 3;
                        break;
                    }
                    break;
                case 1570:
                    if (findAIvalue.equals(Constants.VIA_REPORT_TYPE_JOININ_GROUP)) {
                        obj = 4;
                        break;
                    }
                    break;
                case 1572:
                    if (findAIvalue.equals(Constants.VIA_REPORT_TYPE_WPA_STATE)) {
                        obj = 5;
                        break;
                    }
                    break;
                case 1574:
                    if (findAIvalue.equals(Constants.VIA_REPORT_TYPE_START_GROUP)) {
                        obj = 6;
                        break;
                    }
                    break;
                case 1567966:
                    if (findAIvalue.equals("3100")) {
                        obj = 7;
                        break;
                    }
                    break;
                case 1567967:
                    if (findAIvalue.equals("3101")) {
                        obj = 8;
                        break;
                    }
                    break;
                case 1567968:
                    if (findAIvalue.equals("3102")) {
                        obj = 9;
                        break;
                    }
                    break;
                case 1567969:
                    if (findAIvalue.equals("3103")) {
                        obj = 10;
                        break;
                    }
                    break;
                case 1567970:
                    if (findAIvalue.equals("3104")) {
                        obj = 11;
                        break;
                    }
                    break;
                case 1567971:
                    if (findAIvalue.equals("3105")) {
                        obj = 12;
                        break;
                    }
                    break;
                case 1567972:
                    if (findAIvalue.equals("3106")) {
                        obj = 13;
                        break;
                    }
                    break;
                case 1567973:
                    if (findAIvalue.equals("3107")) {
                        obj = 14;
                        break;
                    }
                    break;
                case 1567974:
                    if (findAIvalue.equals("3108")) {
                        obj = 15;
                        break;
                    }
                    break;
                case 1567975:
                    if (findAIvalue.equals("3109")) {
                        obj = 16;
                        break;
                    }
                    break;
                case 1568927:
                    if (findAIvalue.equals("3200")) {
                        obj = 17;
                        break;
                    }
                    break;
                case 1568928:
                    if (findAIvalue.equals("3201")) {
                        obj = 18;
                        break;
                    }
                    break;
                case 1568929:
                    if (findAIvalue.equals("3202")) {
                        obj = 19;
                        break;
                    }
                    break;
                case 1568930:
                    if (findAIvalue.equals("3203")) {
                        obj = 20;
                        break;
                    }
                    break;
                case 1568931:
                    if (findAIvalue.equals("3204")) {
                        obj = 21;
                        break;
                    }
                    break;
                case 1568932:
                    if (findAIvalue.equals("3205")) {
                        obj = 22;
                        break;
                    }
                    break;
                case 1568933:
                    if (findAIvalue.equals("3206")) {
                        obj = 23;
                        break;
                    }
                    break;
                case 1568934:
                    if (findAIvalue.equals("3207")) {
                        obj = 24;
                        break;
                    }
                    break;
                case 1568935:
                    if (findAIvalue.equals("3208")) {
                        obj = 25;
                        break;
                    }
                    break;
                case 1568936:
                    if (findAIvalue.equals("3209")) {
                        obj = 26;
                        break;
                    }
                    break;
                case 1575716:
                    if (findAIvalue.equals("3920")) {
                        obj = 27;
                        break;
                    }
                    break;
                case 1575717:
                    if (findAIvalue.equals("3921")) {
                        obj = 28;
                        break;
                    }
                    break;
                case 1575718:
                    if (findAIvalue.equals("3922")) {
                        obj = 29;
                        break;
                    }
                    break;
                case 1575719:
                    if (findAIvalue.equals("3923")) {
                        obj = 30;
                        break;
                    }
                    break;
                case 1575747:
                    if (findAIvalue.equals("3930")) {
                        obj = 31;
                        break;
                    }
                    break;
                case 1575748:
                    if (findAIvalue.equals("3931")) {
                        obj = 32;
                        break;
                    }
                    break;
                case 1575749:
                    if (findAIvalue.equals("3932")) {
                        obj = 33;
                        break;
                    }
                    break;
                case 1575750:
                    if (findAIvalue.equals("3933")) {
                        obj = 34;
                        break;
                    }
                    break;
            }
            switch (obj) {
                case null:
                    str2 = findValue;
                    break;
                case 1:
                    str = findValue;
                    break;
                case 2:
                    str3 = findValue;
                    break;
                case 3:
                    str4 = findValue;
                    break;
                case 4:
                    str5 = findValue;
                    break;
                case 5:
                    str6 = findValue;
                    break;
                case 6:
                    str7 = findValue;
                    break;
                case 7:
                case 8:
                case 9:
                case 10:
                case 11:
                case 12:
                case 13:
                case 14:
                case 15:
                case 16:
                    str9 = ExpandedProductParsedResult.KILOGRAM;
                    str10 = findAIvalue.substring(3);
                    str8 = findValue;
                    break;
                case 17:
                case 18:
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                case 24:
                case 25:
                case 26:
                    str9 = ExpandedProductParsedResult.POUND;
                    str10 = findAIvalue.substring(3);
                    str8 = findValue;
                    break;
                case 27:
                case 28:
                case 29:
                case 30:
                    str12 = findAIvalue.substring(3);
                    str11 = findValue;
                    break;
                case 31:
                case 32:
                case 33:
                case 34:
                    if (findValue.length() >= 4) {
                        str11 = findValue.substring(3);
                        str13 = findValue.substring(0, 3);
                        str12 = findAIvalue.substring(3);
                        break;
                    }
                    return null;
                default:
                    hashMap.put(findAIvalue, findValue);
                    break;
            }
            i = length;
        }
        return new ExpandedProductParsedResult(massagedText, str, str2, str3, str4, str5, str6, str7, str8, str9, str10, str11, str12, str13, hashMap);
    }

    private static String findAIvalue(int i, String str) {
        if (str.charAt(i) != '(') {
            return null;
        }
        CharSequence substring = str.substring(i + 1);
        StringBuilder stringBuilder = new StringBuilder();
        for (int i2 = 0; i2 < substring.length(); i2++) {
            char charAt = substring.charAt(i2);
            if (charAt == ')') {
                return stringBuilder.toString();
            }
            if (charAt < '0' || charAt > '9') {
                return null;
            }
            stringBuilder.append(charAt);
        }
        return stringBuilder.toString();
    }

    private static String findValue(int i, String str) {
        StringBuilder stringBuilder = new StringBuilder();
        String substring = str.substring(i);
        for (int i2 = 0; i2 < substring.length(); i2++) {
            char charAt = substring.charAt(i2);
            if (charAt == '(') {
                if (findAIvalue(i2, substring) != null) {
                    break;
                }
                stringBuilder.append('(');
            } else {
                stringBuilder.append(charAt);
            }
        }
        return stringBuilder.toString();
    }
}
