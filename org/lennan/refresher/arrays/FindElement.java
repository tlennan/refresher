package org.lennan.refresher.arrays;

public class FindElement {
    public static void main(String[] args) {
        int[] testData = { 0, 1, 3, 5, 7, 11, 13, 15, 123 };

        System.out.println(findValueInArray(testData, 7));
    }

    private static int findValueInArray(int[] data, int value) {
        int chunkSize = data.length / 2;
        int index = chunkSize;
        boolean found = false;
        while (!found) {
            chunkSize /= 2;
            if (chunkSize == 0) {
                chunkSize = 1;
            }
            if (data[index] < value) {
                index += chunkSize;
            } else if (data[index] < value) {
                index -= chunkSize;
            } else {
                found = true;
            }
        }

        return index;
    }
}
