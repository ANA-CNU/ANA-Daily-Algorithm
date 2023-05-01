
from collections import deque
from sys import stdin
input  =stdin.readline

st = [list(map(int,input().split())) for _ in range(3)]


def bfs():
    global st

    zero_pos = 0 
    start = ""
    for i in range(3):
        for j in range(3):
            start += str(st[i][j])
            if(st[i][j]==0):
                zero_pos = 3*i + j

    deq = deque([(start, zero_pos, 0 )]) # last : cnt

    res = dict()

    while deq:

        cur, zero_pos, cnt = deq.popleft()

        if cur == "123456780":
            return cnt
        
        if(res.get(cur,0) !=1):
            res[cur] = 1
            cur_y, cur_x = zero_pos//3, zero_pos%3
    
            cur = list(cur)
            for dy, dx in [(0,1),(0,-1),(1,0),(-1,0)]:
                ny, nx = cur_y + dy, cur_x + dx
                if(0<=ny < 3) and (0<=nx < 3):
                    newpos = 3 * ny  + nx
                    cur[newpos], cur[zero_pos] = cur[zero_pos], cur[newpos]
                    tmp = "".join(cur)
                    deq.append((tmp, newpos, cnt+1))
                    cur[newpos], cur[zero_pos] = cur[zero_pos], cur[newpos]
    return -1

print(bfs())