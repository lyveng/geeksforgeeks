package geek.livingstone.problems.dp;

import java.util.Arrays;

public class CoinChange {
  public CoinChange(int N, int[] S) {
    int[][] count = new int[N+1][S.length+1];
    for (int j=0;j<=S.length;j++)
      count[0][j] = 1;
    for (int i=0;i<=N;i++) {
      count[i][0] = 0;
    }
    for (int i=1;i<=N;i++) {
      for (int j=1;j<=S.length;j++) {
        count[i][j] = count[i][j-1] + ((i-S[j-1] >= 0) ? count[i-S[j-1]][j] : 0);
      }
    }
    for (int i=0;i<=N;i++)
      System.out.println(Arrays.toString(count[i]));
    System.out.println("Number of different ways is " + count[N][S.length]);
  }

  public static void main(String[] args) {
    new CoinChange(4, new int[] {1,2,3});
    new CoinChange(10, new int[] {2,5,3,6});
  }
}
