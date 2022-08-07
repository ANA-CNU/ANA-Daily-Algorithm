import java.io.*;
import java.util.*;

public class Main {
	
	public static class NodeType{
		int value;
		NodeType left;
		NodeType right;
		
		NodeType(int v){
			value=v;
			left=null;
			right=null;
		}
		
		void setLeft(NodeType newNode) {
			left=newNode;
		}
		void setRight(NodeType newNode) {
			right=newNode;
		}
	}
	
	public static class TreeType{
		NodeType root=null;
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		void push(int item) {
			NodeType currentNode=root;
			NodeType parent=currentNode;
			if(root==null) {
				root=new NodeType(item);
				return;
			}
				
			while(currentNode!=null) {
				if(currentNode.value>item) {
					parent=currentNode;
					currentNode=currentNode.left;
					if(currentNode==null) {
						parent.setLeft(new NodeType(item));
						return;
					}
				}
				else if(currentNode.value<item) {
					parent=currentNode;
					currentNode=currentNode.right;
					if(currentNode==null) {
						parent.setRight(new NodeType(item));
						return;
					}
				}
			}
			
		}
		
		void postorder(NodeType root) throws IOException {
			if(root!=null) {
				postorder(root.left);
				postorder(root.right);
				bw.write(root.value+"\n");
			}
		}
		
		void printTree() throws IOException {
			postorder(root);
			bw.flush();
		}
	}
	
	
	public static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String num=br.readLine();
		TreeType t=new TreeType();
		while(num.length()>0) {
			int newValue=Integer.parseInt(num);
			t.push(newValue);
			num=br.readLine();
			if(num==null)
				break;
		}
		
		t.printTree();
	}
	
	public static void run() throws IOException {
		input();
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		run();
	}
}