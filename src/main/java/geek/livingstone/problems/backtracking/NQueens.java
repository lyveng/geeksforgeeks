package geek.livingstone.problems.backtracking;

/**
 * Full problem at http://www.geeksforgeeks.org/backtracking-set-3-n-queen-problem/
 * 
 * @author emmanuel
 * 
 */
public class NQueens {
  public static void find(int N) {
    int[][] queens = new int[N][N];
    if (findUtil(queens, 0, N)) {
      printBoard(queens, N);
    }
  }

  private static void printBoard(int[][] queens, int N) {
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++)
        System.out.print(String.format("%1d ", queens[i][j]));
      System.out.println();
    }
  }

  private static boolean findUtil(int[][] queens, int col, int N) {
    if (N == col)
      return true;
    for (int i = 0; i < N; i++)
      if (canPlaceQueen(queens, N, i, col)) {
        queens[i][col] = 1;
        if (findUtil(queens, col + 1, N))
          return true;
        queens[i][col] = 0;
      }
    return false;
  }

  private static boolean canPlaceQueen(int[][] queens, int N, int row, int col) {
    if (row < 0 || col < 0 || row >= N || col >= N)
      return false;
    int[] xMove = {-1, -1, -1, 0, 0, 1, 1, 1};
    int[] yMove = {-1, 0, 1, -1, 1, -1, 0, 1};
    int nextRow, nextCol;
    for (int i = 0; i < 8; i++) {
      nextRow = row + xMove[i];
      nextCol = col + yMove[i];
      while (nextRow >= 0 && nextRow < N && nextCol >= 0 && nextCol < N) {
        if (queens[nextRow][nextCol] == 1)
          return false;
        nextRow = nextRow + xMove[i];
        nextCol = nextCol + yMove[i];
      }
    }
    return true;
  }

  public static void main(String[] args) {
    find(8);
  }

}
