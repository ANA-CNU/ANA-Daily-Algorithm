#include <iostream>
#include <algorithm>

using namespace std;

int seg[4000001];

void update(int l, int r, int node, int k, int v) {
	if (k < l || r < k) return;

	if (l == r) {
		seg[node] += v;
		return;
	}

	int mid = (l+r)/2;
	update(l, mid, node*2, k, v);
	update(mid+1, r, node*2+1, k, v);

	seg[node] = seg[node*2] + seg[node*2+1];
}

void find(int l, int r, int node, int k) {
	if (l == r) {
		cout << l << '\n';
		update(1, 1000000, 1, l, -1);
		return;
	}

	int mid = (l+r)/2;
	if (seg[node*2] >= k) {
		find(l, mid, node*2, k);
	} else {
		find(mid+1, r, node*2+1, k-seg[node*2]);
	}
}

int main() {
    cin.tie(0);
    cout.tie(0);
    ios_base::sync_with_stdio(0);

	fill(seg, seg+4000001, 0);

	int Q; cin >> Q;
	while (Q--) {
		int a, b;
		cin >> a >> b;

		if (a == 1) {
			find(1, 1000000, 1, b);
		} else {
			int c; cin >> c;
			update(1, 1000000, 1, b, c);
		}
	}

    return 0;
}