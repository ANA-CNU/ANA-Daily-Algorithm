#include <iostream>
#include <string>
#include <algorithm>
#include <vector>
using namespace std;

bool cmp(pair<int, string> a, pair<int, string> b) {
	return a.first < b.first;
}

int main() {
	cin.tie(NULL);
	cout.tie(NULL);
	ios::sync_with_stdio(false);

	int k, age;
	string name;
	cin >> k;

	vector<pair<int, string>> v;

	while (k-- > 0) {
		cin >> age >> name;
		v.push_back({ age,name });
	}

	stable_sort(v.begin(), v.end(), cmp);

	for (int i = 0; i < v.size(); i++) {
		cout << v.at(i).first << " " << v.at(i).second << "\n";
	}
}