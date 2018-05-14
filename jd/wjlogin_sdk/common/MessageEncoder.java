package jd.wjlogin_sdk.common;

import jd.wjlogin_sdk.model.MessageHeader;
import jd.wjlogin_sdk.util.BufferManager;

/* compiled from: TbsSdkJava */
public class MessageEncoder {
    private BufferManager bufferManager = new BufferManager();
    private MessageHeader messageHeader;

    public byte[] getBufferArray() {
        return this.bufferManager.getBufferArray();
    }

    public MessageHeader getMessageHeader() {
        return this.messageHeader;
    }

    public void setMessageHeader(MessageHeader messageHeader) {
        this.messageHeader = messageHeader;
        this.bufferManager.AddBuffer(messageHeader.getLen());
        this.bufferManager.AddBuffer(messageHeader.getUid());
        this.bufferManager.AddBuffer(messageHeader.getPartition());
        this.bufferManager.AddBuffer(messageHeader.getSeq());
        this.bufferManager.AddBuffer(messageHeader.getClientIp());
        this.bufferManager.AddBuffer(messageHeader.getCmd());
        this.bufferManager.AddBuffer(messageHeader.getSubCmd());
        this.bufferManager.AddBuffer(messageHeader.getAppId());
        this.bufferManager.AddBuffer(messageHeader.getVersion());
        this.bufferManager.AddBuffer(messageHeader.getStatus());
    }

    public MessageEncoder(MessageHeader messageHeader) {
        this.bufferManager.AddBuffer(messageHeader.getLen());
        this.bufferManager.AddBuffer(messageHeader.getUid());
        this.bufferManager.AddBuffer(messageHeader.getPartition());
        this.bufferManager.AddBuffer(messageHeader.getSeq());
        this.bufferManager.AddBuffer(messageHeader.getClientIp());
        this.bufferManager.AddBuffer(messageHeader.getCmd());
        this.bufferManager.AddBuffer(messageHeader.getSubCmd());
        this.bufferManager.AddBuffer(messageHeader.getAppId());
        this.bufferManager.AddBuffer(messageHeader.getVersion());
        this.bufferManager.AddBuffer(messageHeader.getStatus());
    }

    public void AddValueItem(String str) {
        this.bufferManager.AddBuffer(str);
    }

    public short GetBytesLen(String str) {
        return this.bufferManager.getBytesLen(str);
    }

    public void AddKL(short s) {
        this.bufferManager.AddBuffer(s);
    }

    public void AddKL(short s, short s2) {
        this.bufferManager.AddBuffer(s);
        this.bufferManager.AddBuffer(s2);
    }

    public void AddValue(String str) {
        this.bufferManager.AddBuffer(str);
    }

    public void AddBufferNoLen(String str) {
        this.bufferManager.AddBufferNoLen(str);
    }

    public void AddValue(byte b) {
        this.bufferManager.AddBuffer(b);
    }

    public void AddValue(short s) {
        this.bufferManager.AddBuffer(s);
    }

    public void AddValue(int i) {
        this.bufferManager.AddBuffer(i);
    }

    public void AddValue(long j) {
        this.bufferManager.AddBuffer(j);
    }

    public void AddValue(byte[] bArr) {
        this.bufferManager.AddBuffer(bArr);
    }
}
