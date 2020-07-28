package sorting;

import java.util.Random;

/*
* 좌,우 교대로 정렬
* */
public class ShakerSort {
    static int count;

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
        int left = 0;
        int right = arr.length - 1;
        int last = right;

        while(left < right) {
            for(int i = right; i > left; i--) {
                if(arr[i - 1] > arr[i]) {
                    swap(arr, i, i - 1);
                    last = i;
                }
            }
            left = last;

            for(int i = left; i < right; i++) {
                if(arr[i] > arr[i + 1]) {
                    swap(arr, i, i + 1);
                    last = i;
                }
            }
            right = last;
            count++;
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

        sort(arr);
        print(arr);

        System.out.println(count);
    }
}
