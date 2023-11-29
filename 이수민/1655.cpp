#include <bits/stdc++.h>
using namespace std;
priority_queue<int> lv;
priority_queue<int, vector<int>, greater<int> > rv;
int main()
{
    int t, m, k;

    scanf("%d",&t);
    for(int i=0; i<t; i++) {
        scanf("%d",&k);
        if(lv.empty()) lv.push(k);
        else {
            if(k <= lv.top()) {
                if(lv.size() - rv.size() == 1) {
                    lv.push(k);
                    rv.push(lv.top());
                    lv.pop();
                }
                else lv.push(k);
            }
            else {
                if(rv.empty()) rv.push(k);
                else {
                    if(lv.size() - rv.size() == 1) rv.push(k);
                    else {
                        rv.push(k);
                        lv.push(rv.top());
                        rv.pop();
                    }
                }
            }
        }

        printf("%d\n",lv.top());
    }
    return 0;
}
