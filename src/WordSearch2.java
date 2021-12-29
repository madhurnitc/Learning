import java.util.*;

public class WordSearch2 {

    Set<String> words = new HashSet<>();
    Map<String, List<String>> dp = new HashMap<>();
    public List<String> wordBreak(String s, List<String> wordDict) {
        wordDict.stream().forEach(w-> words.add(w));

        return dfs(s, words, dp );

    }

    private List<String> dfs(String s, Set<String> words, Map<String, List<String>> dp) {

        if(dp.containsKey(s)) {
            return dp.get(s);
        }

        List<String> result = new ArrayList<>();
        if(s.isEmpty()) {
            result.add("");
            return result;
        }

        for(String word : words) {
            if(s.startsWith(word)) {
                List<String> suffixes = dfs(s.substring(word.length()),words, dp);
                for(String suffix : suffixes) {
                    result.add(word + (suffix.isEmpty()?"": " ") + suffix);
                }
            }
        }

        dp.put(s, result);
        return result;
    }

    public static void main(String[] args) {
        List<String>  wordDict = new ArrayList<>(Arrays.asList(new String[]{"cat", "cats", "and", "sand", "dog", "do", "go"}));
        String word = "catsanddogo";

        List<String> result = new WordSearch2().wordBreak(word, wordDict);
    }
}
