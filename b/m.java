package b;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.logging.Level;
import java.util.logging.Logger;

/* compiled from: TbsSdkJava */
public final class m {
    private static final Logger a = Logger.getLogger(m.class.getName());

    private m() {
    }

    public static e a(s sVar) {
        if (sVar != null) {
            return new o(sVar);
        }
        throw new IllegalArgumentException("source == null");
    }

    public static d a(r rVar) {
        if (rVar != null) {
            return new n(rVar);
        }
        throw new IllegalArgumentException("sink == null");
    }

    public static r a(OutputStream outputStream) {
        return a(outputStream, new t());
    }

    private static r a(final OutputStream outputStream, final t tVar) {
        if (outputStream == null) {
            throw new IllegalArgumentException("out == null");
        } else if (tVar != null) {
            return new r() {
                public void write(c cVar, long j) throws IOException {
                    u.a(cVar.b, 0, j);
                    while (j > 0) {
                        tVar.throwIfReached();
                        p pVar = cVar.a;
                        int min = (int) Math.min(j, (long) (pVar.c - pVar.b));
                        outputStream.write(pVar.a, pVar.b, min);
                        pVar.b += min;
                        j -= (long) min;
                        cVar.b -= (long) min;
                        if (pVar.b == pVar.c) {
                            cVar.a = pVar.a();
                            q.a(pVar);
                        }
                    }
                }

                public void flush() throws IOException {
                    outputStream.flush();
                }

                public void close() throws IOException {
                    outputStream.close();
                }

                public t timeout() {
                    return tVar;
                }

                public String toString() {
                    return "sink(" + outputStream + ")";
                }
            };
        } else {
            throw new IllegalArgumentException("timeout == null");
        }
    }

    public static r a(Socket socket) throws IOException {
        if (socket == null) {
            throw new IllegalArgumentException("socket == null");
        }
        t c = c(socket);
        return c.sink(a(socket.getOutputStream(), c));
    }

    public static s a(InputStream inputStream) {
        return a(inputStream, new t());
    }

    private static s a(final InputStream inputStream, final t tVar) {
        if (inputStream == null) {
            throw new IllegalArgumentException("in == null");
        } else if (tVar != null) {
            return new s() {
                public long read(c cVar, long j) throws IOException {
                    if (j < 0) {
                        throw new IllegalArgumentException("byteCount < 0: " + j);
                    } else if (j == 0) {
                        return 0;
                    } else {
                        tVar.throwIfReached();
                        p e = cVar.e(1);
                        int read = inputStream.read(e.a, e.c, (int) Math.min(j, (long) (2048 - e.c)));
                        if (read == -1) {
                            return -1;
                        }
                        e.c += read;
                        cVar.b += (long) read;
                        return (long) read;
                    }
                }

                public void close() throws IOException {
                    inputStream.close();
                }

                public t timeout() {
                    return tVar;
                }

                public String toString() {
                    return "source(" + inputStream + ")";
                }
            };
        } else {
            throw new IllegalArgumentException("timeout == null");
        }
    }

    public static s a(File file) throws FileNotFoundException {
        if (file != null) {
            return a(new FileInputStream(file));
        }
        throw new IllegalArgumentException("file == null");
    }

    public static r b(File file) throws FileNotFoundException {
        if (file != null) {
            return a(new FileOutputStream(file));
        }
        throw new IllegalArgumentException("file == null");
    }

    public static r c(File file) throws FileNotFoundException {
        if (file != null) {
            return a(new FileOutputStream(file, true));
        }
        throw new IllegalArgumentException("file == null");
    }

    public static s b(Socket socket) throws IOException {
        if (socket == null) {
            throw new IllegalArgumentException("socket == null");
        }
        t c = c(socket);
        return c.source(a(socket.getInputStream(), c));
    }

    private static a c(final Socket socket) {
        return new a() {
            protected IOException newTimeoutException(IOException iOException) {
                IOException socketTimeoutException = new SocketTimeoutException("timeout");
                if (iOException != null) {
                    socketTimeoutException.initCause(iOException);
                }
                return socketTimeoutException;
            }

            protected void timedOut() {
                try {
                    socket.close();
                } catch (Throwable e) {
                    m.a.log(Level.WARNING, "Failed to close timed out socket " + socket, e);
                } catch (Throwable e2) {
                    if (e2.getCause() == null || e2.getMessage() == null || !e2.getMessage().contains("getsockname failed")) {
                        throw e2;
                    }
                    m.a.log(Level.WARNING, "Failed to close timed out socket " + socket, e2);
                }
            }
        };
    }
}
