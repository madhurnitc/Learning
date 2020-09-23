package org.learn.leetcode.easy;

import java.util.List;

public class Sol3 {


    public static void maximumCupcakes(List<String> trips) {
        // Write your code here

        for(String trip : trips) {
            String[] spliited = trip.split(" ");
            int cash = Integer.parseInt(spliited[0]);
            int cost = Integer.parseInt(spliited[1]);
            int wrapper = Integer.parseInt(spliited[2]);
            System.out.println(totalCupcakes(cash, cost, wrapper));
        }
    }

    private static int totalCupcakes(int cash, int cost, int wrapper_cost) {

        int chocolcate = cash/cost;
        int wrappers = chocolcate;
        while(wrappers/wrapper_cost >0) {
            int newChoc = wrappers/wrapper_cost;
            wrappers-= newChoc*wrapper_cost;
            wrappers+=newChoc;
            chocolcate+=newChoc;

        }
        return chocolcate;
    }
}
