package application.stack;


import stack.LinkStack;
import stack.Stack;

public class ExStack {

    // 十进制转换为...
    public String decimalTo(long N, int t) {
        Stack<Long> S = new LinkStack<>();
        while (N > 0) {
            S.push(N % t);
            N = N / t;
        }
        StringBuilder res = new StringBuilder();
        while (!S.isEmpty())
            res.append(S.pop());
        return res.toString();
    }

    // 括号匹配
    public boolean matchParentheses(String s) {
        Stack<Character> S = new LinkStack<>();
        int size = s.length();
        for (int i = 0; i < size; i++) {
            char ch = s.charAt(i);
            switch (ch) {
                case '(':
                case '[':
                case '{':
                    S.push(ch);
                    break;
                case ')':
                    if (!S.pop().equals('('))
                        return false;
                    break;
                case ']':
                    if (!S.pop().equals('['))
                        return false;
                    break;
                case '}':
                    if (!S.pop().equals('{'))
                        return false;
                    break;
            }
        }
        return S.isEmpty();
    }

    // 行编辑程序
    public String editLine(String s) {
        Stack<Character> S = new LinkStack<>();
        int size = s.length();
        for (int i = 0; i < size; i++) {
            char c = s.charAt(i);
            switch (c) {
                case '#':
                    S.pop();
                    break;
                case '@':
                    S.clear();
                    break;
                default:
                    S.push(c);
            }
        }
        size = S.length();
        char[] cs = new char[size];
        for(int i = size-1; i >= 0; i--)
            cs[i] = S.pop();
        StringBuilder res = new StringBuilder();
        for(int i = 0; i < size; i++)
            res.append(cs[i]);
        return res.toString();
    }

    //迷宫求解


    public static void main(String[] args) {
        ExStack es = new ExStack();
        System.out.println(es.decimalTo(1348, 8));
        System.out.println(es.matchParentheses("[{()]f{}"));
        System.out.println(es.editLine("whli##ilr#e(s#*s)"));
    }

}
