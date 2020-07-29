package sorting;

import stackAndQueue.IntStack;

import java.util.Random;
import java.util.Scanner;

public class QuickSortStackPivotA {
    static int pivot(int a, int b, int c) {
        if(a >= b){
            if(b >= c) {
                return b;
            } else if (c >= a) {
                return a;
            } else {
                return c;
            }
        } else if(b < c) {
            return b;
        } else if(c < a) {
            return a;
        } else {
            return c;
        }
    }

    static void print(int[] arr) {
        for(int v : arr) {
            System.out.print(v + " ");
        }
        System.out.println();
        System.out.println();
    }

    static void insertionSort(int[] arr) {
        System.out.println("삽입 정렬 수행");
        for(int i = 1; i < arr.length; i++) {
            int temp = arr[i];
            int j;
            for(j = i; j > 0 && arr[j - 1] > temp; j--) {
                arr[j] = arr[j - 1];
            }
            arr[j] = temp;
        }
    }


    static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    static void quickSort(int[] arr, int left, int right) {
        System.out.println("퀵 정렬 수행");

        IntStack leftStack = new IntStack(arr.length);
        IntStack rightStack = new IntStack(arr.length);

        leftStack.push(left);
        rightStack.push(right);
        System.out.print("left ");
        leftStack.dump();

        System.out.print("right ");
        rightStack.dump();

        System.out.println();

        while(!leftStack.isEmpty()) {
            int front = left = leftStack.pop();
            int rear = right = rightStack.pop();
            System.out.println("팝 " + left + " : " + right);

            if((right - left) < 9) {
                insertionSort(arr);
            } else {
                int center = (left + right) / 2;
                int pivot = pivot(arr[left], arr[(front + rear) / 2], arr[right]);
                swap(arr, center, right - 1); // 중간 값과 끝에서 -1 번째 값 교환
                front++;
                rear--;

                while(front <= rear) {
                    while(arr[front] < pivot) front++;
                    while(pivot < arr[rear]) rear--;

                    if(front <= rear) {
                        swap(arr, front++, rear--);
                    }
                }

                if((rear - left) < (right - front)) {
                    int temp = left;
                    left = front;
                    front = temp;

                    temp = rear;
                    rear = right;
                    right = temp;
                }

                if(left < rear) {
                    leftStack.push(left);
                    rightStack.push(rear);

                    System.out.println("==분할");
                    System.out.print("왼쪽 그룹 left push ");
                    leftStack.dump();

                    System.out.print("왼쪽 그룹 right push ");
                    rightStack.dump();

                    System.out.println();;

                }

                if(front < right) {
                    leftStack.push(front);
                    rightStack.push(right);

                    System.out.println("==분할==");
                    System.out.print("오른쪽 그룹 left push ");
                    leftStack.dump();

                    System.out.print("오른쪽 그룹 right push ");
                    rightStack.dump();

                    System.out.println();
                }
            }
        }
    }

    public static void main(String[] args) {
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);
        System.out.println("배열의 길이를 입력하세요.");
        int length = scanner.nextInt();
        int[] arr = new int[length];

        for(int i = 0; i < length; i++) {
            arr[i] = random.nextInt(length * 5);
        }
        System.out.println("원본 배열");
        print(arr);

        quickSort(arr, 0, arr.length - 1);

        System.out.println("정렬 후 배열");
        print(arr);
    }
}
