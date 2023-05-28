#include <iostream>
#include <vector>
using namespace std;

int main() {
    cin.tie(NULL);
    cout.tie(NULL);
    ios::sync_with_stdio(false);
    
    int n, money, tmp;
    cin >> n >> money;

    vector<int> coin;   
    
    for (int i = 0; i < n; i++) {
        cin >> tmp;
        coin.push_back(tmp);
    }
    
    int cnt = 0;
    int iAdd = (n-1);

    while (money>0) {
        if (coin[iAdd] <= money) {
            cnt += (money / coin[iAdd]);    
            money = (money % coin[iAdd]);
            iAdd--;
        }
        else
            iAdd--;
        if (money == 0)
            break;
    }
    
    cout << cnt;
}