import java.util.*;
import java.io.*;

class Max {
    static int N;
    static Pair arr[];
    static ArrayList<Node> arrayList;
    static int parent[];

    public static int find(int p) {
        if(parent[p] == p) {
            return p;
        }else{
            parent[p] = find(parent[p]);
        }
        return parent[p];
    }
    public static boolean union(int start, int end) {
        int startP = find(start);
        int endP = find(end);

        if(startP == endP) {
            return false;
        }else{
            parent[endP] = startP;
            return true;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        arr = new Pair[N];
        arrayList = new ArrayList<>();
        parent = new int[N];

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            double start = Double.parseDouble(st.nextToken());
            double end = Double.parseDouble(st.nextToken());

            arr[i] = new Pair(start, end);
        }

        for(int i = 0; i < N - 1; i++) {
            for(int j = i; j < N; j++) {
                Pair first = arr[i];
                Pair second = arr[j];

                double distance = Math.sqrt(Math.pow(second.x - first.x, 2) + Math.pow(second.y - first.y, 2));

                arrayList.add(new Node(i, j, distance));
            }
        }

        Collections.sort(arrayList, new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return (int)(o1.cost - o2.cost);
            }
        });

        for(int i = 0; i < N; i++) {
            parent[i] = i;
        }

        double answer = 0;

        for(Node temp : arrayList) {
            int start = temp.start;
            int end = temp.end;

            int edges = 0;
            if(union(start, end)) {
                edges++;
                answer += temp.cost;
            }
            if(edges == N - 1) {
                break;
            }
        }

        System.out.println(answer);
    }
}
class Pair{
    double x;
    double y;
    Pair(double x, double y){
        this.x = x;
        this.y = y;
    }
}
class Node{
    int start;
    int end;
    double cost;
    Node(int s, int e, double c) {
        start = s;
        end = e;
        cost = c;
    }
}
