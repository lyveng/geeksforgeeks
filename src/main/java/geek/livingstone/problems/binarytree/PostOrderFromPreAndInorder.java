package geek.livingstone.problems.binarytree;

/**
 * Full problem at http://www.geeksforgeeks.org/print-postorder-from-given-inorder-and-preorder-traversals/
 * 
 * @author emmanuel
 *
 */
public class PostOrderFromPreAndInorder {
  public static void postOrder(int[] preOrder, int[] inOrder) {
    postOrder(preOrder, inOrder, 0, preOrder.length - 1, 0, inOrder.length - 1);
  }

  private static void postOrder(int[] preOrder, int[] inOrder, int preStart, int preEnd, int inStart, int inEnd) {
    int root = inStart;
    for (int i = inStart; i <= inEnd; i++)
      if (preOrder[preStart] == inOrder[i]) {
        root = i;
        break;
      }

    // Check if left subtree is empty
    if (root != inStart)
      postOrder(preOrder, inOrder, preStart + 1, preStart + root - inStart, inStart, root - 1);

    // Check if right subtree is empty
    if (root != inEnd)
      postOrder(preOrder, inOrder, preStart + root - inStart + 1, preEnd, root + 1, inEnd);

    System.out.print(preOrder[preStart] + " ");
  }

  public static void main(String[] args) {
    postOrder(new int[] {1, 2, 4, 5, 3, 6}, new int[] {4, 2, 5, 1, 3, 6});
  }

}
