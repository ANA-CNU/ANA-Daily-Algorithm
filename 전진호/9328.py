from collections import deque
import sys 
input = sys.stdin.readline

dx = [0,0,1,-1]; dy = [1,-1,0,0]
def bfs(n, m):
    global keys, MAP
    deq = deque([(0,0)])
    vis = [ [False for _ in range(m+2)] for i in range(n+2)]

    cnt = 0
    new_key_found = False
    vis[0][0] = True
    while len(deq)>0:
        y, x = deq.popleft()
        for i in range(4):
            ny, nx = y + dy[i], x + dx[i]
            if (0<= nx <= m+1) and (0<= ny <= n+1) and MAP[ny][nx]!=1:
                if vis[ny][nx]: continue
                if MAP[ny][nx] == 0:
                    vis[ny][nx] = True
                    deq.append((ny,nx))
                    continue
                    # go 
                # char key exists 
                # if(isinstance(char,int)):
                char = MAP[ny][nx]
                
                if 97<=ord(char)<=122: # key
                    # print(ny,nx,char)
                    MAP[ny][nx] = 0
                    keys.add(char)
                    new_key_found = True
                    deq.append((ny,nx))

                if 65<=ord(char)<=90 and char.lower() in keys:
                    MAP[ny][nx] = 0
                    deq.append((ny,nx))
                
                if ord(char) == 36:
                    # print(ny,nx, char)
                    MAP[ny][nx] = 0
                    deq.append((ny,nx))
                    cnt+=1
                vis[ny][nx] = True

    return cnt, new_key_found

t = int(input())
for i in range(t):
    n, m = map(int,input().split())
    MAP = []
    MAP.append([0 for _ in range(m+2)])
    for _ in range(n):
        MAP.append([0] + list(input().strip('\n')) + [0])
    MAP.append([0 for _ in range(m+2)])
    res = 0

    for i in range(n+2):
        for j in range(m+2):
            if(MAP[i][j]=='*'):
                MAP[i][j] = 1
            if MAP[i][j] == '.':
                MAP[i][j] = 0

    tmp = input().rstrip('\n')
    keys = set(tmp if tmp != '0' else '')

    while (1):
        cnt, new_key_found = bfs(n,m)
        res += cnt
        # print(cnt)
        if not new_key_found:
            break
    print(res)


    # for st in MAP:
    #     print(*st)
    # print(keys)

