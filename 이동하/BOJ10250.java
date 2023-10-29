import java.util.*;
import java.io.*;

public class BOJ10250 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int Floors = Integer.parseInt(st.nextToken());
            int Rooms = Integer.parseInt(st.nextToken());
            int Guests = Integer.parseInt(st.nextToken());
            int index_F = Guests%Floors;
            if (index_F == 0) index_F = Floors;
            int index_R = Guests/Floors;
            if (Guests%Floors == 0) index_R = Guests/Floors;
            else index_R++;
            int result = (index_F*100) + index_R;
            System.out.println(result);
        }
    }
}