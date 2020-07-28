package sorting;

import java.util.Random;
import java.util.Scanner;

public class ShellSort {

    static void print(int[] arr, int count) {
        System.out.println();

        System.out.print("정렬 완료 : ");
        for(int v : arr) {
            System.out.print(v + " ");
        }
        System.out.println();
        System.out.println("카운트 : " + count);
    }

    static int sortDefault(int[] arr) {
        int count = 0;

        for(int h = arr.length / 2; h > 0; h /= 2) {
            for(int i = h; i < arr.length; i++) {
                int j;
                int temp = arr[i];

                for(j = i - h; j >= 0 && arr[j] > temp; j -= h) {
                    arr[j + h] = arr[j];
                }
                arr[j + h] = temp;
                count++;
            }
        }

        return count;
    }


    static int sortMitigated(int[] arr) {
        int count = 0;

        //h 값이 서로 배수가 되지 않도록 121, 40, 13, 4, 1 -> h * 3 + 1
        //h 값이 너무 크면 효과가 없으므로 요솟수를 9로 나누기
        int h;
        for(h = 1; h < arr.length / 9; h = h * 3 + 1);

        for(; h > 0; h /= 3) {
            for(int i = h; i < arr.length; i++) {
                int j;
                int temp = arr[i];

                for(j = i - h; j >= 0 && arr[j] > temp; j -= h) {
                    arr[j + h] = arr[j];
                }
                arr[j + h] = temp;
                count++;
            }
        }

        return count;
    }


    public static void main(String[] args) {
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);
        System.out.println("배열의 길이를 입력하세요.");
        int length = scanner.nextInt() + 1;
        int[] arr1 = new int[length];
        int[] arr2;

        System.out.print("원본 배열 : ");
        for(int i = 0; i < length; i++) {
            arr1[i] = random.nextInt(length * 5);
            System.out.print(arr1[i] + " ");
        }
        System.out.println();

        arr2 = arr1.clone();

        print(arr1, sortDefault(arr1));
        print(arr2, sortMitigated(arr2));
    }
}
