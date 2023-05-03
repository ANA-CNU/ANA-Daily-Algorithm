#include <bits/stdc++.h>
using namespace std;
typedef long long ll;
constexpr int SIZE = (1e5 +5);
int n; ll m;
ll L[SIZE];
ll A[SIZE];
ll M[SIZE];
ll sum(ll level){
    return (level - 1) * ((level) /2);
}
ll binary(ll level, ll item){ // 아이템을 이용해서 만들 수 있는 레벨의 최댓값 
    ll lo = 1; ll hi = (1e10);
    while(lo <= hi){
        ll mid = lo + (hi - lo)/2;
        // level level + 1,  level + 2 ... level + n-1 
        // n * (2level + (n-1) ) /2 <= item 
        // 2level + (mid-1) <= 2 item / mid
        if (mid <= 1+(((2*item) / mid) - 2*level)){
           lo = mid + 1;
        }else{
           hi = mid - 1;
        }
    }
    return hi;
}

int main(void){
    ios::sync_with_stdio(false);cin.tie(0);cout.tie(0);
    cin >> n >> m;
    ll lo = 0;
    for(int i = 0;i<n;i++){
        cin >> L[i];
        lo = max(L[i], lo);
    }
    for(int i = 0;i<n;i++){
        cin >> A[i];
    }
    
    for(int i = 0;i<n;i++){
        ll tmp = binary(L[i], A[i]);
        M[i] = (0 > tmp) ? L[i] : tmp + L[i];
    }
    ll hi = (1e12); ll ans = -1;
    
    while(lo <= hi){
        ll mid = lo + (hi - lo) / 2;
        ll cost = 0;
        bool flag = true;
        for(int i = 0;i<n;i++){
            if(mid < L[i]){
                flag = false; 
                break;
            }
            else{
                cost += (0 >mid - M[i]) ? 0 : mid - M[i];
            }
        }

        if(flag){
            if(cost <= m){
                lo = mid + 1;
                ans = mid;
            }
            else{
                hi = mid - 1;
            }
        }
        else{
            hi = mid - 1;
        }

    }
    cout << ans << '\n';
}




