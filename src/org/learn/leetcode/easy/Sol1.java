package org.learn.leetcode.easy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Sol1 {


    public static void closestNumbers(List<Integer> numbers) {
        // Write your code here
        Collections.sort(numbers);

        int i = 0;
        int j = 1;

        int minDiff = Integer.MAX_VALUE;
       while(i<numbers.size() && j < numbers.size()) {
           int diff = Math.abs(numbers.get(i)-numbers.get(j));
           if(diff < minDiff){
               minDiff = diff;
           }
           i++;j++;
       }

       for(int k =0;k<numbers.size()-1;k++){
           int diff = Math.abs(numbers.get(k)-numbers.get(k+1));
           if(diff == minDiff){
               System.out.println(numbers.get(k) + " " + numbers.get(k+1));
           }
       }


    }

    public static void main(String[] args) {
        List l = new ArrayList();
        l.add(4);
        l.add(2);
        l.add(1);
        l.add(3);
        Sol1.closestNumbers(l);
    }

}
