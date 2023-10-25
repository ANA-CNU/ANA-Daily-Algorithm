import java.util.*;
import java.io.*;

public class BOJ1655 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Integer> nums_large = new PriorityQueue<>();
        PriorityQueue<Integer> nums_small = new PriorityQueue<>(Collections.reverseOrder());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int num;
        for (int i = 0; i < N; i++) {
            if (i < 1) {
                num = Integer.parseInt(br.readLine());
                nums_small.add(num);
            } else {
                if (Math.abs(nums_small.size() - nums_large.size()) < 1 ) {
                    num = Integer.parseInt(br.readLine());
                    if (nums_small.peek() >= num) {
                        nums_small.add(num);
                    } else {
                        nums_large.add(num);
                    }
                } else {
                    num = Integer.parseInt(br.readLine());
                    if (nums_small.size() > nums_large.size()) {
                        if (nums_small.peek() >= num) {
                            nums_large.add(nums_small.poll());
                            nums_small.add(num);
                        } else {
                            nums_large.add(num);
                        }
                    } else {
                        if (nums_large.peek() <= num) {
                            nums_small.add(nums_large.poll());
                            nums_large.add(num);
                        } else {
                            nums_small.add(num);
                        }
                    }
                }
            }
            if ((nums_small.size()+nums_large.size())%2 == 0) {
                sb.append(Math.min(nums_small.peek(),nums_large.peek())).append("\n");
            } else {
                if (nums_small.size() > nums_large.size()) {
                    sb.append(nums_small.peek()).append("\n");
                } else {
                    sb.append(nums_large.peek()).append("\n");
                }
            }
        }
        System.out.println(sb);
    }
}