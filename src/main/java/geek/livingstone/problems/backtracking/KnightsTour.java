package geek.livingstone.problems.backtracking;

/**
 * Full problem at http://www.geeksforgeeks.org/backtracking-set-1-the-knights-tour-problem/
 * 
 * @author emmanuel
 * 
 */
public class KnightsTour {
  
  public static void visit() {
    int[][] board = new int[8][8];
    for (int i=0;i<8;i++)
      for (int j=0;j<8;j++)
        board[i][j] = -1;
    int[] xMoves = {-2, -2, -1, -1,  1,  1,  2,  2};
    int[] yMoves = {-1,  1, -2,  2, -2,  2, -1,  1};
    board[0][0] = 0;
    if (visitUtil(board, 0, 0, 1, xMoves, yMoves))
      printSolution(board);
    else
      System.out.println("No solution exists");
  }

  private static void printSolution(int[][] board) {
    for (int i=0;i<8;i++) {
      for (int j=0;j<8;j++)
        System.out.print(String.format("%2d ", board[i][j]));
      System.out.println();
    }
  }

  private static boolean visitUtil(int[][] board, int x, int y, int movei, int[] xMoves, int[] yMoves) {
    if (movei == 64)
      return true;
    int next_x, next_y;
    for (int i=0;i<8;i++) {
      next_x = x + xMoves[i];
      next_y = y + yMoves[i];
      if (isSafe(board, next_x, next_y))
      {
        board[next_x][next_y] = movei;
        if (visitUtil(board, next_x, next_y, movei + 1, xMoves, yMoves))
          return true;
        board[next_x][next_y] = -1;
      }
    }
    return false;
  }

  private static boolean isSafe(int[][] board, int x, int y) {
    return x >= 0 && y>=0 && x<8 && y<8 && board[x][y] == -1;
  }

  public static void main(String[] args) {
    visit();
  }
}
