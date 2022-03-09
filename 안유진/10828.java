import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        Stack<Integer> stack = new Stack<>();

        int N = Integer.parseInt(br.readLine());

        for(int i = 0; i<N; i++){
            String s = br.readLine();
            StringTokenizer st = new StringTokenizer(s," ");

            String comm = st.nextToken();

            if(st.hasMoreTokens()){
                int num = Integer.parseInt(st.nextToken());
                stack.push(num);
            }

            if(comm.equals("pop")){
                if(stack.empty()){
                    System.out.println(-1);
                }else{
                    System.out.println(stack.pop());
                }
            }

            if(comm.equals("size")){
                System.out.println(stack.size());
            }

            if(comm.equals("empty")){
                if(stack.empty()){
                    System.out.println(1);
                }else {
                    System.out.println(0);
                }
            }

            if(comm.equals("top")){
                if(stack.empty()){
                    System.out.println(-1);
                }else{
                    System.out.println(stack.lastElement());
                }
            }

        }
    }
}
