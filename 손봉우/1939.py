from collections import deque

N, M = map(int, input().split())
L = [[] for _ in range(N)]

for _ in range(M):
    a, b, c = map(int, input().split())
    L[a-1].append ((b-1, c))
    L[b-1].append ((a-1, c))

F1, F2 = map(int, input().split())
F1, F2 = F1-1, F2-1

def bfs(tmp):
    q = deque()
    q.append(F1)

    visit = [False]*N
    
    while q:
        pos = q.popleft()
        if pos == F2:
            return True

        for b, c in L[pos]:
            if tmp <= c and not visit[b]:
                visit[b] = True
                q.append(b)
        
    return False

start, end = 1, 1000000000

result= start
while start <= end:
    mid = (start+end)//2

    if bfs(mid):
        result= mid
        start = mid+1
    else:
        end = mid-1
    
print (result)
