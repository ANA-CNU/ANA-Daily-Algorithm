import sys
from collections import deque
input = sys.stdin.readline

n, m = map(int, input().split())
a = [list(map(int, input().split())) for _ in range(n)]  # 종이
ans = 0
dx = [0,0,-1,1]
dy = [1,-1,0,0]
# 0
cheese = deque()  # 치즈 인덱스 저장
for i in range(n):
    for j in range(m):
        if a[i][j] == 1:
            cheese.append([i,j])

while cheese:
    ans += 1
    # 1
    Q = deque()
    visited = [[False for _ in range(m)] for _ in range(n)]
    Q.append([0,0])
    visited[0][0] = True
    while Q:
        x,y = Q.popleft()
        a[x][y] = -1  # 외부 공기
        for i in range(4):
            X, Y = x+dx[i], y+dy[i]
            if X < 0 or Y < 0 or X >= n or Y >= m:
                continue
            if not visited[X][Y]:
                visited[X][Y] = True
                if a[X][Y] == 0 or a[X][Y] == -1:
                    Q.append([X,Y])

    # 2
    tmp = set()
    l = len(cheese)
    for _ in range(l):
        x,y = cheese.popleft()
        cnt = 0
        for i in range(4):
            X, Y = x + dx[i], y + dy[i]
            if X < 0 or Y < 0 or X >= n or Y >= m:
                continue
            if a[X][Y] == -1:
                cnt +=1
        if cnt < 2:
            cheese.append([x,y])
        else:
            tmp.add((x,y))
    if tmp:
       for x, y in tmp:
           a[x][y] = 0
print(ans)

