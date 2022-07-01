import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] Args) throws IOException {
        int tar = Integer.parseInt(new BufferedReader(new InputStreamReader(System.in)).readLine());
        int n2 = 2;
        int tmp = 0;
        int cnt = 0;
        while(tar > tmp) {
            tmp += n2;
            n2 += n2;
            cnt++;
        }

        tmp = (int) Math.pow(2, cnt);
        tar -= tmp - 1;
        String ret = Integer.toBinaryString(tar);
        StringBuilder sb = new StringBuilder();
        int len = ret.length();
        for(int i = 0; i < cnt - len; i++) {
            sb.append(0);
        }
        ret = sb.toString() + ret;
        ret = ret.replaceAll("0", "4");
        ret = ret.replace("1","7");
        System.out.println(ret);
    }
}