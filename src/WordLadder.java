import java.util.*;

public class WordLadder {

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> targets = new HashSet<>();
        for(String word : wordList) {
            targets.add(word);
        }

        if(!targets.contains(endWord)) {
            return 0;
        }

        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        int step = 0;
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            step++;
            for(int i =0; i < levelSize; i++) {

                String word = queue.poll();
                //targets.remove(word);
                for(int j = 0; j < word.length(); j++) {
                    char[] charArray = word.toCharArray();
                    for(char c = 'a'; c<='z'; c++) {
                        charArray[j] = c;
                        String target = String.valueOf(charArray);

                        if(target.equals(endWord)) {
                            return step+1;
                        }

                        if(targets.contains(target)) {
                            targets.remove(target); // basically we don't want to visit this word again and end up adding in the queue.
                            queue.add(target);
                        }
                    }
                }

            }

        }

        return 0;
    }

    public static void main(String[] args) {
        System.out.println(new WordLadder().ladderLength("hit", "cog", Arrays.asList("hot", "dot", "dog","lot", "log", "cog")));
    }
}
