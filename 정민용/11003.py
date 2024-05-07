import sys
import heapq

n, l = map(int, sys.stdin.readline().split())
arr = list(map(int, sys.stdin.readline().split()))
heap = []
res = []

for index, val in enumerate(arr):
    heapq.heappush(heap, (val, index))

    while heap:
        v, i = heapq.heappop(heap)
        if index-l+1 <= i <= index:
            res.append(v)
            heapq.heappush(heap, (v, i))
            break

print(*res)