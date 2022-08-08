import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

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
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        HashMap<String, Integer> hashMap = new HashMap<>();

        int max = 1;
        for(int i = 0; i < N; i++){
            String name = br.readLine();
            if(!hashMap.containsKey(name)){
                hashMap.put(name, 1);
            }else{
                hashMap.put(name, hashMap.get(name) + 1);
                if(hashMap.get(name) > max){
                    max = hashMap.get(name);
                }
            }
        }
        ArrayList<String>arrayList = new ArrayList<>();
        for(String temp : hashMap.keySet()){
            if(hashMap.get(temp) == max){
                arrayList.add(temp);
            }
        }
        Collections.sort(arrayList);
        System.out.println(arrayList.get(0));
    }
}
