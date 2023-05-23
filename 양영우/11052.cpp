#include <iostream>

using namespace std;


int main(){
    int n,num;
    cin>>n;
    int dp[10001];
    int sum[10001];
    sum[0] = 0;

    for(int i=1; i<=n; i++){
        cin>>num;
        dp[i] = num;
    }

    for(int i=1; i<=n; i++){
        for(int j=1; j<=i; j++){
            sum[i] = max(sum[i-j]+dp[j], sum[i]);
        }
    }
    cout<<sum[n];
}