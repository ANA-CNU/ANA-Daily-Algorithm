#include <stdio.h>
#include <stdlib.h>
int tree[100001];
int arr[100001];
int get(int x) {
    if(x == tree[x]) return x;
    return tree[x] = get(tree[x]);
}

void uni(int a, int b) {
    a = get(a);
    b = get(b);
    if(a < b) tree[b] = a;
    else tree[a] = b;
}

int cmp(int a, int b) {
    a = get(a);
    b = get(b);
    if(a == b) return 1;
    return 0;
}
int main()
{
    int t,n,cnt=0,a;
    scanf("%d",&t);
    scanf("%d",&n);
    for(int i=0; i<=t; i++) tree[i] = i;
    for(int i=0; i<n; i++) scanf("%d",&arr[i]);
    for(int i=0; i<n; i++) {
        a = get(arr[i]);
        if(a == 0) break;
        uni(a, a-1);
        cnt++;
    }
    printf("%d",cnt);
    return 0;
}
