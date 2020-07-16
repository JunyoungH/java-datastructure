package chap01;

public class Med3 {

    static void findMed(int a, int b, int c) {
        int med = a;

        if(a >= b) {
            if(b >= c) {
                med = b;
            } else if(a >= c) {
                med = c;
            } else {
                med = a;
            }
        } else if(a > c) {
            med = a;
        } else if(b > c) {
            med = c;
        } else {
            med = b;
        }

        String out = String.format("%d, %d, %d 의 중앙 값은 %d 입니다", a, b, c, med);
        System.out.println(out);
    }

    public static void main(String[] args) {
        findMed(3, 2, 1);
        findMed(3, 2, 2);
        findMed(3, 1, 2);
        findMed(2, 1, 3);
        findMed(3, 1, 2);
        findMed(3, 3, 2);
        findMed(3, 3, 3);
        findMed(2, 2, 3);
        findMed(2, 3, 1);
        findMed(2, 3, 2);
        findMed(1, 3, 2);
        findMed(2, 3, 3);
        findMed(1, 2, 3);
    }
}
