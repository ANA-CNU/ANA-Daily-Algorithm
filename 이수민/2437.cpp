#include <bits/stdc++.h>
using namespace std;
int n;
int arr[1001];
int sum;
int main()
{
    scanf("%d",&n);
    for(int i=0; i<n; i++) scanf("%d",&arr[i]);
    sort(arr, arr+n);
    if(sum+1 < arr[0]) printf("1");
    else {
        int i;
        for(i=0; i<n-1; i++) {
        sum += arr[i];
        if(sum+1 < arr[i+1]) {
                break;
            }
        }
        if(i == n-1) sum += arr[n-1];
        printf("%d",sum+1);
    }
    return 0;
}
