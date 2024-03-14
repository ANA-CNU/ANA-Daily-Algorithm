#include <iostream>
#include <algorithm>

#define upp 100'000

using namespace std;

int Mseg[4*upp], mseg[4*upp];
int N;
int d = 0;

void init(int l, int r, int node) {
	if (l == r) {
		Mseg[node] = l;
		mseg[node] = l;
		return;
	}

	int mid = (l+r)/2;
	init(l, mid, node*2);
	init(mid+1, r, node*2+1);

	Mseg[node] = max(Mseg[node*2], Mseg[node*2+1]);
	mseg[node] = min(mseg[node*2], mseg[node*2+1]);
}

int countq(int l, int r, int node, int v) {
	if (Mseg[node] < v) return r-l+1;
	if (mseg[node] >= v) return 0;

	int mid = (l+r)/2;
	int sum = countq(l, mid, node*2, v) + countq(mid+1, r, node*2+1, v);
	return sum;
}

void update(int l, int r, int node, int k) {
	if (k < l || r < k) return;
	if (l == r) {
		cout << countq(1, N, 1, Mseg[node]) << ' ';
		Mseg[node] = d;
		mseg[node] = d;
		d -= 1;
		return;
	}

	int mid = (l+r)/2;
	update(l, mid, node*2, k);
	update(mid+1, r, node*2+1, k);

	Mseg[node] = max(Mseg[node*2], Mseg[node*2+1]);
	mseg[node] = min(mseg[node*2], mseg[node*2+1]);
}

int main() {
    cin.tie(0);
    cout.tie(0);
    ios_base::sync_with_stdio(0);

	int T; cin >> T;
	while (T--) {
		fill(Mseg, Mseg+4*upp, 0);
		fill(mseg, mseg+4*upp, 0);
		d = 0;

		int M; cin >> N >> M;
		init(1, N, 1);

		while (M--) {
			int n; cin >> n;
			update(1, N, 1, n);
		}
		cout << '\n';
	}

    return 0;
}