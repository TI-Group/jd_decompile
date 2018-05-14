package org.apache.http.message;

import java.util.ArrayList;
import java.util.List;
import org.apache.http.HeaderElement;
import org.apache.http.NameValuePair;
import org.apache.http.ParseException;
import org.apache.http.annotation.Immutable;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.Args;
import org.apache.http.util.CharArrayBuffer;

@Immutable
/* compiled from: TbsSdkJava */
public class BasicHeaderValueParser implements HeaderValueParser {
    private static final char[] ALL_DELIMITERS = new char[]{PARAM_DELIMITER, ELEM_DELIMITER};
    @Deprecated
    public static final BasicHeaderValueParser DEFAULT = new BasicHeaderValueParser();
    private static final char ELEM_DELIMITER = ',';
    public static final BasicHeaderValueParser INSTANCE = new BasicHeaderValueParser();
    private static final char PARAM_DELIMITER = ';';

    public static HeaderElement[] parseElements(String str, HeaderValueParser headerValueParser) throws ParseException {
        Args.notNull(str, "Value");
        CharArrayBuffer charArrayBuffer = new CharArrayBuffer(str.length());
        charArrayBuffer.append(str);
        ParserCursor parserCursor = new ParserCursor(0, str.length());
        if (headerValueParser == null) {
            headerValueParser = INSTANCE;
        }
        return headerValueParser.parseElements(charArrayBuffer, parserCursor);
    }

    public HeaderElement[] parseElements(CharArrayBuffer charArrayBuffer, ParserCursor parserCursor) {
        Args.notNull(charArrayBuffer, "Char array buffer");
        Args.notNull(parserCursor, "Parser cursor");
        List arrayList = new ArrayList();
        while (!parserCursor.atEnd()) {
            HeaderElement parseHeaderElement = parseHeaderElement(charArrayBuffer, parserCursor);
            if (parseHeaderElement.getName().length() != 0 || parseHeaderElement.getValue() != null) {
                arrayList.add(parseHeaderElement);
            }
        }
        return (HeaderElement[]) arrayList.toArray(new HeaderElement[arrayList.size()]);
    }

    public static HeaderElement parseHeaderElement(String str, HeaderValueParser headerValueParser) throws ParseException {
        Args.notNull(str, "Value");
        CharArrayBuffer charArrayBuffer = new CharArrayBuffer(str.length());
        charArrayBuffer.append(str);
        ParserCursor parserCursor = new ParserCursor(0, str.length());
        if (headerValueParser == null) {
            headerValueParser = INSTANCE;
        }
        return headerValueParser.parseHeaderElement(charArrayBuffer, parserCursor);
    }

    public HeaderElement parseHeaderElement(CharArrayBuffer charArrayBuffer, ParserCursor parserCursor) {
        Args.notNull(charArrayBuffer, "Char array buffer");
        Args.notNull(parserCursor, "Parser cursor");
        NameValuePair parseNameValuePair = parseNameValuePair(charArrayBuffer, parserCursor);
        NameValuePair[] nameValuePairArr = null;
        if (!(parserCursor.atEnd() || charArrayBuffer.charAt(parserCursor.getPos() - 1) == ELEM_DELIMITER)) {
            nameValuePairArr = parseParameters(charArrayBuffer, parserCursor);
        }
        return createHeaderElement(parseNameValuePair.getName(), parseNameValuePair.getValue(), nameValuePairArr);
    }

    protected HeaderElement createHeaderElement(String str, String str2, NameValuePair[] nameValuePairArr) {
        return new BasicHeaderElement(str, str2, nameValuePairArr);
    }

    public static NameValuePair[] parseParameters(String str, HeaderValueParser headerValueParser) throws ParseException {
        Args.notNull(str, "Value");
        CharArrayBuffer charArrayBuffer = new CharArrayBuffer(str.length());
        charArrayBuffer.append(str);
        ParserCursor parserCursor = new ParserCursor(0, str.length());
        if (headerValueParser == null) {
            headerValueParser = INSTANCE;
        }
        return headerValueParser.parseParameters(charArrayBuffer, parserCursor);
    }

    public NameValuePair[] parseParameters(CharArrayBuffer charArrayBuffer, ParserCursor parserCursor) {
        Args.notNull(charArrayBuffer, "Char array buffer");
        Args.notNull(parserCursor, "Parser cursor");
        int pos = parserCursor.getPos();
        int upperBound = parserCursor.getUpperBound();
        while (pos < upperBound && HTTP.isWhitespace(charArrayBuffer.charAt(pos))) {
            pos++;
        }
        parserCursor.updatePos(pos);
        if (parserCursor.atEnd()) {
            return new NameValuePair[0];
        }
        List arrayList = new ArrayList();
        while (!parserCursor.atEnd()) {
            arrayList.add(parseNameValuePair(charArrayBuffer, parserCursor));
            if (charArrayBuffer.charAt(parserCursor.getPos() - 1) == ELEM_DELIMITER) {
                break;
            }
        }
        return (NameValuePair[]) arrayList.toArray(new NameValuePair[arrayList.size()]);
    }

    public static NameValuePair parseNameValuePair(String str, HeaderValueParser headerValueParser) throws ParseException {
        Args.notNull(str, "Value");
        CharArrayBuffer charArrayBuffer = new CharArrayBuffer(str.length());
        charArrayBuffer.append(str);
        ParserCursor parserCursor = new ParserCursor(0, str.length());
        if (headerValueParser == null) {
            headerValueParser = INSTANCE;
        }
        return headerValueParser.parseNameValuePair(charArrayBuffer, parserCursor);
    }

    public NameValuePair parseNameValuePair(CharArrayBuffer charArrayBuffer, ParserCursor parserCursor) {
        return parseNameValuePair(charArrayBuffer, parserCursor, ALL_DELIMITERS);
    }

    private static boolean isOneOf(char c, char[] cArr) {
        if (cArr == null) {
            return false;
        }
        for (char c2 : cArr) {
            if (c == c2) {
                return true;
            }
        }
        return false;
    }

    public NameValuePair parseNameValuePair(CharArrayBuffer charArrayBuffer, ParserCursor parserCursor, char[] cArr) {
        Object obj;
        String substringTrimmed;
        Object obj2 = 1;
        Args.notNull(charArrayBuffer, "Char array buffer");
        Args.notNull(parserCursor, "Parser cursor");
        int pos = parserCursor.getPos();
        int pos2 = parserCursor.getPos();
        int upperBound = parserCursor.getUpperBound();
        while (pos < upperBound) {
            char charAt = charArrayBuffer.charAt(pos);
            if (charAt == '=') {
                obj = null;
                break;
            } else if (isOneOf(charAt, cArr)) {
                int i = 1;
                break;
            } else {
                pos++;
            }
        }
        obj = null;
        if (pos == upperBound) {
            substringTrimmed = charArrayBuffer.substringTrimmed(pos2, upperBound);
            obj = 1;
        } else {
            String substringTrimmed2 = charArrayBuffer.substringTrimmed(pos2, pos);
            pos++;
            substringTrimmed = substringTrimmed2;
        }
        if (obj != null) {
            parserCursor.updatePos(pos);
            return createNameValuePair(substringTrimmed, null);
        }
        Object obj3 = null;
        Object obj4 = null;
        int i2 = pos;
        while (i2 < upperBound) {
            Object obj5;
            char charAt2 = charArrayBuffer.charAt(i2);
            if (charAt2 == '\"' && obj3 == null) {
                obj5 = obj4 == null ? 1 : null;
            } else {
                obj5 = obj4;
            }
            if (obj5 == null && obj3 == null && isOneOf(charAt2, cArr)) {
                break;
            }
            if (obj3 != null) {
                obj4 = null;
            } else if (obj5 == null || charAt2 != '\\') {
                obj4 = null;
            } else {
                pos2 = 1;
            }
            i2++;
            obj3 = obj4;
            obj4 = obj5;
        }
        obj2 = obj;
        int i3 = pos;
        while (i3 < i2 && HTTP.isWhitespace(charArrayBuffer.charAt(i3))) {
            i3++;
        }
        pos2 = i2;
        while (pos2 > i3 && HTTP.isWhitespace(charArrayBuffer.charAt(pos2 - 1))) {
            pos2--;
        }
        if (pos2 - i3 >= 2 && charArrayBuffer.charAt(i3) == '\"' && charArrayBuffer.charAt(pos2 - 1) == '\"') {
            i3++;
            pos2--;
        }
        String substring = charArrayBuffer.substring(i3, pos2);
        if (obj2 != null) {
            pos2 = i2 + 1;
        } else {
            pos2 = i2;
        }
        parserCursor.updatePos(pos2);
        return createNameValuePair(substringTrimmed, substring);
    }

    protected NameValuePair createNameValuePair(String str, String str2) {
        return new BasicNameValuePair(str, str2);
    }
}
