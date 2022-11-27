public class Advotics1 {
    public static void main(String[] args) {
        printPrimes(0);
        printPrimes(1);
        printPrimes(2);
        printPrimes(4);
        printPrimes(8);
    }

    private static void printPrimes(int number) {
        int i = 0;
        int curNum = 1;
        StringBuilder sb = new StringBuilder();
        while(i < number) {
            if(isPrime(curNum)) {
                if(sb.length() != 0) {
                    sb.append(" ");
                }
                sb.append(curNum);
                i++;
            }
            curNum++;
        }
        System.out.println(sb);
    }

    private static boolean isPrime(int number) {
        if(number == 1) return false;
        if(number == 2) return true;
        for(int i = 2; i <= number / 2; ++i) {
            if(number % i == 0) return false;
        }
        return true;
    }
}