#include <bits/stdc++.h>
using namespace std;
int num[10001];
int t,a,b;
int main()
{
    num[1] = 1;
    for(int i=2; i*i<=10000; i++) {
        if(!num[i]) for(int j=i+i; j<=10000; j+=i) num[j] = 1;
    }
    queue<int> q;
    for(scanf("%d",&t);t--;) {
        scanf("%d %d",&a,&b);
        q.push(a);
        int cnt = 0;
        int arr[10001];
        for(int i=1000; i<=9999; i++) arr[i] = 987654321;
        while(!q.empty()) {
            int q_size = q.size();
            for(int i=0; i<q_size; i++) {
                int x = q.front();
                q.pop();
                if(arr[x] < cnt) continue;
                arr[x] = cnt;
                int y = x%1000;
                for(int j=1; j<=9; j++) {
                    int z = j*1000+y;
                    if(!num[z]) q.push(z);
                }

                y = (x/1000)*1000 + x%100;
                for(int j=0; j<=9; j++) {
                    int z = j*100 + y;
                    if(!num[z]) q.push(z);
                }

                y = (x/100)*100 + x%10;
                for(int j=0; j<=9; j++) {
                    int z = j*10 + y;
                    if(!num[z]) q.push(z);
                }

                y = (x/10)*10;
                for(int j=0; j<=9; j++) {
                    int z = j + y;
                    if(!num[z]) q.push(z);
                }
            }
            cnt++;
        }
        if(arr[b] == 987654321) printf("Impossible\n");
        else printf("%d\n",arr[b]);
    }
    return 0;
}
