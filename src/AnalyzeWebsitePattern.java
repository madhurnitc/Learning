import java.util.*;

public class AnalyzeWebsitePattern {

    public List<String> mostVisitedPattern(String[] username, int[] timestamp, String[] website) {
        Map<String, List<Visit>> userVisits = new HashMap<>();
        for(int i = 0; i< username.length; i++) {
            userVisits.putIfAbsent(username[i], new ArrayList<>());
            userVisits.get(username[i]).add(new Visit(website[i], timestamp[i]));
        }

        Map<String, Integer> websitePatternCount = new HashMap<>();
        String resultPattern = "";
        for(Map.Entry<String, List<Visit>> entry : userVisits.entrySet() ) {
            List<Visit> visitByUser = entry.getValue();
            if(visitByUser.size()<3) {
                continue;
            }
            Collections.sort(visitByUser, (a,b) -> a.time- b.time);
            Set<String> uniqueVisitPattern = new HashSet<>();
            for(int i = 0; i< visitByUser.size(); i++) {
                for(int j = i+1; j <visitByUser.size(); j++) {
                    for(int k = j+1; k<visitByUser.size(); k++) {
                        StringBuilder sb = new StringBuilder();
                        sb.append(visitByUser.get(i).website).append(" ").append(visitByUser.get(j).website).append(" ").append(visitByUser.get(k).website);
                        String currentPattern = sb.toString();
                        if(!uniqueVisitPattern.contains(currentPattern)) {
                            uniqueVisitPattern.add(currentPattern);
                            websitePatternCount.put(currentPattern, websitePatternCount.getOrDefault(currentPattern, 0)+1);
                        }
                        if(resultPattern.isEmpty()
                                || websitePatternCount.get(resultPattern) < websitePatternCount.get(currentPattern)
                        ||( websitePatternCount.get(resultPattern) == websitePatternCount.get(currentPattern) && resultPattern.compareTo(currentPattern) > 0)) {
                            resultPattern = currentPattern;
                        }
                    }
                }
            }

        }
        return Arrays.asList(resultPattern.split(" "));
    }


    public class Visit {

        String website;
        int time;

        public Visit(String website, int time) {
            this.time = time;
            this.website = website;
        }
    }

    public static void main(String[] args) {
        String[] users  = {"pdtkrjhd","pdtkrjhd","pdtkrjhd","pdtkrjhd","pdtkrjhd","pdtkrjhd"};
        int[] times = {210984153,262799291,958396687,605779010,373702273,205190519};
        String[] webs = {"xgriygexlk","qs","rugydl","bkrok","canlv","cahgsobjjs"};
        new AnalyzeWebsitePattern().mostVisitedPattern(users, times, webs);

    }
}
