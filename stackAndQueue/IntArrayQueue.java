package stackAndQueue;

import java.util.Scanner;

public class IntArrayQueue {
    private int max; //큐의 용량
    private int num; //현재 데이터 수
    private int[] que; //큐 본체

    public IntArrayQueue(int capacity) {
        num = 0;
        max = capacity;
        try {
            que = new int[max];
        } catch (IntStack.OverflowIntStackException e) {
            max = 0;
        }
    }

    //예외: 큐가 비어 있음
    public class EmptyIntQueueException extends RuntimeException {
        public EmptyIntQueueException(){}
    }

    //예외: 큐가 가득 참
    public class OverflowIntQueueException extends  RuntimeException {
        public  OverflowIntQueueException() {}
    }


    public void enqueue(int value) {
        if(num >= max) {
            throw new IntArrayQueue.OverflowIntQueueException();
        }
        que[num++] = value;
        dump();
    }

    //배열의 0번째 요소를 디큐한 후 배열 다시 재배치
    public int dequeue() {
        if(num <= 0) {
            throw new IntArrayQueue.EmptyIntQueueException();
        }

        int value = que[0];
        num--;

        for(int i = 0; i < num; i++) {
            que[i] = que[i + 1];
        }

        return value;
    }

    public void dump() {
        if(num <= 0) {
            throw new IntArrayQueue.EmptyIntQueueException();
        }

        System.out.print("현재 큐의 값: ");
        for(int i = 0; i < num; i++) {
            System.out.print(que[i] + " ");
        }

        System.out.println();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("큐의 요소 값을 입력해주세요.");
        int capacity = scanner.nextInt();

        IntArrayQueue intArrayQueue = new IntArrayQueue(capacity);

        while (true) {
            System.out.println("옵션을 선택해주세요.");
            System.out.println("1) enqueue  2) dequeue  3) dump");

            switch (scanner.nextInt()) {
                case 1:
                    System.out.println("값을 입력해주세요.");
                    try {
                        intArrayQueue.enqueue(scanner.nextInt());
                    } catch (IntArrayQueue.OverflowIntQueueException e) {
                        System.out.println("큐가 가득 찼습니다.");
                    }
                    break;
                case 2:
                    try {
                        System.out.println("dequeue 결과: " + intArrayQueue.dequeue());
                    } catch (IntArrayQueue.EmptyIntQueueException e) {
                        System.out.println("큐가 비어 있습니다.");
                    }
                    break;
                case 3:
                    try {
                        intArrayQueue.dump();
                    } catch (IntArrayQueue.EmptyIntQueueException e) {
                        System.out.println("큐가 비어 있습니다.");
                    }
                    break;
            }
        }
    }
}
