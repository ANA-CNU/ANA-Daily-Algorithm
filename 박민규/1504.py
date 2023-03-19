#백준 1504번 특정한 최단 경로
from collections import deque
import sys
input = sys.stdin.readline

n,e = map(int,input().split())
graph = [[] for _ in range(n+1) ]

for i in range(e):
    a,b,c = map(int,input().split())
    graph[a].append((b,c))
    graph[b].append((a,c))

v1,v2 = map(int,input().split())

def bfs(start):
    distance = [float('inf')]*(n+1)
    distance[start] = 0
    q = deque()
    q.append((start))

    while q:
        now = q.popleft()

        for next,weight in graph[now]:
            if distance[next] > distance[now] + weight:
                distance[next] = distance[now] + weight
                q.append(next)
    return distance

# 출발점에서 a, b를 지나는 경우의 최단 경로
start_a = bfs(1)[v1]
a_b = bfs(v1)[v2]
b_end = bfs(v2)[n]

# 출발점에서 b, a를 지나는 경우의 최단 경로
start_b = bfs(1)[v2]
b_a = bfs(v2)[v1]
a_end = bfs(v1)[n]

result = min(start_a + a_b + b_end, start_b + b_a + a_end)

if result == float("inf"):
    print(-1)
else:
    print(result)