public class SlowestKey {


    public char slowestKey(int[] releaseTimes, String keysPressed) {

        int[] duration = new int[26];
        int longestDuration = releaseTimes[0];
        char longestChar = keysPressed.charAt(0);
        for(int i =1 ; i< keysPressed.length(); i++){

            int pressDuration = releaseTimes[i]=releaseTimes[i-1];
            char curChar = keysPressed.charAt(i);

            if(pressDuration >= longestDuration) {

                if(pressDuration == longestDuration) {
                    int comp = Character.compare(curChar, longestChar);
                    if(comp <0){
                        longestChar = curChar;
                    }
                }else {
                    longestDuration = pressDuration;
                    longestChar = curChar;
                }
            }


        }

        return longestChar;
    }
}
