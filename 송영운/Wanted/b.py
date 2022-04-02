from collections import deque
input = __import__('sys').stdin.readline
if __name__ == "__main__":
    n, q = map(int, input().split())
    graph = [[] for _ in range(n+1)]
    node_num = list(map(int, input().split()))
    node_num.insert(0, 0)
    for i in range(n-1):
        u, v = map(int, input().split())
        graph[u].append(v)
        graph[v].append(u)
    for i in range(q):
        x, y = map(int, input().split())
        q = deque()
        q.append((x, str(node_num[x])))
        visit = [False] * (n+1)
        while q:
            now, strs = q.popleft()
            if now == y:
                print(int(strs)%1000000007)
                break
            for j in graph[now]:
                if visit[j] == False:
                    visit[j] = True
                    q.append((j, strs+str(node_num[j])))


