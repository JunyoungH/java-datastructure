package chap02;

import java.util.Scanner;

public class NotationCov {

    static String convertNumber(int num, int not) {

        String dChart = "";

        for(int i = 0; i < 10; i++) {
            dChart += i;
        }

        for(char c = 'A'; c <= 'Z'; c++ ){
            dChart += c;
        }

        String result = "";

        while (true) {
            if(num == 0) break;
            result = String.valueOf(dChart.charAt(num % not)) + result;
            num /= not;
        }

        return result;
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int targetNum;
        System.out.println("변활 할 10진수 정수를 입력하세요.");
        while (true) {
            targetNum = scanner.nextInt();
            if(targetNum >= 0) break;
            System.out.println("양의 정수를 입력해주세요.");
        }

        int targetNot;
        System.out.println("변활 할 진수를 입력하세요. (2 ~ 36)");
        while (true) {
            targetNot = scanner.nextInt();
            if(targetNot >= 2 || targetNot <= 36) break;;
        }

        System.out.println("결과는 : " + convertNumber(targetNum, targetNot));
    }
}
