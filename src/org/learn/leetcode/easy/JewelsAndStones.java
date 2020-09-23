package org.learn.leetcode.easy;

import java.util.HashSet;
import java.util.Set;

public class JewelsAndStones {

    public int numJewelsInStones(String J, String S) {

        int result = 0;

        Set<Character> jewels = new HashSet<>();
        for (int i = 0; i < J.length(); i++) {
            jewels.add(J.charAt(i));
        }

        for (int i = 0; i < S.length(); i++) {
            if (jewels.contains(S.charAt(i))) {
                result++;
            }
        }

        return result;

    }

    public static void main(String[] args) {

        JewelsAndStones js = new JewelsAndStones();
        System.out.println(js.numJewelsInStones("aA", "aAAbbb"));
        System.out.println(js.numJewelsInStones("z", "ZZ"));

    }
}
