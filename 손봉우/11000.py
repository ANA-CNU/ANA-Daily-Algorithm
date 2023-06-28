import heapq

N = int(input())

L = []
for _ in range(N):
    L.append(tuple(map(int, input().split())))

L.sort()
q = []

heapq.heappush(q, L[0][1])
for i in L[1:]:
    if q[0] > i[0]:
        heapq.heappush(q, i[1])
    else:
        heapq.heappop(q)
        heapq.heappush(q, i[1])

print (len(q))