import sys
import copy
n, m = map(int, sys.stdin.readline().split())
r = []
for _ in range(n):
    r.append(list(map(int, sys.stdin.readline().split())))
ans = copy.deepcopy(r)
for i in range(n):
    for j in range(m):
        if j+1 < m and ans[i][j+1] < ans[i][j] + r[i][j+1]:
            ans[i][j+1] = ans[i][j] + r[i][j+1]
        if i+1 < n and ans[i+1][j] < ans[i][j] + r[i+1][j]:
            ans[i+1][j] = ans[i][j] + r[i+1][j]
print(ans[n-1][m-1])