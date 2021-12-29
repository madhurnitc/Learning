package org.learn.leetcode.amazon;

import java.util.Arrays;
import java.util.Comparator;

public class MaximumUnitsOnTruck {


    public int maximumUnits(int[][] boxTypes, int truckSize) {
        int unitCount = 0;
        int remainingTruckSize = truckSize;

        Arrays.sort(boxTypes, new Comparator<int[]>() {

            public int compare(int[] a , int[] b) {
                return b[1]-a[1];
            }
        });

        for (int i = 0; i<boxTypes.length; i++) {
            int boxCount = Math.min(remainingTruckSize, boxTypes[i][0]);
            unitCount = unitCount + boxCount*boxTypes[i][1];
            remainingTruckSize = remainingTruckSize - boxCount;
        }

        return unitCount;

    }
}
