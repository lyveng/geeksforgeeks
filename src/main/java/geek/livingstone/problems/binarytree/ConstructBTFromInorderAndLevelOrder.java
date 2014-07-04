package geek.livingstone.problems.binarytree;

import java.util.Arrays;

import geek.livingstone.adt.BinaryTreeNode;

/**
 * Full problem at http://www.geeksforgeeks.org/construct-tree-inorder-level-order-traversals/
 * 
 * @author emmanuel
 * 
 */
public class ConstructBTFromInorderAndLevelOrder {

  public static BinaryTreeNode constructUtil(int[] inOrder, int[] levelOrder) {
    if (inOrder.length == 0)
      return null;
    assert inOrder.length == levelOrder.length;
    int root = 0;
    for (int i = 0; i <= inOrder.length; i++)
      if (levelOrder[0] == inOrder[i]) {
        root = i;
        break;
      }

    BinaryTreeNode rootNode = new BinaryTreeNode(levelOrder[0]);

    // Check if left subtree is empty
    if (root != 0) {
      int[] leftInorder = Arrays.copyOfRange(inOrder, 0, root);
      int[] leftLevelOrder = extract(leftInorder, levelOrder);
      rootNode.left = constructUtil(leftInorder, leftLevelOrder);
    }

    // Check if right subtree is empty
    if (root != inOrder.length - 1) {
      int[] rightInOrder = Arrays.copyOfRange(inOrder, root + 1, inOrder.length);
      int[] rightLevelOrder = extract(rightInOrder, levelOrder);
      rootNode.right = constructUtil(rightInOrder, rightLevelOrder);
    }
    return rootNode;
  }

  private static int[] extract(int[] inOrder, int[] levelOrder) {
    int[] ret = new int[inOrder.length];
    int i = 0;
    for (int val : levelOrder) {
      boolean found = false;
      for (int inVal : inOrder)
        if (inVal == val) {
          found = true;
          break;
        }
      if (found)
        ret[i++] = val;
    }
    return ret;
  }

  public static void main(String[] args) {
    BinaryTreeNode root = constructUtil(new int[] {4, 8, 10, 12, 14, 20, 22}, new int[] {20, 8, 22, 4, 12, 10, 14});
    BinaryTreeNode.printInOrder(root);
  }

}
