import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Problem1386CinemaSeatAllocation {

    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {

        Map<Integer, Set<Integer>> graph = new HashMap<>();
        for(int[] reserved : reservedSeats) {
            int row = reserved[0];
            int seatNum = reserved[1];
            graph.computeIfAbsent(row, r-> new HashSet<>());
            graph.get(row).add(seatNum);
        }

        int result = (n-graph.size())*2;

        for(Set<Integer> reserved : graph.values() ) {
            boolean specialCaseUsed = false;
            if( !reserved.contains(2) && !reserved.contains(3) && !reserved.contains(4) && !reserved.contains(5)) {
                result++;
                specialCaseUsed= true;
            }

            if( !reserved.contains(6) && !reserved.contains(7) && !reserved.contains(8) && !reserved.contains(9)) {
                result++;
                specialCaseUsed= true;
            }

            if(!specialCaseUsed ){
                if(!reserved.contains(4) && !reserved.contains(5) && !reserved.contains(6) && !reserved.contains(7)){
                    result++;
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[][] seats = {{1,2},{1,3},{1,8},{2,6},{3,1},{3,10}};

        System.out.println(new Problem1386CinemaSeatAllocation().maxNumberOfFamilies(3, seats));
    }
}
