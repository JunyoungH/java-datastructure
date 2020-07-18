package chap02;

import java.util.Random;
import java.util.Scanner;

public class TallestHeight {

    static int getTallest(int[] heights) {
        int result = heights[0];

        for(int i = 1; i < heights.length; i++) {
            if(result < heights[i]) {
                result = heights[i];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.println("키의 최댓값을 구합니다.");
        System.out.println("사람수:");
        int num = scanner.nextInt();

        int[] heights = new int[num];

        for(int i = 0; i < heights.length; i++) {
            heights[i] = 100 + random.nextInt(90);
            System.out.println("heights의 인덱스 " + i + "의 값: " + heights[i]);
        }

        System.out.println("가장 큰 키는 " + getTallest(heights) + "입니다.");
    }
}
