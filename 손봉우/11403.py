N = int(input())
G = [list(map(int, input().split())) for _ in range(N)]

for k in range(N):
    for i in range(N):
        for j in range(N):
            if G[i][j] == 1 or (G[i][k] and G[k][j]):
                G[i][j] = 1

for i in G:
    for j in i:
        print (j, end = ' ')
    print()