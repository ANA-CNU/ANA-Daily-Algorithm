import java.util.*;
import java.io.*;

public class Solution{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int wLeng = Integer.parseInt(st.nextToken());
        int sLeng = Integer.parseInt(st.nextToken());

        int warr[] = new int[60];
        int sarr[] = new int[60];

        String w = br.readLine();
        String s = br.readLine();

        for(int i = 0; i < wLeng; i++) {
            char temp = w.charAt(i);
            warr[temp - 65]++;
        }

        int count = 0;
        int start = 0;
        int end = -1;
        int currentLeng = 0;

        while (end < sLeng) {
            end++;
            char current = s.charAt(end);

            if(warr[current - 65] == 0) {
                currentLeng = 0;

                for(int j = start; j <= end; j++) {
                    sarr[s.charAt(j) - 65] = 0;
                }

                start = end + 1;
                continue;
            }

            sarr[current - 65]++;
            if(sarr[current - 65] <= warr[current - 65]) {
                currentLeng++;
            }else{
                sarr[s.charAt(start) - 65]--;
                start++;
            }


            if(currentLeng == wLeng) {
                boolean flag = true;
                for(int i = 0; i < 60; i++) {
                    if(sarr[i] != warr[i]){
                        flag = false;
                    }
                }
                if(flag) {
                    count++;
                }

                sarr[s.charAt(start) - 65]--;
                start++;
                currentLeng--;
            }
        }

        System.out.println(count);
    }
}
