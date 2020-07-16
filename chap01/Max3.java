package chap01;
import java.util.Scanner;

public class Max3 {

    //네 값의 최댓값을 구하는 max4 메서드를 작성하세요.
    static void max4(int a, int b, int c, int d) {
        int max = a;
        if(b > max) max = b;
        if(c > max) max = c;
        if(d > max) max = d;

        System.out.println("max4 최댓값은 " + max + " 입니다.");
    }

    //세 값의 최솟값을 구하는 min3 메서드를 작성하세요.
    static void min3(int a, int b, int c) {
        int min = a;
        if(b < min) min = b;
        if(c < min) min = c;

        System.out.println("min3 최솟값은 " + min + " 입니다.");
    }

    //네 값의 최솟값을 구하는 min4 메서드를 작성하세요.
    static void min4(int a, int b, int c, int d) {
        int min = a;
        if(b < min) min = b;
        if(c < min) min = c;
        if(d < min) min = d;
        System.out.println("min4 최좃값은 " + min + " 입니다.");
    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        System.out.println("세 정수의 최댓값을 구합니다.");
        System.out.println("a의 값: ");
        int a = stdIn.nextInt();

        System.out.println("b의 값: ");
        int b = stdIn.nextInt();

        System.out.println("c의 값: ");
        int c = stdIn.nextInt();

        System.out.println("d의 값: ");
        int d = stdIn.nextInt();

        max4(a, b, c, d);
        min3(a, b, c);
        min4(a, b, c, d);
        stdIn.close();
    }
}
