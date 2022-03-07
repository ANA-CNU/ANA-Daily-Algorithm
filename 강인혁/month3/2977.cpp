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

int n, m;
int block[55][55];
int visited[55][55];

int s[111][2];
int p[111][2];
int part[111];
int h[111];

// idx번째 부품을 k개이상 만들 수 있는 최소가격
int func(int idx, int k) {
    int ret = 111111;
    int requireCnt = part[idx] * k - h[idx];
    int curHave = h[idx];
    
    for(int first =0; (first - 1) * s[idx][0] <= requireCnt; first++) {
        int second = requireCnt - first * s[idx][0];
        second += s[idx][1] - 1;
        second /= s[idx][1];

        int cost = p[idx][0] * first + p[idx][1] * second;
        ret = min(ret, cost);
    }
    return ret;
}

// m원으로 k개의 부품을 만들 수 있는가
bool decision(int k) {
    int cost = 0;
    for(int i =0; i<n; i++) {
        cost += func(i,
         k);
    }
    return cost <= m;
}

int main(){
    ios_base::sync_with_stdio(0);
    cin.tie(0); cout.tie(0);
    
    cin >> n >> m;
    for(int i =0; i<n; i++) {
        cin >> part[i] >> h[i] >> s[i][0] >> p[i][0] >> s[i][1] >> p[i][1];
    }

    int k = 111111;
    int lo = 0, hi = k;
    while(lo + 1 < hi) {
        int mid = (lo + hi) / 2;
        // decision(lo) = true
        if(decision(mid)) {
            lo = mid;
        }
        else hi = mid;
    }
    cout << lo << endl;
    return 0;
}


