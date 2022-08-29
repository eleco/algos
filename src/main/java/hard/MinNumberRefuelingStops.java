package hard;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MinNumberRefuelingStops {

    /*
    A car travels from a starting position to a destination which is target miles east of the
    starting position.

    There are gas stations along the way. The gas stations are represented as an array stations
    where stations[i] = [positioni, fueli] indicates that the ith gas station is positioni miles east
     of the starting position and has fueli liters of gas.

    The car starts with an infinite tank of gas, which initially has startFuel liters of fuel in it.
     It uses one liter of gas per one mile that it drives. When the car reaches a gas station,
     it may stop and refuel, transferring all the gas from the station into the car.

    Return the minimum number of refueling stops the car must make in order to reach its destination.
    If it cannot reach the destination, return -1.

    Note that if the car reaches a gas station with 0 fuel left, the car can still refuel there.
     If the car reaches the destination with 0 fuel left, it is still considered to have arrived.
     */
    public static void main(String[] args) {
        System.out.println(minRefuelStops(100,10,
                new int[][]{{10,60}, {20,30},{30,30},{60,40}}));
    }

    static int minRefuelStops(int target, int startFuel, int[][] stations) {

        Comparator comparator = new Comparator<Integer>() {
            public int compare(Integer e1, Integer e2) {
                return stations[e2][1] - stations[e1][1];
            }
        };

        PriorityQueue<Integer> pq = new PriorityQueue<>(comparator);

        int maxReach = startFuel;
        int station = 0;
        int stops = 0;
        while (maxReach < target) {
            while (station < stations.length && maxReach >= stations[station][0]) {
                pq.add(station);
                station++;
            }
            if (pq.isEmpty()) {
                return -1;
            }
            Integer refuelStation = pq.poll();
            stops++;
            maxReach += stations[refuelStation][1];
        }
        return stops;


    }
}
