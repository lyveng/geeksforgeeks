package geek.livingstone.interviews.flipkart.set8;

/**
 * Find the square root of a given integer. e.g 27 output should be 5, for 32 output should be 6.
 * 
 * @author emmanuel
 *
 */
public class BabylonianMethod {
  public static int isqrt(int n) {
    double x = n, y = 1, e = 1;
    while (x - y > e) {
      x = (x+y)/2;
      y = n/x;
    }
    int sqrt = (int) y;
    if (sqrt*sqrt <= n && (sqrt+1)*(sqrt+1) > n)
      return sqrt;
    else
      return sqrt+1;
  }

  public static void main(String[] args) {
    System.out.println(isqrt(99));
    System.out.println(isqrt(100));
    System.out.println(isqrt(101));
  }
}
