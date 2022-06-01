import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class RingsAndRods {

    public int countPoints(String rings) {

        Map<Integer, Set<Character>> map= new HashMap<>();
        int result = 0;

        for(int i =0; i<rings.length();  i  =i+2 ) {

            int rod = Integer.valueOf(rings.charAt(i+1)-'0');
            char color = rings.charAt(i);
            map.computeIfAbsent(rod, r-> new HashSet<>());
            Set<Character> colors =  map.get(rod);
            if(colors.add(color)){
                if(colors.size() == 3){
                    result++;
                }
            }

        }


        return result;
    }


    public static void main(String[] args) {
        new RingsAndRods().countPoints("B0R0G0R9R0B0G0");
    }
}
