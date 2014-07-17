package geek.livingstone.problems.dp;

import java.util.Arrays;

public class EggDrop {
  /**
   * n eggs k floors
   * @param n
   * @param k
   */
  public static void eggDrop(int n, int k) {
    int[][] m = new int[n+1][k+1];
    // 0 floors - 0 trials - already set by default
    // 1 floor - 1 trial
    // 0 eggs - Pos Inf
    for (int i = 1; i < k; i++) {
      m[0][i] = Integer.MAX_VALUE;
    }
    for (int eggs = 1; eggs <= n; eggs++) {
      for (int floors = 1; floors <= k; floors++) {
        m[eggs][floors] = Integer.MAX_VALUE;
        for (int x = 1; x <= floors; x++) {
          m[eggs][floors] = Math.min(m[eggs][floors], Math.max(m[eggs-1][x-1], m[eggs][floors-x]));
        }
        if (m[eggs][floors] != Integer.MAX_VALUE)
          m[eggs][floors] += 1;
      }
    }
    for (int i = 0; i < m.length; i++) {
      System.out.println(Arrays.toString(m[i]));
    }
    System.out.println(m[n][k]);
  }

  public static void main(String[] args) {
    eggDrop(2, 10);
  }

}
