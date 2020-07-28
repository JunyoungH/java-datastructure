package recursion;

import stackAndQueue.IntStack;

public class RecursionDefinition {

    static IntStack stack = new IntStack(20);

    static void recur2(int n) {
        if(n > 0) {
            recur2(n - 2);
            System.out.println(n);
            recur2(n - 1);
        }
    }

    static void recur2Loop(int n) {
        while (true) {
            if(n > 0) {
                stack.push(n);
                n = n - 2;
                continue;
            }

            if(!stack.isEmpty()) {
                n = stack.pop();
                System.out.println(n);
                n = n - 1;
                continue;
            }

            //스택이 비면 탈출
            break;
        }
    }

    public static void main(String[] args) {
        recur2(4);
        System.out.println("---------------------");
        recur2Loop(4);
    }
}

/*
*     n = 4
*                   recur2(2),               4,                                  recur2(3)
*     recur2(0),      2,      recur2(1)                          recur2(1),          3,        recur2(2)
*       empty        recur2(-1), 1, recur2(0)            recur2(-1), 1, recur2(0)     recur2(0),    2,    recur2(1)
*                     empty          empty                 empty          empty         empty     recur2(-1), 1, recur2(0)
*
* */

