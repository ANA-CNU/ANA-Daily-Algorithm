N = int(input())
M = int(input())

parent = [i for i in range(N)]

def find(node):
    if parent[node] != node:
        parent[node] = find(parent[node])
    return parent[node]

def union(a, b):
    a = find(a)
    b = find(b)
    if a < b:
        parent[b] = a
    else:
        parent[a] = b

for i in range(N):
    for j, item in enumerate(map(int, input().split())):
        if item:
            union(i, j)

path = list(map(int, input().split()))
start = parent[path[0]-1]
for i in range(1, M):
    if parent[path[i]-1] != start:
        print("NO")
        break
else:
    print('YES')