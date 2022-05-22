import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static boolean[] working = new boolean[1_000_000];
    static Todo[] todos;
    public static void main(String[] Args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        todos = new Todo[N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int need = stoi(st);
            int dead = stoi(st);
            todos[i] = new Todo(dead, need);
        }
        Arrays.sort(todos);
        for (int i = 0; i < N; i++) {
            boolean DoneWork = false;
            for (int j = todos[i].dead ; j >= todos[i].need ; j--) { // j == EndPoint
                if(!isAllNotWorking(j-todos[i].need, j)) {
                    continue;
                }
                for (int k = j-1; k > j - todos[i].need-1; k--) {
                    working[k] = true;
                }
                DoneWork = true;
                break;
            }
            if(!DoneWork) {
                System.out.println(-1);
                return;
            }
        }

        for (int i = 0; i < 1_000_000; i++) {
            if(working[i]) {
                System.out.println(i);
                return;
            }
        }
    }

    static int stoi(StringTokenizer st) {
        return Integer.parseInt(st.nextToken());
    }

    static boolean isAllNotWorking(int start, int end) {
        for (int i = 0; i < end-start; i++) {
            if (working[end - i - 1]) {
                return false;
            }
        }
        return true;
    }
}

class Todo implements Comparable<Todo> {
    int dead, need, minimalStart;
    Todo(int dead, int need) {
        this.dead = dead;
        this.need = need;
        this.minimalStart = dead-need;
    }

    @Override
    public int compareTo(Todo o) {
        return -1 * Integer.compare(this.dead, o.dead);
    }
}