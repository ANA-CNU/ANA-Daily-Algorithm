#include<string>
#include<sstream>
#include<fstream>
#include<iostream>
#include<vector>
#include<map>
#include<algorithm>
#include<regex>
#include<queue>
#include<set>
#include <cmath>

#define endl '\n'

typedef long long ll;
using namespace std;

const int INF= 0x3f3f3f3f;
ll modpow(ll b, ll e, ll mod) {
    ll ret = 1;
    ll tmp = b;
    while(e) {
        if(e % 2) ret = (ret * tmp) % mod;
        tmp = tmp * tmp % mod;
        e /= 2;
    }
    return ret;
}

int primes[3] = {2, 7, 61};

bool miller(ll n, ll a) {
    if(a % n == 0) return false;
    ll k = n-1;
    while(1) {
        ll tmp = modpow(a, k, n);
        if(tmp == n-1) return true;
        if(k % 2) return (tmp == 1 || tmp == n-1);
        k /= 2;
    }
}

int main(){
    ios_base::sync_with_stdio(0);
    cin.tie(0); cout.tie(0);
    
    ll a = -1, p = -1;
    while(1) {
        cin >> p >> a;
        if(p == 0 && a == 0) break;
        bool flag = false;
        for(int i =0; i<3; i++) {
            if(!miller(p, primes[i])) flag = true;
        }
        if(!flag) {
            cout << "no" << endl;
            continue;
        }
        
        // cout << modpow(a, p-1, p) << endl;
        if(modpow(a, p, p) == a) cout << "yes" << endl;
        else cout << "no" << endl;

    }
    return 0;
}

