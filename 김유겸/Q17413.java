package _2022_1학기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Q17413 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        List<String> arr = new ArrayList<>();
        arr.addAll(Arrays.stream(br.readLine().split("")).collect(Collectors.toList()));
        StringBuilder sb = new StringBuilder();

        Stack<String> stack = new Stack<>();
        boolean inRange = false;
        for (int i = 0; i < arr.size(); i++) {
            if (arr.get(i).equals("<")) {
                while (!stack.isEmpty()) {
                    sb.append(stack.pop());
                }
                sb.append("<");
                inRange = true;
            } else if (arr.get(i).equals(">")) {
                inRange = false;
                sb.append(arr.get(i));
            } else {
                if (inRange) {
                    sb.append(arr.get(i));
                } else if (!inRange) {
                    if(arr.get(i).equals(" ")){
                        while (!stack.isEmpty()) {
                            sb.append(stack.pop());
                        }
                        sb.append(" ");
                    }else stack.push(arr.get(i));
                }
            }
        }
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        System.out.println(sb);
    }
}
