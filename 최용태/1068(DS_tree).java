import java.util.Scanner;

public class Main {
	static int leaf = 0;

	public static void search(Node currentNode,int size) {
		int childValue=currentNode.hasChild;
		if (childValue>0) {
			for(int i=0;i<childValue;i++)
					search(currentNode.child[i],size);
		} else if (childValue==0)
			leaf--;
	}

	public static class Node {
		public int parent;
		public Node[] child;
		public int hasChild;

		public Node(int nparent, int size) {
			this.parent = nparent;
			this.child = new Node[size];
			this.hasChild = 0;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		Node[] TreeNode = new Node[N];

		for (int i = 0; i < N; i++)
			TreeNode[i] = new Node(-1, N); // 트리노드 객체 생성, Node배열 child 선언, child는 전부 null

		for (int i = 0; i < N; i++) {
			int iParent = sc.nextInt();
			if (iParent == -1)
				leaf++;
			else {
				int childValue=TreeNode[iParent].hasChild;
				if (childValue>0)
					leaf++;
				TreeNode[iParent].child[childValue] = TreeNode[i];
				TreeNode[iParent].hasChild++;
				TreeNode[i].parent = iParent;
			}
		}

		int D = sc.nextInt();
		search(TreeNode[D],N);
		int prt = TreeNode[D].parent;

		if (prt > -1) {
			TreeNode[prt].hasChild--;
			if (TreeNode[prt].hasChild == 0)
				System.out.println(leaf + 1);
			else
				System.out.println(leaf);
		} else
			System.out.println(leaf);

	}
}