import java.lang.annotation.Target;
import java.util.ArrayList;

// A car travels from a starting position to a destination which is target miles east of the starting position.

// There are gas stations along the way. The gas stations are represented as an array stations where stations[i] = [positioni, fueli] indicates that the ith gas station is positioni miles east of the starting position and has fueli liters of gas.

// The car starts with an infinite tank of gas, which initially has startFuel liters of fuel in it. It uses one liter of gas per one mile that it drives. When the car reaches a gas station, it may stop and refuel, transferring all the gas from the station into the car.

// Return the minimum number of refueling stops the car must make in order to reach its destination. If it cannot reach the destination, return -1.

// Note that if the car reaches a gas station with 0 fuel left, the car can still refuel there. If the car reaches the destination with 0 fuel left, it is still considered to have arrived.

public class Solution {

    private int[][] stations;
    private int position;
    private int startFuel;
    private int target;

    public Solution(int[][] stations, int target, int startFuel) {
        this.stations = stations;
        this.startFuel = startFuel;
        this.target = target;
    }

    /*
     * return all the stations that are reachable from the current position with the current fuel
     */
    public ArrayList<ArrayList<Integer>> reachableStations(int[][] stations, int position, int fuel) {

        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();

        for (int i = 0; i < stations.length; i++) {
            if (stations[i][0] - position <= fuel) {
                ArrayList<Integer> station = new ArrayList<Integer>();
                station.add(stations[i][0]);
                station.add(stations[i][1]);

                result.add(station);
            }
        }
        return result;
    }

    public void refuel(int station){
        startFuel -= stations[station][0] - position;
        position = stations[station][0];
        this.startFuel = stations[station][1] + this.startFuel;
        System.out.println("Refuel at station "+station+" with "+stations[station][1]+" liters");
    }

    public int bestStation(int fuel) {
        int maxfuel = -1;
        int stationNum = -1;
        for (ArrayList<Integer> station : reachableStations(stations, position, fuel)) {
            int stationFuel = station.get(1);
            if (stationFuel > maxfuel) {
                maxfuel = stationFuel;
                stationNum = station.get(0);
            }
        }
        return stationNum;
    }

    public boolean canDriveToEnd(int fuel) {
        System.out.println("Can drive to end with "+fuel+" liters? "+((fuel >= target - position) ? "Yes" : "No"));
        return fuel >= target - position;
    }

    public int minRefuelStops(int target, int startFuel, int[][] stations) {

        int stops = 0;
        int position = 0;

        while (!canDriveToEnd(startFuel)) {

            if (canDriveToEnd(startFuel)) {
                return stops;
            }

            else {
                int bestStation = bestStation(startFuel);
                if (bestStation == -1) {
                    return -1;
                }
                refuel(bestStation);
                stops++;
            }


        }

        return stops;
    }
}