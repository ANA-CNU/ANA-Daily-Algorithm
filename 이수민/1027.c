#include <stdio.h>
#include <stdlib.h>
int n,arr[51],cnt[51];
double max,k;
int answer;
int main()
{
    scanf("%d",&n);
    for(int i=0; i<n; i++) scanf("%d",&arr[i]);
    for(int i=0; i<n; i++) {
        max = -1000000001;
        for(int j=i+1; j<n; j++) {
            k = (double)(arr[j] - arr[i]) / (j - i);
            if(max < k) {
                max = k;
                cnt[i]++;
                cnt[j]++;
            }
        }
    }
    for(int i=0; i<n; i++) {
        answer = answer < cnt[i] ? cnt[i] : answer;
    }
    printf("%d",answer);
    return 0;
}
