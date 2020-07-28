package recursion;

import java.util.Scanner;

public class HanoiTowerLoop {
    int[] fromStack = new int[100];
    int[] toStack = new int[100];
    int[] numStack = new int[100];
    int pointer = 0;

    public void honoiTower(int num, int from, int to) {
        while (true) {
            if (num > 1) {
                fromStack[pointer] = from;
                toStack[pointer] =  to;
                numStack[pointer] = num;
                pointer++;
                num--;
                to = 6 - from - to;


                continue;
            }

            System.out.println(num + "번을 " + from + "에서 " + to + "로 이동");

            if (pointer-- > 0) {
                num = numStack[pointer];
                from = fromStack[pointer];
                to = toStack[pointer];
                System.out.println(num + "번을 " + from + "에서 " + to + "로 이동");
                num--;
                from = 6 - from - to;
            } else {
                break;
            }

        }
    }

    /*
    * 1번을 1에서 3로 이동
      2번을 1에서 2로 이동
      1번을 3에서 2로 이동
      3번을 1에서 3로 이동
      1번을 2에서 1로 이동
      2번을 2에서 3로 이동
      1번을 1에서 3로 이동
    */

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HanoiTowerLoop ht = new HanoiTowerLoop();

        System.out.println("탑의 높이를 입력해주세요.");
        int num = scanner.nextInt();
        int from = 1;
        int to = 3;

        ht.honoiTower(num, from, to);
    }
}
