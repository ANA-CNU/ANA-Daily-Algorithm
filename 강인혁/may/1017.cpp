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
#define endl '\n';
typedef long long ll;
using namespace std;
const ll INF = 0x3f3f3f3f;

vector<int> a;
int n;
bool isPrime[2222];
void preCalc() {
    for(int i=2; i<2222; i++) {
        if(isPrime[i]) continue;
        for(int j = i + i; j < 2222; j+=i) {
            isPrime[j] = 1;
        }
    }
}

int adj[1111][1111];
int rGraph[1111][1111];
int networkFlow(int s, int t) {
    for(int i=0; i<111; i++) for(int j =0; j<111; j++) {
        rGraph[i][j] = adj[i][j];
        // cout << rGraph[i][j] << " ";
    }
    // 0, idx번은 이미 흘러야함, 정점으로 바꾸면
    
    int ret = 0;
    while(1) {
        queue<int> q;
        q.push(s);
        vector<int> parent(n + 2, -1);
        parent[s] = s;
        while(!q.empty() && parent[t] == -1) {
            int here = q.front();
            q.pop();
            for(int next = 0; next < n + 2; next++) {
                if(rGraph[here][next] > 0 && parent[next] == -1) {
                    q.push(next);
                    parent[next] = here;
                }
            }
        }
        if(parent[t] == -1) break;
        int flow = INF;
        for(int p = t; p != s; p = parent[p]) {
            flow = min(flow, rGraph[parent[p]][p]);
        }
        for(int p =t; p != s; p = parent[p]) {
            rGraph[parent[p]][p] -= flow;
            rGraph[p][parent[p]] += flow;
        }
        ret += flow;
    }
    // cout << ret << " flow" << endl;
    return ret;
}

int even[1111], odd[1111];
// 0, idx번을 제외한 정점들끼리 이분매칭이 가능한가
// 0, idx는 1을  capacity 0
bool func(int idx) {
    // makeGraph
    memset(adj, 0, sizeof(adj));
    int eCnt = 0, oCnt = 0;
    for(int i=0; i<n; i++) {
        if(a[i] % 2 == 0) {
            even[eCnt++] = a[i];
        }
        else odd[oCnt++] = a[i];
    }
    if(eCnt != oCnt) return false;
    // even to odd
    for(int i =0; i < n/2; i++) {
        for(int j =0; j< n/2; j++) {
            if(isPrime[even[i] + odd[j]] == 0) {
                if(even[i] == a[0] || odd[j] == a[0]) continue;
                if(even[i] == a[idx] || odd[j] == a[idx]) continue;
                adj[2 + i][2 + n/2 + j] = 1;
            }
        }
    }

    for(int i =0; i< n/2; i++) {
        // src to even
        // even is 2 to 2 + n/2 - 1
        adj[0][2 + i] = 1;
    }
    // odd to sink
    // cout << "vertexIdx ";
    for(int i=0; i<n/2; i++) {
        adj[2 + n/2 + i][1] = 1;
    }
    // 0 = src, 1 = sink
    // 2 ~ matchCnt + 1 = matches
    // matchCnt + 2 ~ matchCnt + n -2 + 1 = vertex
    
    int ret = networkFlow(0, 1);
    // if(idx == 4)
    //     cout << a[idx] << endl;
    return ret == n/2 - 1;
}

int main()
{
    ios_base::sync_with_stdio(0);
    cin.tie(0); cout.tie(0);
cin >> n;
    a = vector<int>(n);
    for(int i=0; i<n; i++) cin >> a[i];
    preCalc();
    
    vector<int> ans;
    for(int i =1; i <n; i++) {
        int num = a[i] + a[0];
        if(isPrime[num] == 0) {
            if(func(i)) ans.push_back(a[i]);
        }
    }
    sort(ans.begin(), ans.end());
    if(ans.empty()) cout << -1;
    else {
        for(auto a : ans) cout << a << " ";
    }
    return 0;
}
