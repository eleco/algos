package medium;

public class Celebrity {


    /*
    At a party, there is a single person who everyone knows, but who does not know anyone in return
     (the "celebrity").
     To help figure out who this is, you have access to an O(1) method called knows(a, b),
     which returns True if person a knows person b, else False.
     */


    //Start Pre-definites
    // Max # of persons in the party
    static final int N = 4;

    // Person with 2 is celebrity
    static int MATRIX[][] = {
            { 0, 0, 1, 0 },
            { 0, 0, 1, 0 },
            { 0, 0, 0, 0 },
            { 0, 0, 1, 0 } };

    static boolean knows(int a, int b) { return MATRIX[a][b]==1; }
    //End Pre-definites


    public static void main(String[] args) {
        System.out.println(findCelebrity(N));
    }

    static int findCelebrity(int n) {

        int [] indegrees = new int [N];
        int [] outdegrees = new int [N];

        for (int i=0;i<N;i++) {
            for (int j=0;j<N;j++) {

                if (knows(i,j)) {
                    indegrees[j]++;
                    outdegrees[i]++;
                }
            }
        }

        for (int i=0;i<N;i++) {
            if (indegrees[i]==N-1 && outdegrees[i]==0) return i;

        }

        return -1;
    }
}
