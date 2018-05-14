package com.jingdong.crash.inner;

import android.util.Log;
import cn.jiguang.net.HttpUtils;
import com.jingdong.jdma.common.utils.CommonUtil;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import javax.net.ssl.HttpsURLConnection;
import org.apache.http.protocol.HTTP;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

class aj {
    public static int a = 5000;

    aj() {
    }

    private HttpURLConnection a(URL url) {
        return (HttpURLConnection) url.openConnection();
    }

    private byte[] a(Map map, String str, boolean z) {
        StringBuilder stringBuilder = new StringBuilder();
        if (z) {
            try {
                for (Entry entry : map.entrySet()) {
                    stringBuilder.append(URLEncoder.encode((String) entry.getKey(), str));
                    stringBuilder.append('=');
                    stringBuilder.append(URLEncoder.encode((String) entry.getValue(), str));
                    stringBuilder.append('&');
                }
                return stringBuilder.toString().getBytes(str);
            } catch (Throwable e) {
                throw new RuntimeException("Encoding not supported: " + str, e);
            }
        }
        for (Entry entry2 : map.entrySet()) {
            stringBuilder.append((String) entry2.getKey());
            stringBuilder.append('=');
            stringBuilder.append((String) entry2.getValue());
            stringBuilder.append('&');
        }
        return stringBuilder.toString().getBytes();
    }

    private HttpURLConnection b(URL url) {
        HttpURLConnection a = a(url);
        int i = a;
        a.setConnectTimeout(i);
        a.setReadTimeout(i);
        a.setUseCaches(false);
        a.setDoInput(true);
        if ("https".equals(url.getProtocol())) {
            ((HttpsURLConnection) a).setHostnameVerifier(new ak(this));
        }
        return a;
    }

    public String a() {
        return CommonUtil.URL_HEADER + p.a() + "/client.action";
    }

    void a(al alVar, HashMap hashMap, String str) {
        InputStreamReader inputStreamReader;
        BufferedReader bufferedReader;
        Exception e;
        InputStreamReader inputStreamReader2;
        Throwable th;
        BufferedReader bufferedReader2 = null;
        try {
            URL url = new URL(b(str));
            if (ah.b) {
                ah.a("NetWorkHelper", "url is ........" + b(str));
            }
            HttpURLConnection b = b(url);
            a(b, a((Map) hashMap));
            b.getResponseCode();
            String responseMessage = b.getResponseMessage();
            String str2 = "";
            inputStreamReader = new InputStreamReader(b.getInputStream());
            try {
                bufferedReader = new BufferedReader(inputStreamReader);
                try {
                    String str3 = "";
                    while (true) {
                        str3 = bufferedReader.readLine();
                        if (str3 == null) {
                            break;
                        }
                        str2 = str2 + str3 + "\n";
                    }
                    int optInt = new JSONObject(str2).optInt("code");
                    if (optInt == 0) {
                        Log.d("NetWorkHelper", "upLoadErrors  success........" + responseMessage + " resultData..." + str2);
                        if (alVar != null) {
                            alVar.a(optInt, str2);
                        }
                    } else {
                        Log.d("NetWorkHelper", "upLoadErrors  error........" + responseMessage + " resultData..." + str2);
                        if (alVar != null) {
                            alVar.b(optInt, str2);
                        }
                    }
                    b.disconnect();
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (IOException e2) {
                            e2.printStackTrace();
                        }
                    }
                    if (inputStreamReader != null) {
                        try {
                            inputStreamReader.close();
                        } catch (IOException e22) {
                            e22.printStackTrace();
                        }
                    }
                } catch (Exception e3) {
                    e = e3;
                    bufferedReader2 = bufferedReader;
                    inputStreamReader2 = inputStreamReader;
                    try {
                        Log.d("NetWorkHelper", "upLoadErrors  exception.......... ");
                        e.printStackTrace();
                        if (alVar != null) {
                            alVar.b(-1, "upLoadErrors exception..");
                        }
                        if (bufferedReader2 != null) {
                            try {
                                bufferedReader2.close();
                            } catch (IOException e222) {
                                e222.printStackTrace();
                            }
                        }
                        if (inputStreamReader2 == null) {
                            try {
                                inputStreamReader2.close();
                            } catch (IOException e2222) {
                                e2222.printStackTrace();
                            }
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        inputStreamReader = inputStreamReader2;
                        bufferedReader = bufferedReader2;
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (IOException e4) {
                                e4.printStackTrace();
                            }
                        }
                        if (inputStreamReader != null) {
                            try {
                                inputStreamReader.close();
                            } catch (IOException e42) {
                                e42.printStackTrace();
                            }
                        }
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    if (bufferedReader != null) {
                        bufferedReader.close();
                    }
                    if (inputStreamReader != null) {
                        inputStreamReader.close();
                    }
                    throw th;
                }
            } catch (Exception e5) {
                e = e5;
                inputStreamReader2 = inputStreamReader;
                Log.d("NetWorkHelper", "upLoadErrors  exception.......... ");
                e.printStackTrace();
                if (alVar != null) {
                    alVar.b(-1, "upLoadErrors exception..");
                }
                if (bufferedReader2 != null) {
                    bufferedReader2.close();
                }
                if (inputStreamReader2 == null) {
                    inputStreamReader2.close();
                }
            } catch (Throwable th4) {
                th = th4;
                bufferedReader = null;
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
                if (inputStreamReader != null) {
                    inputStreamReader.close();
                }
                throw th;
            }
        } catch (Exception e6) {
            e = e6;
            inputStreamReader2 = null;
            Log.d("NetWorkHelper", "upLoadErrors  exception.......... ");
            e.printStackTrace();
            if (alVar != null) {
                alVar.b(-1, "upLoadErrors exception..");
            }
            if (bufferedReader2 != null) {
                bufferedReader2.close();
            }
            if (inputStreamReader2 == null) {
                inputStreamReader2.close();
            }
        } catch (Throwable th5) {
            th = th5;
            bufferedReader = null;
            inputStreamReader = null;
            if (bufferedReader != null) {
                bufferedReader.close();
            }
            if (inputStreamReader != null) {
                inputStreamReader.close();
            }
            throw th;
        }
    }

    public void a(HttpURLConnection httpURLConnection, byte[] bArr) {
        if (bArr != null) {
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.addRequestProperty("Content-Type", c());
            DataOutputStream dataOutputStream = new DataOutputStream(httpURLConnection.getOutputStream());
            dataOutputStream.write(bArr);
            dataOutputStream.close();
        }
    }

    public void a(JSONObject jSONObject, al alVar) {
        if (jSONObject != null) {
            try {
                jSONObject.put("verify", b());
            } catch (JSONException e) {
                if (alVar != null) {
                    alVar.b(-1, "upLoadErrors prepare data exception..");
                }
                if (ah.b) {
                    e.printStackTrace();
                }
            }
            HashMap hashMap = new HashMap();
            hashMap.put("body", jSONObject.toString());
            if (ah.b) {
                ah.a("NetWorkHelper", "upLoadLocalErrors body is ........" + jSONObject.toString());
            }
            a(alVar, hashMap, "sdkcrash");
        }
    }

    @Deprecated
    public byte[] a(Map map) {
        return (map == null || map.size() <= 0) ? null : a(map, HTTP.UTF_8, true);
    }

    public String b(String str) {
        return a() + HttpUtils.URL_AND_PARA_SEPARATOR + "functionId=" + str + k.a();
    }

    JSONObject b() {
        long currentTimeMillis = System.currentTimeMillis();
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(p.d);
        stringBuffer.append("crsdkandr");
        stringBuffer.append("1.0.1");
        stringBuffer.append(k.b());
        stringBuffer.append(currentTimeMillis);
        stringBuffer.append("f4111736f15b4ef4bd4e4b70380b9ecd");
        String a = j.a(stringBuffer.toString(), p.c);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("st", String.valueOf(currentTimeMillis));
            jSONObject.put("sign", a);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    public void b(JSONObject jSONObject, al alVar) {
        JSONArray jSONArray = new JSONArray();
        jSONArray.put(jSONObject);
        JSONObject b = b();
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("msg", jSONArray);
            jSONObject2.put("verify", b);
        } catch (JSONException e) {
            if (alVar != null) {
                alVar.b(-1, "upLoadErrors prepare data exception..");
            }
            if (ah.b) {
                e.printStackTrace();
            }
        }
        HashMap hashMap = new HashMap();
        hashMap.put("body", jSONObject2.toString());
        if (ah.b) {
            ah.a("NetWorkHelper", "body is ........" + jSONObject2.toString());
        }
        a(alVar, hashMap, "sdkcrash");
    }

    public String c() {
        return "application/x-www-form-urlencoded; charset=UTF-8";
    }
}
