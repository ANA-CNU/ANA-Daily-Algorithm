#include <iostream>
#include <algorithm>
#include <regex>

#define upp 100'000

using namespace std;

int acc[upp+1];
int seg[4*upp];
int n;

void init(int l, int r, int node) {
	if (l == r) {
		seg[node] = acc[l];
		return;
	}

	int mid = (l+r)/2;
	init(l, mid, node*2);
	init(mid+1, r, node*2+1);
	seg[node] = min(seg[node*2], seg[node*2+1]);
}

int get_min(int l, int r, int node, int u, int v) {
	if (r < u || v < l) return upp*10;
	if (u <= l && r <= v) return seg[node];

	int mid = (l+r)/2;
	int _min = min(get_min(l, mid, node*2, u, v), get_min(mid+1, r, node*2+1, u, v));

	return _min;
}

int main() {
    cin.tie(0);
    cout.tie(0);
    ios_base::sync_with_stdio(0);

	string s; cin >> s;
	n = s.size();
	int m; cin >> m;
	acc[0] = 0;
	int ans = 0;

	for (int i = 1; i < n+1; i++) {
		char c = s[i-1];
		acc[i] = acc[i-1] + (c == '(' ? 1 : -1);
	}

	init(1, n, 1);

	while (m--) {
		int i, j; cin >> i >> j;
		if (acc[i-1] != acc[j]) continue;
		if (get_min(1, n, 1, i, j) >= acc[j]) ++ans;
	}

	cout << ans;

    return 0;
}