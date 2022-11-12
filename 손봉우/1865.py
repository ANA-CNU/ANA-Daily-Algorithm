import sys

for _ in range(int(input())):
    INF = sys.maxsize
    V, E, W = map(int, input().split())
    G = []
    D = [INF] * V

    for i in range(E+W):
        a, b, c = map(int, input().split())
        if i<E:
            G.append((a-1, b-1, c))
            G.append((b-1, a-1, c))
        else:
            G.append((a-1, b-1, -c))

    def bellman_ford(start):
        D[start] = 0

        for i in range(V):
            for j in G:
                a, b, c = j
                if D[b] > D[a]+c:
                    D[b] = D[a] + c
                    if i == V-1:
                        return True
        return False

    if bellman_ford(0):
        print('YES')
    else:
        print('NO')