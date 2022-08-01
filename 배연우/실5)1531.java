import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br;
    static StringTokenizer st;
    static int[][] field = new int[100][100];

    public static void main(String[] Args) throws IOException {
        //init
        br = new BufferedReader(new InputStreamReader(System.in));
        //input
        getSt();
        int n = stoi();
        int m = stoi();
        int[][] paper = new int[n][4];

        for (int i = 0; i < n; i++) {
            getSt();
            for (int j = 0; j < 4; j++) {
                paper[i][j] = stoi()-1;
            }
        }

        //calculate (simulate)
        for (int i = 0; i < n; i++) {
            for (int j = paper[i][0]; j <= paper[i][2]; j++) {
                for (int k = paper[i][1]; k <= paper[i][3] ; k++) {
                    field[j][k]++;
                }
            }
        }

        //getOutput
        int ret = 0;
        for(int[] i : field) {
            for(int j : i) {
                if(j > m)
                    ret++;
            }
        }

        //output
        System.out.println(ret);
    }

    static void getSt() throws IOException {
        st = new StringTokenizer(br.readLine());
    }

    static int stoi() {
        return Integer.parseInt(st.nextToken());
    }
}