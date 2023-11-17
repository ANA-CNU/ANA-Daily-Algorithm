#include <bits/stdc++.h>
using namespace std;
stack<char> s;
char arr[500001];
int main()
{
    int n,k;
    scanf("%d %d ",&n,&k);
    gets(arr);

    for(int i=0; i<n; i++) {
        if(s.empty()) {
            s.push(arr[i]);
        }
        else {
            if(s.top() >= arr[i]) s.push(arr[i]);
            else {
                while(!s.empty() && k && s.top() < arr[i]) {
                        s.pop();
                        k--;
                }
                s.push(arr[i]);
            }
        }
    }
    while(k) {
        s.pop();
        k--;
    }
    vector<char> v;
    while(!s.empty()) {
        v.push_back(s.top());
        s.pop();
    }
    reverse(v.begin(), v.end());

    for(int i=0; i<v.size(); i++) printf("%c",v[i]);
    return 0;
}
