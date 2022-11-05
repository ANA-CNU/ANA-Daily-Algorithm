import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Hashtable<String, Integer> hashtable = new Hashtable<>();

        for(int i = 0; i < N; i++){
            String s = br.readLine();

            if(s.length() < M){
                continue;
            }

            if(!hashtable.containsKey(s)){
                hashtable.put(s, 1);
            }else{
                hashtable.put(s, hashtable.get(s) + 1);
            }
        } //input end

        ArrayList<Pair> arrayList = new ArrayList<>();

        for(String temp : hashtable.keySet()){
            arrayList.add(new Pair(temp, hashtable.get(temp)));
        }

        Collections.sort(arrayList, new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                if(o1.count != o2.count){
                    return o2.count - o1.count;
                }

                if(o1.word.length() != o2.word.length()){
                    return o2.word.length() - o1.word.length();
                }

                return o1.word.compareTo(o2.word);
            }
        });

        for(Pair p : arrayList){
            sb.append(p.word).append('\n');
        }
        System.out.println(sb);
    }
}
class Pair{
    String word;
    int count;

    Pair(String w, int c){
        word = w;
        count = c;
    }
}
