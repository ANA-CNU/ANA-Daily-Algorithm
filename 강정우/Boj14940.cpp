#include <iostream>
#include <vector>
#include <queue>
using namespace std;

vector<vector<int>> v;
int n, m;
vector<vector<int>> visited;

int dx[4] = {0, 0, -1, 1};
int dy[4] = {-1, 1, 0, 0};

void visit(int y,int x){
    queue<pair<int,int>> q;
    q.push({y,x});
    visited[y][x] = 0;

    while(!q.empty()){
        int cy = q.front().first;
        int cx = q.front().second;
        q.pop();

        for(int i=0; i<4; i++){
            int nx = cx + dx[i];
            int ny = cy + dy[i];

            if(nx>=0 && ny>=0 && nx<m && ny<n && v[ny][nx]!=0 && visited[ny][nx]==-2){
                visited[ny][nx] = visited[cy][cx]+1;
                q.push({ny,nx});
            }
        }
    }
}

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    cin >> n >> m;

    v.resize(n,vector<int>(m));
    visited.assign(n,vector<int>(m,-2));

    int y,x;

    for(int i=0;i<n;i++){
        for(int j=0;j<m;j++){
            cin >> v[i][j];
            if(v[i][j]==2){
                y=i;x=j;
            }
            else if(v[i][j]==0){
                visited[i][j]=0;
            }
        }
    }

    visit(y,x);

    for(int i=0;i<n;i++){
        for(int j=0;j<m;j++){
            if(visited[i][j]==-2) cout << "-1 ";
            else cout << visited[i][j] << " ";
        }
        cout << "\n";
    }

    return 0;
}
