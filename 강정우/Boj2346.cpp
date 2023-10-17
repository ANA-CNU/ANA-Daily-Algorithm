#include<iostream>
#include<deque>
using namespace std;
int main(){
    int n, k, t;
    cin>>n;
    int arr[n];
    for(int i=0;i<n;i++) cin>>arr[i];
    deque<int> dq;
    for(int i=1;i<=n;i++) dq.push_back(i);
    dq.pop_front();
    cout<<1<<" ";
    k=arr[0];
    while (dq.empty()!=true){
        if(k>0){
            for(int i=0;i<k-1;i++){
                t=dq.front();
                dq.pop_front();
                dq.push_back(t);
            }
            k=arr[dq.front()-1];
            cout<<dq.front()<<" ";
            dq.pop_front();
        }else{
            for(int i=0;i<-k;i++){
                t=dq.back();
                dq.pop_back();
                dq.push_front(t);
            }
            k=arr[dq.front()-1];
            cout<<dq.front()<<" ";
            dq.pop_front();
        }
    }
}
