#include <iostream>
#include <string>
#include <algorithm>
#include <set>
using namespace std;
int main(){
    int n;
    cin>>n;
    int arr1[n];
    for(int i=0;i<n;i++){
        cin>>arr1[i];
    }
    int k;
    cin>>k;
    int arr2[k];
    for(int i=0;i<k;i++){
        cin>>arr2[i];
    }
    sort(arr1,arr1+n);
    for(int i:arr2){
        cout<<upper_bound(arr1,arr1+n,i)-lower_bound(arr1,arr1+n,i)<<" ";
    }
}
