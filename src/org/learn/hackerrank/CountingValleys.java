package org.learn.hackerrank;

public class CountingValleys {

    static int countingValleys(int n, String s) {

        int result = 0;
        int level = 0;
        for (char c : s.toCharArray()) {
            if ( c == 'U' && level == -1) {
                result++;
                level++;
            } else if ( c == 'U') {
                level++;
            }else {
                level--;
            }
        }

        return result;
    }


    public static void main(String[] args) {
        countingValleys(12, "DDUUDDUDUUUD");
    }
}
