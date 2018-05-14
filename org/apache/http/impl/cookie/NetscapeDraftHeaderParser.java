package org.apache.http.impl.cookie;

import java.util.ArrayList;
import java.util.List;
import org.apache.http.HeaderElement;
import org.apache.http.NameValuePair;
import org.apache.http.ParseException;
import org.apache.http.annotation.Immutable;
import org.apache.http.message.BasicHeaderElement;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.message.ParserCursor;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.Args;
import org.apache.http.util.CharArrayBuffer;

@Immutable
/* compiled from: TbsSdkJava */
public class NetscapeDraftHeaderParser {
    public static final NetscapeDraftHeaderParser DEFAULT = new NetscapeDraftHeaderParser();

    public HeaderElement parseHeader(CharArrayBuffer charArrayBuffer, ParserCursor parserCursor) throws ParseException {
        Args.notNull(charArrayBuffer, "Char array buffer");
        Args.notNull(parserCursor, "Parser cursor");
        NameValuePair parseNameValuePair = parseNameValuePair(charArrayBuffer, parserCursor);
        List arrayList = new ArrayList();
        while (!parserCursor.atEnd()) {
            arrayList.add(parseNameValuePair(charArrayBuffer, parserCursor));
        }
        return new BasicHeaderElement(parseNameValuePair.getName(), parseNameValuePair.getValue(), (NameValuePair[]) arrayList.toArray(new NameValuePair[arrayList.size()]));
    }

    private NameValuePair parseNameValuePair(CharArrayBuffer charArrayBuffer, ParserCursor parserCursor) {
        String substringTrimmed;
        Object obj;
        Object obj2 = 1;
        Object obj3 = null;
        int pos = parserCursor.getPos();
        int pos2 = parserCursor.getPos();
        int upperBound = parserCursor.getUpperBound();
        while (pos < upperBound) {
            char charAt = charArrayBuffer.charAt(pos);
            if (charAt == '=') {
                break;
            } else if (charAt == ';') {
                int i = 1;
                break;
            } else {
                pos++;
            }
        }
        if (pos == upperBound) {
            substringTrimmed = charArrayBuffer.substringTrimmed(pos2, upperBound);
            obj = 1;
        } else {
            String substringTrimmed2 = charArrayBuffer.substringTrimmed(pos2, pos);
            pos++;
            substringTrimmed = substringTrimmed2;
            obj = obj3;
        }
        if (obj != null) {
            parserCursor.updatePos(pos);
            return new BasicNameValuePair(substringTrimmed, null);
        }
        int i2;
        i = pos;
        while (i < upperBound) {
            if (charArrayBuffer.charAt(i) == ';') {
                break;
            }
            i++;
        }
        obj2 = obj;
        while (pos < i && HTTP.isWhitespace(charArrayBuffer.charAt(pos))) {
            pos++;
        }
        pos2 = i;
        while (pos2 > pos && HTTP.isWhitespace(charArrayBuffer.charAt(pos2 - 1))) {
            pos2--;
        }
        substringTrimmed2 = charArrayBuffer.substring(pos, pos2);
        if (obj2 != null) {
            i2 = i + 1;
        } else {
            i2 = i;
        }
        parserCursor.updatePos(i2);
        return new BasicNameValuePair(substringTrimmed, substringTrimmed2);
    }
}
