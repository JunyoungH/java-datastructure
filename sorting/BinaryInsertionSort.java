package sorting;

import java.util.Random;
import java.util.Scanner;

public class BinaryInsertionSort {

    static void print(int[] arr) {
        for(int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    static void sort(int[] arr) {
        for(int i = 1; i < arr.length; i++) {
            int target = arr[i];
            int front = 0; //시작 인덱스
            int rear = i - 1; // 정렬이 끝난 인덱스
            int center = 0;
            int insertionPoint;

            while (front <= rear) {
                center = (front + rear) / 2;

                if(arr[center] == target) break;
                else if(arr[center] < target) front = center + 1;
                else rear = center - 1;
            }

            insertionPoint = front <= rear ? center + 1 : rear + 1;

            for(int j = i; j > insertionPoint; j--) {
                arr[j] = arr[j - 1];
            }
            arr[insertionPoint] = target;

            System.out.println("정렬 후 배열");
            print(arr);
        }
    }

    public static void main(String[] args) {
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);
        System.out.println("배열의 길이를 입력하세요.");
        int length = scanner.nextInt();
        int[] arr = new int[length];

        // 0번째 인덱스에 보초값 0
        for(int i = 0; i < length; i++) {
            arr[i] = random.nextInt(50);
        }
        System.out.println("원본 배열");
        print(arr);

        sort(arr);

    }
}
