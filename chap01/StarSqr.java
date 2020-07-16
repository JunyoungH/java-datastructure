package chap01;

import java.util.Scanner;

public class StarSqr {
    static void drawStart(int num) {
        for(int i = 0; i < num; i++) {
            for(int j = 0; j < num; j++) {
                System.out.printf("*");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("단 수를 입력하세요.");
        int num;
        while (true) {
            num = scanner.nextInt();
            if(num > 0) break;
            System.out.println("0 보다 큰 숫자를 입력하세요.");
        }

        drawStart(num);
    }
}
