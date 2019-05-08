package org.learn.leetcode.easy;

public class WordDistanceEasy {

    public int shortestDistance(String[] words, String word1, String word2) {
        int idx1 =-1, idx2 =-1;
        int minDistance = words.length;
        for(int i = 0; i<words.length; i++) {
            if(words[i].equals(word1)) {
                idx1 = i;
            }else if (words[i].equals(word2)) {
                idx2 = i;
            }

            if(idx1!=-1 && idx2!=-1) {
                minDistance = Math.min(minDistance, Math.abs(idx1-idx2));
            }
        }

        return minDistance;
    }

    public static void main(String[] args) {
        String[] input = {"practice", "makes", "perfect", "coding", "makes"};
        System.out.println(new WordDistanceEasy().shortestDistance(input, "coding", "practise"));
    }
}
