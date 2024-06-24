#include <iostream>
#include <algorithm>

using namespace std;



int dp[1001][1001];






int main(){

    string str_a, str_b;

    string result = "";

    cin>>str_a;
    cin>>str_b;

    int len_a = str_a.size();
    int len_b = str_b.size();

    for(int i=0; i<=len_a; i++){
        for(int j=0; j<=len_b; j++){
            dp[i][j] = 0;
        }
    }


    for(int i=1; i<=len_a; i++){
        for(int j=1; j<=len_b; j++){
            if(str_a[i-1] == str_b[j-1]){
                dp[i][j] = dp[i-1][j-1] + 1;
            }
            else{
                dp[i][j] = max(dp[i-1][j], dp[i][j-1]);
            }
        }
    }

    int lcs_a = len_a;
    int lcs_b = len_b;



    while(len_a > 0 && len_b > 0){
        if(str_a[len_a - 1] == str_b[len_b-1]){
            result += str_a[len_a-1];
            len_a--;
            len_b--;
        }
        else{
            if(dp[len_a-1][len_b] > dp[len_a][len_b-1]) len_a--;
            else len_b--;
        }
    }


    reverse(result.begin(), result.end());



    cout<<dp[lcs_a][lcs_b]<<'\n';

    cout<<result;


    









}