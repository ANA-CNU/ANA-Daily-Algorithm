#백준 2667번 
n = int(input())
apt = [list(map(int,input())) for _ in range(n)]
visited = [[False]*n for _ in range(n)]
cnt = []
def dfs(x,y):
    global house_cnt
    visited[x][y] =[True]
    if apt[x][y] == 1:
        house_cnt += 1
    dx = [-1,0,1,0]
    dy = [0,1,0,-1]
    for i in range(4):
        nx,ny = x + dx[i],y + dy[i]
        if nx>=0 and nx< n and ny>=0 and ny<n:
            if not visited[nx][ny] and apt[nx][ny] == 1:
                dfs(nx,ny)

for i in range(n):
    for j in range(n):
        if apt[i][j] ==1 and not visited[i][j]:
            house_cnt = 0
            dfs(i,j)
            cnt.append(house_cnt)
cnt.sort()
print(len(cnt),*cnt,sep='\n')