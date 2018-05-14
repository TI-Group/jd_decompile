package jd.wjlogin_sdk.model;

import jd.wjlogin_sdk.tlvtype.TLV;

/* compiled from: TbsSdkJava */
public class Message {
    private MessageHeader Header;
    private TLV Tlv;

    public MessageHeader getHeader() {
        return this.Header;
    }

    public void setHeader(MessageHeader messageHeader) {
        this.Header = messageHeader;
    }

    public TLV getTlv() {
        return this.Tlv;
    }

    public void setTlv(TLV tlv) {
        this.Tlv = tlv;
    }
}
