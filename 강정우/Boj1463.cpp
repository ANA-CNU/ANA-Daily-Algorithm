#include <iostream>
#include <queue>
#include <cstring>
using namespace std;
int main(){
    int n;
    cin>>n;
    int arr[n+1];
    memset(arr, 0x3f, sizeof(arr));
    arr[n] = 0;
    queue<int>q;
    q.push(n);
    while(!q.empty()){
        int k=q.front();
        q.pop();
        if(k%3==0&&arr[k/3]>arr[k]+1){
            arr[k/3]=arr[k]+1;
            q.push(k/3);
        }
        if(k%2==0&&arr[k/2]>arr[k]+1){
            arr[k/2]=arr[k]+1;
            q.push(k/2);
        }
        if(k>1&&arr[k-1]>arr[k]+1){
            arr[k-1]=arr[k]+1;
            q.push(k-1);
        }
    }
    cout<<arr[1];
}
