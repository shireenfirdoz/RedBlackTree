package redBlackTree;

public class TreeNode {

  int key;
  TreeNode left;
  TreeNode right;
  TreeNode parent;
  COLOR color;

  public TreeNode(int key, TreeNode left, TreeNode right, TreeNode parent, COLOR color) {
    super();
    this.key = key;
    this.left = left;
    this.right = right;
    this.parent = parent;
    this.color = color;
  }

}
