#include <stdio.h>
#include <stdlib.h>
int n,m;
long long int arr[1000001];
long long int mod[1000];
long long int sum;
int main()
{
    scanf("%d %d",&n,&m);
    for(int i=1; i<=n; i++) {
        scanf("%lld",&arr[i]);
    }
    for(int i=1; i<=n; i++) {
        arr[i] += arr[i-1];
    }
    for(int i=1; i<=n; i++) {
            if(arr[i] % m == 0) sum++;
            mod[arr[i] % m]++;
    }
    for(int i=0; i<m; i++) {
        long long int t = mod[i];
        sum += ((t)*(t-1))/2;
    }
    printf("%lld",sum);
    return 0;
}
