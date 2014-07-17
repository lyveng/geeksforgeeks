package geek.livingstone.problems.dp;

import java.util.Arrays;


public class LongestPalindromicSubsequence {
  public static void lps(String s) {
    int[][] lps = new int[s.length()][s.length()];
    for (int i = 0; i < lps.length; i++) {
      lps[i][i] = 1;
    }
    for (int length = 2; length <= s.length(); length++) {
      for (int start = 0; start <= s.length() - length; start++) {
        int end = start + length - 1;
        if (s.charAt(start) == s.charAt(end))
          lps[start][end] = 2 + lps[start+1][end-1];
        else
          lps[start][end] = Math.max(lps[start+1][end], lps[start][end-1]);
      }
    }
    for (int i = 0; i < lps.length; i++) {
      System.out.println(Arrays.toString(lps[i]));
    }
    System.out.println(lps[0][s.length()-1]);
  }

  public static void main(String[] args) {
    lps("BBABCBCAB");
  }
}
