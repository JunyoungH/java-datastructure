package chap01;

import java.util.Scanner;

public class SumForPos {

    static int sum(int n) {
        return (((1 + n)*n)/2);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n;

        while(true){
            n = scanner.nextInt();
            if(n > 0) break;
            System.out.println("0 보다 큰 숫자를 입력해주세요.");
        }

        System.out.println("결과는 " + sum(n) + "입니다.");
    }
}
