package org.apache.http.message;

import org.apache.http.Header;
import org.apache.http.HttpVersion;
import org.apache.http.ParseException;
import org.apache.http.ProtocolVersion;
import org.apache.http.RequestLine;
import org.apache.http.StatusLine;
import org.apache.http.annotation.Immutable;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.Args;
import org.apache.http.util.CharArrayBuffer;

@Immutable
/* compiled from: TbsSdkJava */
public class BasicLineParser implements LineParser {
    @Deprecated
    public static final BasicLineParser DEFAULT = new BasicLineParser();
    public static final BasicLineParser INSTANCE = new BasicLineParser();
    protected final ProtocolVersion protocol;

    public BasicLineParser(ProtocolVersion protocolVersion) {
        if (protocolVersion == null) {
            protocolVersion = HttpVersion.HTTP_1_1;
        }
        this.protocol = protocolVersion;
    }

    public BasicLineParser() {
        this(null);
    }

    public static ProtocolVersion parseProtocolVersion(String str, LineParser lineParser) throws ParseException {
        Args.notNull(str, "Value");
        CharArrayBuffer charArrayBuffer = new CharArrayBuffer(str.length());
        charArrayBuffer.append(str);
        ParserCursor parserCursor = new ParserCursor(0, str.length());
        if (lineParser == null) {
            lineParser = INSTANCE;
        }
        return lineParser.parseProtocolVersion(charArrayBuffer, parserCursor);
    }

    public ProtocolVersion parseProtocolVersion(CharArrayBuffer charArrayBuffer, ParserCursor parserCursor) throws ParseException {
        Object obj = 1;
        Args.notNull(charArrayBuffer, "Char array buffer");
        Args.notNull(parserCursor, "Parser cursor");
        String protocol = this.protocol.getProtocol();
        int length = protocol.length();
        int pos = parserCursor.getPos();
        int upperBound = parserCursor.getUpperBound();
        skipWhitespace(charArrayBuffer, parserCursor);
        int pos2 = parserCursor.getPos();
        if ((pos2 + length) + 4 > upperBound) {
            throw new ParseException("Not a valid protocol version: " + charArrayBuffer.substring(pos, upperBound));
        }
        int i = 0;
        Object obj2 = 1;
        while (obj2 != null && i < length) {
            if (charArrayBuffer.charAt(pos2 + i) == protocol.charAt(i)) {
                obj2 = 1;
            } else {
                obj2 = null;
            }
            i++;
        }
        if (obj2 == null) {
            obj = obj2;
        } else if (charArrayBuffer.charAt(pos2 + length) != '/') {
            obj = null;
        }
        if (obj == null) {
            throw new ParseException("Not a valid protocol version: " + charArrayBuffer.substring(pos, upperBound));
        }
        int i2 = (length + 1) + pos2;
        int indexOf = charArrayBuffer.indexOf(46, i2, upperBound);
        if (indexOf == -1) {
            throw new ParseException("Invalid protocol version number: " + charArrayBuffer.substring(pos, upperBound));
        }
        try {
            int parseInt = Integer.parseInt(charArrayBuffer.substringTrimmed(i2, indexOf));
            indexOf++;
            i2 = charArrayBuffer.indexOf(32, indexOf, upperBound);
            if (i2 == -1) {
                i2 = upperBound;
            }
            try {
                indexOf = Integer.parseInt(charArrayBuffer.substringTrimmed(indexOf, i2));
                parserCursor.updatePos(i2);
                return createProtocolVersion(parseInt, indexOf);
            } catch (NumberFormatException e) {
                throw new ParseException("Invalid protocol minor version number: " + charArrayBuffer.substring(pos, upperBound));
            }
        } catch (NumberFormatException e2) {
            throw new ParseException("Invalid protocol major version number: " + charArrayBuffer.substring(pos, upperBound));
        }
    }

    protected ProtocolVersion createProtocolVersion(int i, int i2) {
        return this.protocol.forVersion(i, i2);
    }

    public boolean hasProtocolVersion(CharArrayBuffer charArrayBuffer, ParserCursor parserCursor) {
        boolean z = true;
        Args.notNull(charArrayBuffer, "Char array buffer");
        Args.notNull(parserCursor, "Parser cursor");
        int pos = parserCursor.getPos();
        String protocol = this.protocol.getProtocol();
        int length = protocol.length();
        if (charArrayBuffer.length() < length + 4) {
            return false;
        }
        if (pos < 0) {
            pos = (charArrayBuffer.length() - 4) - length;
        } else if (pos == 0) {
            while (pos < charArrayBuffer.length() && HTTP.isWhitespace(charArrayBuffer.charAt(pos))) {
                pos++;
            }
        }
        if ((pos + length) + 4 > charArrayBuffer.length()) {
            return false;
        }
        int i = 0;
        boolean z2 = true;
        while (z2 && i < length) {
            z2 = charArrayBuffer.charAt(pos + i) == protocol.charAt(i);
            i++;
        }
        if (!z2) {
            z = z2;
        } else if (charArrayBuffer.charAt(pos + length) != '/') {
            z = false;
        }
        return z;
    }

    public static RequestLine parseRequestLine(String str, LineParser lineParser) throws ParseException {
        Args.notNull(str, "Value");
        CharArrayBuffer charArrayBuffer = new CharArrayBuffer(str.length());
        charArrayBuffer.append(str);
        ParserCursor parserCursor = new ParserCursor(0, str.length());
        if (lineParser == null) {
            lineParser = INSTANCE;
        }
        return lineParser.parseRequestLine(charArrayBuffer, parserCursor);
    }

    public RequestLine parseRequestLine(CharArrayBuffer charArrayBuffer, ParserCursor parserCursor) throws ParseException {
        Args.notNull(charArrayBuffer, "Char array buffer");
        Args.notNull(parserCursor, "Parser cursor");
        int pos = parserCursor.getPos();
        int upperBound = parserCursor.getUpperBound();
        try {
            skipWhitespace(charArrayBuffer, parserCursor);
            int pos2 = parserCursor.getPos();
            int indexOf = charArrayBuffer.indexOf(32, pos2, upperBound);
            if (indexOf < 0) {
                throw new ParseException("Invalid request line: " + charArrayBuffer.substring(pos, upperBound));
            }
            String substringTrimmed = charArrayBuffer.substringTrimmed(pos2, indexOf);
            parserCursor.updatePos(indexOf);
            skipWhitespace(charArrayBuffer, parserCursor);
            indexOf = parserCursor.getPos();
            int indexOf2 = charArrayBuffer.indexOf(32, indexOf, upperBound);
            if (indexOf2 < 0) {
                throw new ParseException("Invalid request line: " + charArrayBuffer.substring(pos, upperBound));
            }
            String substringTrimmed2 = charArrayBuffer.substringTrimmed(indexOf, indexOf2);
            parserCursor.updatePos(indexOf2);
            ProtocolVersion parseProtocolVersion = parseProtocolVersion(charArrayBuffer, parserCursor);
            skipWhitespace(charArrayBuffer, parserCursor);
            if (parserCursor.atEnd()) {
                return createRequestLine(substringTrimmed, substringTrimmed2, parseProtocolVersion);
            }
            throw new ParseException("Invalid request line: " + charArrayBuffer.substring(pos, upperBound));
        } catch (IndexOutOfBoundsException e) {
            throw new ParseException("Invalid request line: " + charArrayBuffer.substring(pos, upperBound));
        }
    }

    protected RequestLine createRequestLine(String str, String str2, ProtocolVersion protocolVersion) {
        return new BasicRequestLine(str, str2, protocolVersion);
    }

    public static StatusLine parseStatusLine(String str, LineParser lineParser) throws ParseException {
        Args.notNull(str, "Value");
        CharArrayBuffer charArrayBuffer = new CharArrayBuffer(str.length());
        charArrayBuffer.append(str);
        ParserCursor parserCursor = new ParserCursor(0, str.length());
        if (lineParser == null) {
            lineParser = INSTANCE;
        }
        return lineParser.parseStatusLine(charArrayBuffer, parserCursor);
    }

    public StatusLine parseStatusLine(CharArrayBuffer charArrayBuffer, ParserCursor parserCursor) throws ParseException {
        Args.notNull(charArrayBuffer, "Char array buffer");
        Args.notNull(parserCursor, "Parser cursor");
        int pos = parserCursor.getPos();
        int upperBound = parserCursor.getUpperBound();
        try {
            int i;
            String substringTrimmed;
            ProtocolVersion parseProtocolVersion = parseProtocolVersion(charArrayBuffer, parserCursor);
            skipWhitespace(charArrayBuffer, parserCursor);
            int pos2 = parserCursor.getPos();
            int indexOf = charArrayBuffer.indexOf(32, pos2, upperBound);
            if (indexOf < 0) {
                i = upperBound;
            } else {
                i = indexOf;
            }
            String substringTrimmed2 = charArrayBuffer.substringTrimmed(pos2, i);
            indexOf = 0;
            while (indexOf < substringTrimmed2.length()) {
                if (Character.isDigit(substringTrimmed2.charAt(indexOf))) {
                    indexOf++;
                } else {
                    throw new ParseException("Status line contains invalid status code: " + charArrayBuffer.substring(pos, upperBound));
                }
            }
            pos2 = Integer.parseInt(substringTrimmed2);
            if (i < upperBound) {
                substringTrimmed = charArrayBuffer.substringTrimmed(i, upperBound);
            } else {
                substringTrimmed = "";
            }
            return createStatusLine(parseProtocolVersion, pos2, substringTrimmed);
        } catch (NumberFormatException e) {
            throw new ParseException("Status line contains invalid status code: " + charArrayBuffer.substring(pos, upperBound));
        } catch (IndexOutOfBoundsException e2) {
            throw new ParseException("Invalid status line: " + charArrayBuffer.substring(pos, upperBound));
        }
    }

    protected StatusLine createStatusLine(ProtocolVersion protocolVersion, int i, String str) {
        return new BasicStatusLine(protocolVersion, i, str);
    }

    public static Header parseHeader(String str, LineParser lineParser) throws ParseException {
        Args.notNull(str, "Value");
        CharArrayBuffer charArrayBuffer = new CharArrayBuffer(str.length());
        charArrayBuffer.append(str);
        if (lineParser == null) {
            lineParser = INSTANCE;
        }
        return lineParser.parseHeader(charArrayBuffer);
    }

    public Header parseHeader(CharArrayBuffer charArrayBuffer) throws ParseException {
        return new BufferedHeader(charArrayBuffer);
    }

    protected void skipWhitespace(CharArrayBuffer charArrayBuffer, ParserCursor parserCursor) {
        int pos = parserCursor.getPos();
        int upperBound = parserCursor.getUpperBound();
        while (pos < upperBound && HTTP.isWhitespace(charArrayBuffer.charAt(pos))) {
            pos++;
        }
        parserCursor.updatePos(pos);
    }
}
