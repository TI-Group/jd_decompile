package cn.jpush.android.d;

import android.text.TextUtils;
import cn.jpush.android.api.JPushInterface.a;
import java.util.Set;
import java.util.regex.Pattern;

/* compiled from: TbsSdkJava */
public final class g {
    public static final Pattern a;
    public static final Pattern b;
    public static final Pattern c;
    public static final Pattern d;
    public static final Pattern e;
    public static final Pattern f;
    private static final String[] z;

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static {
        /*
        r0 = 3;
        r3 = new java.lang.String[r0];
        r2 = 0;
        r1 = "GY么`鿝)/q,UcCe\u0017'8Bki^3)uc\u0004D)l";
        r0 = -1;
        r4 = r3;
    L_0x0008:
        r1 = r1.toCharArray();
        r5 = r1.length;
        r6 = 0;
        r7 = 1;
        if (r5 > r7) goto L_0x002d;
    L_0x0011:
        r7 = r1;
        r8 = r6;
        r11 = r5;
        r5 = r1;
        r1 = r11;
    L_0x0016:
        r10 = r5[r6];
        r9 = r8 % 5;
        switch(r9) {
            case 0: goto L_0x0075;
            case 1: goto L_0x0078;
            case 2: goto L_0x007a;
            case 3: goto L_0x007d;
            default: goto L_0x001d;
        };
    L_0x001d:
        r9 = 120; // 0x78 float:1.68E-43 double:5.93E-322;
    L_0x001f:
        r9 = r9 ^ r10;
        r9 = (char) r9;
        r5[r6] = r9;
        r6 = r8 + 1;
        if (r1 != 0) goto L_0x002b;
    L_0x0027:
        r5 = r7;
        r8 = r6;
        r6 = r1;
        goto L_0x0016;
    L_0x002b:
        r5 = r1;
        r1 = r7;
    L_0x002d:
        if (r5 > r6) goto L_0x0011;
    L_0x002f:
        r5 = new java.lang.String;
        r5.<init>(r1);
        r1 = r5.intern();
        switch(r0) {
            case 0: goto L_0x0043;
            case 1: goto L_0x004b;
            default: goto L_0x003b;
        };
    L_0x003b:
        r3[r2] = r1;
        r2 = 1;
        r1 = "GY么`鿝)/q,UcCe\u0017'8Bki^3)uc\u0004DyxaL)l";
        r0 = 0;
        r3 = r4;
        goto L_0x0008;
    L_0x0043:
        r3[r2] = r1;
        r2 = 2;
        r1 = "1*`e#x/2\fUC2etØ4퟽賂`ﶷ﷩/ﾧ\u0010#x/2\fUC2etØ4퟽賂`ﶷ﷩/ﾧ\u0011UD(ag#x/2\fUC2etØ4퟽賂`ﶷ﷩/ﾧ\u0010$7+c";
        r0 = 1;
        r3 = r4;
        goto L_0x0008;
    L_0x004b:
        r3[r2] = r1;
        z = r4;
        r1 = "1*)(\nv~)?\bx~)>\u0011x~)\u0016\u001b}g.*\u0011uo&\"\tkq<8\u000fax\u0015d\u00041`!7\u0004{Y)/\u001c|d/%\u0011so&\"\njv>:\u0001c_a1Pzc<1\u001bvo4.\u0017vr4.#xa,+\u001fqk#!\u0015wm:8\u000ea{2\u0010Qef\u0013(\u0012ro'7%e*-)\reg\u0013.\u001d~p;9\rD+4+#ph# \u0017k_4e\u001fvt4*#x`,(\u001e~j!!\u0015wr9?\u000bmw?4%0~ \u0016\u0013tl:9\rD~`$\u0016m4$\u0016m~!\u0016\u001c|n%#\u0017hp;9%0~`'\u0017{q4'#|o'=%0~#\u0016\u001d~j! \u0016ip?4\u0002D~$\u0016\u0019{a!&\njv=;\u0001D~` \u0011u~%\"\u001ap~%8\u000b|w%1\u0015Bc+)\u001d~j#!\u0015wm8<\njv=;\u000fa{2\u0010Qe*&,\u0015|~&(\fel\u0013,\u001b|d/$\u0014vr:8\u0002D+4e\u0017ke4\"\u00150~`=\nv~8\u0016\u0019|d/%\u0013uo&?\u000bmu1\u0010Qes)1\nBg'>\rn_4>#x`+)\u001d~j!'\u0013uo&\"\nmw>4\u0002D~`9\u001du~<?\u0019og$1\fBa,+\u001fqh#!\u0015wm8?\fou2\u0010Qew\u0013,\u001frq17%et\u0013,\u001b|e!#\rD~?\u0016\u001ej_4e\u0000w^e\u0011U)x? M/f45\u0016E/\u0014`I(`}/\u000b*cq,\u0012/e45\u0016E/\u0014`@)c#%\u001a`i&'L~0#$4^et\f-`y|\u0001p7)1\u0000w^e\u0011U}g*,Hxf45\u0016E/\u0014`\u001f/uzxI}~0#$4^e%\u001f{i~,\u0012.d}~\u001a{c45\u0016E/\u0014`\u0010ua\"{\u0019`cq(\u000bz5)1\u0000w^e\u0011Usz)!\b}n81\u0000w^e\u0011Ure*(\u001bqv>1\u0000w^e\u0011Uca#7\u0019q+44#|v=\u0010\u0004cY) \u000fD+";
        r0 = -1;
    L_0x0052:
        r1 = r1.toCharArray();
        r2 = r1.length;
        r3 = 0;
        r4 = 1;
        if (r2 > r4) goto L_0x0103;
    L_0x005b:
        r4 = r1;
        r5 = r3;
        r11 = r2;
        r2 = r1;
        r1 = r11;
    L_0x0060:
        r7 = r2[r3];
        r6 = r5 % 5;
        switch(r6) {
            case 0: goto L_0x00f2;
            case 1: goto L_0x00f6;
            case 2: goto L_0x00f9;
            case 3: goto L_0x00fd;
            default: goto L_0x0067;
        };
    L_0x0067:
        r6 = 120; // 0x78 float:1.68E-43 double:5.93E-322;
    L_0x0069:
        r6 = r6 ^ r7;
        r6 = (char) r6;
        r2[r3] = r6;
        r3 = r5 + 1;
        if (r1 != 0) goto L_0x0101;
    L_0x0071:
        r2 = r4;
        r5 = r3;
        r3 = r1;
        goto L_0x0060;
    L_0x0075:
        r9 = 25;
        goto L_0x001f;
    L_0x0078:
        r9 = 2;
        goto L_0x001f;
    L_0x007a:
        r9 = 72;
        goto L_0x001f;
    L_0x007d:
        r9 = 77;
        goto L_0x001f;
    L_0x0080:
        r0 = java.util.regex.Pattern.compile(r1);
        c = r0;
        r0 = new java.lang.StringBuilder;
        r1 = z;
        r2 = 2;
        r1 = r1[r2];
        r0.<init>(r1);
        r1 = a;
        r6 = r0.append(r1);
        r0 = "0~";
        r0 = r0.toCharArray();
        r1 = r0.length;
        r2 = 0;
        r3 = 1;
        if (r1 > r3) goto L_0x00c8;
    L_0x00a1:
        r3 = r0;
        r4 = r2;
        r11 = r1;
        r1 = r0;
        r0 = r11;
    L_0x00a6:
        r7 = r1[r2];
        r5 = r4 % 5;
        switch(r5) {
            case 0: goto L_0x00bb;
            case 1: goto L_0x00be;
            case 2: goto L_0x00c0;
            case 3: goto L_0x00c3;
            default: goto L_0x00ad;
        };
    L_0x00ad:
        r5 = 120; // 0x78 float:1.68E-43 double:5.93E-322;
    L_0x00af:
        r5 = r5 ^ r7;
        r5 = (char) r5;
        r1[r2] = r5;
        r2 = r4 + 1;
        if (r0 != 0) goto L_0x00c6;
    L_0x00b7:
        r1 = r3;
        r4 = r2;
        r2 = r0;
        goto L_0x00a6;
    L_0x00bb:
        r5 = 25;
        goto L_0x00af;
    L_0x00be:
        r5 = 2;
        goto L_0x00af;
    L_0x00c0:
        r5 = 72;
        goto L_0x00af;
    L_0x00c3:
        r5 = 77;
        goto L_0x00af;
    L_0x00c6:
        r1 = r0;
        r0 = r3;
    L_0x00c8:
        if (r1 > r2) goto L_0x00a1;
    L_0x00ca:
        r1 = new java.lang.String;
        r1.<init>(r0);
        r0 = r1.intern();
        r0 = r6.append(r0);
        r1 = c;
        r0 = r0.append(r1);
        r1 = ")";
        r0 = r0.append(r1);
        r0 = r0.toString();
        r0 = java.util.regex.Pattern.compile(r0);
        d = r0;
        r1 = "Bce794Xx`AE)\u0014c$F^m\u0011UE)\u00156I50}{\u0005EB\u0013,UcCe\u0017H4;\u0015\u0016\u00194x\t`\")/q\u0011UDyxaN-`\u0011VBce794Xx`ADY)`\u0002X/\u0012}U ^e\u0010\u0003).zx\u00050)";
        r0 = 2;
        goto L_0x0052;
    L_0x00f2:
        r6 = 25;
        goto L_0x0069;
    L_0x00f6:
        r6 = 2;
        goto L_0x0069;
    L_0x00f9:
        r6 = 72;
        goto L_0x0069;
    L_0x00fd:
        r6 = 77;
        goto L_0x0069;
    L_0x0101:
        r2 = r1;
        r1 = r4;
    L_0x0103:
        if (r2 > r3) goto L_0x005b;
    L_0x0105:
        r2 = new java.lang.String;
        r2.<init>(r1);
        r1 = r2.intern();
        switch(r0) {
            case 0: goto L_0x011c;
            case 1: goto L_0x0080;
            case 2: goto L_0x0127;
            case 3: goto L_0x0132;
            default: goto L_0x0111;
        };
    L_0x0111:
        r0 = java.util.regex.Pattern.compile(r1);
        a = r0;
        r1 = "1*wwPqv<=\u0004qv<=\u000beJ<9\beJ<9\bj~:9\u000bi~\u001a9\u000bi+r\u0011WE-`rB1=r\u0016\u00194x\t`\")/q\u0011\\E/\u0014\u0012$7^c\u0011YE(\u0014j$1^a\u0011TE9\u0014r$?^u\u0010\u00041=r\u0011]Bce+94Dx`ADyz0Q0yyaN-`rBE8`rBBce794Xx`AE&\u0014`$F^f\u0011SE#\u0014g$>^`\u0011QE.\u0014v$&^n\u0011ED~`rBE'\u0013,UCe\u000bH4;\u00156Jd+a6I50}0Q&^\bdG0=`eG#*ww#x/2\fUC2etØ4퟽賂`ﶷ﷩/ﾧ\u0010#x/2\fUC2etØ4퟽賂`ﶷ﷩/ﾧ\u0011UDyxaN-\u0014cQ2*wwP&8)(\nv~)?\bx~)>\u0011x~)\u0016\u001b}g.*\u0011uo&\"\tkq<8\u000fax\u0015d\u00041=r/\u0011c~*\u0016\u0019{f-+\u001fqk\" \u0016vp;9\u000en{2\u0010Qe*ww\u001bxv4.\u0017t~+\"\u0017i~+\u0016\u0019zf.*\u0010pi$ \u0016vp=;\u0000`x\u0015d\u0004}Y-'\u0013tm2\u0010\u00041=r(\u001cl~-\u0016\u001b|e:>\fl_a1\u001eBk\"&\u0015vp\u00151P&8/\"\u000eee\u0013,\u001a}g.*\u0010pn%#\bhp;9\rn{\u0015d\u0004qY# \u0016kv=\u0010\u00041=r$\u0016m4$\u0016m~!\u0016\u001c|n%#\u0017hp;9%0~`rBsm*>\u0004sY- \u0017i_a1\u0013Bg/%\u0011tl8?\u000f`x\u00151\u0014Bc*.\u0011rp;9\ro{\u00151P&8%$\u0014eo'/\u0011eo=>\u001dlo4 #xa,(\u001fqi$ \u0016vr9?\u000bmw>:\u0000`x\u0015d\u00041=r#\u0019tg4#\u001dm~&\u0016\u0019zg.*\u0011um8?\rc_a1P&8'?\u001fem%d\u00041=r=\nv~8\u0016\u0019|d/%\u0013uo&?\u000bmu1\u0010Qes)1\nBg'>\rn_4>#x`+)\u001d~j!'\u0013uo&\"\nmw>4\u0002D~`rBmg$1\fkc>(\u0014ev\u0013.\u001ce '\u0013uo&\"\bkv>:\u0002D+48#xe#>\u0001c_4;#xa-*\u0011ww\u00151\u000fBd;\u0010\u00041=r5\u0016E/\u0014`Hcu%xN}~0#$4^e|I{7*>Kx;)'N~~0#$4^euHxi /\u0001rl\"y\u001eez&\u0011UE/q9L{3y4\u0011,c45\u0016E/\u0014`\u001c|`)}\u0019}~0#$4^e*Nn0}|\u001cez&\u0011UE/ *\u001ar4)'O7{/\u001ax~0#$4^e%\u0014zh~,\u0001x;->\u001b.c45\u0016E/\u0014`\u0012ac$=\u001cur45\u0016E/\u0014`\u0013~`-.\u0010mt45\u0016E/\u0014`\u0002zi2,\u00100~1\u0016\u001dmw\u00151\u0002Bc%:%0+4eG#*wwJ,Yx`MD~z\u0016H46\u0015\u0016H4;\u00151#)/y\u0010#)/q\u0010\u0003+4\u0016I4;\u0015\u0016H4;\u00151#(/q\u0010QE,`rB+7\u0013}U,_4#)/|\u0010#)/q\u0010\u0004B2e|%B2et%b051#(/q\u0010#)/q\u0010\u0004B3et%e2a\u0011V1=rMB2ex%e0\u0013}U-_\u0013}U _4\u0016H43\u0015\u0016H4;\u00156Jd~\u0013|U _\u0013}U _4\u0016I4;\u00151H0^feG#0}\u0016H47\u00151JB2ey%B2et%eYx`IDYx`ADyz0\u0004B3et%B2et%eYx`AD+adP&8\u0014w$}yyaMd+wdPE-`rB1=r\u0016\u00194x\t`\")/qíUퟦ車eﶂﶈ4￭\u0014v$6^w\u0011BEB\u0014k$$^k\u0011\u0006E/\u0014c$2^i\u0011RE%\u0014e$0^d\u0011'D+4eG#^m\u0016\u00194d\t`>)/q\u0010\u0003+adR0=`rBE`4iQ";
        r0 = 0;
        goto L_0x0052;
    L_0x011c:
        r0 = java.util.regex.Pattern.compile(r1);
        b = r0;
        r1 = "1*zx#)/}\u0010\u0004+Yx`LDYx`AD~\u0013}U(_\u0013}U _3\u0005eYy`ADYx`AD~\u0013|U _a\u0011V10}\u0016H47\u00151JB2ey%B2et%eYx`IDYx`ADyz0\u0004B3et%B2et%eYy`AD~xd$7*zx#)/}\u0010\u0004+Yx`LDYx`AD~\u0013}U(_\u0013}U _3\u0005eYy`ADYx`AD~\u0013|U _4}QE,`MB2ex%e0\u0013}U-_\u0013}U _4\u0016H43\u0015\u0016H4;\u00156Jd~\u0013|U _\u0013}U _4\u0016H4;\u0015dQ";
        r0 = 1;
        goto L_0x0052;
    L_0x0127:
        r0 = java.util.regex.Pattern.compile(r1);
        e = r0;
        r1 = "1^c\u0016H4;\u0015f#E/h\u0011VD(arPE*\u0013}U _c\u0011QB^em$7_bdG1Yx`ADYx`AE/h\u0011VDYx`AE/h\u0011VD)\u0013}U _a";
        r0 = 3;
        goto L_0x0052;
    L_0x0132:
        r0 = java.util.regex.Pattern.compile(r1);
        f = r0;
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jpush.android.d.g.<clinit>():void");
    }

    public static int a(Set<String> set) {
        if (set == null || set.isEmpty()) {
            return 0;
        }
        if (set.size() > 1000) {
            return a.h;
        }
        for (String str : set) {
            if (str == null) {
                return a.f;
            }
            if (str.getBytes().length > 40) {
                return a.g;
            }
            if (!Pattern.compile(z[0]).matcher(str).matches()) {
                return a.f;
            }
        }
        return 0;
    }

    public static boolean a(String str) {
        return str == null ? false : Pattern.compile(z[1]).matcher(str).matches();
    }

    public static int b(String str) {
        return (str == null || TextUtils.isEmpty(str)) ? 0 : str.getBytes().length > 40 ? a.e : !Pattern.compile(z[0]).matcher(str).matches() ? a.d : 0;
    }
}
