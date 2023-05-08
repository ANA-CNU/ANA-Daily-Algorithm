#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int main() {
	cin.tie(NULL);
	cout.tie(NULL);
	ios::sync_with_stdio(false);

	int n, m, tmp;
	cin >> n;

	vector<int> v1, v2;
	
	while (n-- > 0) {
		cin >> tmp;
		v1.push_back(tmp);
	}

	sort(v1.begin(), v1.end());

	cin >> m;

	while (m-- > 0) {
		cin >> tmp;
		v2.push_back(tmp);
	}

	for (int i = 0; i < v2.size(); i++) {
		if (binary_search(v1.begin(), v1.end(), v2[i]))
			cout << "1" << "\n";
		else cout << "0" << "\n";
	}
}