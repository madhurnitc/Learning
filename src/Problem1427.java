public class Problem1427 {

    public String stringShift(String s, int[][] shift) {

        StringBuilder sb = new StringBuilder(s);
        for(int i  =0 ; i <shift.length; i++) {
            int dir = shift[i][0];
            int amount = shift[i][1]%s.length();
            String head, tail;
            if(dir == 0) {
                head = sb.substring(amount);
                tail = sb.substring(0, amount);
            }else {
                head = sb.substring(sb.length()-amount);
                tail = sb.substring(0, sb.length()-amount);
            }
            sb = new StringBuilder();
            sb.append(head).append(tail);

        }
        return sb.toString();
    }

    public static void main(String[] args) {
        int[][] shift = {
            {1,1},
            {1,1,},
            {0,2},
            {1,3}
        };
        String s ="abcdefg";
        System.out.println(new Problem1427().stringShift(s, shift));
    }
}
