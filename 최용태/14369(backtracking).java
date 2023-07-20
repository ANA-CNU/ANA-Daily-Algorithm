import java.util.*;
import java.io.*;
import java.util.stream.IntStream;


public class Main {
    static ArrayList<ArrayList<Character>> resource=new ArrayList<>();
    static String ANS;

    public static int idx(char c){
        return c-'A';
    }

    public static void search(Stack<Integer> string, int[] words){
        if(Arrays.stream(words).filter(W->W!=0).findAny().isEmpty()){
            StringBuilder writer=new StringBuilder();
            string.forEach(writer::append);
            ANS=writer.reverse().toString();
        }else {
            for (int i = 0; i < resource.size(); i++) {
                resource.get(i).forEach(C -> words[idx(C)]--);
                if(Arrays.stream(words).filter(W->W<0).findAny().isEmpty()) {
                    string.push(i);
                    search(string, words);
                    string.pop();
                }
                resource.get(i).forEach(C -> words[idx(C)]++);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N=Integer.parseInt(br.readLine());

        IntStream.range(0,10).forEach(i->resource.add(new ArrayList<>()));

        resource.get(0).addAll(Arrays.asList('Z','E','R','O'));
        resource.get(1).addAll(Arrays.asList('O','N','E'));
        resource.get(2).addAll(Arrays.asList('T','W','O'));
        resource.get(3).addAll(Arrays.asList('T','H','R','E','E'));
        resource.get(4).addAll(Arrays.asList('F','O','U','R'));
        resource.get(5).addAll(Arrays.asList('F','I','V','E'));
        resource.get(6).addAll(Arrays.asList('S','I','X'));
        resource.get(7).addAll(Arrays.asList('S','E','V','E','N'));
        resource.get(8).addAll(Arrays.asList('E','I','G','H','T'));
        resource.get(9).addAll(Arrays.asList('N','I','N','E'));

        StringBuilder sb=new StringBuilder();

        for(int i=1;i<N+1;i++){
            String str=br.readLine();
            int[] words=new int['Z'-'A'+1];
            IntStream.range(0,str.length()).forEach(x->words[idx(str.charAt(x))]++);
            search(new Stack<>(),words);
            sb.append(String.format("Case #%d: ",i)).append(ANS).append("\n");
        }

        System.out.println(sb);
    }
}