package chap01;

import java.util.Scanner;

public class CheckDigits {
    static int checkDigits(int num) {

        int digits = 0;
        while (num > 0) {
            num /= 10;
            digits++;
        }

        return digits;
    }
    public static void main(String[] args) {
        System.out.println("숫자를 입력하세요.");
        int num;

        while(true) {
            num = new Scanner(System.in).nextInt();
            if(num >= 0) break;
        }

        System.out.println(num + "은 " + checkDigits(num) + " 자리입니다.");
    }
}
