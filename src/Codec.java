import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Codec {
    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        if(strs == null || strs.size() == 0){
            return new String(Character.toString((char)258));
        }
        StringBuilder sb = new StringBuilder();
        String delim = Character.toString((char)257);
        for(String str : strs) {
            sb.append(str);
            sb.append(delim);
        }
        sb.deleteCharAt(sb.length()-1);
        return sb.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        if(s == Character.toString((char)258)){
            return new ArrayList<>();
        }
        String delim = Character.toString((char)257);
        return Arrays.asList(s.split(delim,-1));
    }

    public static void main(String[] args) {
        Codec codec = new Codec();
        List<String> strs = new ArrayList<>();
        strs.add("\",\"");
        String encoded = codec.encode(strs);
        List<String> result = codec.decode(encoded);

    }
}
