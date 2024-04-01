#include <iostream>
#include <vector>
using namespace std;
int main() {
    int n;
    cin >> n;
    vector<int> arr(n);
    for (int i = 0; i < n; i++)
        cin >> arr[i];
    vector<int> result(n, 1);
    for(int i=0;i<n;i++) {
        int a = arr[i];
        for (int j = 0; j < i; j++) {
            int b = arr[j];
            if (a > b) {
                result[i] = max(result[i], result[j] + 1);
            }
        }
    }
    int max = 0;
    for (int i = 0; i < n; i++) {
        if (result[i] > max) {
            max = result[i];
        }
    }
    cout << max;
}
