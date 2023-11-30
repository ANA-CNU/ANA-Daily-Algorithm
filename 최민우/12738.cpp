#include <bits/stdc++.h>
#define int long long

using namespace std;
typedef pair<int, int> pii;

#define GCD(x, y) __gcd(x, y)
#define LCM(x, y) (x * y) / __gcd(x, y)

int32_t main() {
#ifndef ONLINE_JUDGE
    freopen("input.txt", "r", stdin);
#endif
	vector<int> result;
	result.push_back(-1000000001);
	int n;
	cin >> n;

    vector<pii> trail;
	
	while(n--) {
		int input;
		cin >> input;
		if (result.back() < input) {
            trail.emplace_back(input, result.size());
			result.push_back(input);
		} else {
			int index = lower_bound(result.begin(), result.end(), input) - result.begin();
            trail.emplace_back(input, index);
			result[index] = input;
		}
	}
	cout << result.size() - 1 << '\n';
	return 0;
}
