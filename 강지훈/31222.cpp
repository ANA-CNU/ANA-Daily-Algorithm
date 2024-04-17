#include <iostream>
#include <algorithm>

#define upp 200000

using namespace std;

int seg[upp*4+2];
int arr[upp+2];
int n;

void init(int l, int r, int node) {
	if (l == r) {
		seg[node] = 1;
		return;
	}

	int mid = (l+r)/2;
	init(l, mid, node*2);
	init(mid+1, r, node*2+1);

	seg[node] = seg[node*2] + seg[node*2+1];
	if (arr[mid] == arr[mid+1]) --seg[node];
}

void update(int l, int r, int node, int k, int v) {
	if (l == r) {
		arr[k] = v;
		return;
	}

	int mid = (l+r)/2;
	if (k <= mid) {
		update(l, mid, node*2, k, v);
	} else {
		update(mid+1, r, node*2+1, k, v);
	}
	
	seg[node] = seg[node*2] + seg[node*2+1];
	if (arr[mid] == arr[mid+1]) --seg[node];
}

int query(int l, int r, int node, int u, int v) {
	if (v < l || r < u) return 0;
	else if (u <= l && r <= v) return seg[node];

	int mid = (l+r)/2;
	int _l = query(l, mid, node*2, u, v);
	int _r = query(mid+1, r, node*2+1, u, v);
	int temp;

	if (_l == 0) temp = _r;
	else if (_r == 0) temp = _l;
	else {
		temp = _l + _r;
		if (arr[mid] == arr[mid+1]) --temp;
	}
	
	return temp;
}

int main() {
    cin.tie(0);
    cout.tie(0);
    ios_base::sync_with_stdio(0);

	int q; cin >> n >> q;
	arr[0] = -1; arr[n+1] = -1;
	for (int i = 1; i < n+1; i++) {
		cin >> arr[i];
	}

	init(1, n, 1);

	while (q--) {
		int d, a, b; cin >> d >> a >> b;
		if (d == 1) {
			update(1, n, 1, a, b);
		} else {
			cout << query(1, n, 1, a, b) << '\n';
		}
	}

    return 0;
}