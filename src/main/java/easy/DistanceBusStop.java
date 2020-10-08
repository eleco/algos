package easy;

public class DistanceBusStop {

    /*
     A bus has n stops numbered from 0 to n - 1 that form a circle. We know the distance between all pairs of neighboring stops where distance[i] is the distance between the stops number i and (i + 1) % n.

     The bus goes along both directions i.e. clockwise and counterclockwise.

     Return the shortest distance between the given start and destination stops.
     */

    public static void main(String args[]) {
        System.out.println(distanceBetweenBusStops(new int[]{1, 2, 3, 4}, 0, 1));
    }

    public static int distanceBetweenBusStops(int[] distance, int start, int destination) {

        int d1 = 0;
        for (int i = start; i != destination; i = (i + 1) % distance.length) {
            d1 += distance[i];
        }

        int d2 = 0;
        for (int i = destination; i != start; i = (i + 1) % distance.length) {

            d2 += distance[i];
        }
        return Math.min(d1, d2);

    }
}

