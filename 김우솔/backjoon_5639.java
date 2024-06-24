package Tree;

import java.io.*;
import java.util.*;

public class backjoon_5639 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int root = sc.nextInt();
        BST bst = new BST(root);

        while (sc.hasNext()) {
            bst.put(sc.nextInt());
        }

        System.out.println(bst.StartPosttravel());
    }
}

class BST {
    StringBuffer sb = new StringBuffer();
    private Node root;
    BST(int key) {
        root = new Node(key);
    }
    void put(int key) {
        if (root == null) return;
        root = put(root, key);
    }
    Node put(Node n, int key) {
        if (n == null) return new Node(key);
        int t = n.getItem() - key;
        if (t > 0) n.setLeft(put(n.getLeft(), key));
        if (t < 0) n.setRight(put(n.getRight(), key));
        return n;
    }
    StringBuffer StartPosttravel() {
        posttravel(root);
        return sb;
    }
    void posttravel(Node node) {
        if (node != null) {
            posttravel(node.getLeft());
            posttravel(node.getRight());
            sb.append(node.getItem()).append("\n");
        }
    }
}
class Node {
    private int item;
    private Node left, right;
    Node(int newitem) {
        item = newitem;
        left = right = null;
    }
    public Node getRight() {return right;}
    public Node getLeft() {return left;}
    public void setRight(Node right) {this.right = right;}
    public void setLeft(Node left) {this.left = left;}
    public int getItem() {return item;}
    public void setItem(int item) {this.item = item;}
}