package org.apache.http.impl.auth;

import java.security.Key;
import java.security.MessageDigest;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Locale;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import jd.wjlogin_sdk.util.ReplyCode;
import org.apache.commons.codec.binary.Base64;
import org.apache.http.annotation.NotThreadSafe;
import org.apache.http.util.EncodingUtils;

@NotThreadSafe
/* compiled from: TbsSdkJava */
final class NTLMEngineImpl implements NTLMEngine {
    static final String DEFAULT_CHARSET = "ASCII";
    protected static final int FLAG_DOMAIN_PRESENT = 4096;
    protected static final int FLAG_REQUEST_128BIT_KEY_EXCH = 536870912;
    protected static final int FLAG_REQUEST_56BIT_ENCRYPTION = Integer.MIN_VALUE;
    protected static final int FLAG_REQUEST_ALWAYS_SIGN = 32768;
    protected static final int FLAG_REQUEST_EXPLICIT_KEY_EXCH = 1073741824;
    protected static final int FLAG_REQUEST_LAN_MANAGER_KEY = 128;
    protected static final int FLAG_REQUEST_NTLM2_SESSION = 524288;
    protected static final int FLAG_REQUEST_NTLMv1 = 512;
    protected static final int FLAG_REQUEST_SEAL = 32;
    protected static final int FLAG_REQUEST_SIGN = 16;
    protected static final int FLAG_REQUEST_TARGET = 4;
    protected static final int FLAG_REQUEST_UNICODE_ENCODING = 1;
    protected static final int FLAG_REQUEST_VERSION = 33554432;
    protected static final int FLAG_TARGETINFO_PRESENT = 8388608;
    protected static final int FLAG_WORKSTATION_PRESENT = 8192;
    private static final SecureRandom RND_GEN;
    private static final byte[] SIGNATURE;
    private String credentialCharset = "ASCII";

    /* compiled from: TbsSdkJava */
    protected static class CipherGen {
        protected final byte[] challenge;
        protected byte[] clientChallenge;
        protected byte[] clientChallenge2;
        protected final String domain;
        protected byte[] lanManagerSessionKey;
        protected byte[] lm2SessionResponse;
        protected byte[] lmHash;
        protected byte[] lmResponse;
        protected byte[] lmUserSessionKey;
        protected byte[] lmv2Hash;
        protected byte[] lmv2Response;
        protected byte[] ntlm2SessionResponse;
        protected byte[] ntlm2SessionResponseUserSessionKey;
        protected byte[] ntlmHash;
        protected byte[] ntlmResponse;
        protected byte[] ntlmUserSessionKey;
        protected byte[] ntlmv2Blob;
        protected byte[] ntlmv2Hash;
        protected byte[] ntlmv2Response;
        protected byte[] ntlmv2UserSessionKey;
        protected final String password;
        protected byte[] secondaryKey;
        protected final String target;
        protected final byte[] targetInformation;
        protected byte[] timestamp;
        protected final String user;

        public CipherGen(String str, String str2, String str3, byte[] bArr, String str4, byte[] bArr2, byte[] bArr3, byte[] bArr4, byte[] bArr5, byte[] bArr6) {
            this.lmHash = null;
            this.lmResponse = null;
            this.ntlmHash = null;
            this.ntlmResponse = null;
            this.ntlmv2Hash = null;
            this.lmv2Hash = null;
            this.lmv2Response = null;
            this.ntlmv2Blob = null;
            this.ntlmv2Response = null;
            this.ntlm2SessionResponse = null;
            this.lm2SessionResponse = null;
            this.lmUserSessionKey = null;
            this.ntlmUserSessionKey = null;
            this.ntlmv2UserSessionKey = null;
            this.ntlm2SessionResponseUserSessionKey = null;
            this.lanManagerSessionKey = null;
            this.domain = str;
            this.target = str4;
            this.user = str2;
            this.password = str3;
            this.challenge = bArr;
            this.targetInformation = bArr2;
            this.clientChallenge = bArr3;
            this.clientChallenge2 = bArr4;
            this.secondaryKey = bArr5;
            this.timestamp = bArr6;
        }

        public CipherGen(String str, String str2, String str3, byte[] bArr, String str4, byte[] bArr2) {
            this(str, str2, str3, bArr, str4, bArr2, null, null, null, null);
        }

        public byte[] getClientChallenge() throws NTLMEngineException {
            if (this.clientChallenge == null) {
                this.clientChallenge = NTLMEngineImpl.makeRandomChallenge();
            }
            return this.clientChallenge;
        }

        public byte[] getClientChallenge2() throws NTLMEngineException {
            if (this.clientChallenge2 == null) {
                this.clientChallenge2 = NTLMEngineImpl.makeRandomChallenge();
            }
            return this.clientChallenge2;
        }

        public byte[] getSecondaryKey() throws NTLMEngineException {
            if (this.secondaryKey == null) {
                this.secondaryKey = NTLMEngineImpl.makeSecondaryKey();
            }
            return this.secondaryKey;
        }

        public byte[] getLMHash() throws NTLMEngineException {
            if (this.lmHash == null) {
                this.lmHash = NTLMEngineImpl.lmHash(this.password);
            }
            return this.lmHash;
        }

        public byte[] getLMResponse() throws NTLMEngineException {
            if (this.lmResponse == null) {
                this.lmResponse = NTLMEngineImpl.lmResponse(getLMHash(), this.challenge);
            }
            return this.lmResponse;
        }

        public byte[] getNTLMHash() throws NTLMEngineException {
            if (this.ntlmHash == null) {
                this.ntlmHash = NTLMEngineImpl.ntlmHash(this.password);
            }
            return this.ntlmHash;
        }

        public byte[] getNTLMResponse() throws NTLMEngineException {
            if (this.ntlmResponse == null) {
                this.ntlmResponse = NTLMEngineImpl.lmResponse(getNTLMHash(), this.challenge);
            }
            return this.ntlmResponse;
        }

        public byte[] getLMv2Hash() throws NTLMEngineException {
            if (this.lmv2Hash == null) {
                this.lmv2Hash = NTLMEngineImpl.lmv2Hash(this.domain, this.user, getNTLMHash());
            }
            return this.lmv2Hash;
        }

        public byte[] getNTLMv2Hash() throws NTLMEngineException {
            if (this.ntlmv2Hash == null) {
                this.ntlmv2Hash = NTLMEngineImpl.ntlmv2Hash(this.domain, this.user, getNTLMHash());
            }
            return this.ntlmv2Hash;
        }

        public byte[] getTimestamp() {
            if (this.timestamp == null) {
                long currentTimeMillis = 10000 * (System.currentTimeMillis() + 11644473600000L);
                this.timestamp = new byte[8];
                for (int i = 0; i < 8; i++) {
                    this.timestamp[i] = (byte) ((int) currentTimeMillis);
                    currentTimeMillis >>>= 8;
                }
            }
            return this.timestamp;
        }

        public byte[] getNTLMv2Blob() throws NTLMEngineException {
            if (this.ntlmv2Blob == null) {
                this.ntlmv2Blob = NTLMEngineImpl.createBlob(getClientChallenge2(), this.targetInformation, getTimestamp());
            }
            return this.ntlmv2Blob;
        }

        public byte[] getNTLMv2Response() throws NTLMEngineException {
            if (this.ntlmv2Response == null) {
                this.ntlmv2Response = NTLMEngineImpl.lmv2Response(getNTLMv2Hash(), this.challenge, getNTLMv2Blob());
            }
            return this.ntlmv2Response;
        }

        public byte[] getLMv2Response() throws NTLMEngineException {
            if (this.lmv2Response == null) {
                this.lmv2Response = NTLMEngineImpl.lmv2Response(getLMv2Hash(), this.challenge, getClientChallenge());
            }
            return this.lmv2Response;
        }

        public byte[] getNTLM2SessionResponse() throws NTLMEngineException {
            if (this.ntlm2SessionResponse == null) {
                this.ntlm2SessionResponse = NTLMEngineImpl.ntlm2SessionResponse(getNTLMHash(), this.challenge, getClientChallenge());
            }
            return this.ntlm2SessionResponse;
        }

        public byte[] getLM2SessionResponse() throws NTLMEngineException {
            if (this.lm2SessionResponse == null) {
                Object clientChallenge = getClientChallenge();
                this.lm2SessionResponse = new byte[24];
                System.arraycopy(clientChallenge, 0, this.lm2SessionResponse, 0, clientChallenge.length);
                Arrays.fill(this.lm2SessionResponse, clientChallenge.length, this.lm2SessionResponse.length, (byte) 0);
            }
            return this.lm2SessionResponse;
        }

        public byte[] getLMUserSessionKey() throws NTLMEngineException {
            if (this.lmUserSessionKey == null) {
                this.lmUserSessionKey = new byte[16];
                System.arraycopy(getLMHash(), 0, this.lmUserSessionKey, 0, 8);
                Arrays.fill(this.lmUserSessionKey, 8, 16, (byte) 0);
            }
            return this.lmUserSessionKey;
        }

        public byte[] getNTLMUserSessionKey() throws NTLMEngineException {
            if (this.ntlmUserSessionKey == null) {
                MD4 md4 = new MD4();
                md4.update(getNTLMHash());
                this.ntlmUserSessionKey = md4.getOutput();
            }
            return this.ntlmUserSessionKey;
        }

        public byte[] getNTLMv2UserSessionKey() throws NTLMEngineException {
            if (this.ntlmv2UserSessionKey == null) {
                byte[] nTLMv2Hash = getNTLMv2Hash();
                Object obj = new byte[16];
                System.arraycopy(getNTLMv2Response(), 0, obj, 0, 16);
                this.ntlmv2UserSessionKey = NTLMEngineImpl.hmacMD5(obj, nTLMv2Hash);
            }
            return this.ntlmv2UserSessionKey;
        }

        public byte[] getNTLM2SessionResponseUserSessionKey() throws NTLMEngineException {
            if (this.ntlm2SessionResponseUserSessionKey == null) {
                Object lM2SessionResponse = getLM2SessionResponse();
                Object obj = new byte[(this.challenge.length + lM2SessionResponse.length)];
                System.arraycopy(this.challenge, 0, obj, 0, this.challenge.length);
                System.arraycopy(lM2SessionResponse, 0, obj, this.challenge.length, lM2SessionResponse.length);
                this.ntlm2SessionResponseUserSessionKey = NTLMEngineImpl.hmacMD5(obj, getNTLMUserSessionKey());
            }
            return this.ntlm2SessionResponseUserSessionKey;
        }

        public byte[] getLanManagerSessionKey() throws NTLMEngineException {
            if (this.lanManagerSessionKey == null) {
                try {
                    Object obj = new byte[14];
                    System.arraycopy(getLMHash(), 0, obj, 0, 8);
                    Arrays.fill(obj, 8, obj.length, (byte) -67);
                    Key access$900 = NTLMEngineImpl.createDESKey(obj, 0);
                    Key access$9002 = NTLMEngineImpl.createDESKey(obj, 7);
                    Object obj2 = new byte[8];
                    System.arraycopy(getLMResponse(), 0, obj2, 0, obj2.length);
                    Cipher instance = Cipher.getInstance("DES/ECB/NoPadding");
                    instance.init(1, access$900);
                    Object doFinal = instance.doFinal(obj2);
                    instance = Cipher.getInstance("DES/ECB/NoPadding");
                    instance.init(1, access$9002);
                    obj = instance.doFinal(obj2);
                    this.lanManagerSessionKey = new byte[16];
                    System.arraycopy(doFinal, 0, this.lanManagerSessionKey, 0, doFinal.length);
                    System.arraycopy(obj, 0, this.lanManagerSessionKey, doFinal.length, obj.length);
                } catch (Throwable e) {
                    throw new NTLMEngineException(e.getMessage(), e);
                }
            }
            return this.lanManagerSessionKey;
        }
    }

    /* compiled from: TbsSdkJava */
    static class HMACMD5 {
        protected byte[] ipad;
        protected MessageDigest md5;
        protected byte[] opad;

        HMACMD5(byte[] bArr) throws NTLMEngineException {
            try {
                this.md5 = MessageDigest.getInstance("MD5");
                this.ipad = new byte[64];
                this.opad = new byte[64];
                int length = bArr.length;
                if (length > 64) {
                    this.md5.update(bArr);
                    bArr = this.md5.digest();
                    length = bArr.length;
                }
                int i = 0;
                while (i < length) {
                    this.ipad[i] = (byte) (bArr[i] ^ 54);
                    this.opad[i] = (byte) (bArr[i] ^ 92);
                    i++;
                }
                for (length = i; length < 64; length++) {
                    this.ipad[length] = ReplyCode.reply0x36;
                    this.opad[length] = (byte) 92;
                }
                this.md5.reset();
                this.md5.update(this.ipad);
            } catch (Throwable e) {
                throw new NTLMEngineException("Error getting md5 message digest implementation: " + e.getMessage(), e);
            }
        }

        byte[] getOutput() {
            byte[] digest = this.md5.digest();
            this.md5.update(this.opad);
            return this.md5.digest(digest);
        }

        void update(byte[] bArr) {
            this.md5.update(bArr);
        }

        void update(byte[] bArr, int i, int i2) {
            this.md5.update(bArr, i, i2);
        }
    }

    /* compiled from: TbsSdkJava */
    static class MD4 {
        protected int A = 1732584193;
        protected int B = -271733879;
        protected int C = -1732584194;
        protected int D = 271733878;
        protected long count = 0;
        protected byte[] dataBuffer = new byte[64];

        MD4() {
        }

        void update(byte[] bArr) {
            int i = (int) (this.count & 63);
            int i2 = 0;
            while ((bArr.length - i2) + i >= this.dataBuffer.length) {
                int length = this.dataBuffer.length - i;
                System.arraycopy(bArr, i2, this.dataBuffer, i, length);
                this.count += (long) length;
                i2 += length;
                processBuffer();
                i = 0;
            }
            if (i2 < bArr.length) {
                int length2 = bArr.length - i2;
                System.arraycopy(bArr, i2, this.dataBuffer, i, length2);
                this.count += (long) length2;
                i2 = i + length2;
            }
        }

        byte[] getOutput() {
            int i = (int) (this.count & 63);
            i = i < 56 ? 56 - i : 120 - i;
            byte[] bArr = new byte[(i + 8)];
            bArr[0] = Byte.MIN_VALUE;
            for (int i2 = 0; i2 < 8; i2++) {
                bArr[i + i2] = (byte) ((int) ((this.count * 8) >>> (i2 * 8)));
            }
            update(bArr);
            byte[] bArr2 = new byte[16];
            NTLMEngineImpl.writeULong(bArr2, this.A, 0);
            NTLMEngineImpl.writeULong(bArr2, this.B, 4);
            NTLMEngineImpl.writeULong(bArr2, this.C, 8);
            NTLMEngineImpl.writeULong(bArr2, this.D, 12);
            return bArr2;
        }

        protected void processBuffer() {
            int i;
            int[] iArr = new int[16];
            for (i = 0; i < 16; i++) {
                iArr[i] = (((this.dataBuffer[i * 4] & 255) + ((this.dataBuffer[(i * 4) + 1] & 255) << 8)) + ((this.dataBuffer[(i * 4) + 2] & 255) << 16)) + ((this.dataBuffer[(i * 4) + 3] & 255) << 24);
            }
            i = this.A;
            int i2 = this.B;
            int i3 = this.C;
            int i4 = this.D;
            round1(iArr);
            round2(iArr);
            round3(iArr);
            this.A = i + this.A;
            this.B += i2;
            this.C += i3;
            this.D += i4;
        }

        protected void round1(int[] iArr) {
            this.A = NTLMEngineImpl.rotintlft((this.A + NTLMEngineImpl.F(this.B, this.C, this.D)) + iArr[0], 3);
            this.D = NTLMEngineImpl.rotintlft((this.D + NTLMEngineImpl.F(this.A, this.B, this.C)) + iArr[1], 7);
            this.C = NTLMEngineImpl.rotintlft((this.C + NTLMEngineImpl.F(this.D, this.A, this.B)) + iArr[2], 11);
            this.B = NTLMEngineImpl.rotintlft((this.B + NTLMEngineImpl.F(this.C, this.D, this.A)) + iArr[3], 19);
            this.A = NTLMEngineImpl.rotintlft((this.A + NTLMEngineImpl.F(this.B, this.C, this.D)) + iArr[4], 3);
            this.D = NTLMEngineImpl.rotintlft((this.D + NTLMEngineImpl.F(this.A, this.B, this.C)) + iArr[5], 7);
            this.C = NTLMEngineImpl.rotintlft((this.C + NTLMEngineImpl.F(this.D, this.A, this.B)) + iArr[6], 11);
            this.B = NTLMEngineImpl.rotintlft((this.B + NTLMEngineImpl.F(this.C, this.D, this.A)) + iArr[7], 19);
            this.A = NTLMEngineImpl.rotintlft((this.A + NTLMEngineImpl.F(this.B, this.C, this.D)) + iArr[8], 3);
            this.D = NTLMEngineImpl.rotintlft((this.D + NTLMEngineImpl.F(this.A, this.B, this.C)) + iArr[9], 7);
            this.C = NTLMEngineImpl.rotintlft((this.C + NTLMEngineImpl.F(this.D, this.A, this.B)) + iArr[10], 11);
            this.B = NTLMEngineImpl.rotintlft((this.B + NTLMEngineImpl.F(this.C, this.D, this.A)) + iArr[11], 19);
            this.A = NTLMEngineImpl.rotintlft((this.A + NTLMEngineImpl.F(this.B, this.C, this.D)) + iArr[12], 3);
            this.D = NTLMEngineImpl.rotintlft((this.D + NTLMEngineImpl.F(this.A, this.B, this.C)) + iArr[13], 7);
            this.C = NTLMEngineImpl.rotintlft((this.C + NTLMEngineImpl.F(this.D, this.A, this.B)) + iArr[14], 11);
            this.B = NTLMEngineImpl.rotintlft((this.B + NTLMEngineImpl.F(this.C, this.D, this.A)) + iArr[15], 19);
        }

        protected void round2(int[] iArr) {
            this.A = NTLMEngineImpl.rotintlft(((this.A + NTLMEngineImpl.G(this.B, this.C, this.D)) + iArr[0]) + 1518500249, 3);
            this.D = NTLMEngineImpl.rotintlft(((this.D + NTLMEngineImpl.G(this.A, this.B, this.C)) + iArr[4]) + 1518500249, 5);
            this.C = NTLMEngineImpl.rotintlft(((this.C + NTLMEngineImpl.G(this.D, this.A, this.B)) + iArr[8]) + 1518500249, 9);
            this.B = NTLMEngineImpl.rotintlft(((this.B + NTLMEngineImpl.G(this.C, this.D, this.A)) + iArr[12]) + 1518500249, 13);
            this.A = NTLMEngineImpl.rotintlft(((this.A + NTLMEngineImpl.G(this.B, this.C, this.D)) + iArr[1]) + 1518500249, 3);
            this.D = NTLMEngineImpl.rotintlft(((this.D + NTLMEngineImpl.G(this.A, this.B, this.C)) + iArr[5]) + 1518500249, 5);
            this.C = NTLMEngineImpl.rotintlft(((this.C + NTLMEngineImpl.G(this.D, this.A, this.B)) + iArr[9]) + 1518500249, 9);
            this.B = NTLMEngineImpl.rotintlft(((this.B + NTLMEngineImpl.G(this.C, this.D, this.A)) + iArr[13]) + 1518500249, 13);
            this.A = NTLMEngineImpl.rotintlft(((this.A + NTLMEngineImpl.G(this.B, this.C, this.D)) + iArr[2]) + 1518500249, 3);
            this.D = NTLMEngineImpl.rotintlft(((this.D + NTLMEngineImpl.G(this.A, this.B, this.C)) + iArr[6]) + 1518500249, 5);
            this.C = NTLMEngineImpl.rotintlft(((this.C + NTLMEngineImpl.G(this.D, this.A, this.B)) + iArr[10]) + 1518500249, 9);
            this.B = NTLMEngineImpl.rotintlft(((this.B + NTLMEngineImpl.G(this.C, this.D, this.A)) + iArr[14]) + 1518500249, 13);
            this.A = NTLMEngineImpl.rotintlft(((this.A + NTLMEngineImpl.G(this.B, this.C, this.D)) + iArr[3]) + 1518500249, 3);
            this.D = NTLMEngineImpl.rotintlft(((this.D + NTLMEngineImpl.G(this.A, this.B, this.C)) + iArr[7]) + 1518500249, 5);
            this.C = NTLMEngineImpl.rotintlft(((this.C + NTLMEngineImpl.G(this.D, this.A, this.B)) + iArr[11]) + 1518500249, 9);
            this.B = NTLMEngineImpl.rotintlft(((this.B + NTLMEngineImpl.G(this.C, this.D, this.A)) + iArr[15]) + 1518500249, 13);
        }

        protected void round3(int[] iArr) {
            this.A = NTLMEngineImpl.rotintlft(((this.A + NTLMEngineImpl.H(this.B, this.C, this.D)) + iArr[0]) + 1859775393, 3);
            this.D = NTLMEngineImpl.rotintlft(((this.D + NTLMEngineImpl.H(this.A, this.B, this.C)) + iArr[8]) + 1859775393, 9);
            this.C = NTLMEngineImpl.rotintlft(((this.C + NTLMEngineImpl.H(this.D, this.A, this.B)) + iArr[4]) + 1859775393, 11);
            this.B = NTLMEngineImpl.rotintlft(((this.B + NTLMEngineImpl.H(this.C, this.D, this.A)) + iArr[12]) + 1859775393, 15);
            this.A = NTLMEngineImpl.rotintlft(((this.A + NTLMEngineImpl.H(this.B, this.C, this.D)) + iArr[2]) + 1859775393, 3);
            this.D = NTLMEngineImpl.rotintlft(((this.D + NTLMEngineImpl.H(this.A, this.B, this.C)) + iArr[10]) + 1859775393, 9);
            this.C = NTLMEngineImpl.rotintlft(((this.C + NTLMEngineImpl.H(this.D, this.A, this.B)) + iArr[6]) + 1859775393, 11);
            this.B = NTLMEngineImpl.rotintlft(((this.B + NTLMEngineImpl.H(this.C, this.D, this.A)) + iArr[14]) + 1859775393, 15);
            this.A = NTLMEngineImpl.rotintlft(((this.A + NTLMEngineImpl.H(this.B, this.C, this.D)) + iArr[1]) + 1859775393, 3);
            this.D = NTLMEngineImpl.rotintlft(((this.D + NTLMEngineImpl.H(this.A, this.B, this.C)) + iArr[9]) + 1859775393, 9);
            this.C = NTLMEngineImpl.rotintlft(((this.C + NTLMEngineImpl.H(this.D, this.A, this.B)) + iArr[5]) + 1859775393, 11);
            this.B = NTLMEngineImpl.rotintlft(((this.B + NTLMEngineImpl.H(this.C, this.D, this.A)) + iArr[13]) + 1859775393, 15);
            this.A = NTLMEngineImpl.rotintlft(((this.A + NTLMEngineImpl.H(this.B, this.C, this.D)) + iArr[3]) + 1859775393, 3);
            this.D = NTLMEngineImpl.rotintlft(((this.D + NTLMEngineImpl.H(this.A, this.B, this.C)) + iArr[11]) + 1859775393, 9);
            this.C = NTLMEngineImpl.rotintlft(((this.C + NTLMEngineImpl.H(this.D, this.A, this.B)) + iArr[7]) + 1859775393, 11);
            this.B = NTLMEngineImpl.rotintlft(((this.B + NTLMEngineImpl.H(this.C, this.D, this.A)) + iArr[15]) + 1859775393, 15);
        }
    }

    /* compiled from: TbsSdkJava */
    static class NTLMMessage {
        private int currentOutputPosition = 0;
        private byte[] messageContents = null;

        NTLMMessage() {
        }

        NTLMMessage(String str, int i) throws NTLMEngineException {
            int i2 = 0;
            this.messageContents = Base64.decodeBase64(EncodingUtils.getBytes(str, "ASCII"));
            if (this.messageContents.length < NTLMEngineImpl.SIGNATURE.length) {
                throw new NTLMEngineException("NTLM message decoding error - packet too short");
            }
            while (i2 < NTLMEngineImpl.SIGNATURE.length) {
                if (this.messageContents[i2] != NTLMEngineImpl.SIGNATURE[i2]) {
                    throw new NTLMEngineException("NTLM message expected - instead got unrecognized bytes");
                }
                i2++;
            }
            i2 = readULong(NTLMEngineImpl.SIGNATURE.length);
            if (i2 != i) {
                throw new NTLMEngineException("NTLM type " + Integer.toString(i) + " message expected - instead got type " + Integer.toString(i2));
            }
            this.currentOutputPosition = this.messageContents.length;
        }

        protected int getPreambleLength() {
            return NTLMEngineImpl.SIGNATURE.length + 4;
        }

        protected int getMessageLength() {
            return this.currentOutputPosition;
        }

        protected byte readByte(int i) throws NTLMEngineException {
            if (this.messageContents.length >= i + 1) {
                return this.messageContents[i];
            }
            throw new NTLMEngineException("NTLM: Message too short");
        }

        protected void readBytes(byte[] bArr, int i) throws NTLMEngineException {
            if (this.messageContents.length < bArr.length + i) {
                throw new NTLMEngineException("NTLM: Message too short");
            }
            System.arraycopy(this.messageContents, i, bArr, 0, bArr.length);
        }

        protected int readUShort(int i) throws NTLMEngineException {
            return NTLMEngineImpl.readUShort(this.messageContents, i);
        }

        protected int readULong(int i) throws NTLMEngineException {
            return NTLMEngineImpl.readULong(this.messageContents, i);
        }

        protected byte[] readSecurityBuffer(int i) throws NTLMEngineException {
            return NTLMEngineImpl.readSecurityBuffer(this.messageContents, i);
        }

        protected void prepareResponse(int i, int i2) {
            this.messageContents = new byte[i];
            this.currentOutputPosition = 0;
            addBytes(NTLMEngineImpl.SIGNATURE);
            addULong(i2);
        }

        protected void addByte(byte b) {
            this.messageContents[this.currentOutputPosition] = b;
            this.currentOutputPosition++;
        }

        protected void addBytes(byte[] bArr) {
            if (bArr != null) {
                for (byte b : bArr) {
                    this.messageContents[this.currentOutputPosition] = b;
                    this.currentOutputPosition++;
                }
            }
        }

        protected void addUShort(int i) {
            addByte((byte) (i & 255));
            addByte((byte) ((i >> 8) & 255));
        }

        protected void addULong(int i) {
            addByte((byte) (i & 255));
            addByte((byte) ((i >> 8) & 255));
            addByte((byte) ((i >> 16) & 255));
            addByte((byte) ((i >> 24) & 255));
        }

        String getResponse() {
            byte[] bArr;
            if (this.messageContents.length > this.currentOutputPosition) {
                bArr = new byte[this.currentOutputPosition];
                System.arraycopy(this.messageContents, 0, bArr, 0, this.currentOutputPosition);
            } else {
                bArr = this.messageContents;
            }
            return EncodingUtils.getAsciiString(Base64.encodeBase64(bArr));
        }
    }

    /* compiled from: TbsSdkJava */
    static class Type1Message extends NTLMMessage {
        protected byte[] domainBytes;
        protected byte[] hostBytes;

        Type1Message(String str, String str2) throws NTLMEngineException {
            byte[] bArr = null;
            try {
                String access$1400 = NTLMEngineImpl.convertHost(str2);
                String access$1500 = NTLMEngineImpl.convertDomain(str);
                this.hostBytes = access$1400 != null ? access$1400.getBytes("ASCII") : null;
                if (access$1500 != null) {
                    bArr = access$1500.toUpperCase(Locale.ENGLISH).getBytes("ASCII");
                }
                this.domainBytes = bArr;
            } catch (Throwable e) {
                throw new NTLMEngineException("Unicode unsupported: " + e.getMessage(), e);
            }
        }

        String getResponse() {
            prepareResponse(40, 1);
            addULong(-1576500735);
            addUShort(0);
            addUShort(0);
            addULong(40);
            addUShort(0);
            addUShort(0);
            addULong(40);
            addUShort(261);
            addULong(2600);
            addUShort(3840);
            return super.getResponse();
        }
    }

    /* compiled from: TbsSdkJava */
    static class Type2Message extends NTLMMessage {
        protected byte[] challenge = new byte[8];
        protected int flags;
        protected String target;
        protected byte[] targetInfo;

        Type2Message(String str) throws NTLMEngineException {
            super(str, 2);
            readBytes(this.challenge, 24);
            this.flags = readULong(20);
            if ((this.flags & 1) == 0) {
                throw new NTLMEngineException("NTLM type 2 message has flags that make no sense: " + Integer.toString(this.flags));
            }
            byte[] readSecurityBuffer;
            this.target = null;
            if (getMessageLength() >= 20) {
                readSecurityBuffer = readSecurityBuffer(12);
                if (readSecurityBuffer.length != 0) {
                    try {
                        this.target = new String(readSecurityBuffer, "UnicodeLittleUnmarked");
                    } catch (Throwable e) {
                        throw new NTLMEngineException(e.getMessage(), e);
                    }
                }
            }
            this.targetInfo = null;
            if (getMessageLength() >= 48) {
                readSecurityBuffer = readSecurityBuffer(40);
                if (readSecurityBuffer.length != 0) {
                    this.targetInfo = readSecurityBuffer;
                }
            }
        }

        byte[] getChallenge() {
            return this.challenge;
        }

        String getTarget() {
            return this.target;
        }

        byte[] getTargetInfo() {
            return this.targetInfo;
        }

        int getFlags() {
            return this.flags;
        }
    }

    /* compiled from: TbsSdkJava */
    static class Type3Message extends NTLMMessage {
        protected byte[] domainBytes;
        protected byte[] hostBytes;
        protected byte[] lmResp;
        protected byte[] ntResp;
        protected byte[] sessionKey;
        protected int type2Flags;
        protected byte[] userBytes;

        Type3Message(String str, String str2, String str3, String str4, byte[] bArr, int i, String str5, byte[] bArr2) throws NTLMEngineException {
            byte[] lanManagerSessionKey;
            byte[] bytes;
            this.type2Flags = i;
            String access$1400 = NTLMEngineImpl.convertHost(str2);
            String access$1500 = NTLMEngineImpl.convertDomain(str);
            CipherGen cipherGen = new CipherGen(access$1500, str3, str4, bArr, str5, bArr2);
            if ((8388608 & i) != 0 && bArr2 != null && str5 != null) {
                try {
                    this.ntResp = cipherGen.getNTLMv2Response();
                    this.lmResp = cipherGen.getLMv2Response();
                    if ((i & 128) != 0) {
                        lanManagerSessionKey = cipherGen.getLanManagerSessionKey();
                    } else {
                        lanManagerSessionKey = cipherGen.getNTLMv2UserSessionKey();
                    }
                } catch (NTLMEngineException e) {
                    this.ntResp = new byte[0];
                    this.lmResp = cipherGen.getLMResponse();
                    if ((i & 128) != 0) {
                        lanManagerSessionKey = cipherGen.getLanManagerSessionKey();
                    } else {
                        lanManagerSessionKey = cipherGen.getLMUserSessionKey();
                    }
                }
            } else if ((524288 & i) != 0) {
                this.ntResp = cipherGen.getNTLM2SessionResponse();
                this.lmResp = cipherGen.getLM2SessionResponse();
                if ((i & 128) != 0) {
                    lanManagerSessionKey = cipherGen.getLanManagerSessionKey();
                } else {
                    lanManagerSessionKey = cipherGen.getNTLM2SessionResponseUserSessionKey();
                }
            } else {
                this.ntResp = cipherGen.getNTLMResponse();
                this.lmResp = cipherGen.getLMResponse();
                if ((i & 128) != 0) {
                    lanManagerSessionKey = cipherGen.getLanManagerSessionKey();
                } else {
                    lanManagerSessionKey = cipherGen.getNTLMUserSessionKey();
                }
            }
            if ((i & 16) == 0) {
                this.sessionKey = null;
            } else if ((NTLMEngineImpl.FLAG_REQUEST_EXPLICIT_KEY_EXCH & i) != 0) {
                this.sessionKey = NTLMEngineImpl.RC4(cipherGen.getSecondaryKey(), lanManagerSessionKey);
            } else {
                this.sessionKey = lanManagerSessionKey;
            }
            if (access$1400 != null) {
                try {
                    bytes = access$1400.getBytes("UnicodeLittleUnmarked");
                } catch (Throwable e2) {
                    throw new NTLMEngineException("Unicode not supported: " + e2.getMessage(), e2);
                }
            }
            bytes = null;
            this.hostBytes = bytes;
            this.domainBytes = access$1500 != null ? access$1500.toUpperCase(Locale.ENGLISH).getBytes("UnicodeLittleUnmarked") : null;
            this.userBytes = str3.getBytes("UnicodeLittleUnmarked");
        }

        String getResponse() {
            int length;
            int i = 0;
            int length2 = this.ntResp.length;
            int length3 = this.lmResp.length;
            int length4 = this.domainBytes != null ? this.domainBytes.length : 0;
            if (this.hostBytes != null) {
                length = this.hostBytes.length;
            } else {
                length = 0;
            }
            int length5 = this.userBytes.length;
            if (this.sessionKey != null) {
                i = this.sessionKey.length;
            }
            int i2 = length3 + 72;
            int i3 = i2 + length2;
            int i4 = i3 + length4;
            int i5 = i4 + length5;
            int i6 = i5 + length;
            prepareResponse(i6 + i, 3);
            addUShort(length3);
            addUShort(length3);
            addULong(72);
            addUShort(length2);
            addUShort(length2);
            addULong(i2);
            addUShort(length4);
            addUShort(length4);
            addULong(i3);
            addUShort(length5);
            addUShort(length5);
            addULong(i4);
            addUShort(length);
            addUShort(length);
            addULong(i5);
            addUShort(i);
            addUShort(i);
            addULong(i6);
            addULong(((((((((((((this.type2Flags & 128) | (this.type2Flags & 512)) | (this.type2Flags & 524288)) | NTLMEngineImpl.FLAG_REQUEST_VERSION) | (this.type2Flags & 32768)) | (this.type2Flags & 32)) | (this.type2Flags & 16)) | (this.type2Flags & NTLMEngineImpl.FLAG_REQUEST_128BIT_KEY_EXCH)) | (this.type2Flags & Integer.MIN_VALUE)) | (this.type2Flags & NTLMEngineImpl.FLAG_REQUEST_EXPLICIT_KEY_EXCH)) | (this.type2Flags & 8388608)) | (this.type2Flags & 1)) | (this.type2Flags & 4));
            addUShort(261);
            addULong(2600);
            addUShort(3840);
            addBytes(this.lmResp);
            addBytes(this.ntResp);
            addBytes(this.domainBytes);
            addBytes(this.userBytes);
            addBytes(this.hostBytes);
            if (this.sessionKey != null) {
                addBytes(this.sessionKey);
            }
            return super.getResponse();
        }
    }

    NTLMEngineImpl() {
    }

    static {
        SecureRandom secureRandom = null;
        try {
            secureRandom = SecureRandom.getInstance("SHA1PRNG");
        } catch (Exception e) {
        }
        RND_GEN = secureRandom;
        Object bytes = EncodingUtils.getBytes("NTLMSSP", "ASCII");
        SIGNATURE = new byte[(bytes.length + 1)];
        System.arraycopy(bytes, 0, SIGNATURE, 0, bytes.length);
        SIGNATURE[bytes.length] = (byte) 0;
    }

    final String getResponseFor(String str, String str2, String str3, String str4, String str5) throws NTLMEngineException {
        if (str == null || str.trim().equals("")) {
            return getType1Message(str4, str5);
        }
        Type2Message type2Message = new Type2Message(str);
        return getType3Message(str2, str3, str4, str5, type2Message.getChallenge(), type2Message.getFlags(), type2Message.getTarget(), type2Message.getTargetInfo());
    }

    String getType1Message(String str, String str2) throws NTLMEngineException {
        return new Type1Message(str2, str).getResponse();
    }

    String getType3Message(String str, String str2, String str3, String str4, byte[] bArr, int i, String str5, byte[] bArr2) throws NTLMEngineException {
        return new Type3Message(str4, str3, str, str2, bArr, i, str5, bArr2).getResponse();
    }

    String getCredentialCharset() {
        return this.credentialCharset;
    }

    void setCredentialCharset(String str) {
        this.credentialCharset = str;
    }

    private static String stripDotSuffix(String str) {
        if (str == null) {
            return null;
        }
        int indexOf = str.indexOf(".");
        if (indexOf != -1) {
            return str.substring(0, indexOf);
        }
        return str;
    }

    private static String convertHost(String str) {
        return stripDotSuffix(str);
    }

    private static String convertDomain(String str) {
        return stripDotSuffix(str);
    }

    private static int readULong(byte[] bArr, int i) throws NTLMEngineException {
        if (bArr.length >= i + 4) {
            return (((bArr[i] & 255) | ((bArr[i + 1] & 255) << 8)) | ((bArr[i + 2] & 255) << 16)) | ((bArr[i + 3] & 255) << 24);
        }
        throw new NTLMEngineException("NTLM authentication - buffer too small for DWORD");
    }

    private static int readUShort(byte[] bArr, int i) throws NTLMEngineException {
        if (bArr.length >= i + 2) {
            return (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8);
        }
        throw new NTLMEngineException("NTLM authentication - buffer too small for WORD");
    }

    private static byte[] readSecurityBuffer(byte[] bArr, int i) throws NTLMEngineException {
        int readUShort = readUShort(bArr, i);
        int readULong = readULong(bArr, i + 4);
        if (bArr.length < readULong + readUShort) {
            throw new NTLMEngineException("NTLM authentication - buffer too small for data item");
        }
        Object obj = new byte[readUShort];
        System.arraycopy(bArr, readULong, obj, 0, readUShort);
        return obj;
    }

    private static byte[] makeRandomChallenge() throws NTLMEngineException {
        if (RND_GEN == null) {
            throw new NTLMEngineException("Random generator not available");
        }
        byte[] bArr = new byte[8];
        synchronized (RND_GEN) {
            RND_GEN.nextBytes(bArr);
        }
        return bArr;
    }

    private static byte[] makeSecondaryKey() throws NTLMEngineException {
        if (RND_GEN == null) {
            throw new NTLMEngineException("Random generator not available");
        }
        byte[] bArr = new byte[16];
        synchronized (RND_GEN) {
            RND_GEN.nextBytes(bArr);
        }
        return bArr;
    }

    static byte[] hmacMD5(byte[] bArr, byte[] bArr2) throws NTLMEngineException {
        HMACMD5 hmacmd5 = new HMACMD5(bArr2);
        hmacmd5.update(bArr);
        return hmacmd5.getOutput();
    }

    static byte[] RC4(byte[] bArr, byte[] bArr2) throws NTLMEngineException {
        try {
            Cipher instance = Cipher.getInstance("RC4");
            instance.init(1, new SecretKeySpec(bArr2, "RC4"));
            return instance.doFinal(bArr);
        } catch (Throwable e) {
            throw new NTLMEngineException(e.getMessage(), e);
        }
    }

    static byte[] ntlm2SessionResponse(byte[] bArr, byte[] bArr2, byte[] bArr3) throws NTLMEngineException {
        try {
            MessageDigest instance = MessageDigest.getInstance("MD5");
            instance.update(bArr2);
            instance.update(bArr3);
            Object obj = new byte[8];
            System.arraycopy(instance.digest(), 0, obj, 0, 8);
            return lmResponse(bArr, obj);
        } catch (Throwable e) {
            if (e instanceof NTLMEngineException) {
                throw ((NTLMEngineException) e);
            }
            throw new NTLMEngineException(e.getMessage(), e);
        }
    }

    private static byte[] lmHash(String str) throws NTLMEngineException {
        try {
            Object bytes = str.toUpperCase(Locale.ENGLISH).getBytes("US-ASCII");
            Object obj = new byte[14];
            System.arraycopy(bytes, 0, obj, 0, Math.min(bytes.length, 14));
            Key createDESKey = createDESKey(obj, 0);
            Key createDESKey2 = createDESKey(obj, 7);
            byte[] bytes2 = "KGS!@#$%".getBytes("US-ASCII");
            Cipher instance = Cipher.getInstance("DES/ECB/NoPadding");
            instance.init(1, createDESKey);
            bytes = instance.doFinal(bytes2);
            instance.init(1, createDESKey2);
            Object doFinal = instance.doFinal(bytes2);
            obj = new byte[16];
            System.arraycopy(bytes, 0, obj, 0, 8);
            System.arraycopy(doFinal, 0, obj, 8, 8);
            return obj;
        } catch (Throwable e) {
            throw new NTLMEngineException(e.getMessage(), e);
        }
    }

    private static byte[] ntlmHash(String str) throws NTLMEngineException {
        try {
            byte[] bytes = str.getBytes("UnicodeLittleUnmarked");
            MD4 md4 = new MD4();
            md4.update(bytes);
            return md4.getOutput();
        } catch (Throwable e) {
            throw new NTLMEngineException("Unicode not supported: " + e.getMessage(), e);
        }
    }

    private static byte[] lmv2Hash(String str, String str2, byte[] bArr) throws NTLMEngineException {
        try {
            HMACMD5 hmacmd5 = new HMACMD5(bArr);
            hmacmd5.update(str2.toUpperCase(Locale.ENGLISH).getBytes("UnicodeLittleUnmarked"));
            if (str != null) {
                hmacmd5.update(str.toUpperCase(Locale.ENGLISH).getBytes("UnicodeLittleUnmarked"));
            }
            return hmacmd5.getOutput();
        } catch (Throwable e) {
            throw new NTLMEngineException("Unicode not supported! " + e.getMessage(), e);
        }
    }

    private static byte[] ntlmv2Hash(String str, String str2, byte[] bArr) throws NTLMEngineException {
        try {
            HMACMD5 hmacmd5 = new HMACMD5(bArr);
            hmacmd5.update(str2.toUpperCase(Locale.ENGLISH).getBytes("UnicodeLittleUnmarked"));
            if (str != null) {
                hmacmd5.update(str.getBytes("UnicodeLittleUnmarked"));
            }
            return hmacmd5.getOutput();
        } catch (Throwable e) {
            throw new NTLMEngineException("Unicode not supported! " + e.getMessage(), e);
        }
    }

    private static byte[] lmResponse(byte[] bArr, byte[] bArr2) throws NTLMEngineException {
        try {
            Object obj = new byte[21];
            System.arraycopy(bArr, 0, obj, 0, 16);
            Key createDESKey = createDESKey(obj, 0);
            Key createDESKey2 = createDESKey(obj, 7);
            Key createDESKey3 = createDESKey(obj, 14);
            Cipher instance = Cipher.getInstance("DES/ECB/NoPadding");
            instance.init(1, createDESKey);
            Object doFinal = instance.doFinal(bArr2);
            instance.init(1, createDESKey2);
            Object doFinal2 = instance.doFinal(bArr2);
            instance.init(1, createDESKey3);
            obj = instance.doFinal(bArr2);
            Object obj2 = new byte[24];
            System.arraycopy(doFinal, 0, obj2, 0, 8);
            System.arraycopy(doFinal2, 0, obj2, 8, 8);
            System.arraycopy(obj, 0, obj2, 16, 8);
            return obj2;
        } catch (Throwable e) {
            throw new NTLMEngineException(e.getMessage(), e);
        }
    }

    private static byte[] lmv2Response(byte[] bArr, byte[] bArr2, byte[] bArr3) throws NTLMEngineException {
        HMACMD5 hmacmd5 = new HMACMD5(bArr);
        hmacmd5.update(bArr2);
        hmacmd5.update(bArr3);
        Object output = hmacmd5.getOutput();
        Object obj = new byte[(output.length + bArr3.length)];
        System.arraycopy(output, 0, obj, 0, output.length);
        System.arraycopy(bArr3, 0, obj, output.length, bArr3.length);
        return obj;
    }

    private static byte[] createBlob(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        Object obj = new byte[]{(byte) 1, (byte) 1, (byte) 0, (byte) 0};
        Object obj2 = new byte[]{(byte) 0, (byte) 0, (byte) 0, (byte) 0};
        Object obj3 = new byte[]{(byte) 0, (byte) 0, (byte) 0, (byte) 0};
        Object obj4 = new byte[]{(byte) 0, (byte) 0, (byte) 0, (byte) 0};
        Object obj5 = new byte[((((((obj.length + obj2.length) + bArr3.length) + 8) + obj3.length) + bArr2.length) + obj4.length)];
        System.arraycopy(obj, 0, obj5, 0, obj.length);
        int length = obj.length + 0;
        System.arraycopy(obj2, 0, obj5, length, obj2.length);
        length += obj2.length;
        System.arraycopy(bArr3, 0, obj5, length, bArr3.length);
        length += bArr3.length;
        System.arraycopy(bArr, 0, obj5, length, 8);
        length += 8;
        System.arraycopy(obj3, 0, obj5, length, obj3.length);
        length += obj3.length;
        System.arraycopy(bArr2, 0, obj5, length, bArr2.length);
        length += bArr2.length;
        System.arraycopy(obj4, 0, obj5, length, obj4.length);
        length += obj4.length;
        return obj5;
    }

    private static Key createDESKey(byte[] bArr, int i) {
        r0 = new byte[7];
        System.arraycopy(bArr, i, r0, 0, 7);
        byte[] bArr2 = new byte[]{r0[0], (byte) ((r0[0] << 7) | ((r0[1] & 255) >>> 1)), (byte) ((r0[1] << 6) | ((r0[2] & 255) >>> 2)), (byte) ((r0[2] << 5) | ((r0[3] & 255) >>> 3)), (byte) ((r0[3] << 4) | ((r0[4] & 255) >>> 4)), (byte) ((r0[4] << 3) | ((r0[5] & 255) >>> 5)), (byte) ((r0[5] << 2) | ((r0[6] & 255) >>> 6)), (byte) (r0[6] << 1)};
        oddParity(bArr2);
        return new SecretKeySpec(bArr2, "DES");
    }

    private static void oddParity(byte[] bArr) {
        for (int i = 0; i < bArr.length; i++) {
            Object obj;
            byte b = bArr[i];
            if ((((b >>> 1) ^ ((((((b >>> 7) ^ (b >>> 6)) ^ (b >>> 5)) ^ (b >>> 4)) ^ (b >>> 3)) ^ (b >>> 2))) & 1) == 0) {
                obj = 1;
            } else {
                obj = null;
            }
            if (obj != null) {
                bArr[i] = (byte) (bArr[i] | 1);
            } else {
                bArr[i] = (byte) (bArr[i] & -2);
            }
        }
    }

    static void writeULong(byte[] bArr, int i, int i2) {
        bArr[i2] = (byte) (i & 255);
        bArr[i2 + 1] = (byte) ((i >> 8) & 255);
        bArr[i2 + 2] = (byte) ((i >> 16) & 255);
        bArr[i2 + 3] = (byte) ((i >> 24) & 255);
    }

    static int F(int i, int i2, int i3) {
        return (i & i2) | ((i ^ -1) & i3);
    }

    static int G(int i, int i2, int i3) {
        return ((i & i2) | (i & i3)) | (i2 & i3);
    }

    static int H(int i, int i2, int i3) {
        return (i ^ i2) ^ i3;
    }

    static int rotintlft(int i, int i2) {
        return (i << i2) | (i >>> (32 - i2));
    }

    public String generateType1Msg(String str, String str2) throws NTLMEngineException {
        return getType1Message(str2, str);
    }

    public String generateType3Msg(String str, String str2, String str3, String str4, String str5) throws NTLMEngineException {
        Type2Message type2Message = new Type2Message(str5);
        return getType3Message(str, str2, str4, str3, type2Message.getChallenge(), type2Message.getFlags(), type2Message.getTarget(), type2Message.getTargetInfo());
    }
}
