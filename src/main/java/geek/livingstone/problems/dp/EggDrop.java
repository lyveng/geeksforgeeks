package geek.livingstone.problems.dp;

import java.util.Arrays;

public class EggDrop {

  public EggDrop(int n, int k) {
    int[][] E = new int[n+1][k+1];
    for (int i=0;i<=n;i++) {
      // 1 floor means 1 trial irrespective of number of eggs..
      E[i][1] = 1;
      // 0 floors means 0 trials.
      E[i][0] = 0;
    }
    for (int j=0;j<=k;j++) {
      // 0 eggs means no trials
      E[0][j] = 0;
      // 1 egg means i trials for i floors.
      E[1][j] = j;
    }
    int xVal;
    for (int i=2;i<=n;i++) {
      for (int j=2;j<=k;j++) {
        E[i][j] = Integer.MAX_VALUE;
        int minFloor = 0;
        for (int x=1;x<=j;x++) {
          xVal = 1 + Math.max(E[i-1][x-1], E[i][j-x]);
          if (xVal < E[i][j]) {
            minFloor = x;
            E[i][j] = xVal;
          }
        }
        System.out.println(String.format("For eggs=%s and floors=%s floor to begin with is %s", i, j, minFloor));
      }
    }
    for (int i=0;i<=n;i++) {
      System.out.println(Arrays.toString(E[i]));
    }
    
    System.out.println(E[n][k]);
  }

  public static void main(String[] args) {
    new EggDrop(2, 10);
  }

}
