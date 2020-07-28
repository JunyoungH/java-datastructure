package recursion;

import java.util.Scanner;

public class EightQueen2 {
    private int level;
    private int[] pos;
    private boolean[] flagRow;
    private boolean[] flagRightDiagonal;
    private boolean[] flagLeftDiagonal;
    private int count;

    public EightQueen2(int level) {
        this.level = level;
        this.pos = new int[level];
        this.flagRow = new boolean[level];
        this.flagRightDiagonal = new boolean[2 * level - 1];
        this.flagLeftDiagonal = new boolean[2 * level - 1];
    }

    public void print() {
        StringBuilder blank;
        String empty = "";
        char fill = '■';

        for(int i = 0; i < level; i++) {
            empty += "□";
        }

        System.out.println("===== " + ++count + " 번째 " + "=====");
        for(int i : pos) {
            blank = new StringBuilder(empty);
            blank.setCharAt(i, fill);
            System.out.println(blank);
        }
    }

    public void set(int i) {
        // i는 현재 컬럼
        for(int j = 0; j < level; j++) {
            //                                                             체크판을 앞에서부터 왼쪽 대각선으로 잘라나갔을때
            //                                                             [0, 0]은 7번 라인, [0, 1]은 8번 라인..
            //j번째 로우 체크           j번째 로우에서 오른쪽 대가선 체크          j번째 로우에서 왼쪽 대각선 체크
            if(!flagRow[j] && !flagRightDiagonal[j + i] && !flagLeftDiagonal[j - i + (level - 1)]) {
                pos[i] = j; // i번째 컬럼에 j번재 로우 마크

                if(i == level - 1) {
                    print();
                } else {
                    flagRow[j] = flagRightDiagonal[j + i] = flagLeftDiagonal[j - i + (level - 1)] = true;
                    set(i + 1);
                    flagRow[j] = flagRightDiagonal[j + i] = flagLeftDiagonal[j - i + (level - 1)]  = false;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("말의 수를 입력해주세요.");
        EightQueen2 queen = new EightQueen2(scanner.nextInt());
        queen.set(0);
    }
}
