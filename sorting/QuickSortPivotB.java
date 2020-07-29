package sorting;

import java.util.Random;
import java.util.Scanner;

public class QuickSortPivotB {

    //시작, 중간, 끝 위치의 값 비교하여 정렬
    static int pivot(int[] arr, int front, int center, int rear) {
        if(arr[front] > arr[center]) {
            swap(arr, front, center);
        }
        if(arr[center] > arr[rear]) {
            swap(arr, center, rear);
        }
        if(arr[front] > arr[center]) {
            swap(arr, front, center);
        }

        return arr[center];
    }

    static void print(int[] arr) {
        for(int v : arr) {
            System.out.print(v + " ");
        }
        System.out.println();
        System.out.println();
    }

    static void insertionSort(int[] arr) {
        System.out.println("삽입 정렬 수행");
        for(int i = 1; i < arr.length; i++) {
            int temp = arr[i];
            int j;
            for(j = i; j > 0 && arr[j - 1] > temp; j--) {
                arr[j] = arr[j - 1];
            }
            arr[j] = temp;
        }
    }


    static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    static void quickSort(int[] arr, int left, int right) {
        if((right - left) < 9) {
            insertionSort(arr);
        } else {
            System.out.println("퀵 정렬 수행");

            int front = left;
            int rear = right;
            int pivot = pivot(arr, left, (left + right) / 2, right);

            // 피벗 나누기
            while(front <= rear) {
                while (arr[front] < pivot) front++;
                while (arr[rear] > pivot) rear--;

                if (front <= rear) {
                    swap(arr, front++, rear--);
                }
            }

            if((rear - left) < (right - front)) {
                int temp = left;
                left = front;
                front = temp;

                temp = rear;
                rear = right;
                right = temp;
            }

            if(left < rear) quickSort(arr, left, rear);
            if(front < right) quickSort(arr, front, right);
        }
    }

    public static void main(String[] args) {
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);
        System.out.println("배열의 길이를 입력하세요.");
        int length = scanner.nextInt();
        int[] arr = new int[length];

        for(int i = 0; i < length; i++) {
            arr[i] = random.nextInt(length * 5);
        }
        System.out.println("원본 배열");
        print(arr);

        quickSort(arr, 0, arr.length - 1);

        System.out.println("정렬 후 배열");
        print(arr);
    }
}
