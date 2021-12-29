import java.util.Arrays;

public class Problem1366 {
    public String rankTeams(String[] votes) {
        Team[] teams =  new Team[26];
        int n = votes[0].length();
        for(String vote  : votes) {
            for(int i = 0 ; i< vote.length(); i++) {
                char letter = vote.charAt(i);
                if(teams[letter-'A'] == null) {
                    teams[letter-'A'] = new Team(letter);
                }
                teams[letter-'A'].votes[i]++;
            }
        }
        Character[] temp = new Character[n];
        char[] ans = votes[0].toCharArray();
        for (int i = 0; i < n; i++) {
            temp[i] = ans[i];
        }

        Arrays.sort(temp, (t1,t2) -> {
           for(int i  =0 ; i< n ; i++){
               if(teams[t1-'A'].votes[i] != teams[t2-'A'].votes[i]) {
                   return teams[t2-'A'].votes[i] - teams[t1-'A'].votes[i];
               }
           }
            return t1-t2;
        });
        StringBuilder sb = new StringBuilder();
        for(int i =0 ;i<n; i++) {
            sb.append(temp[i]);
        }
        return sb.toString();
    }

    public class Team {
        char letter;
        int[] votes = new int[26];
        public Team(char letter) {
            this.letter = letter;
        }
    }

    public static void main(String[] args) {
        String[] votes = {"BCA","CAB","CBA","ABC","ACB","BAC"};
        Problem1366 obj = new Problem1366();
        System.out.println(obj.rankTeams(votes));
    }
}
