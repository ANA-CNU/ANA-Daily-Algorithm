#include <iostream>
#include <algorithm>
#include <map>

#define upp 75000

using namespace std;
using ll = long long;
using pp = pair<int, int>;

int N;
pp points[upp];
int xs[upp], ys[upp];
int seg[4*upp];

bool cmp(pp p1, pp p2) {
	if (p1.first == p2.first) {
		return p1.second < p2.second;
	}
	return p1.first > p2.first;
}

void update(int l, int r, int node, int k) {
	if (k < l || r < k) return;
	if (l == r) {
		seg[node] += 1;
		return;
	}

	int mid = (l+r)/2;
	update(l, mid, node*2, k);
	update(mid+1, r, node*2+1, k);

	seg[node] = seg[node*2] + seg[node*2+1];
}

int getsum(int l, int r, int node, int d, int u) {
	if (r < d || u < l) return 0;
	if (d <= l && r <= u) return seg[node];

	int mid = (l+r)/2;
	int sum = getsum(l, mid, node*2, d, u) + getsum(mid+1, r, node*2+1, d, u);
	return sum;
}

int main() {
    cin.tie(0);
    cout.tie(0);
    ios_base::sync_with_stdio(0);

	int T; cin >> T;
	while (T--) {
		fill(points, points+upp, pp(0,0));
		// fill(xs, xs+upp, 0);
		fill(ys, ys+upp, 0);
		fill(seg, seg+4*upp, 0);

		cin >> N;
		for (int i = 0; i < N; i++) {
			int x, y; cin >> x >> y;
			// xs[i] = x;
			ys[i] = y;
			points[i] = pp(x, y);
		}

		// sort(xs, xs+N);
		sort(ys, ys+N);

		map<int, int> x_map, y_map;
		int xi = 1, yi = 1;
		
		for (int i = 0; i < N; i++) {
			int x = xs[i], y = ys[i];
			// if (x_map.find(x) == x_map.end()) {
			// 	x_map.insert(make_pair(x, xi));
			// 	xi += 1;
			// }
			if (y_map.find(y) == y_map.end()) {
				y_map.insert(make_pair(y, yi));
				yi += 1;
			}
		}

		for (int i = 0; i < N; i++) {
			pp p = points[i];
			// pp new_p = pp(x_map[p.first], y_map[p.second]);
			pp new_p = pp(p.first, y_map[p.second]);
			points[i] = new_p;
		}

		sort(points, points+N, cmp);

		ll ans = 0;
		for (int i = 0; i < N; i++) {
			pp p = points[i];
			int x = p.first, y = p.second;
			ans += getsum(1, upp, 1, 1, y);
			update(1, upp, 1, y);
		}

		cout << ans << '\n';
	}

    return 0;
}