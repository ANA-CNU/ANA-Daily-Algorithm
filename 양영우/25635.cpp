#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;



int main(){
    int n;
    cin>>n;


    vector<long long> v;

    long long num;


    

    for(int i=1; i<=n; i++){
        cin>>num;
        v.push_back(num);
    }


    sort(v.begin(), v.end());


    long long tmp = 0;

    int size = v.size();

    for(int i=0; i<size-1; i++){
        tmp += v[i];
    }

    if(tmp < v[size-1]){
        cout<<tmp * 2 + 1;
    }
    else{
        cout<<tmp + v[size-1];
    }



}