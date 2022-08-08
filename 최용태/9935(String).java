import java.util.*;
import java.io.*;

public class Main {
    public static int size;
    public static String BOOM;
    public static char[] STR;
    public static int limit=0;
    public static Stack s;

    public static class Stack{
        int top=-1;
        char data[];
        int MAX_TOP;
        Stack(int size){
            data=new char[size];
        }
        void push(char i){
            data[++top]=i;
        }
        char pop(){
            if(isEmpty())
                return '.';
            else
                return data[top--];
        }
        boolean isEmpty(){
            return (top==-1);
        }
    }

    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        STR=br.readLine().toCharArray();
        size=STR.length;
        s=new Stack(size);
        BOOM=br.readLine();
    }
    public static void checking(int start){
        int counted=BOOM.length()-1;
        int currentTop=s.top;
        while(counted>=0){
            if(BOOM.charAt(counted--)!=s.pop()) {
                s.top=currentTop;
                return;
            }
        }
    }
    public static void search() throws IOException {
        for(int i=0;i<size;i++){
            s.push(STR[i]);
            if(s.top>=BOOM.length()-1)
                checking(i);
        }
    }

    public static void run() throws IOException {
        StringBuilder S=new StringBuilder();
        input();
        search();
        if(s.isEmpty())
            S.append("FRULA");
        else{
               for(int i=0;i<=s.top;i++){
                   S.append(s.data[i]);
               }
        }

        System.out.println(S);
    }

    public static void main(String[] args) throws IOException {
        run();
    }
}