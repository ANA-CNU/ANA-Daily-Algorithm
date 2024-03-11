#include <iostream>
#include <algorithm>

#include <vector>



const int INF = 1e9;

using namespace std;


int v,e;

int a,b,c;


int d[402][402];



int main(){
    cin.tie(0);
    cin>>v>>e;

    for(int i=1; i<=v; i++){
        fill(d[i], d[i] + v + 1,INF);
        d[i][i] = 0;
    }


    for(int i=1; i<=e; i++){
        cin>>a>>b>>c;
        d[a][b] = min(d[a][b], c);
    }




    for(int i=1; i<=v; i++){
        for(int j=1; j<=v; j++){
            for(int k=1; k<=v; k++){
                d[j][k] = min(d[j][i] + d[i][k], d[j][k]);
            }
        }
    }


    int min_cnt = INF;





    for(int i=1; i<=v; i++){
        for(int j=i+1; j<=v; j++){
            min_cnt = min(min_cnt, d[i][j] + d[j][i]);
        }
    }

    if(min_cnt == INF){
        min_cnt = -1;
    }

    cout<<min_cnt;



}
