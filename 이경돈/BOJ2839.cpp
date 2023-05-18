#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int main() {
    int k;
    cin >> k;

    int x, y;

    vector<pair<int, int>> v;

    for (int x = 0; x <= k; x++) {
        for (int y = 0; y <= k; y++) {
            if (3 * x + 5 * y == k)
                v.push_back({ x,y });
        }
    }

    int res = 5000;
    
    if (v.empty())
        cout << -1;
    else
    {
        for (int i = 0; i < v.size(); i++) {
            res = min(res, v[i].first + v[i].second);
        }
        cout << res;
    }
}