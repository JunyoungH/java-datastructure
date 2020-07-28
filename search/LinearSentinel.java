package search;

import java.util.Random;
import java.util.Scanner;

public class LinearSentinel {

    static int search(int[] nums, int target) {

        System.out.print("   | ");
        for(int i = 0; i < nums.length; i++) {
            System.out.printf("%4d", i);
        }
        System.out.println();
        System.out.print("___+");
        for(int i = 0; i < 4 * nums.length; i++) {
            System.out.print("_");
        }
        System.out.println();

        nums[nums.length - 1] = target;
        int index;
        for(index = 0; index < nums.length; index++) {
            System.out.print("   |");
            System.out.printf(String.format("%%%ds*\n", (index * 4) + 3), "");

            System.out.printf("%3d|", index);
            for (int k = 0; k < nums.length; k++)
                System.out.printf("%4d", nums[k]);
            System.out.println("\n   |");

            if(nums[index] == target) {
                break;
            }
        }
        return index == nums.length - 1 ? -1 : index; // 배열의 마지막 인덱스 (보초)랑 같으면 검색 실패
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("요솟수: ");
        int size = scanner.nextInt();

        int[] nums = new int[size + 1];
        Random rand = new Random();
        for(int i = 0; i < nums.length; i++) {
            nums[i] = rand.nextInt(50);
            System.out.println(i + "의 값: " + nums[i]);
        }

        System.out.println("찾을 숫자: ");
        int target = scanner.nextInt();

        int result = search(nums, target);
        if(result == -1) {
            System.out.println("찾는 숫자가 없습니다.");
        } else {
            System.out.println(result + "에 위치해있습니다.");
        }
    }
}
