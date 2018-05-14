package org.apache.http.client.utils;

import android.support.v4.media.TransportMediator;
import com.tencent.smtt.sdk.TbsListener.ErrorCode;
import java.io.IOException;
import java.net.URI;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import jd.wjlogin_sdk.util.ReplyCode;
import org.apache.http.Consts;
import org.apache.http.Header;
import org.apache.http.HeaderElement;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.annotation.Immutable;
import org.apache.http.entity.ContentType;
import org.apache.http.message.BasicHeaderValueParser;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.message.ParserCursor;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.CharArrayBuffer;
import org.apache.http.util.EntityUtils;

@Immutable
/* compiled from: TbsSdkJava */
public class URLEncodedUtils {
    public static final String CONTENT_TYPE = "application/x-www-form-urlencoded";
    private static final String NAME_VALUE_SEPARATOR = "=";
    private static final BitSet PATHSAFE = new BitSet(256);
    private static final BitSet PUNCT = new BitSet(256);
    private static final char[] QP_SEPS = new char[]{QP_SEP_A, QP_SEP_S};
    private static final char QP_SEP_A = '&';
    private static final String QP_SEP_PATTERN = ("[" + new String(QP_SEPS) + "]");
    private static final char QP_SEP_S = ';';
    private static final int RADIX = 16;
    private static final BitSet RESERVED = new BitSet(256);
    private static final BitSet UNRESERVED = new BitSet(256);
    private static final BitSet URIC = new BitSet(256);
    private static final BitSet URLENCODER = new BitSet(256);
    private static final BitSet USERINFO = new BitSet(256);

    public static List<NameValuePair> parse(URI uri, String str) {
        String rawQuery = uri.getRawQuery();
        if (rawQuery == null || rawQuery.length() <= 0) {
            return Collections.emptyList();
        }
        List<NameValuePair> arrayList = new ArrayList();
        parse(arrayList, new Scanner(rawQuery), QP_SEP_PATTERN, str);
        return arrayList;
    }

    public static List<NameValuePair> parse(HttpEntity httpEntity) throws IOException {
        ContentType contentType = ContentType.get(httpEntity);
        if (contentType != null && contentType.getMimeType().equalsIgnoreCase(CONTENT_TYPE)) {
            String entityUtils = EntityUtils.toString(httpEntity, Consts.ASCII);
            if (entityUtils != null && entityUtils.length() > 0) {
                Charset charset = contentType.getCharset();
                if (charset == null) {
                    charset = HTTP.DEF_CONTENT_CHARSET;
                }
                return parse(entityUtils, charset, QP_SEPS);
            }
        }
        return Collections.emptyList();
    }

    public static boolean isEncoded(HttpEntity httpEntity) {
        Header contentType = httpEntity.getContentType();
        if (contentType == null) {
            return false;
        }
        HeaderElement[] elements = contentType.getElements();
        if (elements.length > 0) {
            return elements[0].getName().equalsIgnoreCase(CONTENT_TYPE);
        }
        return false;
    }

    public static void parse(List<NameValuePair> list, Scanner scanner, String str) {
        parse(list, scanner, QP_SEP_PATTERN, str);
    }

    public static void parse(List<NameValuePair> list, Scanner scanner, String str, String str2) {
        scanner.useDelimiter(str);
        while (scanner.hasNext()) {
            String decodeFormFields;
            String str3 = null;
            String next = scanner.next();
            int indexOf = next.indexOf("=");
            if (indexOf != -1) {
                decodeFormFields = decodeFormFields(next.substring(0, indexOf).trim(), str2);
                str3 = decodeFormFields(next.substring(indexOf + 1).trim(), str2);
            } else {
                decodeFormFields = decodeFormFields(next.trim(), str2);
            }
            list.add(new BasicNameValuePair(decodeFormFields, str3));
        }
    }

    static {
        int i;
        for (i = 97; i <= ErrorCode.DOWNLOAD_HAS_COPY_TBS_ERROR; i++) {
            UNRESERVED.set(i);
        }
        for (i = 65; i <= 90; i++) {
            UNRESERVED.set(i);
        }
        for (i = 48; i <= 57; i++) {
            UNRESERVED.set(i);
        }
        UNRESERVED.set(95);
        UNRESERVED.set(45);
        UNRESERVED.set(46);
        UNRESERVED.set(42);
        URLENCODER.or(UNRESERVED);
        UNRESERVED.set(33);
        UNRESERVED.set(TransportMediator.KEYCODE_MEDIA_PLAY);
        UNRESERVED.set(39);
        UNRESERVED.set(40);
        UNRESERVED.set(41);
        PUNCT.set(44);
        PUNCT.set(59);
        PUNCT.set(58);
        PUNCT.set(36);
        PUNCT.set(38);
        PUNCT.set(43);
        PUNCT.set(61);
        USERINFO.or(UNRESERVED);
        USERINFO.or(PUNCT);
        PATHSAFE.or(UNRESERVED);
        PATHSAFE.set(47);
        PATHSAFE.set(59);
        PATHSAFE.set(58);
        PATHSAFE.set(64);
        PATHSAFE.set(38);
        PATHSAFE.set(61);
        PATHSAFE.set(43);
        PATHSAFE.set(36);
        PATHSAFE.set(44);
        RESERVED.set(59);
        RESERVED.set(47);
        RESERVED.set(63);
        RESERVED.set(58);
        RESERVED.set(64);
        RESERVED.set(38);
        RESERVED.set(61);
        RESERVED.set(43);
        RESERVED.set(36);
        RESERVED.set(44);
        RESERVED.set(91);
        RESERVED.set(93);
        URIC.or(RESERVED);
        URIC.or(UNRESERVED);
    }

    public static List<NameValuePair> parse(String str, Charset charset) {
        return parse(str, charset, QP_SEPS);
    }

    public static List<NameValuePair> parse(String str, Charset charset, char... cArr) {
        if (str == null) {
            return Collections.emptyList();
        }
        BasicHeaderValueParser basicHeaderValueParser = BasicHeaderValueParser.INSTANCE;
        CharArrayBuffer charArrayBuffer = new CharArrayBuffer(str.length());
        charArrayBuffer.append(str);
        ParserCursor parserCursor = new ParserCursor(0, charArrayBuffer.length());
        List<NameValuePair> arrayList = new ArrayList();
        while (!parserCursor.atEnd()) {
            NameValuePair parseNameValuePair = basicHeaderValueParser.parseNameValuePair(charArrayBuffer, parserCursor, cArr);
            if (parseNameValuePair.getName().length() > 0) {
                arrayList.add(new BasicNameValuePair(decodeFormFields(parseNameValuePair.getName(), charset), decodeFormFields(parseNameValuePair.getValue(), charset)));
            }
        }
        return arrayList;
    }

    public static String format(List<? extends NameValuePair> list, String str) {
        return format((List) list, (char) QP_SEP_A, str);
    }

    public static String format(List<? extends NameValuePair> list, char c, String str) {
        StringBuilder stringBuilder = new StringBuilder();
        for (NameValuePair nameValuePair : list) {
            String encodeFormFields = encodeFormFields(nameValuePair.getName(), str);
            String encodeFormFields2 = encodeFormFields(nameValuePair.getValue(), str);
            if (stringBuilder.length() > 0) {
                stringBuilder.append(c);
            }
            stringBuilder.append(encodeFormFields);
            if (encodeFormFields2 != null) {
                stringBuilder.append("=");
                stringBuilder.append(encodeFormFields2);
            }
        }
        return stringBuilder.toString();
    }

    public static String format(Iterable<? extends NameValuePair> iterable, Charset charset) {
        return format((Iterable) iterable, (char) QP_SEP_A, charset);
    }

    public static String format(Iterable<? extends NameValuePair> iterable, char c, Charset charset) {
        StringBuilder stringBuilder = new StringBuilder();
        for (NameValuePair nameValuePair : iterable) {
            String encodeFormFields = encodeFormFields(nameValuePair.getName(), charset);
            String encodeFormFields2 = encodeFormFields(nameValuePair.getValue(), charset);
            if (stringBuilder.length() > 0) {
                stringBuilder.append(c);
            }
            stringBuilder.append(encodeFormFields);
            if (encodeFormFields2 != null) {
                stringBuilder.append("=");
                stringBuilder.append(encodeFormFields2);
            }
        }
        return stringBuilder.toString();
    }

    private static String urlEncode(String str, Charset charset, BitSet bitSet, boolean z) {
        if (str == null) {
            return null;
        }
        StringBuilder stringBuilder = new StringBuilder();
        ByteBuffer encode = charset.encode(str);
        while (encode.hasRemaining()) {
            int i = encode.get() & 255;
            if (bitSet.get(i)) {
                stringBuilder.append((char) i);
            } else if (z && i == 32) {
                stringBuilder.append('+');
            } else {
                stringBuilder.append("%");
                char toUpperCase = Character.toUpperCase(Character.forDigit((i >> 4) & 15, 16));
                char toUpperCase2 = Character.toUpperCase(Character.forDigit(i & 15, 16));
                stringBuilder.append(toUpperCase);
                stringBuilder.append(toUpperCase2);
            }
        }
        return stringBuilder.toString();
    }

    private static String urlDecode(String str, Charset charset, boolean z) {
        if (str == null) {
            return null;
        }
        ByteBuffer allocate = ByteBuffer.allocate(str.length());
        CharBuffer wrap = CharBuffer.wrap(str);
        while (wrap.hasRemaining()) {
            char c = wrap.get();
            if (c == '%' && wrap.remaining() >= 2) {
                c = wrap.get();
                char c2 = wrap.get();
                int digit = Character.digit(c, 16);
                int digit2 = Character.digit(c2, 16);
                if (digit == -1 || digit2 == -1) {
                    allocate.put(ReplyCode.reply0x25);
                    allocate.put((byte) c);
                    allocate.put((byte) c2);
                } else {
                    allocate.put((byte) ((digit << 4) + digit2));
                }
            } else if (z && c == '+') {
                allocate.put(ReplyCode.reply0x20);
            } else {
                allocate.put((byte) c);
            }
        }
        allocate.flip();
        return charset.decode(allocate).toString();
    }

    private static String decodeFormFields(String str, String str2) {
        if (str == null) {
            return null;
        }
        return urlDecode(str, str2 != null ? Charset.forName(str2) : Consts.UTF_8, true);
    }

    private static String decodeFormFields(String str, Charset charset) {
        if (str == null) {
            return null;
        }
        if (charset == null) {
            charset = Consts.UTF_8;
        }
        return urlDecode(str, charset, true);
    }

    private static String encodeFormFields(String str, String str2) {
        if (str == null) {
            return null;
        }
        return urlEncode(str, str2 != null ? Charset.forName(str2) : Consts.UTF_8, URLENCODER, true);
    }

    private static String encodeFormFields(String str, Charset charset) {
        if (str == null) {
            return null;
        }
        if (charset == null) {
            charset = Consts.UTF_8;
        }
        return urlEncode(str, charset, URLENCODER, true);
    }

    static String encUserInfo(String str, Charset charset) {
        return urlEncode(str, charset, USERINFO, false);
    }

    static String encUric(String str, Charset charset) {
        return urlEncode(str, charset, URIC, false);
    }

    static String encPath(String str, Charset charset) {
        return urlEncode(str, charset, PATHSAFE, false);
    }
}
