package stackAndQueue;

import java.util.Scanner;

public class IntStack {
    private int max; //스택 용량
    private int pointer; //현재 스택에 쌓여있는 데이터의 수
    private int[] stack; //스택 본체

    //예외: 스택이 비어 있음
    public class EmptyIntStackException extends RuntimeException {
        public EmptyIntStackException(){}
    }

    //예외: 스택이 가득 참
    public class OverflowIntStackException extends  RuntimeException {
        public  OverflowIntStackException() {}
    }

    public IntStack(int capacity) {
        max = capacity;
        pointer = 0;
        try {
            stack = new int[max];
        } catch (OverflowIntStackException e) {
            max = 0;
        }
    }

    public void push(int num) {
        if(pointer >= max) {
            throw new OverflowIntStackException();
        }
        stack[pointer++] = num;
    }

    public int pop() {
        if(pointer <= 0) {
            throw new EmptyIntStackException();
        }

        return stack[--pointer];
    }

    public int peek() {
        if(pointer <= 0) {
            throw new EmptyIntStackException();
        }
        return stack[pointer - 1];
    }

    //먼저 pop이 되는 숫자 찾기
    public int indexOf(int num) {
        if(pointer <= 0) {
            throw new EmptyIntStackException();
        }
        for(int i = pointer - 1; i >= 0; i--) {
            if(stack[i] == num) {
                return i;
            }
        }

        return -1;
    }

    public void clear() {
        if(pointer <= 0) {
            throw new EmptyIntStackException();
        }

        pointer = 0;
    }

    public int size() {
        if(pointer <= 0) {
            throw new EmptyIntStackException();
        }

        return pointer;
    }

    public boolean isEmpty() {
        return pointer <= 0;
    }

    public boolean isFull() {
        return pointer >= max;
    }

    public void dump() {
        if(pointer <= 0) {
            throw new EmptyIntStackException();
        }

        System.out.print("현재 스택의 값: ");
        for(int i = 0; i < pointer; i++) {
            System.out.print(stack[i] + " ");
        }

        System.out.println();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("스택의 요소 값을 입력해주세요.");
        int capacity = scanner.nextInt();

        IntStack intStack = new IntStack(capacity);

        while (true) {
            System.out.println("옵션을 선택해주세요.");
            System.out.println("1) push  2) pop  3) peek  4) indexOf  5) clear  6) size  7) isEmpty  8) isFull  9) dump");

            switch (scanner.nextInt()) {
                case 1:
                    System.out.println("값을 입력해주세요.");
                    try {
                        intStack.push(scanner.nextInt());
                    } catch (IntStack.OverflowIntStackException e) {
                        System.out.println("스택이 가득 찼습니다.");
                    }
                    break;
                case 2:
                    try {
                        System.out.println("pop 결과: " + intStack.pop());
                    } catch (IntStack.EmptyIntStackException e) {
                        System.out.println("스택이 비어 있습니다.");
                    }
                    break;
                case 3:
                    try {
                        System.out.println("peek 결과: " + intStack.peek());
                    } catch (IntStack.EmptyIntStackException e) {
                        System.out.println("스택이 비어 있습니다.");
                    }
                    break;
                case 4:
                    System.out.println("값을 입력해주세요.");
                    try {
                        System.out.println("indexOf 결과: " + intStack.indexOf(scanner.nextInt()));
                    } catch (IntStack.EmptyIntStackException e) {
                        System.out.println("스택이 비어 있습니다.");
                    }
                    break;
                case 5:
                    try {
                        intStack.clear();
                    } catch (IntStack.EmptyIntStackException e) {
                        System.out.println("스택이 비어 있습니다.");
                    }
                    break;
                case 6:
                    try {
                        System.out.println("size 결과: " + intStack.size());
                    } catch (IntStack.EmptyIntStackException e) {
                        System.out.println("스택이 비어 있습니다.");
                    }
                    break;
                case 7:
                    System.out.println("isEmpty 결과: " + intStack.isEmpty());
                    break;
                case 8:
                    System.out.println("isFull 결과: " + intStack.isFull());
                    break;
                case 9:
                    try {
                        intStack.dump();
                    } catch (IntStack.EmptyIntStackException e) {
                        System.out.println("스택이 비어 있습니다.");
                        break;
                    }
                    break;
                default: break;
            }
        }
    }
}
