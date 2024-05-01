#include <iostream>
#include <algorithm>

using namespace std;

#define MAX 1e9;

int main(){

    int n,k;


    cin>>n>>k;

    int dp[100001];

    int coin[101];

    for(int i=0; i<n; i++){
        cin>>coin[i];
    }

    for(int i=1; i<=k; i++){
        dp[i] = MAX;
    }


    sort(coin, coin + n);


    for(int i=0; i<n; i++){
        for(int j= coin[i]; j<=k; j++){
            dp[j] = min(dp[j],dp[j-coin[i]] + 1);
        }
    }

    if(dp[k] == 1e9){
        cout<<-1;
    }
    else{
        cout<<dp[k];
    }


    


}