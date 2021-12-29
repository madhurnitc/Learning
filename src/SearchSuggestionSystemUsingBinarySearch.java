import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SearchSuggestionSystemUsingBinarySearch {

    public List<List<String>> suggestedProducts(String[] products, String searchWord) {

        Arrays.sort(products);
        List<List<String>> result = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        int startIndex = 0;
        for(int i = 0; i <searchWord.length(); i++) {
            String prefix = sb.append(searchWord.charAt(i)).toString();
            int lowerIndex = findFirstOccurenceOfPrefix(products, prefix, startIndex);
            startIndex = lowerIndex;
            result.add(new ArrayList<>());
            int count = 0;
            while(count < 3 && lowerIndex < products.length) {

                if( prefix.length() > products[lowerIndex].length() || products[lowerIndex].indexOf(prefix) <0) {
                    break;
                }
                result.get(result.size()-1).add(products[lowerIndex]);
                lowerIndex ++;
                count++;
            }
            ;
        }

        return result;
    }

    private int findFirstOccurenceOfPrefix(String[] products, String searchWord, int startIndex) {
        int lo = startIndex;
        int hi = products.length-1;
        while (lo <hi) {

            int mid = lo + (hi-lo)/2;
            if(searchWord.compareTo(products[mid]) <=0) {
                hi = mid;
            }else {
                lo = mid+1;
            }
        }

        return lo;
    }

    public static void main(String[] args) {
        String[] products = {"mobile","mouse","moneypot","monitor","mousepad"};
        new SearchSuggestionSystemUsingBinarySearch().suggestedProducts(products, "mouse");
    }
}
