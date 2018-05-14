package com.jingdong.crash.inner;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.os.Process;
import android.text.TextUtils;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

class d {
    public static String a(int i) {
        FileNotFoundException e;
        InputStreamReader inputStreamReader;
        IOException e2;
        Throwable th;
        BufferedReader bufferedReader = null;
        int i2 = 0;
        InputStreamReader inputStreamReader2;
        BufferedReader bufferedReader2;
        try {
            inputStreamReader2 = new InputStreamReader(new FileInputStream("/proc/" + i + "/cmdline"));
            try {
                bufferedReader2 = new BufferedReader(inputStreamReader2);
                try {
                    char[] cArr = new char[64];
                    bufferedReader2.read(cArr);
                    int length = cArr.length;
                    int i3 = 0;
                    while (i2 < length && cArr[i2] != '\u0000') {
                        i3++;
                        i2++;
                    }
                    String str = new String(cArr, 0, i3);
                    if (inputStreamReader2 != null) {
                        try {
                            inputStreamReader2.close();
                        } catch (IOException e3) {
                            e3.printStackTrace();
                        }
                    }
                    if (bufferedReader2 == null) {
                        return str;
                    }
                    try {
                        bufferedReader2.close();
                        return str;
                    } catch (IOException e4) {
                        return str;
                    }
                } catch (FileNotFoundException e5) {
                    e = e5;
                    inputStreamReader = inputStreamReader2;
                    try {
                        e.printStackTrace();
                        if (inputStreamReader != null) {
                            try {
                                inputStreamReader.close();
                            } catch (IOException e22) {
                                e22.printStackTrace();
                            }
                        }
                        if (bufferedReader2 != null) {
                            try {
                                bufferedReader2.close();
                            } catch (IOException e6) {
                            }
                        }
                        return "";
                    } catch (Throwable th2) {
                        th = th2;
                        inputStreamReader2 = inputStreamReader;
                        bufferedReader = bufferedReader2;
                        if (inputStreamReader2 != null) {
                            try {
                                inputStreamReader2.close();
                            } catch (IOException e7) {
                                e7.printStackTrace();
                            }
                        }
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (IOException e8) {
                            }
                        }
                        throw th;
                    }
                } catch (IOException e9) {
                    e22 = e9;
                    bufferedReader = bufferedReader2;
                    try {
                        e22.printStackTrace();
                        if (inputStreamReader2 != null) {
                            try {
                                inputStreamReader2.close();
                            } catch (IOException e222) {
                                e222.printStackTrace();
                            }
                        }
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (IOException e10) {
                            }
                        }
                        return "";
                    } catch (Throwable th3) {
                        th = th3;
                        if (inputStreamReader2 != null) {
                            inputStreamReader2.close();
                        }
                        if (bufferedReader != null) {
                            bufferedReader.close();
                        }
                        throw th;
                    }
                } catch (Throwable th4) {
                    th = th4;
                    bufferedReader = bufferedReader2;
                    if (inputStreamReader2 != null) {
                        inputStreamReader2.close();
                    }
                    if (bufferedReader != null) {
                        bufferedReader.close();
                    }
                    throw th;
                }
            } catch (FileNotFoundException e11) {
                e = e11;
                bufferedReader2 = null;
                inputStreamReader = inputStreamReader2;
                e.printStackTrace();
                if (inputStreamReader != null) {
                    inputStreamReader.close();
                }
                if (bufferedReader2 != null) {
                    bufferedReader2.close();
                }
                return "";
            } catch (IOException e12) {
                e222 = e12;
                e222.printStackTrace();
                if (inputStreamReader2 != null) {
                    inputStreamReader2.close();
                }
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
                return "";
            }
        } catch (FileNotFoundException e13) {
            e = e13;
            bufferedReader2 = null;
            e.printStackTrace();
            if (inputStreamReader != null) {
                inputStreamReader.close();
            }
            if (bufferedReader2 != null) {
                bufferedReader2.close();
            }
            return "";
        } catch (IOException e14) {
            e222 = e14;
            inputStreamReader2 = null;
            e222.printStackTrace();
            if (inputStreamReader2 != null) {
                inputStreamReader2.close();
            }
            if (bufferedReader != null) {
                bufferedReader.close();
            }
            return "";
        } catch (Throwable th5) {
            th = th5;
            inputStreamReader2 = null;
            if (inputStreamReader2 != null) {
                inputStreamReader2.close();
            }
            if (bufferedReader != null) {
                bufferedReader.close();
            }
            throw th;
        }
    }

    public static boolean a(Context context) {
        List<RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses();
        if (runningAppProcesses == null) {
            return false;
        }
        for (RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
            if (runningAppProcessInfo.processName.equals(context.getPackageName())) {
                return runningAppProcessInfo.importance == 100;
            }
        }
        return false;
    }

    public static boolean b(Context context) {
        if (context == null) {
            return false;
        }
        CharSequence trim = a(Process.myPid()).trim();
        return !TextUtils.isEmpty(trim) && TextUtils.equals(trim, context.getPackageName());
    }
}
