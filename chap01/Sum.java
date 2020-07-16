package chap01;

public class Sum {

    static int sum(int n) {
        return ((1 + n)*n)/2;
    }

    static int sum(int a, int b) {
        return ((a + b) * ((b - a) + 1)/2);
    }

    public static void main(String[] args) {
        System.out.println(sum(5, 7));
    }
}