import sys
from itertools import permutations, combinations
N = int(sys.stdin.readline())
ability = [list(map(int, sys.stdin.readline().split())) for i in range(N)]
for i in range(1, N):
    for j in range(i):
        ability[j][i] += ability[i][j]
difference = sys.maxsize
team1 = [-1] * (N//2)
team2 = [-1] * (N//2)


def dfs(start, link, idx=0, s=0, l=0):
    global difference, ability
    if idx == N:
        print(start, link)
        total = 0
        for i, j in combinations(start, 2):
            total += ability[i][j]
        for i, j in combinations(link, 2):
            total -= ability[i][j]
        difference = min(difference, abs(total))
        return
    if start.count(-1) > 0:
        start[s] = idx
        dfs(start, link, idx+1, s+1, l)
        start[s] = -1
    if link.count(-1) > 0:
        link[l] = idx
        dfs(start, link, idx+1, s, l+1)
        link[l] = -1


dfs(team1, team2)
print(difference)

