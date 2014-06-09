package geek.livingstone.problems.dp;

import java.util.Arrays;
import java.util.Collections;

public class MinCostPath {
  public MinCostPath(int[][] cost, int m, int n) {
    int[][] minCostPath = new int[m+1][n+1];
    for (int i=0;i<=m;i++) {
      for (int j=0;j<=n;j++) {
        if (i==0 && j==0) {
          minCostPath[i][j] = 0;
          continue;
        }
        else if (i==0 || j==0)
        {
          minCostPath[i][j] = Integer.MAX_VALUE;
          continue;
        }
        minCostPath[i][j] = Collections.min(Arrays.asList(
          new Integer[] {minCostPath[i-1][j],
                         minCostPath[i][j-1],
                         minCostPath[i-1][j-1]})
          ) + cost[i-1][j-1];
      }
    }
    for (int i=0;i<=m;i++)
      System.out.println(Arrays.toString(minCostPath[i]));
    System.out.println("Minimum cost is " + minCostPath[m][n]);
  }

  public static void main(String[] args) {
    int[][] cost = new int[][] {{1,2,3},{4,8,2},{1,5,3}};
    new MinCostPath(cost, 3, 3);
  }

}
