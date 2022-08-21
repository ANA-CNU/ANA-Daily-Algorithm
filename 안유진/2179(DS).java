import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.List;

class dic implements Comparable<String>{
    String name;

    public dic(String name){
        this.name = name;
    }
    @Override
    public int compareTo(String s){
        return name.compareTo(s);
    }
}
public class Main {
    static int max = 0;
    public static int compare(String a, String b){
        int count = 0;

        for(int i = 0; i < Math.min(a.length(),  b.length()); i++){
            if(a.charAt(i) == b.charAt(i)){
                count++;
            }else{
                break;
            }
        }
        if(a.length() == b.length() && count == a.length()){
            count = 0;
        }
        if(count > max){
            max = count;
        }
        return count;
    }
    public static void main(String[] args) throws IOException {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       StringBuilder sb = new StringBuilder();

       int N = Integer.parseInt(br.readLine());
       HashMap<String, Integer> hashMap = new HashMap<>();
       List<String> list = new ArrayList<>();

       for(int i = 0; i < N; i++){
           String s = br.readLine();
           if(!hashMap.containsKey(s)){
               hashMap.put(s, i);
           }
           list.add(s);
       }

        if(N == 2){
            for(String s : list){
                sb.append(s).append('\n');
            }
            System.out.println(sb);
            System.exit(0);
        }

       Collections.sort(list);

       int comp[] = new int[N];

       for(int i = 0; i < N-1; i++){
           comp[i] = compare(list.get(i), list.get(i+1));
       }

       int min = Integer.MAX_VALUE;
       String same = "";

       String temp[] = new String[N];

       if(max == 0){
           String first = "";
           String second = " ";
           for(String s : hashMap.keySet()){
               if(hashMap.get(s) == 0){
                   first = s;
               }else if(hashMap.get(s) == 1){
                   second = s;
               }
           }
           System.out.println(first);
           System.out.println(second);
           System.exit(0);
       }

       for(int i = 0; i < N-1; i++){
           if(comp[i] == max){
                int currentmin = Math.min(hashMap.get(list.get(i)), hashMap.get(list.get(i+1)));
                if(min > currentmin){
                    sb = new StringBuilder();
                    min = currentmin;

                    for(int j = 0; j < max; j++){
                        String s = list.get(i);
                        sb.append(s.charAt(j));
                    }
                    same = String.valueOf(sb);
                }
           }
       }
       //S가 여러개일때 가장 작은값을가진 접두사를 알아냄
        int index = 0;
        for(String s : list){
            int check = 0;
            if(s.length() >= max){
                for(int i = 0; i < max; i++){
                    char ch = same.charAt(i);
                    char ch2 = s.charAt(i);
                    if(ch == ch2){
                        check++;
                    }
                }
                if(check == max){
                    temp[index] = s;
                    index++;
                }
            }
        }
        for(int i = 1; i < index; i++){
            for(int j = 0; j < index-i; j++){
                if(hashMap.get(temp[j]) > hashMap.get(temp[j+1])){
                    String change = temp[j];
                    temp[j] = temp[j+1];
                    temp[j+1] = change;
                }
            }
        }

        System.out.println(temp[0]);
        System.out.println(temp[1]);
    }
}

