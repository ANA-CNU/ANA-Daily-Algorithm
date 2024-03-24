#include <stdio.h>
#include <stdlib.h>
int n,m,min,max,cnt;
int arr[5001];
int main()
{
    scanf("%d %d",&n,&m);
    for(int i=0; i<n; i++) {
        scanf("%d",&arr[i]);
    }

    int left = 0;
    int right = 10001;
    while(left <= right) {
        int mid = (left + right) / 2;
        min = 10001;
        max = 0;
        cnt = 0;
        for(int i=0; i<n; i++) {
            min = min > arr[i] ? arr[i] : min;
            max = max < arr[i] ? arr[i] : max;
            if(max - min > mid) {
                cnt++;
                max = arr[i];
                min = arr[i];
            }
        }
        cnt++;
        if(cnt > m) {
            left = mid + 1;
        }
        else {
            right = mid - 1;
        }
    }
    printf("%d",left);


    return 0;
}
