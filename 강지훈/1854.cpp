#include <iostream>
#include <algorithm>
#include <queue>
#include <set>

#define INF 1'000'000'000

using namespace std;
using pii = pair<int, int>;

vector<pii> vc[1001];
priority_queue<int> dist[1001];

int main() {
    cin.tie(0);
    cout.tie(0);
    ios_base::sync_with_stdio(0);

	int n, m, k;
	cin >> n >> m >> k;

	for (int i = 1; i < n+1; i++) {
		vc[i] = vector<pii>();
		priority_queue<int> temp;
		temp.push(INF);
		dist[i] = temp;
	}

	while (m--) {
		int a, b, c; cin >> a >> b >> c;
		vc[a].push_back(pii(c, b));
	}

	priority_queue<pii, vector<pii>, greater<pii>> pq;
	pq.push(pii(0, 1));
	if (dist[1].size() == k) dist[1].pop();
	dist[1].push(0);

	while (!pq.empty()) {
		pii p = pq.top();
		pq.pop();
		int u = p.second, w0 = p.first;

		if (dist[u].top() < w0) continue;

		for (pii temp : vc[u]) {
			int v = temp.second, w = temp.first + w0;

			if (dist[v].top() <= w) continue;
			if (dist[v].size() == k) dist[v].pop();

			dist[v].push(w);
			pq.push(pii(w, v));
		}
	}
	
	for (int i = 1; i < n+1; i++) {
		if (dist[i].top() == INF) {
			cout << "-1\n";
		} else {
			cout << dist[i].top() << '\n';
		}
	}

    return 0;
}