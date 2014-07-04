package geek.livingstone.problems.backtracking;

import java.util.Arrays;

/**
 * Full problem at http://www.geeksforgeeks.org/backttracking-set-5-m-coloring-problem/
 * 
 * @author emmanuel
 * 
 */
public class GraphColoring {
  public static void colorGraph(int[][] graph, int N, int m) {
    int[] colors = new int[N];
    if (colorUtil(graph, N, colors, m, 0))
      System.out.println(Arrays.toString(colors));
    else
      System.out.println("No such arrangement exists.");
  }

  private static boolean colorUtil(int[][] graph, int N, int[] colors, int m, int v) {
    if (v == N)
      return true;
    for (int i = 1; i <= m; i++)
      if (isSafe(graph, N, colors, m, v, i)) {
        colors[v] = i;
        if (colorUtil(graph, N, colors, m, v + 1))
          return true;
        colors[v] = 0;
      }
    return false;
  }

  private static boolean isSafe(int[][] graph, int N, int[] colors, int m, int v, int color) {
    if (v == N)
      return true;
    for (int i = 0; i < N; i++) {
      if (i != v && graph[i][v] == 1 && colors[i] == color)
        return false;
    }
    return true;
  }

  public static void main(String[] args) {
    int[][] graph = { {0, 1, 1, 1}, {1, 0, 1, 0}, {1, 1, 0, 1}, {1, 0, 1, 0}};
    colorGraph(graph, 4, 3);
  }

}
