package recursion;

import java.util.Scanner;

public class Factorial {

    static int factorialRecursion(int num) {
        if(num > 0) {
            return num * factorialRecursion(num - 1); // n! = n * (n - 1)
        } else {
            return 1;
        }
    }

    /*
     *  num = 3;
     *
     *  3 * factorial(3 - 1) -- 3 * 2
     *           |                  ^
     *  2 * factorial(2 - 1) -- 2 * 1
     *           |                  ^
     *  1 * factorial(1 - 1) -- 1 * 1
     *           |   0 is not greater than 0
     *           -> return 1
     */

    static int factorialLoop(int num) {
        int result = 1;
        while (num > 1) {
           result *= num--;
        }
        return result;
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("정수를 입력하세요.");
        int num = scanner.nextInt();
        System.out.println("결과는 : " + factorialRecursion(num));
        System.out.println("결과는 : " + factorialLoop(num));
    }
}
