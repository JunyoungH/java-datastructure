package sorting;

import java.util.Random;

/*
* 제일 작은 숫자를 찾아내서 앞으로 이동
* */
public class StraightSelectionSort {

    static void print(int[] arr) {
        for(int v : arr) {
            System.out.print(v + " ");
        }
        System.out.println();
    }

    static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    static void sort(int[] arr) {
        for(int i = 0; i < arr.length; i++) {
            int min = i;
            for(int j = i + 1; j < arr.length; j++) {
                // i번째 값보다 작은 수중 가장 작은 값 검색
                if(arr[min] > arr[j]) {
                    min = j;
                }
            }
            swap(arr, i, min);
        }
    }

    public static void main(String[] args) {
        Random random = new Random();
        int[] arr = new int[10];

        for(int i = 0; i < 10; i++) {
            arr[i] = random.nextInt(50);
        }
        System.out.println("원본 배열");
        print(arr);

        System.out.println("정렬 후 배열");
        sort(arr);
        print(arr);
    }
}
