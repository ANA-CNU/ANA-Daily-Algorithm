#include <iostream>
#include <algorithm>

#define MOD 1'000'000'007
#define upp 200'000

using namespace std;
using ll = long long;

int N;
ll temp_seg[4*upp];
ll seg[4*upp];

ll getsum(int l, int r, int node, int u, int h, int st) {
	if (r < u || h < l) return 0;
	if (u <= l && r <= h) return abs(seg[node]-temp_seg[node]*st);
	
	int mid = (l+r)/2;
	ll sum = getsum(l, mid, node*2, u, h, st) + getsum(mid+1, r, node*2+1, u, h, st);
	return sum;
}

void update(int l, int r, int node, int v) {
	if (v < l || r < v) return;
	if (l == r) {
		seg[node] += v;
		temp_seg[node] += 1;
		return;
	}

	int mid = (l+r)/2;
	update(l, mid, node*2, v);
	update(mid+1, r, node*2+1, v);
	seg[node] = seg[node*2] + seg[node*2+1];
	temp_seg[node] = temp_seg[node*2] + temp_seg[node*2+1];
}

int main() {
    cin.tie(0);
    cout.tie(0);
    ios_base::sync_with_stdio(0);

	fill(seg, seg+upp+1, 0);
	fill(temp_seg, temp_seg+upp+1, 0);

	cin >> N;
	ll ans = 1;

	for (int i = 0; i < N; i++) {
		int n; cin >> n;
		
		update(0, upp, 1, n);
		if (i == 0) continue;
		ll temp = 0;
		if (n > 0) temp += getsum(0, upp, 1, 0, n-1, n);
		if (n < upp) temp += getsum(0, upp, 1, n+1, upp, n);
		temp %= MOD;

		ans *= temp;
		ans %= MOD;
	}

	cout << ans;

    return 0;
}