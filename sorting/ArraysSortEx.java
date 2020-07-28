package sorting;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class ArraysSortEx {

    static void print(int[] arr) {
        for(int v : arr) {
            System.out.print(v + " ");
        }
        System.out.println();
        System.out.println();
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

        Arrays.sort(arr);

        /*
        * 병합 정렬을 개선
        *
        * 자연 정렬이 필요한 배열
        * static void sort(Object [] a)
        * static void sort(Object [] a, int fromIndex, int toIndex)
        *
        * 자연 정렬이 필요하지 않는 배열
        * static <T> void legacyMergeSort(T[] a, Comparator<? super T> c)
        * static <T> void sort(T[] a, int fromIndex, int toIndex, Comparator<? super T> c)
        *
        * */

        System.out.println("정렬 후 배열");
        print(arr);
    }
}
