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
        landmarks[landmarks.length-1][0] = finalSquare;
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
        int numLandmarks = arr1.length + arr2.length + 1;
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

        arr3[arr3.length - 1][0] = Integer.MAX_VALUE;

        // Sorts the new array based off the first value of each array.
        // I got this line from stack overflow.
        // This is the link: https://stackoverflow.com/questions/15452429/java-arrays-sort-2d-array
        Arrays.sort(arr3, (a, b) -> Double.compare(a[0], b[0]));

        return arr3;
    }

    // Returns
    public static int[] takeLandmark(int location, int landmark, int[][] landmarks, ArrayList<Integer> visited, int steps) {
        if(visited.contains(landmarks[landmark][1]))
            return new int[0];
        for (int i = location; i < landmarks[landmark][0]; i++) {
            visited.add(i);
        }
        if (landmarks[landmark][0] < landmarks[landmark][1]) {
            ArrayList<Integer> landmarksBetween = findLandmarksBetween(landmark, landmarks);
            if (landmarksBetween == null || landmarksBetween.isEmpty()) {
                return true;
            }
            else {
                min
                for (int i = 0; i < landmarksBetween.size(); i++) {

                }
            }
        }
    }

    public static ArrayList<Integer> findPath(int location, int[][] landmarks, ArrayList<Integer> visited) {
        if (visited.contains(location)) {
            return null;
        }
        if (location == landmarks.length - 1) {
            return findPath
        }
    }

    public static ArrayList<Integer> findLandmarksBetween(int landmark, int[][] landmarks) {
        if (landmark == landmarks.length - 1) {
            return null;
        }

        ArrayList<Integer> landmarksBetween = new ArrayList<>();
        int i = landmark + 1;
        int end = landmarks[landmark][1];

        while (landmarks[i][0] <= end) {
            if (i == landmarks.length - 1) {
                break;
            }
            if (landmarks[i][0] < end) {
                landmarksBetween.add(i);
            }
        }

        return landmarksBetween;
    }

}
