package basicDataStructure;

public class YMD {
    private int year;
    private int month;
    private int day;

    static final int[][] MDAYS = {
            {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31}, //평년
            {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31}, //윤년
    };

    YMD(int year, int month, int day){
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public int isLeap(int year) {
        return year%4 == 0 && year%100 != 0 || year%400 == 0 ? 1 : 0;
    }

    public YMD getDateAfter(int num) {
        YMD ymd = new YMD(year, month, day);
        ymd.day += num;

        while (ymd.day >= MDAYS[isLeap(ymd.year)][ymd.month - 1]) {
            ymd.day -= MDAYS[isLeap(ymd.year)][ymd.month - 1];
            if(++ymd.month > 12) {
                ymd.month = 1;
                ymd.year++;
            }
        }
        return ymd;
    }

    public YMD getDateBefore(int num) {
        YMD ymd = new YMD(year, month, day);
        ymd.day -= num;

        while (ymd.day < 1) {
            if(--ymd.month < 1) {
                ymd.month = 12;
                ymd.year--;
            }
            ymd.day += MDAYS[isLeap(ymd.year)][ymd.month - 1];
        }

        return ymd;
    }


    public static void main(String[] args) {
        YMD ymd = new YMD(2020, 7, 18);

        YMD dateAfter = ymd.getDateAfter(250);
        System.out.println(dateAfter.year + "년 " + dateAfter.month + "월 " + dateAfter.day + "일");

        YMD dateBefore = ymd.getDateBefore(250);
        System.out.println(dateBefore.year + "년 " + dateBefore.month + "월 " + dateBefore.day + "일");
    }
}
