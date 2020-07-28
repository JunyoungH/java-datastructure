package recursion;

import stackAndQueue.IntStack;

public class RecursionLoop {
    static IntStack stack = new IntStack(20);

    /*
    *
    *
    *  if(n > 0) {
    *        recur(n - 1);
    *        System.out.println(n);
    *        recur(n - 2);
    *    }
    *  convert this recursion to loop
    * */

     static void recursionLoop(int n) {
        while (true) {
            if(n > 0) {
                stack.push(n);
                n = n - 1;
                continue;
            }

            if(!stack.isEmpty()) {
                n = stack.pop();
                System.out.println(n);
                n = n - 2;
                continue;
            }
            break;
        }
    }

    public static void main(String[] args) {

    }
}
