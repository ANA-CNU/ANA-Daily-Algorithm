#include <iostream>
#include <queue>
#include <vector>
#include <algorithm>
#include <functional>

#define X first
#define Y second

using namespace std;

const int INF = 1e9;

int t;
int n, d, c;
int a, b, s;
int way[10001];

vector<pair<int, int>> adj[10001];

priority_queue<pair<int, int>, vector<pair<int, int>>, greater<pair<int, int>>> pq;

int main() {
    cin >> t;

    while (t--) {
        cin >> n >> d >> c;
        int number = 0;
        int optional_way = 0;

        for (int i = 1; i <= n; i++)
            adj[i].clear();

        fill(way, way + n + 1, INF);
        way[c] = 0;
        pq.push({way[c], c});

        for (int i = 0; i < d; i++) {
            cin >> a >> b >> s;
            adj[b].push_back({s, a});  
        }

        while (!pq.empty()) {
            pair<int, int> cur = pq.top();
            pq.pop();

            for (const pair<int, int>& nxt : adj[cur.Y]) {
                if (way[nxt.Y] > way[cur.Y] + nxt.X) {
                    way[nxt.Y] = way[cur.Y] + nxt.X;
                    pq.push({way[nxt.Y], nxt.Y});
                }
            }
        }


        for (int i = 1; i <= n; i++) {
            if (way[i] != INF) {
                number++;
                if (way[i] > optional_way) {
                    optional_way = way[i];
                }
            } 
        }



        cout << number << " " << optional_way << '\n';
    }






}
