public class Probem1941 {

    public boolean areOccurrencesEqual(String s) {
        int[] chars = new int[26];
        for(char ch : s.toCharArray() ){

            chars[ch-'a']++;
        }
        int prev = chars[s.charAt(0)-'a'];
        for(int count : chars) {
            if(count != 0 && count != prev) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        String s = "abacbc";

        new Probem1941().areOccurrencesEqual(s);
    }
}
