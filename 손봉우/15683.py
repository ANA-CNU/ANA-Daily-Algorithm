import copy, sys

N, M = map(int, input().split())
L = [list(map(int, input().split())) for _ in range(N)]
cctv = []
direction = [[[(0, 1)], [(0, -1)], [(1, 0)], [(-1, 0)]],
[[(-1, 0), (1, 0)], [(0, -1), (0, 1)]],
[[(-1, 0), (0, -1)], [(0, -1), (1, 0)], [(1, 0), (0, 1)], [(0, 1), (-1, 0)]],
[[(-1, 0), (0, -1), (1, 0)], [(0, -1), (1, 0), (0, 1)], [(1, 0), (0, 1), (-1, 0)], [(0, 1), (-1, 0), (0, -1)]],
[[(-1, 0), (0, -1), (1, 0), (0, 1)]]]
res = sys.maxsize

for i in range(N):
    for j in range(M):
        if 1 <= L[i][j] <= 5:
            cctv.append((L[i][j]-1, i, j))

def dfs(map_, depth):
    global res

    if depth == len(cctv):
        cnt = 0
        for i in range(N):
            for j in range(M):
                if map_[i][j] == 0: cnt += 1
        res = min(cnt, res)
        return
    ctype, cx, cy = cctv[depth]
    for i in direction[ctype]:
        new_map = copy.deepcopy(map_)
        for j in i:
            nx, ny = cx, cy
            while True:
                nx += j[0]
                ny += j[1]

                if not 0 <= nx < N or not 0 <= ny < M or map_[nx][ny] == 6:
                    break
                new_map[nx][ny] = 7
        dfs(new_map, depth+1)

dfs(L, 0)
print (res)