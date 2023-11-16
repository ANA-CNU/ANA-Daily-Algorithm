#include <bits/stdc++.h>
using namespace std;
int n;
int arr[500001];
typedef struct {
    int value;
    long long int cnt;
}st;
long long int cnt;
stack<st> s;
int main()
{
    scanf("%d",&n);
    for(int i=0; i<n; i++) scanf("%d",&arr[i]);
    for(int i=0; i<n; i++) {
        while(!s.empty() && s.top().value < arr[i]) {
            st x = s.top();
            cnt += x.cnt;
            s.pop();
        }
        if(!s.empty()) {
            if(s.top().value > arr[i]) {
                cnt++;
                s.push({arr[i], 1});
            }
            else {
                cnt += s.top().cnt;
                if(s.size() > 1) cnt++;
                s.top().cnt++;
            }
        }
        else s.push({arr[i], 1});
    }

    printf("%d",cnt);
    return 0;
}
