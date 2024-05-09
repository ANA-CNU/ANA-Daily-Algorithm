#include <stdio.h>
int N, M;
int arr1[1001][1001]={};
bool arr2[1001];
void dfs(int V){
    printf("%d ", V);
    arr2[V]=true;
    for(int i = 1; i<=N; i++){
        if(arr1[V][i]==1 && !arr2[i]){
            dfs(i);
        }
    }
}
int arr3[1001];
int head, tail = 0;
bool arr4[1001];
void bfs(int V){
    
    arr3[tail] = V;
    tail++;
    arr4[V] = true;
    while(tail != head){
        for(int i = 1; i<=N; i++){
            if(arr1[arr3[head]][i]==1 && !arr4[i]){
                arr3[tail]=i;
                tail++;
                arr4[i]=true;
            }
        }
        printf("%d ", arr3[head]);
        head++;
    }
}
int main(){
    int V;
    scanf("%d %d %d", &N, &M, &V);
    for(int i = 1; i<=M; i++){
        int x, y;
        scanf("%d %d", &x, &y);
        arr1[x][y]=1;
        arr1[y][x]=1;
    }
    dfs(V);
    printf("\n");
    bfs(V);
}