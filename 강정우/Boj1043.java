import java.io.*;
import java.util.*;
public class Boj1043 {
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()), m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int true_people = Integer.parseInt(st.nextToken());
        Set<Integer> true_people_set = new HashSet<>();
        if(true_people != 0){
            for(int i = 0; i < true_people; i++){
                true_people_set.add(Integer.parseInt(st.nextToken()));
            }
        }
        List<HashSet<Integer>> party_list = new ArrayList<>();
        List<HashSet<Integer>>list= new ArrayList<>();
        for(int i = 0; i <= n; i++){
            list.add(new HashSet<>());
        }
        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int party_people = Integer.parseInt(st.nextToken());
            HashSet<Integer> party_people_set = new HashSet<>();
            for(int j = 0; j < party_people; j++){
                party_people_set.add(Integer.parseInt(st.nextToken()));
            }
            party_list.add(party_people_set);
            for(int j=0;j< party_people_set.size();j++) {
                for (int k = 0; k < party_people_set.size(); k++) {
                    if (j == k) continue;
                    ArrayList<Integer> temp = new ArrayList<>(party_people_set);
                    list.get(temp.get(j)).add(temp.get(k));
                }
            }
        }if(true_people == 0){
            System.out.println(m);
            return;
        }
        Queue<Integer> queue = new LinkedList<>();
        for(int i : true_people_set){
            queue.add(i);
        }
        while(!queue.isEmpty()){
            int cur = queue.poll();
            for(int next : list.get(cur)){
                if(!true_people_set.contains(next)){
                    true_people_set.add(next);
                    queue.add(next);
                }
            }
        }
        int result=0;
        for(Set<Integer> party : party_list){
            party.retainAll(true_people_set);
            if(party.isEmpty()){
                result++;
            }
        }
        System.out.println(result);
    }
}
