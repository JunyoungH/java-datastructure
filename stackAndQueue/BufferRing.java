package stackAndQueue;

import java.util.Scanner;

public class BufferRing {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("요솟수를 입력하세요.");
        int size = scanner.nextInt();
        int[] arr = new int[size];
        int counter = 0;
        boolean retry = true;

        while (retry) {
            System.out.println("값을 입력해주세요.");
            arr[counter++ % size] = scanner.nextInt();

            System.out.println("계속 하시겠습니끼? 1.Yes  2.No");
            if(scanner.nextInt() == 2) retry = false;
        }

        int idx = counter - size;
        if(idx < 0) idx = 0;

        System.out.println("결과 : ");
        for(; idx < counter; idx++) {
            System.out.println((idx + 1) + "번째 정수 : " + arr[idx % size]);
        }
    }
}
