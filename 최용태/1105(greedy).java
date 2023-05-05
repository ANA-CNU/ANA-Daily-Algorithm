import java.io.*;
import java.util.*;
import java.util.stream.IntStream;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer s=new StringTokenizer(br.readLine()," ");

        String src1=s.nextToken();
        String src2=s.nextToken();
        int l=Integer.parseInt(src1);
        int gap=Integer.parseInt(src2)-l;
        String modifyRange=String.valueOf(gap);

        if(gap==0) modifyRange="";

        long countL =
                IntStream.range(0, src1.length() - modifyRange.length()).filter(i -> src1.charAt(i) == '8').count();
        long countR =
                IntStream.range(0, src2.length() - modifyRange.length()).filter(i -> src2.charAt(i) == '8').count();



        System.out.println(Math.min(countL,countR));

    }
}