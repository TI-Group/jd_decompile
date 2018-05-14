package jd.wjlogin_sdk.common;

import jd.wjlogin_sdk.model.MessageHeader;
import jd.wjlogin_sdk.tlvtype.TLV;
import jd.wjlogin_sdk.tlvtype.tlv_0x10;
import jd.wjlogin_sdk.tlvtype.tlv_0x11;
import jd.wjlogin_sdk.tlvtype.tlv_0x15;
import jd.wjlogin_sdk.tlvtype.tlv_0x17;
import jd.wjlogin_sdk.tlvtype.tlv_0x1b;
import jd.wjlogin_sdk.tlvtype.tlv_0x1d;
import jd.wjlogin_sdk.tlvtype.tlv_0x1e;
import jd.wjlogin_sdk.tlvtype.tlv_0x22;
import jd.wjlogin_sdk.tlvtype.tlv_0x23;
import jd.wjlogin_sdk.tlvtype.tlv_0x24;
import jd.wjlogin_sdk.tlvtype.tlv_0x26;
import jd.wjlogin_sdk.tlvtype.tlv_0x3;
import jd.wjlogin_sdk.tlvtype.tlv_0x32;
import jd.wjlogin_sdk.tlvtype.tlv_0x37;
import jd.wjlogin_sdk.tlvtype.tlv_0xa;
import jd.wjlogin_sdk.tlvtype.tlv_0xe;
import jd.wjlogin_sdk.tlvtype.tlv_0xf;
import jd.wjlogin_sdk.util.Base64Util;
import jd.wjlogin_sdk.util.BufferManager;
import jd.wjlogin_sdk.util.ByteUtil;

/* compiled from: TbsSdkJava */
public class MessageDecoder {
    private BufferManager bufferManager;
    private MessageHeader messageHeader;

    public MessageDecoder(byte[] bArr) {
        this.bufferManager = new BufferManager(bArr);
        this.bufferManager.flip();
    }

    public MessageHeader getMessageHeader() {
        this.messageHeader = new MessageHeader();
        this.messageHeader.setLen(this.bufferManager.getBufferShort());
        this.messageHeader.setUid(this.bufferManager.getBufferLong());
        this.messageHeader.setPartition(this.bufferManager.getBufferInt());
        this.messageHeader.setSeq(this.bufferManager.getBufferInt());
        this.messageHeader.setClientIp(this.bufferManager.getBufferInt());
        this.messageHeader.setCmd(this.bufferManager.getBufferShort());
        this.messageHeader.setSubCmd(this.bufferManager.getBufferShort());
        this.messageHeader.setAppId(this.bufferManager.getBufferShort());
        this.messageHeader.setVersion(this.bufferManager.getBufferShort());
        this.messageHeader.setStatus(this.bufferManager.getBufferByte());
        return this.messageHeader;
    }

    public TLV getTLV() throws Exception {
        TLV tlv = new TLV();
        int limit = this.bufferManager.getLimit();
        int nowPostion = this.bufferManager.getNowPostion();
        while (nowPostion < limit) {
            switch (this.bufferManager.getBufferShort()) {
                case (short) 3:
                    this.bufferManager.getBufferShort();
                    tlv_0x3 tlv_0x3 = new tlv_0x3();
                    tlv_0x3.setwErrorVer(this.bufferManager.getBufferShort());
                    tlv_0x3.setwErrorCode(this.bufferManager.getBufferShort());
                    tlv_0x3.setStError(this.bufferManager.getBufferString());
                    tlv_0x3.setStUError(this.bufferManager.getBufferString());
                    tlv.setTlv0x3(tlv_0x3);
                    break;
                case (short) 10:
                    tlv_0xa tlv_0xa = new tlv_0xa();
                    tlv_0xa.setA2(Base64Util.encodeUrl(this.bufferManager.getBufferBytes()));
                    tlv.setTlv0xa(tlv_0xa);
                    break;
                case (short) 14:
                    this.bufferManager.getBufferShort();
                    tlv_0xe tlv_0xe = new tlv_0xe();
                    tlv_0xe.setDwChangeTime(this.bufferManager.getBufferInt());
                    tlv_0xe.setDwExpireTime(this.bufferManager.getBufferInt());
                    tlv.setTlv0xe(tlv_0xe);
                    break;
                case (short) 15:
                    this.bufferManager.getBufferShort();
                    tlv_0xf tlv_0xf = new tlv_0xf();
                    tlv_0xf.setStEncryptKey(this.bufferManager.getBufferString());
                    tlv_0xf.setsPicData(this.bufferManager.getBufferBytes());
                    tlv.setTlv0xf(tlv_0xf);
                    break;
                case (short) 16:
                    tlv_0x10 tlv_0x10 = new tlv_0x10();
                    tlv_0x10.setPin(ByteUtil.parseByte2HexStr(this.bufferManager.getBufferBytes()));
                    tlv.setTlv0x10(tlv_0x10);
                    break;
                case (short) 17:
                    tlv_0x11 tlv_0x11 = new tlv_0x11();
                    tlv_0x11.setToken(this.bufferManager.getBufferBytes());
                    tlv.setTlv0x11(tlv_0x11);
                    break;
                case (short) 21:
                    this.bufferManager.getBufferShort();
                    tlv_0x15 tlv_0x15 = new tlv_0x15();
                    tlv_0x15.setDwLimitTime(this.bufferManager.getBufferInt());
                    tlv.setTlv0x15(tlv_0x15);
                    break;
                case (short) 23:
                    tlv_0x17 tlv_0x17 = new tlv_0x17();
                    tlv_0x17.setUrl(this.bufferManager.getBufferString());
                    tlv.setTlv0x17(tlv_0x17);
                    break;
                case (short) 27:
                    this.bufferManager.getBufferShort();
                    tlv_0x1b tlv_0x1b = new tlv_0x1b();
                    tlv_0x1b.setMessagePwdExpireTime(this.bufferManager.getBufferInt());
                    tlv.setTlv0x1b(tlv_0x1b);
                    break;
                case (short) 29:
                    this.bufferManager.getBufferShort();
                    tlv_0x1d tlv_0x1d = new tlv_0x1d();
                    tlv_0x1d.setAccessToken(this.bufferManager.getBufferString());
                    tlv_0x1d.setExpireTime(this.bufferManager.getBufferInt());
                    tlv_0x1d.setRefreshToken(this.bufferManager.getBufferString());
                    tlv_0x1d.setOpenid(this.bufferManager.getBufferString());
                    tlv_0x1d.setScope(this.bufferManager.getBufferString());
                    tlv_0x1d.setType(this.bufferManager.getBufferByte());
                    tlv.setTlv0x1d(tlv_0x1d);
                    break;
                case (short) 30:
                    tlv_0x1e tlv_0x1e = new tlv_0x1e();
                    tlv_0x1e.setUrl(this.bufferManager.getBufferString());
                    tlv.setTlv0x1e(tlv_0x1e);
                    break;
                case (short) 34:
                    this.bufferManager.getBufferShort();
                    tlv_0x22 tlv_0x22 = new tlv_0x22();
                    tlv_0x22.setType(this.bufferManager.getBufferByte());
                    tlv_0x22.setSize(this.bufferManager.getBufferInt());
                    tlv.setTlv0x22(tlv_0x22);
                    break;
                case (short) 35:
                    tlv_0x23 tlv_0x23 = new tlv_0x23();
                    tlv_0x23.setQRCodeData(this.bufferManager.getBufferBytes());
                    tlv.setTlv0x23(tlv_0x23);
                    break;
                case (short) 36:
                    tlv_0x24 tlv_0x24 = new tlv_0x24();
                    tlv_0x24.setQRCodeKey(this.bufferManager.getBufferString());
                    tlv.setTlv0x24(tlv_0x24);
                    break;
                case (short) 38:
                    tlv_0x26 tlv_0x26 = new tlv_0x26();
                    tlv_0x26.setTips(this.bufferManager.getBufferString());
                    tlv.setTlv0x26(tlv_0x26);
                    break;
                case (short) 50:
                    tlv_0x32 tlv_0x32 = new tlv_0x32();
                    tlv_0x32.setButtonTips(this.bufferManager.getBufferString());
                    tlv.setTlv0x32(tlv_0x32);
                    break;
                case (short) 55:
                    tlv_0x37 tlv_0x37 = new tlv_0x37();
                    tlv_0x37.setSoftFingerprint(this.bufferManager.getBufferString());
                    tlv.setTlv0x37(tlv_0x37);
                    break;
                default:
                    this.bufferManager.getBufferBytes(this.bufferManager.getBufferShort());
                    break;
            }
            nowPostion = this.bufferManager.getNowPostion();
        }
        return tlv;
    }
}
