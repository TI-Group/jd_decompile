package okhttp3.internal;

import android.support.v4.media.TransportMediator;
import b.c;
import b.f;
import b.s;
import java.io.Closeable;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Array;
import java.net.IDN;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;
import okhttp3.HttpUrl;
import org.apache.http.protocol.HTTP;

/* compiled from: TbsSdkJava */
public final class Util {
    public static final byte[] EMPTY_BYTE_ARRAY = new byte[0];
    public static final String[] EMPTY_STRING_ARRAY = new String[0];
    public static final TimeZone UTC = TimeZone.getTimeZone("GMT");
    public static final Charset UTF_8 = Charset.forName(HTTP.UTF_8);
    private static final Pattern VERIFY_AS_IP_ADDRESS = Pattern.compile("([0-9a-fA-F]*:[0-9a-fA-F:.]*)|([\\d.]+)");

    private Util() {
    }

    public static void checkOffsetAndCount(long j, long j2, long j3) {
        if ((j2 | j3) < 0 || j2 > j || j - j2 < j3) {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    public static boolean equal(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    public static void closeQuietly(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (RuntimeException e) {
                throw e;
            } catch (Exception e2) {
            }
        }
    }

    public static void closeQuietly(Socket socket) {
        if (socket != null) {
            try {
                socket.close();
            } catch (AssertionError e) {
                if (!isAndroidGetsocknameError(e)) {
                    throw e;
                }
            } catch (RuntimeException e2) {
                throw e2;
            } catch (Exception e3) {
            }
        }
    }

    public static void closeQuietly(ServerSocket serverSocket) {
        if (serverSocket != null) {
            try {
                serverSocket.close();
            } catch (RuntimeException e) {
                throw e;
            } catch (Exception e2) {
            }
        }
    }

    public static void closeAll(Closeable closeable, Closeable closeable2) throws IOException {
        Object obj = null;
        try {
            closeable.close();
        } catch (Throwable th) {
            obj = th;
        }
        try {
            closeable2.close();
        } catch (Throwable th2) {
            if (obj == null) {
                Throwable th3 = th2;
            }
        }
        if (obj != null) {
            if (obj instanceof IOException) {
                throw ((IOException) obj);
            } else if (obj instanceof RuntimeException) {
                throw ((RuntimeException) obj);
            } else if (obj instanceof Error) {
                throw ((Error) obj);
            } else {
                throw new AssertionError(obj);
            }
        }
    }

    public static boolean discard(s sVar, int i, TimeUnit timeUnit) {
        try {
            return skipAll(sVar, i, timeUnit);
        } catch (IOException e) {
            return false;
        }
    }

    public static boolean skipAll(s sVar, int i, TimeUnit timeUnit) throws IOException {
        long nanoTime = System.nanoTime();
        long deadlineNanoTime = sVar.timeout().hasDeadline() ? sVar.timeout().deadlineNanoTime() - nanoTime : Long.MAX_VALUE;
        sVar.timeout().deadlineNanoTime(Math.min(deadlineNanoTime, timeUnit.toNanos((long) i)) + nanoTime);
        try {
            c cVar = new c();
            while (sVar.read(cVar, 2048) != -1) {
                cVar.u();
            }
            if (deadlineNanoTime == Long.MAX_VALUE) {
                sVar.timeout().clearDeadline();
            } else {
                sVar.timeout().deadlineNanoTime(deadlineNanoTime + nanoTime);
            }
            return true;
        } catch (InterruptedIOException e) {
            if (deadlineNanoTime == Long.MAX_VALUE) {
                sVar.timeout().clearDeadline();
            } else {
                sVar.timeout().deadlineNanoTime(deadlineNanoTime + nanoTime);
            }
            return false;
        } catch (Throwable th) {
            if (deadlineNanoTime == Long.MAX_VALUE) {
                sVar.timeout().clearDeadline();
            } else {
                sVar.timeout().deadlineNanoTime(deadlineNanoTime + nanoTime);
            }
            throw th;
        }
    }

    public static String md5Hex(String str) {
        Object e;
        try {
            return f.of(MessageDigest.getInstance("MD5").digest(str.getBytes(HTTP.UTF_8))).hex();
        } catch (NoSuchAlgorithmException e2) {
            e = e2;
            throw new AssertionError(e);
        } catch (UnsupportedEncodingException e3) {
            e = e3;
            throw new AssertionError(e);
        }
    }

    public static String shaBase64(String str) {
        Object e;
        try {
            return f.of(MessageDigest.getInstance("SHA-1").digest(str.getBytes(HTTP.UTF_8))).base64();
        } catch (NoSuchAlgorithmException e2) {
            e = e2;
            throw new AssertionError(e);
        } catch (UnsupportedEncodingException e3) {
            e = e3;
            throw new AssertionError(e);
        }
    }

    public static f sha1(f fVar) {
        try {
            return f.of(MessageDigest.getInstance("SHA-1").digest(fVar.toByteArray()));
        } catch (NoSuchAlgorithmException e) {
            throw new AssertionError(e);
        }
    }

    public static f sha256(f fVar) {
        try {
            return f.of(MessageDigest.getInstance("SHA-256").digest(fVar.toByteArray()));
        } catch (NoSuchAlgorithmException e) {
            throw new AssertionError(e);
        }
    }

    public static <T> List<T> immutableList(List<T> list) {
        return Collections.unmodifiableList(new ArrayList(list));
    }

    public static <T> List<T> immutableList(T... tArr) {
        return Collections.unmodifiableList(Arrays.asList((Object[]) tArr.clone()));
    }

    public static <K, V> Map<K, V> immutableMap(Map<K, V> map) {
        return Collections.unmodifiableMap(new LinkedHashMap(map));
    }

    public static ThreadFactory threadFactory(final String str, final boolean z) {
        return new ThreadFactory() {
            public Thread newThread(Runnable runnable) {
                Thread thread = new Thread(runnable, str);
                thread.setDaemon(z);
                return thread;
            }
        };
    }

    public static <T> T[] intersect(Class<T> cls, T[] tArr, T[] tArr2) {
        List intersect = intersect(tArr, tArr2);
        return intersect.toArray((Object[]) Array.newInstance(cls, intersect.size()));
    }

    private static <T> List<T> intersect(T[] tArr, T[] tArr2) {
        List<T> arrayList = new ArrayList();
        for (Object obj : tArr) {
            for (Object obj2 : tArr2) {
                if (obj.equals(obj2)) {
                    arrayList.add(obj2);
                    break;
                }
            }
        }
        return arrayList;
    }

    public static String hostHeader(HttpUrl httpUrl, boolean z) {
        String str;
        if (httpUrl.host().contains(":")) {
            str = "[" + httpUrl.host() + "]";
        } else {
            str = httpUrl.host();
        }
        return (z || httpUrl.port() != HttpUrl.defaultPort(httpUrl.scheme())) ? str + ":" + httpUrl.port() : str;
    }

    public static String toHumanReadableAscii(String str) {
        int length = str.length();
        int i = 0;
        while (i < length) {
            int codePointAt = str.codePointAt(i);
            if (codePointAt <= 31 || codePointAt >= TransportMediator.KEYCODE_MEDIA_PAUSE) {
                c cVar = new c();
                cVar.a(str, 0, i);
                codePointAt = i;
                while (codePointAt < length) {
                    int codePointAt2 = str.codePointAt(codePointAt);
                    i = (codePointAt2 <= 31 || codePointAt2 >= TransportMediator.KEYCODE_MEDIA_PAUSE) ? 63 : codePointAt2;
                    cVar.a(i);
                    codePointAt = Character.charCount(codePointAt2) + codePointAt;
                }
                return cVar.r();
            }
            i += Character.charCount(codePointAt);
        }
        return str;
    }

    public static boolean isAndroidGetsocknameError(AssertionError assertionError) {
        return (assertionError.getCause() == null || assertionError.getMessage() == null || !assertionError.getMessage().contains("getsockname failed")) ? false : true;
    }

    public static boolean contains(String[] strArr, String str) {
        return Arrays.asList(strArr).contains(str);
    }

    public static String[] concat(String[] strArr, String str) {
        Object obj = new String[(strArr.length + 1)];
        System.arraycopy(strArr, 0, obj, 0, strArr.length);
        obj[obj.length - 1] = str;
        return obj;
    }

    public static int skipLeadingAsciiWhitespace(String str, int i, int i2) {
        int i3 = i;
        while (i3 < i2) {
            switch (str.charAt(i3)) {
                case '\t':
                case '\n':
                case '\f':
                case '\r':
                case ' ':
                    i3++;
                default:
                    return i3;
            }
        }
        return i2;
    }

    public static int skipTrailingAsciiWhitespace(String str, int i, int i2) {
        int i3 = i2 - 1;
        while (i3 >= i) {
            switch (str.charAt(i3)) {
                case '\t':
                case '\n':
                case '\f':
                case '\r':
                case ' ':
                    i3--;
                default:
                    return i3 + 1;
            }
        }
        return i;
    }

    public static String trimSubstring(String str, int i, int i2) {
        int skipLeadingAsciiWhitespace = skipLeadingAsciiWhitespace(str, i, i2);
        return str.substring(skipLeadingAsciiWhitespace, skipTrailingAsciiWhitespace(str, skipLeadingAsciiWhitespace, i2));
    }

    public static int delimiterOffset(String str, int i, int i2, String str2) {
        for (int i3 = i; i3 < i2; i3++) {
            if (str2.indexOf(str.charAt(i3)) != -1) {
                return i3;
            }
        }
        return i2;
    }

    public static int delimiterOffset(String str, int i, int i2, char c) {
        for (int i3 = i; i3 < i2; i3++) {
            if (str.charAt(i3) == c) {
                return i3;
            }
        }
        return i2;
    }

    public static String domainToAscii(String str) {
        try {
            String toLowerCase = IDN.toASCII(str).toLowerCase(Locale.US);
            if (toLowerCase.isEmpty() || containsInvalidHostnameAsciiCodes(toLowerCase)) {
                return null;
            }
            return toLowerCase;
        } catch (IllegalArgumentException e) {
            return null;
        }
    }

    private static boolean containsInvalidHostnameAsciiCodes(String str) {
        for (int i = 0; i < str.length(); i++) {
            char charAt = str.charAt(i);
            if (charAt <= '\u001f' || charAt >= '') {
                return true;
            }
            if (" #%/:?@[\\]".indexOf(charAt) != -1) {
                return true;
            }
        }
        return false;
    }

    public static boolean verifyAsIpAddress(String str) {
        return VERIFY_AS_IP_ADDRESS.matcher(str).matches();
    }
}
