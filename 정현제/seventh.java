package grap_my_hand;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class seventh {



	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int total=Integer.parseInt(br.readLine());
		PriorityQueue<Point> pq = new PriorityQueue<Point>();

		for(int i=0;i<total;i++) {
			int num=Integer.parseInt(br.readLine());
			if(num==0) {
				if(pq.size()!=0) {
					System.out.println(pq.poll().x);
				}
				else {
					System.out.println(0);
				}
			}
			else {
				pq.add(new Point(num,Math.abs(num)));
			}

		}

	}


	static class Point implements Comparable<Point>{
		int x,y;
		public Point(int x,int y) {
			this.x=x;
			this.y=y;
		}
		@Override
		public int compareTo(Point o) {
			if(this.y==o.y) {
				return this.x-o.x;
			}
			return this.y-o.y;
		}
	}
}
