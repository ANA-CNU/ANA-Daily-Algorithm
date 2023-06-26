from collections import deque

dx = [0, 0, -1, 1]
dy = [-1, 1, 0, 0]

N, M = map(int, input().split())
L = [list(map(int, input().split())) for _ in range(N)]

def check():
    q = deque()
    q.append((0, 0))

    visited = [[0]*M for _ in range(N)]
    visited[0][0] = 1

    while q:
        curX, curY = q.popleft()

        for i in range(4):
            nX = curX + dx[i]
            nY = curY + dy[i]

            if 0 <= nX < N and 0 <= nY < M:
                if L[nX][nY] == 0 and visited[nX][nY] == 0:
                    q.append((nX, nY))
                    visited[nX][nY] = 1
                elif L[nX][nY] == 1:
                    visited[nX][nY] += 1
    melted = []
    for i in range(N):
        for j in range(M):
            if visited[i][j] >= 2:
                melted.append((i, j))
    
    return melted

result = 0

while True:
    isAnyCheese = False

    melted = check()

    if not melted:
        break
        
    for x, y in melted:
        L[x][y] = 0

    result += 1
        
print (result)