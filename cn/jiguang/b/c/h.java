package cn.jiguang.b.c;

import android.support.v4.internal.view.SupportMenu;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public final class h implements Cloneable {
    private static m[] d = new m[0];
    private static l[] e = new l[0];
    private g a;
    private List[] b;
    private int c;

    public h() {
        this(new g());
    }

    private h(d dVar) {
        this(new g(dVar));
        int i = 0;
        while (i < 4) {
            try {
                int b = this.a.b(i);
                if (b > 0) {
                    this.b[i] = new ArrayList(b);
                }
                for (int i2 = 0; i2 < b; i2++) {
                    this.b[i].add(m.a(dVar, i));
                }
                i++;
            } catch (t e) {
                throw e;
            }
        }
        this.c = dVar.a();
    }

    private h(g gVar) {
        this.b = new List[4];
        this.a = gVar;
    }

    public h(byte[] bArr) {
        this(new d(bArr));
    }

    public static h a(m mVar) {
        h hVar = new h();
        if (hVar.b[0] == null) {
            hVar.b[0] = new LinkedList();
        }
        hVar.a.a(0);
        hVar.b[0].add(mVar);
        return hVar;
    }

    public final m a() {
        List list = this.b[0];
        return (list == null || list.size() == 0) ? null : (m) list.get(0);
    }

    public final l[] a(int i) {
        if (this.b[1] == null) {
            return e;
        }
        m[] mVarArr;
        List linkedList = new LinkedList();
        if (this.b[1] == null) {
            mVarArr = d;
        } else {
            List list = this.b[1];
            mVarArr = (m[]) list.toArray(new m[list.size()]);
        }
        Set hashSet = new HashSet();
        int i2 = 0;
        while (i2 < mVarArr.length) {
            int i3;
            j b = mVarArr[i2].b();
            if (hashSet.contains(b)) {
                for (int size = linkedList.size() - 1; size >= 0; size--) {
                    l lVar = (l) linkedList.get(size);
                    if (lVar.b().d() == mVarArr[i2].d() && lVar.b().e() == mVarArr[i2].e() && lVar.b().b().equals(b)) {
                        lVar.a(mVarArr[i2]);
                        i3 = 0;
                        break;
                    }
                }
            }
            i3 = 1;
            if (i3 != 0) {
                linkedList.add(new l(mVarArr[i2]));
                hashSet.add(b);
            }
            i2++;
        }
        return (l[]) linkedList.toArray(new l[linkedList.size()]);
    }

    public final byte[] b(int i) {
        e eVar = new e();
        this.a.a(eVar);
        b bVar = new b();
        this.a.a();
        for (int i2 = 0; i2 < 4; i2++) {
            if (this.b[i2] != null) {
                int size = this.b[i2].size();
                int a = eVar.a();
                int i3 = 0;
                int i4 = 0;
                m mVar = null;
                int i5 = 0;
                while (i5 < size) {
                    int i6;
                    m mVar2 = (m) this.b[i2].get(i5);
                    if (i2 == 3) {
                        m mVar3 = mVar;
                        i6 = a;
                        a = i3;
                        i3 = i4 + 1;
                        mVar2 = mVar3;
                    } else {
                        if (mVar != null) {
                            Object obj = (mVar2.d() == mVar.d() && mVar2.e() == mVar.e() && mVar2.b().equals(mVar.b())) ? 1 : null;
                            if (obj == null) {
                                a = eVar.a();
                                i3 = i5;
                            }
                        }
                        mVar2.a(eVar, bVar);
                        if (eVar.a() > SupportMenu.USER_MASK) {
                            eVar.a(a);
                            int i7 = (size - i3) + i4;
                            break;
                        }
                        i6 = a;
                        a = i3;
                        i3 = i4;
                    }
                    i5++;
                    i4 = i3;
                    i3 = a;
                    a = i6;
                    mVar = mVar2;
                }
            }
        }
        this.c = eVar.a();
        return eVar.b();
    }

    public final Object clone() {
        h hVar = new h();
        for (int i = 0; i < this.b.length; i++) {
            if (this.b[i] != null) {
                hVar.b[i] = new LinkedList(this.b[i]);
            }
        }
        hVar.a = (g) this.a.clone();
        hVar.c = this.c;
        return hVar;
    }
}
