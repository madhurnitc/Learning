import java.util.ArrayList;
import java.util.List;

public class Problem118 {

    public List<List<Integer>> generate(int numRows) {

        List<List<Integer>> result = new ArrayList<>();

        List<Integer> firstRow = new ArrayList<>();
        firstRow.add(1);
        result.add(firstRow);

        for (int i = 1 ; i < numRows ; i++) {
            List<Integer> row = new ArrayList<>();
            row.add(1);

            while(row.size() <i) {


                row.add(result.get(i-1).get(row.size()-1)+result.get(i-1).get(row.size()));
            }

            row.add(1);

            result.add(row);
        }


        return result;
    }

    public static void main(String[] args) {
        new Problem118().generate(5);
    }
}
