import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] Args) throws IOException {
        int cnt = Integer.parseInt(br.readLine());
        int repeat = 1;
        while(cnt != 0) {
            //init log
            Log[] logs = new Log[cnt];
            for (int i = 0; i < cnt; i++) {
                logs[i] = new Log(br.readLine(), i+1);
            }
            //set others
            StringTokenizer st;
            for (int i = 0; i < cnt*2-1; i++) {
                st = getSt();
                int tar = Integer.parseInt(st.nextToken()) - 1;
                logs[tar].setOthers(st.nextToken().charAt(0));
            }
            for (int i = 0; i < cnt; i++) {
                if(!logs[i].returned) {
                    System.out.printf("%d %s\n", repeat, logs[i].name);
                    break;
                }
            }

            //to next
            cnt = Integer.parseInt(br.readLine());
            repeat++;
        }
    }

    static StringTokenizer getSt() throws IOException {
        return new StringTokenizer(br.readLine());
    }
}

class Log {
    String name;
    int num = 0;
    char type = '0';
    boolean returned = false;

    public Log(String name, int num) {
        this.num = num;
        this.name = name;
    }

    public void setOthers(char type) {
        if(this.type == '0') {
            this.type = type;
            return;
        }
        returned = true;
    }
}