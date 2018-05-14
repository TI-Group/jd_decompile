package okhttp3.internal;

import b.c;
import b.h;
import b.r;
import java.io.IOException;

/* compiled from: TbsSdkJava */
class FaultHidingSink extends h {
    private boolean hasErrors;

    public FaultHidingSink(r rVar) {
        super(rVar);
    }

    public void write(c cVar, long j) throws IOException {
        if (this.hasErrors) {
            cVar.h(j);
            return;
        }
        try {
            super.write(cVar, j);
        } catch (IOException e) {
            this.hasErrors = true;
            onException(e);
        }
    }

    public void flush() throws IOException {
        if (!this.hasErrors) {
            try {
                super.flush();
            } catch (IOException e) {
                this.hasErrors = true;
                onException(e);
            }
        }
    }

    public void close() throws IOException {
        if (!this.hasErrors) {
            try {
                super.close();
            } catch (IOException e) {
                this.hasErrors = true;
                onException(e);
            }
        }
    }

    protected void onException(IOException iOException) {
    }
}
