#백준 11725번 트리의 부모 찾기
import sys
from collections import deque
input = sys.stdin.readline

n = int(input())
graph = [[] for i in range(n+1)]
parent = [0] * (n+1)

for i in range(n-1):
    a,b = map(int,input().split())
    graph[a].append(b)
    graph[b].append(a)

def bfs():
    q = deque()
    q.append(1)
    parent[1] = -1 # 루트 노드의 부모를 -1로 설정

    while q:
        node = q.popleft()
        for i in graph[node]:
            if parent[i] == 0:
                parent[i] = node
                q.append(i)
    return parent

result = bfs()

for i in range(2, n+1):
    print(result[i])