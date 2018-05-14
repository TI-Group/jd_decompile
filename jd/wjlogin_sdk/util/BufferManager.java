package jd.wjlogin_sdk.util;

import java.nio.ByteBuffer;

/* compiled from: TbsSdkJava */
public class BufferManager {
    private static final short defual_len = (short) 1024;
    private ByteBuffer buffer;
    private short bufferlen;
    private short index;
    private short total_len;

    public BufferManager() {
        this.buffer = ByteBuffer.allocate(1024);
        this.total_len = defual_len;
    }

    public BufferManager(byte[] bArr) {
        this.bufferlen = (short) bArr.length;
        this.buffer = ByteBuffer.allocate(this.bufferlen);
        this.buffer.put(bArr);
    }

    public int getLimit() {
        return this.buffer.limit();
    }

    public int getNowPostion() {
        return this.buffer.position();
    }

    public byte[] getBufferArray() {
        flip();
        byte[] bArr = new byte[this.bufferlen];
        for (short s = (short) 0; s < this.bufferlen; s++) {
            bArr[s] = this.buffer.get();
        }
        return bArr;
    }

    public void AddBuffer(byte b) {
        checkBufferLen((short) 1);
        this.buffer.put(b);
        this.bufferlen = (short) (this.bufferlen + 1);
        ChangeBufferLen();
    }

    public void AddBuffer(short s) {
        checkBufferLen((short) 2);
        this.buffer.putShort(s);
        this.bufferlen = (short) (this.bufferlen + 2);
        ChangeBufferLen();
    }

    public void AddBuffer(int i) {
        checkBufferLen((short) 4);
        this.buffer.putInt(i);
        this.bufferlen = (short) (this.bufferlen + 4);
        ChangeBufferLen();
    }

    public void AddBuffer(long j) {
        checkBufferLen((short) 8);
        this.buffer.putLong(j);
        this.bufferlen = (short) (this.bufferlen + 8);
        ChangeBufferLen();
    }

    public void AddBuffer(String str) {
        byte[] bytes = str.getBytes();
        short length = (short) bytes.length;
        AddBuffer(length);
        checkBufferLen(length);
        this.buffer.put(bytes);
        this.bufferlen = (short) (this.bufferlen + length);
        ChangeBufferLen();
    }

    public void AddBufferNoLen(String str) {
        byte[] bytes = str.getBytes();
        short length = (short) bytes.length;
        checkBufferLen(length);
        this.buffer.put(bytes);
        this.bufferlen = (short) (this.bufferlen + length);
        ChangeBufferLen();
    }

    public void AddBuffer(byte[] bArr) {
        short length = (short) bArr.length;
        AddBuffer(length);
        checkBufferLen(length);
        this.buffer.put(bArr);
        this.bufferlen = (short) (length + this.bufferlen);
        ChangeBufferLen();
    }

    private void ChangeBufferLen() {
        this.buffer.putShort(0, this.bufferlen);
    }

    private void checkBufferLen(short s) {
        if (this.bufferlen + s > this.total_len) {
            this.total_len = (short) (this.total_len * 2);
            ByteBuffer allocate = ByteBuffer.allocate(this.total_len);
            allocate.put(getBufferArray());
            this.buffer = allocate;
        }
    }

    public short getBytesLen(String str) {
        return (short) str.getBytes().length;
    }

    public byte getBufferByte() {
        this.index = (short) (this.index + 1);
        return this.buffer.get();
    }

    public short getBufferShort() {
        this.index = (short) (this.index + 2);
        return this.buffer.getShort();
    }

    public int getBufferInt() {
        this.index = (short) (this.index + 4);
        return this.buffer.getInt();
    }

    public long getBufferLong() {
        this.index = (short) (this.index + 8);
        return this.buffer.getLong();
    }

    public String getBufferString() {
        short bufferShort = getBufferShort();
        byte[] bArr = new byte[bufferShort];
        for (short s = (short) 0; s < bufferShort; s++) {
            bArr[s] = this.buffer.get();
        }
        this.index = (short) (this.index + bufferShort);
        return new String(bArr);
    }

    public byte[] getBufferBytes() {
        short bufferShort = getBufferShort();
        byte[] bArr = new byte[bufferShort];
        for (short s = (short) 0; s < bufferShort; s++) {
            bArr[s] = this.buffer.get();
        }
        this.index = (short) (this.index + bufferShort);
        return bArr;
    }

    public byte[] getBufferBytes(int i) {
        byte[] bArr = new byte[i];
        for (int i2 = 0; i2 < i; i2++) {
            bArr[i2] = this.buffer.get();
        }
        this.index = (short) (this.index + i);
        return bArr;
    }

    public void flip() {
        this.buffer.flip();
    }

    public boolean isEnd() {
        return this.index >= this.bufferlen;
    }
}
