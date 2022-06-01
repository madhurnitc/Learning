import java.util.*;

public class KillProcess {

    public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {

        Map<Integer, List<Integer>> map = new HashMap<>();

        for(int i = 0; i<pid.size(); i++) {

            int childPid = pid.get(i);
            int parentPid = ppid.get(i);
            map.computeIfAbsent(parentPid, k->new ArrayList<>()).add(childPid);
        }

        List<Integer> result = new ArrayList<>();
        result.add(kill);
        List<Integer> childPids = map.get(kill);

        getAllChildren(map, result, kill);
        return result;


    }

    private void getAllChildren(  Map<Integer, List<Integer>> map, List<Integer> result, int kill) {

        if(map.containsKey(kill)) {
            for(int id : map.get(kill)){
                result.add(id);
                getAllChildren(map, result, id);
            }
        }
    }

    public static void main(String[] args) {
        List<Integer> pid = Arrays.asList(new Integer[]{1,3,10,5});
        List<Integer> ppid = Arrays.asList(new Integer[]{3,0,5,3});
        List<Integer> result = new KillProcess().killProcess(pid, ppid, 5);
    }
}
