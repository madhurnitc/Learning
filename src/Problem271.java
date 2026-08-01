import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem271 {

    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {

        if (strs == null || strs.size() == 0) {
            return Character.toString((char) 258);
        }
        StringBuilder sb = new StringBuilder();
        String delimitter = Character.toString((char) 257);
        for (String str : strs) {
            sb.append(str);
            sb.append(delimitter);
        }
        sb.deleteCharAt(sb.length() - 1);

        return sb.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        if (s.equals(Character.toString((char) 258))) {
            return new ArrayList<>();
        }

        String d = Character.toString((char) 257);
        return Arrays.asList(s.split(d, -1));
    }
}
