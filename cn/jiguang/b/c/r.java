package cn.jiguang.b.c;

import java.io.EOFException;
import java.net.SocketAddress;
import java.net.SocketTimeoutException;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

public final class r extends a {
    private r(long j) {
        super(SocketChannel.open(), j);
    }

    private byte[] a(int i) {
        SocketChannel socketChannel = (SocketChannel) this.b.channel();
        byte[] bArr = new byte[i];
        ByteBuffer wrap = ByteBuffer.wrap(bArr);
        this.b.interestOps(1);
        int i2 = 0;
        while (i2 < i) {
            if (this.b.isReadable()) {
                long read = (long) socketChannel.read(wrap);
                if (read < 0) {
                    throw new EOFException();
                }
                i2 += (int) read;
                if (i2 < i) {
                    try {
                        if (System.currentTimeMillis() > this.a) {
                            throw new SocketTimeoutException();
                        }
                    } catch (Throwable th) {
                        if (this.b.isValid()) {
                            this.b.interestOps(0);
                        }
                    }
                } else {
                    continue;
                }
            } else {
                a.a(this.b, this.a);
            }
        }
        if (this.b.isValid()) {
            this.b.interestOps(0);
        }
        return bArr;
    }

    public static byte[] a(SocketAddress socketAddress, SocketAddress socketAddress2, byte[] bArr, long j) {
        int i = 0;
        r rVar = new r(j);
        try {
            SocketChannel socketChannel = (SocketChannel) rVar.b.channel();
            if (!socketChannel.connect(socketAddress2)) {
                rVar.b.interestOps(8);
                while (!socketChannel.finishConnect()) {
                    if (!rVar.b.isConnectable()) {
                        a.a(rVar.b, rVar.a);
                    }
                }
                if (rVar.b.isValid()) {
                    rVar.b.interestOps(0);
                }
            }
            socketChannel = (SocketChannel) rVar.b.channel();
            byte[] bArr2 = new byte[]{(byte) (bArr.length >>> 8), (byte) (bArr.length & 255)};
            ByteBuffer[] byteBufferArr = new ByteBuffer[]{ByteBuffer.wrap(bArr2), ByteBuffer.wrap(bArr)};
            rVar.b.interestOps(4);
            while (i < bArr.length + 2) {
                if (rVar.b.isWritable()) {
                    long write = socketChannel.write(byteBufferArr);
                    if (write < 0) {
                        throw new EOFException();
                    }
                    i += (int) write;
                    if (i < bArr.length + 2 && System.currentTimeMillis() > rVar.a) {
                        throw new SocketTimeoutException();
                    }
                }
                a.a(rVar.b, rVar.a);
            }
            if (rVar.b.isValid()) {
                rVar.b.interestOps(0);
            }
            byte[] a = rVar.a(2);
            a = rVar.a((a[1] & 255) + ((a[0] & 255) << 8));
            rVar.b.channel();
            rVar.a();
            return a;
        } catch (Throwable th) {
            rVar.a();
        }
    }
}
