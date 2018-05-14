package com.jingdong.jdma.common.utils;

import android.content.Context;
import android.os.Process;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Log;
import com.jingdong.jdma.JDMaInterface;
import com.jingdong.jdma.common.utils.e.a;
import com.jingdong.jdma.common.utils.e.b;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Pattern;

/* compiled from: TbsSdkJava */
public class CommonUtil {
    public static final String COMMON_MA_INIT_ACCESSBLOCKTIME = "common_ma_init_accblocktime";
    public static final int CONN_TIMEOUT = 10000;
    public static final long DEFAULT_LOOPBTW = 2;
    public static final Long DEFULT_UNWIFIREPORT_SIZE = Long.valueOf(0);
    public static final Long DEFULT_UNWIFI_INTER = Long.valueOf(300);
    public static final Long DEFULT_WIFI_INTER = Long.valueOf(300);
    public static final Long DEFULT_WIFI_REPORT_SIZE = Long.valueOf(5);
    public static final String EXCEPTION_TABLE_NAME = "exception";
    public static final int GET_STRATEGY_FAILDE_FOR_PARAM = 10;
    public static final int GET_STRATEGY_FAILDE_FOR_SYSTEM = 9;
    public static final int GET_STRATEGY_SUCC_CODE = 0;
    public static final int GET_STRATEGY_TYPE_UNANIMOUS_CODE = 1;
    private static String IMS = null;
    private static String IMSI = null;
    public static boolean LOGSWITCH = false;
    public static final int MAX_COUNT = 300;
    public static final int POST_TIMEOUT = 30000;
    public static final int RECORD_TYPE_EX = 1;
    public static final int RECORD_TYPE_MAX = 1;
    public static final int RECORD_TYPE_STATISTIC = 0;
    public static final int REPORT_DATA_SUCC = 0;
    public static final int REPORT_ERROR_BUT_DELETE_DATA = -3;
    public static final long REPORT_ERROR_SLEEP_TIME = 300000;
    public static final int REPORT_MESSAGE = 53;
    public static final int REPORT_NOTHING = -1;
    public static final int REPORT_OTHER_EXCEPTION = -2;
    public static final String REQUEST_HEADER = "JD-STD";
    public static final int RETRY_NUM = 3;
    public static final String RETURN_SUCC = "0";
    public static final int RETURN_SUCC_NUM = 0;
    public static final Long STATISTIC_DEFULT_2G_INTER = Long.valueOf(60);
    public static final Long STATISTIC_DEFULT_2G_SIZE = Long.valueOf(10);
    public static final Long STATISTIC_DEFULT_3G_INTER = Long.valueOf(60);
    public static final Long STATISTIC_DEFULT_3G_SIZE = Long.valueOf(10);
    public static final Long STATISTIC_DEFULT_4G_INTER = Long.valueOf(60);
    public static final Long STATISTIC_DEFULT_4G_SIZE = Long.valueOf(10);
    public static final Long STATISTIC_DEFULT_CYC = Long.valueOf(0);
    public static final Long STATISTIC_DEFULT_LOOPBTW = Long.valueOf(2);
    public static final int STATISTIC_DEFULT_RET = 1;
    public static final int STATISTIC_DEFULT_SPD = 30;
    public static final String STATISTIC_DEFULT_VERSION = "0.0";
    public static final Long STATISTIC_DEFULT_WIFI_INTER = Long.valueOf(30);
    public static final Long STATISTIC_DEFULT_WIFI_REPORT_SIZE = Long.valueOf(20);
    public static final String STATISTIC_GET_STRATEGY_ADDRESS_SUFFIX = "/m/log/v1";
    public static final String STATISTIC_GET_STRATEGY_DEFAULT_DOMAIN = "policy.jd.com";
    public static final String STATISTIC_REPORT_DATA_ADDRESS_SUFFIX = "/log/sdk";
    public static final String STATISTIC_REPORT_DATA_DEFAULT_DOMAIN = "saturn.jd.com";
    public static final String STATISTIC_REPORT_METHOD = "bp.report";
    public static final String STATISTIC_STRATEGY_KEY = "statisticstrategy";
    public static final String STATISTIC_TABLE_NAME = "statistic";
    public static final int STRATEGY_UPDATE_MESSAGE = 51;
    public static final String[] TABLE_NAME_LIST = new String[]{STATISTIC_TABLE_NAME};
    public static final String TAG = "JDMASDK";
    public static final String URL_HEADER = "https://";
    public static final String UTF8 = "utf-8";
    public static final String UUID_KEY = "mauuidkey";
    public static CommonUtil commonUtilInstance;
    public static String huanhangSymbol = "\n";
    public static String keyValueSymbol = "\t:\t";

    public static synchronized String getIMS(Context context) {
        String str;
        synchronized (CommonUtil.class) {
            if (IMS == null) {
                if (context == null) {
                    str = "";
                } else {
                    final TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
                    e.a(context, "android.permission.READ_PHONE_STATE", new b() {
                        public Object a() {
                            String simOperator = telephonyManager.getSimOperator();
                            if (simOperator != null) {
                                CommonUtil.IMS = simOperator;
                            } else {
                                CommonUtil.IMS = "";
                            }
                            return null;
                        }
                    }, new a() {
                        public Object a() {
                            CommonUtil.IMS = "";
                            return null;
                        }
                    });
                }
            }
            str = IMS;
        }
        return str;
    }

    public static synchronized String getIMSI(Context context) {
        String str;
        synchronized (CommonUtil.class) {
            if (IMSI == null) {
                if (context == null) {
                    str = "";
                } else {
                    final TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
                    e.a(context, "android.permission.READ_PHONE_STATE", new b() {
                        public Object a() {
                            String subscriberId = telephonyManager.getSubscriberId();
                            if (subscriberId != null) {
                                CommonUtil.IMSI = subscriberId;
                            } else {
                                CommonUtil.IMSI = "";
                            }
                            return null;
                        }
                    }, new a() {
                        public Object a() {
                            CommonUtil.IMSI = "";
                            return null;
                        }
                    });
                }
            }
            str = IMSI;
        }
        return str;
    }

    public static String getCurrentMicrosecond() {
        return "" + String.format("%.6f", new Object[]{Double.valueOf((((double) System.currentTimeMillis()) + JDMaInterface.PV_UPPERLIMIT) / 1000.0d)});
    }

    public static CommonUtil getCommonUtilInstance() {
        if (commonUtilInstance == null) {
            commonUtilInstance = new CommonUtil();
        }
        return commonUtilInstance;
    }

    public static void commonUtilLog(String str, String str2) {
        if (LOGSWITCH) {
            Log.d(str, str2);
        }
    }

    public static boolean isNumeric(String str) {
        return Pattern.compile("[0-9]*").matcher(str.trim()).matches();
    }

    public static Long parseLongPositive(String str) {
        if (TextUtils.isEmpty(str)) {
            return Long.valueOf(0);
        }
        Long valueOf = Long.valueOf(0);
        try {
            if (!isNumeric(str)) {
                return valueOf;
            }
            try {
                return Long.valueOf(Long.parseLong(str));
            } catch (Exception e) {
                e.printStackTrace();
                return valueOf;
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            return valueOf;
        }
    }

    public static boolean isMainProcess(Context context) {
        CharSequence trim = getProcessName(Process.myPid()).trim();
        if (TextUtils.isEmpty(trim) || context == null || !TextUtils.equals(trim, context.getPackageName())) {
            return false;
        }
        return true;
    }

    public static String getProcessName(int i) {
        InputStreamReader inputStreamReader;
        BufferedReader bufferedReader;
        FileNotFoundException e;
        InputStreamReader inputStreamReader2;
        IOException e2;
        Throwable th;
        BufferedReader bufferedReader2 = null;
        int i2 = 0;
        try {
            inputStreamReader = new InputStreamReader(new FileInputStream("/proc/" + i + "/cmdline"));
            try {
                bufferedReader = new BufferedReader(inputStreamReader);
                try {
                    char[] cArr = new char[64];
                    bufferedReader.read(cArr);
                    int length = cArr.length;
                    int i3 = 0;
                    while (i2 < length && cArr[i2] != '\u0000') {
                        i3++;
                        i2++;
                    }
                    String str = new String(cArr, 0, i3);
                    if (inputStreamReader != null) {
                        try {
                            inputStreamReader.close();
                        } catch (IOException e3) {
                            e3.printStackTrace();
                        }
                    }
                    if (bufferedReader == null) {
                        return str;
                    }
                    try {
                        bufferedReader.close();
                        return str;
                    } catch (IOException e4) {
                        e4.printStackTrace();
                        return str;
                    }
                } catch (FileNotFoundException e5) {
                    e = e5;
                    inputStreamReader2 = inputStreamReader;
                    try {
                        e.printStackTrace();
                        if (inputStreamReader2 != null) {
                            try {
                                inputStreamReader2.close();
                            } catch (IOException e22) {
                                e22.printStackTrace();
                            }
                        }
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (IOException e222) {
                                e222.printStackTrace();
                            }
                        }
                        return "";
                    } catch (Throwable th2) {
                        th = th2;
                        inputStreamReader = inputStreamReader2;
                        bufferedReader2 = bufferedReader;
                        if (inputStreamReader != null) {
                            try {
                                inputStreamReader.close();
                            } catch (IOException e42) {
                                e42.printStackTrace();
                            }
                        }
                        if (bufferedReader2 != null) {
                            try {
                                bufferedReader2.close();
                            } catch (IOException e422) {
                                e422.printStackTrace();
                            }
                        }
                        throw th;
                    }
                } catch (IOException e6) {
                    e222 = e6;
                    bufferedReader2 = bufferedReader;
                    try {
                        e222.printStackTrace();
                        if (inputStreamReader != null) {
                            try {
                                inputStreamReader.close();
                            } catch (IOException e2222) {
                                e2222.printStackTrace();
                            }
                        }
                        if (bufferedReader2 != null) {
                            try {
                                bufferedReader2.close();
                            } catch (IOException e22222) {
                                e22222.printStackTrace();
                            }
                        }
                        return "";
                    } catch (Throwable th3) {
                        th = th3;
                        if (inputStreamReader != null) {
                            inputStreamReader.close();
                        }
                        if (bufferedReader2 != null) {
                            bufferedReader2.close();
                        }
                        throw th;
                    }
                } catch (Throwable th4) {
                    th = th4;
                    bufferedReader2 = bufferedReader;
                    if (inputStreamReader != null) {
                        inputStreamReader.close();
                    }
                    if (bufferedReader2 != null) {
                        bufferedReader2.close();
                    }
                    throw th;
                }
            } catch (FileNotFoundException e7) {
                e = e7;
                bufferedReader = null;
                inputStreamReader2 = inputStreamReader;
                e.printStackTrace();
                if (inputStreamReader2 != null) {
                    inputStreamReader2.close();
                }
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
                return "";
            } catch (IOException e8) {
                e22222 = e8;
                e22222.printStackTrace();
                if (inputStreamReader != null) {
                    inputStreamReader.close();
                }
                if (bufferedReader2 != null) {
                    bufferedReader2.close();
                }
                return "";
            }
        } catch (FileNotFoundException e9) {
            e = e9;
            bufferedReader = null;
            e.printStackTrace();
            if (inputStreamReader2 != null) {
                inputStreamReader2.close();
            }
            if (bufferedReader != null) {
                bufferedReader.close();
            }
            return "";
        } catch (IOException e10) {
            e22222 = e10;
            inputStreamReader = null;
            e22222.printStackTrace();
            if (inputStreamReader != null) {
                inputStreamReader.close();
            }
            if (bufferedReader2 != null) {
                bufferedReader2.close();
            }
            return "";
        } catch (Throwable th5) {
            th = th5;
            inputStreamReader = null;
            if (inputStreamReader != null) {
                inputStreamReader.close();
            }
            if (bufferedReader2 != null) {
                bufferedReader2.close();
            }
            throw th;
        }
    }
}
