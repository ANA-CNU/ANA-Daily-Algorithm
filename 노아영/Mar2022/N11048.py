import sys
import copy
n, m = map(int, sys.stdin.readline().split())
maze = []
for _ in range(n):
    maze.append(list(map(int, sys.stdin.readline().split())))
cnt = copy.deepcopy(maze)
for i in range(n):
    for j in range(m):
        if i + 1 < n and cnt[i+1][j] < cnt[i][j] + maze[i+1][j]:
            cnt[i+1][j] = cnt[i][j] + maze[i+1][j]
        if i + 1 < n and j + 1 < m and cnt[i+1][j+1] < cnt[i][j] + maze[i+1][j+1]:
            cnt[i+1][j+1] = cnt[i][j] + maze[i+1][j+1]
        if j + 1 < m and cnt[i][j+1] < cnt[i][j] + maze[i][j+1]:
            cnt[i][j+1] = cnt[i][j] + maze[i][j+1]
print(cnt[n-1][m-1])