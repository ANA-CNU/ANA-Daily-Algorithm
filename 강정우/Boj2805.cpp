#include<iostream>
#include<algorithm>
using namespace std;
int main(){
    int n,m;
    cin>>n>>m;
    int arr[n];
    for(int i=0;i<n;i++){
        cin>>arr[i];
    }
    sort(arr,arr+n);
    int left=0;
    int right=arr[n-1];
    int mid;
    int result=0;
    while(left<=right){
        mid=(left+right)/2;
        long long sum=0;
        for(int i=0;i<n;i++){
            if(arr[i]>mid){
                sum+=arr[i]-mid;
            }
        }
        if(sum>=m){
            result=mid;
            left=mid+1;
        }
        else{
            right=mid-1;
        }
    }
    cout<<result;
    return 0;
}
