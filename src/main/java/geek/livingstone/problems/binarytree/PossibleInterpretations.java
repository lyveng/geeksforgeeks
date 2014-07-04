package geek.livingstone.problems.binarytree;

/**
 * Full problem at http://www.geeksforgeeks.org/find-all-possible-interpretations/
 * 
 * @author emmanuel
 * 
 */
public class PossibleInterpretations {
  static int base = (int) 'a' - 1;

  public static void print(int[] arr) {
    print(arr, 0, new StringBuilder());
  }

  private static void print(int[] arr, int index, StringBuilder sb) {
    if (index == arr.length) {
      System.out.println(sb.toString());
      return;
    }
    sb.append((char) (base + arr[index]));
    print(arr, index + 1, sb);
    sb.deleteCharAt(sb.length() - 1);

    if (index + 1 < arr.length) {
      int val = arr[index] * 10 + arr[index + 1];
      if (val <= 26) {
        sb.append((char) (base + val));
        print(arr, index + 2, sb);
        sb.deleteCharAt(sb.length() - 1);
      }
    }
  }

  public static void main(String[] args) {
    print(new int[] {1,1});
    System.out.println();
    print(new int[] {1,2,1});
    System.out.println();;
    print(new int[] {9,1,8});
  }

}
