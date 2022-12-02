import java.io.*;
import java.util.StringTokenizer;

class Node {
    Node parent, left, right;
    int value, size = 1, min, max;
    long sum;
    boolean reverse;
    Node (int value) {
        sum = max = min = this.value = value;
    }

    public void update () {
        size = 1;
        sum = max = min = value;

        if (left != null) {
            min = Math.min(left.min, min);
            max = Math.max(left.max, max);
            size += left.size;
            sum += left.sum;
        }

        if (right != null) {
            min = Math.min(right.min, min);
            max = Math.max(right.max, max);
            size += right.size;
            sum += right.sum;
        }
    }
}

class Splay {
    public Node root;
    private Node[] nodes = new Node[300001];
    private int size;
    Splay (int size) {
        this.size = size;
        for (int i=1;i<=size;i++) {
            nodes[i] = new Node(i);
        }

        for (int i=size;i>1;i--) {
            nodes[i-1].right = nodes[i];
            nodes[i].parent = nodes[i-1];

            nodes[i-1].update();
        }

        root = nodes[1];
    }

    public void propagate(Node a) {
        if (a.reverse) {
            Node temp = a.left;
            a.left = a.right;
            a.right = temp;

            if (a.left != null) {
                a.left.reverse ^= true;
            }

            if (a.right != null) {
                a.right.reverse ^= true;
            }
        }

        a.reverse = false;
    }

    public void rotate (Node a) {
        Node p = a.parent, temp = null;

        propagate(p);
        propagate(a);

        if (p.left == a) {
            temp = p.left = a.right;
            a.right = p;
        } else {
            temp = p.right = a.left;
            a.left = p;
        }

        a.parent = p.parent;
        p.parent = a;

        if (temp != null) {
            temp.parent = p;
        }

        if (a.parent != null) {
            if (a.parent.left == p) {
                a.parent.left = a;
            } else {
                a.parent.right = a;
            }
        } else {
            root = a;
        }

        p.update();
        a.update();
    }

    public void splay (Node a) {
        while(a.parent != null) {
            if(a.parent.parent != null) rotate(((a.parent.parent.left == a.parent) && (a.parent.left == a)) ? a.parent : a);
            rotate(a);
        }
    }

    public void query2 (int left, int right, int k) throws IOException{
        if (left == 1 && right == size) {
            bw.write(root.min+" "+root.max+" "+root.sum+"\n");

        } else if (left == 1) {
            findKth(right + 1, root);
            bw.write(root.left.min +" "+root.left.max+" "+root.left.sum+"\n");

        } else if (right == size) {
            findKth(left-1, root);
            bw.write(root.right.min+" "+root.right.max+" "+root.right.sum+"\n");

        } else {
            findKth(left-1, root);
            Node origin = root;

            root = origin.right;
            root.parent = null;

            findKth(right-left + 2, root);

            Node answer = root.left;

            origin.right = root;
            root.parent = origin;

            root = origin;

            bw.write(answer.min+" "+answer.max+" "+answer.sum+"\n");
        }

        //구간 쉬프트 적용
        shift(left, right, k);
    }

    public void shift (int left, int right, int k) {
        int temp = k;
        k = Math.abs(k);
        k %= right - left + 1;

        if (k == 0) return;

        if (temp > 0) {
            k = right - left + 1 - k;
        }

        reverseRange(left, left+k-1);
        reverseRange(left+k, right);
        reverseRange(left, right);
    }


    public void reverseRange (int left, int right) {
        if (left == right) return;

        if (left == 1 && right == size) {
            root.reverse ^= true;
        } else if (left == 1) {
            findKth(right + 1, root);

            root.left.reverse ^= true;
        } else if (right == size) {
            findKth(left - 1, root);

            root.right.reverse ^= true;
        } else {
            findKth(left-1, root);
            Node origin = root;

            root = origin.right;
            root.parent = null;

            findKth(right-left + 2, root);

            Node answer = root.left;
            answer.reverse ^= true;

            origin.right = root;
            root.parent = origin;

            root = origin;
        }
    }

    public void findKth (int order, Node now) {
        propagate(now);

        if (now.left == null && now.right == null) {
            splay(now);
            return;
        }

        if (now.left == null) {
            if (order == 1) {
                splay(now);
                return;
            }

            findKth(order-1, now.right);
        } else if (now.right == null) {
            if (now.size == order) {
                splay(now);
            } else {
                findKth(order, now.left);
            }
        } else {
            if (now.left.size + 1 == order) {
                splay(now);
                return;
            }

            if (now.left.size < order) {
                findKth(order - now.left.size - 1, now.right);
            } else {
                findKth(order, now.left);
            }
        }
    }

    public int findXOrder (int x) {
        splay(nodes[x]);

        if (nodes[x].left == null) return 1;
        return nodes[x].left.size + 1;
    }

    public void query1 (int left, int right) throws IOException{
        if (left == 1 && right == size) {
            root.reverse ^= true;
            bw.write(root.min+" "+root.max+" "+root.sum+"\n");
        } else if (left == 1) {
            findKth(right + 1, root);
            propagate(root);

            root.left.reverse ^= true;
            bw.write(root.left.min +" "+root.left.max+" "+root.left.sum+"\n");
        } else if (right == size) {
            findKth(left-1, root);

            root.right.reverse ^= true;
            bw.write(root.right.min+" "+root.right.max+" "+root.right.sum+"\n");
        } else {
            findKth(left-1, root);
            Node origin = root;

            root = origin.right;
            root.parent = null;

            findKth(right-left + 2, root);

            Node answer = root.left;
            answer.reverse ^= true;

            origin.right = root;
            root.parent = origin;

            root = origin;

            bw.write(answer.min+" "+answer.max+" "+answer.sum+"\n");
        }
    }

    public void middleOrder (Node node) throws IOException {
        propagate(node);

        if (node.left != null) {
            middleOrder(node.left);
        }

        bw.write(node.value+" ");
        if (node.right!=null) {
            middleOrder(node.right);
        }
    }

    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());
        Splay tree = new Splay(N);

        BufferedWriter bw = tree.bw;
        while(M-->0) {
            st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());

            if (m == 1) {
                int left = Integer.parseInt(st.nextToken()), right = Integer.parseInt(st.nextToken());
                tree.query1(left, right);

//                tree.middleOrder(tree.root);
//                bw.write('\n');
            } else if (m == 2) {
                int left = Integer.parseInt(st.nextToken()), right = Integer.parseInt(st.nextToken());
                int x = Integer.parseInt(st.nextToken());

                tree.query2(left, right, x);

//                tree.middleOrder(tree.root);
//                bw.write('\n');
            } else if (m == 3) {
                tree.findKth(Integer.parseInt(st.nextToken()), tree.root);
                bw.write(tree.root.value+"\n");
            } else {
                bw.write(tree.findXOrder(Integer.parseInt(st.nextToken()))+"\n");
            }

        }
        tree.middleOrder(tree.root);
        bw.write('\n');
        bw.flush();

    }
}
