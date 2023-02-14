package es.ujaen.ssccdd;

public class PrimeGenerator extends Thread {

    public static boolean isPrime(long n) {
        if (n <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    @Override
    public void run() {
        long number = 1L;

        while (true) {
            if (isPrime(number)) {
                System.out.println("Number " + number + " is Prime\n");
            }

            if (isInterrupted()) {
                System.out.println("The Prime Generator has been Interrupted\n");
                return;
            }
            number++;
        }
    }


}
