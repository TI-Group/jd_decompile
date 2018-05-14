package com.jingdong.crash.inner;

import android.app.Activity;
import android.content.Context;
import android.os.SystemClock;
import android.telephony.TelephonyManager;
import com.jingdong.crash.a.b;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import org.apache.http.protocol.HTTP;
import org.json.JSONException;
import org.json.JSONObject;

class q {
    public static Context a;
    public static Activity b;
    private static LinkedList c = new LinkedList();
    private static File d;
    private static boolean e = true;
    private static Object f = new Object();
    private static StringBuffer g = new StringBuffer();
    private static String h = null;

    protected static String a() {
        g.append("page info:");
        int size = c.size();
        for (int i = 0; i < size; i++) {
            if (i < size - 1) {
                g.append(((String) c.poll()) + ">>");
            } else {
                g.append(((String) c.poll()) + "\n");
            }
        }
        if (h != null) {
            g.append(h);
        }
        return g.toString();
    }

    protected static String a(long j) {
        return ((j / 1000) / 3600) + ":" + (((j / 1000) % 3600) / 60) + ":" + (((j / 1000) % 3600) % 60);
    }

    protected static void a(Context context) {
        int i = ab.a(context).getInt("shared_crash_times", 0);
        ab.b(context).putInt("shared_crash_consecutive_times", ab.a(context).getInt("shared_crash_consecutive_times", 0) + 1);
        ab.b(context).putInt("shared_crash_times", i + 1).commit();
    }

    public static void a(Context context, String str, String str2) {
        a = context;
        try {
            if (a != null) {
                d = new File(a.getFilesDir(), "crash_sdk");
            }
        } catch (Exception e) {
            if (ah.e) {
                e.printStackTrace();
            }
        }
        try {
            if (d.b(context)) {
                new Thread(new t(str, str2)).start();
            }
        } catch (Throwable th) {
            if (ah.e) {
                th.printStackTrace();
            }
        }
    }

    public static void a(u uVar) {
        if (d != null) {
            if (d.exists() && d.length() > 500000) {
                d.delete();
            }
            if (e) {
                e = false;
                if (d.exists()) {
                    new r(uVar).start();
                } else {
                    e = true;
                }
            }
        }
    }

    public static void a(JSONObject jSONObject) {
        LineNumberReader lineNumberReader;
        List arrayList;
        Exception e;
        int i;
        List list;
        boolean z;
        BufferedWriter bufferedWriter;
        Throwable th;
        BufferedWriter bufferedWriter2 = null;
        if (d != null && jSONObject != null) {
            try {
                jSONObject.put("sysInfo", "-cache-" + jSONObject.getString("sysInfo"));
            } catch (JSONException e2) {
                if (ah.b) {
                    e2.printStackTrace();
                }
            }
            synchronized (f) {
                try {
                    int i2;
                    if (d.exists()) {
                        List list2;
                        int size;
                        try {
                            lineNumberReader = new LineNumberReader(new InputStreamReader(new FileInputStream(d), HTTP.UTF_8));
                            try {
                                arrayList = new ArrayList();
                                while (true) {
                                    try {
                                        String readLine = lineNumberReader.readLine();
                                        if (readLine == null) {
                                            break;
                                        } else if (readLine.trim().length() > 0) {
                                            arrayList.add(readLine);
                                        }
                                    } catch (Exception e3) {
                                        e = e3;
                                    }
                                }
                                if (lineNumberReader != null) {
                                    lineNumberReader.close();
                                    list2 = arrayList;
                                    size = list2 == null ? list2.size() : 0;
                                    if (size != 10) {
                                        list2.remove(0);
                                        list2.add(jSONObject.toString());
                                        i = size;
                                        list = list2;
                                        z = false;
                                    } else {
                                        i = size;
                                        z = true;
                                        list = list2;
                                    }
                                }
                            } catch (Exception e4) {
                                e = e4;
                                arrayList = null;
                                try {
                                    if (ah.b) {
                                        e.printStackTrace();
                                    }
                                    if (lineNumberReader != null) {
                                        lineNumberReader.close();
                                        list2 = arrayList;
                                        if (list2 == null) {
                                        }
                                        if (size != 10) {
                                            list2.remove(0);
                                            list2.add(jSONObject.toString());
                                            i = size;
                                            list = list2;
                                            z = false;
                                        } else {
                                            i = size;
                                            z = true;
                                            list = list2;
                                        }
                                        bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(d, z)));
                                        if (!z) {
                                            i = list.size();
                                            for (i2 = 0; i2 < i; i2++) {
                                                if (i2 == 0) {
                                                    bufferedWriter.append("\n" + ((String) list.get(i2)));
                                                } else {
                                                    bufferedWriter.append((CharSequence) list.get(i2));
                                                }
                                            }
                                        } else if (i == 0) {
                                            bufferedWriter.append("\n" + jSONObject.toString());
                                        } else {
                                            try {
                                                bufferedWriter.append(jSONObject.toString());
                                            } catch (Throwable th2) {
                                                th = th2;
                                                if (bufferedWriter != null) {
                                                    bufferedWriter.close();
                                                }
                                                throw th;
                                            }
                                        }
                                        bufferedWriter.flush();
                                        if (bufferedWriter != null) {
                                            try {
                                                bufferedWriter.close();
                                            } catch (IOException e5) {
                                                if (ah.e) {
                                                    e5.printStackTrace();
                                                }
                                            }
                                        }
                                    }
                                    list2 = arrayList;
                                    if (list2 == null) {
                                    }
                                    if (size != 10) {
                                        i = size;
                                        z = true;
                                        list = list2;
                                    } else {
                                        list2.remove(0);
                                        list2.add(jSONObject.toString());
                                        i = size;
                                        list = list2;
                                        z = false;
                                    }
                                    bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(d, z)));
                                    if (!z) {
                                        i = list.size();
                                        for (i2 = 0; i2 < i; i2++) {
                                            if (i2 == 0) {
                                                bufferedWriter.append((CharSequence) list.get(i2));
                                            } else {
                                                bufferedWriter.append("\n" + ((String) list.get(i2)));
                                            }
                                        }
                                    } else if (i == 0) {
                                        bufferedWriter.append(jSONObject.toString());
                                    } else {
                                        bufferedWriter.append("\n" + jSONObject.toString());
                                    }
                                    bufferedWriter.flush();
                                    if (bufferedWriter != null) {
                                        bufferedWriter.close();
                                    }
                                } catch (Throwable th3) {
                                    th = th3;
                                    if (lineNumberReader != null) {
                                        lineNumberReader.close();
                                    }
                                    throw th;
                                }
                            }
                        } catch (Exception e6) {
                            e = e6;
                            lineNumberReader = null;
                            arrayList = null;
                            if (ah.b) {
                                e.printStackTrace();
                            }
                            if (lineNumberReader != null) {
                                lineNumberReader.close();
                                list2 = arrayList;
                                if (list2 == null) {
                                }
                                if (size != 10) {
                                    list2.remove(0);
                                    list2.add(jSONObject.toString());
                                    i = size;
                                    list = list2;
                                    z = false;
                                } else {
                                    i = size;
                                    z = true;
                                    list = list2;
                                }
                                bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(d, z)));
                                if (!z) {
                                    i = list.size();
                                    for (i2 = 0; i2 < i; i2++) {
                                        if (i2 == 0) {
                                            bufferedWriter.append("\n" + ((String) list.get(i2)));
                                        } else {
                                            bufferedWriter.append((CharSequence) list.get(i2));
                                        }
                                    }
                                } else if (i == 0) {
                                    bufferedWriter.append("\n" + jSONObject.toString());
                                } else {
                                    bufferedWriter.append(jSONObject.toString());
                                }
                                bufferedWriter.flush();
                                if (bufferedWriter != null) {
                                    bufferedWriter.close();
                                }
                            }
                            list2 = arrayList;
                            if (list2 == null) {
                            }
                            if (size != 10) {
                                i = size;
                                z = true;
                                list = list2;
                            } else {
                                list2.remove(0);
                                list2.add(jSONObject.toString());
                                i = size;
                                list = list2;
                                z = false;
                            }
                            bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(d, z)));
                            if (!z) {
                                i = list.size();
                                for (i2 = 0; i2 < i; i2++) {
                                    if (i2 == 0) {
                                        bufferedWriter.append((CharSequence) list.get(i2));
                                    } else {
                                        bufferedWriter.append("\n" + ((String) list.get(i2)));
                                    }
                                }
                            } else if (i == 0) {
                                bufferedWriter.append(jSONObject.toString());
                            } else {
                                bufferedWriter.append("\n" + jSONObject.toString());
                            }
                            bufferedWriter.flush();
                            if (bufferedWriter != null) {
                                bufferedWriter.close();
                            }
                        } catch (Throwable th4) {
                            th = th4;
                            lineNumberReader = null;
                            if (lineNumberReader != null) {
                                lineNumberReader.close();
                            }
                            throw th;
                        }
                        list2 = arrayList;
                        if (list2 == null) {
                        }
                        if (size != 10) {
                            i = size;
                            z = true;
                            list = list2;
                        } else {
                            list2.remove(0);
                            list2.add(jSONObject.toString());
                            i = size;
                            list = list2;
                            z = false;
                        }
                    } else {
                        d.createNewFile();
                        z = true;
                        i = 0;
                        list = null;
                    }
                    bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(d, z)));
                    if (!z) {
                        i = list.size();
                        for (i2 = 0; i2 < i; i2++) {
                            if (i2 == 0) {
                                bufferedWriter.append((CharSequence) list.get(i2));
                            } else {
                                bufferedWriter.append("\n" + ((String) list.get(i2)));
                            }
                        }
                    } else if (i == 0) {
                        bufferedWriter.append(jSONObject.toString());
                    } else {
                        bufferedWriter.append("\n" + jSONObject.toString());
                    }
                    bufferedWriter.flush();
                    if (bufferedWriter != null) {
                        bufferedWriter.close();
                    }
                } catch (Throwable th5) {
                    th = th5;
                    bufferedWriter = null;
                    if (bufferedWriter != null) {
                        bufferedWriter.close();
                    }
                    throw th;
                }
            }
        }
    }

    public static void a(JSONObject jSONObject, al alVar) {
        new aj().b(jSONObject, alVar);
    }

    protected static String b() {
        if (b.a == 0) {
            return "";
        }
        return "runRealTime :" + a(SystemClock.elapsedRealtime() - b.a);
    }

    protected static String b(Context context) {
        if (context != null) {
            return !c.a("android.permission.READ_PHONE_STATE") ? "" : ((TelephonyManager) context.getSystemService("phone")).getLine1Number();
        } else {
            try {
                return "";
            } catch (Exception e) {
                e.printStackTrace();
                return "";
            }
        }
    }

    public static File c() {
        return d;
    }

    public static void c(Context context) {
        if (context != null && d != null && d.exists() && ab.a(context).getBoolean("shared_frist_init", true)) {
            d.delete();
            ab.b(context).putBoolean("shared_frist_init", false).apply();
        }
    }

    private static void c(JSONObject jSONObject, al alVar) {
        new aj().a(jSONObject, alVar);
    }

    public static Context d() {
        return a;
    }
}
