package recursion;

public class EightQueen {
    static int[] pos = new int[4];

    static void print() {
        for(int i : pos) {
            System.out.printf("%2d", i);
        }
        System.out.println();
    }

    static void set(int i) {
        for(int j = 0; j < 4; j++) {

            pos[i] = j;
            if(i == 3) {
                print();
            } else {
                set(i + 1);
            }
        }
    }

    public static void main(String[] args) {
        set(0);
    }
}
