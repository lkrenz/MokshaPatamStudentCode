import java.util.ArrayList;

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

        System.out.println(ladders);
        System.out.println(snakes);
        int finalSquare = boardsize * boardsize;
        int location = 0;

        int numLandmarks = ladders.length + snakes.length;
        int[][] landmarks = new int[numLandmarks][2];

        for (int i = 0; i < numLandmarks; i++) {

        }
        while (location != finalSquare) {

        }
        return 0;
    }

    public ArrayList<Integer> findNextMove(int square) {
        return null;
    }
}
