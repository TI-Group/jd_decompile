package okhttp3.internal.http;

import java.io.IOException;

/* compiled from: TbsSdkJava */
public final class RequestException extends Exception {
    public RequestException(IOException iOException) {
        super(iOException);
    }

    public IOException getCause() {
        return (IOException) super.getCause();
    }
}
