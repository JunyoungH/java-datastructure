package search;

import java.util.Random;
import java.util.Scanner;

/*
* 배열의 중간 인덱서의 값을 찾고 찾는 값과 크기 비교
* 찾는 값이 더 작으면 배열 중간의 앞 부분의 중간 인덱스의 값을 찾아서 비교
* 더 이상 배열이 나눠지지 않을 때까지 반복
* */
public class BinarySearch {

    static int search(int nums[], int target) {

        int start = 0;
        int end = nums.length - 1;

        while (start <= end) {
            int center = (start + end) / 2;
            if(nums[center] == target) {
                while (center > start) {
                    if(nums[center -1] < target) break;
                    center--;
                }
                return center;
            }
            else if(nums[center] < target) {
                start = center + 1;
            } else {
                end = center - 1;
            }
        }

        return -1;
    }

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
