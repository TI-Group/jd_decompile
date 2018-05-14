package okhttp3;

import java.io.IOException;

/* compiled from: TbsSdkJava */
public interface Interceptor {

    /* compiled from: TbsSdkJava */
    public interface Chain {
        Connection connection();

        Response proceed(Request request) throws IOException;

        Request request();
    }

    Response intercept(Chain chain) throws IOException;
}
