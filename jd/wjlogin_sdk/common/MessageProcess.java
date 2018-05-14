package jd.wjlogin_sdk.common;

import jd.wjlogin_sdk.model.ClientInfo;
import jd.wjlogin_sdk.model.MessageHeader;
import jd.wjlogin_sdk.model.QQTokenInfo;
import jd.wjlogin_sdk.model.WXTokenInfo;
import jd.wjlogin_sdk.tlvtype.tlv_0x37;
import jd.wjlogin_sdk.tlvtype.tlv_0x4;
import jd.wjlogin_sdk.util.Base64Util;
import jd.wjlogin_sdk.util.Config;

/* compiled from: TbsSdkJava */
public class MessageProcess {
    public static MessageHeader getMessageHeader(short s, short s2, ClientInfo clientInfo, int i) {
        MessageHeader messageHeader = new MessageHeader();
        messageHeader.setLen((short) 0);
        messageHeader.setUid(1);
        messageHeader.setPartition(1);
        messageHeader.setSeq(i);
        messageHeader.setClientIp(0);
        messageHeader.setCmd(s);
        messageHeader.setSubCmd(s2);
        messageHeader.setAppId(clientInfo.getDwAppID());
        messageHeader.setVersion(Config.HEADER_VERSION);
        messageHeader.setStatus((byte) 0);
        return messageHeader;
    }

    public static void putTlv0x22(MessageEncoder messageEncoder, byte b, int i) {
        messageEncoder.AddKL((short) 34, (short) 5);
        messageEncoder.AddValue(b);
        messageEncoder.AddValue(i);
    }

    public static void putTlv0x24(MessageEncoder messageEncoder, String str) {
        messageEncoder.AddKL((short) 36, messageEncoder.GetBytesLen(str));
        messageEncoder.AddBufferNoLen(str);
    }

    public static void putTlv0x2(MessageEncoder messageEncoder, String str, String str2) {
        messageEncoder.AddKL((short) 2, (short) (((short) (4 + messageEncoder.GetBytesLen(str))) + messageEncoder.GetBytesLen(str2)));
        messageEncoder.AddValue(str);
        messageEncoder.AddValue(str2);
    }

    public static void putTlv0x4(MessageEncoder messageEncoder, tlv_0x4 tlv_0x4) {
        messageEncoder.AddKL((short) 4, (short) 52);
        messageEncoder.AddBufferNoLen(tlv_0x4.getStrHexVer());
        messageEncoder.AddBufferNoLen(tlv_0x4.getstrHexGuid());
    }

    public static void putTlv0x8(MessageEncoder messageEncoder, ClientInfo clientInfo, String str) {
        messageEncoder.AddKL((short) 8, (short) (((short) (((short) (((short) (((short) (((short) (((short) (((short) (((short) (26 + messageEncoder.GetBytesLen(clientInfo.getClientType()))) + messageEncoder.GetBytesLen(clientInfo.getAppName()))) + messageEncoder.GetBytesLen(clientInfo.getArea()))) + messageEncoder.GetBytesLen(clientInfo.getDwAppClientVer()))) + messageEncoder.GetBytesLen(str))) + messageEncoder.GetBytesLen(clientInfo.getOsVer()))) + messageEncoder.GetBytesLen(clientInfo.getScreen()))) + messageEncoder.GetBytesLen(clientInfo.getUuid()))) + messageEncoder.GetBytesLen(Config.SDK_VER_NAME)));
        messageEncoder.AddValue((short) 2);
        messageEncoder.AddValue(clientInfo.getDwAppID());
        messageEncoder.AddValue(clientInfo.getClientType());
        messageEncoder.AddValue(clientInfo.getOsVer());
        messageEncoder.AddValue(clientInfo.getDwAppClientVer());
        messageEncoder.AddValue(clientInfo.getScreen());
        messageEncoder.AddValue(clientInfo.getAppName());
        messageEncoder.AddValue(str);
        messageEncoder.AddValue(clientInfo.getArea());
        messageEncoder.AddValue(clientInfo.getUuid());
        messageEncoder.AddValue(clientInfo.getDwGetSig());
        messageEncoder.AddValue(Config.SDK_VER_NAME);
    }

    public static void putTlv0x10(MessageEncoder messageEncoder, String str) {
        if (str == null || str.length() == 0) {
            messageEncoder.AddKL((short) 16, (short) 0);
            return;
        }
        messageEncoder.AddKL((short) 16);
        messageEncoder.AddValue(str);
    }

    public static void putTlv0x13(MessageEncoder messageEncoder, int i, byte b) {
        messageEncoder.AddKL((short) 19, (short) 5);
        messageEncoder.AddValue(i);
        messageEncoder.AddValue(b);
    }

    public static void putTlv0x14(MessageEncoder messageEncoder, byte b) {
        messageEncoder.AddKL((short) 20, (short) 1);
        messageEncoder.AddValue(b);
    }

    public static void putTlv0xa(MessageEncoder messageEncoder, String str) throws Exception {
        byte[] decodeUrl = Base64Util.decodeUrl(str);
        messageEncoder.AddKL((short) 10);
        messageEncoder.AddValue(decodeUrl);
    }

    public static void putTlv0x12(MessageEncoder messageEncoder, String str, String str2) {
        messageEncoder.AddKL((short) 18, (short) (((short) (4 + messageEncoder.GetBytesLen(str))) + messageEncoder.GetBytesLen(str2)));
        messageEncoder.AddValue(str);
        messageEncoder.AddValue(str2);
    }

    public static void putTlv0x17(MessageEncoder messageEncoder, String str) {
        messageEncoder.AddKL((short) 23);
        messageEncoder.AddValue(str);
    }

    public static void putTlv0x18(MessageEncoder messageEncoder, String str) {
        if (str == null || str.length() == 0) {
            messageEncoder.AddKL((short) 24, (short) 0);
            return;
        }
        messageEncoder.AddKL((short) 24);
        messageEncoder.AddValue(str);
    }

    public static void putTlv0x19(MessageEncoder messageEncoder, String str) {
        messageEncoder.AddKL((short) 25);
        messageEncoder.AddValue(str);
    }

    public static void putTlv0x1a(MessageEncoder messageEncoder, String str) {
        messageEncoder.AddKL((short) 26);
        messageEncoder.AddValue(str);
    }

    public static void putTlv0x1c(MessageEncoder messageEncoder, WXTokenInfo wXTokenInfo) {
        messageEncoder.AddKL((short) 28);
        messageEncoder.AddValue(wXTokenInfo.getCode());
    }

    public static void putTlv0x20(MessageEncoder messageEncoder, QQTokenInfo qQTokenInfo) {
        messageEncoder.AddKL((short) 32, (short) (((short) (4 + messageEncoder.GetBytesLen(qQTokenInfo.getAccessToken()))) + messageEncoder.GetBytesLen(qQTokenInfo.getOpenid())));
        messageEncoder.AddValue(qQTokenInfo.getAccessToken());
        messageEncoder.AddValue(qQTokenInfo.getOpenid());
    }

    public static void putTlv0x11(MessageEncoder messageEncoder, String str) {
        messageEncoder.AddKL((short) 17);
        messageEncoder.AddValue(str);
    }

    public static void putTlv0x37(MessageEncoder messageEncoder, tlv_0x37 tlv_0x37) {
        if (tlv_0x37 != null) {
            messageEncoder.AddKL((short) 55);
            messageEncoder.AddValue(tlv_0x37.getSoftFingerprint());
        }
    }

    public static void putTlv0x48(MessageEncoder messageEncoder, ClientInfo clientInfo) {
        messageEncoder.AddKL((short) 72, (short) (((short) (((short) (((short) (8 + messageEncoder.GetBytesLen(clientInfo.getDeviceName()))) + messageEncoder.GetBytesLen(clientInfo.getDeviceBrand()))) + messageEncoder.GetBytesLen(clientInfo.getDeviceModel()))) + messageEncoder.GetBytesLen(clientInfo.getReserve())));
        messageEncoder.AddValue(clientInfo.getDeviceName());
        messageEncoder.AddValue(clientInfo.getDeviceBrand());
        messageEncoder.AddValue(clientInfo.getDeviceModel());
        messageEncoder.AddValue(clientInfo.getReserve());
    }
}
