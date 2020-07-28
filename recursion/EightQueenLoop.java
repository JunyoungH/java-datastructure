package recursion;

import java.util.Scanner;

public class EightQueenLoop {
    private int level;
    private int[] pos;
    private boolean[] flagRow;
    private boolean[] flagRightDiagonal;
    private boolean[] flagLeftDiagonal;
    private int count;

    public EightQueenLoop(int level) {
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
        int j;
        int[] jStack = new int[level];

        Start:while(true) {
            j = 0;
            while (true) {
                while (j < level) {
                    if(!flagRow[j] && !flagRightDiagonal[j + i] && !flagLeftDiagonal[j - i + (level - 1)]) {
                        pos[i] = j;
                        if(i == level - 1) {
                            print();
                        } else {
                            flagRow[j] = flagRightDiagonal[j + i] = flagLeftDiagonal[j - i + (level - 1)] = true;
                            jStack[i++] = j; //마크한 로우을 스택에 푸시
                            continue Start;
                        }
                    }
                    j++;
                }
                //실패한 컬럼의 한 칸 전으로 이동
                if(--i < 0) {
                    return;
                }
                j = jStack[i]; //실패한 컬럼의 마크된 로우를 팝
                flagRow[j] = flagRightDiagonal[j + i] = flagLeftDiagonal[j - i + (level - 1)] = false;
                j++; // 마크를 초기화하고 마크 되었던 로우 뒤부터 재검색
            }
        }

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("말의 수를 입력해주세요.");
        EightQueenLoop queen = new EightQueenLoop(scanner.nextInt());
        queen.set(0);
    }
}

