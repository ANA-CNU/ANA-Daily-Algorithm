package baekjoon2024September;

import java.util.*;
import java.io.*;

public class n1004 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	public static void main(String[] args) throws IOException{
		int t = Integer.parseInt(br.readLine());
		for(int i = 0; i<t; i++) {
			littlePrince();
		}
	}
	
	private static void littlePrince() throws IOException{
		String str = br.readLine();
		String[] arr = str.split(" ");
		
		int x1 = Integer.parseInt(arr[0]);
		int y1 = Integer.parseInt(arr[1]);
		int x2 = Integer.parseInt(arr[2]);
		int y2 = Integer.parseInt(arr[3]);
		
		int n = Integer.parseInt(br.readLine());
		
		int sum = 0;
		for(int i = 0; i<n; i++) {
			str = br.readLine();
			String[] arr2 = str.split(" ");
			
			int cx = Integer.parseInt(arr2[0]);
			int cy = Integer.parseInt(arr2[1]);
			int r = Integer.parseInt(arr2[2]);
			
			if(cal(x1, y1, cx, cy, r) ^ cal(x2, y2, cx, cy, r)) {
				sum++;
				//System.out.println(cx + " " + cy + " " + r);
			}
		}
		
		System.out.println(sum);
	}
	
	private static boolean cal(int x, int y, int cx, int cy, int r) {
		return (x - cx) * (x - cx) + (y - cy) * (y - cy) > r * r;
	}
}
