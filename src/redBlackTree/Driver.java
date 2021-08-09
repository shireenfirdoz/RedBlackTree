package redBlackTree;

public class Driver {

  public Driver() {
    // TODO Auto-generated constructor stub
  }

  public static void main(String[] args) {

    print() ;
    
  }

  public static void print() {

    RedBlackTree rb = new RedBlackTree();
    TreeNode z = new TreeNode(2, rb.sentinel, rb.sentinel, rb.sentinel, COLOR.RED);
    rb.insert(z);
    System.out.println("height----"+ rb.height());
    TreeNode z1 = new TreeNode(4, rb.sentinel, rb.sentinel, rb.sentinel, COLOR.RED);
    rb.insert(z1);
    System.out.println("height----"+ rb.height());
    TreeNode z2 = new TreeNode(1, rb.sentinel, rb.sentinel, rb.sentinel, COLOR.RED);
    rb.insert(z2);
    System.out.println("height----"+ rb.height());
    TreeNode z3 = new TreeNode(10, rb.sentinel, rb.sentinel, rb.sentinel, COLOR.RED);
    rb.insert(z3);
    System.out.println("height----"+ rb.height());
    TreeNode z4 = new TreeNode(20, rb.sentinel, rb.sentinel, rb.sentinel, COLOR.RED);
    rb.insert(z4);
    System.out.println("height----"+ rb.height());
    TreeNode z5 = new TreeNode(30, rb.sentinel, rb.sentinel, rb.sentinel, COLOR.RED);
    rb.insert(z5);
    System.out.println("height----"+ rb.height());

    
    rb.printTree();
    System.out.println("height----"+ rb.height());
    rb.sort();
    System.out.println("height----"+ rb.height());
    TreeNode node = rb.search(20);
    if (node == null) {
      System.out.println("key not found");
    } else {
      System.out.println("Search Node " + node.key + " Color " + node.color + " LeftChild "
          + node.left.key + " RightChild " + node.right.key + " Parent " + node.parent.key);
    }
    System.out.println("height----"+ rb.height());

    System.out.println("min " + rb.min());
    System.out.println("height----"+ rb.height());
    System.out.println("max " + rb.max());
    System.out.println("height----"+ rb.height());

    TreeNode predecessor = rb.predecessor(z4);
    if (predecessor == null) {
      System.out.println("predecessor not found");
    } else {
      System.out.println("Predecessor Node " + predecessor.key + " Color " + predecessor.color
          + " LeftChild " + predecessor.left.key + " RightChild " + predecessor.right.key
          + " Parent " + predecessor.parent.key);
    }
    System.out.println("height----"+ rb.height());
    
    TreeNode successor = rb.successor(z3);
    if (successor == null) {
      System.out.println("successor not found");
    } else {
      System.out.println("Successor Node " + successor.key + " Color " + successor.color
          + " LeftChild " + successor.left.key + " RightChild " + successor.right.key + " Parent "
          + successor.parent.key);
      System.out.println("height----"+ rb.height());
    }

  }

}
