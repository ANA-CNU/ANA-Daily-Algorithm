import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        while (T --> 0){
            TreeMap<Integer, Integer> treeMap = new TreeMap<>();

            int cal = Integer.parseInt(br.readLine());

            for(int i = 0; i < cal; i++){
                StringTokenizer st = new StringTokenizer(br.readLine()," ");

                String order = st.nextToken();
                int num = Integer.parseInt(st.nextToken());

                if(order.equals("I")){
                    if(treeMap.containsKey(num)){
                        treeMap.put(num,  treeMap.get(num) + 1);
                    }else{
                        treeMap.put(num, 1);
                    }
                }else{
                   if(!treeMap.isEmpty()){
                        if(num == -1){
                            if(treeMap.get(treeMap.firstKey()) != 1){
                                treeMap.put(treeMap.firstKey(), treeMap.get(treeMap.firstKey()) -1);
                            }else{
                                treeMap.remove(treeMap.firstKey());
                            }
                        }else{
                            if(treeMap.get(treeMap.lastKey()) != 1){
                                treeMap.put(treeMap.lastKey(), treeMap.get(treeMap.lastKey()) -1);
                            }else{
                                treeMap.remove(treeMap.lastKey());
                            }
                        }
                   }
                }
            }
            if(treeMap.isEmpty()){
                sb.append("EMPTY").append('\n');
            }else{
                sb.append(treeMap.lastKey()).append(" ").append(treeMap.firstKey()).append('\n');
            }
        }
        System.out.println(sb);
    }
}
