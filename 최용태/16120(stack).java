import java.io.*;
import java.util.*;


class Main {
    static Stack<Character> stk=new Stack<>();
    static boolean switchOfA=false;
    static boolean isFail(){
        for(int l=0;l<2;l++){
            if(stk.isEmpty()) return true;
            stk.pop();
        }

        switchOfA=true;
        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String ppap=br.readLine();
        String ans="PPAP";

        for(int i=0;i<ppap.length();i++){
            char p=ppap.charAt(i);
            if(p=='A'){
                if(switchOfA || isFail()){
                    ans="NP";
                    break;
                }
            }else{
                switchOfA = switchOfA ? !switchOfA : switchOfA;
                stk.push(p);
            }
        }

        if(stk.size()!=1 || switchOfA) ans="NP";

        System.out.println(ans);
        // A가 들어올 때 스택을 2번 비운다
        // 이때, size 가 부족하면 fail
        // P일때 peek()=A라면 pop
    }
}