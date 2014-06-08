package geek.livingstone.problems.linkedlist;

import java.util.Arrays;

public class LongestCommonSubsequence {
  public LongestCommonSubsequence(String a, String b) {
    int[][] L = new int[a.length() + 1][b.length() + 1];
    for (int i = 0; i <= a.length(); i++) {
      for (int j = 0; j <= b.length(); j++) {
        if (i==0 || j==0) {
          L[i][j] = 0;
        }
        else if (a.charAt(i-1) == b.charAt(j-1)) {
          L[i][j] = L[i-1][j-1] + 1;
        }
        else {
          L[i][j] = Math.max(L[i-1][j], L[i][j-1]);
        }
      }
    }
    for (int i=0;i<=a.length();i++)
      System.out.println(Arrays.toString(L[i]));
    System.out.println("Length of LCS is " + L[a.length()][b.length()]);
    constructAndPrintLCS(a, b, L);
    System.out.println();
  }

  private void constructAndPrintLCS(String a, String b, int[][] L) {
    int i=a.length(), j=b.length();
    StringBuilder sb = new StringBuilder();
    while(i>1 && j>1) {
      while (L[i-1][j] == L[i][j])
        i--;
      while (L[i][j-1] == L[i][j])
        j--;
      sb.append(a.charAt(i-1));
      i--;
      j--;
    }
    System.out.println(sb.reverse().toString());
  }

  public static void main(String[] args) {
    new LongestCommonSubsequence("ABCDGH", "AEDFHR");
    new LongestCommonSubsequence("AGGTAB", "GXTXAYB");
  }

}
