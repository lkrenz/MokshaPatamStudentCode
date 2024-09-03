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
        landmarks[landmarks.length-1][0] = finalSquare;
        ArrayList<Integer> visited = new ArrayList<>();

        ArrayList<Integer> shortestDistance = findPath(0, landmarks, visited);

        return (shortestDistance.getFirst() / 6) + 1;
    }

    public ArrayList<Integer> findNextMove(int square) {
        return null;
    }

    // Method to combine and sort two 2D integer arrays based off the first index in each array.
    public static int[][] combineArrays(int[][] arr1, int[][] arr2) {
        int numLandmarks = arr1.length + arr2.length;
        int[][] arr3 = new int[numLandmarks + 2][2];

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

    // First index is return array is the length of the path.
    public static ArrayList<Integer> findPath(int location, int[][] landmarks, ArrayList<Integer> visited) {
        if (visited.contains(location)) {
            return null;
        }
        if (location == landmarks.length - 1) {
            ArrayList<Integer> solution = new ArrayList<>();
            solution.add(location);
            solution.addFirst(0);
            return solution;
        }
        visited.add(location);

        // Case if next landmark is a ladder.
        ArrayList<Integer> shortestDistance = new ArrayList<>();
        if (landmarks[location][0] < landmarks[location][1]) {
            ArrayList<Integer> landmarksBetween = findLandmarksBetween(location, landmarks, true);
            ArrayList<Integer>[] paths = new ArrayList[landmarksBetween.size()];
            for (int i = 0; i < paths.length; i++) {
                paths[i] = findPath(landmarksBetween.get(i), landmarks, visited);
                if (paths[i] != null) {
                    paths[i].set(0, paths[i].getFirst() + landmarks[landmarksBetween.get(i)][0] - landmarks[location][0]);
                }

            }
            int shortest = 0;
            for (int i = 0; i < paths.length; i++) {
                if (paths[i] != null) {
                    if (paths[shortest].get(0) > paths[i].get(0)) {
                        shortest = i;
                    }
                }
            }
            shortestDistance = paths[shortest];
        } // Case if next landmark is a snake
        else if (landmarks[location][0] > landmarks[location][1]) {
            ArrayList<Integer> landmarksBetween = findLandmarksBetween(location, landmarks, false);
            ArrayList<Integer>[] paths = new ArrayList[landmarksBetween.size()];
            for (int i = 0; i < paths.length; i++) {
                paths[i] = findPath(landmarksBetween.get(i), landmarks, visited);
                if (paths[i] != null) {
                    paths[i].set(0, paths[i].getFirst() + landmarks[landmarksBetween.get(i)][0] - landmarks[location][0]);
                }

            }
            int shortest = 0;
            for (int i = 0; i < paths.length; i++) {
                if (paths[i] != null) {
                    if (paths[shortest].get(0) > paths[i].get(0)) {
                        shortest = i;
                    }
                }
            }
            shortestDistance = paths[shortest];
        }

        // Case where next landmark is skipped.
        ArrayList<Integer> solution = findPath(location+1, landmarks, visited);
        solution.set(0, solution.getFirst() + landmarks[location+1][0] - landmarks[location][0]);
        visited.remove((Integer) location);
        if (solution.get(0) < shortestDistance.get(0)) {
            return solution;
        }
        return shortestDistance;
    }

    public static ArrayList<Integer> findLandmarksBetween(int landmark, int[][] landmarks, boolean ladder) {
        if (landmark == landmarks.length - 1) {
            return null;
        }
        int i = 0;
        int end = 0;
        if (ladder) {
            i = landmark + 1;
            end = landmarks[landmark][1];
        }
        else {
            int endSnake = landmarks[landmark][1];
            while (i < landmarks.length) {
                if (landmarks[i][0] > endSnake) {
                    break;
                }
                i++;
            }
            end = landmarks[landmarks.length - 1][0];
        }

        ArrayList<Integer> landmarksBetween = new ArrayList<>();

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
