#include <iostream>
#include <algorithm>

#define upp 100'000

using namespace std;

int n;
int arr[upp+1];
int seg[4*upp];
int lazy[4*upp];

void init(int l, int r, int node) {
	if (l == r) {
		seg[node] = arr[l];
		return;
	}

	int mid = (l+r)/2;
	init(l, mid, node*2);
	init(mid+1, r, node*2+1);

	seg[node] = min(seg[node*2], seg[node*2+1]);
}

void sync(int l, int r, int node) {
	if (lazy[node] == 0) return;

	seg[node] += lazy[node];
	if (l != r) {
		lazy[node*2] += lazy[node];
		lazy[node*2+1] += lazy[node];
	}

	lazy[node] = 0;
}

int find(int l, int r, int node, int k) {
	sync(l, r, node);

	if (l == r) return seg[node];
	
	int mid = (l+r)/2;
	if (k > mid) return find(mid+1, r, node*2+1, k);
	else return find(l, mid, node*2, k);
}

void update(int l, int r, int node, int u, int v, int _val) {
	sync(l, r, node);

	if (r < u || v < l) return;
	if (u <= l && r <= v) {
		lazy[node] += _val;
		sync(l, r, node);
		return;
	}

	int mid = (l+r)/2;
	update(l, mid, node*2, u, v, _val);
	update(mid+1, r, node*2+1, u, v, _val);

	seg[node] = min(seg[node*2], seg[node*2+1]);
}

int main() {
    cin.tie(0);
    cout.tie(0);
    ios_base::sync_with_stdio(0);

	string s; cin >> s;
	int m; cin >> m;
	n = s.size();
	arr[0] = 0;
	int ans = 0;

	for (int i = 1; i < n+1; i++) {
		if (s[i-1] == '(') arr[i] = arr[i-1]+1;
		else arr[i] = arr[i-1]-1;
	}

	init(1, n, 1);

	while (m--) {
		int idx; cin >> idx;
		int v;

		if (s[idx-1] == '(') {
			v = -2;
			s[idx-1] = ')';
		} else {
			v = 2;
			s[idx-1] = '(';
		}
		
		update(1, n, 1, idx, n, v);

		int k = find(1, n, 1, n);
		sync(1, n, 1);
		if (k == 0 && seg[1] >= 0) {
			++ans;
		}
	}

	cout << ans;

    return 0;
}