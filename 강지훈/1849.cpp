#include <iostream>
#include <algorithm>

using namespace std;

int N;
int seg[400001];
int ans[100001];

void init(int l, int r, int node) {
	if (l == r)  {
		seg[node] = 1;
		return;
	}

	int mid = (l+r)/2;
	init(l, mid, node*2);
	init(mid+1, r, node*2+1);

	seg[node] = seg[node*2]+seg[node*2+1];
}

void update(int l, int r, int node, int k) {
	if (k < l || r < k) return;
	
	if (l == r) {
		--seg[node];
		return;
	}

	int mid = (l+r)/2;
	update(l, mid, node*2, k);
	update(mid+1, r, node*2+1, k);

	seg[node] = seg[node*2]+seg[node*2+1];
}

void find(int l, int r, int node, int n, int v) {
	if (l == r) {
		ans[l] = v;
		update(1, N, 1, l);
		return;
	}

	int mid = (l+r)/2;

	if (n < seg[node*2]) {
		find(l, mid, node*2, n, v);
	} else {
		find(mid+1, r, node*2+1, n-seg[node*2], v);
	}
}

int main() {
    cin.tie(0);
    cout.tie(0);
    ios_base::sync_with_stdio(0);

	cin >> N;

	init(1, N, 1);
	
	for (int i = 1; i < N+1; i++) {
		int n; cin >> n;
		find(1, N, 1, n, i);
	}

	for (int i = 1; i < N+1; i++) {
		cout << ans[i] << '\n';
	}

    return 0;
}