package jd.wjlogin_sdk.util;

/* compiled from: TbsSdkJava */
public class StringBufferManager {
    private StringBuffer buffer = new StringBuffer();
    private int index = 0;

    public void AddBuffer(byte b) {
        this.buffer.append(b);
    }

    public void AddBuffer(short s) {
        this.buffer.append(s);
    }

    public void AddBuffer(int i) {
        this.buffer.append(i);
    }

    public void AddBuffer(long j) {
        this.buffer.append(j);
    }

    public void AddBuffer(String str) {
        AddBuffer((short) str.getBytes().length);
        this.buffer.append(str);
    }

    public byte getBufferByte() {
        char[] cArr = new char[1];
        this.buffer.getChars(0, 1, cArr, 0);
        return new String(cArr).getBytes()[0];
    }

    public short getBufferShort() {
        char[] cArr = new char[2];
        this.buffer.getChars(0, 2, cArr, this.index);
        this.index += 2;
        return ByteUtil.byteToShort(new String(cArr).getBytes());
    }

    public int getBufferInt() {
        char[] cArr = new char[4];
        this.buffer.getChars(0, 4, cArr, 0);
        return ByteUtil.byteToInt(new String(cArr).getBytes());
    }

    public long getBufferLong() {
        char[] cArr = new char[8];
        this.buffer.getChars(0, 8, cArr, 0);
        return ByteUtil.byteToLong(new String(cArr).getBytes());
    }

    public String getBufferString() {
        short bufferShort = getBufferShort();
        char[] cArr = new char[bufferShort];
        this.buffer.getChars(0, bufferShort, cArr, 0);
        this.index = bufferShort + this.index;
        return new String(cArr);
    }
}
