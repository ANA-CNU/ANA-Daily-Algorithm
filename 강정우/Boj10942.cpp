#include <iostream>
using namespace std;
int main(){
    cin.tie(NULL); cout.tie(NULL); ios_base::sync_with_stdio(false);
    int n,k;
    cin>>n;
    int arr[n];
    bool res[n][n];
    for(int i=0;i<n;i++){
        for(int j=0;j<n;j++){
            res[i][j]=false;
        }
    }
    for(int i=0;i<n;i++)
        cin>>arr[i];
    for(int i=0;i<n;i++){
        res[i][i]= true;
    }
    for (int i = 0; i < n ; i++) {
        if (arr[i] == arr[i + 1])
            res[i][i + 1] = true;
    }
    for (int i = n-2; i >=0; i--) {
        for (int j = i + 2; j < n; j++) {
            if (arr[i] == arr[j] && res[i + 1][j - 1]) {
                res[i][j] = true;
            }
        }
    }
    cin>>k;
    for(int i=0;i<k;i++){
        int a,b;
        cin>>a>>b;
        if(res[a-1][b-1])
            cout<<1<<"\n";
        else
            cout<<0<<"\n";
    }
}
