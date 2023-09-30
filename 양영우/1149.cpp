#include <iostream>
#include <algorithm>

using namespace std;

int dp[1001][4] = {0};
int color[1001][4] = {0};
int n;

int main(){
    cin>>n;
    int sum = 100000000;

    for(int i=1; i<=n; i++){
        for(int j=1; j<=3; j++){
            cin>>color[i][j];
        }
    }
    dp[1][1] = color[1][1];
    dp[1][2] = color[1][2];
    dp[1][3] = color[1][3];

    for(int i=2; i<=n; i++){
        for(int j=1; j<=3; j++){
            if(j==1){
                dp[i][1] = min(dp[i-1][2],dp[i-1][3]) + color[i][1];
            }
            else if(j==2){
                dp[i][2] = min(dp[i-1][1], dp[i-1][3]) + color[i][2];
            }
            else{
                dp[i][3] = min(dp[i-1][1], dp[i-1][2]) + color[i][3];
            }
        }
        
    }

    for(int i=1; i<=3; i++){
        sum = min(sum, dp[n][i]);
    }

    cout<<sum;

    
    




}