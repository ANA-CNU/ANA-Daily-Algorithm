#include <stdio.h>
#include <stdlib.h>
long long int n,l,r,m,k,sum,l_v,r_v;
long long int a[20001],b[20001],c[20001];
int main()
{
    scanf("%lld",&n);
    for(int i=1; i<=n; i++) {
        scanf("%lld %lld %lld",&a[i], &c[i], &b[i]);
    }
    l = 1;
    r = 2147483647;
    while(l <= r) {
        m = (l + r) / 2;
        sum = 0;
        for(int i=1; i<=n; i++) {
            if(m < a[i]) continue;
            if(m > c[i]) {
                k = (c[i] - a[i]) / b[i];
            }
            else {
                k = (m - a[i]) / b[i];
            }
            sum += k + 1;
        }
        if(sum % 2 == 0) {
            l = m + 1;
        }
        else {
            r = m - 1;
        }
    }
    for(int i=1; i<=n; i++) {
        if(l < a[i]) continue;
        if(l > c[i]) {
            k = (c[i] - a[i]) / b[i];
        }
        else {
            k = (l - a[i]) / b[i];
        }
        l_v += k + 1;
    }
    for(int i=1; i<=n; i++) {
        if(r < a[i]) continue;
        if(r > c[i]) {
            k = (c[i] - a[i]) / b[i];
        }
        else {
            k = (r - a[i]) / b[i];
        }
        r_v += k + 1;
    }
    if(l == 2147483648) printf("NOTHING");
    else printf("%lld %lld",l,l_v - r_v);

    return 0;
}
