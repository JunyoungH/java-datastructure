package chap02;

import java.util.Random;
import java.util.Scanner;

public class ArrayCopy {

    static void printArray(int[] array) {
        for (int i : array) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    //a배열의 값을 b로 복사
    static void copy(int[] a, int[] b) {

        int length = a.length > b.length ? b.length : a.length;
        for(int i = 0; i < length; i++) {
            b[i] = a[i];
        }
    }

    //a배열의 값을 역순으로 b로 복사
    static void rcopy(int[] a, int[] b) {

        int length = a.length > b.length ? b.length : a.length;
        for(int i = 0; i < length; i++) {
            b[i] = a[a.length - i - 1];
        }
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("a 배열의 길이를 입력하세요.");
        int[] a = new int[scanner.nextInt()];

        System.out.println("b 배열의 길이를 입력하세요.");
        int[] b = new int[scanner.nextInt()];

        Random rand = new Random();
        for(int i = 0; i < a.length; i++) {
            a[i] = rand.nextInt(50);
        }

        System.out.println("a의 값:");
        printArray(a);

        copy(a, b);
        System.out.println("copy 결과:");
        printArray(b);

        rcopy(a, b);
        System.out.println("rcopy 결과:");
        printArray(b);
    }
}
