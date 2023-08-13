#include <iostream>
#include <algorithm>

using namespace std;

int main(){
    int n,s;
    cin>>n>>s;
    int length = 200000;

    int nums[n];
    for(int i=0; i<n; i++){
        cin>>nums[i];
    }

    int en = 0;
    int cnt = nums[0];

    for(int st = 0; st<n; st++){
        while(en < n && cnt < s){
            en++;
            if(en!= n){
                cnt += nums[en];
            }
        }
        if(en == n) break;
        length = min(length, en - st + 1);
        cnt -= nums[st];
    }
    if(length == 200000) cout<<0;
    else{
        cout<<length;
    }
}