#include <iostream>

using namespace std;

int main(){
    int n;
    long long dp[81];
    cin>>n;
    dp[1] = 1;
    dp[2] = 1;


    for(int i=3; i<=n; i++){
        dp[i] = dp[i-1] + dp[i-2];
    }



    long long width = dp[n] + dp[n-1];
    long long length = dp[n];

    if(n == 1){
        cout<<4;
    }
    else{
        cout<< 2 * (width + length);

    }








}