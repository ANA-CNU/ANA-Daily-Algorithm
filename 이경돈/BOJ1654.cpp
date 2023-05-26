#include <iostream>
#include <algorithm>
using namespace std;

long long arr[10001];

int main() {
    cin.tie(NULL);
    cout.tie(NULL);
    ios::sync_with_stdio(false);
    
    int k, n;
    cin >> k >> n;

    long long high = 1;
    long long low = 1;
    
    long long sum;
    long long res;

    for (int i = 0; i < k; i++) {
        cin >> arr[i];
        high = max(arr[i], high);

        sum += arr[i];
    }

    long long  mid;

    while (low <= high) {
        mid = (high + low) / 2;
        sum = 0;
        
        for (int i = 0; i < k; i++) {
            sum += (arr[i] / mid);
        }

        if (sum >= n) {
            res = mid;
            low = mid + 1;
        }
        else
            high = mid - 1;
    }

    cout << res;
}
