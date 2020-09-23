package org.learn.hackerrank;

public class JumpingOnClouds {

    static int jumpingOnClouds(int[] c) {

        return 1+ Math.min(jumpOnClouds(c,1 ), jumpOnClouds(c,2));
    }

    static int jumpOnClouds(int[] c, int index) {

        if(index >= c.length || c[index] == 1) {
            return Integer.MAX_VALUE;
        }


        return 1 + Math.min(jumpOnClouds(c,index + 1 ), jumpOnClouds(c,index + 2));
    }

}