import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        combinationSum(candidates, result, new ArrayList<>(), target, 0);

        return result;

    }

    public void combinationSum(int[] candidates, List<List<Integer>> result, List<Integer> items, int remaining, int start) {

        if(remaining <0) {
            return;
        }

        if(remaining == 0) {
            result.add(new ArrayList<>(items));
        }

        for(int i = start; i<candidates.length; i++) {

            items.add(candidates[i]);
            combinationSum(candidates, result, items, remaining-candidates[i], i);
            items.remove(items.size()-1);
        }


    }

    public static void main(String[] args) {
        CombinationSum cs = new CombinationSum();
        List<List<Integer>> list = cs.combinationSum(new int[]{2,3,5,7}, 7);
    }
}
