import java.util.HashMap;
import java.util.Map;

public class Trie {

    TrieNode root;
    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {

    }

    private void insert(String word, TrieNode root){

        TrieNode node = root;
        for(char ch : word.toCharArray()){
            if(!node.children.containsKey(ch)) {
                TrieNode current = new TrieNode();
                node.children.put(ch, current);
            }
            node = node.children.get(ch);
        }
        node.word = true;
    }

    public boolean search(String word) {

        TrieNode node = root;
        for(char ch : word.toCharArray()){

            if (!node.children.containsKey(ch)) {
                return false;
            }
            node = node.children.get(ch);
        }

        return node.word;

    }

    public boolean startsWith(String prefix) {
        TrieNode node = root;
        for(char ch : prefix.toCharArray()) {
            if(!node.children.containsKey(ch)){
                return false;
            }
            node = node.children.get(ch);
        }

        return true;
    }

    public class TrieNode {

        boolean word = false;
        Map<Character, TrieNode> children = new HashMap<>();

    }
}
