package recursion;

import java.util.Scanner;

public class HanoiTower {

    /*static void hanoiTower(int n, char from, char middle, char to) {

        if(n == 1) {
            System.out.println(n + "번을 " + from + "에서 " + to + "로 이동");
        } else {
            hanoiTower(n -1, from, to, middle);
            System.out.println(n + "번을 " + from + "에서 " + to + "로 이동");
            hanoiTower(n -1, middle, from, to);
        }

    }*/

    static void hanoiTower(int n, int from, int to) {

        if (n == 1) {
            System.out.println(n + "번을 " + from + "에서 " + to + "로 이동");
        } else {
            hanoiTower(n - 1, from, 6 - from - to);
            System.out.println(n + "번을 " + from + "에서 " + to + "로 이동");
            hanoiTower(n - 1, 6 - from - to, to);
        }
    }

    /*
     * n = 4
     * 1 B -> C  c, b, a
     * 2 A -> C  a, c, b
     * 1 A -> B  a, b, c
     * 3 B -> C  b, a, c
     * 1 C -> A  c, b, a
     * 2 B -> A  b, c, a
     * 1 B -> C  b, a, c
     *
     * 4 A -> C  a, b, c
     *
     * 1 A -> B  c, b, a
     * 2 C -> B  b, c, a
     * 1 C -> A  b, a, c
     * 3 A -> B  a, b, c
     * 1 B -> C  c, a, b
     * 2 A -> C  a, c, b
     * 1 A -> B  a, b, c
     *
     * */



    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("탑의 높이를 입력하세요.");
        int size = scanner.nextInt();

        /*char from = 'A';
        char middle = 'B';
        char to = 'C';*/

        int from = 1;
        int to = 3;

        //hanoiTower(size, from, middle, to);
        hanoiTower(size, from, to);

        System.out.println("이동 횟수는 " + ((int)Math.pow(2, size) - 1));
    }
}
