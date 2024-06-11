package baekjoon2024June;
import java.io.*;
import java.util.*;

public class m17114{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int num = 0;
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int o = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());
        int u = Integer.parseInt(st.nextToken());
        int v = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        
        Queue<int[]> que = new LinkedList<>();
        boolean[][][][][][][][][][][] visited = new boolean[m][n][o][p][q][r][s][t][u][v][w];

        for (int i1 = 0; i1 < w; i1++) {
            for (int i2 = 0; i2 < v; i2++) {
                for (int i3 = 0; i3 < u; i3++) {
                    for (int i4 = 0; i4 < t; i4++) {
                        for (int i5 = 0; i5 < s; i5++) {
                            for (int i6 = 0; i6 < r; i6++) {
                                for (int i7 = 0; i7 < q; i7++) {
                                    for (int i8 = 0; i8 < p; i8++) {
                                        for (int i9 = 0; i9 < o; i9++) {
                                            for (int i10 = 0; i10 < n; i10++) {
                                                String str = br.readLine();
                                                String[] arr = str.split(" ");
                                                for (int j = 0; j < m; j++) {
                                                    int value = Integer.parseInt(arr[j]);
                                                    if (value == 1) {
                                                        int[] node = {j, i10, i9, i8, i7, i6, i5, i4, i3, i2, i1};
                                                        que.offer(node);
                                                        visited[j][i10][i9][i8][i7][i6][i5][i4][i3][i2][i1] = true;
                                                        num++;
                                                    } else if(value == -1) {
                                                        visited[j][i10][i9][i8][i7][i6][i5][i4][i3][i2][i1] = true;
                                                        num++;
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        
        int[][] dirs = {
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {-1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}
        };

        int max = 0;
        Queue<int[]> que2 = new LinkedList<>();
        while (!que.isEmpty()) {
        	while(!que.isEmpty()) {
        		que2.offer(que.poll());
        	}
        	max++;
        	while(!que2.isEmpty()) {
        		int[] node = que2.poll();
        		for (int[] dir : dirs) {
        			int there_m = node[0] + dir[0];
        			int there_n = node[1] + dir[1];
        			int there_o = node[2] + dir[2];
        			int there_p = node[3] + dir[3];
        			int there_q = node[4] + dir[4];
        			int there_r = node[5] + dir[5];
        			int there_s = node[6] + dir[6];
        			int there_t = node[7] + dir[7];
        			int there_u = node[8] + dir[8];
        			int there_v = node[9] + dir[9];
        			int there_w = node[10] + dir[10];
        			
        			if (0 <= there_m && there_m < m &&
        					0 <= there_n && there_n < n &&
        					0 <= there_o && there_o < o &&
        					0 <= there_p && there_p < p &&
        					0 <= there_q && there_q < q &&
        					0 <= there_r && there_r < r &&
        					0 <= there_s && there_s < s &&
        					0 <= there_t && there_t < t &&
        					0 <= there_u && there_u < u &&
        					0 <= there_v && there_v < v &&
        					0 <= there_w && there_w < w) {
        				
        				if (!visited[there_m][there_n][there_o][there_p][there_q][there_r][there_s][there_t][there_u][there_v][there_w]) {
        					visited[there_m][there_n][there_o][there_p][there_q][there_r][there_s][there_t][there_u][there_v][there_w] = true;
        					int[] no = {there_m, there_n, there_o, there_p, there_q, there_r, there_s, there_t, there_u, there_v, there_w};
        					que.offer(no);
        					num++;
        				}
        			}
        		}
        	}
        }
        
        if (num == m * n * o * p * q * r * s * t * u * v * w) System.out.println(max -1);
        else System.out.println(-1);
    }
}
