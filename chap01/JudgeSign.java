package chap01;

import java.util.Scanner;

public class JudgeSign {

    static String judgeSign(int number) {
        return number > 0 ? "양수" : "음수";
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("숫자를 입력해주세요.");
        System.out.println("입력하신 숫자는 " + judgeSign(scanner.nextInt()) + "입니다.");
    }
}
