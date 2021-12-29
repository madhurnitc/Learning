import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Problem1496 {
    public boolean isPathCrossing(String path) {
        Set<String> set = new HashSet<>();
        int[] current = new int[] {0,0};
        set.add(0 +","+0);
        Map<Character,int[]> map = new HashMap<>();
        map.put('N', new int[] {0,1});
        map.put('S', new int[] {0,-1});
        map.put('E', new int[] {1,0});
        map.put('W', new int[] {-1,0});
        for(int i =0; i<path.length() ; i++) {
            int[] dir = map.get(path.charAt(i));
            current = new int[]{current[0]+dir[0], current[1]+dir[1]};
            String cordinateAsString =  new StringBuilder().append(current[0]).append(",").append(current[1]).toString();
            if(set.contains(cordinateAsString)) {
                return true;
            }
            set.add(cordinateAsString);

        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new Problem1496().isPathCrossing("NESWW"));
    }
}
