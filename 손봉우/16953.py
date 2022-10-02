from collections import deque
A, B = map(int, input().split())

def bfs():
    q = deque()
    q.append((A, 0))
    while q:
        cur, cnt = q.popleft()
        
        if cur == B:
            return cnt
        if cur > B:
            continue
        
        q.append ((cur*2, cnt+1))
        q.append ((cur*10+1, cnt+1))
    return -2

print (bfs()+1)

