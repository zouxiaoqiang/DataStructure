package application;

import list.*;

/*
* 存储每一项
* */


class Term implements Comparable<Term> {
    private double coef;
    private int expn;

    public Term(double coef, int expn) {
        this.coef = coef;
        this.expn = expn;
    }

    public void setCoef(double coef) {
        this.coef = coef;
    }

    public void setExpn(int expn) {
        this.expn = expn;
    }

    public double getCoef() {
        return coef;
    }

    public int getExpn() {
        return expn;
    }

    @Override
    public int compareTo(Term term) {
        if (expn == term.expn) {
            return 0;
        } else if (expn < term.expn) {
            return -1;
        } else {
            return 1;
        }
    }
}

/**
 * @author xiaoq
 */
public class Polynomial {
    private List<Term> list = new LinkList<>();

    public Polynomial(double[] coefs, int[] expns) throws ArrayIndexOutOfBoundsException {
        int size = expns.length;
        for (int i = 0; i < size; i++) {
            if (coefs[i] == 0) continue;
            Term term = new Term(coefs[i], expns[i]);
            orderAdd(term);
        }
    }

    // 以下循环中list.length()为可变量, 应小心处理

    // 按指数升序构造多项式
    private void orderAdd(Term t) {
        if (list.isEmpty()) {
            list.add(t);
            return;
        }
        for (int i = 1; i <= list.length(); i++) {
            Term tmp = (Term) list.get(i);
            if (t.compareTo(tmp) == 0) {
                // tmp是对象引用, 所以tmp的改变会同步该改变list中的元素
                tmp.setCoef(tmp.getCoef() + t.getCoef());
                if (tmp.getCoef() == 0) {
                    list.remove(i);
                    i--;
                }
                return;
            } else if (t.compareTo(tmp) < 0) {
                list.add(i, t);
                return;
            }
        }
        list.add(t);
    }

    // 多项式相加, 合并同类项
    public void add(Polynomial poly) {
        int i, j;
        for (i = 1, j = 1; i <= list.length() && j <= poly.list.length(); ) {
            Term l = (Term) list.get(i);
            Term r = (Term) poly.list.get(j);
            if (l.compareTo(r) == 0) {
                l.setCoef(l.getCoef() + r.getCoef());
                if (l.getCoef() == 0)
                    list.remove(i);
                j++;
            } else if (l.compareTo(r) < 0) {
                i++;
            } else {
                // 这里必须重新创建一个Term, 否则两个对象将共享r所指的地址，后果严重
                // 在涉及地址的操作时必须处处谨慎，否则排查bug的时候将步步艰难
                Term tmp = new Term(r.getCoef(), r.getExpn());
                list.add(i, tmp);
                i++;
                j++;
            }
        }
        while (j <= poly.list.length()) {
            Term tmp = (Term) poly.list.get(j);
            list.add(new Term(tmp.getCoef(), tmp.getExpn()));
            j++;
        }
    }

    // 多项式的每项依次与单项式相乘
    public void multi(Term t) {
        for (int i = 1; i <= list.length(); ) {
            Term tmp = (Term) list.get(i);
            tmp.setCoef(tmp.getCoef() * t.getCoef());
            tmp.setExpn(tmp.getExpn() + t.getExpn());
            if (tmp.getCoef() == 0)
                list.remove(i);
            else
                i++;
        }
    }

    public Polynomial copy() {
        int size = list.length();
        double[] ceofs = new double[size];
        int[] expns = new int[size];
        for (int i = 0; i < size; i++) {
            Term tmp = (Term) list.get(i + 1);
            ceofs[i] = tmp.getCoef();
            expns[i] = tmp.getExpn();
        }
        return new Polynomial(ceofs, expns);
    }

    // 多项式与多项式的乘积
    public void multi(Polynomial p) {
        int size = p.list.length();
        // 用数组暂时保存多项式this与p的每项相乘得到的多项式
        Polynomial[] polys = new Polynomial[size];
        for (int i = 1; i <= size; i++) {
            // 用副本防止this被污染
            Polynomial duplication = this.copy();
            Term tmp = (Term) p.list.get(i);
            // 将多项式p的每一项与多项式this相乘
            duplication.multi(new Term(tmp.getCoef(), tmp.getExpn()));
            polys[i - 1] = duplication;
        }
        list = polys[0].list;
        for (int i = 1; i < size; i++)
            add(polys[i]);
    }

    //多项式减法, this-p
    public void sub(Polynomial p) {
        // 将减法当作加法处理, 由于不能改变p, 只能两次对多项式this取相反数
        Term t = new Term(-1, 0);
        this.multi(t);
        this.add(p);
        this.multi(t);
    }

    public void print() {
        int size = list.length();
        for (int i = 1; i <= size; i++) {
            Term tmp = (Term) list.get(i);
            String sign = " + ";
            double p = tmp.getCoef();
            if (i != 1 && p < 0) {
                sign = " - ";
                p *= -1;
            }
            System.out.print((i == 1 ? "" : sign) + p + "x^" + tmp.getExpn());
        }
        System.out.println(); }

    public static void main(String[] args) {
        double[] c1 = {0, 0.5, 1, -1, 0.5};
        int[] e1 = {2, 1, 0, -1, 1};
        Polynomial p1 = new Polynomial(c1, e1);
        System.out.println("p1:");
        p1.print();
        double[] c2 = {0.5, 1, 0, 1, 0.5};
        int[] e2 = {1, 0, -1, -2, 1};
        Polynomial p2 = new Polynomial(c2, e2);
        System.out.println("p2:");
        p2.print();
        p1.add(p2);
        System.out.println("p1+p2:");
        p1.print();
        p1.sub(p2);
        System.out.println("p1+p2-p2:");
        p1.print();
        System.out.println("p1*p2:");
        p1.multi(p2);
        p1.print();
    }
}
