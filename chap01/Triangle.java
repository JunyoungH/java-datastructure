package chap01;

public class Triangle {
    static void drawTriangleLB(int num) {
        for(int i = 0; i < num; i++) {
            for(int j = 0; j < i + 1; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    static void drawTriangleLU(int num) {
        for(int i = 0; i < num; i++) {
            for(int j = num - i; j > 0; j--) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    static void drawTriangleRU(int num) {
        for(int i = 0; i < num; i++) {
            String star = "";
            for(int j = num - i; j > 0; j--) {
                star += "*";
            }
            System.out.printf("%" + num + "s", star);
            System.out.println();
        }
    }

    static void drawTriangleRB(int num) {
        for(int i = 0; i < num; i++) {
            String star = "";
            for(int j = 0; j < i + 1; j++) {
                star += "*";
            }
            System.out.printf("%" + num + "s", star);
            System.out.println();
        }
    }

    static void drawStarPyramid(int num) {
        for(int i = 1; i <= num; i++) {
            for(int j = 0; j < num - i; j++) {
                System.out.print(" ");
            }

            for(int k = 0; k < i * 2 - 1; k++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    static void drawNumPyramid(int num) {
        for(int i = 1; i <= num; i++) {
            for(int j = 0; j < num - i; j++) {
                System.out.print(" ");
            }

            for(int k = 0; k < i * 2 - 1; k++) {
                System.out.print(i % 10);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {

        drawNumPyramid(6);
    }
}
