#include <iostream>

using namespace std;

int main(){
    int n,k,coin;
    cin>>n>>k;

    
    long long *value = new long long[n+1]; // n번쨰의 동전의 가치
    
    long long dp[10001] = {0}; // dp[i] : 가치가 i 인 경우의 수 


    for(int i=1; i<=n; i++){
        cin>>coin;
        value[i] = coin;
    }
    dp[0] = 1;

    for(int i=1; i<=n; i++){
        for(int j=1; j<=k; j++){
            if(j-value[i] < 0){
                continue;
            }
            dp[j] += dp[j-value[i]];
        }
    }
    cout<<dp[k];
}