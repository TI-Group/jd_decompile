package org.apache.commons.lang;

import java.io.IOException;
import java.io.Writer;
import org.apache.commons.lang.exception.NestableRuntimeException;

/* compiled from: TbsSdkJava */
public class StringEscapeUtils {
    public static String escapeJava(String str) {
        return escapeJavaStyleString(str, false);
    }

    public static void escapeJava(Writer writer, String str) throws IOException {
        escapeJavaStyleString(writer, str, false);
    }

    public static String escapeJavaScript(String str) {
        return escapeJavaStyleString(str, true);
    }

    public static void escapeJavaScript(Writer writer, String str) throws IOException {
        escapeJavaStyleString(writer, str, true);
    }

    private static String escapeJavaStyleString(String str, boolean z) {
        String str2 = null;
        if (str != null) {
            try {
                Writer stringPrintWriter = new StringPrintWriter(str.length() * 2);
                escapeJavaStyleString(stringPrintWriter, str, z);
                str2 = stringPrintWriter.getString();
            } catch (Throwable e) {
                e.printStackTrace();
            }
        }
        return str2;
    }

    private static void escapeJavaStyleString(Writer writer, String str, boolean z) throws IOException {
        if (writer == null) {
            throw new IllegalArgumentException("The Writer must not be null");
        } else if (str != null) {
            int length = str.length();
            for (int i = 0; i < length; i++) {
                char charAt = str.charAt(i);
                if (charAt <= '࿿') {
                    if (charAt <= 'ÿ') {
                        if (charAt <= '') {
                            if (charAt >= ' ') {
                                switch (charAt) {
                                    case '\"':
                                        writer.write(92);
                                        writer.write(34);
                                        break;
                                    case '\'':
                                        if (z) {
                                            writer.write(92);
                                        }
                                        writer.write(39);
                                        break;
                                    case '\\':
                                        writer.write(92);
                                        writer.write(92);
                                        break;
                                    default:
                                        writer.write(charAt);
                                        break;
                                }
                            }
                            switch (charAt) {
                                case '\b':
                                    writer.write(92);
                                    writer.write(98);
                                    break;
                                case '\t':
                                    writer.write(92);
                                    writer.write(116);
                                    break;
                                case '\n':
                                    writer.write(92);
                                    writer.write(110);
                                    break;
                                case '\f':
                                    writer.write(92);
                                    writer.write(102);
                                    break;
                                case '\r':
                                    writer.write(92);
                                    writer.write(114);
                                    break;
                                default:
                                    if (charAt <= '\u000f') {
                                        writer.write(new StringBuffer().append("\\u000").append(hex(charAt)).toString());
                                        break;
                                    } else {
                                        writer.write(new StringBuffer().append("\\u00").append(hex(charAt)).toString());
                                        break;
                                    }
                            }
                        }
                        writer.write(new StringBuffer().append("\\u00").append(hex(charAt)).toString());
                    } else {
                        writer.write(new StringBuffer().append("\\u0").append(hex(charAt)).toString());
                    }
                } else {
                    writer.write(new StringBuffer().append("\\u").append(hex(charAt)).toString());
                }
            }
        }
    }

    private static String hex(char c) {
        return Integer.toHexString(c).toUpperCase();
    }

    public static String unescapeJava(String str) {
        String str2 = null;
        if (str != null) {
            try {
                Writer stringPrintWriter = new StringPrintWriter(str.length());
                unescapeJava(stringPrintWriter, str);
                str2 = stringPrintWriter.getString();
            } catch (Throwable e) {
                e.printStackTrace();
            }
        }
        return str2;
    }

    public static void unescapeJava(Writer writer, String str) throws IOException {
        if (writer == null) {
            throw new IllegalArgumentException("The Writer must not be null");
        } else if (str != null) {
            int length = str.length();
            StringBuffer stringBuffer = new StringBuffer(4);
            Object obj = null;
            Object obj2 = null;
            for (int i = 0; i < length; i++) {
                char charAt = str.charAt(i);
                if (obj != null) {
                    stringBuffer.append(charAt);
                    if (stringBuffer.length() == 4) {
                        try {
                            writer.write((char) Integer.parseInt(stringBuffer.toString(), 16));
                            stringBuffer.setLength(0);
                            obj = null;
                            obj2 = null;
                        } catch (Throwable e) {
                            throw new NestableRuntimeException(new StringBuffer().append("Unable to parse unicode value: ").append(stringBuffer).toString(), e);
                        }
                    }
                    continue;
                } else if (obj2 != null) {
                    switch (charAt) {
                        case '\"':
                            writer.write(34);
                            obj2 = null;
                            break;
                        case '\'':
                            writer.write(39);
                            obj2 = null;
                            break;
                        case '\\':
                            writer.write(92);
                            obj2 = null;
                            break;
                        case 'b':
                            writer.write(8);
                            obj2 = null;
                            break;
                        case 'f':
                            writer.write(12);
                            obj2 = null;
                            break;
                        case 'n':
                            writer.write(10);
                            obj2 = null;
                            break;
                        case 'r':
                            writer.write(13);
                            obj2 = null;
                            break;
                        case 't':
                            writer.write(9);
                            obj2 = null;
                            break;
                        case 'u':
                            int i2 = 1;
                            obj2 = null;
                            break;
                        default:
                            writer.write(charAt);
                            obj2 = null;
                            break;
                    }
                } else if (charAt == '\\') {
                    int i3 = 1;
                } else {
                    writer.write(charAt);
                }
            }
            if (obj2 != null) {
                writer.write(92);
            }
        }
    }

    public static String unescapeJavaScript(String str) {
        return unescapeJava(str);
    }

    public static void unescapeJavaScript(Writer writer, String str) throws IOException {
        unescapeJava(writer, str);
    }

    public static String escapeHtml(String str) {
        if (str == null) {
            return null;
        }
        return Entities.HTML40.escape(str);
    }

    public static String unescapeHtml(String str) {
        if (str == null) {
            return null;
        }
        return Entities.HTML40.unescape(str);
    }

    public static String escapeXml(String str) {
        if (str == null) {
            return null;
        }
        return Entities.XML.escape(str);
    }

    public static String unescapeXml(String str) {
        if (str == null) {
            return null;
        }
        return Entities.XML.unescape(str);
    }

    public static String escapeSql(String str) {
        if (str == null) {
            return null;
        }
        return StringUtils.replace(str, "'", "''");
    }
}
