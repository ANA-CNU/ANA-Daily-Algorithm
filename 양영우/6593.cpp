#include <iostream>
#include <queue>
#include <tuple>

using namespace std;




int main(){
    while(true){
        int l,r,c;
        cin>>l>>r>>c;
        char arr[31][31][31];
        int dx[6] = {1, -1, 0, 0, 0, 0};
        int dy[6] = {0, 0, 1, -1, 0, 0};
        int dz[6] = {0, 0, 0, 0, 1, -1};
        int time[31][31][31];
        bool escape = false;

        if(l==0 && r==0 && c==0)break;
        queue<tuple<int,int,int> > Q;

        for(int i=0; i<l; i++){
            for(int j=0; j<r; j++){
                fill(time[i][j], time[i][j] + c, 0);
            }
        }

        for(int i=0; i<l; i++){
            for(int j=0; j<r; j++){
                for(int k=0; k<c; k++){
                    cin>>arr[i][j][k];
                    if(arr[i][j][k] == 'S'){
                        Q.push({i,j,k});
                        time[i][j][k] = 0;
                    }
                    else if(arr[i][j][k] == '.'){
                        time[i][j][k] = -1;
                    }
                }
            }
        }
    

    

        while(!Q.empty()){
            if(escape) break;
            
            tuple<int,int,int> cur = Q.front();
            Q.pop();
            for(int i=0; i<6; i++){
                int nx = dx[i] + get<0>(cur);
                int ny = dy[i] + get<1>(cur);
                int nz = dz[i] + get<2>(cur);
                if(nx >=l || nx < 0 || ny >= r || ny < 0 || nz >= c || nz < 0 ) continue;
                if(arr[nx][ny][nz] == '#' || time[nx][ny][nz] >0) continue;
                time[nx][ny][nz] = time[get<0>(cur)][get<1>(cur)][get<2>(cur)] + 1;
                if(arr[nx][ny][nz] == 'E'){
                    cout<<"Escaped in "<< time[nx][ny][nz]<< " minute(s)."<<'\n';
                    escape = true;
                    break;
                }
                Q.push({nx,ny,nz});
            }
        }
        while(!Q.empty()){
            Q.pop();
        }
        if(!escape){
            cout<<"Trapped!"<<'\n';
        }
        escape = false;
    }
}