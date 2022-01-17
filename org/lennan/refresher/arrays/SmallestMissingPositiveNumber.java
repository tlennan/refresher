package org.lennan.refresher.arrays;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SmallestMissingPositiveNumber {
    public static void main(String[] args) {
        int[] list = {2, 9, -10, 5, 3, 1, 11, -1, 7};

        Integer smallest = smallestMissingHash(list);
        System.out.println(smallest);
        smallest = smallestMissingSort(list);
        System.out.println(smallest);
    }

    private static Integer smallestMissingSort(int[] list) {
        Arrays.sort(list);
        int smallest = 1;
        for (int i = 0; i < list.length; i++) {
            Integer currentValue = list[i];
            if (currentValue > 0) {
                if (currentValue == smallest) {
                    smallest++;
                }
            }
        }

        return smallest;
    }

    private static Integer smallestMissingHash(int[] list) {
        Set<Integer> seen = new HashSet<>();
        int smallest = 1;
        for (int i = 0; i < list.length; i++) {
            Integer currentValue = list[i];
            if (currentValue > 0) {
                if (currentValue == smallest) {
                    smallest++;
                    while (seen.contains(smallest)) {
                        smallest++;
                    }
                } else {
                    seen.add(currentValue);
                }
            }
        }

        return smallest;
    }
}
