package stringSearch;

/*
* 검색에 실패할 경우 다시 검색할 인덱스 값을 미리 표로 만들어 사용
* 패턴에 중복되는 문자가 있을시 유용
* */
public class KMP {

    static int indexOf(String text, String pattern) {
        int textIndex = 1;
        int patternIndex = 0;
        int[] skipSheet = new int[pattern.length() + 1];

        skipSheet[textIndex] = 0;

        //패턴에서 중복되는 문자열 찾기
        while(textIndex < pattern.length()) {
            if(pattern.charAt(textIndex) == pattern.charAt(patternIndex)) {
                skipSheet[++textIndex] = ++patternIndex;
            } else if(patternIndex == 0) {
                skipSheet[++textIndex] = patternIndex;
            } else {
                patternIndex = skipSheet[patternIndex];
            }
        }

        textIndex = patternIndex = 0;
        while (patternIndex < pattern.length()) {
            if(text.charAt(textIndex) == pattern.charAt(patternIndex)) {
                textIndex++;
                patternIndex++;
            } else if(patternIndex == 0) {
                textIndex++;
            } else {
                patternIndex = skipSheet[patternIndex];
            }
        }

        if(patternIndex == patternIndex) {
            return textIndex - patternIndex;
        }

        return -1;
    }

    public static void main(String[] args) {
        String text = "ABCEFGCABCABCABDGABCJKTRABDQE";
        String pattern = "EFGCABC";

        int firstIndex = indexOf(text, pattern);

        if(firstIndex == -1) {
            System.out.println("패턴이 없습니다.");
        } else {
            int length = 0;
            for(int i = 0; i < firstIndex; i++) {
                length += text.substring(i, i + 1).getBytes().length;
            }
            length += pattern.length();

            System.out.println((firstIndex + 1) + "번째부터 일치합니다");
            System.out.println("텍스트:" + text);
            System.out.printf(String.format("패턴: %%%ds\n", length), pattern);
        }
    }
}
