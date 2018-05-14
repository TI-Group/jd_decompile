package cn.jiguang.api;

import java.nio.ByteBuffer;

public abstract class JRequest extends JProtocol {
    public JRequest(int i, int i2, long j) {
        super(true, i, i2, j);
    }

    public JRequest(Object obj, ByteBuffer byteBuffer) {
        super(true, obj, byteBuffer);
    }

    public void setJuid(long j) {
        this.head.a(j);
    }

    public void setSid(int i) {
        this.head.b(i);
    }
}
