package basicDataStructure;

import java.util.Random;
import java.util.Scanner;

public class ArraySum {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("배열의 길이를 입력하세요.");
        int length = scanner.nextInt();
        int[] array = new int[length];

        Random rand = new Random();
        for(int i = 0; i < array.length; i++) {
            array[i] = rand.nextInt(100);
            System.out.println("배열 " + i + "번째 값: " + array[i]);
        }

        // Using Stream
        // Arrays.stream(array).sum()

        int sum = 0;
        for(int i : array) {
            sum += i;
        }

        System.out.println("배열 값의 합계는 " + sum + "입니다.");
    }
}
