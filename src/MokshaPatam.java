import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
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
        int location = 1;
        int[] landmarks = makeArray(snakes, ladders, boardsize + 1);
        landmarks[boardsize - 1] = boardsize;
        int[] visited = new int[boardsize + 1];
        Queue<Integer> toVisit = new LinkedList<>();

        while (location != boardsize) {
            if (location >= boardsize - 6) {
                visited[boardsize] = location;
                location = boardsize;
                break;
            }

            for (int i = location + 1; i < location + 7; i++) {
                if (visited[i] != 0) {
                    continue;
                }
                if (landmarks[i] != 0) {
                    if (visited[landmarks[i]] == 0) {
                        toVisit.add(landmarks[i]);
                        visited[landmarks[i]] = location;
                    }
                    visited[i] = location;
                }
                else {
                    toVisit.add(i);
                    visited[i] = location;
                }
            }
            if (toVisit.isEmpty()) {
                return -1;
            }
            location = toVisit.poll();
        }

        ArrayList<Integer> path = new ArrayList<>();
        while (location != 1) {
            path.add(location);
            location = visited[location];
        }
        return path.size();
    }




    public static int[] makeArray(int[][] arr1, int[][] arr2, int boardsize) {
        int[] arr3 = new int[boardsize];
        for (int[] value : arr1) {
            arr3[value[0]] = value[1];
        }
        for (int[] ints : arr2) {
            arr3[ints[0]] = ints[1];
        }
        return arr3;
    }
}
