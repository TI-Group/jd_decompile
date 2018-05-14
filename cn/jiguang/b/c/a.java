package cn.jiguang.b.c;

import java.net.SocketTimeoutException;
import java.nio.channels.SelectableChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;

class a {
    protected long a;
    protected SelectionKey b;

    protected a(SelectableChannel selectableChannel, long j) {
        Selector selector = null;
        this.a = j;
        try {
            selector = Selector.open();
            selectableChannel.configureBlocking(false);
            this.b = selectableChannel.register(selector, 1);
        } catch (Throwable th) {
            if (selector != null) {
                selector.close();
            }
            selectableChannel.close();
        }
    }

    protected static void a(SelectionKey selectionKey, long j) {
        long currentTimeMillis = j - System.currentTimeMillis();
        int i = 0;
        if (currentTimeMillis > 0) {
            i = selectionKey.selector().select(currentTimeMillis);
        } else if (currentTimeMillis == 0) {
            i = selectionKey.selector().selectNow();
        }
        if (i == 0) {
            throw new SocketTimeoutException();
        }
    }

    final void a() {
        this.b.selector().close();
        this.b.channel().close();
    }
}
