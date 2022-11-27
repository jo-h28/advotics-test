import java.util.*;

public class Advotics3 {
    public static void main(String[] args) {
        int[] arr = {1, 1, 2, 2, 3, 3, 3, 3, 4, 4, 5, 5};
        int k = 6;
        System.out.println(countSumToK(arr, k));
        printTupleList(sumToK(arr, k));
    }

    private static void printTupleList(List<Tuple> tuples) {
        for(Tuple tuple: tuples) {
            System.out.println(tuple.number1 + " " + tuple.number2);
        }
    }

    private static List<Tuple> sumToK(int[] arr, int k) {
        Map<Integer, Integer> countMap = new HashMap<>();
        for(int el: arr) {
            countMap.put(k - el, countMap.getOrDefault(k - el, 0) + 1);
        }
        List<Tuple> result = new ArrayList<>();
        boolean equalDiffProcessed = false;
        for(int el: arr) {
            if(countMap.containsKey(el)) {
                int count = countMap.get(el), nCopy = count / 2;
                if(k == el * 2) {
                    if(!equalDiffProcessed) {
                        nCopy = count * (count - 1) / 2;
                        equalDiffProcessed = true;
                    }
                    else {
                        continue;
                    }
                }
                result.addAll(Collections.nCopies(nCopy, new Tuple(Math.min(el, k - el), Math.max(el, k - el))));
            }
        }
        return result;
    }

    public static int countSumToK(int[] arr, int k) {
        Map<Integer, Integer> countMap = new HashMap<>();
        for(int el: arr) {
            countMap.put(k - el, countMap.getOrDefault(k - el, 0) + 1);
        }
        int count = 0;
        for(int el: arr) {
            if(countMap.containsKey(el)) {
                count += countMap.get(el);
                if(k == el * 2) {
                    count--;
                }
            }
        }
        return count / 2;
    }
     static class Tuple {
        int number1, number2;

        Tuple(int num1, int num2) {
            number1 = num1;
            number2 = num2;
        }
     }
}