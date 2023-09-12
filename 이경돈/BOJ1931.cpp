#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

vector<pair<int, int>> vtime;

bool cmp(pair<int, int> a, pair<int, int> b) {
    if (a.second == b.second)
        return a.first < b.first;
    else
        return a.second < b.second;
}

int main() {
    int n, a, b;
    int curend, cnt = 1;

    cin >> n;
    
    while(n-->0) {
        cin >> a >> b;
        vtime.push_back({ a,b });
    }

    sort(vtime.begin(), vtime.end(), cmp);

    curend = vtime[0].second;
    
    for (int i = 1; i < vtime.size(); i++) {
        if (vtime[i].first >= curend) {
            cnt++;
            curend = vtime[i].second;
        }
    }

    cout << cnt;
}
