import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Tes {


    public static void main(String[] args) {
       Map<Point, Character> map = new HashMap<>();
       Point p = new Point(1, 1);
       map.put(p, 'a');
       p.x = 2;
       System.out.println(map.get(p));
       System.out.println(map.containsKey(p));

        
    }


}
