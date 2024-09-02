import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Moksha Patam
 * A puzzle created by Zach Blick
 * for Adventures in Algorithms
 * at Menlo School in Atherton, CA
 *
 * Completed by: [YOUR NAME HERE]
 *
 */

public class MokshaPatam {

    /**
     * TODO: Complete this function, fewestMoves(), to return the minimum number of moves
     *  to reach the final square on a board with the given size, ladders, and snakes.
     */
    public static int fewestMoves(int boardsize, int[][] ladders, int[][] snakes) {
        int finalSquare = boardsize * boardsize;
        int location = 0;
        int[][] landmarks = combineArrays(ladders, snakes);
        ArrayList<Integer> visited = new ArrayList<>();

        while (location != finalSquare) {

        }
        return 0;
    }

    public ArrayList<Integer> findNextMove(int square) {
        return null;
    }

    // Method to combine and sort two 2D integer arrays based off the first index in each array.
    public static int[][] combineArrays(int[][] arr1, int[][] arr2) {
        int numLandmarks = arr1.length + arr2.length;
        int[][] arr3 = new int[numLandmarks][2];

        // Combines the two arrays.
        for (int i = 0; i < arr1.length; i++) {
            arr3[i][0] = arr1[i][0];
            arr3[i][1] = arr1[i][1];
        }
        for (int i = arr1.length; i < numLandmarks; i++) {
            arr3[i][0] = arr2[i - arr1.length][0];
            arr3[i][1] = arr2[i - arr1.length][1];
        }

        // Sorts the new array based off the first value of each array.
        // I got this line from stack overflow.
        // This is the link: https://stackoverflow.com/questions/15452429/java-arrays-sort-2d-array
        Arrays.sort(arr3, (a, b) -> Double.compare(a[0], b[0]));

        return arr3;
    }

    // Returns true if taking a landmark leads to a more efficient path
    public static boolean takeLandmark(int location, int[] landmark, int[][] landmarks, ArrayList<Integer> visited) {
        if(visited.contains(landmark[1]))
            return false;
        for (int i = location; i < landmark[0]; i++) {
            visited.add(i);
        }
        if (landmark[0] < landmark[1]) {

        }
    }

    public static int[] findLandmarksBetween(int start, int end, int[][] landmarks) {
        ArrayList<Integer> landmarksBetween = new ArrayList<>();
        int landmarkIndex = landmarks.
        while (start <= end) {
            if ()
        }
    }
}
