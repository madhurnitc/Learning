public class UnHappyFriends {


    public int unhappyFriends(int n, int[][] preferences, int[][] pairs) {

        int count = 0;
        for(int[] pair : pairs) {

            int u = pair[0];
            int v = pair[1];

            if(checkIfUnHappy(u,v, preferences)){

                count++;
            }

        }

        return count;
    }

    private boolean checkIfUnHappy(int u, int v , int[][] preferences) {
        int[] uprefList = preferences[u];
        int[] vprefList = preferences[v];
        int vindex = getPrefIndex(uprefList, v);
        int uindex = getPrefIndex(vprefList, u);
        if(vindex > 0 && uindex >0){
            return true;
        }

        return false;
    }

    private int getPrefIndex(int[] prefList, int v) {
        int i =0;
        for(int pref : prefList){
            if(pref == v) {
                return i;
            }

            i++;
        }

        return -1;
    }

    public static void main(String[] args) {
        int[][] prefs = {{1,2,3},{3,2,0},{3,1,0},{1,2,0}};
        int[][] pair = {{0,1},{2,3}};

        System.out.println(new UnHappyFriends().unhappyFriends(4, prefs, pair));
    }


}
