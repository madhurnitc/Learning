import javafx.util.Pair;

import java.util.HashMap;

class UndergroundSystem {

    HashMap<Integer, Trip> checkinMap;
    HashMap<String, Pair<Integer, Integer>> checkoutMap;

    public UndergroundSystem() {

        checkinMap = new HashMap<>();
        checkoutMap = new HashMap<>();
    }

    public void checkIn(int id, String stationName, int t) {
        checkinMap.put(id, new Trip(stationName,t));

    }

    public void checkOut(int id, String stationName, int t) {
        Trip trip =  checkinMap.get(id);
        String route = trip.startStation + "_" + stationName;
        int duration = t-trip.time;
        Pair<Integer, Integer> counter = checkoutMap.getOrDefault(route, new Pair<>(0,0));
        checkoutMap.put(route, new Pair<>(counter.getKey()+1, counter.getValue()+duration ));
    }

    public double getAverageTime(String startStation, String endStation) {

        Pair<Integer, Integer> stats = checkoutMap.get(startStation + "_" + endStation);
        int totalTime = stats.getValue();
        int totalTrip = stats.getKey();

        return totalTime/(double) totalTrip;


    }

    public class Trip {

        String startStation;
        int time;
        public Trip(String s, int t) {
            startStation = s;
            time = t;
        }


    }
}