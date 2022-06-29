import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int basicSum;
    static ArrayList<BinaryTree> trees = new ArrayList<>();
    public static void main(String[] Args) throws IOException{
        int N = stoi();
        for (int i = 0; i < N; i++) {
            int tar = stoi();
            trees.add(new BinaryTree(tar));
            basicSum+=tar;
        }
        Collections.sort(trees);
        trees.add(new BinaryTree(Integer.MAX_VALUE));
        recursive();
    }

    static void recursive() {
        if(trees.size() == 1) {
            int finalValue = trees.get(0).getTotalValue() - basicSum;
            System.out.println(finalValue);
            System.exit(0);
        }

        BinaryTree fst = trees.remove(0);
        BinaryTree sec = trees.remove(0);
        BinaryTree add = new BinaryTree(fst.value+sec.value,fst, sec);
        if(trees.size() != 0) {
            int low = -1, high = trees.size();
            while(low+1<high) {
                int mid = (low + high) /2;
                if(trees.get(mid).value < add.value) {
                    low = mid;
                }
                else high = mid;
            }
            if(high == 0 && add.value >= trees.get(trees.size()-1).value)
                high = trees.size();
            trees.add(high, add);
        } else
            trees.add(add);
        recursive();
    }

    static int stoi() throws IOException{
        return Integer.parseInt(br.readLine());
    }


}

class BinaryTree implements Comparable<BinaryTree>{
    int value;
    BinaryTree left, right;
    BinaryTree() {
        this.value = 0;
    }

    BinaryTree(int value) {
        this.value = value;
    }

    BinaryTree(int value, BinaryTree left, BinaryTree right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }

    int getTotalValue() {
        int leftValue = 0, rightValue = 0;
        if(left != null) {
            leftValue = left.getTotalValue();
        }
        if(right != null) {
            rightValue = right.getTotalValue();
        }
        return value + leftValue + rightValue;
    }

    @Override
    public int compareTo(BinaryTree o) {
        return Integer.compare(value, o.value);
    }
}