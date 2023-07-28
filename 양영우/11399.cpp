#include <iostream>
#include <algorithm>

using namespace std;

int main(){
    int n;
    int time;
    int a = 0, total = 0;
    cin>>n;
    int*  arr = new int[n+1];

    for(int i=1; i<=n; i++){
        cin>>arr[i];
    }
    sort(arr,arr+(n+1));

    for(int i=1; i<=n; i++){
        a += arr[i];
        total += a;
    }
    cout<<total;
}