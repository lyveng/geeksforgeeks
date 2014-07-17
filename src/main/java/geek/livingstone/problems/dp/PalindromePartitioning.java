package geek.livingstone.problems.dp;


/**
 * Full problem can be found at
 * http://www.geeksforgeeks.org/dynamic-programming-set-17-palindrome-partitioning/
 * 
 * @author emmanuel
 * 
 */
public class PalindromePartitioning {
  public static void partition(String s) {
    int[][] c = new int[s.length()][s.length()];
    for (int i = 0; i < c.length; i++) {
      for (int j = 0; j < c[i].length; j++) {
        c[i][j] = i == j ? 0 : Integer.MAX_VALUE;
      }
    }
    for (int l = 2; l <= s.length(); l++) {
      for (int start = 0; start <= s.length() - l; start++) {
        int end = start + l - 1;
        if (isPalindrome(s, start, end)) {
          c[start][end] = 0;
          continue;
        }
        for (int cut = start; cut < end; cut++) {
          c[start][end] = Math.min(c[start][end], 1 + c[start][cut] + c[cut + 1][end]);
        }
      }
    }
    System.out.println(c[0][s.length() - 1]);
  }

  private static boolean isPalindrome(String s, int start, int end) {
    while (start < end) {
      if (s.charAt(start) != s.charAt(end))
        break;
      start++;
      end--;
    }
    return start >= end;
  }

  public static void main(String[] args) {
    partition("a");
    partition("ab");
    partition("aba");
    partition("abc");
    partition("abba");
    partition("abbc");
    partition("ababbbabbababa");
  }

}
