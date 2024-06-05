package baekjoon2024June;
import java.util.*;
class locate{
	int x, y, z;
	locate(int x, int y, int z){
		this.x = x;
		this.y = y;
		this.z = z;
	}
}
public class n6593 {
	static boolean bfs(int a, int b, int c, char[][][] map) {
		//System.out.println("t");
		
		int start_x = 0;
		int start_y = 0;
		int start_z = 0;
		int end_x = 0;
		int end_y = 0;
		int end_z = 0;
		boolean[][][] visited = new boolean[a+2][b+2][c+2];
		int[][][] result = new int[a+2][b+2][c+2];
		for(int i = 1 ; i<=a ; i++) {
			for(int j = 1; j<=b; j++) {
				for(int k = 1; k<=c; k++) {
					if(map[i][j][k] == 'S') {
						start_x = i;
						start_y = j;
						start_z = k;
					}
					if(map[i][j][k] == 'E') {
						end_x = i;
						end_y = j;
						end_z = k;
					}
				}
			}
		}
		Queue<locate> que = new LinkedList<>();
		locate l = new locate(start_x, start_y, start_z);
		que.offer(l);
		while(!que.isEmpty()) {
			int[][] dirs = {{0, 0, 1}, {0, 0, -1}, {0, 1, 0}, {0, -1, 0}, {1, 0, 0}, {-1, 0, 0}}; 
			locate here = que.poll();
			int x = here.x;
			int y = here.y;
			int z = here.z;
			for(int[] dir : dirs) {
				int tx = x + dir[0];
				int ty = y + dir[1];
				int tz = z + dir[2];
				if((map[tx][ty][tz] == '.'|| map[tx][ty][tz] == 'E') && !visited[tx][ty][tz]) {
					visited[tx][ty][tz] = true;
					que.offer(new locate(tx, ty, tz));
					result[tx][ty][tz] = result[x][y][z] +1;
				}
			}	
		}
		if(result[end_x][end_y][end_z] !=0) System.out.println("Escaped in "+result[end_x][end_y][end_z]+" minute(s).");
		else System.out.println("Trapped!");
		return false;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int I = 0;
		char[][][][] map = new char[10][32][32][32];
		int[] a = new int[10];
		int[] b = new int[10];
		int[] c = new int[10];
		while(true) {
			I++;
			a[I] = sc.nextInt();
			b[I] = sc.nextInt();
			c[I] = sc.nextInt();
			sc.nextLine();
			if(a[I] == 0 && b[I]==0 && c[I]==0) {
				break;
			}
			for(int i = 1 ; i<=a[I] ; i++) {
				for(int j = 1; j<=b[I]; j++) {
					String str = sc.nextLine();
					for(int k = 1; k<=c[I]; k++) {
						map[I][i][j][k] = str.charAt(k-1);
					}
				}
				if(i != a[I])sc.nextLine();
			}
		}
		for(int i = 1; i<I; i++) {
			bfs(a[i], b[i], c[i], map[i]);
		}
	}
	
}
