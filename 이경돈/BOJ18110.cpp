#include <iostream>
#include <cmath>
#include <algorithm>
#include <vector>
#include <numeric>
using namespace std;

int main() {
    cin.tie(NULL);
    cout.tie(NULL);
    ios::sync_with_stdio(false);

    int k, n;
    cin >> k;

    int m = k;

    vector<int> v;

    while (k-- > 0) {
        cin >> n;
        v.push_back(n);
    }

    if (v.empty()) {
        cout << 0;
        return 0;
    }
    
    sort(v.begin(), v.end());

    int cut = round((double)m * 15 / 100);

    int sum = accumulate(v.begin() + cut, v.end() - cut, 0);

    int avg = round((double)sum / (m - 2 * cut));

    cout << avg;
}