package org.solutions.findmissingnumbers;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;


/**
 * Two numbers are missing from range of numbers. Find those two missing numbers
 * <p>
 * Eg. for the range 1 to 100
 * Consider 64 and 43 numbers are missing.
 * The solution should find these missing numbers
 *
 * Time Complexity: O(n)
 * This time is needed to populate the hashmap for finding the missing numbers
 * */
public class MissingNumbers {

    public static void main(String[] args) {
        List<Integer> numbersToIgnore = Stream.of(64, 43).collect(Collectors.toList());
        List<Integer> inputDataSet = getDataSet(1, 100, numbersToIgnore);
        List<Integer> allTheNumbersFromTheRange = getDataSet(1, 100, Collections.emptyList());
        findMissingNumbers(inputDataSet, allTheNumbersFromTheRange);
    }

    private static void findMissingNumbers(List<Integer> inputDataSet, List<Integer> allTheNumbersFromTheRange) {
        int sumOfInputDataSet = getSum(inputDataSet);
        int sumOfTheRange = getSum(allTheNumbersFromTheRange);
        int sumOfMissingNumbers = sumOfTheRange - sumOfInputDataSet;
        Map<Integer, Integer> sumPairs = new HashMap<>();
        inputDataSet.forEach(num -> sumPairs.put(num, sumOfMissingNumbers - num));
        for (Integer num : allTheNumbersFromTheRange) {
            if (!sumPairs.containsKey(num)) {
                System.out.println(num);
                System.out.println(sumOfMissingNumbers - num);
                break;
            }
        }
    }

    private static int getSum(List<Integer> inputDataSet) {
        return inputDataSet.stream().mapToInt(value -> value).sum();
    }

    private static List<Integer> getDataSet(int start, int end, List<Integer> numbersToIgnore) {
        List<Integer> arr = new ArrayList<>();
        for (int i = start; i < end; i++) {
            if (!numbersToIgnore.isEmpty() && numbersToIgnore.contains(i)) {
                continue;
            }
            arr.add(i);
        }
        return arr;
    }
}
