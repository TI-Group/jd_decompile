package cn.jpush.android.service;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.NetworkInfo;
import android.net.NetworkInfo.State;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import cn.jiguang.a.c.c;
import cn.jiguang.api.JCoreInterface;
import cn.jiguang.b.d.b;
import cn.jiguang.b.d.m;
import cn.jiguang.c.d;
import cn.jiguang.e.a;
import cn.jiguang.e.h;
import cn.jiguang.e.j;

public class PushReceiver extends BroadcastReceiver {
    private static final String[] z;

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static {
        /*
        r0 = 35;
        r3 = new java.lang.String[r0];
        r2 = 0;
        r1 = "\u0017\u001a\r\u0004\n\u0000\u0002\u000f\"";
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
            case 0: goto L_0x019f;
            case 1: goto L_0x01a3;
            case 2: goto L_0x01a7;
            case 3: goto L_0x01ab;
            default: goto L_0x001e;
        };
    L_0x001e:
        r9 = 110; // 0x6e float:1.54E-43 double:5.43E-322;
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
            case 7: goto L_0x007d;
            case 8: goto L_0x0087;
            case 9: goto L_0x0092;
            case 10: goto L_0x009d;
            case 11: goto L_0x00a8;
            case 12: goto L_0x00b3;
            case 13: goto L_0x00be;
            case 14: goto L_0x00c9;
            case 15: goto L_0x00d4;
            case 16: goto L_0x00df;
            case 17: goto L_0x00ea;
            case 18: goto L_0x00f5;
            case 19: goto L_0x0100;
            case 20: goto L_0x010b;
            case 21: goto L_0x0116;
            case 22: goto L_0x0121;
            case 23: goto L_0x012c;
            case 24: goto L_0x0137;
            case 25: goto L_0x0142;
            case 26: goto L_0x014d;
            case 27: goto L_0x0158;
            case 28: goto L_0x0163;
            case 29: goto L_0x016e;
            case 30: goto L_0x0179;
            case 31: goto L_0x0184;
            case 32: goto L_0x018f;
            case 33: goto L_0x019a;
            default: goto L_0x003c;
        };
    L_0x003c:
        r3[r2] = r1;
        r2 = 1;
        r1 = "\u0006\u0001\u00005\u000b\u0006\u001a\u00074\u0000H\u001d\u001a:\u001a\u0000";
        r0 = 0;
        r3 = r4;
        goto L_0x0009;
    L_0x0044:
        r3[r2] = r1;
        r2 = 2;
        r1 = "\u0017\u001a\r";
        r0 = 1;
        r3 = r4;
        goto L_0x0009;
    L_0x004c:
        r3[r2] = r1;
        r2 = 3;
        r1 = "\"\u000b\u001a{\u0019\u0017\u0001\u0000<N\u0001\u000f\u001a:N\u0016\u001a\u001c2\u0000\u0002N\b)\u0001\bN\u00075\u001a\u0000\u0000\u001aaN";
        r0 = 2;
        r3 = r4;
        goto L_0x0009;
    L_0x0054:
        r3[r2] = r1;
        r2 = 4;
        r1 = "\n\u001a\u0006>\u001cE\u0000\u000b/\u0019\n\u001c\u0005{\u001d\u0011\u000f\u001a>NHN";
        r0 = 3;
        r3 = r4;
        goto L_0x0009;
    L_0x005c:
        r3[r2] = r1;
        r2 = 5;
        r1 = "\u0004\u0000\n)\u0001\f\n@2\u0000\u0011\u000b\u0000/@\u0004\r\u001a2\u0001\u000b@,\u0014!11-\u0014#5\"+\u000f+!";
        r0 = 4;
        r3 = r4;
        goto L_0x0009;
    L_0x0064:
        r3[r2] = r1;
        r2 = 6;
        r1 = "_N)>\u001aE\u0000\u0001{\n\u0004\u001a\u000f{\b\u0017\u0001\u0003{\u0007\u000b\u001a\u000b5\u001aK";
        r0 = 5;
        r3 = r4;
        goto L_0x0009;
    L_0x006c:
        r3[r2] = r1;
        r2 = 7;
        r1 = "\u0001\u000b\f.\t:\u0000\u0001/\u0007\u0003\u0007\r:\u001a\f\u0001\u0000";
        r0 = 6;
        r3 = r4;
        goto L_0x0009;
    L_0x0074:
        r3[r2] = r1;
        r2 = 8;
        r1 = "7\u000b\r>\u0007\u0013\u000b\n{\u000f\u0006\u001a\u00074\u0000E\u0007\u001d{\u0000\u0010\u0002\u0002";
        r0 = 7;
        r3 = r4;
        goto L_0x0009;
    L_0x007d:
        r3[r2] = r1;
        r2 = 9;
        r1 = "\u0004\u0000\n)\u0001\f\n@5\u000b\u0011@\r4\u0000\u000b@-\u0014 ++-\u000f'3':\u00021&&/\u0015) ";
        r0 = 8;
        r3 = r4;
        goto L_0x0009;
    L_0x0087:
        r3[r2] = r1;
        r2 = 10;
        r1 = "\u0006\u0000@1\u001e\u0010\u001d\u0006u\u000f\u000b\n\u001c4\u0007\u0001@\u00075\u001a\u0000\u0000\u001au-*  \u001e-1'8\u0012:<1-\u0013/+)+";
        r0 = 9;
        r3 = r4;
        goto L_0x0009;
    L_0x0092:
        r3[r2] = r1;
        r2 = 11;
        r1 = "+\u000b\u001a,\u0001\u0017\u0005N2\u001dE\r\u00015\u0000\u0000\r\u001a>\nK";
        r0 = 10;
        r3 = r4;
        goto L_0x0009;
    L_0x009d:
        r3[r2] = r1;
        r2 = 12;
        r1 = "\u0006\u0000@1\u001e\u0010\u001d\u0006u\u000f\u000b\n\u001c4\u0007\u0001@\u00075\u001a\u0000\u0000\u001au<1-";
        r0 = 11;
        r3 = r4;
        goto L_0x0009;
    L_0x00a8:
        r3[r2] = r1;
        r2 = 13;
        r1 = "\u000b\u0001-4\u0000\u000b\u000b\r/\u0007\u0013\u0007\u001a\"";
        r0 = 12;
        r3 = r4;
        goto L_0x0009;
    L_0x00b3:
        r3[r2] = r1;
        r2 = 14;
        r1 = "7\u000b\r>\u0007\u0013\u000b\n{\u0000\nN\u000f8\u001a\f\u0001\u0000{\u0007\u000b\u001a\u000b5\u001aE\f\u001c4\u000f\u0001\r\u000f(\u001aKN)2\u0018\u0000N\u001b+N\u0015\u001c\u00018\u000b\u0016\u001d\u00075\tK";
        r0 = 13;
        r3 = r4;
        goto L_0x0009;
    L_0x00be:
        r3[r2] = r1;
        r2 = 15;
        r1 = "\u0017\u000b\u001e7\u000f\u0006\u000bN:\u001e\u0015";
        r0 = 14;
        r3 = r4;
        goto L_0x0009;
    L_0x00c9:
        r3[r2] = r1;
        r2 = 16;
        r1 = "\n\u0000<>\r\u0000\u0007\u0018>N_$-4\u001c\u0000'\u0000/\u000b\u0017\b\u000f8\u000bE\u0007\u00002\u001aE\b\u000f2\u0002\u0000\n";
        r0 = 15;
        r3 = r4;
        goto L_0x0009;
    L_0x00d4:
        r3[r2] = r1;
        r2 = 17;
        r1 = "\u000b\u000b\u001a,\u0001\u0017\u0005'5\b\n";
        r0 = 16;
        r3 = r4;
        goto L_0x0009;
    L_0x00df:
        r3[r2] = r1;
        r2 = 18;
        r1 = "\u0015\u000f\r0\u000f\u0002\u000bT";
        r0 = 17;
        r3 = r4;
        goto L_0x0009;
    L_0x00ea:
        r3[r2] = r1;
        r2 = 19;
        r1 = "+\u0001\u001a{\b\n\u001b\u0000?N\u000b\u000b\u001a,\u0001\u0017\u0005'5\b\n";
        r0 = 18;
        r3 = r4;
        goto L_0x0009;
    L_0x00f5:
        r3[r2] = r1;
        r2 = 20;
        r1 = "\n\u0000<>\r\u0000\u0007\u0018>NHN";
        r0 = 19;
        r3 = r4;
        goto L_0x0009;
    L_0x0100:
        r3[r2] = r1;
        r2 = 21;
        r1 = "KN*4N\u000b\u0001\u001a3\u0007\u000b\t@";
        r0 = 20;
        r3 = r4;
        goto L_0x0009;
    L_0x010b:
        r3[r2] = r1;
        r2 = 22;
        r1 = "\u0006\u0000@1\u001e\u0010\u001d\u0006u\u000f\u000b\n\u001c4\u0007\u0001@\u00075\u001a\u0000\u0000\u001au *:'\u001d'&/:\u0012!+1!\u000b+++*\u0004>7!6\u0002";
        r0 = 21;
        r3 = r4;
        goto L_0x0009;
    L_0x0116:
        r3[r2] = r1;
        r2 = 23;
        r1 = "&\u0001\u00005\u000b\u0006\u001a\u00074\u0000E\u001d\u001a:\u001a\u0000N\r3\u000f\u000b\t\u000b?N\u0011\u0001NvN";
        r0 = 22;
        r3 = r4;
        goto L_0x0009;
    L_0x0121:
        r3[r2] = r1;
        r2 = 24;
        r1 = "\u0011\u0001\u000f(\u001a1\u000b\u0016/";
        r0 = 23;
        r3 = r4;
        goto L_0x0009;
    L_0x012c:
        r3[r2] = r1;
        r2 = 25;
        r1 = "(#={\u0001\u0017N=\u000e>)N\u0000>\u001a\u0012\u0001\u001c0N\u0016\u001a\u000f/\u000bE\r\u0006:\u0000\u0002\u000bB{\u001a\nN\n4N\u000b\u0001\u001a3\u0007\u000b\tO";
        r0 = 24;
        r3 = r4;
        goto L_0x0009;
    L_0x0137:
        r3[r2] = r1;
        r2 = 26;
        r1 = "\u0004\u0000\n)\u0001\f\n@2\u0000\u0011\u000b\u0000/@\u0004\r\u001a2\u0001\u000b@>\u001a-./)\u001e1$**\u001e*";
        r0 = 25;
        r3 = r4;
        goto L_0x0009;
    L_0x0142:
        r3[r2] = r1;
        r2 = 27;
        r1 = "7\u000b\r>\u0007\u0013\u000b\n{\u0000\u0010\u0002\u0002{\u0007\u000b\u001a\u000b5\u001aE\f\u001c4\u000f\u0001\r\u000f(\u001aKN)2\u0018\u0000N\u001b+N\u0015\u001c\u00018\u000b\u0016\u001d\u00075\tK";
        r0 = 26;
        r3 = r4;
        goto L_0x0009;
    L_0x014d:
        r3[r2] = r1;
        r2 = 28;
        r1 = "5\u001b\u001d3<\u0000\r\u000b2\u0018\u0000\u001c";
        r0 = 27;
        r3 = r4;
        goto L_0x0009;
    L_0x0158:
        r3[r2] = r1;
        r2 = 29;
        r1 = "\u0004\u0000\n)\u0001\f\n@2\u0000\u0011\u000b\u0000/@\u0004\r\u001a2\u0001\u000b@>\u001a-./)\u001e17+#\u00148 *";
        r0 = 28;
        r3 = r4;
        goto L_0x0009;
    L_0x0163:
        r3[r2] = r1;
        r2 = 30;
        r1 = "+\u0001N:\u0000\u001cN\u0000>\u001a\u0012\u0001\u001c0N\f\u001dN8\u0001\u000b\u0000\u000b8\u001a\u0000\n";
        r0 = 29;
        r3 = r4;
        goto L_0x0009;
    L_0x016e:
        r3[r2] = r1;
        r2 = 31;
        r1 = "\u0004\u0000\n)\u0001\f\n@2\u0000\u0011\u000b\u0000/@\u0004\r\u001a2\u0001\u000b@;\b+71>\t+6+ \u000f";
        r0 = 30;
        r3 = r4;
        goto L_0x0009;
    L_0x0179:
        r3[r2] = r1;
        r2 = 32;
        r1 = "\n\u0000<>\r\u0000\u0007\u0018>\u001cE\u000b\u001c)\u0001\u0017T";
        r0 = 31;
        r3 = r4;
        goto L_0x0009;
    L_0x0184:
        r3[r2] = r1;
        r2 = 33;
        r1 = "\u0016\n\u0005/\u0017\u0015\u000b";
        r0 = 32;
        r3 = r4;
        goto L_0x0009;
    L_0x018f:
        r3[r2] = r1;
        r2 = 34;
        r1 = "+\u000b\u001a,\u0001\u0017\u0005N2\u001dE\n\u0007(\r\n\u0000\u0000>\r\u0011\u000b\nu";
        r0 = 33;
        r3 = r4;
        goto L_0x0009;
    L_0x019a:
        r3[r2] = r1;
        z = r4;
        return;
    L_0x019f:
        r9 = 101; // 0x65 float:1.42E-43 double:5.0E-322;
        goto L_0x0020;
    L_0x01a3:
        r9 = 110; // 0x6e float:1.54E-43 double:5.43E-322;
        goto L_0x0020;
    L_0x01a7:
        r9 = 110; // 0x6e float:1.54E-43 double:5.43E-322;
        goto L_0x0020;
    L_0x01ab:
        r9 = 91;
        goto L_0x0020;
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jpush.android.service.PushReceiver.<clinit>():void");
    }

    public void onReceive(Context context, Intent intent) {
        int i = 0;
        if (intent == null) {
            d.h(z[28], z[27]);
            return;
        }
        try {
            String action = intent.getAction();
            d.d(z[28], new StringBuilder(z[20]).append(action).toString());
            if (TextUtils.isEmpty(action)) {
                d.h(z[28], z[8]);
                return;
            }
            try {
                if (action.equals(z[22]) && intent.getBooleanExtra(z[7], false)) {
                    String stringExtra = intent.getStringExtra(z[24]);
                    if (!TextUtils.isEmpty(stringExtra)) {
                        Toast makeText = Toast.makeText(context, stringExtra, 0);
                        try {
                            View view = makeText.getView();
                            if (view instanceof LinearLayout) {
                                view = ((LinearLayout) view).getChildAt(0);
                                if (view instanceof TextView) {
                                    TextView textView = (TextView) view;
                                    if (!j.a(stringExtra)) {
                                        textView.setText(stringExtra);
                                    }
                                    textView.setTextSize(13.0f);
                                }
                            }
                        } catch (Exception e) {
                        }
                        makeText.show();
                        return;
                    }
                }
                if (JCoreInterface.init(context.getApplicationContext(), false)) {
                    if (action.equals(z[5]) || action.equals(z[31])) {
                        if (!action.equals(z[31])) {
                            i = 500;
                        }
                        Bundle bundle = new Bundle();
                        bundle.putInt(z[0], i);
                        bundle.putString(z[2], z[2]);
                        m.a().b(context, z[12], bundle);
                    } else if (action.equals(z[26]) || action.equals(z[29])) {
                        String dataString = intent.getDataString();
                        if (dataString == null) {
                            d.h(z[28], action + z[6]);
                            return;
                        } else if (dataString.trim().length() <= 8 || !dataString.startsWith(z[18])) {
                            d.h(z[28], new StringBuilder(z[3]).append(dataString).toString());
                            return;
                        } else {
                            dataString = dataString.substring(8);
                            if (action.equals(z[26])) {
                                c.a(context, h.a(dataString, cn.jiguang.e.d.a(cn.jiguang.e.d.a(context, dataString))));
                            } else if (a.h(context.getApplicationContext(), dataString)) {
                                d.c(z[28], z[15]);
                            } else {
                                c.a(context, h.a(dataString));
                            }
                            c.a(context, dataString);
                        }
                    } else if (action.equalsIgnoreCase(z[9])) {
                        NetworkInfo networkInfo = (NetworkInfo) intent.getParcelableExtra(z[17]);
                        if (networkInfo == null) {
                            d.g(z[28], z[19]);
                            return;
                        }
                        d.c(z[28], new StringBuilder(z[23]).append(networkInfo.toString()).toString());
                        if (2 == networkInfo.getType() || 3 == networkInfo.getType()) {
                            d.c(z[28], z[25]);
                            return;
                        }
                        boolean booleanExtra = intent.getBooleanExtra(z[13], false);
                        Bundle extras = intent.getExtras();
                        if (booleanExtra) {
                            d.c(z[28], z[30]);
                            extras.putString(z[1], cn.jiguang.b.b.a.b.name());
                        } else if (State.CONNECTED == networkInfo.getState()) {
                            d.c(z[28], z[11]);
                            extras.putString(z[1], cn.jiguang.b.b.a.a.name());
                        } else if (State.DISCONNECTED == networkInfo.getState()) {
                            d.c(z[28], z[34]);
                            extras.putString(z[1], cn.jiguang.b.b.a.b.name());
                        } else {
                            d.c(z[28], new StringBuilder(z[4]).append(networkInfo.getState()).append(z[21]).toString());
                        }
                        m.a().b(context, z[10], extras);
                    } else {
                        action.equals(z[22]);
                    }
                    b.a();
                    b.a(context, intent.getStringExtra(z[33]), (Object) intent);
                    return;
                }
                d.h(z[28], z[16]);
            } catch (Exception e2) {
                d.h(z[28], new StringBuilder(z[32]).append(e2.getMessage()).toString());
            }
        } catch (NullPointerException e3) {
            d.h(z[28], z[14]);
        }
    }
}
