package sorting;

import java.util.Random;
import java.util.Scanner;

public class StraightInsertionSort {

    static void print(int[] arr) {
        for(int i = 1; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    static void sort(int[] arr) {
        for(int i = 2; i < arr.length; i++) {
            int j = i;
            int temp = arr[i];
            System.out.printf("시작: temp = arr[%d] [%d]\n", i, arr[i]);

            // i 번째부터 앞으로 삽일 할 위치 검색.
            for(; arr[j - 1] > temp; j--) {
                arr[j] = arr[j - 1];
                System.out.printf("한칸 뒤로: arr[%d] = arr[%d] [%d]\n", j, j -1, arr[j - 1]);
            }

            arr[j] = temp;
            System.out.printf("삽입 : arr[%d] = temp [%d]\n", j, temp);

            System.out.println();
        }
    }

    public static void main(String[] args) {
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);
        System.out.println("배열의 길이를 입력하세요.");
        int length = scanner.nextInt() + 1;
        int[] arr = new int[length];

        // 0번째 인덱스에 보초값 0
        for(int i = 1; i < length; i++) {
            arr[i] = random.nextInt(50);
        }
        System.out.println("원본 배열");
        print(arr);

        sort(arr);

        System.out.println("정렬 후 배열");
        print(arr);
    }
}
