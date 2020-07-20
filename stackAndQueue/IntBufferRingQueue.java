package stackAndQueue;

import java.util.Scanner;

public class IntBufferRingQueue {
    private int max;
    private int front;
    private int rear;
    private int num;
    private int[] que;

    public IntBufferRingQueue(int capacity) {
        num = front = rear = 0;
        max = capacity;
        que = new int[max];
    }

    //예외: 큐가 비어 있음
    public class EmptyBufferRingQueueException extends RuntimeException {
        public EmptyBufferRingQueueException(){}
    }

    //예외: 큐가 가득 참
    public class OverflowBufferRingQueueException extends  RuntimeException {
        public  OverflowBufferRingQueueException() {}
    }

    public void enqueue(int value) {
        if(num >= max) {
            throw new IntBufferRingQueue.OverflowBufferRingQueueException();
        }

        que[rear++] = value;
        num++;
        if(rear >= max) rear = 0;
        dump();
    }

    public int dequeue() {
        if(num <= 0) {
            throw new IntBufferRingQueue.EmptyBufferRingQueueException();
        }

        int value = que[front++];
        num--;
        if(front >= max) front = 0;

        return value;
    }

    public int indexOf(int value) {
        for(int i = 0; i < num; i++) {
            int idx = (i + front) % max;
            if(que[idx] == value) {
                return idx;
            }
        }
        return -1;
    }

    public int search(int value) {
        for(int i = 0; i < num; i++) {
            int idx = (i + front) % max;
            if(que[idx] == value) {
                return i + 1;
            }
        }
        return -1;
    }

    public void dump() {
        if(num <= 0) {
            throw new IntBufferRingQueue.EmptyBufferRingQueueException();
        }

        System.out.print("현재 큐의 값: ");

        System.out.println(front + " : " + rear + " : " + num);

        for(int i = 0; i < num; i++) {
            System.out.print(que[(i + front) % max] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("큐의 요소 값을 입력해주세요.");
        int capacity = scanner.nextInt();

        IntBufferRingQueue intBufferRingQueue = new IntBufferRingQueue(capacity);

        while (true) {
            System.out.println("옵션을 선택해주세요.");
            System.out.println("1) enqueue  2) dequeue  3) dump");

            switch (scanner.nextInt()) {
                case 1:
                    System.out.println("값을 입력해주세요.");
                    try {
                        intBufferRingQueue.enqueue(scanner.nextInt());
                    } catch (IntBufferRingQueue.OverflowBufferRingQueueException e) {
                        System.out.println("큐가 가득 찼습니다.");
                    }
                    break;
                case 2:
                    try {
                        System.out.println("dequeue 결과: " + intBufferRingQueue.dequeue());
                    } catch (IntBufferRingQueue.EmptyBufferRingQueueException e) {
                        System.out.println("큐가 비어 있습니다.");
                    }
                    break;
                case 3:
                    try {
                        intBufferRingQueue.dump();
                    } catch (IntBufferRingQueue.EmptyBufferRingQueueException e) {
                        System.out.println("큐가 비어 있습니다.");
                    }
                    break;
            }
        }
    }
}
