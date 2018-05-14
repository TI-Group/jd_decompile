package c.a;

/* compiled from: TbsSdkJava */
public enum t {
    LEGIT(1),
    ALIEN(2);
    
    private final int c;

    private t(int i) {
        this.c = i;
    }

    public int a() {
        return this.c;
    }

    public static t a(int i) {
        switch (i) {
            case 1:
                return LEGIT;
            case 2:
                return ALIEN;
            default:
                return null;
        }
    }
}
