#include <bits/stdc++.h>
#define deb(x) cout << #x << " : " << (x) << "\n"
#define deb_pair(x, y)                                                         \
    cout << "(" << #x << ", " << #y << ") : (" << (x) << ", " << (y) << ")\n"
#define deb_tuple(x, y, z)                                                     \
    cout << "(" << #x << ", " << #y << ", " << #z << ") : (" << (x) << ", " << (y) \
         << ", " << (z) << ")\n"
#define ALL(x) (x).begin(), (x).end()
#define SIZE(x) (int)((x).size())
using namespace std;

int n, m, k;
map<int, int> num;
vector<int> adj[100001];

void bfs(int end) {
    queue<int> q;
    vector<int> prev(100001);
    q.push(1);
    prev[1] = 1;
    while (!q.empty()) {
        int here = q.front();
        q.pop();
        for (int there : adj[here]) if (!prev[there]) {
            q.push(there);
            prev[there] = here;
        }
    }
    if (!prev[end]) {
        cout << -1 << "\n";
        return;
    }
    vector<int> path;
    int here = end;
    while (prev[here] != here) {
        path.push_back(here);
        here = prev[here];
    }
    path.push_back(1);
    reverse(ALL(path));
    for (int& p : path) {
        cout << p << " ";
    }
    cout << "\n";
}

int main() {
    cin.tie(0);
    ios_base::sync_with_stdio(0);
    cin >> n >> k;
    for (int i = 1; i <= n; i++) {
        string here;
        cin >> here;
        num.insert({stoi(here, NULL, 2), i});
    }
    for (auto& p : num) {
        int here = p.second;
        for (int i = 0; i < k; i++) {
            int there = p.first ^ (1 << i);
            if (num.count(there)) {
                adj[here].push_back(num.find(there)->second);
            }
        }
    }
    cin >> m;
    for (int i = 0; i < m; i++) {
        int end;
        cin >> end;
        bfs(end);
    }
}
