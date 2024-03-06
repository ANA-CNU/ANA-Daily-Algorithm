#include <stdio.h>
#include <stdlib.h>
int t,a,b,c,d,arr_len,cnt;
char arr[100001];
int main()
{
    for(scanf("%d",&t);t--;) {
        scanf(" %s",arr);
        arr_len = strlen(arr);
        a = 0;
        b = arr_len - 1;
        cnt = 0;
        while(a <= b) {
            if(arr[a] != arr[b]) {
                cnt++;
                break;
            }
            a++;
            b--;
        }
        if(cnt == 0) {
            printf("0\n");
            continue;
        }
        c = a+1;
        d = b;
        while(c <= d) {
            if(arr[c] != arr[d]) {
                cnt++;
                break;
            }
            c++;
            d--;
        }

        c = a;
        d = b-1;
        while(c <= d) {
            if(arr[c] != arr[d]) {
                cnt++;
                break;
            }
            c++;
            d--;
        }
        if(cnt == 3) printf("2\n");
        else printf("1\n");

    }
    return 0;
}
