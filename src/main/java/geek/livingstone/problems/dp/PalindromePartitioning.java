package geek.livingstone.problems.dp;

/**
 * Full problem can be found at
 * http://www.geeksforgeeks.org/dynamic-programming-set-17-palindrome-partitioning/
 * 
 * @author emmanuel
 * 
 */
public class PalindromePartitioning {
  private Boolean[][] isPalindrome;

  public PalindromePartitioning(String s) {
    isPalindrome = new Boolean[s.length()][s.length()];
    if (isPalindrome(s)) {
      System.out.println(0);
      return;
    }
    int[][] min = new int[s.length()][s.length()];
    for (int i = 0; i < s.length(); i++) {
      min[i][i] = 0;
      isPalindrome[i][i] = true;
    }
    for (int L = 2; L <= s.length(); L++) {
      for (int i = 0; i <= (s.length() - L); i++) {
        int j = i + L - 1;
        if (s.charAt(i) == s.charAt(j) && L == 2)
          isPalindrome[i][j] = true;
        else if (s.charAt(i) == s.charAt(j))
          isPalindrome[i][j] = isPalindrome[i + 1][j - 1];
        else
          isPalindrome[i][j] = false;
        if (isPalindrome[i][j]) {
          min[i][j] = 0;
          continue;
        }
        min[i][j] = Integer.MAX_VALUE;
        for (int k = i; k < j; k++) {
          int minK = 1 + min[i][k] + min[k + 1][j];
          if (minK < min[i][j]) min[i][j] = minK;
        }
      }
    }
    System.out.println(min[0][s.length() - 1]);
  }

  private boolean isPalindrome(String s) {
    if (s.length() <= 1) return true;
    int i = (s.length() - 2) / 2;
    int j = (s.length() % 2 == 0) ? (i + 1) : (i + 2);
    for (; i >= 0 && j < s.length(); i--, j++)
      if (s.charAt(i) != s.charAt(j)) {
        return false;
      }
    return true;
  }

  public static void main(String[] args) {
    new PalindromePartitioning("a");
    new PalindromePartitioning("ab");
    new PalindromePartitioning("aba");
    new PalindromePartitioning("abc");
    new PalindromePartitioning("abba");
    new PalindromePartitioning("abbc");
    new PalindromePartitioning("ababbbabbababa");
  }

}
