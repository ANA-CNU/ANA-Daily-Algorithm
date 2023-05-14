#include <iostream>
#include <vector>
using namespace std;

int main(){
    int n, k;
    cin >> n >> k;

    vector<int> v;
    vector<int> res;

    for(int i=1; i<= n; i++)
        v.push_back(i);
    
    int p = k-1;
    
    while(v.size() > 1){
        while(p>=v.size()){
            p = p%v.size();
        }
        res.push_back(v[p]);
        v.erase(v.begin() + p);
        p+=(k-1);
    }

    res.push_back(v[0]);

    cout << "<" << res[0];
    for(int i=1; i<res.size(); i++)
        cout << ", " << res[i];
    cout << ">";
}