package geek.livingstone.problems.dp;

import java.util.Arrays;

public class LongestPalindromicSubsequence {
  public LongestPalindromicSubsequence(String s) {
    int[][] L = new int[s.length()][s.length()];
    for (int i=0;i<s.length();i++)
      L[i][i] = 1;
    // sl is the length of the subsequence
    for (int sl=2;sl<=s.length();sl++) {
      for (int i=0;i<=s.length()-sl;i++) {
        int j=i+sl-1;
        if (s.charAt(i)==s.charAt(j) && sl==2)
          L[i][j] = 2;
        else if (s.charAt(i)==s.charAt(j))
          L[i][j] = 2 + L[i+1][j-1];
        else
          L[i][j] = Math.max(L[i+1][j], L[i][j-1]);
      }
    }
    for (int i=0;i<s.length();i++)
      System.out.println(Arrays.toString(L[i]));
    System.out.println("Length of LPS is " + L[0][s.length()-1]);
  }

  public static void main(String[] args) {
    new LongestPalindromicSubsequence("BBABCBCAB");
  }
}
