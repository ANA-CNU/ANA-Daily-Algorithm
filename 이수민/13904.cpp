#include <bits/stdc++.h>
using namespace std;
typedef struct {
    int d;
    int w;
}st;

struct compare {
    bool operator()(st a, st b) {
        return a.w < b.w;
    }
};
int dp[1001];
priority_queue<st, vector<st>, compare> pq;
int main()
{
    int n,d,w;
    scanf("%d",&n);
    for(int i=0; i<n; i++) {
        scanf("%d %d",&d,&w);
        pq.push({d, w});
    }
    int sum = 0;
    while(!pq.empty()) {
        st x = pq.top();
        pq.pop();

        for(int i=x.d; i>=1; i--) {
            if(dp[i] == 0) {
                sum += x.w;
                dp[i] = x.w;
                break;
            }
        }
    }
    printf("%d",sum);

    return 0;
}
