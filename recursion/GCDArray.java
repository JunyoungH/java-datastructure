package recursion;

import java.util.Scanner;

public class GCDArray {

    static int gcdLoop(int x, int y) {
        while (y != 0) {
            int temp = y;
            y = x % y;
            x = temp;
        }
        return x;
    }

    static int gcdArray(int[] nums, int start, int count) {
        if(count == 1) {
            return nums[start];
        } else if(count == 2) {
            return gcdLoop(nums[start], nums[start + 1]);
        } else {
            return gcdLoop(nums[start], gcdArray(nums, start + 1, count - 1));
        }
    }

    /*
    * [12, 72, 45, 30]
    * start = 0, count = 4
    *
    * gcdArray(nums, 1, 3)   return gcdLoop(nums[0], gcdLoop(nums[1], gcdLoop(nums[2], nums[3])))
    *
    * gcdArray(nums, 2, 2)   return gcdLoop(nums[1], gcdLoop(nums[2], nums[3]))
    *
    * count == 2             return gcdLoop(nums[2], nums[3])
    *
    * */

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("정수 몇 개의 최대 공약수를 구할까요?：");
        int num;
        do {
            num = scanner.nextInt();
        } while (num <= 1);

        int[] x = new int[num]; // 길이 num인 배열

        for (int i = 0; i < num; i++) {
            System.out.print("x[" + i + "]：");
            x[i] = scanner.nextInt();
        }

        System.out.println("최대 공약수는 " + gcdArray(x, 0, num) + "입니다.");
    }
}
