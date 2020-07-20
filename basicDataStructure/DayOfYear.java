package basicDataStructure;

import java.util.Scanner;

public class DayOfYear {

    static final int[][] MDAYS = {
            {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31}, //평년
            {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31}, //윤년
    };

    static int getLeap(int year) {
        return year%4 == 0 && year%100 != 0 || year%400 == 0 ? 1 : 0;
    }

    static int getDaysOfYear(int year, int month, int day) {
        /*for(int i = 0; i < month - 1; i++) {
            days += MDAYS[getLeap(year)][i];
        }*/

        while (--month > 0) {
            day += MDAYS[getLeap(year)][month - 1];
        }

        return day;
    }

    static int getLetfDaysOfYear(int year, int month, int day) {
        int leap = getLeap(year);
        while (--month > 0) {
            day += MDAYS[getLeap(year)][month - 1];
        }
        return 365 + leap - day;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int retry = 0;

        System.out.println("그 해 경과 일수를 구합니다.");
        do{
            System.out.print(" 년: ");
            int year = scanner.nextInt();

            System.out.print(" 월: ");
            int month = scanner.nextInt();

            System.out.print(" 일: ");
            int day = scanner.nextInt();

            //System.out.println("경과된 일수는 " + getDaysOfYear(year, month, day) + "입니다.");
            System.out.println("남은 일수는: " + getLetfDaysOfYear(year, month, day) + "입니다.");

            System.out.println("한번 더 하시겠습니까? 1.예 2.아니오");
            retry = scanner.nextInt();

        }while (retry == 1);
    }
}
