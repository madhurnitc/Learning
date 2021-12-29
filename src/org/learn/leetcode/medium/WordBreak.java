package org.learn.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WordBreak {

    public boolean wordBreak(String s, List<String> wordDict) {

        TrieNode root = buildTrie(wordDict);
        TrieNode node = root;
        boolean[] seen = new boolean[s.length()+1];
        seen[s.length()] = true;

        for(int i = s.length()-1; i>=0; i--) {
            node = root;
            for(int j = i; node != null && j<s.length(); j++) {
                node = node.next[s.charAt(j)-'a'];
                if(node != null && node.isWord && seen[j+1]) {
                    seen[i] = true;
                    break;

                }
            }
        }

        return seen[0];
    }

    public TrieNode buildTrie(List<String> words) {
        TrieNode root = new TrieNode();

        for(String word : words) {
            TrieNode node = root;
            for(char c : word.toCharArray()) {
                if(node.next[c-'a'] == null) {
                    node.next[c-'a'] = new TrieNode();
                    node.next[c-'a'].ch = c;
                }
                node = node.next[c-'a'];
            }
            node.isWord = true;
        }

        return root;

    }
    public class TrieNode {
        boolean isWord = false;
        char ch;
        TrieNode[] next = new TrieNode[26];
    }

    public static void main(String[] args) {
        List<String> words = Arrays.asList("leet", "code");
        String word = "leetcode";
        new WordBreak().wordBreak(word, words);
    }
}
