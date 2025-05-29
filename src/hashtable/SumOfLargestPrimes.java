package hashtable;

import java.util.*;

public class SumOfLargestPrimes {

    public static void main(String[] args) {
        SumOfLargestPrimes sol = new SumOfLargestPrimes();
        String input = "3175"; // Example input
        long result = sol.sumOfLargestPrimes(input);
        System.out.println("Sum of the 3 largest unique primes: " + result);
    }

    public long sumOfLargestPrimes(String s) {
        Set<Long> primeSet = new HashSet<>();

        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j <= s.length(); j++) {
                String digit = s.substring(i, j);
                try {
                    long num = Long.parseLong(digit);
                    if (isPrime(num)) {
                        primeSet.add(num);
                    }
                } catch (NumberFormatException e) {
                    // Skip numbers that are too large
                    continue;
                }
            }
        }

        List<Long> primeList = new ArrayList<>(primeSet);
        Collections.sort(primeList, Collections.reverseOrder());

        long sum = 0;
        for (int i = 0; i < Math.min(3, primeList.size()); i++) {
            sum += primeList.get(i);
        }

        return sum;
    }

//    public boolean isPrime(long num) {
//        if (num <= 1) return false;
//        if (num == 2) return true;
//        if (num % 2 == 0) return false;
//        for (long i = 3; i * i <= num; i += 2) {
//            if (num % i == 0) return false;
//        }
//        return true;
//    }

    public boolean isPrime(long num) {
        if (num <= 1) return false;
        if (num <= 3) return true;
        if (num % 2 == 0 || num % 3 == 0) return false;

        for (long i = 5; i * i <= num; i += 6) {
            if (num % i == 0 || num % (i + 2) == 0) return false;
        }
        return true;
    }

}
