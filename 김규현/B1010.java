import java.io.*;

public class B1010 {
    static int [][] sheet = new int[30][30];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int j = 1; j <= n; j++) {

            String [] c = br.readLine().split(" ");

            int m = Integer.parseInt(c[0]);
            int p = Integer.parseInt(c[1]);

            sb.append(comb(p,m)+"\n");
        }
        System.out.println(sb);
    }

    static int comb (int n, int r){
        if(sheet[n][r] > 0){
            return sheet[n][r];
        }
        if(n == r || r == 0){
            return sheet[n][r] = 1;
        }

        return sheet[n][r] = comb(n-1, r-1) + comb(n-1, r);

    }
}

