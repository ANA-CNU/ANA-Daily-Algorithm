#include <iostream>
#include <vector>
#include <queue>



using namespace std;


vector<int> adj[1001];


int deg[1001];


int main(){
    int cnt = 0;
    int n,m;

    int arr[1001] = {0};
    cin>>n>>m;
    


    queue<int> Q;
    queue<int> ans;

    for(int i=0; i<m; i++){
        int a;
        cin>>a;
        for(int j=0; j<a; j++){
            cin>>arr[j];
        }
        for(int k=0; k<a-1; k++){
            adj[arr[k]].push_back(arr[k+1]);
            deg[arr[k+1]]++;
        }
        fill_n(arr,1001,0);
    }


    for(int i=1; i<=n; i++){
        if(deg[i] == 0) Q.push(i);
    }


    while(!Q.empty()){
        int cur = Q.front(); Q.pop();
        
        cnt++;
        ans.push(cur);

        for(size_t i = 0; i < adj[cur].size(); i++){
            int nxt = adj[cur][i];
            deg[nxt]--;
            if(deg[nxt] == 0) Q.push(nxt);
        }
    }

    if(cnt !=n) cout<<0;
    else{
        while(!ans.empty()){
            cout<<ans.front()<<'\n';
            ans.pop();
        }
    }







    

    




    



    
}