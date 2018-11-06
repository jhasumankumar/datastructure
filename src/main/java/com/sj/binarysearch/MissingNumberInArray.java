package com.sj.binarysearch;

import java.util.Arrays;
import java.util.BitSet;
public class MissingNumberInArray {
    public static void main(String args[]) {




        // Only one missing number in array
        int[] iArray = new int[]{-1, -3};
        int missing = getMissingNumber(iArray, 3);
        System.out.printf("Missing number in array %s is %d %n",
                Arrays.toString(iArray), missing);
    }
    /**
     * A general method to find missing values from an integer array in Java.
     * This method will work even if array has more than one missing element.
     */
    private static void printMissingNumber(int[] numbers, int count) {
        int missingCount = count - numbers.length;
        BitSet bitSet = new BitSet(count);

        for (int number : numbers) {
            bitSet.set(number - 1);
        }

        System.out.printf("Missing numbers in integer array %s, with total number %d is %n",
                Arrays.toString(numbers), count);
        int lastMissingIndex = 0;

        for (int i = 0; i < missingCount; i++) {
            lastMissingIndex = bitSet.nextClearBit(lastMissingIndex);
            System.out.println(++lastMissingIndex);
        }

    }
    /**
     * Java method to find missing number in array of size n containing
     * numbers from 1 to n only.
     * can be used to find missing elements on integer array of
     * numbers from 1 to 100 or 1 - 1000
     */
    private static int getMissingNumber(int[] numbers, int totalCount) {
        int expectedSum = totalCount * ((totalCount + 1) / 2);
        int actualSum = 0;
        for (int i : numbers) {
            actualSum += i;
        }

        return expectedSum - actualSum;
    }

}
