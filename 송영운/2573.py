dxdy = [(-1, 0), (1, 0), (0, -1), (0, 1)]
def melt(q):
    global n
    global m
    q2 = deque()
    board2 = copy.deepcopy(board)
    while q:
        x, y = q.popleft()
        melt_count = 0
        for d in dxdy:
            dx, dy = x + d[0], y + d[1]
            if 0<=dx<n and 0<=dy<m and board[dx][dy] <= 0:
                melt_count += 1
        board2[x][y] -= melt_count
        if board2[x][y] > 0:
            q2.append((x, y))
    return q2, board2

def checkTwo(q):
    global n
    global m
    count = 0
    q2 = deque()
    visit = [[False]*m for _ in range(n)]
    while q:
        x, y = q.popleft()
        q2.append((x, y))
        if visit[x][y] == True:
            continue
        visit[x][y] = True
        que = deque()
        que.append((x, y))
        while que:
            x, y = que.popleft()
            for d in dxdy:
                dx, dy = x + d[0], y + d[1]
                if 0<=dx<n and 0<=dy<m and visit[dx][dy] == False:
                    if board[dx][dy] > 0:
                        visit[dx][dy] = True
                        que.append((dx, dy))
        count += 1
    return q2, count

import copy
from collections import deque
input = __import__('sys').stdin.readline
if __name__ == "__main__":
    n, m = map(int, input().split())
    board = [[0]*m for _ in range(n)]
    q = deque()
    for i in range(n):
        line = list(map(int, input().split()))
        for j in range(m):
            if line[j] != 0:
                board[i][j] = line[j]
                q.append((i, j))
    answer = 0
    while True:
        answer += 1
        q, board = melt(q)
        q, ice = checkTwo(q)
        if ice == 0:
            print(0)
            exit()
        if ice > 1:
            print(answer)
            exit()

