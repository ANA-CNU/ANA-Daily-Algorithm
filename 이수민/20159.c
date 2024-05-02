#include <stdio.h>
#include <stdlib.h>
int n,a,ei=1,oi=1,max;
int odd[50001];
int even[50001];
int main()
{
    scanf("%d",&n);
    for(int i=1; i<=n; i++) {
        scanf("%d",&a);
        if(i % 2 == 0) {
            even[ei] = even[ei-1] + a;
            ei++;
        }
        else {
            odd[oi] = odd[oi-1] + a;
            oi++;
        }
    }
    max = odd[oi-1];
    for(int i=1; i<n; i++) {
        if(i % 2 == 0) {
            max = max < odd[i/2] + even[n/2-1] - even[i/2-1] ? odd[i/2] + even[n/2-1] - even[i/2-1] : max;
        }
        else {
            max = max < odd[i/2] + even[n/2] - even[i/2] ? odd[i/2] + even[n/2] - even[i/2] : max;
        }
    }
    printf("%d",max);
    return 0;
}
