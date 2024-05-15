#include <stdio.h>
#include <stdlib.h>
int arr[251][251];
int main()
{
    int n,m,u,v,b,s,e;
    scanf("%d %d",&n,&m);
    for(int i=1; i<=n; i++) {
        for(int j=1; j<=n; j++) {
            if(i != j) arr[i][j] = 987654321;
        }
    }
    for(int i=0; i<m; i++) {
        scanf("%d %d %d",&u,&v,&b);
        if(b == 0) {
            arr[u][v] = 0;
            arr[v][u] = 1;
        }
        else {
            arr[u][v] = 0;
            arr[v][u] = 0;
        }
    }
    for(int k=1; k<=n; k++) {
        for(int i=1; i<=n; i++) {
            for(int j=1; j<=n; j++) {
                arr[i][j] = arr[i][j] > arr[i][k] + arr[k][j] ? arr[i][k] + arr[k][j] : arr[i][j];
            }
        }
    }

    for(int i=1; i<=n; i++, puts("")) for(int j=1; j<=n; j++) printf("%d ",arr[i][j]);

    int k;
    scanf("%d",&k);
    for(int i=0; i<k; i++) {
        scanf("%d %d",&s,&e);
        printf("%d\n",arr[s][e]);
    }
    return 0;
}
