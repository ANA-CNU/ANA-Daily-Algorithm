#include <stdio.h>
#include <stdlib.h>
int t,n;
long long int arr[1000001];
int main()
{
    for(int i=1; i<=1000000; i++) {
        for(int j=i; j<=1000000; j+=i) {
            arr[j] += i;
        }
    }
    for(int i=1; i<=1000000; i++) arr[i] += arr[i-1];
    for(scanf("%d",&t);t--;) {
        scanf("%d",&n);
        printf("%lld\n",arr[n]);
    }
    return 0;
}
