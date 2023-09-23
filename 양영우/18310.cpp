#include <iostream>
#include <algorithm>
#include <vector>

using namespace std;


int main(){
    int n;
    cin>>n;
    int a;

    vector<int> home;

    for(int i=0; i<n; i++){
        cin>>a;
        home.push_back(a);
    }


    sort(home.begin(), home.end());


    cout<<home[(n-1)/2];





}