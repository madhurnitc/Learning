public class Problem28 {

    public int strStr(String haystack, String needle) {

        if (needle.isEmpty()) {
            return -1;
        }

        if (haystack.length() < needle.length()) {
            return -1;
        }

        int hlength = haystack.length();
        int nlength = needle.length();

        for (int i = 0; i < hlength; i++) {
            for (int j = 0; j < nlength; j++) {
                if (hlength - i < nlength) {
                    return -1;
                }

                if (haystack.charAt(i + j) != needle.charAt(j)) {
                    break;
                }

                if (j == nlength - 1) {
                    return i;
                }

            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(new Problem28().strStr("sadbutsad", "sad"));
    }
}
