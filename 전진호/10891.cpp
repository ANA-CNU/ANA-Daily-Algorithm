#include <iostream>
#include <vector>
#include <algorithm>
#include <utility>
#include <stack>
#include <set>

using namespace std;
using pii = pair<int,int>;
const int MAX = 100001;

vector<int> G[MAX];
int indegree[100001];
int dfsorder[100001];
bool vis[100001];
int dfscnt;
int V,E;
stack<pii> S;
vector<vector<pii>> bcc_res;

int min(int &a, int &b){
    return (a>b) ? b: a;
}

// dfs
int DFS(int cur, int prev = -1){
    //
    // 
    int res = dfsorder[cur] = ++dfscnt;

    // 인접 정점 순회
    for(int& next : G[cur]){
        // cout << next << '\n';
        if(next==prev) continue; 
        // 부모 정점인 경우 지나가기

        // 아직 방문 X -> 만약 방문했다면 
        // 부등식은 dfsorder[cur] <= dfsorder[next]
        if(dfsorder[cur] > dfsorder[next]) S.push({cur,next});

        if(dfsorder[next] > 0 ) {
            res = min(res, dfsorder[next]);
        }
        else{
            int temp = DFS(next, cur);
            res = min(temp, res);
            if(temp >= dfsorder[cur]){
                vector<pii> curBCC;
                pii end = {cur, next};
                while(!S.empty() && S.top() != end){
                    curBCC.push_back(S.top());
                    S.pop();
                }
                curBCC.push_back(S.top()); 
                S.pop();
                bcc_res.push_back(curBCC);
            }
        }
    }
    return res;
}

set<int> chk;
int main(void){
    ios::sync_with_stdio(false);cin.tie(0);cout.tie(0);
    cin >> V >> E;
    int s, e;
    for(int i = 0; i< E;i++){
        cin >> s >> e;       
        G[s].push_back(e);
        G[e].push_back(s); 
        // 무향 그래프
    }


    for(int i= 1;i<=V;i++){
        if(dfsorder[i]==0) DFS(i); 
    }
    // cout << bcc_res.size() << '\n';
    vector<int> ret;
    set<int> tmp;
    for(auto & bcc : bcc_res){
        for(pii & next : bcc){
            // cout << next.first << " " << next.second << " ";
            tmp.insert(next.first);
            tmp.insert(next.second);
            if(chk.find(next.first)!=chk.end() && !vis[next.first]){
                vis[next.first] = true;
                ret.push_back(next.first);
            }
            if(chk.find(next.second)!=chk.end() && !vis[next.second]){
                vis[next.second] = true;
                ret.push_back(next.second);
            }
        }
        for(auto it : tmp ){
            chk.insert(it);
        }
    }   
    cout << ret.size() << '\n';
    sort(ret.begin(), ret.end());
    for(int good : ret){
        cout << good << " ";
    }
    tmp.clear();
    cout << '\n';
}

// 1 
// 4 6
// 5 7
//   2 3
// 