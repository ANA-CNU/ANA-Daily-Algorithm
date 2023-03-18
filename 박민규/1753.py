#백준 1753번 최단경로
from collections import deque
import sys
input = sys.stdin.readline
INF = int(1e9)
v,e = map(int,input().split())
k = int(input())

graph = [[] for _ in range(e)]
distance = [INF]*(v+1)

for i in range(e):
    a,b,c = map(int,input().split())
    graph[a].append((b,c))

def bfs(k):
    q = deque()
    q.append(k)
    distance[k] = 0

    while q:
        now = q.popleft()

        for next,weight in graph[now]:                  #weight = 가중치, next = 다음 노드
            if distance[next] > distance[now] + weight: #현재 노드(now)를 거쳐서 인접한 노드(next)까지 
                                                        #가는 거리를 구한 값(distance[now] + weight)
                                                        # 이전에 계산한 최단 거리(distance[next])보다 작다면 최단 거리를 업데이트 .
                distance[next] = distance[now] + weight
                q.append(next)

bfs(k)

for i in range(1,v+1):
    if distance[i] == INF:
        print("INF")
    else:
        print(distance[i])