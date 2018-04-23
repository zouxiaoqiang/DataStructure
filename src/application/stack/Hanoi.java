package application.stack;

public class Hanoi {
    private static StringBuilder ss = new StringBuilder();
    public void hanoi(int n, char A, char B, char C){
        if(n == 1)
            ss.append("(").append(A).append(", ").append(C).append(")->");
        else{
            hanoi(n-1, A, C, B);
            ss.append("(").append(A).append(", ").append(C).append(")->");
            hanoi(n-1, B, A, C);
        }
    }

    public static void main(String[] args) {
        new Hanoi().hanoi(7, 'A', 'B', 'C');
        String s = ss.toString().substring(0, ss.length()-2);
        System.out.println(s);
    }
}
