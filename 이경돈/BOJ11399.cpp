#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int main() {
    cin.tie(NULL);
    cout.tie(NULL);
    ios::sync_with_stdio(false);

    int k, tmp;
    cin >> k;

    vector<int> v;
    vector<int> pv;
    
    for (int i = 0; i < k; i++) {
        cin >> tmp;
        v.push_back(tmp);
    }

    sort(v.begin(), v.end());

    int sum = v[0];
    pv.push_back(v[0]);
    for (int i = 1; i < k; i++) {
        pv.push_back(pv[i - 1] + v[i]);
        sum += pv[i];
    }

    cout << sum;

}