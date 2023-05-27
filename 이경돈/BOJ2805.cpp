#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int main() {
    cin.tie(NULL);
    cout.tie(NULL);
    ios::sync_with_stdio(false);

    long long n;
    long long len, tmp, sum = 0;
    
    cin >> n >> len;
    vector<long long> v;

    for (int i = 0; i < n; i++) {
        cin >> tmp;
        v.push_back(tmp);
    }

    long long res, mid;
    long long low = 0;
    long long high = *max_element(v.begin(), v.end());

    
    while (low <= high) {
        sum = 0;
        mid = (low + high) / 2;
        for (int i = 0; i < n; i++) {
            if(v[i]>mid)
                sum += (v[i] - mid);
        }
        
        if (sum >= len) {
            res = mid;
            low = mid + 1;
        }
        else
            high = mid - 1;
    }

    cout << res;
}