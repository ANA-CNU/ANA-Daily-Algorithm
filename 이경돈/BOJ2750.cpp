#include <iostream>
using namespace std;

int num[2001];

int main() {
    cin.tie(NULL);
    cout.tie(NULL);
    ios::sync_with_stdio(false);
    
    int k, tmp;
    cin >> k;

    for (int i = 0; i < k; i++) {
        cin >> tmp;
        num[tmp + 1000] = 1;
    }

    for (int i = 0; i < 2001; i++)
        if (num[i] == 1 )
            cout << i - 1000 << "\n";

}