public class ShortestWordDistance2 {

    public int shortestWordDistance(String[] wordsDict, String word1, String word2) {
        int index = -1;
        int min = wordsDict.length;

        for(int i = 0; i< wordsDict.length; i++) {

            if(wordsDict[i].equals(word1) || wordsDict[i].equals(word2)) {

                if(index != -1 && (word1.equals(word2) || !wordsDict[index].equals(wordsDict[i])) ){
                    min = Math.min(min, i-index);
                }
                index = i;
            }

        }

        return min;
    }

    public static void main(String[] args) {
        String[] words = {"practice", "makes", "perfect", "coding", "makes"};
        String w1 = "makes";
        String w2 = "coding";

        System.out.println(new ShortestWordDistance2().shortestWordDistance(words, w1, w2));
    }
}
