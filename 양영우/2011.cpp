#include <iostream>

using namespace std;


int main(){
    int dp[5001] = {0};

    string a;

    cin>>a;

    int len = a.length();
    
    if (a.empty() || a[0] == '0') {
        cout << 0 << endl;
        return 0;
    }


    dp[0] = 1;
    dp[1] = 1;    


    for(int i=2; i<=len; i++){
        if(a[i-1] != '0') dp[i] = dp[i-1] % 1000000;
        int m = a[i-2] - '0';
        int n = a[i-1] - '0';
        if((m * 10 + n) <= 26 && (m * 10 + n)>= 10){
            dp[i] = (dp[i] + dp[i-2]) % 1000000;
        }

    }
    cout<<dp[len];
}


