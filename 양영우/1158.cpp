#include <iostream>
#include <queue>


using namespace std;


int main(){
    
    int n,k,num = 0;
    cin>>n>>k;
    queue<int> q;
    
    for(int i=1; i<=n; i++){
        q.push(i);
    }
    cout<<"<";
    
    while(q.size()>1){
        for(int i=0; i<k-1; i++){
            num = q.front();
            q.pop();
            q.push(num);
        }
        cout<<q.front()<<", ";
        q.pop();
    }
    cout<<q.front()<<">";

}