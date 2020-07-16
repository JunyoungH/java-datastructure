package chap01;

import java.util.Scanner;

public class SumFor {

    static int sum(int n) {
        int result = 0;

        for(int i = 1; i <= n; i++) {
            result += i;
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("숫자를 입력해주세요.");
        System.out.println("결과는 " + sum(scanner.nextInt()) +" 입니다.");
    }
}
