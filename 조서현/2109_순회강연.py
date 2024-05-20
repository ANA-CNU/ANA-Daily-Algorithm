from heapq import heappop, heappush

n = int(input())
arr = [tuple(map(int, input().split())) for _ in range(n)]
arr.sort(key=lambda x: x[-1])
# print(arr)

res = 0
q = []
for p, d in arr:
    if d > len(q):
        heappush(q, p)
    elif p > q[0]:
        heappop(q)
        heappush(q, p)
print(sum(q))
# https://www.acmicpc.net/problem/2109