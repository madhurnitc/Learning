public class Problem125 {
    public boolean isPalindrome(String s) {

        if (s == null || s.length() == 0 || s.isEmpty()) {
            return true;
        }

        int left = 0;
        int right = s.length()-1;
        while (left <= right) {

            while (left < s.length() && !Character.isLetterOrDigit(s.charAt(left))) {
                left++;
            }

            while(right >= 0 && !Character.isLetterOrDigit(s.charAt(right))) {
                right--;
            }

            if(left < s.length() && right >=0 &&  Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
                return false;
            }

            left++;
            right--;


        }

        return true;
    }

    public static void main(String[] args) {
        String str = " ";

        new Problem125().isPalindrome(str);
    }
}
