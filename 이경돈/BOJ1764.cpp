#include <iostream>
#include <vector>
#include <algorithm>
#include <map>
using namespace std;

int main() {
    cin.tie(NULL);
    cout.tie(NULL);
    ios::sync_with_stdio(false);

    int n, m;
    cin >> n >> m;

    map<string, int> uh;
    vector<string> res;
    
    string tmp;
    int cnt = 0;
    
    for (int i = 0; i < n; i++) {
        cin >> tmp;
        uh.insert({ tmp, 1 });
    }
    
    for (int i = 0; i < m; i++) {
        cin >> tmp;
        if (uh[tmp] == 1) {
            cnt++;
            res.push_back(tmp);
        }
    }

    sort(res.begin(), res.end());
    
    cout << cnt << "\n";
    for (int i = 0; i < res.size(); i++) {
        cout << res[i] << "\n"; 
    }
}