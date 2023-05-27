#include <iostream>
#include <algorithm>
using namespace std;

int gcd(int a, int b) {
    if (b == 0) {
        return a;
    } else {
        return gcd(b, a % b);
    }
}

int main() {
    int n;
    cin >> n;
    int arr[n];
    for (int i = 0; i < n; i++) {
        cin >> arr[i];
    }
    sort(arr, arr + n);
    int arr2[n - 1];
    for (int i = 0; i < n - 1; i++) {
        arr2[i] = arr[i + 1] - arr[i];
    }
    sort(arr2, arr2 + n - 1);
    int k = arr2[0];
    for (int i = 1; i < n - 1; i++) {
        k = gcd(k, arr2[i]);
    }
    int sum = 0;
    for (int i = 0; i < n - 1; i++) {
        sum += arr2[i] / k - 1;
    }
    cout << sum;
}
