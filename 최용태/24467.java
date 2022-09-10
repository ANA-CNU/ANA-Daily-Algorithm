import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int canThrough=0;
    static int enteredRute=0;

    public static void run() throws IOException{
        int ans=0;
        int counted=0;
        for(int i=0;i<10&&counted<50;i++){
            String current=br.readLine();
            int rear=0;
            for(int x=0;x<4;x++){
                if(current.charAt(x)=='0') rear++;
            }
            if(rear==4 || rear==0) i--;
            ans=search(rear,ans);
            counted++;
        }

        if(ans>20) System.out.println("WIN");
        else System.out.println("LOSE");
    }
    public static int search(int rear,int c){
        int currentLoc=c;
        int move=rear;
        if(rear==0) move=5;

        if(canThrough!=0){
            currentLoc=canThrough;
            canThrough=0;
        }

        currentLoc+=move;

        if(currentLoc==5 || currentLoc==10){
            enteredRute=currentLoc;
            canThrough=14; // 지름길 진입
        } else if(currentLoc==17){
            enteredRute=0;
        } else if(enteredRute==5 && currentLoc>17){
            currentLoc-=5;
            enteredRute=0;
        }

        return currentLoc;
    }
    public static void main(String[] args) throws IOException {
        run();
    }
}