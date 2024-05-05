#include <iostream>
#include <stack>
using namespace std;

int n;
string str;
stack<int> s;

int main(){
    cin >> n >> str;
    s.push(-1);
    int ans = 0;
    for(int i=0; i<n; i++){
        if(str[i] == '(')
            s.push(i);
        else{
            s.pop();
            if(!s.empty())
                ans = max(ans, i - s.top());
            else
                s.push(i);
        }
    }
    cout << ans;
}
