package org.learn.leetcode.easy;

import java.util.HashSet;
import java.util.Set;

public class UniqueMorseRepresentations {

    public int uniqueMorseRepresentations(String[] words) {
        String[] morseCodes = new String []{".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..", "--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        Set<String> set = new HashSet<>();
        for(String word : words) {
            StringBuilder sb = new StringBuilder();
            for(char c : word.toCharArray()){
                int morseIndex = c - 'a';
                sb.append(morseCodes[morseIndex]);
            }
            set.add(sb.toString());

            System.out.println(word + " <-->   " + sb.toString());
        }

        return set.size();
    }

    public static void main (String[] args) {
        UniqueMorseRepresentations umr = new UniqueMorseRepresentations();
        System.out.println(umr.uniqueMorseRepresentations(new String[]{"gin", "zen", "gig", "msg"}));
    }
}
