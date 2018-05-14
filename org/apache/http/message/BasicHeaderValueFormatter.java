package org.apache.http.message;

import org.apache.http.HeaderElement;
import org.apache.http.NameValuePair;
import org.apache.http.annotation.Immutable;
import org.apache.http.util.Args;
import org.apache.http.util.CharArrayBuffer;

@Immutable
/* compiled from: TbsSdkJava */
public class BasicHeaderValueFormatter implements HeaderValueFormatter {
    @Deprecated
    public static final BasicHeaderValueFormatter DEFAULT = new BasicHeaderValueFormatter();
    public static final BasicHeaderValueFormatter INSTANCE = new BasicHeaderValueFormatter();
    public static final String SEPARATORS = " ;,:@()<>\\\"/[]?={}\t";
    public static final String UNSAFE_CHARS = "\"\\";

    public static String formatElements(HeaderElement[] headerElementArr, boolean z, HeaderValueFormatter headerValueFormatter) {
        if (headerValueFormatter == null) {
            headerValueFormatter = INSTANCE;
        }
        return headerValueFormatter.formatElements(null, headerElementArr, z).toString();
    }

    public CharArrayBuffer formatElements(CharArrayBuffer charArrayBuffer, HeaderElement[] headerElementArr, boolean z) {
        Args.notNull(headerElementArr, "Header element array");
        int estimateElementsLen = estimateElementsLen(headerElementArr);
        if (charArrayBuffer == null) {
            charArrayBuffer = new CharArrayBuffer(estimateElementsLen);
        } else {
            charArrayBuffer.ensureCapacity(estimateElementsLen);
        }
        for (estimateElementsLen = 0; estimateElementsLen < headerElementArr.length; estimateElementsLen++) {
            if (estimateElementsLen > 0) {
                charArrayBuffer.append(", ");
            }
            formatHeaderElement(charArrayBuffer, headerElementArr[estimateElementsLen], z);
        }
        return charArrayBuffer;
    }

    protected int estimateElementsLen(HeaderElement[] headerElementArr) {
        int i = 0;
        if (headerElementArr != null && headerElementArr.length >= 1) {
            int length = (headerElementArr.length - 1) * 2;
            i = length;
            length = 0;
            while (length < headerElementArr.length) {
                int estimateHeaderElementLen = estimateHeaderElementLen(headerElementArr[length]) + i;
                length++;
                i = estimateHeaderElementLen;
            }
        }
        return i;
    }

    public static String formatHeaderElement(HeaderElement headerElement, boolean z, HeaderValueFormatter headerValueFormatter) {
        if (headerValueFormatter == null) {
            headerValueFormatter = INSTANCE;
        }
        return headerValueFormatter.formatHeaderElement(null, headerElement, z).toString();
    }

    public CharArrayBuffer formatHeaderElement(CharArrayBuffer charArrayBuffer, HeaderElement headerElement, boolean z) {
        Args.notNull(headerElement, "Header element");
        int estimateHeaderElementLen = estimateHeaderElementLen(headerElement);
        if (charArrayBuffer == null) {
            charArrayBuffer = new CharArrayBuffer(estimateHeaderElementLen);
        } else {
            charArrayBuffer.ensureCapacity(estimateHeaderElementLen);
        }
        charArrayBuffer.append(headerElement.getName());
        String value = headerElement.getValue();
        if (value != null) {
            charArrayBuffer.append('=');
            doFormatValue(charArrayBuffer, value, z);
        }
        int parameterCount = headerElement.getParameterCount();
        if (parameterCount > 0) {
            for (estimateHeaderElementLen = 0; estimateHeaderElementLen < parameterCount; estimateHeaderElementLen++) {
                charArrayBuffer.append("; ");
                formatNameValuePair(charArrayBuffer, headerElement.getParameter(estimateHeaderElementLen), z);
            }
        }
        return charArrayBuffer;
    }

    protected int estimateHeaderElementLen(HeaderElement headerElement) {
        int i = 0;
        if (headerElement == null) {
            return 0;
        }
        int length = headerElement.getName().length();
        String value = headerElement.getValue();
        if (value != null) {
            length += value.length() + 3;
        }
        int parameterCount = headerElement.getParameterCount();
        if (parameterCount <= 0) {
            return length;
        }
        while (i < parameterCount) {
            length += estimateNameValuePairLen(headerElement.getParameter(i)) + 2;
            i++;
        }
        return length;
    }

    public static String formatParameters(NameValuePair[] nameValuePairArr, boolean z, HeaderValueFormatter headerValueFormatter) {
        if (headerValueFormatter == null) {
            headerValueFormatter = INSTANCE;
        }
        return headerValueFormatter.formatParameters(null, nameValuePairArr, z).toString();
    }

    public CharArrayBuffer formatParameters(CharArrayBuffer charArrayBuffer, NameValuePair[] nameValuePairArr, boolean z) {
        Args.notNull(nameValuePairArr, "Header parameter array");
        int estimateParametersLen = estimateParametersLen(nameValuePairArr);
        if (charArrayBuffer == null) {
            charArrayBuffer = new CharArrayBuffer(estimateParametersLen);
        } else {
            charArrayBuffer.ensureCapacity(estimateParametersLen);
        }
        for (estimateParametersLen = 0; estimateParametersLen < nameValuePairArr.length; estimateParametersLen++) {
            if (estimateParametersLen > 0) {
                charArrayBuffer.append("; ");
            }
            formatNameValuePair(charArrayBuffer, nameValuePairArr[estimateParametersLen], z);
        }
        return charArrayBuffer;
    }

    protected int estimateParametersLen(NameValuePair[] nameValuePairArr) {
        int i = 0;
        if (nameValuePairArr != null && nameValuePairArr.length >= 1) {
            int length = (nameValuePairArr.length - 1) * 2;
            i = length;
            length = 0;
            while (length < nameValuePairArr.length) {
                int estimateNameValuePairLen = estimateNameValuePairLen(nameValuePairArr[length]) + i;
                length++;
                i = estimateNameValuePairLen;
            }
        }
        return i;
    }

    public static String formatNameValuePair(NameValuePair nameValuePair, boolean z, HeaderValueFormatter headerValueFormatter) {
        if (headerValueFormatter == null) {
            headerValueFormatter = INSTANCE;
        }
        return headerValueFormatter.formatNameValuePair(null, nameValuePair, z).toString();
    }

    public CharArrayBuffer formatNameValuePair(CharArrayBuffer charArrayBuffer, NameValuePair nameValuePair, boolean z) {
        Args.notNull(nameValuePair, "Name / value pair");
        int estimateNameValuePairLen = estimateNameValuePairLen(nameValuePair);
        if (charArrayBuffer == null) {
            charArrayBuffer = new CharArrayBuffer(estimateNameValuePairLen);
        } else {
            charArrayBuffer.ensureCapacity(estimateNameValuePairLen);
        }
        charArrayBuffer.append(nameValuePair.getName());
        String value = nameValuePair.getValue();
        if (value != null) {
            charArrayBuffer.append('=');
            doFormatValue(charArrayBuffer, value, z);
        }
        return charArrayBuffer;
    }

    protected int estimateNameValuePairLen(NameValuePair nameValuePair) {
        if (nameValuePair == null) {
            return 0;
        }
        int length = nameValuePair.getName().length();
        String value = nameValuePair.getValue();
        if (value != null) {
            return length + (value.length() + 3);
        }
        return length;
    }

    protected void doFormatValue(CharArrayBuffer charArrayBuffer, String str, boolean z) {
        int i = 0;
        if (!z) {
            for (int i2 = 0; i2 < str.length() && !r7; i2++) {
                z = isSeparator(str.charAt(i2));
            }
        }
        if (z) {
            charArrayBuffer.append('\"');
        }
        while (i < str.length()) {
            char charAt = str.charAt(i);
            if (isUnsafe(charAt)) {
                charArrayBuffer.append('\\');
            }
            charArrayBuffer.append(charAt);
            i++;
        }
        if (z) {
            charArrayBuffer.append('\"');
        }
    }

    protected boolean isSeparator(char c) {
        return SEPARATORS.indexOf(c) >= 0;
    }

    protected boolean isUnsafe(char c) {
        return UNSAFE_CHARS.indexOf(c) >= 0;
    }
}
