package geek.livingstone.problems.binarysearchtree;

/**
 * Check if each internal node of a BST has exactly one child given the pre order traversal of the bst. * 
 * Full problem at
 * http://www.geeksforgeeks.org/check-if-each-internal-node-of-a-bst-has-exactly-one-child/
 * 
 * @author emmanuel
 * 
 */
public class CheckBSTInternalNodesHaveSingleChild {
  public static boolean check(int[] pre) {
    int i=0, min=Integer.MIN_VALUE, max = Integer.MAX_VALUE;
    for (i=0;i<pre.length-1;i++) {
      if (pre[i] < min || pre[i] > max)
        break;
      if (pre[i+1] > pre[i])
        min = pre[i];
      else
        max = pre[i];
    }
    return i == (pre.length-1);
  }

  public static void main(String[] args) {
    System.out.println(check(new int[] {20, 10, 11, 13, 12}));
  }

}

