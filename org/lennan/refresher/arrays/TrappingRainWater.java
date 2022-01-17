package org.lennan.refresher.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class TrappingRainWater {
    public static void main(String[] args) {
//        Input: arr[]   = {2, 0, 2}
//        Output: 2

//        Input: arr[]   = {3, 0, 2, 0, 4}
//        Output: 7
        System.out.println("{2, 0, 2} = " + compute(Arrays.asList(2, 0, 2)) );
        System.out.println("{2, 0, 2} = " + compute(Arrays.asList(3, 0, 2, 0, 4)) );
    }

    private static Integer compute(List<Integer> terrain) {
        Integer currentAltitude = 0;
        List<Integer> peaks = new ArrayList<>();

        // Uphill
        for (int i = 0; i < terrain.size(); i++) {
            if (terrain.get(i) >= currentAltitude) {
                peaks.add(i);
                currentAltitude = terrain.get(i);
            }
        }

        // Downhill
        currentAltitude = 0;
        Integer highestPeak = terrain.get(peaks.size() - 1);
        for (int i = terrain.size() - 1; i >= highestPeak; i--) {
            if (terrain.get(i) >= currentAltitude) {
                peaks.add(i);
                currentAltitude = terrain.get(i);
            }
        }

        List<Integer> sortedPeaks = peaks.stream().sorted().distinct().collect(Collectors.toList());

        Integer volume = 0;
        for (int j = 0; j < sortedPeaks.size() - 1; j++) {
            volume += computeVolume(terrain.subList(sortedPeaks.get(j), sortedPeaks.get(j + 1) + 1));
        }

        return volume;
    }

    private static Integer computeVolume(List<Integer> valley) {
        Integer volume = 0;
        Integer min = Math.min(valley.get(0), valley.get(valley.size() - 1));
        for (int i = 0; i < valley.size(); i++) {
            Integer height = valley.get(i);
            if (height < min) {
                volume += min - height;
            }
        }

        return volume;
    }
}
