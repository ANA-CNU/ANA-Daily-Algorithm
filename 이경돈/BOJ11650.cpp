#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

bool cmp(pair<int, int> a, pair<int, int> b) {
	if (a.first == b.first)
		return a.second < b.second;
	else
		return a.first < b.first;
}

int main() {
	cin.tie(NULL);
	cout.tie(NULL);
	ios::sync_with_stdio(false);

	int k, x, y;
	cin >> k;
	
	vector<pair<int, int>> v;

	while (k-- > 0) {
		cin >> x >> y;
		v.push_back({ x,y });
	}

	sort(v.begin(), v.end(), cmp);

	for (int i = 0; i < v.size(); i++)
		cout << v[i].first << " " << v[i].second << "\n";
}