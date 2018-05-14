package okhttp3.internal.framed;

import b.c;
import b.e;
import b.f;
import b.i;
import b.l;
import b.m;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;

/* compiled from: TbsSdkJava */
class NameValueBlockReader {
    private int compressedLimit;
    private final l inflaterSource;
    private final e source = m.a(this.inflaterSource);

    public NameValueBlockReader(e eVar) {
        this.inflaterSource = new l(new i(eVar) {
            public long read(c cVar, long j) throws IOException {
                if (NameValueBlockReader.this.compressedLimit == 0) {
                    return -1;
                }
                long read = super.read(cVar, Math.min(j, (long) NameValueBlockReader.this.compressedLimit));
                if (read == -1) {
                    return -1;
                }
                NameValueBlockReader.this.compressedLimit = (int) (((long) NameValueBlockReader.this.compressedLimit) - read);
                return read;
            }
        }, new Inflater() {
            public int inflate(byte[] bArr, int i, int i2) throws DataFormatException {
                int inflate = super.inflate(bArr, i, i2);
                if (inflate != 0 || !needsDictionary()) {
                    return inflate;
                }
                setDictionary(Spdy3.DICTIONARY);
                return super.inflate(bArr, i, i2);
            }
        });
    }

    public List<Header> readNameValueBlock(int i) throws IOException {
        this.compressedLimit += i;
        int j = this.source.j();
        if (j < 0) {
            throw new IOException("numberOfPairs < 0: " + j);
        } else if (j > 1024) {
            throw new IOException("numberOfPairs > 1024: " + j);
        } else {
            List<Header> arrayList = new ArrayList(j);
            for (int i2 = 0; i2 < j; i2++) {
                f toAsciiLowercase = readByteString().toAsciiLowercase();
                f readByteString = readByteString();
                if (toAsciiLowercase.size() == 0) {
                    throw new IOException("name.size == 0");
                }
                arrayList.add(new Header(toAsciiLowercase, readByteString));
            }
            doneReading();
            return arrayList;
        }
    }

    private f readByteString() throws IOException {
        return this.source.d((long) this.source.j());
    }

    private void doneReading() throws IOException {
        if (this.compressedLimit > 0) {
            this.inflaterSource.a();
            if (this.compressedLimit != 0) {
                throw new IOException("compressedLimit > 0: " + this.compressedLimit);
            }
        }
    }

    public void close() throws IOException {
        this.source.close();
    }
}
