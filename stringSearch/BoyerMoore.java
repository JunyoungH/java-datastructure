package stringSearch;

public class BoyerMoore {
    static int indexOf(String text, String pattern) {
        int textIndex;
        int patternIndex;
        int textLength = text.length();
        int patternLength = pattern.length();
        int[] skipSheet = new int[Character.MAX_VALUE + 1];

        //건너뛰기 표 만들기
        for (textIndex = 0; textIndex < skipSheet.length; textIndex++) {
            skipSheet[textIndex] = patternLength;
        }

        // textIndex == patternLength - 1
        for(patternIndex = 0; patternIndex < patternLength - 1; textIndex = patternIndex++) {
            skipSheet[pattern.charAt(patternIndex)] = patternLength - patternIndex - 1;
        }

        //패턴의 뒤에서부터 검색
        while(textIndex < textLength) {
            patternIndex = patternLength - 1; // 패턴의 끝 인덱스

            while(text.charAt(textIndex) == pattern.charAt(patternIndex)) {
                if(patternIndex == 0) {
                    return textIndex;
                }
                textIndex--;
                patternIndex--;
            }

            textIndex += (skipSheet[text.charAt(textIndex)] > patternLength - patternIndex ) ?
                            skipSheet[text.charAt(textIndex)] : patternLength - patternIndex;
        }

        return -1;
    }

    public static void main(String[] args) {
        String text = "GBSIBMCEBUCICJAPANCSU";
        String pattern = "CEBU";

        int firstIndex = indexOf(text, pattern);

        if(firstIndex == -1) {
            System.out.println("패턴이 없습니다.");
        } else {

            System.out.println((firstIndex + 1) + "번째부터 일치합니다");
            System.out.println("텍스트:" + text);
            System.out.printf(String.format("패턴: %%%ds\n", firstIndex + pattern.length() + 1), pattern);
        }
    }
}
