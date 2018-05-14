package com.kepler.sdk;

import android.os.Process;
import com.kepler.jd.login.KeplerApiManager;

/* compiled from: TbsSdkJava */
public class aa {
    private ab a;
    private String b;
    private ad c;
    private Thread d;
    private ac e;
    private ae f;
    private int g;
    private a h;

    /* compiled from: TbsSdkJava */
    interface a {
        boolean a(int i);
    }

    public a a() {
        if (this.h == null) {
            this.h = d();
        }
        return this.h;
    }

    private a d() {
        return new a(this) {
            int[] a = new int[]{KeplerApiManager.NetLinker_Err_IOException, KeplerApiManager.NetLinker_Err_NoNetwork};
            final /* synthetic */ aa b;

            {
                this.b = r2;
            }

            public boolean a(int i) {
                if (this.a != null) {
                    for (int i2 : this.a) {
                        if (i2 == i) {
                            return false;
                        }
                    }
                }
                return true;
            }
        };
    }

    private aa(ab abVar) {
        this.g = -1;
        this.a = abVar;
    }

    public aa(ab abVar, String str, int i, ad adVar) {
        this(abVar);
        this.g = i;
        this.b = str;
        this.c = adVar;
    }

    public void a(ac acVar) {
        if (this.c != null) {
            this.c.a(acVar);
        }
    }

    public void a(int i, String str) {
        b(i, str);
        if (this.c != null) {
            this.c.a(i, str);
        }
    }

    private void b(int i, String str) {
        try {
            if (a().a(i)) {
                l.a(str, this.b.replaceAll(" ", "_") + "_" + i);
            }
        } catch (Throwable th) {
            p.a(th);
        }
    }

    public void b() {
        try {
            if (this.d != null) {
                this.d.destroy();
            }
            if (this.f != null) {
                this.f.a();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        this.c = null;
    }

    public void c() {
        if (ao.a(KeplerApiManager.getWebViewService().getApplicatonContext())) {
            String str;
            Runnable anonymousClass2 = new Runnable(this) {
                final /* synthetic */ aa a;

                {
                    this.a = r1;
                }

                public void run() {
                    if (this.a.g > 0) {
                        Process.setThreadPriority(this.a.g);
                    }
                    try {
                        if (o.q) {
                            Thread.sleep(200);
                        }
                    } catch (Throwable e) {
                        p.a(e);
                    }
                    try {
                        this.a.f = new ae();
                        this.a.e = this.a.f.a(this.a.a);
                        int a = this.a.e.a();
                        if (a != 200) {
                            this.a.a((int) KeplerApiManager.NetLinker_Err_Not_200, "response not 200 " + a);
                            if (this.a.f != null) {
                                try {
                                    this.a.f.a();
                                } catch (Throwable e2) {
                                    e2.printStackTrace();
                                }
                            }
                        } else if (aq.a(this.a.e.b())) {
                            this.a.a((int) KeplerApiManager.NetLinker_Err_NetException, "response string null " + a);
                            if (this.a.f != null) {
                                try {
                                    this.a.f.a();
                                } catch (Throwable e22) {
                                    e22.printStackTrace();
                                }
                            }
                        } else {
                            this.a.a(this.a.e);
                            if (this.a.f != null) {
                                try {
                                    this.a.f.a();
                                } catch (Throwable e222) {
                                    e222.printStackTrace();
                                }
                            }
                        }
                    } catch (Throwable e2222) {
                        p.a(e2222);
                        this.a.a((int) KeplerApiManager.NetLinker_Err_IOException, e2222.getMessage());
                        if (this.a.f != null) {
                            this.a.f.a();
                        }
                    } catch (Throwable e22222) {
                        p.a(e22222);
                        this.a.a(-1000, e22222.getMessage());
                        if (this.a.f != null) {
                            this.a.f.a();
                        }
                    } catch (Throwable e222222) {
                        p.a(e222222);
                        this.a.a((int) KeplerApiManager.NetLinker_Err_NoSuchAlgorithmException, e222222.getMessage());
                        if (this.a.f != null) {
                            this.a.f.a();
                        }
                    } catch (Throwable e2222222) {
                        p.a(e2222222);
                        this.a.a((int) KeplerApiManager.NetLinker_Err_IOException, e2222222.getMessage());
                        if (this.a.f != null) {
                            this.a.f.a();
                        }
                    } catch (Throwable e22222222) {
                        p.a(e22222222);
                        this.a.a((int) KeplerApiManager.NetLinker_Err_NetException, e22222222.getMessage());
                        if (this.a.f != null) {
                            this.a.f.a();
                        }
                    } catch (Throwable e222222222) {
                        e222222222.printStackTrace();
                    }
                }
            };
            if (this.b == null) {
                str = "";
            } else {
                str = this.b;
            }
            this.d = new Thread(anonymousClass2, str);
            this.d.start();
            return;
        }
        a((int) KeplerApiManager.NetLinker_Err_NoNetwork, a.a().b("kepler_check_net"));
    }
}
