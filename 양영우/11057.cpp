#include <iostream>

using namespace std;

int main(){

    long long dp[100001][10]; // 길이가 i이고 마지막 수가 j인 오르막 수의 개수
    int n,sum = 0;
    cin>>n;
    
    for(int i=0; i<10; i++){
        dp[1][i] = 1;
    }
    for(int i=1; i<=n; i++){
        for(int j= 0; j<10; j++){
            for(int k=0; k<=j; k++){
                dp[i][j] += dp[i-1][k];
                dp[i][j] %= 10007;
            }
        }
    }
    for(int i=0; i<10; i++){
        sum += dp[n][i];
    }
    cout<<sum % 10007;
}