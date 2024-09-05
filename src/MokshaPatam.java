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
        int location = 0;
        int finalSpace = boardsize - 1;
        int[] landmarks = makeArray(snakes, ladders, boardsize);
        landmarks[finalSpace - 1] = finalSpace;
        ArrayList<Integer> visited = new ArrayList<>();
        Queue<Integer> toVisit = new LinkedList<>();
        int[] pathTaken = new int[finalSpace + 1];
        System.out.println(Arrays.toString(landmarks));
        while (location != finalSpace) {
            if (location >= 93) {
                pathTaken[finalSpace] = location;
                location = finalSpace;
                break;
            }
            for (int i = location + 1; i < location + 7; i++) {
                if (visited.contains(i)) {
                    continue;
                }
                if (landmarks[i] != 0) {
                    if (!visited.contains(landmarks[i])) {
                        toVisit.add(landmarks[i]);
                        visited.add(landmarks[i]);
                        pathTaken[landmarks[i]] = location;
                    }
                    visited.add(i);
                }
                else {
                    toVisit.add(i);
                    visited.add(i);
                    pathTaken[i] = location;
                }
            }
            if (toVisit.isEmpty()) {
                return -1;
            }
            location = toVisit.poll();
        }

        ArrayList<Integer> path = new ArrayList<>();
        while (location != 0) {
            path.add(location);
            location = pathTaken[location];
        }
        System.out.println(path);
        System.out.println(Arrays.deepToString(ladders));
        System.out.println(Arrays.deepToString(snakes));
        System.out.println("--------------------------------------------------------");
        return path.size();
    }



//    public static ArrayList<Integer> breadthFirstSearch(int location, ArrayList<Integer> visited, Queue<Integer> toVisit, int[] landmarks) {
//        if (visited.contains(location)) {
//            return null;
//        }
//        if (landmarks[location] == location && location != 0) {
//            return new ArrayList<>();
//        }
//        visited.add(location);
//        for (int i = 0; i < 6; i++) {
//            if (landmarks[location + i] != 0) {
//                toVisit.add(landmarks[location + 1]);
//            }
//            else {
//                toVisit.add(location + 1);
//            }
//        }
//    }

//    public static ArrayList<Integer> bfs(int location, int parent, ArrayList<Integer> visited, Queue<Integer> toVisit, int[] landmarks) {
//        if (visited.contains(location)) {
//            return null;
//        }
//        if (landmarks[location] == location && location != 0) {
//            return new ArrayList<>();
//        }
//        for (int i = 0; i < 6; i++) {
//            if (visited.contains(location + i)) {
//                continue;
//            }
//            if (landmarks[location + i] != 0) {
//                toVisit.add(landmarks[location + i]);
//                visited.add(location + i);
//            }
//            else {
//                toVisit.add(location + i);
//                visited.add(location + 1);
//            }
//        }
//        bfs()
//    }

    public static int[] makeArray(int[][] arr1, int[][] arr2, int boardsize) {
        int[] arr3 = new int[boardsize];
        for (int[] value : arr1) {
            arr3[value[0] - 1] = value[1] - 1;
        }
        for (int[] ints : arr2) {
            arr3[ints[0] - 1] = ints[1] - 1;
        }
        return arr3;
    }
}
