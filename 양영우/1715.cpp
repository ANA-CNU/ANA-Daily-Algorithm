#include <iostream>
#include <queue>
#include <vector>


using namespace std;

int main(){
    int n;
    int cnt = 0;
    int num;
    int ans = 0;
    cin>>n;

    int a;

    priority_queue<int, vector<int>, greater<int> > pq;

    for(int i=0; i<n; i++){
        cin>>num;
        pq.push(num);

    }

    while(n>1){
        a = pq.top(); pq.pop();
        a += pq.top(); pq.pop();
        pq.push(a);
        ans+= a;
        n--;
    }
    
    cout<<ans;



}