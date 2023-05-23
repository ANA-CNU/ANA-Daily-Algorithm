#include <iostream>

using namespace std;





int main(){
    int n,num;
    cin>>n;
    int dp[12];
    dp[1] = 1;
    dp[2] = 2;
    dp[3] = 4;


    for(int i=0; i<n; i++){
        cin>>num;
            for(int j=4; j<=num; j++){
                dp[j] = dp[j-1] + dp[j-2] + dp[j-3];
            }

            cout<<dp[num]<<endl;
        }
}