package sorting;

import java.util.Random;
import java.util.Scanner;

public class CountingSort {

    static void print(int[] arr) {
        for(int v : arr) {
            System.out.print(v + " ");
        }
        System.out.println();
    }

    static void sort(int[] oriArr) {
        int maxValue = oriArr[0];
        int minValue = oriArr[0];

        for(int i = 1; i < oriArr.length; i++) {
            if(oriArr[i] > maxValue) {
                maxValue = oriArr[i];
            }
        }

        System.out.println(maxValue);

        for(int i = 1; i < oriArr.length; i++) {
            if(oriArr[i] < minValue) {
                minValue = oriArr[i];
            }
        }

        int countingRange = maxValue - minValue + 2;

        int[] countingArr = new int[countingRange];
        int[] resultArr = new int[oriArr.length];


        for(int i = 0; i < oriArr.length; i++) {
            countingArr[oriArr[i]]++;
        }

        for(int i = 0; i < countingRange - 1; i++) {
            countingArr[i + 1] += countingArr[i];
        }

        for(int i = oriArr.length - 1; i >= 0; i--) {
            resultArr[--countingArr[oriArr[i]]] = oriArr[i];
        }

        for(int i = 0; i < oriArr.length; i++) {
            oriArr[i] = resultArr[i];
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.println("요솟수를 입력하세요.");
        int size = scanner.nextInt();
        int[] arr = new int[size];

        for(int i = 0; i < size; i++) {
            arr[i] = random.nextInt(15);
        }

        System.out.println("원본 배열");
        print(arr);

        sort(arr);

        System.out.println("정렬 후 배열");
        print(arr);
    }
}
