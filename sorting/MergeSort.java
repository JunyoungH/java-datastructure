package sorting;

import java.util.Random;
import java.util.Scanner;

public class MergeSort {
    static void print(int[] arr) {
        for(int v : arr) {
            System.out.print(v + " ");
        }
        System.out.println();
        System.out.println();
    }


    static void __mergeSort(int[] arr, int left, int right, int[] buffer) {

        if (left < right) {
            int i;
            int center = (left + right) / 2;
            int p = 0; // 버퍼의 요솟수
            int j = 0; // 버퍼 인덱스
            int k = left; // merge 되는 배열의 인덱스

            __mergeSort(arr, left, center, buffer); // 앞부분 나누기
            __mergeSort(arr, center + 1, right, buffer); // 뒷부분 나누기

            //앞에서 중간까지 버퍼에 담음
            //center = (left + center) / 2, (center + 1 + right) / 2
            for(i = left; i <= center; i++) {
                buffer[p++] = arr[i];
            }

            //i는 중간값 + 1
            //정렬 후 병합
            while(i <= right && j < p) {
                arr[k++] = buffer[j] <= arr[i] ? buffer[j++]:arr[i++];
            }

            //버퍼에 남은 값을 추가함
            while (j < p) {
                arr[k++] = buffer[j++];
            }
        }
    }

    static void sort(int[] arr) {
        int[] buffer = new int[arr.length];
        __mergeSort(arr, 0, arr.length - 1, buffer);
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

        sort(arr);

        System.out.println("정렬 후 배열");
        print(arr);
    }
}
