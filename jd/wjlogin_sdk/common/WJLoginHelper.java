package jd.wjlogin_sdk.common;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.util.Log;
import java.nio.ByteBuffer;
import java.util.Date;
import jd.wjlogin_sdk.common.listener.CheckImageCodeAndPhoneNumCallBack;
import jd.wjlogin_sdk.common.listener.OnCommonCallback;
import jd.wjlogin_sdk.common.listener.OnConfirmQRCodeScannedCallback;
import jd.wjlogin_sdk.common.listener.OnGetMessageCodeCallback;
import jd.wjlogin_sdk.common.listener.OnGetMessagePwdExpireTimeCallback;
import jd.wjlogin_sdk.common.listener.OnLoginCallback;
import jd.wjlogin_sdk.common.listener.OnNeedImageCodeCallBack;
import jd.wjlogin_sdk.common.listener.OnPhoneNumLoginCallback;
import jd.wjlogin_sdk.common.listener.OnQrcodeConfirmLoginCallback;
import jd.wjlogin_sdk.common.listener.OnRefreshCheckCodeCallback;
import jd.wjlogin_sdk.common.listener.OnRegistJumpToMCallback;
import jd.wjlogin_sdk.common.listener.OnReqJumpTokenCallback;
import jd.wjlogin_sdk.common.listener.OnReqQRCodePictureCallback;
import jd.wjlogin_sdk.common.listener.OnSendMsgCodeCallback;
import jd.wjlogin_sdk.common.listener.TencentLoginCallback;
import jd.wjlogin_sdk.common.listener.WXLoginCallback;
import jd.wjlogin_sdk.model.BindResult;
import jd.wjlogin_sdk.model.ClientInfo;
import jd.wjlogin_sdk.model.FailResult;
import jd.wjlogin_sdk.model.JumpResult;
import jd.wjlogin_sdk.model.MessageHeader;
import jd.wjlogin_sdk.model.PicDataInfo;
import jd.wjlogin_sdk.model.QQTokenInfo;
import jd.wjlogin_sdk.model.QrCodeScannedResult;
import jd.wjlogin_sdk.model.WUserAccessToken;
import jd.wjlogin_sdk.model.WUserSigInfo;
import jd.wjlogin_sdk.model.WXTokenInfo;
import jd.wjlogin_sdk.tlvtype.TLV;
import jd.wjlogin_sdk.tlvtype.tlv_0x11;
import jd.wjlogin_sdk.tlvtype.tlv_0x15;
import jd.wjlogin_sdk.tlvtype.tlv_0x1b;
import jd.wjlogin_sdk.tlvtype.tlv_0x1d;
import jd.wjlogin_sdk.tlvtype.tlv_0x1e;
import jd.wjlogin_sdk.tlvtype.tlv_0x22;
import jd.wjlogin_sdk.tlvtype.tlv_0x26;
import jd.wjlogin_sdk.tlvtype.tlv_0x3;
import jd.wjlogin_sdk.tlvtype.tlv_0x37;
import jd.wjlogin_sdk.tlvtype.tlv_0x4;
import jd.wjlogin_sdk.tlvtype.tlv_0xa;
import jd.wjlogin_sdk.tlvtype.tlv_0xe;
import jd.wjlogin_sdk.tlvtype.tlv_0xf;
import jd.wjlogin_sdk.util.AES128;
import jd.wjlogin_sdk.util.Base64Util;
import jd.wjlogin_sdk.util.BufferManager;
import jd.wjlogin_sdk.util.ByteUtil;
import jd.wjlogin_sdk.util.Config;
import jd.wjlogin_sdk.util.ConvertUtil;
import jd.wjlogin_sdk.util.GuidUtil;
import jd.wjlogin_sdk.util.HttpConfig;
import jd.wjlogin_sdk.util.LocalFileUtil;
import jd.wjlogin_sdk.util.NetworkManager;
import jd.wjlogin_sdk.util.RandomKeyDecryptor;
import jd.wjlogin_sdk.util.ReplyCode;
import jd.wjlogin_sdk.util.ajax.Ajax;
import jd.wjlogin_sdk.util.ajax.AjaxUtil;
import jd.wjlogin_sdk.util.ajax.OnErrorListener;
import jd.wjlogin_sdk.util.ajax.OnSuccessListener;

/* compiled from: TbsSdkJava */
public class WJLoginHelper {
    private static tlv_0x4 guid = null;
    private static Object lock = new Object();
    private static WUserSigInfo mUserInfo = null;
    private static WUserAccessToken wUserAccessToken = null;
    private boolean bLocked;
    private ClientInfo clientInfo;
    private boolean isDevelop;
    private Context mContext;
    private tlv_0x37 mSoftFingerprint;
    private MessageEncoder messageEncoder;
    private int seq;
    private long startTime;

    public WJLoginHelper(Context context, ClientInfo clientInfo) {
        this.mSoftFingerprint = null;
        this.messageEncoder = null;
        this.seq = 0;
        this.mContext = null;
        this.clientInfo = null;
        this.startTime = 0;
        this.bLocked = false;
        this.isDevelop = true;
        this.seq = 0;
        this.mContext = context;
        this.clientInfo = clientInfo;
        LocalFileUtil.initLocalFileUtil(this.mContext);
        getUserInfo(false);
        getSoftFingerprintTlv();
    }

    public void SetDevleop(boolean z) {
        this.isDevelop = z;
    }

    public void JDLoginWithPassword(final String str, String str2, PicDataInfo picDataInfo, Boolean bool, final OnLoginCallback onLoginCallback) {
        try {
            if (checkLocked()) {
                this.seq++;
                this.messageEncoder = new MessageEncoder();
                this.messageEncoder.setMessageHeader(MessageProcess.getMessageHeader((short) 2, (short) 6, this.clientInfo, this.seq));
                MessageProcess.putTlv0x2(this.messageEncoder, str, str2);
                MessageProcess.putTlv0x4(this.messageEncoder, getGuid());
                MessageProcess.putTlv0x8(this.messageEncoder, this.clientInfo, NetworkManager.getAPNTypeString(this.mContext));
                MessageProcess.putTlv0x37(this.messageEncoder, this.mSoftFingerprint);
                MessageProcess.putTlv0x48(this.messageEncoder, this.clientInfo);
                if (picDataInfo != null) {
                    MessageProcess.putTlv0x12(this.messageEncoder, picDataInfo.getStEncryptKey(), picDataInfo.getAuthCode());
                }
                final String randomKey = RandomKeyDecryptor.getRandomKey();
                String encode = RandomKeyDecryptor.encode(this.messageEncoder.getBufferArray(), randomKey);
                this.startTime = System.currentTimeMillis();
                Ajax ajax = new Ajax(1, AjaxUtil.getUrl(HttpConfig.LOGIN_METHOD, this.isDevelop), this.mContext);
                ajax.setRetryTimes(2);
                ajax.setRetryWithHttp(true);
                ajax.setParams(encode);
                ajax.send();
                final String str3 = str;
                final String str4 = str2;
                final Boolean bool2 = bool;
                final OnLoginCallback onLoginCallback2 = onLoginCallback;
                ajax.setOnSuccessListener(new OnSuccessListener() {
                    public void onSuccess(String str) {
                        WJLoginHelper.this.bLocked = false;
                        WJLoginHelper.this.LoginSuccess(str, str3, str4, bool2, randomKey, onLoginCallback2);
                    }
                });
                ajax.setOnErrorListener(new OnErrorListener() {
                    public void onError(String str) {
                        WJLoginHelper.this.bLocked = false;
                        if (onLoginCallback != null) {
                            onLoginCallback.onError(str);
                        }
                        WJLoginHelper.this.reportLoginResult(str, (byte) -1, (short) 2, (short) 6);
                    }
                });
            } else if (onLoginCallback != null) {
                onLoginCallback.onError(Config.makeErrMsg(Config.ERR_CODE_SDK_BLOCKED, Config.ERR_MSG_SDK_BLOCKED));
            }
        } catch (Exception e) {
            this.bLocked = false;
            e.printStackTrace();
            if (onLoginCallback != null) {
                onLoginCallback.onError(Config.makeErrMsg(Config.ERR_CODE_RESPONSE_DATA_ERR, Config.ERR_MSG_RESPONSE_DATA_ERR));
            }
        }
    }

    @SuppressLint({"NewApi"})
    private void LoginSuccess(String str, String str2, String str3, Boolean bool, String str4, OnLoginCallback onLoginCallback) {
        try {
            MessageDecoder messageDecoder = new MessageDecoder(RandomKeyDecryptor.decode(str, str4));
            MessageHeader messageHeader = messageDecoder.getMessageHeader();
            TLV tlv = messageDecoder.getTLV();
            byte status = messageHeader.getStatus();
            if (checkSeq(messageHeader.getSeq())) {
                saveSoftfingerprint(tlv.getTlv0x37());
                if (status == (byte) 0) {
                    SaveUserInfo(tlv, str2, str3, bool);
                    if (TextUtils.isEmpty(getA2()) || TextUtils.isEmpty(getPin())) {
                        if (onLoginCallback != null) {
                            onLoginCallback.onError(Config.makeErrMsg(Config.ERR_CODE_RESPONSE_DATA_ERR, Config.ERR_MSG_RESPONSE_DATA_ERR));
                        }
                        reportLoginResult((byte) -2, (short) 2, (short) 6);
                        return;
                    }
                    if (onLoginCallback != null) {
                        onLoginCallback.onSuccess();
                    }
                    reportLoginResult(str2, status, (short) 2, (short) 6);
                    return;
                }
                FailResult failResult;
                tlv_0x3 tlv0x3 = tlv.getTlv0x3();
                tlv_0x15 tlv0x15 = tlv.getTlv0x15();
                tlv_0xf tlv0xf = tlv.getTlv0xf();
                tlv_0x11 tlv0x11 = tlv.getTlv0x11();
                tlv_0x1e tlv0x1e = tlv.getTlv0x1e();
                PicDataInfo picDataInfo = null;
                if (tlv0x3 != null) {
                    failResult = getFailResult(status, tlv0x3);
                } else {
                    failResult = getDefualFailResult(status);
                }
                if (tlv0x15 != null) {
                    failResult.setDwLimitTime(tlv0x15.getDwLimitTime());
                }
                if (tlv0xf != null) {
                    picDataInfo = getPicData(tlv0xf);
                }
                JumpResult jumpResult;
                if (status >= Byte.MIN_VALUE && status <= (byte) -113) {
                    jumpResult = getJumpResult(tlv0x11, tlv0x1e);
                    if (onLoginCallback != null) {
                        onLoginCallback.onFail(failResult, jumpResult, picDataInfo);
                    }
                } else if (status == ReplyCode.reply0x67) {
                    jumpResult = getJumpResult(null, tlv0x1e);
                    if (onLoginCallback != null) {
                        onLoginCallback.onFail(failResult, jumpResult, picDataInfo);
                    }
                } else if (status == ReplyCode.reply0x6a) {
                    if (onLoginCallback != null) {
                        onLoginCallback.onFail(failResult, getJumpResult(null, null), picDataInfo);
                    }
                } else if (status >= ReplyCode.reply0x77 && status <= ReplyCode.reply0x7a) {
                    jumpResult = getJumpResult(null, tlv0x1e);
                    if (onLoginCallback != null) {
                        onLoginCallback.onFail(failResult, jumpResult, picDataInfo);
                    }
                } else if (status < ReplyCode.reply0x7b || status > ReplyCode.reply0x7e) {
                    if (onLoginCallback != null) {
                        onLoginCallback.onFail(failResult, picDataInfo);
                    }
                } else if (onLoginCallback != null) {
                    onLoginCallback.onFail(failResult, getJumpResult(null, null), picDataInfo);
                }
                reportLoginResult(str2, status, (short) 2, (short) 6);
                return;
            }
            if (onLoginCallback != null) {
                onLoginCallback.onFail(getDefualFailResult(), null);
            }
            reportLoginResult(str2, (byte) -1, (short) 2, (short) 6);
        } catch (Exception e) {
            e.printStackTrace();
            if (onLoginCallback != null) {
                onLoginCallback.onFail(getDefualFailResult(), null);
            }
            reportLoginResult(str2, (byte) -2, (short) 2, (short) 6);
        }
    }

    private void reportLoginResult(byte b, short s, short s2) {
        try {
            int currentTimeMillis = (int) (System.currentTimeMillis() - this.startTime);
            this.messageEncoder = new MessageEncoder();
            this.messageEncoder.setMessageHeader(MessageProcess.getMessageHeader(s, s2, this.clientInfo, this.seq));
            MessageProcess.putTlv0x4(this.messageEncoder, getGuid());
            MessageProcess.putTlv0x8(this.messageEncoder, this.clientInfo, NetworkManager.getAPNTypeString(this.mContext));
            MessageProcess.putTlv0x10(this.messageEncoder, getPin() == null ? "" : getPin());
            MessageProcess.putTlv0x13(this.messageEncoder, currentTimeMillis, b);
            String pin = getUserAccount() == null ? getPin() == null ? "" : getPin() : getUserAccount();
            MessageProcess.putTlv0x18(this.messageEncoder, pin);
            Ajax ajax = new Ajax(1, AjaxUtil.getReportUrl(HttpConfig.LOGIN_REPORT_METHOD, this.isDevelop), this.mContext);
            ajax.setParams(Base64Util.encode(this.messageEncoder.getBufferArray()));
            ajax.send();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void reportLoginResult(String str, byte b, short s, short s2) {
        try {
            int currentTimeMillis = (int) (System.currentTimeMillis() - this.startTime);
            this.messageEncoder = new MessageEncoder();
            this.messageEncoder.setMessageHeader(MessageProcess.getMessageHeader(s, s2, this.clientInfo, this.seq));
            MessageProcess.putTlv0x4(this.messageEncoder, getGuid());
            MessageProcess.putTlv0x8(this.messageEncoder, this.clientInfo, NetworkManager.getAPNTypeString(this.mContext));
            MessageProcess.putTlv0x10(this.messageEncoder, getPin() == null ? "" : getPin());
            MessageProcess.putTlv0x13(this.messageEncoder, currentTimeMillis, b);
            if (str == null) {
                str = "";
            }
            MessageProcess.putTlv0x18(this.messageEncoder, str);
            Ajax ajax = new Ajax(1, AjaxUtil.getReportUrl(HttpConfig.LOGIN_REPORT_METHOD, this.isDevelop), this.mContext);
            ajax.setParams(Base64Util.encode(this.messageEncoder.getBufferArray()));
            ajax.send();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void refreshImageCode(PicDataInfo picDataInfo, final OnRefreshCheckCodeCallback onRefreshCheckCodeCallback) {
        try {
            if (checkLocked()) {
                this.seq++;
                this.messageEncoder = new MessageEncoder();
                this.messageEncoder.setMessageHeader(MessageProcess.getMessageHeader((short) 2, (short) 7, this.clientInfo, this.seq));
                MessageProcess.putTlv0x8(this.messageEncoder, this.clientInfo, NetworkManager.getAPNTypeString(this.mContext));
                MessageProcess.putTlv0x12(this.messageEncoder, picDataInfo.getStEncryptKey(), picDataInfo.getAuthCode());
                final String randomKey = RandomKeyDecryptor.getRandomKey();
                String encode = RandomKeyDecryptor.encode(this.messageEncoder.getBufferArray(), randomKey);
                this.startTime = System.currentTimeMillis();
                Ajax ajax = new Ajax(1, AjaxUtil.getUrl(HttpConfig.LOGIN_METHOD, this.isDevelop), this.mContext);
                ajax.setRetryTimes(2);
                ajax.setRetryWithHttp(true);
                ajax.setParams(encode);
                ajax.send();
                ajax.setOnSuccessListener(new OnSuccessListener() {
                    public void onSuccess(String str) {
                        WJLoginHelper.this.bLocked = false;
                        WJLoginHelper.this.refreshImageCodeSucess(str, randomKey, onRefreshCheckCodeCallback);
                    }
                });
                ajax.setOnErrorListener(new OnErrorListener() {
                    public void onError(String str) {
                        WJLoginHelper.this.bLocked = false;
                        if (onRefreshCheckCodeCallback != null) {
                            onRefreshCheckCodeCallback.onError(str);
                        }
                        WJLoginHelper.this.reportLoginResult((byte) -1, (short) 2, (short) 7);
                    }
                });
            } else if (onRefreshCheckCodeCallback != null) {
                onRefreshCheckCodeCallback.onError(Config.makeErrMsg(Config.ERR_CODE_SDK_BLOCKED, Config.ERR_MSG_SDK_BLOCKED));
            }
        } catch (Exception e) {
            this.bLocked = false;
            e.printStackTrace();
            if (onRefreshCheckCodeCallback != null) {
                onRefreshCheckCodeCallback.onError(Config.makeErrMsg(Config.ERR_CODE_RESPONSE_DATA_ERR, Config.ERR_MSG_RESPONSE_DATA_ERR));
            }
        }
    }

    private void refreshImageCodeSucess(String str, String str2, OnRefreshCheckCodeCallback onRefreshCheckCodeCallback) {
        try {
            MessageDecoder messageDecoder = new MessageDecoder(RandomKeyDecryptor.decode(str, str2));
            MessageHeader messageHeader = messageDecoder.getMessageHeader();
            byte status = messageHeader.getStatus();
            TLV tlv = messageDecoder.getTLV();
            if (!checkSeq(messageHeader.getSeq())) {
                if (onRefreshCheckCodeCallback != null) {
                    onRefreshCheckCodeCallback.onFail(getDefualFailResult());
                }
                reportLoginResult((byte) -1, (short) 2, (short) 7);
            } else if (status == (byte) 0) {
                tlv_0xf tlv0xf = tlv.getTlv0xf();
                if (tlv0xf != null) {
                    if (onRefreshCheckCodeCallback != null) {
                        onRefreshCheckCodeCallback.onSuccess(getPicData(tlv0xf));
                    }
                } else if (onRefreshCheckCodeCallback != null) {
                    onRefreshCheckCodeCallback.onFail(getDefualFailResult());
                }
                reportLoginResult(status, (short) 2, (short) 7);
            } else {
                FailResult failResult;
                tlv_0x3 tlv0x3 = tlv.getTlv0x3();
                if (tlv0x3 != null) {
                    failResult = getFailResult(status, tlv0x3);
                } else {
                    failResult = getDefualFailResult(status);
                }
                if (onRefreshCheckCodeCallback != null) {
                    onRefreshCheckCodeCallback.onFail(failResult);
                }
                reportLoginResult(status, (short) 2, (short) 7);
            }
        } catch (Exception e) {
            e.printStackTrace();
            if (onRefreshCheckCodeCallback != null) {
                onRefreshCheckCodeCallback.onFail(getDefualFailResult());
            }
            reportLoginResult((byte) -2, (short) 2, (short) 7);
        }
    }

    public void refreshA2(final OnCommonCallback onCommonCallback) {
        try {
            if (checkLocked()) {
                this.seq++;
                this.messageEncoder = new MessageEncoder();
                this.messageEncoder.setMessageHeader(MessageProcess.getMessageHeader((short) 3, (short) 2, this.clientInfo, this.seq));
                MessageProcess.putTlv0x8(this.messageEncoder, this.clientInfo, NetworkManager.getAPNTypeString(this.mContext));
                MessageProcess.putTlv0xa(this.messageEncoder, getA2());
                MessageProcess.putTlv0x10(this.messageEncoder, getPin());
                this.startTime = System.currentTimeMillis();
                Ajax ajax = new Ajax(1, AjaxUtil.getUrl(HttpConfig.LOGIN_METHOD, this.isDevelop), this.mContext);
                final String randomKey = RandomKeyDecryptor.getRandomKey();
                String encode = RandomKeyDecryptor.encode(this.messageEncoder.getBufferArray(), randomKey);
                ajax.setRetryTimes(2);
                ajax.setRetryWithHttp(true);
                ajax.setParams(encode);
                ajax.send();
                ajax.setOnSuccessListener(new OnSuccessListener() {
                    public void onSuccess(String str) {
                        WJLoginHelper.this.bLocked = false;
                        WJLoginHelper.this.refreshA2Success(str, randomKey, onCommonCallback);
                    }
                });
                ajax.setOnErrorListener(new OnErrorListener() {
                    public void onError(String str) {
                        WJLoginHelper.this.bLocked = false;
                        if (onCommonCallback != null) {
                            onCommonCallback.onError(str);
                        }
                        WJLoginHelper.this.reportLoginResult((byte) -1, (short) 3, (short) 2);
                    }
                });
            } else if (onCommonCallback != null) {
                onCommonCallback.onError(Config.makeErrMsg(Config.ERR_CODE_SDK_BLOCKED, Config.ERR_MSG_SDK_BLOCKED));
            }
        } catch (Exception e) {
            this.bLocked = false;
            e.printStackTrace();
            if (onCommonCallback != null) {
                onCommonCallback.onError(Config.makeErrMsg(Config.ERR_CODE_RESPONSE_DATA_ERR, Config.ERR_MSG_RESPONSE_DATA_ERR));
            }
        }
    }

    private void refreshA2Success(String str, String str2, OnCommonCallback onCommonCallback) {
        try {
            MessageDecoder messageDecoder = new MessageDecoder(RandomKeyDecryptor.decode(str, str2));
            MessageHeader messageHeader = messageDecoder.getMessageHeader();
            byte status = messageHeader.getStatus();
            TLV tlv = messageDecoder.getTLV();
            if (!checkSeq(messageHeader.getSeq())) {
                if (onCommonCallback != null) {
                    onCommonCallback.onFail(getDefualFailResult());
                }
                reportLoginResult((byte) -1, (short) 3, (short) 2);
            } else if (status == (byte) 0) {
                tlv_0xa tlv0xa = tlv.getTlv0xa();
                tlv_0xe tlv0xe = tlv.getTlv0xe();
                if (tlv0xa != null && tlv0xe != null) {
                    SaveA2(tlv0xa, tlv0xe);
                    if (onCommonCallback != null) {
                        onCommonCallback.onSuccess();
                    }
                } else if (onCommonCallback != null) {
                    onCommonCallback.onError(Config.makeErrMsg(Config.ERR_CODE_RESPONSE_DATA_ERR, Config.ERR_MSG_RESPONSE_DATA_ERR));
                }
                reportLoginResult(status, (short) 3, (short) 2);
            } else {
                FailResult failResult;
                tlv_0x3 tlv0x3 = tlv.getTlv0x3();
                if (tlv0x3 != null) {
                    failResult = getFailResult(status, tlv0x3);
                } else {
                    failResult = getDefualFailResult(status);
                }
                if (onCommonCallback != null) {
                    onCommonCallback.onFail(failResult);
                }
                reportLoginResult(status, (short) 3, (short) 2);
            }
        } catch (Exception e) {
            e.printStackTrace();
            if (onCommonCallback != null) {
                onCommonCallback.onFail(getDefualFailResult());
            }
            reportLoginResult((byte) -2, (short) 3, (short) 2);
        }
    }

    public void CheckA2(final OnCommonCallback onCommonCallback) {
        try {
            if (checkLocked()) {
                this.seq++;
                this.messageEncoder = new MessageEncoder();
                this.messageEncoder.setMessageHeader(MessageProcess.getMessageHeader((short) 3, (short) 1, this.clientInfo, this.seq));
                MessageProcess.putTlv0x8(this.messageEncoder, this.clientInfo, NetworkManager.getAPNTypeString(this.mContext));
                MessageProcess.putTlv0xa(this.messageEncoder, getA2());
                MessageProcess.putTlv0x10(this.messageEncoder, getPin());
                this.startTime = System.currentTimeMillis();
                Ajax ajax = new Ajax(1, AjaxUtil.getUrl(HttpConfig.LOGIN_METHOD, this.isDevelop), this.mContext);
                final String randomKey = RandomKeyDecryptor.getRandomKey();
                String encode = RandomKeyDecryptor.encode(this.messageEncoder.getBufferArray(), randomKey);
                ajax.setRetryTimes(2);
                ajax.setRetryWithHttp(true);
                ajax.setParams(encode);
                ajax.send();
                ajax.setOnSuccessListener(new OnSuccessListener() {
                    public void onSuccess(String str) {
                        WJLoginHelper.this.bLocked = false;
                        WJLoginHelper.this.checkA2Success(str, randomKey, onCommonCallback);
                    }
                });
                ajax.setOnErrorListener(new OnErrorListener() {
                    public void onError(String str) {
                        WJLoginHelper.this.bLocked = false;
                        if (onCommonCallback != null) {
                            onCommonCallback.onError(str);
                        }
                        WJLoginHelper.this.reportLoginResult((byte) -1, (short) 3, (short) 1);
                    }
                });
            } else if (onCommonCallback != null) {
                onCommonCallback.onError(Config.makeErrMsg(Config.ERR_CODE_SDK_BLOCKED, Config.ERR_MSG_SDK_BLOCKED));
            }
        } catch (Exception e) {
            this.bLocked = false;
            e.printStackTrace();
            if (onCommonCallback != null) {
                onCommonCallback.onError(Config.makeErrMsg(Config.ERR_CODE_RESPONSE_DATA_ERR, Config.ERR_MSG_RESPONSE_DATA_ERR));
            }
        }
    }

    private void checkA2Success(String str, String str2, OnCommonCallback onCommonCallback) {
        try {
            MessageDecoder messageDecoder = new MessageDecoder(RandomKeyDecryptor.decode(str, str2));
            MessageHeader messageHeader = messageDecoder.getMessageHeader();
            byte status = messageHeader.getStatus();
            TLV tlv = messageDecoder.getTLV();
            if (!checkSeq(messageHeader.getSeq())) {
                if (onCommonCallback != null) {
                    onCommonCallback.onFail(getDefualFailResult());
                }
                reportLoginResult((byte) -1, (short) 3, (short) 1);
            } else if (status == (byte) 0) {
                if (onCommonCallback != null) {
                    onCommonCallback.onSuccess();
                }
                reportLoginResult(status, (short) 3, (short) 1);
            } else {
                FailResult failResult;
                tlv_0x3 tlv0x3 = tlv.getTlv0x3();
                if (tlv0x3 != null) {
                    failResult = getFailResult(status, tlv0x3);
                } else {
                    failResult = getDefualFailResult(status);
                }
                if (onCommonCallback != null) {
                    onCommonCallback.onFail(failResult);
                }
                reportLoginResult(status, (short) 3, (short) 1);
            }
        } catch (Exception e) {
            e.printStackTrace();
            if (onCommonCallback != null) {
                onCommonCallback.onFail(getDefualFailResult());
            }
            reportLoginResult((byte) -2, (short) 3, (short) 1);
        }
    }

    public void reqJumpToken(String str, final OnReqJumpTokenCallback onReqJumpTokenCallback) {
        try {
            if (checkLocked()) {
                this.seq++;
                this.messageEncoder = new MessageEncoder();
                this.messageEncoder.setMessageHeader(MessageProcess.getMessageHeader((short) 2, (short) 9, this.clientInfo, this.seq));
                MessageProcess.putTlv0x8(this.messageEncoder, this.clientInfo, NetworkManager.getAPNTypeString(this.mContext));
                MessageProcess.putTlv0x10(this.messageEncoder, getPin() == null ? "" : getPin());
                MessageProcess.putTlv0xa(this.messageEncoder, getA2() == null ? "" : getA2());
                MessageProcess.putTlv0x17(this.messageEncoder, str);
                this.startTime = System.currentTimeMillis();
                Ajax ajax = new Ajax(1, AjaxUtil.getUrl(HttpConfig.LOGIN_METHOD, this.isDevelop), this.mContext);
                final String randomKey = RandomKeyDecryptor.getRandomKey();
                String encode = RandomKeyDecryptor.encode(this.messageEncoder.getBufferArray(), randomKey);
                ajax.setRetryTimes(2);
                ajax.setRetryWithHttp(true);
                ajax.setUseHttp(true);
                ajax.setParams(encode);
                ajax.send();
                ajax.setOnSuccessListener(new OnSuccessListener() {
                    public void onSuccess(String str) {
                        WJLoginHelper.this.bLocked = false;
                        WJLoginHelper.this.reqJumpTokenSuccess(str, randomKey, onReqJumpTokenCallback);
                    }
                });
                ajax.setOnErrorListener(new OnErrorListener() {
                    public void onError(String str) {
                        WJLoginHelper.this.bLocked = false;
                        if (onReqJumpTokenCallback != null) {
                            onReqJumpTokenCallback.onError(str);
                        }
                        WJLoginHelper.this.reportLoginResult((byte) -1, (short) 2, (short) 9);
                    }
                });
            } else if (onReqJumpTokenCallback != null) {
                onReqJumpTokenCallback.onError(Config.makeErrMsg(Config.ERR_CODE_SDK_BLOCKED, Config.ERR_MSG_SDK_BLOCKED));
            }
        } catch (Exception e) {
            this.bLocked = false;
            e.printStackTrace();
            if (onReqJumpTokenCallback != null) {
                onReqJumpTokenCallback.onError(Config.makeErrMsg(Config.ERR_CODE_RESPONSE_DATA_ERR, Config.ERR_MSG_RESPONSE_DATA_ERR));
            }
        }
    }

    private void reqJumpTokenSuccess(String str, String str2, OnReqJumpTokenCallback onReqJumpTokenCallback) {
        try {
            MessageDecoder messageDecoder = new MessageDecoder(RandomKeyDecryptor.decode(str, str2));
            MessageHeader messageHeader = messageDecoder.getMessageHeader();
            byte status = messageHeader.getStatus();
            TLV tlv = messageDecoder.getTLV();
            String pin = getPin();
            short dwAppID = this.clientInfo.getDwAppID();
            if (!checkSeq(messageHeader.getSeq())) {
                if (onReqJumpTokenCallback != null) {
                    onReqJumpTokenCallback.onFail(getDefualFailResult());
                }
                reportLoginResult((byte) -1, (short) 2, (short) 9);
            } else if (status == (byte) 0) {
                String encodeUrl;
                tlv_0x11 tlv0x11 = tlv.getTlv0x11();
                String url = tlv.getTlv0x17().getUrl();
                byte[] bArr;
                if (pin == null || pin == String.valueOf("")) {
                    ByteBuffer allocate = ByteBuffer.allocate(256);
                    allocate.putShort((short) 0);
                    allocate.putShort(dwAppID);
                    allocate.putShort((short) tlv0x11.getToken().length);
                    allocate.put(tlv0x11.getToken());
                    allocate.flip();
                    bArr = new byte[allocate.limit()];
                    allocate.get(bArr);
                    allocate.clear();
                    encodeUrl = Base64Util.encodeUrl(bArr);
                } else {
                    ByteBuffer allocate2 = ByteBuffer.allocate(256);
                    byte[] bytes = pin.getBytes();
                    allocate2.putShort((short) bytes.length);
                    allocate2.put(bytes);
                    allocate2.putShort(dwAppID);
                    allocate2.putShort((short) tlv0x11.getToken().length);
                    allocate2.put(tlv0x11.getToken());
                    allocate2.flip();
                    bArr = new byte[allocate2.limit()];
                    allocate2.get(bArr);
                    allocate2.clear();
                    encodeUrl = Base64Util.encodeUrl(bArr);
                }
                if (onReqJumpTokenCallback != null) {
                    onReqJumpTokenCallback.onSuccess(url, encodeUrl);
                }
                reportLoginResult(status, (short) 2, (short) 9);
            } else {
                FailResult failResult;
                tlv_0x3 tlv0x3 = tlv.getTlv0x3();
                if (tlv0x3 != null) {
                    failResult = getFailResult(status, tlv0x3);
                } else {
                    failResult = getDefualFailResult(status);
                }
                if (onReqJumpTokenCallback != null) {
                    onReqJumpTokenCallback.onFail(failResult);
                }
                reportLoginResult(status, (short) 2, (short) 9);
            }
        } catch (Exception e) {
            e.printStackTrace();
            if (onReqJumpTokenCallback != null) {
                onReqJumpTokenCallback.onFail(getDefualFailResult());
            }
            reportLoginResult((byte) -2, (short) 2, (short) 9);
        }
    }

    public void getMessagePassWord(String str, final OnGetMessagePwdExpireTimeCallback onGetMessagePwdExpireTimeCallback) {
        try {
            if (checkLocked()) {
                this.seq++;
                this.messageEncoder = new MessageEncoder();
                this.messageEncoder.setMessageHeader(MessageProcess.getMessageHeader((short) 4, (short) 1, this.clientInfo, this.seq));
                MessageProcess.putTlv0x4(this.messageEncoder, getGuid());
                MessageProcess.putTlv0x8(this.messageEncoder, this.clientInfo, NetworkManager.getAPNTypeString(this.mContext));
                MessageProcess.putTlv0x19(this.messageEncoder, str);
                this.startTime = System.currentTimeMillis();
                Ajax ajax = new Ajax(1, AjaxUtil.getUrl(HttpConfig.LOGIN_METHOD, this.isDevelop), this.mContext);
                final String randomKey = RandomKeyDecryptor.getRandomKey();
                String encode = RandomKeyDecryptor.encode(this.messageEncoder.getBufferArray(), randomKey);
                ajax.setRetryTimes(2);
                ajax.setRetryWithHttp(true);
                ajax.setParams(encode);
                ajax.send();
                ajax.setOnSuccessListener(new OnSuccessListener() {
                    public void onSuccess(String str) {
                        WJLoginHelper.this.bLocked = false;
                        WJLoginHelper.this.getMessagePassWordSuccess(str, randomKey, onGetMessagePwdExpireTimeCallback);
                    }
                });
                ajax.setOnErrorListener(new OnErrorListener() {
                    public void onError(String str) {
                        WJLoginHelper.this.bLocked = false;
                        if (onGetMessagePwdExpireTimeCallback != null) {
                            onGetMessagePwdExpireTimeCallback.onError(str);
                        }
                        WJLoginHelper.this.reportLoginResult((byte) -1, (short) 4, (short) 1);
                    }
                });
            } else if (onGetMessagePwdExpireTimeCallback != null) {
                onGetMessagePwdExpireTimeCallback.onError(Config.makeErrMsg(Config.ERR_CODE_SDK_BLOCKED, Config.ERR_MSG_SDK_BLOCKED));
            }
        } catch (Exception e) {
            this.bLocked = false;
            e.printStackTrace();
            if (onGetMessagePwdExpireTimeCallback != null) {
                onGetMessagePwdExpireTimeCallback.onError(Config.makeErrMsg(Config.ERR_CODE_RESPONSE_DATA_ERR, Config.ERR_MSG_RESPONSE_DATA_ERR));
            }
        }
    }

    private void getMessagePassWordSuccess(String str, String str2, OnGetMessagePwdExpireTimeCallback onGetMessagePwdExpireTimeCallback) {
        try {
            MessageDecoder messageDecoder = new MessageDecoder(RandomKeyDecryptor.decode(str, str2));
            MessageHeader messageHeader = messageDecoder.getMessageHeader();
            byte status = messageHeader.getStatus();
            TLV tlv = messageDecoder.getTLV();
            if (!checkSeq(messageHeader.getSeq())) {
                if (onGetMessagePwdExpireTimeCallback != null) {
                    onGetMessagePwdExpireTimeCallback.onFail(getDefualFailResult());
                }
                reportLoginResult((byte) -1, (short) 4, (short) 1);
            } else if (status == (byte) 0) {
                if (onGetMessagePwdExpireTimeCallback != null) {
                    onGetMessagePwdExpireTimeCallback.onSuccess(tlv.getTlv0x1b().getMessagePwdExpireTime());
                }
                reportLoginResult(status, (short) 4, (short) 1);
            } else {
                FailResult failResult;
                tlv_0x3 tlv0x3 = tlv.getTlv0x3();
                tlv_0x15 tlv0x15 = tlv.getTlv0x15();
                if (tlv0x3 != null) {
                    failResult = getFailResult(status, tlv0x3);
                } else {
                    failResult = getDefualFailResult(status);
                }
                if (tlv0x15 != null) {
                    failResult.setDwLimitTime(tlv0x15.getDwLimitTime());
                }
                if (onGetMessagePwdExpireTimeCallback != null) {
                    onGetMessagePwdExpireTimeCallback.onFail(failResult);
                }
                reportLoginResult(status, (short) 4, (short) 1);
            }
        } catch (Exception e) {
            e.printStackTrace();
            if (onGetMessagePwdExpireTimeCallback != null) {
                onGetMessagePwdExpireTimeCallback.onFail(getDefualFailResult());
            }
            reportLoginResult((byte) -2, (short) 4, (short) 1);
        }
    }

    public void registerByPhone(String str, String str2, final OnCommonCallback onCommonCallback) {
        try {
            this.messageEncoder = new MessageEncoder();
            this.messageEncoder.setMessageHeader(MessageProcess.getMessageHeader((short) 4, (short) 2, this.clientInfo, this.seq));
            MessageProcess.putTlv0x4(this.messageEncoder, getGuid());
            MessageProcess.putTlv0x8(this.messageEncoder, this.clientInfo, NetworkManager.getAPNTypeString(this.mContext));
            MessageProcess.putTlv0x19(this.messageEncoder, str);
            MessageProcess.putTlv0x1a(this.messageEncoder, str2);
            this.startTime = System.currentTimeMillis();
            Ajax ajax = new Ajax(1, AjaxUtil.getUrl(HttpConfig.LOGIN_METHOD, this.isDevelop), this.mContext);
            final String randomKey = RandomKeyDecryptor.getRandomKey();
            String encode = RandomKeyDecryptor.encode(this.messageEncoder.getBufferArray(), randomKey);
            ajax.setRetryTimes(2);
            ajax.setRetryWithHttp(true);
            ajax.setParams(encode);
            ajax.send();
            final String str3 = str;
            final String str4 = str2;
            final OnCommonCallback onCommonCallback2 = onCommonCallback;
            ajax.setOnSuccessListener(new OnSuccessListener() {
                public void onSuccess(String str) {
                    WJLoginHelper.this.bLocked = false;
                    WJLoginHelper.this.registerByPhoneSuccess(str, str3, randomKey, str4, onCommonCallback2);
                }
            });
            ajax.setOnErrorListener(new OnErrorListener() {
                public void onError(String str) {
                    WJLoginHelper.this.bLocked = false;
                    if (onCommonCallback != null) {
                        onCommonCallback.onError(str);
                    }
                    WJLoginHelper.this.reportLoginResult((byte) -1, (short) 4, (short) 2);
                }
            });
        } catch (Exception e) {
            this.bLocked = false;
            e.printStackTrace();
            if (onCommonCallback != null) {
                onCommonCallback.onError(Config.makeErrMsg(Config.ERR_CODE_RESPONSE_DATA_ERR, Config.ERR_MSG_RESPONSE_DATA_ERR));
            }
        }
    }

    private void registerByPhoneSuccess(String str, String str2, String str3, String str4, OnCommonCallback onCommonCallback) {
        try {
            MessageDecoder messageDecoder = new MessageDecoder(RandomKeyDecryptor.decode(str, str3));
            MessageHeader messageHeader = messageDecoder.getMessageHeader();
            byte status = messageHeader.getStatus();
            TLV tlv = messageDecoder.getTLV();
            if (!checkSeq(messageHeader.getSeq())) {
                if (onCommonCallback != null) {
                    onCommonCallback.onFail(getDefualFailResult());
                }
                reportLoginResult((byte) -1, (short) 4, (short) 2);
            } else if (status == (byte) 0) {
                SaveUserInfo(tlv, str2, str4, Boolean.valueOf(true));
                if (onCommonCallback != null) {
                    onCommonCallback.onSuccess();
                }
                reportLoginResult(status, (short) 4, (short) 2);
            } else {
                FailResult failResult;
                tlv_0x3 tlv0x3 = tlv.getTlv0x3();
                if (tlv0x3 != null) {
                    failResult = getFailResult(status, tlv0x3);
                } else {
                    failResult = getDefualFailResult(status);
                }
                if (onCommonCallback != null) {
                    onCommonCallback.onFail(failResult);
                }
                reportLoginResult(status, (short) 4, (short) 2);
            }
        } catch (Exception e) {
            e.printStackTrace();
            if (onCommonCallback != null) {
                onCommonCallback.onError(Config.makeErrMsg(Config.ERR_CODE_RESPONSE_DATA_ERR, Config.ERR_MSG_RESPONSE_DATA_ERR));
            }
            reportLoginResult((byte) -2, (short) 4, (short) 2);
        }
    }

    public void reportAppStatus(byte b) {
        try {
            this.messageEncoder = new MessageEncoder();
            this.messageEncoder.setMessageHeader(MessageProcess.getMessageHeader((short) 0, (short) 0, this.clientInfo, this.seq));
            MessageProcess.putTlv0x4(this.messageEncoder, getGuid());
            MessageProcess.putTlv0x8(this.messageEncoder, this.clientInfo, NetworkManager.getAPNTypeString(this.mContext));
            MessageProcess.putTlv0x10(this.messageEncoder, getPin());
            MessageProcess.putTlv0x14(this.messageEncoder, b);
            MessageProcess.putTlv0x18(this.messageEncoder, getUserAccount() == null ? "" : getUserAccount());
            Ajax ajax = new Ajax(1, AjaxUtil.getReportUrl(HttpConfig.ONLINE_REPORT_METHOD, this.isDevelop), this.mContext);
            ajax.setParams(Base64Util.encode(this.messageEncoder.getBufferArray()));
            ajax.send();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private boolean checkLocked() {
        if (this.bLocked) {
            return false;
        }
        this.bLocked = true;
        return true;
    }

    private void saveSoftfingerprint(tlv_0x37 tlv_0x37) {
        synchronized (lock) {
            if (tlv_0x37 != null) {
                if (!TextUtils.isEmpty(tlv_0x37.getSoftFingerprint())) {
                    this.mSoftFingerprint = tlv_0x37;
                    if (this.isDevelop) {
                        Log.e("WJLoginHelper", " soft= " + this.mSoftFingerprint.getSoftFingerprint());
                    }
                    try {
                        LocalFileUtil.setObject(Config.SOFTFINGERPRINT_LOCAL, tlv_0x37);
                    } catch (Exception e) {
                    }
                }
            }
        }
    }

    private void getSoftFingerprintTlv() {
        this.mSoftFingerprint = (tlv_0x37) LocalFileUtil.getObject(Config.SOFTFINGERPRINT_LOCAL);
    }

    public String getSoftFingerprint() {
        synchronized (lock) {
            getSoftFingerprintTlv();
            if (this.mSoftFingerprint != null) {
                String softFingerprint = this.mSoftFingerprint.getSoftFingerprint();
                return softFingerprint;
            }
            return "";
        }
    }

    public void createGuid() {
        if (getGuid() == null) {
            tlv_0x4 tlv_0x4 = new tlv_0x4();
            try {
                tlv_0x4.setwGuidVer((short) 1);
                tlv_0x4.setcTerminalType((short) 1);
                tlv_0x4.setcOSVer(ConvertUtil.string_to_version(getOSVer()));
                String guidUtil = new GuidUtil(this.mContext).toString();
                tlv_0x4.setstrHexGuid(guidUtil);
                tlv_0x4.setwNextFieldLen((short) guidUtil.length());
                BufferManager bufferManager = new BufferManager();
                bufferManager.AddBuffer(tlv_0x4.getwGuidVer());
                bufferManager.AddBuffer(tlv_0x4.getcTerminalType());
                bufferManager.AddBuffer(tlv_0x4.getcOSVer());
                bufferManager.AddBuffer(tlv_0x4.getwNextFieldLen());
                tlv_0x4.setStrHexVer(ByteUtil.parseByte2HexStr(bufferManager.getBufferArray()));
                LocalFileUtil.setObject(Config.GUID_LOCALNAME, tlv_0x4);
                guid = tlv_0x4;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void getUserInfo(boolean z) {
        synchronized (lock) {
            if (mUserInfo == null || z) {
                try {
                    WUserSigInfo wUserSigInfo = (WUserSigInfo) LocalFileUtil.getObjectJsonDecrypt(Config.USERINFO_LOCALNAME, WUserSigInfo.class);
                    if (wUserSigInfo == null) {
                        wUserSigInfo = (WUserSigInfo) LocalFileUtil.getObject(Config.USERINFO_LOCALNAME);
                        if (wUserSigInfo != null) {
                            decryptUserInfo(wUserSigInfo);
                            setUserInfo(wUserSigInfo);
                        }
                    } else {
                        mUserInfo = wUserSigInfo;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return;
            }
        }
    }

    public boolean isExistsUserInfo() {
        boolean z;
        synchronized (lock) {
            z = (mUserInfo == null || mUserInfo.getPin() == null) ? false : true;
        }
        return z;
    }

    public String getUserAccount() {
        synchronized (lock) {
            if (mUserInfo != null) {
                String account = mUserInfo.getAccount();
                return account;
            }
            return null;
        }
    }

    public String getA2() {
        synchronized (lock) {
            if (mUserInfo != null) {
                String a2 = mUserInfo.getA2();
                return a2;
            }
            return "";
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String getPin() {
        /*
        r3 = this;
        r1 = lock;
        monitor-enter(r1);
        r0 = mUserInfo;	 Catch:{ all -> 0x0024 }
        if (r0 == 0) goto L_0x0020;
    L_0x0007:
        r0 = mUserInfo;	 Catch:{ all -> 0x0024 }
        r0 = r0.getPin();	 Catch:{ all -> 0x0024 }
        if (r0 == 0) goto L_0x0020;
    L_0x000f:
        r0 = new java.lang.String;	 Catch:{ all -> 0x0024 }
        r2 = mUserInfo;	 Catch:{ all -> 0x0024 }
        r2 = r2.getPin();	 Catch:{ all -> 0x0024 }
        r2 = jd.wjlogin_sdk.util.ByteUtil.parseHexStr2Byte(r2);	 Catch:{ all -> 0x0024 }
        r0.<init>(r2);	 Catch:{ all -> 0x0024 }
        monitor-exit(r1);	 Catch:{ all -> 0x0024 }
    L_0x001f:
        return r0;
    L_0x0020:
        monitor-exit(r1);	 Catch:{ all -> 0x0024 }
        r0 = "";
        goto L_0x001f;
    L_0x0024:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x0024 }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: jd.wjlogin_sdk.common.WJLoginHelper.getPin():java.lang.String");
    }

    public boolean isNeedPwdInput() {
        boolean z;
        synchronized (lock) {
            z = mUserInfo == null || mUserInfo.getPwd() == null || mUserInfo.getPwd().length() == 0;
        }
        return z;
    }

    private String getPwd() {
        synchronized (lock) {
            if (mUserInfo != null) {
                String pwd = mUserInfo.getPwd();
                return pwd;
            }
            return null;
        }
    }

    public boolean isExistsA2() {
        boolean z;
        synchronized (lock) {
            z = (mUserInfo == null || mUserInfo.getA2() == null) ? false : true;
        }
        return z;
    }

    public boolean checkA2TimeOut() {
        boolean z = true;
        synchronized (lock) {
            try {
                if (mUserInfo == null || mUserInfo.getA2() == null) {
                } else {
                    if (((int) ((new Date().getTime() - mUserInfo.getA2CreateDate().getTime()) / 1000)) < mUserInfo.getA2TimeOut()) {
                        z = false;
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return z;
    }

    public boolean checkA2IsNeedRefresh() {
        boolean z = true;
        synchronized (lock) {
            try {
                if (mUserInfo == null || mUserInfo.getA2() == null) {
                } else {
                    if (((int) ((new Date().getTime() - mUserInfo.getA2CreateDate().getTime()) / 1000)) < mUserInfo.getA2RefreshTime()) {
                        z = false;
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return z;
    }

    public void quickLogin(OnLoginCallback onLoginCallback) {
    }

    private void clearLocalUserInfo() {
        synchronized (lock) {
            if (mUserInfo != null) {
                mUserInfo.setPwd(null);
                mUserInfo.setPin(null);
                mUserInfo.setA2(null);
                mUserInfo.setA2RefreshTime(0);
                mUserInfo.setA2TimeOut(0);
                mUserInfo.setA2CreateDate(null);
            }
            setUserInfo(mUserInfo);
            if (wUserAccessToken != null) {
                wUserAccessToken.setAccessToken(null);
                wUserAccessToken.setExpireTime(0);
                wUserAccessToken.setOpenid(null);
                wUserAccessToken.setRefreshToken(null);
                wUserAccessToken.setScope(null);
                wUserAccessToken.setType(null);
                wUserAccessToken.setUnionid(null);
                setUserTokenInfo(wUserAccessToken);
            }
        }
    }

    public void clearLocalOnlineState() {
        synchronized (lock) {
            if (mUserInfo != null) {
                mUserInfo.setPin(null);
                mUserInfo.setA2(null);
                mUserInfo.setA2RefreshTime(0);
                mUserInfo.setA2TimeOut(0);
                mUserInfo.setA2CreateDate(null);
            }
            setUserInfo(mUserInfo);
        }
    }

    public tlv_0x4 getGuid() {
        if (guid == null) {
            try {
                guid = (tlv_0x4) LocalFileUtil.getObject(Config.GUID_LOCALNAME);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return guid;
    }

    public ClientInfo getClientInfo() {
        return this.clientInfo;
    }

    private void setUserInfo(WUserSigInfo wUserSigInfo) {
        if (wUserSigInfo != null) {
            try {
                if (mUserInfo == null) {
                    mUserInfo = new WUserSigInfo();
                }
                if (mUserInfo != wUserSigInfo) {
                    mUserInfo.setAccount(wUserSigInfo.getAccount());
                    mUserInfo.setPwd(wUserSigInfo.getPwd());
                    mUserInfo.setPin(wUserSigInfo.getPin());
                    mUserInfo.setA2(wUserSigInfo.getA2());
                    mUserInfo.setA2RefreshTime(wUserSigInfo.getA2RefreshTime());
                    mUserInfo.setA2TimeOut(wUserSigInfo.getA2TimeOut());
                    mUserInfo.setA2CreateDate(wUserSigInfo.getA2CreateDate());
                }
                LocalFileUtil.setObjectJsonEncrypt(Config.USERINFO_LOCALNAME, mUserInfo);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private String getOSVer() {
        return VERSION.RELEASE;
    }

    private FailResult getDefualFailResult() {
        FailResult failResult = new FailResult();
        failResult.setReplyCode((byte) -2);
        failResult.setMessage(Config.ERR_MSG_LOCAL_NETWORK_FAILED);
        return failResult;
    }

    private FailResult getDefualFailResult(byte b) {
        FailResult failResult = new FailResult();
        failResult.setReplyCode(b);
        failResult.setMessage(Config.ERR_MSG_LOCAL_NETWORK_FAILED);
        return failResult;
    }

    private FailResult getFailResult(byte b, tlv_0x3 tlv_0x3) {
        FailResult failResult = new FailResult();
        failResult.setReplyCode(b);
        if (tlv_0x3.getStUError() != null) {
            failResult.setMessage(tlv_0x3.getStUError());
        } else {
            failResult.setMessage(tlv_0x3.getStError());
        }
        return failResult;
    }

    private BindResult getUnBindResult(tlv_0x11 tlv_0x11, tlv_0x1e tlv_0x1e) {
        BindResult bindResult = new BindResult();
        if (!(tlv_0x11 == null || tlv_0x11.getToken() == null)) {
            bindResult.setToken(new String(tlv_0x11.getToken()));
        }
        if (tlv_0x1e != null) {
            bindResult.setUrl(tlv_0x1e.getUrl());
        }
        return bindResult;
    }

    private JumpResult getJumpResult(tlv_0x11 tlv_0x11, tlv_0x1e tlv_0x1e) {
        JumpResult jumpResult = new JumpResult();
        if (tlv_0x11 != null) {
            jumpResult.setToken(new String(tlv_0x11.getToken()));
        }
        if (tlv_0x1e != null) {
            jumpResult.setUrl(tlv_0x1e.getUrl());
        }
        return jumpResult;
    }

    private QrCodeScannedResult getQrCodeResult(tlv_0x26 tlv_0x26, tlv_0x22 tlv_0x22) {
        QrCodeScannedResult qrCodeScannedResult = new QrCodeScannedResult();
        if (tlv_0x26 != null) {
            qrCodeScannedResult.setTips(tlv_0x26.getTips());
        }
        if (tlv_0x22 != null) {
            qrCodeScannedResult.setType(tlv_0x22.getType());
        }
        return (tlv_0x22 == null || tlv_0x26 == null) ? null : qrCodeScannedResult;
    }

    private PicDataInfo getPicData(tlv_0xf tlv_0xf) {
        PicDataInfo picDataInfo = new PicDataInfo();
        picDataInfo.setsPicData(tlv_0xf.getsPicData());
        picDataInfo.setStEncryptKey(tlv_0xf.getStEncryptKey());
        return picDataInfo;
    }

    private void decryptUserInfo(WUserSigInfo wUserSigInfo) {
        AES128.getKey(this.mContext);
        wUserSigInfo.setAccount(AES128.decrypt(wUserSigInfo.getAccount()));
        wUserSigInfo.setA2(AES128.decrypt(wUserSigInfo.getA2()));
        wUserSigInfo.setPin(AES128.decrypt(wUserSigInfo.getPin()));
        wUserSigInfo.setPwd(AES128.decrypt(wUserSigInfo.getPwd()));
    }

    private boolean checkSeq(int i) {
        if (i != this.seq) {
            return false;
        }
        return true;
    }

    private void SaveUserInfo(TLV tlv, String str, String str2, Boolean bool) {
        synchronized (lock) {
            if (mUserInfo == null) {
                mUserInfo = new WUserSigInfo();
            }
            mUserInfo.setAccount(str);
            if (tlv.getTlv0xa() != null) {
                mUserInfo.setA2(tlv.getTlv0xa().getA2());
                mUserInfo.setA2CreateDate(new Date());
            }
            if (tlv.getTlv0xe() != null) {
                mUserInfo.setA2RefreshTime(tlv.getTlv0xe().getDwChangeTime());
                mUserInfo.setA2TimeOut(tlv.getTlv0xe().getDwExpireTime());
            }
            if (tlv.getTlv0x10() != null) {
                mUserInfo.setPin(tlv.getTlv0x10().getPin());
            }
            if (!(!bool.booleanValue() || str2 == null || str2.equals(""))) {
                mUserInfo.setPwd(str2);
            }
            setUserInfo(mUserInfo);
        }
    }

    private void SaveA2(tlv_0xa tlv_0xa, tlv_0xe tlv_0xe) {
        synchronized (lock) {
            mUserInfo.setA2(tlv_0xa.getA2());
            mUserInfo.setA2CreateDate(new Date());
            mUserInfo.setA2RefreshTime(tlv_0xe.getDwChangeTime());
            mUserInfo.setA2TimeOut(tlv_0xe.getDwExpireTime());
            setUserInfo(mUserInfo);
        }
    }

    public WUserSigInfo getLocalUserTest() {
        return this.isDevelop ? mUserInfo : null;
    }

    public void refreshUserInfoFromLocalFile() {
        getUserInfo(true);
    }

    public void wxLogin(WXTokenInfo wXTokenInfo, final WXLoginCallback wXLoginCallback) {
        try {
            if (checkLocked()) {
                this.seq++;
                this.messageEncoder = new MessageEncoder();
                this.messageEncoder.setMessageHeader(MessageProcess.getMessageHeader((short) 5, (short) 1, this.clientInfo, this.seq));
                MessageProcess.putTlv0x4(this.messageEncoder, getGuid());
                MessageProcess.putTlv0x8(this.messageEncoder, this.clientInfo, NetworkManager.getAPNTypeString(this.mContext));
                MessageProcess.putTlv0x1c(this.messageEncoder, wXTokenInfo);
                MessageProcess.putTlv0x37(this.messageEncoder, this.mSoftFingerprint);
                MessageProcess.putTlv0x48(this.messageEncoder, this.clientInfo);
                final String randomKey = RandomKeyDecryptor.getRandomKey();
                String encode = RandomKeyDecryptor.encode(this.messageEncoder.getBufferArray(), randomKey);
                this.startTime = System.currentTimeMillis();
                Ajax ajax = new Ajax(1, AjaxUtil.getUrl(HttpConfig.LOGIN_METHOD, this.isDevelop), this.mContext);
                ajax.setRetryTimes(2);
                ajax.setRetryWithHttp(true);
                ajax.setParams(encode);
                ajax.send();
                ajax.setOnSuccessListener(new OnSuccessListener() {
                    public void onSuccess(String str) {
                        WJLoginHelper.this.bLocked = false;
                        WJLoginHelper.this.WXLoginSuccess(str, randomKey, wXLoginCallback);
                    }
                });
                ajax.setOnErrorListener(new OnErrorListener() {
                    public void onError(String str) {
                        WJLoginHelper.this.bLocked = false;
                        if (wXLoginCallback != null) {
                            wXLoginCallback.onError(str);
                        }
                        WJLoginHelper.this.reportLoginResult((byte) -1, (short) 5, (short) 1);
                    }
                });
            } else if (wXLoginCallback != null) {
                wXLoginCallback.onError(Config.makeErrMsg(Config.ERR_CODE_SDK_BLOCKED, Config.ERR_MSG_SDK_BLOCKED));
            }
        } catch (Exception e) {
            this.bLocked = false;
            e.printStackTrace();
            if (wXLoginCallback != null) {
                wXLoginCallback.onError(Config.makeErrMsg(Config.ERR_CODE_RESPONSE_DATA_ERR, Config.ERR_MSG_RESPONSE_DATA_ERR));
            }
        }
    }

    private void WXLoginSuccess(String str, String str2, WXLoginCallback wXLoginCallback) {
        try {
            MessageDecoder messageDecoder = new MessageDecoder(RandomKeyDecryptor.decode(str, str2));
            MessageHeader messageHeader = messageDecoder.getMessageHeader();
            byte status = messageHeader.getStatus();
            TLV tlv = messageDecoder.getTLV();
            if (checkSeq(messageHeader.getSeq())) {
                saveSoftfingerprint(tlv.getTlv0x37());
                if (status == (byte) 0) {
                    SaveUserInfo(tlv, "", "", Boolean.valueOf(false));
                    saveUserTokenInfo(tlv.getTlv0x1d());
                    if (TextUtils.isEmpty(getA2()) || TextUtils.isEmpty(getPin())) {
                        if (wXLoginCallback != null) {
                            wXLoginCallback.onError(Config.makeErrMsg(Config.ERR_CODE_RESPONSE_DATA_ERR, Config.ERR_MSG_RESPONSE_DATA_ERR));
                        }
                        reportLoginResult((byte) -2, (short) 5, (short) 1);
                        return;
                    }
                    if (wXLoginCallback != null) {
                        wXLoginCallback.onSuccess();
                    }
                    reportLoginResult(status, (short) 5, (short) 1);
                    return;
                }
                FailResult failResult;
                tlv_0x3 tlv0x3 = tlv.getTlv0x3();
                if (tlv0x3 != null) {
                    failResult = getFailResult(status, tlv0x3);
                } else {
                    failResult = getDefualFailResult(status);
                }
                tlv_0x11 tlv0x11 = tlv.getTlv0x11();
                tlv_0x1e tlv0x1e = tlv.getTlv0x1e();
                BindResult unBindResult = getUnBindResult(tlv0x11, tlv0x1e);
                if (status == ReplyCode.reply0x6a) {
                    if (wXLoginCallback != null) {
                        wXLoginCallback.onFail(failResult, getUnBindResult(null, null));
                    }
                } else if (status < ReplyCode.reply0x77 || status > ReplyCode.reply0x7a) {
                    if (status < ReplyCode.reply0x7b || status > ReplyCode.reply0x7e) {
                        if (wXLoginCallback != null) {
                            wXLoginCallback.onFail(failResult, unBindResult);
                        }
                    } else if (wXLoginCallback != null) {
                        wXLoginCallback.onFail(failResult, getUnBindResult(null, tlv0x1e));
                    }
                } else if (wXLoginCallback != null) {
                    wXLoginCallback.onFail(failResult, getUnBindResult(null, tlv0x1e));
                }
                reportLoginResult(status, (short) 5, (short) 1);
                return;
            }
            if (wXLoginCallback != null) {
                wXLoginCallback.onFail(getDefualFailResult(), null);
            }
            reportLoginResult((byte) -1, (short) 5, (short) 1);
        } catch (Exception e) {
            e.printStackTrace();
            if (wXLoginCallback != null) {
                wXLoginCallback.onError(Config.makeErrMsg(Config.ERR_CODE_RESPONSE_DATA_ERR, Config.ERR_MSG_RESPONSE_DATA_ERR));
                reportLoginResult((byte) -2, (short) 5, (short) 1);
            }
        }
    }

    public void qqLogin(QQTokenInfo qQTokenInfo, final TencentLoginCallback tencentLoginCallback) {
        try {
            if (checkLocked()) {
                this.seq++;
                this.messageEncoder = new MessageEncoder();
                this.messageEncoder.setMessageHeader(MessageProcess.getMessageHeader((short) 5, (short) 7, this.clientInfo, this.seq));
                MessageProcess.putTlv0x4(this.messageEncoder, getGuid());
                MessageProcess.putTlv0x8(this.messageEncoder, this.clientInfo, NetworkManager.getAPNTypeString(this.mContext));
                MessageProcess.putTlv0x20(this.messageEncoder, qQTokenInfo);
                MessageProcess.putTlv0x37(this.messageEncoder, this.mSoftFingerprint);
                MessageProcess.putTlv0x48(this.messageEncoder, this.clientInfo);
                final String randomKey = RandomKeyDecryptor.getRandomKey();
                String encode = RandomKeyDecryptor.encode(this.messageEncoder.getBufferArray(), randomKey);
                this.startTime = System.currentTimeMillis();
                Ajax ajax = new Ajax(1, AjaxUtil.getUrl(HttpConfig.LOGIN_METHOD, this.isDevelop), this.mContext);
                ajax.setRetryTimes(2);
                ajax.setRetryWithHttp(true);
                ajax.setParams(encode);
                ajax.send();
                ajax.setOnSuccessListener(new OnSuccessListener() {
                    public void onSuccess(String str) {
                        WJLoginHelper.this.bLocked = false;
                        WJLoginHelper.this.QQLoginSuccess(str, randomKey, tencentLoginCallback);
                    }
                });
                ajax.setOnErrorListener(new OnErrorListener() {
                    public void onError(String str) {
                        WJLoginHelper.this.bLocked = false;
                        if (tencentLoginCallback != null) {
                            tencentLoginCallback.onError(str);
                        }
                        WJLoginHelper.this.reportLoginResult((byte) -1, (short) 5, (short) 7);
                    }
                });
            } else if (tencentLoginCallback != null) {
                tencentLoginCallback.onError(Config.makeErrMsg(Config.ERR_CODE_SDK_BLOCKED, Config.ERR_MSG_SDK_BLOCKED));
            }
        } catch (Exception e) {
            this.bLocked = false;
            e.printStackTrace();
            if (tencentLoginCallback != null) {
                tencentLoginCallback.onError(Config.makeErrMsg(Config.ERR_CODE_RESPONSE_DATA_ERR, Config.ERR_MSG_RESPONSE_DATA_ERR));
            }
        }
    }

    private void QQLoginSuccess(String str, String str2, TencentLoginCallback tencentLoginCallback) {
        try {
            MessageDecoder messageDecoder = new MessageDecoder(RandomKeyDecryptor.decode(str, str2));
            MessageHeader messageHeader = messageDecoder.getMessageHeader();
            byte status = messageHeader.getStatus();
            TLV tlv = messageDecoder.getTLV();
            if (checkSeq(messageHeader.getSeq())) {
                saveSoftfingerprint(tlv.getTlv0x37());
                if (status == (byte) 0) {
                    SaveUserInfo(tlv, null, null, Boolean.valueOf(false));
                    saveUserTokenInfo(tlv.getTlv0x1d());
                    if (TextUtils.isEmpty(getA2()) || TextUtils.isEmpty(getPin())) {
                        if (tencentLoginCallback != null) {
                            tencentLoginCallback.onError(Config.makeErrMsg(Config.ERR_CODE_RESPONSE_DATA_ERR, Config.ERR_MSG_RESPONSE_DATA_ERR));
                        }
                        reportLoginResult((byte) -2, (short) 5, (short) 7);
                        return;
                    }
                    if (tencentLoginCallback != null) {
                        tencentLoginCallback.onSuccess();
                    }
                    reportLoginResult(status, (short) 5, (short) 7);
                    return;
                }
                FailResult failResult;
                tlv_0x3 tlv0x3 = tlv.getTlv0x3();
                if (tlv0x3 != null) {
                    failResult = getFailResult(status, tlv0x3);
                } else {
                    failResult = getDefualFailResult(status);
                }
                tlv_0x11 tlv0x11 = tlv.getTlv0x11();
                tlv_0x1e tlv0x1e = tlv.getTlv0x1e();
                BindResult unBindResult = getUnBindResult(tlv0x11, tlv0x1e);
                if (status == ReplyCode.reply0x6a) {
                    if (tencentLoginCallback != null) {
                        tencentLoginCallback.onFail(failResult, getUnBindResult(null, null));
                    }
                } else if (status < ReplyCode.reply0x77 || status > ReplyCode.reply0x7a) {
                    if (status < ReplyCode.reply0x7b || status > ReplyCode.reply0x7e) {
                        if (tencentLoginCallback != null) {
                            tencentLoginCallback.onFail(failResult, unBindResult);
                        }
                    } else if (tencentLoginCallback != null) {
                        tencentLoginCallback.onFail(failResult, getUnBindResult(null, tlv0x1e));
                    }
                } else if (tencentLoginCallback != null) {
                    tencentLoginCallback.onFail(failResult, getUnBindResult(null, tlv0x1e));
                }
                reportLoginResult(status, (short) 5, (short) 7);
                return;
            }
            if (tencentLoginCallback != null) {
                tencentLoginCallback.onFail(getDefualFailResult(), null);
            }
            reportLoginResult((byte) -1, (short) 5, (short) 7);
        } catch (Exception e) {
            e.printStackTrace();
            if (tencentLoginCallback != null) {
                tencentLoginCallback.onError(Config.makeErrMsg(Config.ERR_CODE_RESPONSE_DATA_ERR, Config.ERR_MSG_RESPONSE_DATA_ERR));
                reportLoginResult((byte) -2, (short) 5, (short) 7);
            }
        }
    }

    public void bindAccountLogin(String str, final OnCommonCallback onCommonCallback) {
        try {
            if (checkLocked()) {
                this.seq++;
                this.messageEncoder = new MessageEncoder();
                this.messageEncoder.setMessageHeader(MessageProcess.getMessageHeader((short) 5, (short) 4, this.clientInfo, this.seq));
                MessageProcess.putTlv0x11(this.messageEncoder, str);
                final String randomKey = RandomKeyDecryptor.getRandomKey();
                String encode = RandomKeyDecryptor.encode(this.messageEncoder.getBufferArray(), randomKey);
                this.startTime = System.currentTimeMillis();
                Ajax ajax = new Ajax(1, AjaxUtil.getUrl(HttpConfig.LOGIN_METHOD, this.isDevelop), this.mContext);
                ajax.setRetryTimes(2);
                ajax.setRetryWithHttp(true);
                ajax.setParams(encode);
                ajax.send();
                ajax.setOnSuccessListener(new OnSuccessListener() {
                    public void onSuccess(String str) {
                        WJLoginHelper.this.bLocked = false;
                        WJLoginHelper.this.bindAccountLoginSuccess(str, randomKey, onCommonCallback);
                    }
                });
                ajax.setOnErrorListener(new OnErrorListener() {
                    public void onError(String str) {
                        WJLoginHelper.this.bLocked = false;
                        if (onCommonCallback != null) {
                            onCommonCallback.onError(str);
                        }
                        WJLoginHelper.this.reportLoginResult((byte) -1, (short) 5, (short) 4);
                    }
                });
            } else if (onCommonCallback != null) {
                onCommonCallback.onError(Config.makeErrMsg(Config.ERR_CODE_SDK_BLOCKED, Config.ERR_MSG_SDK_BLOCKED));
            }
        } catch (Exception e) {
            this.bLocked = false;
            e.printStackTrace();
            if (onCommonCallback != null) {
                onCommonCallback.onError(Config.makeErrMsg(Config.ERR_CODE_RESPONSE_DATA_ERR, Config.ERR_MSG_RESPONSE_DATA_ERR));
            }
        }
    }

    private void bindAccountLoginSuccess(String str, String str2, OnCommonCallback onCommonCallback) {
        try {
            MessageDecoder messageDecoder = new MessageDecoder(RandomKeyDecryptor.decode(str, str2));
            MessageHeader messageHeader = messageDecoder.getMessageHeader();
            byte status = messageHeader.getStatus();
            TLV tlv = messageDecoder.getTLV();
            if (checkSeq(messageHeader.getSeq())) {
                saveSoftfingerprint(tlv.getTlv0x37());
                if (status == (byte) 0) {
                    SaveUserInfo(tlv, null, null, Boolean.valueOf(false));
                    saveUserTokenInfo(tlv.getTlv0x1d());
                    if (onCommonCallback != null) {
                        onCommonCallback.onSuccess();
                    }
                    reportLoginResult(status, (short) 5, (short) 4);
                    return;
                }
                FailResult failResult;
                tlv_0x3 tlv0x3 = tlv.getTlv0x3();
                if (tlv0x3 != null) {
                    failResult = getFailResult(status, tlv0x3);
                } else {
                    failResult = getDefualFailResult(status);
                }
                if (onCommonCallback != null) {
                    onCommonCallback.onFail(failResult);
                }
                reportLoginResult(status, (short) 5, (short) 4);
                return;
            }
            if (onCommonCallback != null) {
                onCommonCallback.onFail(getDefualFailResult());
            }
            reportLoginResult(status, (short) 5, (short) 4);
        } catch (Exception e) {
            e.printStackTrace();
            if (onCommonCallback != null) {
                onCommonCallback.onError(Config.makeErrMsg(Config.ERR_CODE_RESPONSE_DATA_ERR, Config.ERR_MSG_RESPONSE_DATA_ERR));
            }
            reportLoginResult((byte) -2, (short) 5, (short) 4);
        }
    }

    private void saveUserTokenInfo(tlv_0x1d tlv_0x1d) {
        synchronized (lock) {
            if (wUserAccessToken == null) {
                wUserAccessToken = new WUserAccessToken();
            }
            if (tlv_0x1d != null) {
                wUserAccessToken.setAccessToken(tlv_0x1d.getAccessToken());
                wUserAccessToken.setExpireTime((long) tlv_0x1d.getExpireTime());
                wUserAccessToken.setOpenid(tlv_0x1d.getOpenid());
                wUserAccessToken.setScope(tlv_0x1d.getScope());
                wUserAccessToken.setRefreshToken(tlv_0x1d.getRefreshToken());
                wUserAccessToken.setType(String.valueOf(tlv_0x1d.getType()));
                setUserTokenInfo(wUserAccessToken);
            }
        }
    }

    private void setUserTokenInfo(WUserAccessToken wUserAccessToken) {
        LocalFileUtil.setObjectJsonEncrypt(Config.USERTOKENINFO_LOCALNAME, wUserAccessToken);
    }

    public WUserAccessToken getUserTokenInfo() {
        synchronized (lock) {
            if (wUserAccessToken == null) {
                wUserAccessToken = (WUserAccessToken) LocalFileUtil.getObjectJsonDecrypt(Config.USERTOKENINFO_LOCALNAME, WUserAccessToken.class);
            }
            if (wUserAccessToken != null) {
                WUserAccessToken wUserAccessToken = new WUserAccessToken();
                wUserAccessToken.setAccessToken(wUserAccessToken.getAccessToken());
                wUserAccessToken.setExpireTime(wUserAccessToken.getExpireTime());
                wUserAccessToken.setOpenid(wUserAccessToken.getOpenid());
                wUserAccessToken.setScope(wUserAccessToken.getScope());
                wUserAccessToken.setRefreshToken(wUserAccessToken.getRefreshToken());
                wUserAccessToken.setType(wUserAccessToken.getType());
                return wUserAccessToken;
            }
            return null;
        }
    }

    public void isNeedImageCode(final OnNeedImageCodeCallBack onNeedImageCodeCallBack) {
        try {
            if (checkLocked()) {
                this.seq++;
                this.messageEncoder = new MessageEncoder();
                this.messageEncoder.setMessageHeader(MessageProcess.getMessageHeader((short) 4, (short) 8, this.clientInfo, this.seq));
                MessageProcess.putTlv0x4(this.messageEncoder, getGuid());
                MessageProcess.putTlv0x8(this.messageEncoder, this.clientInfo, NetworkManager.getAPNTypeString(this.mContext));
                this.startTime = System.currentTimeMillis();
                Ajax ajax = new Ajax(1, AjaxUtil.getUrl(HttpConfig.LOGIN_METHOD, this.isDevelop), this.mContext);
                final String randomKey = RandomKeyDecryptor.getRandomKey();
                String encode = RandomKeyDecryptor.encode(this.messageEncoder.getBufferArray(), randomKey);
                ajax.setRetryTimes(2);
                ajax.setRetryWithHttp(true);
                ajax.setParams(encode);
                ajax.send();
                ajax.setOnSuccessListener(new OnSuccessListener() {
                    public void onSuccess(String str) {
                        WJLoginHelper.this.bLocked = false;
                        WJLoginHelper.this.isNeedImageCodeSuccess(str, randomKey, onNeedImageCodeCallBack);
                    }
                });
                ajax.setOnErrorListener(new OnErrorListener() {
                    public void onError(String str) {
                        WJLoginHelper.this.bLocked = false;
                        if (onNeedImageCodeCallBack != null) {
                            onNeedImageCodeCallBack.onError(str);
                        }
                        WJLoginHelper.this.reportLoginResult((byte) -1, (short) 4, (short) 8);
                    }
                });
            } else if (onNeedImageCodeCallBack != null) {
                onNeedImageCodeCallBack.onError(Config.makeErrMsg(Config.ERR_CODE_SDK_BLOCKED, Config.ERR_MSG_SDK_BLOCKED));
            }
        } catch (Exception e) {
            this.bLocked = false;
            e.printStackTrace();
            if (onNeedImageCodeCallBack != null) {
                onNeedImageCodeCallBack.onError(Config.makeErrMsg(Config.ERR_CODE_RESPONSE_DATA_ERR, Config.ERR_MSG_RESPONSE_DATA_ERR));
            }
        }
    }

    private void isNeedImageCodeSuccess(String str, String str2, OnNeedImageCodeCallBack onNeedImageCodeCallBack) {
        PicDataInfo picDataInfo = null;
        try {
            MessageDecoder messageDecoder = new MessageDecoder(RandomKeyDecryptor.decode(str, str2));
            MessageHeader messageHeader = messageDecoder.getMessageHeader();
            byte status = messageHeader.getStatus();
            TLV tlv = messageDecoder.getTLV();
            if (!checkSeq(messageHeader.getSeq())) {
                if (onNeedImageCodeCallBack != null) {
                    onNeedImageCodeCallBack.onFail(getDefualFailResult());
                }
                reportLoginResult((byte) -1, (short) 4, (short) 8);
            } else if (status == (byte) 0) {
                if (onNeedImageCodeCallBack != null) {
                    onNeedImageCodeCallBack.onSuccess(null);
                }
            } else if (status == (byte) 3) {
                if (onNeedImageCodeCallBack != null) {
                    tlv_0xf tlv0xf = tlv.getTlv0xf();
                    if (tlv0xf != null) {
                        picDataInfo = getPicData(tlv0xf);
                    }
                    onNeedImageCodeCallBack.onSuccess(picDataInfo);
                }
                reportLoginResult(status, (short) 4, (short) 8);
            } else {
                FailResult failResult;
                tlv_0x3 tlv0x3 = tlv.getTlv0x3();
                if (tlv0x3 != null) {
                    failResult = getFailResult(status, tlv0x3);
                } else {
                    failResult = getDefualFailResult(status);
                }
                if (onNeedImageCodeCallBack != null) {
                    onNeedImageCodeCallBack.onFail(failResult);
                }
                reportLoginResult(status, (short) 4, (short) 8);
            }
        } catch (Exception e) {
            e.printStackTrace();
            if (onNeedImageCodeCallBack != null) {
                onNeedImageCodeCallBack.onFail(getDefualFailResult());
            }
            reportLoginResult((byte) -2, (short) 4, (short) 8);
        }
    }

    public void checkImageCodeAndPhoneNum(PicDataInfo picDataInfo, String str, boolean z, final CheckImageCodeAndPhoneNumCallBack checkImageCodeAndPhoneNumCallBack) {
        try {
            if (checkLocked()) {
                this.seq++;
                this.messageEncoder = new MessageEncoder();
                this.messageEncoder.setMessageHeader(MessageProcess.getMessageHeader((short) 4, (short) 3, this.clientInfo, this.seq));
                MessageProcess.putTlv0x4(this.messageEncoder, getGuid());
                MessageProcess.putTlv0x8(this.messageEncoder, this.clientInfo, NetworkManager.getAPNTypeString(this.mContext));
                MessageProcess.putTlv0x19(this.messageEncoder, str);
                if (z) {
                    MessageProcess.putTlv0x12(this.messageEncoder, picDataInfo.getStEncryptKey(), picDataInfo.getAuthCode());
                }
                this.startTime = System.currentTimeMillis();
                Ajax ajax = new Ajax(1, AjaxUtil.getUrl(HttpConfig.LOGIN_METHOD, this.isDevelop), this.mContext);
                final String randomKey = RandomKeyDecryptor.getRandomKey();
                String encode = RandomKeyDecryptor.encode(this.messageEncoder.getBufferArray(), randomKey);
                ajax.setRetryTimes(2);
                ajax.setRetryWithHttp(true);
                ajax.setParams(encode);
                ajax.send();
                ajax.setOnSuccessListener(new OnSuccessListener() {
                    public void onSuccess(String str) {
                        WJLoginHelper.this.bLocked = false;
                        WJLoginHelper.this.checkImageCodeAndPhoneNumSuccess(str, randomKey, checkImageCodeAndPhoneNumCallBack);
                    }
                });
                ajax.setOnErrorListener(new OnErrorListener() {
                    public void onError(String str) {
                        WJLoginHelper.this.bLocked = false;
                        if (checkImageCodeAndPhoneNumCallBack != null) {
                            checkImageCodeAndPhoneNumCallBack.onError(str);
                        }
                        WJLoginHelper.this.reportLoginResult((byte) -1, (short) 4, (short) 3);
                    }
                });
            } else if (checkImageCodeAndPhoneNumCallBack != null) {
                checkImageCodeAndPhoneNumCallBack.onError(Config.makeErrMsg(Config.ERR_CODE_SDK_BLOCKED, Config.ERR_MSG_SDK_BLOCKED));
            }
        } catch (Exception e) {
            this.bLocked = false;
            e.printStackTrace();
            if (checkImageCodeAndPhoneNumCallBack != null) {
                checkImageCodeAndPhoneNumCallBack.onError(Config.makeErrMsg(Config.ERR_CODE_RESPONSE_DATA_ERR, Config.ERR_MSG_RESPONSE_DATA_ERR));
            }
        }
    }

    private void checkImageCodeAndPhoneNumSuccess(String str, String str2, CheckImageCodeAndPhoneNumCallBack checkImageCodeAndPhoneNumCallBack) {
        try {
            MessageDecoder messageDecoder = new MessageDecoder(RandomKeyDecryptor.decode(str, str2));
            MessageHeader messageHeader = messageDecoder.getMessageHeader();
            byte status = messageHeader.getStatus();
            TLV tlv = messageDecoder.getTLV();
            if (!checkSeq(messageHeader.getSeq())) {
                if (checkImageCodeAndPhoneNumCallBack != null) {
                    checkImageCodeAndPhoneNumCallBack.onFail(getDefualFailResult(), null);
                }
                reportLoginResult((byte) -1, (short) 4, (short) 3);
            } else if (status == (byte) 0) {
                if (checkImageCodeAndPhoneNumCallBack != null) {
                    checkImageCodeAndPhoneNumCallBack.onSuccess();
                }
                reportLoginResult(status, (short) 4, (short) 3);
            } else {
                FailResult failResult;
                PicDataInfo picData;
                tlv_0x3 tlv0x3 = tlv.getTlv0x3();
                tlv_0xf tlv0xf = tlv.getTlv0xf();
                tlv_0x1b tlv0x1b = tlv.getTlv0x1b();
                if (tlv0x3 != null) {
                    failResult = getFailResult(status, tlv0x3);
                } else {
                    failResult = getDefualFailResult(status);
                }
                if (tlv0x1b != null) {
                    failResult.setDwLimitTime(tlv0x1b.getMessagePwdExpireTime());
                }
                if (tlv0xf != null) {
                    picData = getPicData(tlv0xf);
                } else {
                    picData = null;
                }
                if (checkImageCodeAndPhoneNumCallBack != null) {
                    checkImageCodeAndPhoneNumCallBack.onFail(failResult, picData);
                }
                reportLoginResult(status, (short) 4, (short) 3);
            }
        } catch (Exception e) {
            e.printStackTrace();
            if (checkImageCodeAndPhoneNumCallBack != null) {
                checkImageCodeAndPhoneNumCallBack.onFail(getDefualFailResult(), null);
            }
            reportLoginResult((byte) -2, (short) 4, (short) 3);
        }
    }

    public void getMessageCode(String str, final OnGetMessageCodeCallback onGetMessageCodeCallback) {
        try {
            if (checkLocked()) {
                this.seq++;
                this.messageEncoder = new MessageEncoder();
                this.messageEncoder.setMessageHeader(MessageProcess.getMessageHeader((short) 4, (short) 4, this.clientInfo, this.seq));
                MessageProcess.putTlv0x4(this.messageEncoder, getGuid());
                MessageProcess.putTlv0x8(this.messageEncoder, this.clientInfo, NetworkManager.getAPNTypeString(this.mContext));
                MessageProcess.putTlv0x19(this.messageEncoder, str);
                this.startTime = System.currentTimeMillis();
                Ajax ajax = new Ajax(1, AjaxUtil.getUrl(HttpConfig.LOGIN_METHOD, this.isDevelop), this.mContext);
                final String randomKey = RandomKeyDecryptor.getRandomKey();
                String encode = RandomKeyDecryptor.encode(this.messageEncoder.getBufferArray(), randomKey);
                ajax.setRetryTimes(2);
                ajax.setRetryWithHttp(true);
                ajax.setParams(encode);
                ajax.send();
                ajax.setOnSuccessListener(new OnSuccessListener() {
                    public void onSuccess(String str) {
                        WJLoginHelper.this.bLocked = false;
                        WJLoginHelper.this.getMessageCodeSuccess(str, randomKey, onGetMessageCodeCallback);
                    }
                });
                ajax.setOnErrorListener(new OnErrorListener() {
                    public void onError(String str) {
                        WJLoginHelper.this.bLocked = false;
                        if (onGetMessageCodeCallback != null) {
                            onGetMessageCodeCallback.onError(str);
                        }
                        WJLoginHelper.this.reportLoginResult((byte) -1, (short) 4, (short) 4);
                    }
                });
            } else if (onGetMessageCodeCallback != null) {
                onGetMessageCodeCallback.onError(Config.makeErrMsg(Config.ERR_CODE_SDK_BLOCKED, Config.ERR_MSG_SDK_BLOCKED));
            }
        } catch (Exception e) {
            this.bLocked = false;
            e.printStackTrace();
            if (onGetMessageCodeCallback != null) {
                onGetMessageCodeCallback.onError(Config.makeErrMsg(Config.ERR_CODE_RESPONSE_DATA_ERR, Config.ERR_MSG_RESPONSE_DATA_ERR));
            }
        }
    }

    private void getMessageCodeSuccess(String str, String str2, OnGetMessageCodeCallback onGetMessageCodeCallback) {
        try {
            MessageDecoder messageDecoder = new MessageDecoder(RandomKeyDecryptor.decode(str, str2));
            MessageHeader messageHeader = messageDecoder.getMessageHeader();
            byte status = messageHeader.getStatus();
            TLV tlv = messageDecoder.getTLV();
            if (!checkSeq(messageHeader.getSeq())) {
                if (onGetMessageCodeCallback != null) {
                    onGetMessageCodeCallback.onFail(getDefualFailResult());
                }
                reportLoginResult((byte) -1, (short) 4, (short) 4);
            } else if (status == (byte) 0) {
                if (onGetMessageCodeCallback != null) {
                    onGetMessageCodeCallback.onSuccess(tlv.getTlv0x1b().getMessagePwdExpireTime());
                }
                reportLoginResult(status, (short) 4, (short) 4);
            } else {
                FailResult failResult;
                tlv_0x3 tlv0x3 = tlv.getTlv0x3();
                tlv_0x1b tlv0x1b = tlv.getTlv0x1b();
                if (tlv0x3 != null) {
                    failResult = getFailResult(status, tlv0x3);
                } else {
                    failResult = getDefualFailResult(status);
                }
                if (tlv0x1b != null) {
                    failResult.setDwLimitTime(tlv0x1b.getMessagePwdExpireTime());
                }
                if (onGetMessageCodeCallback != null) {
                    onGetMessageCodeCallback.onFail(failResult);
                }
                reportLoginResult(status, (short) 4, (short) 4);
            }
        } catch (Exception e) {
            e.printStackTrace();
            if (onGetMessageCodeCallback != null) {
                onGetMessageCodeCallback.onFail(getDefualFailResult());
            }
            reportLoginResult((byte) -2, (short) 4, (short) 4);
        }
    }

    public void checkMessageCode(String str, String str2, final OnCommonCallback onCommonCallback) {
        try {
            if (checkLocked()) {
                this.seq++;
                this.messageEncoder = new MessageEncoder();
                this.messageEncoder.setMessageHeader(MessageProcess.getMessageHeader((short) 4, (short) 5, this.clientInfo, this.seq));
                MessageProcess.putTlv0x4(this.messageEncoder, getGuid());
                MessageProcess.putTlv0x8(this.messageEncoder, this.clientInfo, NetworkManager.getAPNTypeString(this.mContext));
                MessageProcess.putTlv0x19(this.messageEncoder, str);
                MessageProcess.putTlv0x1a(this.messageEncoder, str2);
                this.startTime = System.currentTimeMillis();
                Ajax ajax = new Ajax(1, AjaxUtil.getUrl(HttpConfig.LOGIN_METHOD, this.isDevelop), this.mContext);
                final String randomKey = RandomKeyDecryptor.getRandomKey();
                String encode = RandomKeyDecryptor.encode(this.messageEncoder.getBufferArray(), randomKey);
                ajax.setRetryTimes(2);
                ajax.setRetryWithHttp(true);
                ajax.setParams(encode);
                ajax.send();
                ajax.setOnSuccessListener(new OnSuccessListener() {
                    public void onSuccess(String str) {
                        WJLoginHelper.this.bLocked = false;
                        WJLoginHelper.this.checkMessageCodeSuccess(str, randomKey, onCommonCallback);
                    }
                });
                ajax.setOnErrorListener(new OnErrorListener() {
                    public void onError(String str) {
                        WJLoginHelper.this.bLocked = false;
                        if (onCommonCallback != null) {
                            onCommonCallback.onError(str);
                        }
                        WJLoginHelper.this.reportLoginResult((byte) -1, (short) 4, (short) 5);
                    }
                });
            } else if (onCommonCallback != null) {
                onCommonCallback.onError(Config.makeErrMsg(Config.ERR_CODE_SDK_BLOCKED, Config.ERR_MSG_SDK_BLOCKED));
            }
        } catch (Exception e) {
            this.bLocked = false;
            e.printStackTrace();
            if (onCommonCallback != null) {
                onCommonCallback.onError(Config.makeErrMsg(Config.ERR_CODE_RESPONSE_DATA_ERR, Config.ERR_MSG_RESPONSE_DATA_ERR));
            }
        }
    }

    private void checkMessageCodeSuccess(String str, String str2, OnCommonCallback onCommonCallback) {
        try {
            MessageDecoder messageDecoder = new MessageDecoder(RandomKeyDecryptor.decode(str, str2));
            MessageHeader messageHeader = messageDecoder.getMessageHeader();
            byte status = messageHeader.getStatus();
            TLV tlv = messageDecoder.getTLV();
            if (!checkSeq(messageHeader.getSeq())) {
                if (onCommonCallback != null) {
                    onCommonCallback.onFail(getDefualFailResult());
                }
                reportLoginResult((byte) -1, (short) 4, (short) 5);
            } else if (status == (byte) 0) {
                if (onCommonCallback != null) {
                    onCommonCallback.onSuccess();
                }
                reportLoginResult(status, (short) 4, (short) 5);
            } else {
                FailResult failResult;
                tlv_0x3 tlv0x3 = tlv.getTlv0x3();
                if (tlv0x3 != null) {
                    failResult = getFailResult(status, tlv0x3);
                } else {
                    failResult = getDefualFailResult(status);
                }
                if (onCommonCallback != null) {
                    onCommonCallback.onFail(failResult);
                }
                reportLoginResult(status, (short) 4, (short) 5);
            }
        } catch (Exception e) {
            e.printStackTrace();
            if (onCommonCallback != null) {
                onCommonCallback.onFail(getDefualFailResult());
            }
            reportLoginResult((byte) -2, (short) 4, (short) 5);
        }
    }

    public void setLoginPassword(String str, String str2, final OnCommonCallback onCommonCallback) {
        try {
            if (checkLocked()) {
                this.seq++;
                this.messageEncoder = new MessageEncoder();
                this.messageEncoder.setMessageHeader(MessageProcess.getMessageHeader((short) 4, (short) 6, this.clientInfo, this.seq));
                MessageProcess.putTlv0x4(this.messageEncoder, getGuid());
                MessageProcess.putTlv0x8(this.messageEncoder, this.clientInfo, NetworkManager.getAPNTypeString(this.mContext));
                MessageProcess.putTlv0x19(this.messageEncoder, str);
                MessageProcess.putTlv0x1a(this.messageEncoder, str2);
                MessageProcess.putTlv0x48(this.messageEncoder, this.clientInfo);
                this.startTime = System.currentTimeMillis();
                Ajax ajax = new Ajax(1, AjaxUtil.getUrl(HttpConfig.LOGIN_METHOD, this.isDevelop), this.mContext);
                final String randomKey = RandomKeyDecryptor.getRandomKey();
                String encode = RandomKeyDecryptor.encode(this.messageEncoder.getBufferArray(), randomKey);
                ajax.setRetryTimes(2);
                ajax.setRetryWithHttp(true);
                ajax.setParams(encode);
                ajax.send();
                final String str3 = str;
                final String str4 = str2;
                final OnCommonCallback onCommonCallback2 = onCommonCallback;
                ajax.setOnSuccessListener(new OnSuccessListener() {
                    public void onSuccess(String str) {
                        WJLoginHelper.this.bLocked = false;
                        WJLoginHelper.this.setLoginPasswordSuccess(str, str3, str4, randomKey, onCommonCallback2);
                    }
                });
                ajax.setOnErrorListener(new OnErrorListener() {
                    public void onError(String str) {
                        WJLoginHelper.this.bLocked = false;
                        if (onCommonCallback != null) {
                            onCommonCallback.onError(str);
                        }
                        WJLoginHelper.this.reportLoginResult((byte) -1, (short) 4, (short) 6);
                    }
                });
            } else if (onCommonCallback != null) {
                onCommonCallback.onError(Config.makeErrMsg(Config.ERR_CODE_SDK_BLOCKED, Config.ERR_MSG_SDK_BLOCKED));
            }
        } catch (Exception e) {
            this.bLocked = false;
            e.printStackTrace();
            if (onCommonCallback != null) {
                onCommonCallback.onError(Config.makeErrMsg(Config.ERR_CODE_RESPONSE_DATA_ERR, Config.ERR_MSG_RESPONSE_DATA_ERR));
            }
        }
    }

    private void setLoginPasswordSuccess(String str, String str2, String str3, String str4, OnCommonCallback onCommonCallback) {
        try {
            MessageDecoder messageDecoder = new MessageDecoder(RandomKeyDecryptor.decode(str, str4));
            MessageHeader messageHeader = messageDecoder.getMessageHeader();
            byte status = messageHeader.getStatus();
            TLV tlv = messageDecoder.getTLV();
            if (!checkSeq(messageHeader.getSeq())) {
                if (onCommonCallback != null) {
                    onCommonCallback.onFail(getDefualFailResult());
                }
                reportLoginResult((byte) -1, (short) 4, (short) 6);
            } else if (status == (byte) 0) {
                SaveUserInfo(tlv, str2, str3, Boolean.valueOf(true));
                if (TextUtils.isEmpty(getA2()) || TextUtils.isEmpty(getPin())) {
                    if (onCommonCallback != null) {
                        onCommonCallback.onError(Config.makeErrMsg(Config.ERR_CODE_RESPONSE_DATA_ERR, Config.ERR_MSG_RESPONSE_DATA_ERR));
                    }
                    reportLoginResult((byte) -2, (short) 4, (short) 6);
                    return;
                }
                if (onCommonCallback != null) {
                    onCommonCallback.onSuccess();
                }
                reportLoginResult(status, (short) 4, (short) 6);
            } else {
                FailResult failResult;
                tlv_0x3 tlv0x3 = tlv.getTlv0x3();
                if (tlv0x3 != null) {
                    failResult = getFailResult(status, tlv0x3);
                } else {
                    failResult = getDefualFailResult(status);
                }
                if (onCommonCallback != null) {
                    onCommonCallback.onFail(failResult);
                }
                reportLoginResult(status, (short) 4, (short) 6);
            }
        } catch (Exception e) {
            e.printStackTrace();
            if (onCommonCallback != null) {
                onCommonCallback.onError(Config.makeErrMsg(Config.ERR_CODE_RESPONSE_DATA_ERR, Config.ERR_MSG_RESPONSE_DATA_ERR));
            }
            reportLoginResult((byte) -2, (short) 4, (short) 6);
        }
    }

    public void unBindPhoneNum(String str, final OnGetMessagePwdExpireTimeCallback onGetMessagePwdExpireTimeCallback) {
        try {
            if (checkLocked()) {
                this.seq++;
                this.messageEncoder = new MessageEncoder();
                this.messageEncoder.setMessageHeader(MessageProcess.getMessageHeader((short) 4, (short) 7, this.clientInfo, this.seq));
                MessageProcess.putTlv0x4(this.messageEncoder, getGuid());
                MessageProcess.putTlv0x8(this.messageEncoder, this.clientInfo, NetworkManager.getAPNTypeString(this.mContext));
                MessageProcess.putTlv0x19(this.messageEncoder, str);
                this.startTime = System.currentTimeMillis();
                Ajax ajax = new Ajax(1, AjaxUtil.getUrl(HttpConfig.LOGIN_METHOD, this.isDevelop), this.mContext);
                final String randomKey = RandomKeyDecryptor.getRandomKey();
                String encode = RandomKeyDecryptor.encode(this.messageEncoder.getBufferArray(), randomKey);
                ajax.setRetryTimes(2);
                ajax.setRetryWithHttp(true);
                ajax.setParams(encode);
                ajax.send();
                ajax.setOnSuccessListener(new OnSuccessListener() {
                    public void onSuccess(String str) {
                        WJLoginHelper.this.bLocked = false;
                        WJLoginHelper.this.unBindPhoneNumSuccess(str, randomKey, onGetMessagePwdExpireTimeCallback);
                    }
                });
                ajax.setOnErrorListener(new OnErrorListener() {
                    public void onError(String str) {
                        WJLoginHelper.this.bLocked = false;
                        if (onGetMessagePwdExpireTimeCallback != null) {
                            onGetMessagePwdExpireTimeCallback.onError(str);
                        }
                        WJLoginHelper.this.reportLoginResult((byte) -1, (short) 4, (short) 7);
                    }
                });
            } else if (onGetMessagePwdExpireTimeCallback != null) {
                onGetMessagePwdExpireTimeCallback.onError(Config.makeErrMsg(Config.ERR_CODE_SDK_BLOCKED, Config.ERR_MSG_SDK_BLOCKED));
            }
        } catch (Exception e) {
            this.bLocked = false;
            e.printStackTrace();
            if (onGetMessagePwdExpireTimeCallback != null) {
                onGetMessagePwdExpireTimeCallback.onError(Config.makeErrMsg(Config.ERR_CODE_RESPONSE_DATA_ERR, Config.ERR_MSG_RESPONSE_DATA_ERR));
            }
        }
    }

    private void unBindPhoneNumSuccess(String str, String str2, OnGetMessagePwdExpireTimeCallback onGetMessagePwdExpireTimeCallback) {
        try {
            MessageDecoder messageDecoder = new MessageDecoder(RandomKeyDecryptor.decode(str, str2));
            MessageHeader messageHeader = messageDecoder.getMessageHeader();
            byte status = messageHeader.getStatus();
            TLV tlv = messageDecoder.getTLV();
            if (!checkSeq(messageHeader.getSeq())) {
                if (onGetMessagePwdExpireTimeCallback != null) {
                    onGetMessagePwdExpireTimeCallback.onFail(getDefualFailResult());
                }
                reportLoginResult((byte) -1, (short) 4, (short) 7);
            } else if (status == (byte) 0) {
                if (onGetMessagePwdExpireTimeCallback != null) {
                    onGetMessagePwdExpireTimeCallback.onSuccess(tlv.getTlv0x1b().getMessagePwdExpireTime());
                }
                reportLoginResult(status, (short) 4, (short) 7);
            } else {
                FailResult failResult;
                tlv_0x3 tlv0x3 = tlv.getTlv0x3();
                tlv_0x1b tlv0x1b = tlv.getTlv0x1b();
                if (tlv0x3 != null) {
                    failResult = getFailResult(status, tlv0x3);
                } else {
                    failResult = getDefualFailResult(status);
                }
                if (tlv0x1b != null) {
                    failResult.setDwLimitTime(tlv0x1b.getMessagePwdExpireTime());
                }
                if (onGetMessagePwdExpireTimeCallback != null) {
                    onGetMessagePwdExpireTimeCallback.onFail(failResult);
                }
                reportLoginResult(status, (short) 4, (short) 7);
            }
        } catch (Exception e) {
            e.printStackTrace();
            if (onGetMessagePwdExpireTimeCallback != null) {
                onGetMessagePwdExpireTimeCallback.onFail(getDefualFailResult());
            }
            reportLoginResult((byte) -2, (short) 4, (short) 7);
        }
    }

    public void exitLogin(final OnCommonCallback onCommonCallback) {
        try {
            if (checkLocked()) {
                this.seq++;
                this.messageEncoder = new MessageEncoder();
                this.messageEncoder.setMessageHeader(MessageProcess.getMessageHeader((short) 3, (short) 3, this.clientInfo, this.seq));
                MessageProcess.putTlv0x10(this.messageEncoder, getPin() == null ? "" : getPin());
                MessageProcess.putTlv0x8(this.messageEncoder, this.clientInfo, NetworkManager.getAPNTypeString(this.mContext));
                MessageProcess.putTlv0xa(this.messageEncoder, getA2() == null ? "" : getA2());
                this.startTime = System.currentTimeMillis();
                Ajax ajax = new Ajax(1, AjaxUtil.getUrl(HttpConfig.LOGIN_METHOD, this.isDevelop), this.mContext);
                final String randomKey = RandomKeyDecryptor.getRandomKey();
                String encode = RandomKeyDecryptor.encode(this.messageEncoder.getBufferArray(), randomKey);
                ajax.setRetryTimes(2);
                ajax.setRetryWithHttp(true);
                ajax.setParams(encode);
                ajax.send();
                ajax.setOnSuccessListener(new OnSuccessListener() {
                    public void onSuccess(String str) {
                        WJLoginHelper.this.bLocked = false;
                        WJLoginHelper.this.clearLocalUserInfo();
                        WJLoginHelper.this.createGuid();
                        WJLoginHelper.this.exitLoginSuccess(str, randomKey, onCommonCallback);
                    }
                });
                ajax.setOnErrorListener(new OnErrorListener() {
                    public void onError(String str) {
                        WJLoginHelper.this.bLocked = false;
                        WJLoginHelper.this.clearLocalUserInfo();
                        WJLoginHelper.this.createGuid();
                        if (onCommonCallback != null) {
                            onCommonCallback.onError(str);
                        }
                        WJLoginHelper.this.reportLoginResult((byte) -1, (short) 3, (short) 3);
                    }
                });
            } else if (onCommonCallback != null) {
                onCommonCallback.onError(Config.makeErrMsg(Config.ERR_CODE_SDK_BLOCKED, Config.ERR_MSG_SDK_BLOCKED));
            }
        } catch (Exception e) {
            this.bLocked = false;
            clearLocalUserInfo();
            createGuid();
            e.printStackTrace();
            if (onCommonCallback != null) {
                onCommonCallback.onError(Config.makeErrMsg(Config.ERR_CODE_RESPONSE_DATA_ERR, Config.ERR_MSG_RESPONSE_DATA_ERR));
            }
        }
    }

    private void exitLoginSuccess(String str, String str2, OnCommonCallback onCommonCallback) {
        try {
            MessageDecoder messageDecoder = new MessageDecoder(RandomKeyDecryptor.decode(str, str2));
            MessageHeader messageHeader = messageDecoder.getMessageHeader();
            byte status = messageHeader.getStatus();
            TLV tlv = messageDecoder.getTLV();
            if (!checkSeq(messageHeader.getSeq())) {
                if (onCommonCallback != null) {
                    onCommonCallback.onFail(getDefualFailResult());
                }
                reportLoginResult((byte) -1, (short) 3, (short) 3);
            } else if (status == (byte) 0) {
                if (onCommonCallback != null) {
                    onCommonCallback.onSuccess();
                }
                reportLoginResult(status, (short) 3, (short) 3);
            } else {
                FailResult failResult;
                tlv_0x3 tlv0x3 = tlv.getTlv0x3();
                if (tlv0x3 != null) {
                    failResult = getFailResult(status, tlv0x3);
                } else {
                    failResult = getDefualFailResult(status);
                }
                if (onCommonCallback != null) {
                    onCommonCallback.onFail(failResult);
                }
                reportLoginResult(status, (short) 3, (short) 3);
            }
        } catch (Exception e) {
            e.printStackTrace();
            if (onCommonCallback != null) {
                onCommonCallback.onFail(getDefualFailResult());
            }
            reportLoginResult((byte) -2, (short) 3, (short) 3);
        }
    }

    public void reqQRCodePicture(int i, final OnReqQRCodePictureCallback onReqQRCodePictureCallback) {
        try {
            if (checkLocked()) {
                this.seq++;
                this.messageEncoder = new MessageEncoder();
                this.messageEncoder.setMessageHeader(MessageProcess.getMessageHeader((short) 7, (short) 1, this.clientInfo, this.seq));
                MessageProcess.putTlv0x4(this.messageEncoder, getGuid());
                MessageProcess.putTlv0x8(this.messageEncoder, this.clientInfo, NetworkManager.getAPNTypeString(this.mContext));
                MessageProcess.putTlv0x22(this.messageEncoder, (byte) 1, i);
                final String randomKey = RandomKeyDecryptor.getRandomKey();
                String encode = RandomKeyDecryptor.encode(this.messageEncoder.getBufferArray(), randomKey);
                this.startTime = System.currentTimeMillis();
                Ajax ajax = new Ajax(1, AjaxUtil.getUrl(HttpConfig.LOGIN_METHOD, this.isDevelop), this.mContext);
                ajax.setRetryTimes(2);
                ajax.setRetryWithHttp(true);
                ajax.setParams(encode);
                ajax.send();
                ajax.setOnSuccessListener(new OnSuccessListener() {
                    public void onSuccess(String str) {
                        WJLoginHelper.this.bLocked = false;
                        WJLoginHelper.this.reqQRCodePictureSuccess(str, randomKey, onReqQRCodePictureCallback);
                    }
                });
                ajax.setOnErrorListener(new OnErrorListener() {
                    public void onError(String str) {
                        WJLoginHelper.this.bLocked = false;
                        if (onReqQRCodePictureCallback != null) {
                            onReqQRCodePictureCallback.onError(str);
                        }
                        WJLoginHelper.this.reportLoginResult((byte) -1, (short) 7, (short) 1);
                    }
                });
            } else if (onReqQRCodePictureCallback != null) {
                onReqQRCodePictureCallback.onError(Config.makeErrMsg(Config.ERR_CODE_SDK_BLOCKED, Config.ERR_MSG_SDK_BLOCKED));
            }
        } catch (Exception e) {
            this.bLocked = false;
            e.printStackTrace();
            if (onReqQRCodePictureCallback != null) {
                onReqQRCodePictureCallback.onError(Config.makeErrMsg(Config.ERR_CODE_RESPONSE_DATA_ERR, Config.ERR_MSG_RESPONSE_DATA_ERR));
            }
        }
    }

    private void reqQRCodePictureSuccess(String str, String str2, OnReqQRCodePictureCallback onReqQRCodePictureCallback) {
        try {
            MessageDecoder messageDecoder = new MessageDecoder(RandomKeyDecryptor.decode(str, str2));
            MessageHeader messageHeader = messageDecoder.getMessageHeader();
            TLV tlv = messageDecoder.getTLV();
            byte status = messageHeader.getStatus();
            if (!checkSeq(messageHeader.getSeq())) {
                if (onReqQRCodePictureCallback != null) {
                    onReqQRCodePictureCallback.onFail(getDefualFailResult());
                }
                reportLoginResult((byte) -1, (short) 7, (short) 1);
            } else if (status == (byte) 0) {
                if (onReqQRCodePictureCallback != null) {
                    onReqQRCodePictureCallback.onSuccess(tlv.getTlv0x24().getQRCodeKey(), tlv.getTlv0x23().getQRCodeData());
                }
                reportLoginResult(status, (short) 7, (short) 1);
            } else {
                FailResult failResult;
                tlv_0x3 tlv0x3 = tlv.getTlv0x3();
                tlv_0x15 tlv0x15 = tlv.getTlv0x15();
                if (tlv0x3 != null) {
                    failResult = getFailResult(status, tlv0x3);
                } else {
                    failResult = getDefualFailResult(status);
                }
                if (tlv0x15 != null) {
                    failResult.setDwLimitTime(tlv0x15.getDwLimitTime());
                }
                onReqQRCodePictureCallback.onFail(failResult);
                reportLoginResult(status, (short) 7, (short) 1);
            }
        } catch (Exception e) {
            e.printStackTrace();
            if (onReqQRCodePictureCallback != null) {
                onReqQRCodePictureCallback.onFail(getDefualFailResult());
            }
            reportLoginResult((byte) -2, (short) 7, (short) 1);
        }
    }

    public void verifyQRCode(String str, final OnCommonCallback onCommonCallback) {
        try {
            if (checkLocked()) {
                this.seq++;
                this.messageEncoder = new MessageEncoder();
                this.messageEncoder.setMessageHeader(MessageProcess.getMessageHeader((short) 7, (short) 2, this.clientInfo, this.seq));
                MessageProcess.putTlv0x4(this.messageEncoder, getGuid());
                MessageProcess.putTlv0x8(this.messageEncoder, this.clientInfo, NetworkManager.getAPNTypeString(this.mContext));
                MessageProcess.putTlv0x24(this.messageEncoder, str);
                MessageProcess.putTlv0x22(this.messageEncoder, (byte) 1, 0);
                final String randomKey = RandomKeyDecryptor.getRandomKey();
                String encode = RandomKeyDecryptor.encode(this.messageEncoder.getBufferArray(), randomKey);
                this.startTime = System.currentTimeMillis();
                Ajax ajax = new Ajax(1, AjaxUtil.getUrl(HttpConfig.LOGIN_METHOD, this.isDevelop), this.mContext);
                ajax.setRetryTimes(2);
                ajax.setRetryWithHttp(true);
                ajax.setParams(encode);
                ajax.send();
                ajax.setOnSuccessListener(new OnSuccessListener() {
                    public void onSuccess(String str) {
                        WJLoginHelper.this.bLocked = false;
                        WJLoginHelper.this.verifyQRCodeSuccess(str, randomKey, onCommonCallback);
                    }
                });
                ajax.setOnErrorListener(new OnErrorListener() {
                    public void onError(String str) {
                        WJLoginHelper.this.bLocked = false;
                        if (onCommonCallback != null) {
                            onCommonCallback.onError(str);
                        }
                        WJLoginHelper.this.reportLoginResult((byte) -1, (short) 7, (short) 1);
                    }
                });
            } else if (onCommonCallback != null) {
                onCommonCallback.onError(Config.makeErrMsg(Config.ERR_CODE_SDK_BLOCKED, Config.ERR_MSG_SDK_BLOCKED));
            }
        } catch (Exception e) {
            this.bLocked = false;
            e.printStackTrace();
            if (onCommonCallback != null) {
                onCommonCallback.onError(Config.makeErrMsg(Config.ERR_CODE_RESPONSE_DATA_ERR, Config.ERR_MSG_RESPONSE_DATA_ERR));
            }
        }
    }

    private void verifyQRCodeSuccess(String str, String str2, OnCommonCallback onCommonCallback) {
        try {
            MessageDecoder messageDecoder = new MessageDecoder(RandomKeyDecryptor.decode(str, str2));
            MessageHeader messageHeader = messageDecoder.getMessageHeader();
            TLV tlv = messageDecoder.getTLV();
            byte status = messageHeader.getStatus();
            if (!checkSeq(messageHeader.getSeq())) {
                if (onCommonCallback != null) {
                    onCommonCallback.onFail(getDefualFailResult());
                }
                reportLoginResult((byte) -1, (short) 7, (short) 2);
            } else if (status == (byte) 0) {
                SaveUserInfo(tlv, null, null, Boolean.valueOf(false));
                if (TextUtils.isEmpty(getA2()) || TextUtils.isEmpty(getPin())) {
                    if (onCommonCallback != null) {
                        onCommonCallback.onError(Config.makeErrMsg(Config.ERR_CODE_RESPONSE_DATA_ERR, Config.ERR_MSG_RESPONSE_DATA_ERR));
                    }
                    reportLoginResult((byte) -2, (short) 7, (short) 2);
                    return;
                }
                if (onCommonCallback != null) {
                    onCommonCallback.onSuccess();
                }
                reportLoginResult(status, (short) 7, (short) 2);
            } else {
                FailResult failResult;
                tlv_0x3 tlv0x3 = tlv.getTlv0x3();
                if (tlv0x3 != null) {
                    failResult = getFailResult(status, tlv0x3);
                } else {
                    failResult = getDefualFailResult(status);
                }
                onCommonCallback.onFail(failResult);
                reportLoginResult(status, (short) 7, (short) 2);
            }
        } catch (Exception e) {
            e.printStackTrace();
            if (onCommonCallback != null) {
                onCommonCallback.onFail(getDefualFailResult());
            }
            reportLoginResult((byte) -2, (short) 7, (short) 2);
        }
    }

    public String getQRCodeKeyFromUrl(String str) {
        if (str == null || str.length() == 0) {
            return null;
        }
        String str2 = "http://qr.m.jd.com/p?k=";
        int indexOf = str.indexOf(str2);
        if (indexOf < 0 || indexOf > str.length()) {
            return null;
        }
        return str.substring(str2.length());
    }

    public void confirmQRCodeScanned(String str, final OnConfirmQRCodeScannedCallback onConfirmQRCodeScannedCallback) {
        try {
            if (checkLocked()) {
                Log.e("qrkey:", ":" + str);
                this.seq++;
                this.messageEncoder = new MessageEncoder();
                this.messageEncoder.setMessageHeader(MessageProcess.getMessageHeader((short) 7, (short) 3, this.clientInfo, this.seq));
                MessageProcess.putTlv0x4(this.messageEncoder, getGuid());
                MessageProcess.putTlv0x8(this.messageEncoder, this.clientInfo, NetworkManager.getAPNTypeString(this.mContext));
                MessageProcess.putTlv0x24(this.messageEncoder, str);
                final String randomKey = RandomKeyDecryptor.getRandomKey();
                String encode = RandomKeyDecryptor.encode(this.messageEncoder.getBufferArray(), randomKey);
                this.startTime = System.currentTimeMillis();
                Ajax ajax = new Ajax(1, AjaxUtil.getUrl(HttpConfig.LOGIN_METHOD, this.isDevelop), this.mContext);
                ajax.setRetryTimes(2);
                ajax.setRetryWithHttp(true);
                ajax.setParams(encode);
                ajax.send();
                ajax.setOnSuccessListener(new OnSuccessListener() {
                    public void onSuccess(String str) {
                        WJLoginHelper.this.bLocked = false;
                        WJLoginHelper.this.confirmQRCodeScannedSuccess(str, randomKey, onConfirmQRCodeScannedCallback);
                    }
                });
                ajax.setOnErrorListener(new OnErrorListener() {
                    public void onError(String str) {
                        WJLoginHelper.this.bLocked = false;
                        if (onConfirmQRCodeScannedCallback != null) {
                            onConfirmQRCodeScannedCallback.onError(str);
                        }
                        WJLoginHelper.this.reportLoginResult((byte) -1, (short) 7, (short) 3);
                    }
                });
            } else if (onConfirmQRCodeScannedCallback != null) {
                onConfirmQRCodeScannedCallback.onError(Config.makeErrMsg(Config.ERR_CODE_SDK_BLOCKED, Config.ERR_MSG_SDK_BLOCKED));
            }
        } catch (Exception e) {
            this.bLocked = false;
            e.printStackTrace();
            if (onConfirmQRCodeScannedCallback != null) {
                onConfirmQRCodeScannedCallback.onError(Config.makeErrMsg(Config.ERR_CODE_RESPONSE_DATA_ERR, Config.ERR_MSG_RESPONSE_DATA_ERR));
            }
        }
    }

    private void confirmQRCodeScannedSuccess(String str, String str2, OnConfirmQRCodeScannedCallback onConfirmQRCodeScannedCallback) {
        try {
            MessageDecoder messageDecoder = new MessageDecoder(RandomKeyDecryptor.decode(str, str2));
            MessageHeader messageHeader = messageDecoder.getMessageHeader();
            TLV tlv = messageDecoder.getTLV();
            byte status = messageHeader.getStatus();
            if (!checkSeq(messageHeader.getSeq())) {
                if (onConfirmQRCodeScannedCallback != null) {
                    onConfirmQRCodeScannedCallback.onFail(getDefualFailResult(), null);
                }
                reportLoginResult((byte) -1, (short) 7, (short) 3);
            } else if (status == (byte) 0) {
                if (onConfirmQRCodeScannedCallback != null) {
                    onConfirmQRCodeScannedCallback.onSuccess(tlv.getTlv0x26().getTips(), tlv.getTlv0x32().getButtonTips(), tlv.getTlv0x22().getType());
                }
                reportLoginResult(status, (short) 7, (short) 3);
            } else {
                FailResult failResult;
                QrCodeScannedResult qrCodeResult = getQrCodeResult(tlv.getTlv0x26(), tlv.getTlv0x22());
                tlv_0x3 tlv0x3 = tlv.getTlv0x3();
                if (tlv0x3 != null) {
                    failResult = getFailResult(status, tlv0x3);
                } else {
                    failResult = getDefualFailResult(status);
                }
                onConfirmQRCodeScannedCallback.onFail(failResult, qrCodeResult);
                reportLoginResult(status, (short) 7, (short) 3);
            }
        } catch (Exception e) {
            e.printStackTrace();
            if (onConfirmQRCodeScannedCallback != null) {
                onConfirmQRCodeScannedCallback.onFail(getDefualFailResult(), null);
            }
            reportLoginResult((byte) -2, (short) 7, (short) 3);
        }
    }

    public void confirmQRCodeLogined(String str, OnQrcodeConfirmLoginCallback onQrcodeConfirmLoginCallback) {
        confirmQRCodeLogined(str, getA2(), getPin(), onQrcodeConfirmLoginCallback);
    }

    public void cancelQRCodeLogined(String str, final OnQrcodeConfirmLoginCallback onQrcodeConfirmLoginCallback) {
        try {
            if (checkLocked()) {
                this.seq++;
                this.messageEncoder = new MessageEncoder();
                this.messageEncoder.setMessageHeader(MessageProcess.getMessageHeader((short) 7, (short) 6, this.clientInfo, this.seq));
                MessageProcess.putTlv0x4(this.messageEncoder, getGuid());
                MessageProcess.putTlv0x8(this.messageEncoder, this.clientInfo, NetworkManager.getAPNTypeString(this.mContext));
                MessageProcess.putTlv0x24(this.messageEncoder, str);
                String encode = RandomKeyDecryptor.encode(this.messageEncoder.getBufferArray(), RandomKeyDecryptor.getRandomKey());
                this.startTime = System.currentTimeMillis();
                Ajax ajax = new Ajax(1, AjaxUtil.getUrl(HttpConfig.LOGIN_METHOD, this.isDevelop), this.mContext);
                ajax.setRetryTimes(2);
                ajax.setRetryWithHttp(true);
                ajax.setParams(encode);
                ajax.send();
                ajax.setOnSuccessListener(new OnSuccessListener() {
                    public void onSuccess(String str) {
                        WJLoginHelper.this.bLocked = false;
                    }
                });
                ajax.setOnErrorListener(new OnErrorListener() {
                    public void onError(String str) {
                        WJLoginHelper.this.bLocked = false;
                        if (onQrcodeConfirmLoginCallback != null) {
                            onQrcodeConfirmLoginCallback.onError(str);
                        }
                    }
                });
            } else if (onQrcodeConfirmLoginCallback != null) {
                onQrcodeConfirmLoginCallback.onError(Config.makeErrMsg(Config.ERR_CODE_SDK_BLOCKED, Config.ERR_MSG_SDK_BLOCKED));
            }
        } catch (Exception e) {
            this.bLocked = false;
            e.printStackTrace();
            if (onQrcodeConfirmLoginCallback != null) {
                onQrcodeConfirmLoginCallback.onError(Config.makeErrMsg(Config.ERR_CODE_RESPONSE_DATA_ERR, Config.ERR_MSG_RESPONSE_DATA_ERR));
            }
        }
    }

    public void confirmQRCodeLogined(String str, String str2, String str3, final OnQrcodeConfirmLoginCallback onQrcodeConfirmLoginCallback) {
        try {
            if (checkLocked()) {
                this.seq++;
                this.messageEncoder = new MessageEncoder();
                this.messageEncoder.setMessageHeader(MessageProcess.getMessageHeader((short) 7, (short) 4, this.clientInfo, this.seq));
                MessageProcess.putTlv0x4(this.messageEncoder, getGuid());
                MessageProcess.putTlv0x8(this.messageEncoder, this.clientInfo, NetworkManager.getAPNTypeString(this.mContext));
                MessageProcess.putTlv0xa(this.messageEncoder, str2);
                MessageProcess.putTlv0x10(this.messageEncoder, str3);
                MessageProcess.putTlv0x24(this.messageEncoder, str);
                final String randomKey = RandomKeyDecryptor.getRandomKey();
                String encode = RandomKeyDecryptor.encode(this.messageEncoder.getBufferArray(), randomKey);
                this.startTime = System.currentTimeMillis();
                Ajax ajax = new Ajax(1, AjaxUtil.getUrl(HttpConfig.LOGIN_METHOD, this.isDevelop), this.mContext);
                ajax.setRetryTimes(2);
                ajax.setRetryWithHttp(true);
                ajax.setParams(encode);
                ajax.send();
                ajax.setOnSuccessListener(new OnSuccessListener() {
                    public void onSuccess(String str) {
                        WJLoginHelper.this.bLocked = false;
                        WJLoginHelper.this.confirmQRCodeLoginedSuccess(str, randomKey, onQrcodeConfirmLoginCallback);
                    }
                });
                ajax.setOnErrorListener(new OnErrorListener() {
                    public void onError(String str) {
                        WJLoginHelper.this.bLocked = false;
                        if (onQrcodeConfirmLoginCallback != null) {
                            onQrcodeConfirmLoginCallback.onError(str);
                        }
                        WJLoginHelper.this.reportLoginResult((byte) -1, (short) 7, (short) 4);
                    }
                });
            } else if (onQrcodeConfirmLoginCallback != null) {
                onQrcodeConfirmLoginCallback.onError(Config.makeErrMsg(Config.ERR_CODE_SDK_BLOCKED, Config.ERR_MSG_SDK_BLOCKED));
            }
        } catch (Exception e) {
            this.bLocked = false;
            e.printStackTrace();
            if (onQrcodeConfirmLoginCallback != null) {
                onQrcodeConfirmLoginCallback.onError(Config.makeErrMsg(Config.ERR_CODE_RESPONSE_DATA_ERR, Config.ERR_MSG_RESPONSE_DATA_ERR));
            }
        }
    }

    private void confirmQRCodeLoginedSuccess(String str, String str2, OnQrcodeConfirmLoginCallback onQrcodeConfirmLoginCallback) {
        try {
            MessageDecoder messageDecoder = new MessageDecoder(RandomKeyDecryptor.decode(str, str2));
            MessageHeader messageHeader = messageDecoder.getMessageHeader();
            TLV tlv = messageDecoder.getTLV();
            byte status = messageHeader.getStatus();
            if (checkSeq(messageHeader.getSeq())) {
                saveSoftfingerprint(tlv.getTlv0x37());
                if (status == (byte) 0) {
                    if (onQrcodeConfirmLoginCallback != null) {
                        onQrcodeConfirmLoginCallback.onSuccess();
                    }
                    reportLoginResult(status, (short) 7, (short) 4);
                    return;
                }
                FailResult failResult;
                QrCodeScannedResult qrCodeResult = getQrCodeResult(tlv.getTlv0x26(), tlv.getTlv0x22());
                tlv_0x3 tlv0x3 = tlv.getTlv0x3();
                if (tlv0x3 != null) {
                    failResult = getFailResult(status, tlv0x3);
                } else {
                    failResult = getDefualFailResult(status);
                }
                onQrcodeConfirmLoginCallback.onFail(failResult, qrCodeResult);
                reportLoginResult(status, (short) 7, (short) 4);
                return;
            }
            if (onQrcodeConfirmLoginCallback != null) {
                onQrcodeConfirmLoginCallback.onFail(getDefualFailResult(), null);
            }
            reportLoginResult((byte) -1, (short) 7, (short) 4);
        } catch (Exception e) {
            e.printStackTrace();
            if (onQrcodeConfirmLoginCallback != null) {
                onQrcodeConfirmLoginCallback.onFail(getDefualFailResult(), null);
            }
            reportLoginResult((byte) -2, (short) 7, (short) 4);
        }
    }

    public void h5BackToApp(String str, final OnCommonCallback onCommonCallback) {
        try {
            if (checkLocked()) {
                this.seq++;
                this.messageEncoder = new MessageEncoder();
                this.messageEncoder.setMessageHeader(MessageProcess.getMessageHeader((short) 2, (short) 12, this.clientInfo, this.seq));
                MessageProcess.putTlv0x11(this.messageEncoder, str);
                final String randomKey = RandomKeyDecryptor.getRandomKey();
                String encode = RandomKeyDecryptor.encode(this.messageEncoder.getBufferArray(), randomKey);
                this.startTime = System.currentTimeMillis();
                Ajax ajax = new Ajax(1, AjaxUtil.getUrl(HttpConfig.LOGIN_METHOD, this.isDevelop), this.mContext);
                ajax.setRetryTimes(2);
                ajax.setRetryWithHttp(true);
                ajax.setParams(encode);
                ajax.send();
                ajax.setOnSuccessListener(new OnSuccessListener() {
                    public void onSuccess(String str) {
                        WJLoginHelper.this.bLocked = false;
                        WJLoginHelper.this.h5BackToAppSuccess(str, randomKey, onCommonCallback);
                    }
                });
                ajax.setOnErrorListener(new OnErrorListener() {
                    public void onError(String str) {
                        WJLoginHelper.this.bLocked = false;
                        if (onCommonCallback != null) {
                            onCommonCallback.onError(str);
                        }
                        WJLoginHelper.this.reportLoginResult((byte) -1, (short) 2, (short) 12);
                    }
                });
            } else if (onCommonCallback != null) {
                onCommonCallback.onError(Config.makeErrMsg(Config.ERR_CODE_SDK_BLOCKED, Config.ERR_MSG_SDK_BLOCKED));
            }
        } catch (Exception e) {
            this.bLocked = false;
            e.printStackTrace();
            if (onCommonCallback != null) {
                onCommonCallback.onError(Config.makeErrMsg(Config.ERR_CODE_RESPONSE_DATA_ERR, Config.ERR_MSG_RESPONSE_DATA_ERR));
            }
        }
    }

    private void h5BackToAppSuccess(String str, String str2, OnCommonCallback onCommonCallback) {
        try {
            MessageDecoder messageDecoder = new MessageDecoder(RandomKeyDecryptor.decode(str, str2));
            MessageHeader messageHeader = messageDecoder.getMessageHeader();
            TLV tlv = messageDecoder.getTLV();
            byte status = messageHeader.getStatus();
            if (!checkSeq(messageHeader.getSeq())) {
                if (onCommonCallback != null) {
                    onCommonCallback.onFail(getDefualFailResult());
                }
                reportLoginResult((byte) -1, (short) 2, (short) 12);
            } else if (status == (byte) 0) {
                if (onCommonCallback != null) {
                    SaveUserInfo(tlv, null, null, Boolean.valueOf(false));
                    onCommonCallback.onSuccess();
                }
                reportLoginResult(status, (short) 2, (short) 12);
            } else {
                FailResult failResult;
                tlv_0x3 tlv0x3 = tlv.getTlv0x3();
                if (tlv0x3 != null) {
                    failResult = getFailResult(status, tlv0x3);
                } else {
                    failResult = getDefualFailResult(status);
                }
                onCommonCallback.onFail(failResult);
                reportLoginResult(status, (short) 2, (short) 12);
            }
        } catch (Exception e) {
            e.printStackTrace();
            if (onCommonCallback != null) {
                onCommonCallback.onFail(getDefualFailResult());
            }
            reportLoginResult((byte) -2, (short) 2, (short) 12);
        }
    }

    public void registJumpToM(final OnRegistJumpToMCallback onRegistJumpToMCallback) {
        try {
            if (checkLocked()) {
                this.seq++;
                this.messageEncoder = new MessageEncoder();
                this.messageEncoder.setMessageHeader(MessageProcess.getMessageHeader((short) 4, (short) 9, this.clientInfo, this.seq));
                MessageProcess.putTlv0x4(this.messageEncoder, getGuid());
                MessageProcess.putTlv0x8(this.messageEncoder, this.clientInfo, NetworkManager.getAPNTypeString(this.mContext));
                final String randomKey = RandomKeyDecryptor.getRandomKey();
                String encode = RandomKeyDecryptor.encode(this.messageEncoder.getBufferArray(), randomKey);
                this.startTime = System.currentTimeMillis();
                Ajax ajax = new Ajax(1, AjaxUtil.getUrl(HttpConfig.LOGIN_METHOD, this.isDevelop), this.mContext);
                ajax.setRetryTimes(2);
                ajax.setRetryWithHttp(true);
                ajax.setParams(encode);
                ajax.send();
                ajax.setOnSuccessListener(new OnSuccessListener() {
                    public void onSuccess(String str) {
                        WJLoginHelper.this.bLocked = false;
                        WJLoginHelper.this.registJumpToMSuccess(str, randomKey, onRegistJumpToMCallback);
                    }
                });
                ajax.setOnErrorListener(new OnErrorListener() {
                    public void onError(String str) {
                        WJLoginHelper.this.bLocked = false;
                        if (onRegistJumpToMCallback != null) {
                            onRegistJumpToMCallback.onError(str);
                        }
                        WJLoginHelper.this.reportLoginResult((byte) -1, (short) 2, (short) 12);
                    }
                });
            } else if (onRegistJumpToMCallback != null) {
                onRegistJumpToMCallback.onError(Config.makeErrMsg(Config.ERR_CODE_SDK_BLOCKED, Config.ERR_MSG_SDK_BLOCKED));
            }
        } catch (Exception e) {
            this.bLocked = false;
            e.printStackTrace();
            if (onRegistJumpToMCallback != null) {
                onRegistJumpToMCallback.onError(Config.makeErrMsg(Config.ERR_CODE_RESPONSE_DATA_ERR, Config.ERR_MSG_RESPONSE_DATA_ERR));
            }
        }
    }

    private void registJumpToMSuccess(String str, String str2, OnRegistJumpToMCallback onRegistJumpToMCallback) {
        try {
            MessageDecoder messageDecoder = new MessageDecoder(RandomKeyDecryptor.decode(str, str2));
            MessageHeader messageHeader = messageDecoder.getMessageHeader();
            TLV tlv = messageDecoder.getTLV();
            byte status = messageHeader.getStatus();
            if (!checkSeq(messageHeader.getSeq())) {
                if (onRegistJumpToMCallback != null) {
                    onRegistJumpToMCallback.onFail(getDefualFailResult());
                }
                reportLoginResult((byte) -1, (short) 2, (short) 12);
            } else if (status == (byte) 0) {
                String url = tlv.getTlv0x1e().getUrl();
                if (onRegistJumpToMCallback != null) {
                    onRegistJumpToMCallback.onSuccess(url);
                }
                reportLoginResult(status, (short) 2, (short) 12);
            } else {
                FailResult failResult;
                tlv_0x3 tlv0x3 = tlv.getTlv0x3();
                if (tlv0x3 != null) {
                    failResult = getFailResult(status, tlv0x3);
                } else {
                    failResult = getDefualFailResult(status);
                }
                onRegistJumpToMCallback.onFail(failResult);
                reportLoginResult(status, (short) 2, (short) 12);
            }
        } catch (Exception e) {
            e.printStackTrace();
            if (onRegistJumpToMCallback != null) {
                onRegistJumpToMCallback.onFail(getDefualFailResult());
            }
            reportLoginResult((byte) -2, (short) 2, (short) 12);
        }
    }

    public void sendMsgCodeForPhoneNumLogin(String str, final OnSendMsgCodeCallback onSendMsgCodeCallback) {
        try {
            if (checkLocked()) {
                this.seq++;
                this.messageEncoder = new MessageEncoder();
                this.messageEncoder.setMessageHeader(MessageProcess.getMessageHeader((short) 11, (short) 1, this.clientInfo, this.seq));
                MessageProcess.putTlv0x4(this.messageEncoder, getGuid());
                MessageProcess.putTlv0x8(this.messageEncoder, this.clientInfo, NetworkManager.getAPNTypeString(this.mContext));
                MessageProcess.putTlv0x19(this.messageEncoder, str);
                final String randomKey = RandomKeyDecryptor.getRandomKey();
                String encode = RandomKeyDecryptor.encode(this.messageEncoder.getBufferArray(), randomKey);
                this.startTime = System.currentTimeMillis();
                Ajax ajax = new Ajax(1, AjaxUtil.getUrl(HttpConfig.LOGIN_METHOD, this.isDevelop), this.mContext);
                ajax.setRetryTimes(2);
                ajax.setRetryWithHttp(true);
                ajax.setParams(encode);
                ajax.send();
                ajax.setOnSuccessListener(new OnSuccessListener() {
                    public void onSuccess(String str) {
                        WJLoginHelper.this.bLocked = false;
                        WJLoginHelper.this.sendMsgCodeSuccess(str, randomKey, onSendMsgCodeCallback);
                    }
                });
                ajax.setOnErrorListener(new OnErrorListener() {
                    public void onError(String str) {
                        WJLoginHelper.this.bLocked = false;
                        if (onSendMsgCodeCallback != null) {
                            onSendMsgCodeCallback.onError(str);
                        }
                        WJLoginHelper.this.reportLoginResult((byte) -1, (short) 2, (short) 12);
                    }
                });
            } else if (onSendMsgCodeCallback != null) {
                onSendMsgCodeCallback.onError(Config.makeErrMsg(Config.ERR_CODE_SDK_BLOCKED, Config.ERR_MSG_SDK_BLOCKED));
            }
        } catch (Exception e) {
            this.bLocked = false;
            e.printStackTrace();
            if (onSendMsgCodeCallback != null) {
                onSendMsgCodeCallback.onError(Config.makeErrMsg(Config.ERR_CODE_RESPONSE_DATA_ERR, Config.ERR_MSG_RESPONSE_DATA_ERR));
            }
        }
    }

    private void sendMsgCodeSuccess(String str, String str2, OnSendMsgCodeCallback onSendMsgCodeCallback) {
        try {
            MessageDecoder messageDecoder = new MessageDecoder(RandomKeyDecryptor.decode(str, str2));
            MessageHeader messageHeader = messageDecoder.getMessageHeader();
            TLV tlv = messageDecoder.getTLV();
            byte status = messageHeader.getStatus();
            if (!checkSeq(messageHeader.getSeq())) {
                if (onSendMsgCodeCallback != null) {
                    onSendMsgCodeCallback.onFail(getDefualFailResult());
                }
                reportLoginResult((byte) -1, (short) 2, (short) 12);
            } else if (status == (byte) 0) {
                if (onSendMsgCodeCallback != null) {
                    onSendMsgCodeCallback.onSuccess(tlv.getTlv0x1b().getMessagePwdExpireTime());
                }
                reportLoginResult(status, (short) 4, (short) 1);
            } else {
                FailResult failResult;
                tlv_0x3 tlv0x3 = tlv.getTlv0x3();
                tlv_0x15 tlv0x15 = tlv.getTlv0x15();
                tlv_0x1b tlv0x1b = tlv.getTlv0x1b();
                if (tlv0x3 != null) {
                    failResult = getFailResult(status, tlv0x3);
                } else {
                    failResult = getDefualFailResult(status);
                }
                if (tlv0x15 != null) {
                    failResult.setDwLimitTime(tlv0x15.getDwLimitTime());
                }
                if (tlv0x1b != null) {
                    failResult.setDwLimitTime(tlv0x1b.getMessagePwdExpireTime());
                }
                if (onSendMsgCodeCallback != null) {
                    onSendMsgCodeCallback.onFail(failResult);
                }
                reportLoginResult(status, (short) 4, (short) 1);
            }
        } catch (Exception e) {
            e.printStackTrace();
            if (onSendMsgCodeCallback != null) {
                onSendMsgCodeCallback.onFail(getDefualFailResult());
            }
            reportLoginResult((byte) -2, (short) 2, (short) 12);
        }
    }

    public void checkMsgCodeAndLogin(final String str, String str2, final OnPhoneNumLoginCallback onPhoneNumLoginCallback) {
        try {
            if (checkLocked()) {
                this.seq++;
                this.messageEncoder = new MessageEncoder();
                this.messageEncoder.setMessageHeader(MessageProcess.getMessageHeader((short) 11, (short) 2, this.clientInfo, this.seq));
                MessageProcess.putTlv0x4(this.messageEncoder, getGuid());
                MessageProcess.putTlv0x8(this.messageEncoder, this.clientInfo, NetworkManager.getAPNTypeString(this.mContext));
                MessageProcess.putTlv0x19(this.messageEncoder, str);
                MessageProcess.putTlv0x1a(this.messageEncoder, str2);
                final String randomKey = RandomKeyDecryptor.getRandomKey();
                String encode = RandomKeyDecryptor.encode(this.messageEncoder.getBufferArray(), randomKey);
                this.startTime = System.currentTimeMillis();
                Ajax ajax = new Ajax(1, AjaxUtil.getUrl(HttpConfig.LOGIN_METHOD, this.isDevelop), this.mContext);
                ajax.setRetryTimes(2);
                ajax.setRetryWithHttp(true);
                ajax.setParams(encode);
                ajax.send();
                ajax.setOnSuccessListener(new OnSuccessListener() {
                    public void onSuccess(String str) {
                        WJLoginHelper.this.bLocked = false;
                        WJLoginHelper.this.checkMsgCodeAndLoginSuccess(str, str, randomKey, onPhoneNumLoginCallback);
                    }
                });
                ajax.setOnErrorListener(new OnErrorListener() {
                    public void onError(String str) {
                        WJLoginHelper.this.bLocked = false;
                        if (onPhoneNumLoginCallback != null) {
                            onPhoneNumLoginCallback.onError(str);
                        }
                        WJLoginHelper.this.reportLoginResult((byte) -1, (short) 2, (short) 12);
                    }
                });
            } else if (onPhoneNumLoginCallback != null) {
                onPhoneNumLoginCallback.onError(Config.makeErrMsg(Config.ERR_CODE_SDK_BLOCKED, Config.ERR_MSG_SDK_BLOCKED));
            }
        } catch (Exception e) {
            this.bLocked = false;
            e.printStackTrace();
            if (onPhoneNumLoginCallback != null) {
                onPhoneNumLoginCallback.onError(Config.makeErrMsg(Config.ERR_CODE_RESPONSE_DATA_ERR, Config.ERR_MSG_RESPONSE_DATA_ERR));
            }
        }
    }

    private void checkMsgCodeAndLoginSuccess(String str, String str2, String str3, OnPhoneNumLoginCallback onPhoneNumLoginCallback) {
        try {
            MessageDecoder messageDecoder = new MessageDecoder(RandomKeyDecryptor.decode(str2, str3));
            MessageHeader messageHeader = messageDecoder.getMessageHeader();
            TLV tlv = messageDecoder.getTLV();
            byte status = messageHeader.getStatus();
            if (!checkSeq(messageHeader.getSeq())) {
                if (onPhoneNumLoginCallback != null) {
                    onPhoneNumLoginCallback.onFail(getDefualFailResult());
                }
                reportLoginResult((byte) -1, (short) 2, (short) 12);
            } else if (status == (byte) 0) {
                SaveUserInfo(tlv, str, null, Boolean.valueOf(false));
                if (TextUtils.isEmpty(getA2()) || TextUtils.isEmpty(getPin())) {
                    if (onPhoneNumLoginCallback != null) {
                        onPhoneNumLoginCallback.onError(Config.makeErrMsg(Config.ERR_CODE_RESPONSE_DATA_ERR, Config.ERR_MSG_RESPONSE_DATA_ERR));
                    }
                    reportLoginResult((byte) -2, (short) 2, (short) 6);
                    return;
                }
                if (onPhoneNumLoginCallback != null) {
                    onPhoneNumLoginCallback.onSuccess();
                }
                reportLoginResult(str, status, (short) 2, (short) 6);
            } else {
                FailResult failResult;
                tlv_0x3 tlv0x3 = tlv.getTlv0x3();
                if (tlv0x3 != null) {
                    failResult = getFailResult(status, tlv0x3);
                } else {
                    failResult = getDefualFailResult(status);
                }
                onPhoneNumLoginCallback.onFail(failResult);
                System.out.println("onFail");
                reportLoginResult(str, status, (short) 2, (short) 6);
            }
        } catch (Exception e) {
            e.printStackTrace();
            if (onPhoneNumLoginCallback != null) {
                onPhoneNumLoginCallback.onFail(getDefualFailResult());
            }
            reportLoginResult((byte) -2, (short) 2, (short) 12);
        }
    }
}
