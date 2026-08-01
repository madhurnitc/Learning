import java.util.ArrayList;
import java.util.List;



public class EmployeeFreeTime {

    public List<Interval> employeeFreeTime(List<List<Interval>> schedule) {
        List<int[]> flattenedIntervals = new ArrayList<>();
        for(List<Interval> employee : schedule){
           for(Interval interval : employee){
               flattenedIntervals.add(new int[]{interval.start,interval.end});
           }
        }
        flattenedIntervals.sort((i1, i2) -> i1[0] - i2[0]);
        List<int[]> merged = new ArrayList<>();
        for(int[] flattenedInterval: flattenedIntervals){
            if(merged.isEmpty() || merged.get(merged.size()-1)[1]<flattenedInterval[0]){
                merged.add(new int[]{flattenedInterval[0],flattenedInterval[1]});
            }else {
                merged.get(merged.size()-1)[1] = Math.max(merged.get(merged.size()-1)[1],flattenedInterval[1]);
            }
        }

        List<Interval> result = new ArrayList<>();
        for(int i = 1; i < merged.size(); i++){
            if(merged.get(i)[0]>merged.get(i-1)[1]){
                result.add(new Interval(merged.get(i-1)[0],merged.get(i)[1]));
            }
        }
        return result;
    }

    public class Interval {
        public int start;
        public int end;

        public Interval() {}

        public Interval(int _start, int _end) {
            start = _start;
            end = _end;
        }
    }

}
