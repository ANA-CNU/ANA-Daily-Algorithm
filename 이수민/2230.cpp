#include <bits/stdc++.h>
using namespace std;
int n,m,a,l,r;
int answer = 2100000000;
vector<int> v;
int main()
{
    scanf("%d %d",&n,&m);
    for(int i=0; i<n; i++) {
        scanf("%d",&a);
        v.push_back(a);
    }
    sort(v.begin(), v.end());
    l = 0;
    r = 0;
    while(l <= r && r < n) {
        int x = v[l];
        int y = v[r];
        if(y-x < m) {
            r++;
        }
        else if(y-x > m) {
            answer = answer > y-x ? y-x : answer;
            l++;
        }
        else {
            answer = m;
            break;
        }
    }
    printf("%d",answer);
    return 0;
}
