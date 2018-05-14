package c.a;

/* compiled from: TbsSdkJava */
public class cd extends az {
    public static final int a = 0;
    public static final int b = 1;
    public static final int c = 2;
    public static final int d = 3;
    public static final int e = 4;
    protected int f = 0;

    public cd(int i) {
        this.f = i;
    }

    public cd(int i, String str) {
        super(str);
        this.f = i;
    }

    public cd(String str) {
        super(str);
    }

    public cd(int i, Throwable th) {
        super(th);
        this.f = i;
    }

    public cd(Throwable th) {
        super(th);
    }

    public cd(String str, Throwable th) {
        super(str, th);
    }

    public cd(int i, String str, Throwable th) {
        super(str, th);
        this.f = i;
    }

    public int a() {
        return this.f;
    }
}
