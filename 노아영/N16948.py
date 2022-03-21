import sys
from collections import deque

def bfs(r1, c1, r2, c2, n):
    v = [[False]*n for _ in range(n)]
    q = deque()
    q.append((r1, c1, 0))
    dx = [-2, -2, 0, 0, 2, 2]    
    dy = [-1, 1, -2, 2, -1, 1]
    while q:
        tmp = q.popleft()
        for i in range(6):
            nx = tmp[0] + dx[i]
            ny = tmp[1] + dy[i]

            if nx < 0 or ny < 0 or nx >= n or ny >= n:
                continue
            if nx == r2 and ny == c2:
                return tmp[2]+1
            if not v[ny][nx]:
                v[ny][nx] = True
                q.append((nx, ny, tmp[2]+1))

    return -1

def main():
    n = int(sys.stdin.readline())
    r1, c1, r2, c2 = map(int, sys.stdin.readline().split())
    print(bfs(r1, c1, r2, c2, n))

if __name__ == "__main__":
    main()