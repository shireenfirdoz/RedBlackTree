package redBlackTree;

public class RedBlackTree {

  TreeNode root;
  TreeNode sentinel;

  public RedBlackTree() {
    sentinel = new TreeNode(Integer.MIN_VALUE, null, null, null, COLOR.BLACK);
    root = sentinel;
  }

  public void printTree() {
    printRbTree(root);
  }

  private void printRbTree(TreeNode root) {
    if (root != sentinel) {
      System.out.println("Node " + root.key + " Color " + root.color + " LeftChild " + root.left.key
          + " RightChild " + root.right.key + " Parent " + root.parent.key);
      printRbTree(root.left);
      printRbTree(root.right);
    }
  }

  private void printRbTreeInorder(TreeNode root) {
    if (root != sentinel) {
      printRbTreeInorder(root.left);
      System.out.println(root.key);
      printRbTreeInorder(root.right);
    }
  }

  private TreeNode search(TreeNode t, int k) {
    if (t != sentinel) {
      if (t.key == k) {
        return t;
      } else if (t.key > k) {
        return search(t.left, k);
      } else if (t.key < k) {
        return search(t.right, k);
      }
    }
    return null;
  }

  public TreeNode search(int k) {
    return search(root, k);
  }

  public int min() {
    TreeNode temp = root;
    while (temp.left != sentinel) {
      temp = temp.left;
    }
    return temp.key;
  }

  public int max() {

    TreeNode temp = root;
    while (temp.right != sentinel) {
      temp = temp.right;
    }
    return temp.key;
  }

  public int height() {
    return height(root);
  }

  private int height(TreeNode t) {
    if (t == sentinel) {
      return 0;
    }
    if (t.left == sentinel && t.right == sentinel) {
      return 1;
    }

    return Math.max(height(t.left), height(t.right)) + 1;
  }

  public TreeNode predecessor(TreeNode t) {
    if (t == null) {
      return null;
    }

    if (t.left != sentinel) {
      TreeNode temp = t.left;
      while (temp.right != sentinel) {
        temp = temp.right;
      }
      return temp;
    }
    TreeNode node = t.parent;
    while (node != sentinel && t == node.left) {
      t = node;
      node = node.parent;
    }

    return node;

  }

  public TreeNode successor(TreeNode t) {

    if (t == null) {
      return null;
    }

    if (t.right != sentinel) {
      TreeNode temp = t.right;
      while (temp.left != sentinel) {
        temp = temp.left;
      }
      return temp;
    }
    TreeNode node = t.parent;
    while (node != sentinel && t == node.right) {
      t = node;
      node = node.parent;
    }

    return node;
  }

  public void sort() {
    printRbTreeInorder(root);
  }

  public void leftRotate(TreeNode x) {
    TreeNode y = x.right;
    // roots parent is sentinel
    if (y != sentinel) {
      x.right = y.left;
      if (y.left != sentinel) {
        y.left.parent = x;
      }
      y.parent = x.parent;
      if (x.parent == sentinel) {
        root = y;
      } else if (x == x.parent.left) {
        x.parent.left = y;
      } else {
        x.parent.right = y;
      }
      y.left = x;
      x.parent = y;
    }
  }

  public void rightRotate(TreeNode x) {
    TreeNode y = x.left;
    if (y != sentinel) {
      x.left = y.right;
      if (y.right != sentinel) {
        y.right.parent = x;
      }
      y.parent = x.parent;
      if (x.parent == sentinel) {
        root = y;
      } else if (x == x.parent.right) {
        x.parent.right = y;
      } else {
        x.parent.left = y;
      }
      y.right = x;
      x.parent = y;
    }
  }

  public void insert(TreeNode z) {

    if (root == sentinel) {
      root = z;
      root.color = COLOR.BLACK;
      return;
    }
    TreeNode y = sentinel;
    TreeNode x = root;

    while (x != sentinel) {
      y = x;
      if (z.key < x.key) {
        x = x.left;
      } else {
        x = x.right;
      }

    }
    z.parent = y;
    if (y == sentinel) {
      root = z;
    } else if (z.key < y.key) {
      y.left = z;
    } else {
      y.right = z;

    }

    z.left = sentinel;
    z.right = sentinel;
    z.color = COLOR.RED;
    insertFixUp(z);
  }

  public void insertFixUp(TreeNode z) {
    while (z.parent.color == COLOR.RED) {
      if (z.parent == z.parent.parent.left) {
        TreeNode y = z.parent.parent.right;
        if (y.color == COLOR.RED) {
          z.parent.color = COLOR.BLACK;
          y.color = COLOR.BLACK;
          z.parent.parent.color = COLOR.RED;
          z = z.parent.parent;
        } else if (z == z.parent.right) {
          z = z.parent;
          leftRotate(z);
        } else {
          z.parent.color = COLOR.BLACK;
          z.parent.parent.color = COLOR.RED;
          rightRotate(z.parent.parent);
        }

      } else {
        TreeNode y = z.parent.parent.left;
        if (y.color == COLOR.RED) {
          z.parent.color = COLOR.BLACK;
          y.color = COLOR.BLACK;
          z.parent.parent.color = COLOR.RED;
          z = z.parent.parent;
        } else if (z == z.parent.left) {
          z = z.parent;
          rightRotate(z);
        } else {
          z.parent.color = COLOR.BLACK;
          z.parent.parent.color = COLOR.RED;
          leftRotate(z.parent.parent);
        }

      }
    }
    root.color = COLOR.BLACK;
  }

}
