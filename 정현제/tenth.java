package grap_my_hand;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class tenth {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int total = Integer.parseInt(br.readLine());
		
		ArrayList<Integer>[] list = new ArrayList[total+1];
		int[] parent=new int[total+1];
		
		for(int i=0;i<total+1;i++) {
			list[i]=new ArrayList<Integer>();
		}
		
		for(int i=0;i<total-1;i++) {
			StringTokenizer st=new StringTokenizer(br.readLine()," ");
			int a=Integer.parseInt(st.nextToken());
			int b=Integer.parseInt(st.nextToken());
			
			list[a].add(b);
			list[b].add(a);
		}
		
		dfs(list,parent,total,1,0);
		
		for(int i=2;i<=total;i++) {
			System.out.println(parent[i]);
		}
	}
	public static void dfs(ArrayList<Integer>[] list,int[] parent,int total,int start,int parents) {
		parent[start]=parents;
		for(int item:list[start]) {
			if(item!=parents) {
				dfs(list,parent,total,item,start);
			}
		}
	}

}
