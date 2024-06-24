#include <iostream>
#include <vector>
#include <queue>
#include <algorithm>
using namespace std;
const int INF = 987654321;
int n, e, v1, v2, res = INF;
int sToV1, sToV2, V1ToV2, V1ToN, V2ToN;
vector<pair<int, int>> v[801];
int dist[801];
void dijk(int start){
    for (int i = 0; i <= n; i++) dist[i] = INF;
    dist[start] = 0;
    priority_queue<pair<int, int>, vector<pair<int, int>>, greater<pair<int, int>>> q;
    q.push({ 0,start });
    while (!q.empty()) {
        int cur = q.top().second;
        int curDist = q.top().first;
        q.pop();
        for (int i = 0; i < v[cur].size(); i++) {
            int next = v[cur][i].first;
            int nextDist = v[cur][i].second;
            if (dist[next] > curDist + nextDist) {
                dist[next] = curDist + nextDist;
                q.push({ dist[next],next });
            }
        }
    }
}
int main(){
    cin >> n >> e;
    for(int i=0;i< n;i++){
        int a, b, c;
        cin >> a >> b >> c;
        v[a].push_back({ b,c });
        v[b].push_back({ a,c });
    }
    cin >> v1 >> v2;
    dijk(1);
    sToV1 = dist[v1];
    sToV2 = dist[v2];
    dijk(v1);
    V1ToV2 = dist[v2];
    V1ToN = dist[n];
    dijk(v2);
    V2ToN = dist[n];
    if (sToV1 == INF || V1ToV2 == INF || V2ToN == INF) res = -1;
    else res = min(sToV1 + V1ToV2 + V2ToN, sToV2 + V1ToV2 + V1ToN);
    cout << res ;
}
