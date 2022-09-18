public class Run {
    public static void main(String[] args) {

        int[][] stations = {{1, 1}, {2, 1}, {3, 1}, {10, 1}};
        int position = 0;
        int fuel = 10;
        Solution solution = new Solution(stations, 13, fuel);
        System.out.println(solution.reachableStations(stations, position, fuel));
        System.out.println("The best station is at mile "+solution.bestStation(fuel));
        System.out.println("The minimum number of refuel stops is "+solution.minRefuelStops(13, 10, stations));
    }
}