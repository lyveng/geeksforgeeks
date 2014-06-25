package geek.livingstone.problems.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Full problem at http://www.geeksforgeeks.org/backtracking-set-7-suduku/
 * 
 * @author emmanuel
 *
 */
public class Sudoku {
  private static int maxPos = Integer.MIN_VALUE;

  public static void solve(int[][] board, int N) {
    List<Integer> row = new ArrayList<>(), col = new ArrayList<>();
    for (int i = 0; i < N; i++)
      for (int j = 0; j < N; j++)
        if (board[i][j] == 0) {
          row.add(i);
          col.add(j);
        }
    if (solveUtil(board, N, row.toArray(new Integer[] {}), col.toArray(new Integer[] {}), 0))
      printBoard(board, N);
    else
      System.out.println("No solution exists for the given configuration.");
  }

  private static void printBoard(int[][] board, int n) {
    for (int i = 0; i < n; i++)
      System.out.println(Arrays.toString(board[i]));
  }

  private static boolean solveUtil(int[][] board, int N, Integer[] row, Integer[] col, int pos) {
    if (pos > maxPos) maxPos = pos;
    if (pos == row.length) return true;
    assert board[row[pos]][col[pos]] == 0;
    for (int i = 1; i <= 9; i++) {
      if (isSafe(board, N, row[pos], col[pos], i)) {
        board[row[pos]][col[pos]] = i;
        if (solveUtil(board, N, row, col, pos + 1)) return true;
        board[row[pos]][col[pos]] = 0;
      }
    }
    return false;
  }

  private static boolean isSafe(int[][] board, int N, int row, int col, int val) {
    assert board[row][col] == 0;
    // Check the 3x3 matrix
    int startRow = row / 3 * 3, endRow = startRow + 3, startCol = col / 3 * 3, endCol = startCol + 3;
    for (int i = startRow; i < endRow; i++)
      for (int j = startCol; j < endCol; j++) {
        if (board[i][j] == val) return false;
      }

    // Check the row
    for (int i = 0; i < N; i++)
      if (board[row][i] == val) return false;

    // Check the col
    for (int i = 0; i < N; i++)
      if (board[i][col] == val) return false;
    return true;
  }

  public static void main(String[] args) {
    int[][] grid = {{3, 0, 6, 5, 0, 8, 4, 0, 0},
                    {5, 2, 0, 0, 0, 0, 0, 0, 0},
                    {0, 8, 7, 0, 0, 0, 0, 3, 1},
                    {0, 0, 3, 0, 1, 0, 0, 8, 0},
                    {9, 0, 0, 8, 6, 3, 0, 0, 5},
                    {0, 5, 0, 0, 9, 0, 6, 0, 0},
                    {1, 3, 0, 0, 0, 0, 2, 5, 0},
                    {0, 0, 0, 0, 0, 0, 0, 7, 4},
                    {0, 0, 5, 2, 0, 6, 3, 0, 0}};
    solve(grid, 9);
    System.out.println(maxPos);
  }

}
