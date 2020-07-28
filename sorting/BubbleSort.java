package sorting;

import java.util.Random;

/*
* 좌 또는 우에서 순차적으로 정렬
* */
public class BubbleSort {
    static int count;
    static void print(int[] arr) {
        for(int v : arr) {
            System.out.print(v + " ");
        }
        System.out.println();
    }

    static void sortFromEnd(int[] arr) {
        count = 0;
        int i = 0;
        while(i < arr.length - 1) {
            int last = arr.length - 1;
            for(int j = arr.length - 1; j > i; j--) {
                for(int k = 0; k < arr.length; k++) {
                    if(k == j - 1) {
                        System.out.printf("%3d%2c", arr[k], arr[j - 1] > arr[j]? '+': '-');
                    } else {
                        System.out.printf("%3d%2c", arr[k], ' ');
                    }
                }
                System.out.println();

                if(arr[j - 1] > arr[j] ) {
                    int temp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = temp;
                    last = j;
                }
                count++;
            }

            i = last;
        }
    }

    static void sortFromStart(int[] arr) {
        count = 0;
        for(int i = arr.length - 1; i > 0; i--) {
            for(int j = 0; j < i; j++) {
                for(int k = 0; k < arr.length; k++) {
                    if(k == j) {
                        System.out.printf("%3d%2c", arr[k], arr[j] > arr[j + 1]? '+': '-');
                    } else {
                        System.out.printf("%3d%2c", arr[k], ' ');
                    }
                }
                System.out.println();
                if(arr[j] > arr[j + 1] ) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
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

        sortFromEnd(arr);

        System.out.println(count);
    }
}
