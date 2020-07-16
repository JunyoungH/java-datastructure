package chap01;

import java.util.Scanner;

public class SubNum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("숫자를 입력해 주세요.");

        int a = scanner.nextInt();
        System.out.println("a의 값: " + a);

        int b;
        while (true) {
            b = scanner.nextInt();
            if(b > a) {
                System.out.println("b의 값: " + b);
                break;
            }

            System.out.println("a보다 큰 값을 입력해주세요.");
        }

        System.out.println("b - a = " + (b - a));
    }
}
