#include <bits/stdc++.h>
using namespace std;
int t,n,a;
priority_queue<int> down;
priority_queue<int, vector<int>, greater<int>> up;
vector<int> v;
int main()
{
    for(scanf("%d",&t);t--;) {
        scanf("%d",&n);
        for(int i=1; i<=n; i++) {
            scanf("%d",&a);
            if(up.empty()) {
                up.push(a);
            }
            else if(down.empty()) {
                if(up.top() > a) down.push(a);
                else {
                    down.push(up.top());
                    up.pop();
                    up.push(a);
                }
            }
            else {
                if(up.size() == down.size()) {
                    if(down.top() < a) up.push(a);
                    else {
                        up.push(down.top());
                        down.pop();
                        down.push(a);
                    }
                }
                else {
                    if(up.top() > a) down.push(a);
                    else {
                        down.push(up.top());
                        up.pop();
                        up.push(a);
                    }
                }
            }

            if(i%2) {
                v.push_back(up.top());
            }
        }
        printf("%d\n",(n+1)/2);
        int v_size = v.size();
        for(int i=0; i<v_size; i++) {
            if(i != 0 && i % 10 == 0) {
                printf("\n%d ",v[i]);
            }
            else {
                printf("%d ",v[i]);
            }
        }
        printf("\n");
        v.clear();
        while(!up.empty()) up.pop();
        while(!down.empty()) down.pop();
    }
    return 0;
}
