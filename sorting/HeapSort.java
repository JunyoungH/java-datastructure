package sorting;

/*
* heap은 '부모의 값이 자식의 값보다 항상 크거나 항상 작다'는 조건을 만족하는 완전이진트리
* 형재의 대소 관계가 정해져 있지 않아 부분순서트리라고도 함. Partial ordered tree
*
* 부모와 자식의 인덱스 관계
* */

import java.util.Random;
import java.util.Scanner;

public class HeapSort {

    static void print(int[] arr) {
        for(int v : arr) {
            System.out.print(v + " ");
        }
        System.out.println();
        System.out.println();
    }

    static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    static void setHeap(int[] arr, int parentNode, int depth) {
        int parentValue = arr[parentNode];
        int targetChildNode;

        /*
        *  parentNode = targetChildNode
        *  자식 노드를 부모 노드로 할당하여 레벨 다운
        *
        * */
        for(; parentNode < (depth + 1) / 2; parentNode = targetChildNode) {
            int leftNode = parentNode * 2 + 1; //왼쪽 자식
            int rightNode = leftNode + 1; // 오른쪽 자식
            targetChildNode = (rightNode <= depth && arr[rightNode] > arr[leftNode]) ? rightNode : leftNode;

            if(parentValue >= arr[targetChildNode]) {
                break;
            }
            swap(arr, parentNode, targetChildNode);
        }
    }

    /*
    * 1. 부모 arr[(자식 인덱스 - 1) / 2]
    * 2. 왼쪽 자식 arr[부모 인덱스 * 2 + 1]
    * 3. 오른쪽 자식 arr[부모 인덱스 * 2 + 2]
    * */
    static void sort(int[] arr) {
        int lastIndex = arr.length - 1;

        //마지막 부분트리의 부모에서 시작해 위로 올라가면서 힙으로 만듦
        for(int i = lastIndex / 2; i >= 0; i--) {
            setHeap(arr, i, lastIndex);
        }

        //가장 큰 요소와 아직 정렬되지 않은 부분의 마지막 요소를 교환
        for(int i = lastIndex; i > 0; i--) {
            swap(arr, 0, i);
            setHeap(arr, 0, i - 1);
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

        sort(arr);

        System.out.println("정렬 후 배열");
        print(arr);
    }
}
