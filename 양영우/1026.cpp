#include <iostream>
#include <algorithm>


using namespace std;

int main(){
    int n;
    int a,b;
    int a_arr[51];
    int b_arr[51];
    int sum = 0;
    cin>>n;

    for(int i=0; i<n; i++){
        cin>>a_arr[i];
    }
        for(int i=0; i<n; i++){
        cin>>b_arr[i];
    }
    sort(a_arr,a_arr+n);
    sort(b_arr,b_arr+n,greater<>());

    for(int i=0; i<n; i++){
        sum+=(a_arr[i] * b_arr[i]);
    }
    cout<<sum;

    





}