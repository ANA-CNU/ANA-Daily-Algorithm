import sys

input = sys.stdin.readline

N, M = map(int, input().split())
graph = [[] for _ in range(N)]
for _ in range(M):
    a, b = map(int, input().split())
    # 양방향 그래프, 친구 관계
    graph[a].append(b)
    graph[b].append(a)
visited = [False] * N
ans = False


def DFS(per, cnt):
    global ans
    if cnt == 4:
        ans = True
        return

    visited[per] = True
    for n in graph[per]:
        if not visited[n]:
            DFS(n, cnt + 1)
    visited[per] = False


for i in range(N):
    DFS(i, 0)

if ans:
    print(1)
else:
    print(0)
