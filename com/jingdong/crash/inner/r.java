package com.jingdong.crash.inner;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import org.apache.http.protocol.HTTP;
import org.json.JSONArray;
import org.json.JSONObject;

final class r extends Thread {
    final /* synthetic */ u a;

    r(u uVar) {
        this.a = uVar;
    }

    public void run() {
        JSONObject jSONObject;
        Exception e;
        Throwable th;
        JSONObject jSONObject2 = null;
        synchronized (q.f) {
            LineNumberReader lineNumberReader;
            try {
                lineNumberReader = new LineNumberReader(new InputStreamReader(new FileInputStream(q.d), HTTP.UTF_8));
                try {
                    JSONArray jSONArray = new JSONArray();
                    while (true) {
                        String readLine = lineNumberReader.readLine();
                        if (readLine == null) {
                            break;
                        } else if (readLine.length() > 0) {
                            jSONArray.put(new JSONObject(readLine));
                        }
                    }
                    if (jSONArray.length() <= 0) {
                        if (lineNumberReader != null) {
                            try {
                                lineNumberReader.close();
                            } catch (IOException e2) {
                                if (ah.e) {
                                    e2.printStackTrace();
                                }
                            }
                        }
                        return;
                    }
                    jSONObject = new JSONObject();
                    try {
                        jSONObject.put("msg", jSONArray);
                        if (lineNumberReader != null) {
                            try {
                                lineNumberReader.close();
                            } catch (IOException e22) {
                                if (ah.e) {
                                    e22.printStackTrace();
                                }
                            }
                        }
                    } catch (Exception e3) {
                        e = e3;
                        jSONObject2 = jSONObject;
                        try {
                            if (ah.e) {
                                e.printStackTrace();
                            }
                            if (lineNumberReader != null) {
                                try {
                                    lineNumberReader.close();
                                    jSONObject = jSONObject2;
                                } catch (IOException e222) {
                                    if (ah.e) {
                                        e222.printStackTrace();
                                    }
                                    jSONObject = jSONObject2;
                                }
                            } else {
                                jSONObject = jSONObject2;
                            }
                            q.c(jSONObject, new s(this));
                        } catch (Throwable th2) {
                            th = th2;
                            if (lineNumberReader != null) {
                                try {
                                    lineNumberReader.close();
                                } catch (IOException e4) {
                                    if (ah.e) {
                                        e4.printStackTrace();
                                    }
                                }
                            }
                            throw th;
                        }
                    }
                    try {
                        q.c(jSONObject, new s(this));
                    } catch (Exception e5) {
                        if (this.a != null) {
                            this.a.a(false);
                        }
                        e5.printStackTrace();
                    }
                } catch (Exception e6) {
                    e5 = e6;
                    if (ah.e) {
                        e5.printStackTrace();
                    }
                    if (lineNumberReader != null) {
                        lineNumberReader.close();
                        jSONObject = jSONObject2;
                    } else {
                        jSONObject = jSONObject2;
                    }
                    q.c(jSONObject, new s(this));
                }
            } catch (Exception e7) {
                e5 = e7;
                lineNumberReader = null;
                if (ah.e) {
                    e5.printStackTrace();
                }
                if (lineNumberReader != null) {
                    jSONObject = jSONObject2;
                } else {
                    lineNumberReader.close();
                    jSONObject = jSONObject2;
                }
                q.c(jSONObject, new s(this));
            } catch (Throwable th3) {
                th = th3;
                lineNumberReader = null;
                if (lineNumberReader != null) {
                    lineNumberReader.close();
                }
                throw th;
            }
        }
    }
}
