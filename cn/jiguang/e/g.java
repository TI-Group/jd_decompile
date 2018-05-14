package cn.jiguang.e;

import cn.jiguang.c.d;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.security.KeyStore;
import java.security.KeyStore.Entry;
import java.security.KeyStore.TrustedCertificateEntry;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;

public final class g implements HostnameVerifier, X509TrustManager {
    public static boolean a = false;
    private static final String[] z;
    private X509TrustManager b;

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static {
        /*
        r0 = 8;
        r3 = new java.lang.String[r0];
        r2 = 0;
        r1 = "fiSI\u0002j|";
        r0 = -1;
        r4 = r3;
    L_0x0009:
        r1 = r1.toCharArray();
        r5 = r1.length;
        r6 = 0;
        r7 = 1;
        if (r5 > r7) goto L_0x002e;
    L_0x0012:
        r7 = r1;
        r8 = r6;
        r11 = r5;
        r5 = r1;
        r1 = r11;
    L_0x0017:
        r10 = r5[r6];
        r9 = r8 % 5;
        switch(r9) {
            case 0: goto L_0x007c;
            case 1: goto L_0x007e;
            case 2: goto L_0x0081;
            case 3: goto L_0x0084;
            default: goto L_0x001e;
        };
    L_0x001e:
        r9 = 109; // 0x6d float:1.53E-43 double:5.4E-322;
    L_0x0020:
        r9 = r9 ^ r10;
        r9 = (char) r9;
        r5[r6] = r9;
        r6 = r8 + 1;
        if (r1 != 0) goto L_0x002c;
    L_0x0028:
        r5 = r7;
        r8 = r6;
        r6 = r1;
        goto L_0x0017;
    L_0x002c:
        r5 = r1;
        r1 = r7;
    L_0x002e:
        if (r5 > r6) goto L_0x0012;
    L_0x0030:
        r5 = new java.lang.String;
        r5.<init>(r1);
        r1 = r5.intern();
        switch(r0) {
            case 0: goto L_0x0044;
            case 1: goto L_0x004c;
            case 2: goto L_0x0054;
            case 3: goto L_0x005c;
            case 4: goto L_0x0064;
            case 5: goto L_0x006c;
            case 6: goto L_0x0074;
            default: goto L_0x003c;
        };
    L_0x003c:
        r3[r2] = r1;
        r2 = 1;
        r1 = "]&9\u000bT";
        r0 = 0;
        r3 = r4;
        goto L_0x0009;
    L_0x0044:
        r3[r2] = r1;
        r2 = 2;
        r1 = "(%!\u0016@GMKr#%KIi9LNEx,QM!\u0016@(%\u0006v$LMXA.FIv^\nDEy,bAHz\u0007u~Az]BK_J*VAn\b)TMNx\u001aPIA~$}Kvz'GoBm/DQXz\u0001S\\\u0006v?\\Jz4A^]j&@=s7R1YX\u0003Srhx/Ojav\u0018HZL*TQHm<TLIC'MR[\u00028ffZA\tFJDY*<a\u0006b:ro]\u000b(r@dX#H\\AC QI=v\u0007@rBQ8r_dX#HbEL#QA{v\u0007@rBQ8r_fy(HYL.TQHm<TO\u0006~\u001aO^YA(RENj*D9Y~.mEBi_S~Zs'4k?j\nV_9Q!oMhv/vOM\n8@Itv8W:ZM;MB=X^To\u0006n\\KEE~#GAO\u000b\nWrAL\nbMev,5OOh\u001cB[EY^AYIy,T]MzYLJHL,rok~&DgEy,TLfM\u00031C\u0006S\u001cUXm\t]<C:|5w]gP9al?N9W=Op:`g|\f\bWpGh=]?}|4dp:~U<P#]<u;iZ:}0GzZPR\u0006nTpdEa?uQ9\n\u001cQBIv(@m'~\u000bu{dR:6y{i\u0002Tbkq7cIY\t\u0005hm'V\u001eIy>w\u001boijM46IfJ&.J\u0006\u0003TC}e|\tQ?Np\u0006NP[p\u001d*BTk\fNLaq\u000b|Kb\b808BN M`er\u0001iRys(kZmT=_{Vm=*gu}\u0014vp\u0006Q]do'V\u0006PnF\t\u000bR}@I 5<]K\u001fU|h\t=\\9\f]6l5\u000e\u0000kzY\f\u00192laH\u0017A|:W\tJI\r/2|zW[TJ\u0006r]`^D\r#6#`R>}{jj\u001bf#X|(N;jM\b`RiI;J0~O\u001fH^{T\u000b2]Iq\u001frMki(wJ|Y\bCJJm]}~\u0006M4ADkm\u001aq{;C_jZ9W,bENz,Bbk\\+NEEr/WbM]/bFZs>HMK,RoNo,`xdT\u0007\\f;J\u001aSc\u0006/C1}U\\i}AI QbM_/bFZs<1MJ\\<P8a\u0014^i~_}=6A4v%5b>T;1e:uURf{L(bQHm?5\\\u0006z<M'Nz\nrJk~/*Ey,AICy\nK^DjUGIj\u0003(GIAx,TQ{u\n\\LZi]cJO\u0003\u001aI\\MI\u0002FekqY\\d\u0006Z%W8o\u0002sD>X\u0015IfB\u000e\u000fRFew\u0000K~nhTokaC\u0017I:h\u000b77pzb\u0000C{@V#|jHz\u001bGokI/bMJy<fJ\u0006z<TbAx(r@{b$NUy/T]Dv,BOI\t\u00055lDz[Iq5U l=v^:4bURXoj>\u000b\u001aQIU;W8ky(P\u0006j\u0017GJN\\\u001db`g\\/m~d},Tk>v)HAj4LC{b/GYYs,bM[q:m8hs,3Du\u0002^a;oN77^z_%O9\u0006X^T}U\tTqD?q\u0001f:5\n\u000ehF`X\u0014<bos rC]b)SZ<i/FA{r&TmAy\u001a}Ofz4GoBm/DEX~;K=\u0006Y:C}h|;o]IO'I\\IO#QE9v,5OOh\u001cB[EY^AYIy.r]MzYLJMj.b9\\X\u001e.;]w\u000b7\\tA8Ky\u0006U_O\\Dz'=eFx\u00042c5T\\FImX\u0015L#h\f#T>?pU2ge\u0010\u000b}n}_Y.LUa;U`Gs!Hc5H$g?_Z7_1\u0006bZ6kG\r\nc8Nt(fX;\t#__F\u0010\f_;~\u000fL};X9<k`\\\faRA\u0014\u0019NG;\u0002#bUx,1mj\f\u000470d^8wo\u0006\b&nj{Y\u000b2<W7]DZ\b/5\\YWB}BMr\u0001sJg\u000f/fJaH!}@M\u000f\u0018\\X@\u000f7IbTM)pioNTUO}\u00071=\u0006h;BmJ\u000b\u0019UMHK\u000fuieh\u000f*;:\n\nvLXn\tR^tU\u0017|:z\nU<j\\H=]9cC%VAJv9KLo}!@FmbT.F\u0006j#dNDW%u]^X\bD9nqUQKx\u000eXvZcI\u0003TEU|\u000fdDDa[UXaW%2@~S s`'\b<OjNTFa<El\u001bHx\u0006A#V[\u0006\u0016@(%!~#A(O~?QAJr.D\\I\u0016@(%!";
        r0 = 1;
        r3 = r4;
        goto L_0x0009;
    L_0x004c:
        r3[r2] = r1;
        r2 = 3;
        r1 = "V[@o\u001fp{xv\fkik^\u001f";
        r0 = 2;
        r3 = r4;
        goto L_0x0009;
    L_0x0054:
        r3[r2] = r1;
        r2 = 4;
        r1 = "bmxz\u000efm|O\baAH\u0018`z";
        r0 = 3;
        r3 = r4;
        goto L_0x0009;
    L_0x005c:
        r3[r2] = r1;
        r2 = 5;
        r1 = "f`iX\u0006Fde^\u0003q\\~N\u001eqmh";
        r0 = 4;
        r3 = r4;
        goto L_0x0009;
    L_0x0064:
        r3[r2] = r1;
        r2 = 6;
        r1 = "F`iX\u0006%[iI\u001b`z,CX51O^\u001fqajR\u000ed|iHMl{,^\u0000u|u";
        r0 = 5;
        r3 = r4;
        goto L_0x0009;
    L_0x006c:
        r3[r2] = r1;
        r2 = 7;
        r1 = "f`iX\u0006Vm~M\bw\\~N\u001eqmh";
        r0 = 6;
        r3 = r4;
        goto L_0x0009;
    L_0x0074:
        r3[r2] = r1;
        z = r4;
        r0 = 0;
        a = r0;
        return;
    L_0x007c:
        r9 = 5;
        goto L_0x0020;
    L_0x007e:
        r9 = 8;
        goto L_0x0020;
    L_0x0081:
        r9 = 12;
        goto L_0x0020;
    L_0x0084:
        r9 = 59;
        goto L_0x0020;
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jiguang.e.g.<clinit>():void");
    }

    public g() {
        try {
            CertificateFactory instance = CertificateFactory.getInstance(z[1]);
            InputStream byteArrayInputStream = new ByteArrayInputStream(z[2].getBytes());
            X509Certificate x509Certificate = (X509Certificate) instance.generateCertificate(byteArrayInputStream);
            byteArrayInputStream.close();
            Entry trustedCertificateEntry = new TrustedCertificateEntry(x509Certificate);
            KeyStore instance2 = KeyStore.getInstance(KeyStore.getDefaultType());
            instance2.load(null, null);
            instance2.setEntry(z[0], trustedCertificateEntry, null);
            TrustManagerFactory instance3 = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
            instance3.init(instance2);
            for (TrustManager trustManager : instance3.getTrustManagers()) {
                if (trustManager instanceof X509TrustManager) {
                    this.b = (X509TrustManager) trustManager;
                    return;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public final void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) {
        d.c(z[3], z[5]);
    }

    public final void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) {
        d.c(z[3], z[7]);
        if (x509CertificateArr == null || x509CertificateArr.length == 0) {
            throw new CertificateException(z[6]);
        } else if (x509CertificateArr[0] != null) {
            x509CertificateArr[0].checkValidity();
        }
    }

    public final X509Certificate[] getAcceptedIssuers() {
        d.c(z[3], z[4]);
        return this.b.getAcceptedIssuers();
    }

    public final boolean verify(String str, SSLSession sSLSession) {
        return !a;
    }
}
