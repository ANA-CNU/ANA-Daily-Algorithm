import java.util.Scanner;

public class Main {
	static int leaf = 0;

	public static void preorder(Node currentNode) {
		if(currentNode!=null) {
			System.out.print(currentNode.A);
			preorder(currentNode.left);
			preorder(currentNode.right);
		}
	}
	public static void inorder(Node currentNode) {
		if(currentNode!=null) {
			inorder(currentNode.left);
			System.out.print(currentNode.A);
			inorder(currentNode.right);
		}
	}
	public static void postorder(Node currentNode) {
		if(currentNode!=null) {
			postorder(currentNode.left);
			postorder(currentNode.right);
			System.out.print(currentNode.A);
		}
	}

	public static class Node {
		char A;
		Node left;
		Node right;

		public Node(char input) {
			A = input;
			left = null;
			right = null;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		char[] order = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', // SIZE 26(0~25)
				'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S','T','U','V', 'W', 'X', 'Y', 'Z' };
		Node[] TreeNode = new Node[N];

		for (int j = 0; j < N; j++)
			TreeNode[j] = new Node(order[j]);

		for (int j = 0; j < N; j++) {
			int node=0;
			for (int i = 0; i < 3; i++) {
				char input = sc.next().charAt(0);
				int selected = 0;
				if (input == '.')
					continue;
				else {
					switch (i) {
					case 0:
						for (int z = 0; z < N; z++) {
							if (input == order[z]) {
								node = z;
								break;
							}
						}
						break;
					case 1:
						for (int z = 0; z < N; z++) {
							if (input == order[z]) {
								selected = z;
								break;
							}
						}
						TreeNode[node].left = TreeNode[selected];
						break;
					case 2:
						for (int z = 0; z < N; z++) {
							if (input == order[z]) {
								selected = z;
								break;
							}
						}
						TreeNode[node].right = TreeNode[selected];
						break;
					default:
						break;
					}
				}
			}
		}

				preorder(TreeNode[0]);
				System.out.println("");
				inorder(TreeNode[0]);
				System.out.println("");
				postorder(TreeNode[0]);
		}

	}