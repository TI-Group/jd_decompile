package c.a;

/* compiled from: TbsSdkJava */
public class bp extends az {
    public static final int a = 0;
    public static final int b = 1;
    public static final int c = 2;
    public static final int d = 3;
    public static final int e = 4;
    public static final int f = 5;
    protected int g = 0;

    public bp(int i) {
        this.g = i;
    }

    public bp(int i, String str) {
        super(str);
        this.g = i;
    }

    public bp(String str) {
        super(str);
    }

    public bp(int i, Throwable th) {
        super(th);
        this.g = i;
    }

    public bp(Throwable th) {
        super(th);
    }

    public bp(String str, Throwable th) {
        super(str, th);
    }

    public bp(int i, String str, Throwable th) {
        super(str, th);
        this.g = i;
    }

    public int a() {
        return this.g;
    }
}
