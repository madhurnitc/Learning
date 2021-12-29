import java.util.Arrays;
import java.util.Comparator;

public class ReorderLogs {

    public String[] reorderLogFiles(String[] logs) {

        Arrays.sort(logs, (o1, o2) -> {
            String[] splittedStr1 = o1.split(" ", 2);
            String[] splittedStr2 = o2.split(" ", 2);
            boolean isLetterLog1 = Character.isLetter(splittedStr1[0].charAt(0));
            boolean isLetterLog2 = Character.isLetter(splittedStr2[0].charAt(0));

            if(isLetterLog1 && isLetterLog2) {
                int compare = splittedStr1[1].compareTo(splittedStr2[1]);
                if(compare == 0) {
                    return splittedStr1[0].compareTo(splittedStr2[0]);
                }
                return compare;
            }else {

                if(isLetterLog1) {
                    return -1;
                }
                if(isLetterLog2) {
                    return 1;
                }else {
                    return 0;
                }
            }
        });

        return logs;
    }
}
