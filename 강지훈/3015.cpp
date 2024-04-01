#include <iostream>
#include <algorithm>
#include <stack>
#include <vector>

using namespace std;
using ll = long long;
using pii = pair<int, ll>;

int n;
stack<pii> st;
vector<pii> vc;

int main() {
    cin.tie(0);
    cout.tie(0);
    ios_base::sync_with_stdio(0);

	cin >> n;
	ll ans = 0;

	for (int i = 0; i < n; i++) {
		int m; cin >> m;
		if (vc.empty()) vc.push_back(pii(m,1));
		else {
			if (vc[vc.size()-1].first == m) *vc.rbegin() = pii(m, (*vc.rbegin()).second+1);
			else vc.push_back(pii(m, 1));
		}
		ans += (*vc.rbegin()).second - 1;
	}

	n = vc.size();

	for (int i = 0; i < n; i++) {
		st.push(vc[i]);
		while (st.size() > 1) {
			pii cur = st.top();
			st.pop();

			int f = cur.first;
			ll s = cur.second;

			pii pre = st.top();
			st.pop();

			int _f = pre.first;
			ll _s = pre.second;

			if (_f < f) {
				if (!st.empty()) ans += _s;
				ans += _s;
				st.push(cur);
			} else if (_f > f) {
				st.push(pre);
				st.push(cur);
				break;
			} else {
				ans += _s*s;
				st.push(pii(_f, _s+s));
			}
		}
	}

	while (st.size() > 1) {
		// 어차피 내림차순이니까 더 작은 쪽이 top
		ans += st.top().second;
		st.pop();
	}

	cout << ans;

    return 0;
}