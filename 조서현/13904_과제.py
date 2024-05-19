from heapq import heappop, heappush

n = int(input())
arr = [tuple(map(int, input().split())) for _ in range(n)]
arr.sort()
# print(arr)

res = 0
q = []
for d, w in arr:
    if d > len(q):
        heappush(q, w)
    elif w > q[0]:
        heappop(q)
        heappush(q, w)
print(sum(q))
# https://www.acmicpc.net/problem/13904