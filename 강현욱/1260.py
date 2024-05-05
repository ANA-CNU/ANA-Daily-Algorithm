import sys
input = sys.stdin.readline

def dfs(graph, enter, start):
    enter[start] = 1
    print(f'{start} ', end='')
    for k in graph[start]:
        if enter[k] != 1:
            dfs(graph, enter, k)

def bfs(graph, enter, start):
    queue = []
    enter[start] = 1
    queue.append(start)
    while queue:
        current = queue.pop(0)
        print(f'{current} ', end='')
        for neighbor in graph[current]:
            if enter[neighbor] == 0:
                queue.append(neighbor)
                enter[neighbor] = 1

# 입력값 파싱
dot, line, start = map(int, input().rstrip().split())

# Initialize graph as a list of lists
graph = [[] for _ in range(dot + 1)]
enter = [0] * (dot + 1)

# Populate the graph
for j in range(line):
    a, b = map(int, input().rstrip().split())
    graph[a].append(b)
    graph[b].append(a)  # 양방향 그래프
for j in range(1,dot+1):
    graph[j].sort()
dfs(graph, enter, start)
print()
enter = [0] * (dot + 1)  # BFS를 위해 enter 초기화
bfs(graph, enter, start)
