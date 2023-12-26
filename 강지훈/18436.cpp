#include <iostream>
#include <algorithm>
#include <vector>

using namespace std;

// 홀수의 개수
int tree[400000];
int arr[100001];
int N;

int init(int l, int r, int node) {
	if (l == r) return tree[node] = arr[l]%2;
	
	int mid = (l+r)/2;
	return tree[node] = init(l, mid, node*2) + init(mid+1, r, node*2+1);
}

int getsum(int l, int r, int node, int u, int v) {
	if (r < u || v < l) return 0;
	else if (u <= l && r <= v) return tree[node];

	int mid = (l+r)/2;
	return getsum(l, mid, node*2, u, v) + getsum(mid+1, r, node*2+1, u, v);
}

int update(int l, int r, int node, int k, int v) {
	if (l == k && k == r) return tree[node] = v%2;
	else if (l <= k && k <= r) {
		int mid = (l+r)/2;
		return tree[node] = update(l, mid, node*2, k, v) + update(mid+1, r, node*2+1, k, v);
	} else return tree[node];
}

int main() {
    cin.tie(0);
    cout.tie(0);
    ios_base::sync_with_stdio(0);
    
	cin >> N;
	for (int i = 1; i < N+1; i++) {
		cin >> arr[i];
	}

	init(1, N, 1);

	int Q; cin >> Q;
	while (Q--) {
		int n, u, v; cin >> n >> u >> v;
		if (n == 1) update(1, N, 1, u, v);
		else if (n == 2) cout << v - u + 1 - getsum(1, N, 1, u, v) << '\n';
		else cout << getsum(1, N, 1, u, v) << '\n';
	}

    return 0;
}