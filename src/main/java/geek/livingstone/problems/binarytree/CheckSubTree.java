package geek.livingstone.problems.binarytree;

import geek.livingstone.adt.BinaryTreeNode;

/**
 * Full problem at http://www.geeksforgeeks.org/check-if-a-binary-tree-is-subtree-of-another-binary-tree/
 * @author emmanuel
 *
 */
public class CheckSubTree {
  /**
   * Check if S is a subtree of T.
   * 
   * @param T
   * @param S
   * @return
   */
  public static boolean isSubTree(BinaryTreeNode T, BinaryTreeNode S) {
    if (T == null && S == null) 
      return true;
    else if (T == null || S == null)
      return false;
    if (isSameTree(T, S))
      return true;
    return isSubTree(T.left, S) || isSubTree(T.right, S);
  }

  public static boolean isSameTree(BinaryTreeNode n1, BinaryTreeNode n2)
  {
    if (n1 == null && n2 == null)
      return true;
    else if (n1 == null || n2 == null)
      return false;
    else
      return n1.data == n2.data && isSameTree(n1.left, n2.left) && isSameTree(n1.right, n2.right);
  }

  public static void main(String[] args) {
    /* Construct the following tree
        26
       /   \
     10     3
     / \     \
    4   6     3
     \
      30
    */
    BinaryTreeNode root1 = new BinaryTreeNode(26);
    root1.right = new BinaryTreeNode(3);
    root1.right.right = new BinaryTreeNode(3);
    root1.left = new BinaryTreeNode(10);
    root1.left.left = new BinaryTreeNode(4);
    root1.left.left.right = new BinaryTreeNode(30);
    root1.left.right = new BinaryTreeNode(6);

    /* Construct the following tree
       10
      /   \
    4      6
     \
      30
     */
    BinaryTreeNode root2 = new BinaryTreeNode(10);
    root2.right = new BinaryTreeNode(6);
    root2.left = new BinaryTreeNode(4);
    root2.left.right = new BinaryTreeNode(30);

    System.out.println(isSubTree(root1, root2));
  }
}
