public class NumbersEndingIn7 {

    public static void main(String[] args) {

        for (int n = 0; n < 1000; n++) {
            if (n % 10 == 7) {
                System.out.println(n);
            }
        }

    }

}
