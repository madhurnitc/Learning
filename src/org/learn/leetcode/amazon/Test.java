package org.learn.leetcode.amazon;

import java.time.Instant;
import java.util.Date;

public class Test {

    public static void main (String[] args){


        Date date = Date.from(Instant.ofEpochSecond(1650550248));
        System.out.println(date);
        Date date2 = Date.from(Instant.ofEpochMilli(1650550248000L));
        System.out.println(date2);
    }
}
