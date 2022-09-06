import java.io.*;
import java.util.StringTokenizer;

public class S5_2869 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int go = Integer.parseInt(st.nextToken());
        int back = Integer.parseInt(st.nextToken());

        int goal = Integer.parseInt(st.nextToken());

        double an = (double)(goal - back)/(go - back);

        if(an == (int)an) bw.write((int)an + "");
        else bw.write((int)an+1 + "");

        bw.flush();
        bw.close();



    }
}
