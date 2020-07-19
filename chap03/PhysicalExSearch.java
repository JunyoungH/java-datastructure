package chap03;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class PhysicalExSearch {

    static class PhyscData {

        String name;
        int height;
        double vision;

        PhyscData(String name, int height, double vision) {
            this.name = name;
            this.height = height;
            this.vision = vision;
        }

        @Override
        public String toString() {
            return "PhyscData{" +
                    "name='" + name + '\'' +
                    ", height=" + height +
                    ", vision=" + vision +
                    '}';
        }

        public static final Comparator<PhyscData> VISION_ORDER = new VisionOrderComparator();
        private static class VisionOrderComparator implements Comparator<PhyscData> {
            @Override
            public int compare(PhyscData d1, PhyscData d2) {

                if(d1.vision < d2.vision) return 1;
                else if(d1.vision > d2.vision) return -1;

                return 0;
            }
        }
    }

    public static void main(String[] args) {
        PhyscData[] arr = {					// 키의 오름차순으로 정렬되어 있습니다.
                new PhyscData("이나령", 162, 2.0),
                new PhyscData("유지훈", 168, 1.8),
                new PhyscData("김한결", 169, 1.4),
                new PhyscData("홍준기", 171, 0.9),
                new PhyscData("전서현", 173, 0.7),
                new PhyscData("이호연", 174, 0.3),
                new PhyscData("이수민", 175, 0.1),
        };

        Scanner scanner = new Scanner(System.in);
        System.out.print("어떤 시력의 사람을 찾고 있나요?：");
        double vision = scanner.nextDouble();

        int idx = Arrays.binarySearch(
                arr,
                new PhyscData("", 0, vision),
                PhyscData.VISION_ORDER
        );

        if (idx < 0)
            System.out.println("요소가 없습니다.");
        else {
            System.out.println("x[" + idx + "]에 있습니다.");
            System.out.println("찾은 데이터：" + arr[idx]);
        }
    }
}
