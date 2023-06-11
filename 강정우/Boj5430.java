import java.io.*;
import java.util.*;

public class Boj5430 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            char[] p = br.readLine().toCharArray();
            int n = Integer.parseInt(br.readLine());
            String s = br.readLine();
            String s1 = s.substring(1, s.length() - 1);

            String[] splitStr = s1.isEmpty() ? new String[0] : s1.split(",");
            int[] arr1 = new int[splitStr.length];

            for (int j = 0; j < splitStr.length; j++) {
                arr1[j] = Integer.parseInt(splitStr[j].trim());
            }

            Deque<Integer> deq = new LinkedList<Integer>();
            for (int j = 0; j < n; j++) {
                deq.offer(arr1[j]);
            }

            int direction = 1;
            boolean error = false;
            for (char command : p) {
                if (command == 'R') {
                    direction *= -1;
                } else if (command == 'D') {
                    if (!deq.isEmpty()) {
                        if (direction == 1) {
                            deq.pollFirst();
                        } else {
                            deq.pollLast();
                        }
                    } else {
                        error = true;
                        break;
                    }
                }
            }

            if (error) {
                bw.write("error\n");
            } else {
                bw.write("[");
                if (!deq.isEmpty()) {
                    if (direction == 1) {
                        bw.write(deq.pollFirst().toString());
                        while (!deq.isEmpty()) {
                            bw.write(",");
                            bw.write(deq.pollFirst().toString());
                        }
                    } else {
                        bw.write(deq.pollLast().toString());
                        while (!deq.isEmpty()) {
                            bw.write(",");
                            bw.write(deq.pollLast().toString());
                        }
                    }
                }
                bw.write("]\n");
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
