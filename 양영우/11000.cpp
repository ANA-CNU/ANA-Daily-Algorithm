#include <iostream>
#include <vector>
#include <queue>
#include <algorithm>

using namespace std;

int main(){
    int n;
    int s,t;
    cin>>n;

    vector<pair<int,int> > time;

    priority_queue<int,vector<int>, greater<int> > pq;



    for(int i=0; i<n; i++){
        cin>>s>>t;
        time.push_back({s,t});
    }

    sort(time.begin(), time.end());

    pq.push(time[0].second);

    for(int i=1; i<n; i++){
        int start = time[i].first;
        int end = time[i].second;
        if(start >=pq.top()){
            pq.pop();
            pq.push(end);
        }
        else{
            pq.push(end);
        }
    }

    cout<<pq.size();








}
