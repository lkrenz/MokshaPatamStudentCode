import java.util.LinkedList;
import java.util.Queue;

/**
 * Moksha Patam
 * A puzzle created by Zach Blick
 * for Adventures in Algorithms
 * at Menlo School in Atherton, CA
 *
 * Completed by: Liam Krenz
 *
 */

public class MokshaPatam {
    // Finds and returns fewest moves needed to complete a given board.
    public static int fewestMoves(int boardsize, int[][] ladders, int[][] snakes) {
        int location = 1;

        // Array to hold all snakes and ladders, allows for constant time lookups.
        int[] landmarks = makeArray(snakes, ladders, boardsize + 1);
        landmarks[boardsize - 1] = boardsize;

        // Stores previously visited spaces.
        // Allows for constant time lookups while looking for next move and adding up moves.
        int[] visited = new int[boardsize + 1];
        Queue<Integer> toVisit = new LinkedList<>();

        // While loop iterates through toVisit until final s
        while (location != boardsize) {
            if (location >= boardsize - 6) {
                visited[boardsize] = location;
                location = boardsize;
                break;
            }

            // Handles all viable roles from the current location.
            for (int i = location + 1; i < location + 7; i++) {
                if (visited[i] != 0) {
                    continue;
                }
                if (landmarks[i] != 0) {
                    // Adds end of snake / ladder to toVisit
                    if (visited[landmarks[i]] == 0) {
                        toVisit.add(landmarks[i]);
                        visited[landmarks[i]] = location;
                    }
                    // Adds beginning and end of snake to visited.
                    visited[i] = location;
                }
                else {
                    // Adds non landmark tiles.
                    toVisit.add(i);
                    visited[i] = location;
                }
            }

            // Returns -1 if no path exists.
            if (toVisit.isEmpty()) {
                return -1;
            }
            location = toVisit.poll();
        }

        // Finds moves needed to reach end square.
        int moves = 0;
        while (location != 1) {
            moves++;
            location = visited[location];
        }
        return moves;
    }

    // Merges the snake and ladder arrays into one array, allowing for constant time lookups.
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
