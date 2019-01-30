public class RecursiveFibonacci {
    public static void main(String[] args) {

        int n = 50;
        long[] fibonaccies = new long[n+1];
        fibonaccies[0] = 0;
        fibonaccies[1] = 1;

        for (int i = 2; i <= n ; i++) {
            fibonaccies[i] = -1;
        }

        long fib8 = fibonacci(n, fibonaccies);
        System.out.println(fib8);

    }

    static long fibonacci(int n, long[] fibonaccies) {

        if (fibonaccies[n] != -1) {
            return fibonaccies[n];
        }

        System.out.println("Calculating fibonacci of " + n);

        long prev = fibonacci(n-1, fibonaccies);
        long prevPrev = fibonacci(n-2, fibonaccies);

        long result = prev + prevPrev;
        fibonaccies[n] = result;

        return result;

    }

}
