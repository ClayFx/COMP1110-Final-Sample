package comp1110.exam;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * COMP1110 Final Exam, Question 1ii
 *
 * Discover all victims (reachable white pieces), given a the initial board
 * and a black knight placed at a particular start position.  The initial board
 * may contain black and/or white pieces in addition to the black knight.
 *
 * A black knight may tour an 8 x 8 chess board according to the following
 * rules:
 *   1. It may move from its current square to any of the eight nearby squares
 *      reachable by either: moving sideways two and vertically one; or vertically
 *      two and sideways one.  Given the board below, a piece at '*' may move to
 *      any of the positions marked with an 'X'.
 *
 *       . X . X .
 *       X . . . X
 *       . . * . .
 *       X . . . X
 *       . X . X .
 *
 *   2. It may not move to a square off the 8 x 8 board
 *
 *   3. It may not move to a square already occupied by another piece
 *
 * The number of 'victims' of the black knight is equal to all of the
 * white pieces that it could ever have reached on a tour according to the
 * above rules for touring the board.
 */
public class Q1Tour {
    enum Piece { black, white }
    Piece[][] pieces = new Piece[8][8];

    /**
     * Construct a new instance with a particular placement
     * @param placement
     */
    Q1Tour(String placement) {
        populateBoard(placement);
    }


    /**
     * Take a placement string and populate the board
     * @param placement A string describing placement of black and white pieces
     */
    private void populateBoard(String placement) {
        for(int i = 0; i < placement.length(); i+=3) {
            String piece = placement.substring(i,i+3);
            int col = (piece.charAt(1)-'A');
            int row = (piece.charAt(2)-'1');
            this.pieces[col][row] = (piece.charAt(0) == 'B') ? Piece.black : Piece.white;
        }
    }

    /**
     * Find the number of victims for a black knight's tour, starting at a specific
     * position (according to the rules described above).
     *
     * @param start  The starting point for the black knight is described as a two letter
     *               string, the column ('A'-'H')followed by the row ('1'-'8').
     * @return The number of white pieces reachable by a knight's tour from the
     * starting point (according to the rules above).
     */
    public int tourVictims(String start) {
        // FIXME Question 1iii: complete this function
        int count = 0;
        int col = (start.charAt(0)-'A');
        int row = (start.charAt(1)-'1');
        int[] knight = new int[]{col,row};
        ArrayList<int[]> white = new ArrayList<>();
        ArrayList<int[]> black = new ArrayList<>();
        for (int x = 0; x <= 7; x = x + 1) {
            for (int y = 0 ; y <= 7; y = y + 1) {
                if (this.pieces[x][y] == Piece.black) {
                    int[] blackOne = new int[]{x,y};
                    black.add(blackOne);
                } else if (this.pieces[x][y] == Piece.white) {
                    int[] whiteOne = new int[]{x,y};
                    white.add(whiteOne);
                }
            }
        }
        ArrayList<int[]> togo = new ArrayList<>();
        togo.add(knight);
        int[] horizontal = new int[] {-1,1,2,2,1,-1,-2,-2};
        int[] vertical = new int[] {-2,-2,-1,1,2,2,1,-1};
        ArrayList<int[]> alreadygot = new ArrayList<>();
        ArrayList<int[]> alreadyGone = new ArrayList<>();
        while (togo.size() > 0) {
            if (count == white.size()) break;
            for (int i = 0; i < horizontal.length; i++) {
                int newx = togo.get(0)[0] + horizontal[i];
                int newy = togo.get(0)[1] + vertical[i];
                if (newx >= 0 && newx <= 7 && newy <= 7 && newy >= 0
                        && this.pieces[newx][newy] != Piece.black) {
                    int[] ywu = {newx, newy};
                    if (contains(white,ywu)) {
                        if (!contains(alreadygot,ywu)) {
                            count = count + 1;
                            alreadygot.add(ywu);
                            if (!contains(alreadyGone,ywu)) {
                                togo.add(ywu);
                            }
                        }
                    }
                    else if (!contains(togo,ywu)) {
                        if (!contains(alreadyGone,ywu))
                            togo.add(ywu);
                    }
                }
            }
            alreadyGone.add(togo.get(0));
            togo.remove(0);
        }
        return count;
    }
    public boolean canReach (int[] poi) {
        int[] horizontal = new int[] {-1,1,2,2,1,-1,-2,-2};
        int[] vertical = new int[] {-2,-2,-1,1,2,2,1,-1};
        ArrayList<int[]> theReach = new ArrayList<>();
        for (int i = 0; i < horizontal.length ; i++) {
            int newx = poi[0] + horizontal[i];
            int newy = poi[1] + vertical[i];
            if (newx >= 0 && newx <= 7 && newy <= 7
                    && newy >= 0 && this.pieces[newx][newy] != Piece.black) {
                int[] ywu = {newx,newy};
                theReach.add(ywu);
            }
        }
        if (theReach.size() > 0) {
            return true;
        }
        return false;
    }
    public boolean contains (ArrayList<int[]> a,int[] b) {
        for (int[] element:a) {
            if (element[0] == b[0] && element[1] == b[1]) {
                return true;
            }
        }
        return false;
    }

}

//    private ArrayList<int[]> theReacha = new ArrayList<>();
//    private boolean already = false;
//    private int forstack = 0;
//    public void allReachable (int[] poi, int[] knight) {
//        this.theReacha.clear();
//        this.already = false;
//        int[] horizontal = new int[] {-1,1,2,2,1,-1,-2,-2};
//        int[] vertical = new int[] {-2,-2,-1,1,2,2,1,-1};
//        ArrayList<int[]> theReach = new ArrayList<>();
//        for (int i = 0; i < horizontal.length ; i++) {
//            int newx = poi[0] + horizontal[i];
//            int newy = poi[1] + vertical[i];
//            if (newx >= 0 && newx <= 7 && newy <= 7
//                    && newy >= 0 && this.pieces[newx][newy] != Piece.black) {
//                int[] ywu = {newx,newy};
//                if (ywu == knight) {
//                    this.already = true;
//                    return;
//                }
//                if (!theReacha.contains(ywu)) {
//                    this.theReacha.add(ywu);
//                    theReach.add(ywu);
//                }
//            }
//        }
//
//        if (theReach.size() != 0) {
//            if (this.forstack < 3) {
//                for (int[] element : theReach) {
//                    allReachable (element,knight);
//                }
//                this.forstack += 1;
//            }
//        }
//    }
//}