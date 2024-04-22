#include <iostream>
#include <cstring>

using namespace std;

bool vis[100001] = {0};

bool complete[100001] = {0};

int student[100001];

int cnt;



void Group(int a){
    int next = student[a];
    vis[a] = 1;

    if(!vis[next]){
        Group(next);
    }
    else{
        if(!complete[next]){
            for(int i=next; i!= a; i = student[i]){
                cnt++;
            }
            cnt++;

        }
    }

    complete[a] = 1;




}




int main(){
    int t;

    scanf("%d", &t);

    for(int i=0; i<t; i++){
        cnt = 0;
        int n;
        scanf("%d", &n);


        for(int j=1; j<=n; j++){
            cin>>student[j];
        }

        for(int j=1; j<=n; j++){
            if(!vis[j]){
                Group(j);
            }
        }
        cout<<n - cnt<<'\n';



        memset(vis, 0, 100001);
        memset(complete, 0, 100001);

    }

}