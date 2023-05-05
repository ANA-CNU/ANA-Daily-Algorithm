#include <bits/stdc++.h>

using namespace std;
typedef long long ll;
struct M{
    ll type;
    ll att;
    ll hp;
}P[130000];


int n,m;

bool check(int n, ll Maxhp, ll at){

    ll cur_hp = Maxhp;
    for(int i = 0;i<n;i++){
        if(P[i].type==1){
            ll cnt = (P[i].hp + at - 1) / at; // 나머지 때문에 올림
            cur_hp -= (cnt - 1) * P[i].att; // 선빵 치니까 cnt -1 
            if(cur_hp <= 0){return false;}
        }
        else{ // portion 
            cur_hp = min(cur_hp+P[i].hp, Maxhp);
            at += P[i].att;
        }
    }
    return cur_hp > 0;
}

void sol(int at){


    ll lo = 1; ll hi = (1e18);
    ll ans = 1e18;
    while(lo <= hi){
        ll mid = lo + (hi-lo)/2;
        if (check(n, mid, at)){
            ans = mid;
            hi = mid-1;
        }
        else{
            lo = mid + 1;
        }
    }
    cout << lo << '\n';
    return;
}

int main(void){
    ios::sync_with_stdio(false);cin.tie(0);cout.tie(0);
    cin >> n >> m;
    for(int i = 0;i<n;i++){
        cin >> P[i].type >> P[i].att >> P[i].hp;
    }
    sol(m);
    return 0;
}