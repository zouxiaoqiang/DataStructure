package application.stack;

import stack.LinkStack;
import stack.Stack;

import java.util.Scanner;

// Expression Evaluation
public class ExprEvaluation {
    // Precedence between operators
    char[][] Precedence = {
            {'>', '>', '<', '<', '<', '>', '>'},
            {'>', '>', '<', '<', '<', '>', '>'},
            {'>', '>', '>', '>', '<', '>', '>'},
            {'>', '>', '>', '>', '<', '>', '>'},
            {'<', '<', '<', '<', '<', '=', ' '},
            {'>', '>', '>', '>', ' ', '>', '>'},
            {'<', '<', '<', '<', '<', ' ', '='}
    };
    char[] ops = {'+', '-', '*', '/', '(', ')', '#'};

    private char precede(char op1, char op2) {
        int index1 = -1, index2 = -1;
        for (int i = 0; i < ops.length; i++) {
            if (op1 == ops[i])
                index1 = i;
            if (op2 == ops[i])
                index2 = i;
        }
        if (index1 == -1 || index2 == -1)
            return ' ';
        return Precedence[index1][index2];
    }

    private boolean isOptr(String s) {
        char c = s.charAt(0);
        if (s.length() == 1 && (c == 35 || c >= 40 && c <= 47))
            return true;
        return false;
    }

    private Double operate(double a, char op, double b) {
        double d;
        switch (op) {
            case '+':
                d = a + b;
                break;
            case '-':
                d = a - b;
                break;
            case '*':
                d = a * b;
                break;
            case '/':
                if (b == 0)
                    return null;
                d = a / b;
                break;
            default:
                return null;
        }
        return d;
    }

    public double evaluateExpression() {
        System.out.println("Input expression:");
        Scanner scan = new Scanner(System.in);
        Stack<Double> opnd = new LinkStack<>();
        Stack<Character> optr = new LinkStack<>();
        optr.push('#');
        String s = scan.next();
        while (!s.equals("#") || !optr.top().equals('#')) {
            if (!isOptr(s)) {
                opnd.push(Double.parseDouble(s));
                s = scan.next();
            } else {
                char c = s.charAt(0);
                switch (precede(optr.top(), c)) {
                    case '<':
                        optr.push(c);
                        s = scan.next();
                        break;
                    case '=':
                        optr.pop();
                        s = scan.next();
                        break;
                    case '>':
                        char op = optr.pop();
                        double b = opnd.pop();
                        double a = opnd.pop();
                        Double d = operate(a, op, b);
                        if (d == null) {
                            System.out.println("Grammatical errors");
                            return 0;
                        }
                        opnd.push(d);
                        break;
                    default:
                        System.out.println("Grammatical errors");
                        return 0;
                }
            }
        }
        return opnd.top();
    }

    public static void main(String[] args) {
        ExprEvaluation e = new ExprEvaluation();
        System.out.println(e.evaluateExpression());
    }


}
