#include <iostream>
#include <algorithm>
#include <vector>

using namespace std;
using ll = long long;

vector<int> adj[2001];
ll tree[4*2001];

int N;

void update(int l, int r, int node, int i) {
	if (l == i && i == r) {
		++tree[node];
		return;
	}

	if (l <= i && i <= r) {
		int mid = (l+r)/2;
		++tree[node];

		update(l, mid, node*2, i);
		update(mid+1, r, node*2+1, i);
	}
}

ll getsum(int l, int r, int node, int u, int v) {
	if (r < u || v < l) return 0;
	if (u <= l && r <= v) return tree[node];

	int mid = (l+r)/2;
	return getsum(l, mid, node*2, u, v) + getsum(mid+1, r, node*2+1, u, v);
} 

int main() {
    cin.tie(0);
    cout.tie(0);
    ios_base::sync_with_stdio(0);
    
	int M;
	cin >> N >> M;

	while (M--) {
		int u, v; cin >> u >> v;
		adj[u].push_back(v);
	}

	for (int i = 1; i < N+1; i++) {
		sort(adj[i].begin(), adj[i].end());
	}
	
	fill(tree, tree+2001, 0);

	ll ans = 0;

	for (int u = 1; u < N+1; u++) {
		for (int v : adj[u]) {
			update(1, N, 1, v);
			if (v == 2000) continue;
			else ans += getsum(1, N, 1, v+1, N);
		}
	}

	cout << ans;

    return 0;
}