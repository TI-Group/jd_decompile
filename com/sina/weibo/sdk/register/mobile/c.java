package com.sina.weibo.sdk.register.mobile;

import android.content.Context;
import android.text.TextUtils;
import com.jingdong.jdma.JDMaInterface;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: TbsSdkJava */
public class c {
    private static c a;
    private static short[] b;
    private static final String[] c = new String[]{"a", "ai", "an", "ang", "ao", "ba", "bai", "ban", "bang", "bao", "bei", "ben", "beng", "bi", "bian", "biao", "bie", "bin", "bing", "bo", "bu", "ca", "cai", "can", "cang", "cao", JDMaInterface.SERVER_TYPE_CUSTOM, "cen", "ceng", "cha", "chai", "chan", "chang", "chao", "che", "chen", "cheng", "chi", "chong", "chou", "chu", "chuai", "chuan", "chuang", "chui", "chun", "chuo", "ci", "cong", "cou", "cu", "cuan", "cui", "cun", "cuo", "da", "dai", "dan", "dang", "dao", "de", "deng", "di", "dia", "dian", "diao", "die", "ding", "diu", "dong", "dou", "du", "duan", "dui", "dun", "duo", "e", "ei", "en", "er", "fa", "fan", "fang", "fei", "fen", "feng", "fo", "fou", "fu", "ga", "gai", "gan", "gang", "gao", "ge", "gei", "gen", "geng", "gong", "gou", "gu", "gua", "guai", "guan", "guang", "gui", "gun", "guo", "ha", "hai", "han", "hang", "hao", "he", "hei", "hen", "heng", "hong", "hou", "hu", "hua", "huai", "huan", "huang", "hui", "hun", "huo", "ji", "jia", "jian", "jiang", "jiao", "jie", "jin", "jing", "jiong", "jiu", "ju", "juan", "jue", "jun", "ka", "kai", "kan", "kang", "kao", "ke", "ken", "keng", "kong", "kou", "ku", "kua", "kuai", "kuan", "kuang", "kui", "kun", "kuo", "la", "lai", "lan", "lang", "lao", "le", "lei", "leng", "li", "lia", "lian", "liang", "liao", "lie", "lin", "ling", "liu", "long", "lou", "lu", "luan", "lun", "luo", "lv", "lve", "m", "ma", "mai", "man", "mang", "mao", "me", "mei", "men", "meng", "mi", "mian", "miao", "mie", "min", "ming", "miu", "mo", "mou", "mu", "na", "nai", "nan", "nang", "nao", "ne", "nei", "nen", "neng", "ng", "ni", "nian", "niang", "niao", "nie", "nin", "ning", "niu", "none", "nong", "nou", "nu", "nuan", "nuo", "nv", "nve", "o", "ou", "pa", "pai", "pan", "pang", "pao", "pei", "pen", "peng", "pi", "pian", "piao", "pie", "pin", "ping", "po", "pou", "pu", "qi", "qia", "qian", "qiang", "qiao", "qie", "qin", "qing", "qiong", "qiu", "qu", "quan", "que", "qun", "ran", "rang", "rao", "re", "ren", "reng", "ri", "rong", "rou", "ru", "ruan", "rui", "run", "ruo", "sa", "sai", "san", "sang", "sao", "se", "sen", "seng", "sha", "shai", "shan", "shang", "shao", "she", "shei", "shen", "sheng", "shi", "shou", "shu", "shua", "shuai", "shuan", "shuang", "shui", "shun", "shuo", "si", "song", "sou", "su", "suan", "sui", "sun", "suo", "ta", "tai", "tan", "tang", "tao", "te", "teng", "ti", "tian", "tiao", "tie", "ting", "tong", "tou", "tu", "tuan", "tui", "tun", "tuo", "wa", "wai", "wan", "wang", "wei", "wen", "weng", "wo", "wu", "xi", "xia", "xian", "xiang", "xiao", "xie", "xin", "xing", "xiong", "xiu", "xu", "xuan", "xue", "xun", "ya", "yan", "yang", "yao", "ye", "yi", "yiao", "yin", "ying", "yo", "yong", "you", "yu", "yuan", "yue", "yun", "za", "zai", "zan", "zang", "zao", "ze", "zei", "zen", "zeng", "zha", "zhai", "zhan", "zhang", "zhao", "zhe", "zhei", "zhen", "zheng", "zhi", "zhong", "zhou", "zhu", "zhua", "zhuai", "zhuan", "zhuang", "zhui", "zhun", "zhuo", "zi", "zong", "zou", "zu", "zuan", "zui", "zun", "zuo"};
    private static volatile boolean d = false;

    private c() {
    }

    public static synchronized c a(Context context) {
        c cVar;
        synchronized (c.class) {
            if (a == null) {
                a = new c();
            }
            b(context);
            cVar = a;
        }
        return cVar;
    }

    private static void b(Context context) {
        InputStream open;
        DataInputStream dataInputStream;
        InputStream inputStream;
        Throwable th;
        Throwable th2;
        DataInputStream dataInputStream2 = null;
        InputStream inputStream2 = null;
        DataInputStream dataInputStream3 = null;
        try {
            if (d) {
                if (null != null) {
                    try {
                        dataInputStream3.close();
                    } catch (IOException e) {
                        return;
                    }
                }
                if (null != null) {
                    inputStream2.close();
                    return;
                }
                return;
            }
            open = context.getAssets().open("pinyinindex");
            try {
                dataInputStream = new DataInputStream(open);
                try {
                    b = new short[((int) ((long) (dataInputStream.available() >> 1)))];
                    for (int i = 0; i < b.length; i++) {
                        b[i] = dataInputStream.readShort();
                    }
                    d = true;
                    if (dataInputStream != null) {
                        try {
                            dataInputStream.close();
                        } catch (IOException e2) {
                            return;
                        }
                    }
                    if (open != null) {
                        open.close();
                    }
                } catch (IOException e3) {
                    inputStream = open;
                } catch (Exception e4) {
                }
            } catch (IOException e5) {
                dataInputStream = null;
                inputStream = open;
                try {
                    d = false;
                    if (dataInputStream != null) {
                        try {
                            dataInputStream.close();
                        } catch (IOException e6) {
                            return;
                        }
                    }
                    if (inputStream != null) {
                        inputStream.close();
                    }
                } catch (Throwable th3) {
                    th = th3;
                    open = inputStream;
                    dataInputStream2 = dataInputStream;
                    th2 = th;
                    if (dataInputStream2 != null) {
                        try {
                            dataInputStream2.close();
                        } catch (IOException e7) {
                            throw th2;
                        }
                    }
                    if (open != null) {
                        open.close();
                    }
                    throw th2;
                }
            } catch (Exception e8) {
                dataInputStream = null;
                try {
                    d = false;
                    if (dataInputStream != null) {
                        try {
                            dataInputStream.close();
                        } catch (IOException e9) {
                            return;
                        }
                    }
                    if (open != null) {
                        open.close();
                    }
                } catch (Throwable th4) {
                    th = th4;
                    dataInputStream2 = dataInputStream;
                    th2 = th;
                    if (dataInputStream2 != null) {
                        dataInputStream2.close();
                    }
                    if (open != null) {
                        open.close();
                    }
                    throw th2;
                }
            } catch (Throwable th5) {
                th2 = th5;
                if (dataInputStream2 != null) {
                    dataInputStream2.close();
                }
                if (open != null) {
                    open.close();
                }
                throw th2;
            }
        } catch (IOException e10) {
            dataInputStream = null;
            d = false;
            if (dataInputStream != null) {
                dataInputStream.close();
            }
            if (inputStream != null) {
                inputStream.close();
            }
        } catch (Exception e11) {
            dataInputStream = null;
            open = null;
            d = false;
            if (dataInputStream != null) {
                dataInputStream.close();
            }
            if (open != null) {
                open.close();
            }
        } catch (Throwable th6) {
            th2 = th6;
            open = null;
            if (dataInputStream2 != null) {
                dataInputStream2.close();
            }
            if (open != null) {
                open.close();
            }
            throw th2;
        }
    }

    private String a(char c) {
        if (!d) {
            return "";
        }
        String str = "";
        if (c == '〇') {
            return "LING";
        }
        if (c < '一' || c > '龥') {
            return String.valueOf(c);
        }
        str = c[b[c - 19968]];
        if (str == null) {
            return "";
        }
        return str;
    }

    public String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        if (!d) {
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder();
        int length = str.length();
        for (int i = 0; i < length; i++) {
            stringBuilder.append(a(str.charAt(i)));
        }
        return stringBuilder.toString();
    }

    public static c a() {
        return a;
    }
}
