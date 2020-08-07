package list;

import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.util.Comparator;
import java.util.Scanner;

public class ListTester {
    static Scanner scanner = new Scanner(System.in);

    static class Data {
        static final int NO = 1;
        static final int NAME = 2;

        private Integer no;
        private String name;

        public String toString() {
            return "(" + no + ") " + name;
        }

        void scanData(String guide, int sw) {
            System.out.println(guide + "할 데이터를 입력하세요.");
            if ((sw & NO) == NO) {
                System.out.println("번호: ");
                no = scanner.nextInt();
            }
            if ((sw & NAME) == NAME) {
                System.out.println("이름: ");
                name = scanner.next();
            }
        }

        public  static final Comparator<Data> NO_ORDER = new NoOderComparator();

        private static class NoOderComparator implements Comparator<Data> {
            public int compare(Data d1, Data d2) {
                return (d1.no > d2.no) ? 1 : (d1.no < d2.no) ? -1 : 0;
            }
        }

        public  static final Comparator<Data> NAME_ORDER = new NameOrderComparator();

        private static class NameOrderComparator implements  Comparator<Data>{
            public  int compare(Data d1, Data d2) {
                return d1.name.compareTo(d2.name);
            }
        }
    }

    enum Menu {
        ADD_FIRST(  "머리에 노드를 삽입"),
        ADD_LAST(   "꼬리에 노드를 삽입"),
        RMV_FIRST(  "머리 노드를 삭제"),
        RMV_LAST(   "꼬리 노드를 삭제"),
        RMV_CRNT(   "선택 노드를 삭제"),
        RMV_DUPE_NO(   "번호가 중복되는 모든 노드를 삭제"),
        RMV_DUPE_NAME(   "이름이 중복되는 모든 노드를 삭제"),
        CLEAR(      "모든 노드를 삭제"),
        SEARCH_NO(  "번호로 검색"),
        SEARCH_NAME("이름으로 검색"),
        SEARCH_INDEX(  "인덱스로 검색"),
        NEXT(       "선택 노드를 하나 뒤쪽으로 이동"),
        PRINT_CRNT( "선택 노드를 출력"),
        DUMP(       "모든 노드를 출력"),
        TERMINATE(  "종료");

        private final String message;

        static Menu MenuAt(int index) {
            for (Menu menu : Menu.values()) {
                if (menu.ordinal() == index) {
                    return menu;
                }
            }
            return null;
        }

        Menu(String string) {
            message = string;
        }

        String getMessage() {
            return message;
        }
    }

    static Menu SelectMenu() {
        int key;

        do {
            for (Menu menu : Menu.values()) {
                System.out.printf("(%d) %s  ", menu.ordinal(), menu.getMessage());
                if ((menu.ordinal() % 3) == 2 && menu.ordinal() != Menu.TERMINATE.ordinal()) {
                    System.out.println();
                }
            }
            key = scanner.nextByte();
        } while (key < Menu.ADD_FIRST.ordinal() || key > Menu.TERMINATE.ordinal());
        return  Menu.MenuAt(key);
    }

    public static void main(String[] args) {
        Menu menu;						// 메뉴
        Data data;						// 추가용 데이터 참조
        Data pointer;						// 검색용 데이터 참조
        Data input = new Data();			// 입력용 데이터

        //LinkedList<Data> list = new LinkedList<>();
        //ArrayLinkedList<Data> list = new ArrayLinkedList<>(100);
        DoubleLinkedList<Data> list = new DoubleLinkedList<>();

        do {
            switch (menu = SelectMenu()) {
                case ADD_FIRST :								// 머리에 노드를 삽입
                    data = new Data();                   // 01        10
                    data.scanData("머리에 삽입", Data.NO | Data.NAME);
                    list.addFirst(data);
                    break;

                case ADD_LAST :								// 꼬리에 노드를 삽입
                    data = new Data();
                    data.scanData("꼬리에 삽입", Data.NO | Data.NAME);
                    list.addLast(data);
                    break;

                case RMV_FIRST :								// 머리 노드를 삭제
                    list.removeFirst();
                    break;

                case RMV_LAST :								// 꼬리 노드를 삭제
                    list.removeLast();
                    break;

                case RMV_CRNT :								// 선택 노드를 삭제
                    list.removeCurrentNode();
                    break;

                /*case RMV_DUPE_NO:
                    data = new Data();
                    list.purge(data.NO_ORDER);
                    break;

                case RMV_DUPE_NAME:
                    data = new Data();
                    list.purge(data.NAME_ORDER);
                    break;*/

                case SEARCH_NO :								// 회원번호로 검색
                    input.scanData("검색", Data.NO);
                    pointer = list.search(input, Data.NO_ORDER);
                    if (pointer == null)
                        System.out.println("그 번호의 데이터가 없습니다.");
                    else
                        System.out.println("검색 성공：" + pointer);
                    break;

                case SEARCH_NAME :								// 이름으로 검색
                    input.scanData("검색", Data.NAME);
                    pointer = list.search(input, Data.NAME_ORDER);
                    if (pointer == null)
                        System.out.println("그 이름의 데이터가 없습니다.");
                    else
                        System.out.println("검색 성공：" + pointer);
                    break;

                /*case SEARCH_INDEX :
                    input.scanData("검색", Data.NO);
                    pointer = list.retrieve(input.no);
                    if (pointer == null)
                        System.out.println("해당 인덱스의 데이터가 없습니다.");
                    else
                        System.out.println("검색 성공：" + pointer);
                    break;
*/
                case NEXT :									// 선택 노드를 뒤쪽으로 이동
                    list.next();
                    break;

                case PRINT_CRNT :								// 선택 노드의 데이터를 출력
                    list.printCurrentNode();
                    break;

                case DUMP :									// 모든 노드를 리스트 순서로 출력
                    list.dump();
                    break;

                case CLEAR :									// 모든 노드를 삭제
                    list.clear();
                    break;
            }
        } while (menu != Menu.TERMINATE);
    }
}
