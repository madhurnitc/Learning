import java.util.HashSet;
import java.util.Set;

public class GoatLatin {

    public String toGoatLatin(String sentence) {
        Set<Character> vowels = new HashSet<>();
        vowels.add('A');
        vowels.add('E');
        vowels.add('I');
        vowels.add('O');
        vowels.add('U');
        vowels.add('a');
        vowels.add('e');
        vowels.add('i');
        vowels.add('o');
        vowels.add('u');

        String goat = "maa";
        StringBuilder sb = new StringBuilder();
        String[] words = sentence.split(" ");

        for(String word : words) {


            if(vowels.contains(word.charAt(0))){
                sb.append(word).append(goat).append(" ");
            }else {

                sb.append(word.substring(1));

                sb.append(word.charAt(0)).append(goat).append(" ");
            }
            goat += "a";
        }

        return sb.toString().trim();

    }

    public static void main(String[] args) {
        System.out.println( new GoatLatin().toGoatLatin("I speak Goat Latin"));
    }
}
