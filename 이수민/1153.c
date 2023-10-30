#include <stdio.h>
#include <stdlib.h>
int arr[1000001];
int max;
int answer[5];
int isOk;
void f(int x, int cnt) {
    if(isOk) return;
    if(x < 0) return;
    if(cnt != 4 && x == 0) return;
    if(cnt == 4) {
        if(x != 0) return;
        for(int i=3; i>=0; i--) printf("%d ",answer[i]);
        isOk = 1;
        return;
    }
    for(int i=x; i>=2; i--) {
        if(!arr[i] && !isOk) {
            answer[cnt] = i;
            f(x-i, cnt+1);
        }
    }
}
int main()
{
    arr[0] = 1;
    arr[1] = 1;
    for(int i=2; i*i<=1000000; i++) {
        if(!arr[i]) {
            for(int j=i*i; j<=1000000; j+=i) arr[j] = 1;
        }
    }
    int n;
    scanf("%d",&n);
    f(n, 0);
    if(!isOk) printf("-1");
    return 0;
}
