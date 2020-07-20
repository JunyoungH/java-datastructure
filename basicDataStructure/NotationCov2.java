package basicDataStructure;

import java.util.Scanner;

public class NotationCov2 {

    static void convertNumber(char[] cnums, int num, int not) {
        String dChart = "";
        for(int i = 0; i < 10; i++) {
            dChart += i;
        }

        for(char c = 'A'; c <= 'Z'; c++ ){
            dChart += c;
        }

        int ori = ((Integer)num).toString().length();
        System.out.printf("%2d | %" + ori + "d\n", not, num);

        int digit;
        for(digit = 0; digit < cnums.length; digit++) {
            if(num == 0) break;
            int rem = num % not;
            cnums[digit] = dChart.charAt(rem);
            num /= not;

            System.out.printf("   +");
            for (int i = 0; i < ori + 2; i++)
                System.out.print('-');
            System.out.println();

            if(num == 0) {
                System.out.printf("   | %" + ori + "d --- %d\n", num, rem);
            } else {
                System.out.printf("%2d | %" + ori + "d --- %d\n", not, num, rem);
            }
        }

        for(int j = 0; j < digit / 2; j++) {
            char temp = cnums[j];
            cnums[j] = cnums[digit - j - 1];
            cnums[digit - j - 1] = temp;
        }
    }

    public static void main(String[] args) {
        char cnums[] = new char[32];

        Scanner scanner = new Scanner(System.in);

        boolean retry = false;
        int targetNum;
        int targetNot;

        do{

            System.out.println("변활 할 10진수 정수를 입력하세요.");
            while (true) {
                targetNum = scanner.nextInt();
                if(targetNum >= 0) break;
                System.out.println("양의 정수를 입력해주세요.");
            }


            System.out.println("변활 할 진수를 입력하세요. (2 ~ 36)");
            while (true) {
                targetNot = scanner.nextInt();
                if(targetNot >= 2 || targetNot <= 36) break;;
            }

            convertNumber(cnums, targetNum, targetNot);

            String result = "";
            for(char c: cnums){
                result += c;
            }
            System.out.println(targetNum + "으로 " + result + "입니다.");

            System.out.println("다시 하시겠습니까? 1.예 2.아니오");
            retry = scanner.nextInt() == 1 ? true : false;
        } while (retry);

    }
}
