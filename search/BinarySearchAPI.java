package search;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class BinarySearchAPI {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random rand = new Random();

        System.out.println("요솟수 : ");
        int size = scanner.nextInt();
        int[] nums = new int[size];
        nums[0] = rand.nextInt(10);
        System.out.println("0의 값: " + nums[0]);

        for(int i = 1; i < size; i++) {
            nums[i] = nums[i - 1] + rand.nextInt(10);
            System.out.println(i + "의 값: " + nums[i]);
        }

        System.out.println("검색할 값: ");
        int target = scanner.nextInt();

        int idx = Arrays.binarySearch(nums, target);
        if(idx < 0) {
            System.out.println("삽입 포인트는 " + -(idx + 1) + "입니다.");
            System.out.println("요수 값을 찾을 수 없습니다.");
        } else {
            System.out.println("인덱스는 " + idx + "입니다.");
        }
    }
}
