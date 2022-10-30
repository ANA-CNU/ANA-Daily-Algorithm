import java.io.*;
import java.util.*;

public class Second {
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = "";

        HashMap<String, ArrayList<String>> hashMap = new HashMap<>();
        while ((input = br.readLine()) != null){
            char temp[] = input.toCharArray();

            Arrays.sort(temp);
            String s = Arrays.toString(temp);

            if(hashMap.containsKey(s)){
                hashMap.get(s).add(input);
            } else {
                hashMap.put(s, new ArrayList<>());
                hashMap.get(s).add(input);
            }
        }

        List<String> list = new ArrayList<>(hashMap.keySet());
        //모든 key set을 입력받은 후 hashmap의 원소를 기준으로 정렬해줄꺼임

        for(String s : hashMap.keySet()){
            Collections.sort(hashMap.get(s));
        }

        Collections.sort(list, new Comparator<>() {
            @Override
            public int compare(String o1, String o2) {
                if (hashMap.get(o1).size() == hashMap.get(o2).size()) {
                    String first = hashMap.get(o1).get(0);
                    String second = hashMap.get(o2).get(0);

                    return first.compareTo(second);
                } else {
                    return hashMap.get(o2).size() - hashMap.get(o1).size();
                }
            }
        });

        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < Math.min(list.size(), 5); i++) {
            String s = list.get(i);
            sb.append("Group of size ").append(hashMap.get(s).size()).append(": ");

            HashSet<String> hashSet = new HashSet<>(hashMap.get(s));
            List<String> output = new ArrayList<>(hashSet);

            Collections.sort(output);
            for(String temp : output){
                sb.append(temp).append(" ");
            }

            sb.append(".").append('\n');
        }
        System.out.println(sb);
    }
}
