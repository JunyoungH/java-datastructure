package tree;

import java.util.Comparator;
import java.util.Scanner;

public class BinarySearchTreeTester {
    static Scanner stdIn = new Scanner(System.in);

    // 데이터 (회원번호 + 이름)
    static class Data {
        public static final int NO   = 1;	// 번호를 읽어 들일까요?
        public static final int NAME = 2;	// 이름을 읽어 들일까요?

        private Integer no;					// 회원번호 (키 값)
        private String  name;				// 이름

        // 키 값
        Integer keyCode() {
            return no;
        }

        Data() {}

        Data(int no, String name) {
            this.no = no;
            this.name = name;
        }

        // 문자열을 반환합니다.
        public String toString() {
            return name;
        }

        // 데이터를 입력합니다.
        void scanData(String guide, int sw) {
            System.out.println(guide + "할 데이터를 입력하세요.");

            if ((sw & NO) == NO) {
                System.out.print("번호：");
                no = stdIn.nextInt();
            }
            if ((sw & NAME) == NAME) {
                System.out.print("이름：");
                name = stdIn.next();
            }
        }
    }

    // 메뉴 열거형
    enum Menu {
        ADD(      "삽입"),
        REMOVE(   "삭제"),
        SEARCH(   "검색"),
        SEARCH_MIN_KEY(   "가장 작은 키 검색"),
        SEARCH_MAX_KEY(   "가장 큰 키 검색"),
        PRINT_ASC(    "오름차순 출력"),
        PRINT_DESC(    "내림차순 출력"),
        TERMINATE("종료");

        private final String message;			// 출력할 문자열

        static Menu MenuAt(int idx) {			// 서수가 idx인 열거를 반환
            for (Menu m : Menu.values())
                if (m.ordinal() == idx)
                    return m;
            return null;
        }

        Menu(String string) {					// 생성자
            message = string;
        }

        String getMessage() {					// 출력할 문자열을 반환
            return message;
        }
    }

    // 메뉴 선택
    static Menu SelectMenu() {
        int key;
        do {
            for (Menu m : Menu.values())
                System.out.printf("(%d) %s  ", m.ordinal(), m.getMessage());
            System.out.print("：");
            key = stdIn.nextInt();
        } while (key < Menu.ADD.ordinal() || key > Menu.TERMINATE.ordinal());

        return Menu.MenuAt(key);
    }

    public static void main(String[] args) {
        Menu menu;								// 메뉴
        Data data;								// 추가용 데이터 참조
        Data pointer;								// 검색용 데이터 참조
        Data temp = new Data();					// 입력용 데이터
        Integer key;

        class IntegerDescComparator implements Comparator<Integer> {
            public int compare(Integer a, Integer b) {
                if (a == b) return 0;
                return a > b ? 1 : -1;
            }
        }

        // 정수의 내림차순으로 순서매기기를 수행하는 comparator
        BinarySearchTree<Integer, Data> tree = new BinarySearchTree<Integer, Data>(new IntegerDescComparator());
        //BinarySearchTree<Integer, Data> tree = new BinarySearchTree<Integer, Data>();

        for(int i = 0; i < 10; i++) {
            data = new Data(i, "test" + i);
            tree.add(data.keyCode(), data);
        }

        do {
            switch (menu = SelectMenu()) {
                case ADD :							// 노드를 삽입
                    data = new Data();
                    data.scanData("삽입", Data.NO | Data.NAME);
                    tree.add(data.keyCode(), data);
                    break;

                case REMOVE :						// 노드를 삭제
                    temp.scanData("삭제", Data.NO);
                    tree.remove(temp.keyCode());
                    break;

                case SEARCH :						// 노드를 검색
                    temp.scanData("검색", Data.NO);
                    pointer = tree.search(temp.keyCode());
                    if (pointer != null)
                        System.out.println("그 번호의 이름은 " + pointer + "입니다.");
                    else
                        System.out.println("해당 데이터가 없습니다.");
                    break;

                case SEARCH_MIN_KEY :
                    key = tree.getMinKey();
                    if (key != null) {
                        System.out.println("가장 작은 번호는 " + key + "입니다.");
                    } else {
                        System.out.println("데이터가 없습니다.");
                    }
                    break;

                case SEARCH_MAX_KEY :
                    key = tree.getMaxKey();
                    if (key != null) {
                        System.out.println("가장 큰 번호는 " + key + "입니다.");
                    } else {
                        System.out.println("데이터가 없습니다.");
                    }
                    break;

                case PRINT_ASC :					// 모든 노드를 키 값의 오름차순으로 출력
                    tree.printOrderByASC();
                    break;

                case PRINT_DESC :					// 모든 노드를 키 값의 내림차순으로 출력
                    tree.printOrderByDESC();
                    break;
            }
        } while (menu != Menu.TERMINATE);
    }
}
