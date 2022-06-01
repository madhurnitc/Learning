public class RepeatedSubString {

    public boolean repeatedSubstringPattern(String s) {
        String a1=s+s;
        String a2=a1.substring(1,a1.length()-1);
        if(a2.contains(s)) return true;
        else return false;
    }

    public static void main(String[] args) {
        RepeatedSubString s = new RepeatedSubString();
        System.out.println(s.repeatedSubstringPattern("abcabc"));
    }
}
