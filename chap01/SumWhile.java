package chap01;

import java.util.Scanner;

public class SumWhile {

    static int sum(int n) {
        int result = 0;
        int i = 0;

        while(i <= n) {
            result += i++;
        }

        System.out.println("최종 i 값은 " + i + " 입니다.");
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("숫자를 입력해주세요.");
        int n = scanner.nextInt();
        System.out.println(n + "까지의 합은 " + sum(n) + " 입니다.");
    }
}
