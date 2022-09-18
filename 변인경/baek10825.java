import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class baek10825 {
    public static class Person1{
        String name= null ;
        int Korean;
        int English;
        int Math;
        public Person1(String name, int korean,int english,int math){
            this.name = name;
            this.Korean = korean;
            this.English = english;
            this.Math = math;
        }
        public String toString(){
            return name+"\n";
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int input = Integer.parseInt(br.readLine());

        Person1[] p = new Person1[input];

        for(int i =0;i<input;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            String name = st.nextToken();
            int Korean = Integer.parseInt(st.nextToken());
            int English = Integer.parseInt(st.nextToken());
            int Math = Integer.parseInt(st.nextToken());
            p[i] = new Person1(name,Korean,English,Math);

        }
        Arrays.sort(p, new Comparator<Person1>() {
            @Override
            public int compare(Person1 o1, Person1 o2) {
                if(o2.Korean-o1.Korean==0){
                    if(o1.English-o2.English==0){
                        if(o2.Math-o1.Math ==0){
                            return o1.name.compareTo(o2.name);
                        }else{
                            return o2.Math-o1.Math;
                        }
                    }
                    else{
                        return o1.English-o2.English;
                    }
                }
                else{
                    return o2.Korean-o1.Korean;
                }
            }
        });

        StringBuilder sb = new StringBuilder();
        for(int i=0;i<input;i++){
            sb.append(p[i]);
        }
        System.out.println(sb);

    }
}
