#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;


int main(){
    int n;
    cin>>n;

    vector<pair<int,int> > v(n);

    for(int i=0; i<n; i++){
        cin>>v[i].second;
    }

    for(int i=0; i<n; i++){
        cin>>v[i].first;
    }


    long long sum = 0;


    sort(v.begin(), v.end());


    for(int i=0; i<n; i++){
        sum += v[i].first * i + v[i].second;
    }

    cout<<sum;




    




}