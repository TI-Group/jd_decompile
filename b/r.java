package b;

import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;

/* compiled from: TbsSdkJava */
public interface r extends Closeable, Flushable {
    void close() throws IOException;

    void flush() throws IOException;

    t timeout();

    void write(c cVar, long j) throws IOException;
}
