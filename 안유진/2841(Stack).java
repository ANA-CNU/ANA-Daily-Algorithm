import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Stack<Integer>[] stack = new Stack[7];

        for(int i = 1; i < 7; i++){
            stack[i] = new Stack<>();
        }

        int count = 0;

        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken());

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine()," ");
            int str = Integer.parseInt(st.nextToken());
            int prat = Integer.parseInt(st.nextToken());

            if(stack[str].isEmpty()){
                count++;
                stack[str].add(prat);
            }else{
                int temp = stack[str].peek();
                if(temp < prat){
                    stack[str].add(prat);
                    count++;
                }else if(temp > prat){
                    while (!stack[str].isEmpty()){
                        temp = stack[str].peek();
                        if(temp <= prat){
                            break;
                        }
                        stack[str].pop();
                        count++;
                    }
                    if(stack[str].isEmpty() || stack[str].peek() != prat){
                        stack[str].add(prat);
                        count++;
                    }
                }
            }
        }
        System.out.println(count);
    }
}
