package stringSearch;

public class BruteForce {

    static int indexOf(String text, String pattern) {
        int textIndex = 0;
        int patternIndex = 0;

        while(textIndex < text.length()) {
            if(text.charAt(textIndex) == pattern.charAt(patternIndex)) {
                textIndex++;
                patternIndex++;

                if(patternIndex == pattern.length()) {
                    return (textIndex - patternIndex);
                }
            } else {
                textIndex = textIndex - patternIndex + 1;
                patternIndex = 0;
            }
        }

        return -1;
    }

    static int lastIndexOf(String text, String pattern) {
        int textIndex = text.length() - 1; //텍스트 커서
        int patternIndex = pattern.length() - 1; //패턴 커서

        //텍스트의 끝에서부터 검색
        while(textIndex >= 0) {
            if(text.charAt(textIndex) == pattern.charAt(patternIndex)) {
                textIndex--;
                patternIndex--;

                if(patternIndex < 0) {
                    return textIndex + 1;
                }
            } else {
                textIndex = textIndex + (pattern.length() - patternIndex) - 2;
                patternIndex = pattern.length() - 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        String text = "PHILIPPINES아이비엠CICJAPANCSU";
        String pattern = "아이비엠";

        System.out.println(pattern.getBytes().length);

        int firstIndex = indexOf(text, pattern);
        int lastIndex = lastIndexOf(text, pattern);

        //int firstIndex = text.indexOf(pattern);
        //int lastIndex = text.lastIndexOf(pattern);

        if(firstIndex == -1) {
            System.out.println("패턴이 없습니다.");
        } else {
            int length1 = 0;
            for(int i = 0; i < firstIndex; i++) {
                length1 += text.substring(i, i + 1).getBytes().length;
            }
            length1 += pattern.length();

            int length2 = 0;
            for(int i = 0; i < lastIndex; i++) {
                length2 += text.substring(i, i + 1).getBytes().length;
            }
            length2 += pattern.length();


            System.out.println((firstIndex + 1) + "번째부터 일치합니다");
            System.out.println("텍스트:" + text);
            System.out.printf(String.format("패턴: %%%ds\n", length1), pattern);
            System.out.println("텍스트:" + text);
            System.out.printf(String.format("패턴: %%%ds\n", length2), pattern);

        }
    }
}
