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

const int dy[4] = {-1,0,1,0};
const int dx[4] = {0,-1,0,1};
int main(){
    ios_base::sync_with_stdio(0);
    cin.tie(0); cout.tie(0);
    cin >> n >> m;
    for(int i=0; i<=n + 1; i++) for(int j= 0; j<=n + 1; j++) block[i][j] = 1;
    vector<pair<int,int>> virus;
    for(int i =1; i<=n; i++) {
        for(int j =1; j<=n; j++) {
            cin >> block[i][j];
            if(block[i][j] == 2) virus.push_back({i,j});
        }
    }

    vector<int> pos(virus.size(), 0);
    for(int i =0; i<m; i++) pos[i] = 1;

    int ret = INF;
    do {
        queue<pair<int,pair<int,int>>> q;
        memset(visited, 0, sizeof(visited));
        for(int i =0; i< pos.size(); i++) {
            int y = virus[i].first, x = virus[i].second;
            if(pos[i] == 0) continue;
            visited[y][x] = true;
            q.push({0, {y, x}});
        }
        
        int tmp = 0;
        while(!q.empty()) {
            auto p  = q.front().second;
            int dist = q.front().first;
            if(block[p.first][p.second] != 2)
                tmp = max(tmp, dist);
                
            q.pop();
            int y = p.first, x = p.second;
            for(int i=0; i<4; i++) {
                int ny = y + dy[i], nx = x + dx[i];
                if(block[ny][nx] != 1 && visited[ny][nx] == 0) {
                    visited[ny][nx] = dist + 1;
                    q.push({dist + 1, {ny,nx}});
                }
            }
        }

        bool flag = false;
        for(int i =1; i <=n; i++){
            for(int j =1; j<=n; j++) {
                if(!visited[i][j] && block[i][j] != 1) {
                    flag = true;
                }
            }
        }

        if(!flag) {
            ret = min(ret, tmp);
        }

    } while(next_permutation(pos.rbegin(), pos.rend()));
    if(ret == INF) cout << -1 << endl;
    else cout << ret << endl;
    return 0;
}

