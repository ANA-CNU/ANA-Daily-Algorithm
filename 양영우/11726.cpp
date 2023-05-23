#include <iostream>

using namespace std;



int main(){
    int n;
    cin>>n;
    int dp[1001];
    dp[1] = 1;
    dp[2] = 2;

    if(n==1){
        cout<<dp[1];
    }
    else if(n==2){
        cout<<dp[2];
    }
    else{
        for(int i=3; i<=n; i++){
            dp[i] = (dp[i-2] + dp[i-1])%10007;
        }
        cout<<dp[n];
    }

}