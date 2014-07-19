package geek.livingstone.interviews.flipkart.set8;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Stack;

/**
 * Online coding round.
 * 
 * @author emmanuel
 *
 */
public class ReverseLevelOrder {
  public static void printReverseLevelOrder(int[] tree) {
    Stack<Integer[]> traversal = new Stack<>();
    LinkedList<Integer> q1 = new LinkedList<>(), q2 = new LinkedList<>();
    int root = -1;
    for (int i = 0; i < tree.length; i++)
      if (tree[i] == -1)
      {
        root = i;
        break;
      }
    assert root != -1;
    q1.addLast(root);
    traversal.add(q1.toArray(new Integer[] {}));

    while (!q1.isEmpty()) {
      int cur = q1.removeFirst();
      for (int i = 0; i < tree.length; i++)
        if (tree[i] == cur)
          q2.addLast(i);
      if (q1.isEmpty() && !q2.isEmpty())
      {
        traversal.add(q2.toArray(new Integer[] {}));
        q1 = q2;
        q2 = new LinkedList<>();
      }
    }

    while (!traversal.isEmpty()) {
      Integer[] cur = traversal.pop();
      System.out.println(Arrays.toString(cur));
    }
    System.out.println();
  }

  public static void main(String[] args) {
    printReverseLevelOrder(new int[] {-1, 0, 0, 1, 1});
  }

}
