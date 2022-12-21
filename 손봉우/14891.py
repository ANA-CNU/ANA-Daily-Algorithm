from collections import deque

wheels = [deque(map(int, list(input()))) for _ in range(4)]

def rotate(wheel, direction):
    if direction == 1:
        wheel.appendleft(wheel.pop())
    else:
        wheel.append(wheel.popleft())
    return wheel

K = int(input())
vd = [1, -1]
res = 0

for _ in range(K):
    N, D = map(int, input().split())
    q = deque()
    q.append((N-1, D))
    visited = [False] * 4
    tmp = []

    while q:
        cur, curD = q.popleft()
        tmp.append((cur, curD))
        visited[cur] = True

        for v in vd:
            nxt = cur+v
            if 0 <= nxt < 4 and not visited[nxt]:
                if (v == -1 and wheels[cur][6] != wheels[nxt][2]
                or v == 1 and wheels[nxt][6] != wheels[cur][2]):
                    q.append((nxt, -1 if curD == 1 else 1))
                    visited[nxt] = True
    for cur, curD in tmp:
        rotate(wheels[cur], curD)

for i in range(4):
    res += wheels[i][0]*(pow(2, i))
print (res)