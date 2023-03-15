#include <iostream>
#include <algorithm>
#include <vector>

#define MOD 1000000007
 
using namespace std;
using ll = long long;

vector<vector<ll>> base = {{4, -1}, {1, 0}};

vector<vector<ll>> mulMatrix(vector<vector<ll>> mat1, vector<vector<ll>> mat2) {
    vector<vector<ll>> temp = {{0, 0}, {0, 0}};

    for (int i = 0; i < 2; i++) {
        for (int j = 0; j < 2; j++) {
            for (int k = 0; k < 2; k++) {
                temp[i][j] += ((mat1[i][k] * mat2[k][j]) % MOD);
                temp[i][j] = (temp[i][j] + MOD) % MOD;
            }
        }
    }

    return temp;    
}

vector<vector<ll>> solve(ll n) {
    if (n == 0 || n == 1) return base;

    vector<vector<ll>> temp = solve(n / 2);
    temp = mulMatrix(temp, temp);
    if (n % 2 == 1) temp = mulMatrix(temp, base);

    return temp;
}

int main() {
    cin.tie(NULL);
    cout.tie(NULL);
    ios_base::sync_with_stdio(false);
    
    ll N; cin >> N;

    if (N % 2 != 0) {
        cout << 0;
    } else {
        N /= 2;

        vector<vector<ll>> mat = solve(N - 1);

        ll ans = (3 * mat[0][0]) % MOD;
        ans += (mat[0][1]);
        ans = (ans + MOD) % MOD;

        if (N == 1) cout << 3;
        else cout << ans;
    }
 
    return 0;
}