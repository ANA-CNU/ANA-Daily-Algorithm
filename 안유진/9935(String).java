import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        String input = br.readLine();
        String bomb = br.readLine();

        ArrayList<Character> arrayList = new ArrayList<>();

        for(int i = 0; i < input.length(); i++){
            arrayList.add(input.charAt(i));

            if(arrayList.size() >= bomb.length()){
                boolean flag = true;
                int index = arrayList.size() - 1;
                for(int j = bomb.length() - 1; j >= 0; j--){
                    if(arrayList.get(index) != bomb.charAt(j)){
                        flag = false;
                        break;
                    }
                    index--;
                }

                if(flag){
                    index = arrayList.size() - 1;
                    for(int j = 0; j < bomb.length(); j++){
                        arrayList.remove(index);
                        index = arrayList.size() - 1;
                    }
                }
            }
        }

        for(char ch : arrayList){
            sb.append(ch);
        }

        if(sb.length() == 0){
            System.out.println("FRULA");
        }else{
            System.out.println(sb);
        }
    }
}
