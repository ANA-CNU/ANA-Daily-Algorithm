from collections import deque
N, L = map(int, input().split())
A = list(map(int, input().split()))

Q = deque([(A[0], 0)])
result = [A[0]]

for i in range(1, N):
    if Q[0][1] == i-L:
        Q.popleft()
    while Q and Q[-1][0] >= A[i]:
        Q.pop()
    Q.append((A[i], i))
    result.append(Q[0][0])

print(*result)
