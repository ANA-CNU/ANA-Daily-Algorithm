import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();
        int N = s.length();
        int M = Integer.parseInt(br.readLine());

        Deque<Character> lastqueue = new ArrayDeque<>();
        Deque<Character> firstqueue = new ArrayDeque<>();

        for(int i = 0; i < N; i++){
            lastqueue.offerLast(s.charAt(i));
        }

        while (M --> 0){
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            if(st.countTokens() == 1){
                String ch = st.nextToken();

                if(ch.equals("L")){
                    if(!lastqueue.isEmpty()){
                        char temp = lastqueue.removeLast();
                        firstqueue.addFirst(temp);
                    }
                }else if(ch.equals("D")){
                    if(!firstqueue.isEmpty()){
                        char temp = firstqueue.removeFirst();
                        lastqueue.addLast(temp);
                    }
                }else if(ch.equals("B")){
                    if(!lastqueue.isEmpty()){
                        lastqueue.removeLast();
                    }
                }
            }else{
                String ch = st.nextToken();
                char adding = st.nextToken().charAt(0);

                lastqueue.addLast(adding);
            }
        }
        StringBuilder sb = new StringBuilder();

        int leng = lastqueue.size();
        for(int i = 0; i < leng; i++){
            sb.append(lastqueue.removeFirst());
        }
        leng = firstqueue.size();
        for(int i = 0; i < leng; i++){
            sb.append(firstqueue.removeFirst());
        }
        System.out.println(sb);
    }
}

