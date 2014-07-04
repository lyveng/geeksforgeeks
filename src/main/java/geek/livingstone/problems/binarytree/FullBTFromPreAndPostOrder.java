package geek.livingstone.problems.binarytree;

import geek.livingstone.adt.BinaryTreeNode;

/**
 * Construct Full Binary Tree from given preorder and postorder traversals Full problem at
 * http://www
 * .geeksforgeeks.org/full-and-complete-binary-tree-from-given-preorder-and-postorder-traversals/
 * 
 * @author emmanuel
 * 
 */
public class FullBTFromPreAndPostOrder {
  public static BinaryTreeNode constructTree(int[] pre, int[] post, int preStart, int preEnd, int postStart, int postEnd) {
    assert pre[preStart] == post[postEnd];
    if (preStart == preEnd)
      return new BinaryTreeNode(pre[preStart]);
    int postLeftEnd = postStart;
    for (int i = postStart; i <= postEnd; i++)
      if (pre[preStart + 1] == post[i]) {
        postLeftEnd = i;
        break;
      }

    BinaryTreeNode root = new BinaryTreeNode(pre[preStart]);
    root.left = constructTree(pre, post, preStart + 1, preStart + (postLeftEnd - postStart + 1), postStart, postLeftEnd);
    root.right = constructTree(pre, post, preStart + (postLeftEnd - postStart + 1) + 1, preEnd, postLeftEnd + 1, postEnd);
    return root;
  }

  public static void main(String[] args) {
    int[] pre = {1, 2, 4, 8, 9, 5, 3, 6, 7};
    int[] post = {8, 9, 4, 5, 2, 6, 7, 3, 1};
    BinaryTreeNode root = constructTree(pre, post, 0, pre.length - 1, 0, post.length - 1);
    BinaryTreeNode.printInOrder(root);
  }

}
