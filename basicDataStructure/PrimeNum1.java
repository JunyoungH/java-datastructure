package basicDataStructure;

public class PrimeNum1 {
    public static void main(String[] args) {
        int[] prime = new int[500];
        int index = 0;
        prime[index++] = 2;
        prime[index++] = 3;

        //홀수만 대상으로 함
        for(int i = 5; i <= 100; i += 2) {
            boolean isPrime = true;
            for(int j = 1; prime[j]*prime[j] <= i; j++) {
                if(i % prime[j] == 0) {
                    isPrime = false;
                    break;
                }
            }

            if(isPrime) {
                prime[index++] = i;
            }
        }

        for (int i = 0; i < index; i++)			// 찾은 ptr개의 소수를  나타냄
            System.out.println(prime[i]);
    }
}
