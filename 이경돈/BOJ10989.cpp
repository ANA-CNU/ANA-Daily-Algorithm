#include <iostream>
using namespace std;

int num[10001];

int main() {
    cin.tie(NULL);
    cout.tie(NULL);
    ios::sync_with_stdio(false);

    int k, tmp;
    cin >> k;

    for (int i = 0; i < k; i++) {
        cin >> tmp;
        num[tmp]++;
    }

    for (int i = 1; i < 10001; i++)
        while (num[i] > 0) {
            cout << i << "\n";
            num[i]--;
        }
}