#include <stdio.h>
#include <stdlib.h>
int n;
int count;
int arr[50][50];
void f(int x, int y) {
    if(x == n-1) {
        count++;
        return;
    }
    for(int i=x+1; i<n; i++) {arr[i][y]++; arr[x+i-x][y+i-x]++; arr[x+i-x][y-i+x]++;}

    for(int i=0; i<n; i++) if(arr[x+1][i] == 0) f(x+1, i);

    for(int i=x+1; i<n; i++) {arr[i][y]--; arr[x+i-x][y+i-x]--; arr[x+i-x][y-i+x]--;}

}
int main()
{
    scanf("%d",&n);
    for(int i=0; i<n; i++) f(0, i);
    printf("%d",count);
    return 0;
}
