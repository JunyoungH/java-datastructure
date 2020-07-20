package basicDataStructure;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;

public class PhysicalEx {

    static final int VMAX = 21;
    static final int DECIMAL_POIINT = 2;

    static class PhysicalData {
        private String name;
        private int height;
        private double vision;

        PhysicalData(String name, int height, double vision) {
            this.name = name;
            this.height = height;
            this.vision = vision;
        }
    }

    static BigDecimal scaleDecimal(double value) {
        return new BigDecimal(value).setScale(2, RoundingMode.HALF_UP);
    }

    static BigDecimal avgHeight(PhysicalData[] pds) {
        double heightSum = 0.0;
        for(PhysicalData pd: pds) {
            heightSum += pd.height;
        }
        return scaleDecimal(heightSum / pds.length);
    }

    static String[] distVision(PhysicalData[] pds, String[] vChart) {

        for(int i = 0; i < pds.length; i++) {
            if(pds[i].vision >= 0.0 && pds[i].vision < VMAX / 10.0) {
                vChart[(int)(pds[i].vision * 10)] += "*";
            }
        }
        return vChart;
    }


    public static void main(String[] args) {
        String[] vChart = new String[VMAX];
        Arrays.fill(vChart, "");

        PhysicalData[] pds = {
                new PhysicalData("Michael", 163, 0.7),
                new PhysicalData("Andro", 172, 0.4),
                new PhysicalData("Freo", 171, 0.3),
                new PhysicalData("Jiko", 168, 0.3),
                new PhysicalData("Enrique", 170, 1.0),
                new PhysicalData("Kurt", 176, 2.0),
                new PhysicalData("Lolito", 164, 1.5),
                new PhysicalData("Flore", 157, 1.0),
                new PhysicalData("Jeric", 181, 0.7),
        };

        System.out.printf("평균키는 %.2f\n", avgHeight(pds));
        distVision(pds, vChart);

        for(int i = 0; i < vChart.length; i++) {
            System.out.println(i / 10.0 + " : " + vChart[i]);
        }
    }
}
