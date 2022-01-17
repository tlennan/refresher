package org.lennan.refresher.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MoveZeroesToArrayEnd {
        
    public static void main(String[] args) {
        Integer[] testData = {1, 2, 3, 4 ,5, 6, 7, 8, 9, 0};
        
        moveZeroesToArrayEnd(testData);

        System.out.println(Arrays.asList(testData).toString());
    }

    // Urgh side effects are bad
    private static void moveZeroesToArrayEnd(Integer[] data) {
        int readIndex = data.length - 1;
        int writeIndex = data.length - 1;

        while (readIndex >= 0) {
            if (data[readIndex] == 0) {
                readIndex--;
            } else {
                data[writeIndex--] = data[readIndex--];
            }
        }

        while (writeIndex >= 0)
            data[writeIndex--] = 0;
    }
}
