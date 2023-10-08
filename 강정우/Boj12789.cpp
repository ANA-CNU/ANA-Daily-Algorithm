#include <iostream>
#include <stack>
#include <vector>
using namespace std;
int main(){
    bool result = true;
    int t,count,input;
    cin >> t;
    stack<int> s;
    vector<int> v;
    for(int i=0;i<t;i++){
        cin >> input;
        v.push_back(input);
    }
    count = 1;
    for(int i=0;i<t;i++){
        if(v[i] == count){
            count++;
        }
        else if(!s.empty() && s.top() == count){
            s.pop();
            count++;
            i--;
        }
        else{
            s.push(v[i]);
        }
    }
    while(!s.empty()){
        if(s.top() == count){
            s.pop();
            count++;
        }
        else{
            result = false;
            break;
        }
    }
    if(result) cout << "Nice";
    else cout << "Sad";
}
