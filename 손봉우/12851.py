from collections import deque

position_a, position_b = map(int, input().split())

q = deque()
visited = [False]*100001
result = 0
cnt = 1

q.append((0, position_a))
while q:
    time, cur = q.popleft();
    visited[cur] = True

    if cur == position_b:
        result = time
        for i in q:
            if i == (time, cur):
                cnt += 1
        break
    if cur-1 >= 0 and not visited[cur-1]:
        q.append((time+1, cur-1))
    if cur+1 <= 100000 and not visited[cur+1]:
        q.append((time+1, cur+1))
    if cur*2 <= 100000 and not visited[cur*2]:
        q.append((time+1, cur*2))

print (result)
print (cnt)