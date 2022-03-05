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
int main(){
    ios_base::sync_with_stdio(0);
    cin.tie(0); cout.tie(0);

    cin >> n >> m;
    vector<pair<int,int>> path;
    vector<pair<int,int>> house;
    int cnt = 0;
    for(int i=0; i<n; i++) {
        for(int j =0; j<n; j++) {
            cin >> block[i][j];
            if(block[i][j] == 2) {
                path.push_back({i, j});
                cnt++;
            }
            else if(block[i][j] == 1) house.push_back({i,j});
        }
    }
    vector<int> perm;
    for(int i = m; i < cnt; i++) perm.push_back(0);
    for(int i =0; i<m; i++) perm.push_back(1);

    int ret = INF;
    do {
        vector<pair<int,int>> left;
        for(int i =0; i < cnt; i++)
            if(perm[i])
                left.push_back({path[i].first, path[i].second});
        int tmp = 0;
        for(auto h : house) {
            int y = h.first, x = h.second;
            int dist = INF;
            for(auto l : left) dist = min(dist, abs(y - l.first) + abs(x - l.second));
            tmp += dist;
        }
        if(ret > tmp) {
            ret = tmp;
        }
    } while(next_permutation(perm.begin(), perm.end()));


    cout << ret << endl;
    return 0;
}

