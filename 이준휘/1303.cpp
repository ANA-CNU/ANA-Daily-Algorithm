#include <stdio.h>
int que[1000000];
int head, tail = 0;
char map[1000][1000];
bool visited[1000][1000];
void push(int N){
    que[tail] = N;
    tail++;
}
int pop(){
    head++;
    return que[head-1];
}
bool isEmpty(){
    if(head==tail) return true;
    else return false;
}
int bfs(int N, int M){
    int sum=0;
		push(N);
		push(M);
		visited[N][M] = true;
		while(!isEmpty()) {
			int here_x = pop();
			int here_y = pop();
			sum++;
			if(map[here_x+1][here_y] == map[here_x][here_y] && !visited[here_x+1][here_y]) {
				int there_x = here_x+1;
				int there_y = here_y;
				push(there_x);
				push(there_y);
				visited[there_x][there_y] = true;
			}
			if(map[here_x-1][here_y] == map[here_x][here_y] && !visited[here_x-1][here_y]) {
				int there_x = here_x-1;
				int there_y = here_y;
				push(there_x);
				push(there_y);
				visited[there_x][there_y] = true;
			}
			if(map[here_x][here_y+1] == map[here_x][here_y] && !visited[here_x][here_y+1]) {
				int there_x = here_x;
				int there_y = here_y+1;
				push(there_x);
				push(there_y);
				visited[there_x][there_y] = true;
			}
			if(map[here_x][here_y-1] == map[here_x][here_y] && !visited[here_x][here_y-1]) {
				int there_x = here_x;
				int there_y = here_y-1;
				push(there_x);
				push(there_y);
				visited[there_x][there_y] = true;
			}
		}
		return sum;
}

int main(){
    int N, M;
    scanf("%d %d\n", &N, &M);
    for(int i = 1; i<=N ; i++){
        for(int j=1; j<=M; j++){
            scanf("%c", &map[i][j]);
        }
        if(i!=N) scanf("\n");
    }
    int sum_B=0;
	int sum_W=0;
		for(int i=1; i<=N; i++ ) {
			for(int j = 1; j<=M; j++) {
				if(!visited[i][j] && map[i][j]=='B') {
					int t = bfs(i, j);
					sum_B += t*t;
				}
				if(!visited[i][j] && map[i][j]=='W') {
					int t = bfs(i, j);
					sum_W += t*t;
				}
			}
		}
		printf("%d %d", sum_W, sum_B);

}
