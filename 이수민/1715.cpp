#include <bits/stdc++.h>
using namespace std;
int n,a;
int answer;
priority_queue<int, vector<int>, greater<int> > pq;
int main()
{

    scanf("%d",&n);
    for(int i=0; i<n; i++) {
        scanf("%d",&a);
        pq.push(a);
    }
    if(n == 1) {
        printf("0");
    }
    else {
        while(pq.size() != 1) {
            int x = pq.top();
            pq.pop();

            int y = pq.top();
            answer += (x+y);
            pq.pop();

            pq.push(x+y);

        }
        printf("%d",answer);
    }
    return 0;
}
