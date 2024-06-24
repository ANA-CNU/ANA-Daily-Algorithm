import java.util.*;
import java.io.*;

public class Main {
    static StringBuilder sb;
    static int inorder[], postorder[];
    static int n;

    // in: 4 2 5 1 3
    // post: 4 5 2 3 1
    // pre: 1 2 4 5 3
    // post: last: root, root - 1: right, root - 2: left
    // in: middle: root, middle - 1: left, middle + 1: right
    public static void preorder(int inorder_start, int inorder_end, int postorder_start, int postorder_end) {
        if(inorder_start > inorder_end || postorder_start > postorder_end) {
            return;
        }

        int root = postorder[postorder_end];
        sb.append(root).append(" ");

        int root_index = 0;
        for(int i = inorder_start; i <= inorder_end; i++) {
            if(inorder[i] == root) {
                root_index = i;
                break;
            }
        }

        // left
        preorder(inorder_start, root_index - 1, postorder_start, postorder_start + (root_index - inorder_start) - 1);

        // right
        preorder(root_index + 1, inorder_end, postorder_start + (root_index - inorder_start), postorder_end - 1);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        inorder = new int[n + 1];
        postorder = new int[n + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        //input end

        for(int i = 1; i <= n; i++) {
            inorder[i] = Integer.parseInt(st.nextToken());
            postorder[i] = Integer.parseInt(st2.nextToken());
        }

        sb = new StringBuilder();
        preorder(1, n, 1, n);

        System.out.println(sb);
    }
}

