package chap02;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class ArrayReverse {

    static void printArray(int[] array) {
        for (int i : array) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    static void reverse(int[] array) {
        for(int i = 0; i < array.length / 2; i++) {
            printArray(array);
            int targetIndex = (array.length - 1) - i;
            System.out.println("array[" + i + "]과 array[" + targetIndex + "]을 교환 합니다.");

            int temp = array[i];
            array[i] = array[targetIndex];
            array[targetIndex] = temp;

            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("배열의 길이를 입력하세요.");
        int length = scanner.nextInt();
        int[] array = new int[length];

        Random rand = new Random();
        for(int i = 0; i < array.length; i++) {
            array[i] = rand.nextInt(100);
            System.out.println("배열 " + i + "번째 값: " + array[i]);
        }
        
        reverse(array);
        System.out.print("결과:");
        printArray(array);
    }
}
