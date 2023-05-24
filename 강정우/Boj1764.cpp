#include <iostream>
#include <string>
#include <algorithm>
#include <set>
using namespace std;
int main(){
    int a, b;
    cin >> a >> b;
    set<string> set1;
    set<string> set2;
    for(int i=0; i<a; i++){
        string s;
        cin >> s;
        set1.insert(s);
    }
    for(int i=0; i<b; i++){
        string s;
        cin >> s;
        set2.insert(s);
    }
    set<string> result;
    set_intersection(set1.begin(), set1.end(), set2.begin(), set2.end(), std::inserter(result, result.begin()));
    cout<<result.size()<<endl;
    string result2[result.size()];
    int i=0;
    for(string k: result){
        result2[i++]=k;
    }
    sort(result2, result2+result.size());
    for(string k: result){
        cout<<k<<endl;
    }
}
