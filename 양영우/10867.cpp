#include <iostream>
#include <algorithm>

using namespace std;

int main(){
    int n;
    cin>>n;
    int arr[100001];

    for(int i=0; i<n; i++){
        cin>>arr[i];
    }
    sort(arr, arr+n);

    for(int i=0; i<n; i++){
        if(i == 0){
            cout<<arr[i]<<" "; 
        }
        else if(arr[i] != arr[i-1]){
            cout<<arr[i]<<" ";
        }
    }



}