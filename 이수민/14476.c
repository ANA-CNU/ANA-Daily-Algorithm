#include <stdio.h>
#include <stdlib.h>
int n, max_gcd, max_index;
int arr[1000001];
int ltr[1000001];
int rtl[1000001];
int gcd(int a, int b) {
    if(b == 0) return a;
    return gcd(b, a%b);
}
int main()
{
    scanf("%d",&n);
    for(int i=0; i<n; i++) {
        scanf("%d",&arr[i]);
    }
    ltr[0] = arr[0];
    for(int i=1; i<n; i++) {
        ltr[i] = gcd(ltr[i-1], arr[i]);
    }
    rtl[n-1] = arr[n-1];
    for(int i=n-2; i>=0; i--) {
        rtl[i] = gcd(rtl[i+1], arr[i]);
    }

    max_gcd = 0;
    max_index = -1;
    for(int i=0; i<n; i++) {
        int k = arr[i];
        if(i == 0) {
            if(k % rtl[1] != 0) {
                if(max_gcd < rtl[1]) {
                    max_gcd = rtl[1];
                    max_index = 0;
                }
            }
        }
        else if(i == n-1) {
            if(k % ltr[n-2] != 0) {
                if(max_gcd < ltr[n-2]) {
                    max_gcd = ltr[n-2];
                    max_index = n-1;
                }
            }
        }
        else {
            int m = gcd(ltr[i-1], rtl[i+1]);
            if(k % m != 0) {
                if(max_gcd < m) {
                    max_gcd = m;
                    max_index = i;
                }
            }
        }
    }
    if(max_index != -1) {
        printf("%d %d",max_gcd, arr[max_index]);
    }
    else {
        printf("-1");
    }
    puts("");
    for(int i=0; i<n; i++) {
        printf("%d ",ltr[i]);
    }
    puts("");
    for(int i=0; i<n; i++) {
        printf("%d ",rtl[i]);
    }
    return 0;
}
