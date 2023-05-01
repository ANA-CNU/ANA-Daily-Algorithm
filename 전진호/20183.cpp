#include<bits/stdc++.h>
using namespace std;

const long long INF = 1e15;
const int MAXN = 1e5 + 5;
vector<pair<int, int>> adj[MAXN];
int N, M, A, B;
long long C;

bool dijkstra(long long max_cost) {
    vector<long long> dist(N + 1, INF);
    // vector initialize 
    priority_queue<pair<long long, int>, vector<pair<long long , int>>, greater<pair<long long, int>>> pq;
    // 더 짧은 경로 : 전형적인 O(nlogn) dijstra 코드 

    dist[A] = 0; // dijstra 현재 위치 기록 
    pq.push({0, A}); // 현재까지의 경로, 다음 목적지
    
    while (!pq.empty()) {
        int u = pq.top().second;
        long long d = pq.top().first;
        pq.pop();
        
        if (u == B) return d <= C; 
        // 최종 목적지에 도착했을 떄 비용은 C 이해여야 하기 때문에 
        
        if (d != dist[u]) continue;
        // 현재 기록된 거리가 최단거리가 아닌 경우 
        // 즉, 현재 경로에서 다른 거리로 갈 때 더 짧아질 수도 있다. 
        // 그러므로 아래 코드로 진행하게 되는 것

        for (auto p : adj[u]) {
            int v = p.first;
            int w = p.second;
            
            if (w > max_cost) continue;
            
            if (dist[v] > dist[u] + w) {
                dist[v] = dist[u] + w;
                pq.push({dist[v], v});
            }
        }
    }
    
    return false;
}

int main() {
    // Open the input file
    ios::sync_with_stdio(false);cin.tie(0);

    // Read input from the file
    cin  >> N >> M >> A >> B >> C;

    int u, v, w;
    for (int i = 0; i < M; i++) {
        cin >>  u >> v >> w;
        adj[u].push_back({v, w});
        adj[v].push_back({u, w});
    }


    // Add your binary search implementation here
    
    long long low = 1, high = C, ans = -1;
    // 처음부터 1<= C <= high 여야 한다. 
    // low = 0 -> impossibel 

    while (low <= high) {
        long long mid = low + (high - low) / 2;
        // 
        if (dijkstra(mid)) {
            ans = mid;
            high = mid - 1;
        } else {
            low = mid + 1;
        }
    }
    
    cout << ans << '\n';
    return 0;
}
