package chap03;

import java.util.Arrays;
import java.util.Scanner;

public class StringBinarySearch {
    public static void main(String[] args) {
        String[] x = {
                "abstract",   "assert",       "boolean",   "break",      "byte",
                "case",       "catch",        "char",      "class",      "const",
                "continue",   "default",      "do",        "double",     "else",
                "enum",       "extends",      "final",     "finally",    "float",
                "for",        "goto",         "if",        "implements", "import",
                "instanceof", "int",          "interface", "long",       "native",
                "new",        "package",      "private",   "protected",  "public",
                "return",     "short",        "static",    "strictfp",   "super",
                "switch",     "synchronized", "this",      "throw",      "throws",
                "transient",  "try",          "void",      "volatile",   "while"
        };

        System.out.println("검색할 키워드 :");
        Scanner scanner = new Scanner(System.in);
        String keyword = scanner.next();

        int idx = Arrays.binarySearch(x, keyword);
        if(idx < 0) {
            System.out.println("삽입 포인트는 " + -(idx + 1) + "입니다.");
            System.out.println("요수 값을 찾을 수 없습니다.");
        } else {
            System.out.println("인덱스는 " + idx + "입니다.");
        }
    }
}
