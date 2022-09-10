import java.io.*;
import java.util.HashMap;
import java.util.StringTokenizer;

public class baek17219 {
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        HashMap<String,String> hashMa = new HashMap<>();

        for(int i=0;i<a;i++){
            st= new StringTokenizer(br.readLine());
            String url = st.nextToken();
            String pw = st.nextToken();
            hashMa.put(url,pw);
        }
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for(int i=0;i<b;i++){
            String input = br.readLine();
            bw.write(hashMa.get(input)+"\n");
        }
        bw.flush();
    }
}
