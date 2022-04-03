#include <iostream>
#include <vector>
#include <string.h>

using namespace std;

int main()
{
    int n;
    cin >> n;
    string strs;
    cin >> strs;
    int w_num = 0;
    int e_num = 0;
    vector<int> w_count(1);
    vector<int> e_count(1);
    for(int i = 0; i < strs.length(); i++){
        if(strs[i] == 'W'){
            w_num += 1;
        }
        else if(strs[i] == 'H'){
            w_count.push_back(w_num);
            e_count.push_back(e_num);
        }
        else if(strs[i] == 'E'){
            e_num += 1;
        }
    }

    vector<int> e_dp(1);
    for(int i = 1; i <= e_num; i++){
        e_dp.push_back((i-1) + 2*e_dp.back());
    }

    int ans = 0;
    for(int i = 1; i < w_count.size(); i++){
        int e_num_i_to_end = e_num - e_count[i];
        ans += w_count[i] * e_dp[e_num_i_to_end];
    }

    cout << (ans%1000000007);
    return 0;
}
