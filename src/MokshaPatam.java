import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;

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
        ArrayList<Integer> spaces = new ArrayList<>();
        int location = 0;
        int finalSpace = boardsize * boardsize;
        int[] landmarks = makeArray(snakes, ladders);

        while (location != finalSpace)

    }



    public static ArrayList<Integer> breadthFirstSearch(int location, ArrayList<Integer> visited, Queue<Integer> toVisit, int[] landmarks) {
        if (visited.contains(location)) {
            return null;
        }
        visited.add(location);
        for (int i = 0; i < 6; i++) {

        }
    }

    public static int[] makeArray(int[][] arr1, int[][] arr2) {
        int[] arr3 = new int[arr1.length + arr2.length];
        for (int[] value : arr1) {
            arr3[value[0]] = value[1];
        }
        for (int[] ints : arr2) {
            arr3[ints[0]] = ints[1];
        }
        return arr3;
    }
}
