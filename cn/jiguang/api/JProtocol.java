package cn.jiguang.api;

import cn.jiguang.api.utils.ProtocolUtil;
import cn.jiguang.b.e.a.a.c;
import cn.jiguang.c.d;
import cn.jiguang.e.j;
import java.io.ByteArrayOutputStream;
import java.nio.ByteBuffer;

public abstract class JProtocol {
    public static final int DEFAULT_RESP_CODE = 0;
    public static final int DEFAULT_RID = 0;
    public static final int DEFAULT_SID = 0;
    public static final int NO_JUID = -1;
    public static final int NO_RESP_CODE = -1;
    public static final int NO_SID = -1;
    private static final int PACKET_SIZE = 7168;
    private static final String TAG;
    private static final String[] z;
    protected ByteBuffer body;
    protected c head;
    private boolean isRequest;

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static {
        /*
        r0 = 10;
        r3 = new java.lang.String[r0];
        r2 = 0;
        r1 = "\u0005\u000f\u000f88 <\u0012;";
        r0 = 9;
        r4 = r3;
    L_0x000a:
        r1 = r1.toCharArray();
        r5 = r1.length;
        r6 = 0;
        r7 = 1;
        if (r5 > r7) goto L_0x0035;
    L_0x0013:
        r7 = r1;
        r8 = r6;
        r11 = r5;
        r5 = r1;
        r1 = r11;
    L_0x0018:
        r10 = r5[r6];
        r9 = r8 % 5;
        switch(r9) {
            case 0: goto L_0x0094;
            case 1: goto L_0x0097;
            case 2: goto L_0x009a;
            case 3: goto L_0x009d;
            default: goto L_0x001f;
        };
    L_0x001f:
        r9 = 76;
    L_0x0021:
        r9 = r9 ^ r10;
        r9 = (char) r9;
        r5[r6] = r9;
        r6 = r8 + 1;
        if (r1 != 0) goto L_0x0033;
    L_0x0029:
        r5 = r7;
        r8 = r6;
        r6 = r1;
        goto L_0x0018;
    L_0x002d:
        TAG = r1;
        r1 = ":1\u00169#825&*<\t";
        r0 = -1;
        goto L_0x000a;
    L_0x0033:
        r5 = r1;
        r1 = r7;
    L_0x0035:
        if (r5 > r6) goto L_0x0013;
    L_0x0037:
        r5 = new java.lang.String;
        r5.<init>(r1);
        r1 = r5.intern();
        switch(r0) {
            case 0: goto L_0x004b;
            case 1: goto L_0x0053;
            case 2: goto L_0x005b;
            case 3: goto L_0x0063;
            case 4: goto L_0x006b;
            case 5: goto L_0x0073;
            case 6: goto L_0x007b;
            case 7: goto L_0x0084;
            case 8: goto L_0x008f;
            case 9: goto L_0x002d;
            default: goto L_0x0043;
        };
    L_0x0043:
        r3[r2] = r1;
        r2 = 1;
        r1 = " =\u00172/;\n6?o1\b; ";
        r0 = 0;
        r3 = r4;
        goto L_0x000a;
    L_0x004b:
        r3[r2] = r1;
        r2 = 2;
        r1 = "\u00010]5#+&]##o/\u001c%?*q";
        r0 = 1;
        r3 = r4;
        goto L_0x000a;
    L_0x0053:
        r3[r2] = r1;
        r2 = 3;
        r1 = ",-\u001868*7\u001f).;]1-&3\u00183v";
        r0 = 2;
        r3 = r4;
        goto L_0x000a;
    L_0x005b:
        r3[r2] = r1;
        r2 = 4;
        r1 = ";0?.8*,]5#+&?.8*,]w%<]99#3";
        r0 = 3;
        r3 = r4;
        goto L_0x000a;
    L_0x0063:
        r3[r2] = r1;
        r2 = 5;
        r1 = "c\u001f.8*,Gw";
        r0 = 4;
        r3 = r4;
        goto L_0x000a;
    L_0x006b:
        r3[r2] = r1;
        r2 = 6;
        r1 = "\t6\u00136 or];)!e";
        r0 = 5;
        r3 = r4;
        goto L_0x000a;
    L_0x0073:
        r3[r2] = r1;
        r2 = 7;
        r1 = "\u0014\r\u0018$< 1\u000e2\u0011";
        r0 = 6;
        r3 = r4;
        goto L_0x000a;
    L_0x007b:
        r3[r2] = r1;
        r2 = 8;
        r1 = "\u0014\r\u0018&9*,\t\n";
        r0 = 7;
        r3 = r4;
        goto L_0x000a;
    L_0x0084:
        r3[r2] = r1;
        r2 = 9;
        r1 = "or]";
        r0 = 8;
        r3 = r4;
        goto L_0x000a;
    L_0x008f:
        r3[r2] = r1;
        z = r4;
        return;
    L_0x0094:
        r9 = 79;
        goto L_0x0021;
    L_0x0097:
        r9 = 95;
        goto L_0x0021;
    L_0x009a:
        r9 = 125; // 0x7d float:1.75E-43 double:6.2E-322;
        goto L_0x0021;
    L_0x009d:
        r9 = 87;
        goto L_0x0021;
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jiguang.api.JProtocol.<clinit>():void");
    }

    public JProtocol(boolean z, int i, int i2, long j) {
        this.isRequest = z;
        this.head = new c(z, i, i2, j);
        this.body = ByteBuffer.allocate(PACKET_SIZE);
    }

    public JProtocol(boolean z, int i, int i2, long j, int i3, long j2) {
        this.isRequest = z;
        this.head = new c(z, 0, i, i2, j, i3, j2);
        this.body = ByteBuffer.allocate(PACKET_SIZE);
    }

    public JProtocol(boolean z, Object obj, ByteBuffer byteBuffer) {
        this.isRequest = z;
        this.head = (c) obj;
        if (byteBuffer != null) {
            this.body = byteBuffer;
            parseBody();
            return;
        }
        d.g(TAG, z[2]);
    }

    public JProtocol(boolean z, ByteBuffer byteBuffer, byte[] bArr) {
        this.isRequest = z;
        try {
            this.head = new c(z, bArr);
        } catch (Exception e) {
            d.g(TAG, new StringBuilder(z[3]).append(e.getMessage()).toString());
        }
        if (byteBuffer != null) {
            this.body = byteBuffer;
            parseBody();
            return;
        }
        d.g(TAG, z[2]);
    }

    public static byte[] parseHead(Object obj) {
        if (obj == null) {
            d.g(TAG, z[1]);
            return null;
        } else if (obj instanceof c) {
            return ((c) obj).f();
        } else {
            d.g(TAG, z[0]);
            return null;
        }
    }

    private final byte[] toBytes() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bytes = ProtocolUtil.getBytes(this.body);
        if (bytes == null) {
            d.g(TAG, z[4]);
            return null;
        }
        this.head.a((this.isRequest ? 24 : 20) + bytes.length);
        try {
            byteArrayOutputStream.write(this.head.f());
            byteArrayOutputStream.write(bytes);
        } catch (Exception e) {
        }
        byte[] toByteArray = byteArrayOutputStream.toByteArray();
        d.c(TAG, new StringBuilder(z[6]).append(toByteArray.length).append(z[5]).append(j.a(toByteArray)).toString());
        return toByteArray;
    }

    public ByteBuffer getBody() {
        return this.body;
    }

    public int getCommand() {
        return this.head.a();
    }

    public c getHead() {
        return this.head;
    }

    public long getJuid() {
        return this.head.c();
    }

    public abstract String getName();

    public Long getRid() {
        return this.head.b();
    }

    public int getSid() {
        return this.head.d();
    }

    public int getVersion() {
        return this.head.e();
    }

    protected abstract boolean isNeedParseeErrorMsg();

    protected abstract void parseBody();

    public String toString() {
        return (this.isRequest ? z[8] : z[7]) + z[9] + this.head.toString();
    }

    protected abstract void writeBody();

    public final byte[] writeBodyAndToBytes() {
        this.body.clear();
        writeBody();
        this.body.flip();
        return toBytes();
    }

    protected void writeBytes(byte[] bArr) {
        this.body.put(bArr);
    }

    protected void writeInt1(int i) {
        this.body.put((byte) i);
    }

    protected void writeInt2(int i) {
        this.body.putShort((short) i);
    }

    protected void writeInt4(int i) {
        this.body.putInt(i);
    }

    protected void writeLong8(long j) {
        this.body.putLong(j);
    }

    protected void writeTlv2(String str) {
        this.body.put(ProtocolUtil.tlv2ToByteArray(str));
    }
}
