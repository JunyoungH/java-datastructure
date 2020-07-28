package recursion;

import java.util.Scanner;

public class GreatestCommonDivisor {

    static int gcdRecursion(int x, int y) {
        if(y == 0) {
            return  x;
        }
     return gcdRecursion(y, x % y);
    }

    /*
    * x = 22, y == 8
    * 22 % 8 = 6
    * 8 % 6 = 2
    * 6 % 2 = 0
    *
    * y is 0
    * 2 % 0 -> return 2
    */

    static int gcdLoop(int x, int y) {
        while (y != 0) {
                int temp = y;
                y = x % y;
                x = temp;
            }
        return x;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("정수를 입력하세요.");
        int x = scanner.nextInt();

        System.out.println("정수를 입력하세요.");
        int y = scanner.nextInt();

        System.out.println("최대 공약수는 " + gcdRecursion(x, y) + "입니다.");
        System.out.println("최대 공약수는 " + gcdLoop(x, y) + "입니다.");
    }
}
