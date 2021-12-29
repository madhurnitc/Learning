import java.util.HashMap;
import java.util.Map;

public class LongestOverlappingSubArray {
    public int findLength(int[] A, int[] B) {
        int result = 0;
        for (int i = 0; i < A.length + B.length - 1; ++i) {
            // The current overlapping window is A[aStart, Math.min(A.length, B.length)] and B[bStart, Math.min(A.length, B.length)].
            int aStart = Math.max(0, A.length - 1 - i);
            int bStart = Math.max(0, i - (A.length - 1));
            int numConsecutiveMatches = 0;
            for (int aIdx = aStart, bIdx = bStart; aIdx < A.length && bIdx < B.length; ++aIdx, ++bIdx) {
                // Maintain number of equal consecutive elements in the current window (overlap) and the max number ever computed.
                numConsecutiveMatches = A[aIdx] == B[bIdx] ? numConsecutiveMatches + 1 : 0;
                result = Math.max(result, numConsecutiveMatches);
            }
        }
        return result;
    }

    public int maxNumberOfBalloons(String text) {
        Map<Character, Integer> counts = new HashMap<>();

        for(char c : text.toCharArray()) {

            if(c == 'b' || c == 'a' || c == 'l' || c == 'o' || c == 'n') {
               counts.put(c, counts.getOrDefault(c,0)+1);
            }
        }
        int result = Integer.MAX_VALUE;
        for(Map.Entry<Character, Integer> entry : counts.entrySet()) {

            char c = entry.getKey();
            int count = entry.getValue();
            int availability =0;
            if(c == 'l' || c == 'o') {
                count = count/2;
            }
            result = Math.min(result, count);

        }

        return result;
    }

    public static void main(String[] args) {
        int[] a = {1,2,3,2,1};
        int[] b = {3,2,1,4,7};
        System.out.println(new LongestOverlappingSubArray().findLength(a, b));
    }

}
