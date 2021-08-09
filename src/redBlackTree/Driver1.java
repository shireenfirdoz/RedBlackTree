package redBlackTree;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Driver1 {

  public static void main(String[] args) throws FileNotFoundException {

    RedBlackTree rbTree = new RedBlackTree();

    Scanner sc = new Scanner(new File("res/rbtree.txt"));
    while (sc.hasNextLine()) {
      String input = sc.nextLine();
      execute("insert " + input, rbTree);
    }

    sc = new Scanner(System.in);

    System.out.println(
        "Red Black Tree operations are as follows: \n 1.) insert <key> \n 2.) search <key> \n 3.) min \n 4.)"
            + " max \n 5.) predecessor <key> \n 6.) successor <key> \n 7.) sort \n 8.) print \n 9.) q\nPlease select one option:");
    while (sc.hasNextLine()) {

      execute(sc.nextLine(), rbTree);
      System.out.println("Please select one option: ");
    }

  }

  private static void execute(String str, RedBlackTree rb) {
    String[] input = str.split(" ");
    switch (input[0]) {
    case "insert":
      if (input.length <= 1)
        System.out.println("Command for inserting an element is :  \"insert <key>\"");
      else {
        TreeNode z = new TreeNode(Integer.parseInt(input[1]), rb.sentinel, rb.sentinel, rb.sentinel,
            COLOR.RED);
        rb.insert(z);
        System.out.println(input[1] + " element inserted successfully");
      }
      break;

    case "search":
      if (input.length <= 1)
        System.out.println("Command for searching an element is :  \"search <key>\"");
      else {
        TreeNode node = rb.search(Integer.parseInt(input[1]));
        if (node == null) {
          System.out.println("key not found");
        } else {
          System.out.println("Search Node " + node.key + " Color " + node.color + " LeftChild "
              + node.left.key + " RightChild " + node.right.key + " Parent " + node.parent.key);
        }
      }

      break;
    case "sort":
      System.out.println("Sorted elements of RB Tree is :");
      rb.sort();
      break;

    case "max":
      System.out.println("Maximum for RB Tree is: " + rb.max());
      break;

    case "min":
      System.out.println("Minimum for RB Tree is:  " + rb.min());
      break;
    case "successor":
      if (input.length <= 1)
        System.out.println("Command for finding an successor element is :  \"successor <key>\"");
      else {
        TreeNode node = rb.search(Integer.parseInt(input[1]));
        TreeNode successor = rb.successor(node);
        if (successor == null) {
          System.out.println("successor not found");
        } else {
          System.out.println("Successor Node " + successor.key + " Color " + successor.color
              + " LeftChild " + successor.left.key + " RightChild " + successor.right.key
              + " Parent " + successor.parent.key);
        }
      }
      break;

    case "predecessor":
      if (input.length <= 1)
        System.out
            .println("Command for finding an predecessor element is :  \"predecessor <key>\"");
      else {
        TreeNode node = rb.search(Integer.parseInt(input[1]));
        TreeNode predecessor = rb.predecessor(node);
        if (predecessor == null) {
          System.out.println("predecessor not found");
        } else {
          System.out.println("Predecessor Node " + predecessor.key + " Color " + predecessor.color
              + " LeftChild " + predecessor.left.key + " RightChild " + predecessor.right.key
              + " Parent " + predecessor.parent.key);
        }

      }
      break;
    case "print":
      rb.printTree();
      return;

    case "q":
      return;
    default:
      System.out.println("Invalid Command.");
      break;
    }
    System.out.println("RB Tree height: " + rb.height() + "\n");
  }
}
