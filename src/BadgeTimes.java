/*
We are working on a security system for a badged-access room in our company's building.

We want to find employees who badged into our secured room unusually often.
We have an unordered list of names and entry times over a single day.
Access times are given as numbers up to four digits in length using 24-hour time, such as "800" or "2250".

Write a function that finds anyone who badged into the room three or more times in a one-hour period.
Your function should return each of the employees who fit that criteria, plus the times that they badged in during the one-hour period.
If there are multiple one-hour periods where this was true for an employee, just return the earliest one for that employee.

badge_times = [
  ["Paul",      "1355"], ["Jennifer",  "1910"], ["Jose",    "835"],
  ["Jose",       "830"], ["Paul",      "1315"], ["Chloe",     "0"],
  ["Chloe",     "1910"], ["Jose",      "1615"], ["Jose",   "1640"],
  ["Paul",      "1405"], ["Jose",       "855"], ["Jose",    "930"],
  ["Jose",       "915"], ["Jose",       "730"], ["Jose",    "940"],
  ["Jennifer",  "1335"], ["Jennifer",   "730"], ["Jose",   "1630"],
  ["Jennifer",     "5"], ["Chloe",     "1909"], ["Zhang",     "1"],
  ["Zhang",       "10"], ["Zhang",      "109"], ["Zhang",   "110"],
  ["Amos",         "1"], ["Amos",         "2"], ["Amos",    "400"],
  ["Amos",       "500"], ["Amos",       "503"], ["Amos",    "504"],
  ["Amos",       "601"], ["Amos",       "602"], ["Paul",   "1416"]
];

Expected output (in any order)
   Paul: 1315 1355 1405
   Jose: 830 835 855 915 930
   Zhang: 10 109 110
   Amos: 500 503 504

n: length of the badge records array
*/

import java.io.*;
import java.util.*;

public class BadgeTimes {

    public static void main(String[] argv) {
        String[][] badgeTimes = new String[][] {
                {"Paul", "1355"},
                {"Jennifer", "1910"},
                {"Jose", "835"},
                {"Jose", "830"},
                {"Paul", "1315"},
                {"Chloe", "0"},
                {"Chloe", "1910"},
                {"Jose", "1615"},
                {"Jose", "1640"},
                {"Paul", "1405"},
                {"Jose", "855"},
                {"Jose", "930"},
                {"Jose", "915"},
                {"Jose", "730"},
                {"Jose", "940"},
                {"Jennifer", "1335"},
                {"Jennifer", "730"},
                {"Jose", "1630"},
                {"Jennifer", "5"},
                {"Chloe", "1909"},
                {"Zhang", "1"},
                {"Zhang", "10"},
                {"Zhang", "109"},
                {"Zhang", "110"},
                {"Amos", "1"},
                {"Amos", "2"},
                {"Amos", "400"},
                {"Amos", "500"},
                {"Amos", "503"},
                {"Amos", "504"},
                {"Amos", "601"},
                {"Amos", "602"},
                {"Paul", "1416"},
        };

        new BadgeTimes().findPersonWithMoreThan3Entries(badgeTimes);

    }

    public List<EntryRecord> findPersonWithMoreThan3Entries(String[][] badgeTimes) {

        Map<String, List<Integer>> personToEntryMap = new HashMap<>();
        List<EntryRecord> finalResult= new ArrayList<>();

        for(String[] badgeTime : badgeTimes) {

            String personName = badgeTime[0];
            String entryTime = badgeTime[1];
            if(!personToEntryMap.containsKey(personName)) {

                personToEntryMap.put(personName, new ArrayList<>());
            }

            personToEntryMap.get(personName).add(Integer.valueOf(entryTime));
        }

        for(Map.Entry<String, List<Integer> >entry : personToEntryMap.entrySet()){

            List<Integer> entries = entry.getValue();

            if(entries.size() <3) {
                continue;
            }
            Collections.sort(entries);
            System.out.println(entry.getKey());
            entries.stream().forEach( e -> {

                System.out.println(e);
            });
            List<Integer> vEntries = findVoilationEntries(entries);
            EntryRecord er = new EntryRecord();
            er.personName = entry.getKey();
            er.entries = vEntries;
            finalResult.add(er);

        }
        return  finalResult;

    }

    private List<Integer> findVoilationEntries(List<Integer> entries) {
        List<Integer> result = new ArrayList<>();
        int right = 0;
        int left = 0 ;
        for(; right< entries.size(); right++) {
            while(entries.get(right)-entries.get(left)>100) {
                left++;
            }
            if(right-left>=2) {
                while(right < entries.size() && entries.get(right) - entries.get(left) <= 100) right ++;
                for(int i = left ; i<right; i++) {
                    result.add(entries.get(i));
                }
            }
        }


        return result;
    }

    public class EntryRecord {
        String personName;
        List<Integer> entries;
    }



}
