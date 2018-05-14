package b;

import java.io.Closeable;
import java.io.IOException;

/* compiled from: TbsSdkJava */
public interface s extends Closeable {
    void close() throws IOException;

    long read(c cVar, long j) throws IOException;

    t timeout();
}
