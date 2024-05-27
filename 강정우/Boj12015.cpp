#include <iostream>
#include <vector>
using namespace std;
vector<int> a, res;
int binary(int k) {
    int start = 0;
    int end = res.size() - 1;
    int mid;
    while (start < end) {
        mid = start + (end - start) / 2;
        if (res[mid] >= k)
            end = mid;
        else
            start = mid + 1;
    }
    return end;
}
int main() {
    int n, t, idx;
    cin >> n;
    for (int i = 0; i < n; i++){
        cin >> t;
        a.push_back(t);
    }
    res.push_back(a.front());

    for (int i = 1; i < n; i++) {
        if (a[i] > res.back())
            res.push_back(a[i]);
        else {
            idx = binary(a[i]);
            res[idx] = a[i];
        }
    }
    cout << res.size();
    return 0;
}
