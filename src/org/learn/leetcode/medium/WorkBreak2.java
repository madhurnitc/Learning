package org.learn.leetcode.medium;

import java.util.Arrays;
import java.util.List;

public class WorkBreak2 {

    public boolean wordBreak(String s, List<String> words) {
        //build a trie with the dictionary words which will be used for searching the string s
        TrieNode root = buildTrie(words);
        TrieNode node = root;

        //keep an array to mark if the words are seen in the trie
        boolean[] seen = new boolean[s.length()+1];
        seen[s.length()] = true;

        //start traversing from the back of the string s and take all the substrings to check if that substring exists in the trie
        //and if it exist then is that substring is also a word from the dictionary
        for(int i=s.length()-1 ; i>=0 ; i--){
            node = root;
            for(int j=i ; node != null && j<s.length() ; j++){
                node = node.next[s.charAt(j) - 'a'];
                if(node != null && node.isWord && seen[j + 1]){
                    seen[i] = true;
                    break;
                }
            }
        }
        return seen[0];
    }

    public TrieNode buildTrie(List<String> words){
        TrieNode root = new TrieNode();
        for(String word : words){
            TrieNode node = root;
            for(char c : word.toCharArray()){
                if(node.next[c-'a'] == null){
                    node.next[c-'a'] = new TrieNode();
                }
                node = node.next[c-'a'] ;
            }
            node.isWord = true;
        }
        return root;
    }

    class TrieNode{
        TrieNode[] next = new TrieNode[26];
        boolean isWord;
    }

    public static void main(String[] args) {
        List<String> words = Arrays.asList("leet", "code");
        String word = "leetcode";
        new WorkBreak2().wordBreak(word, words);
    }
}
