import sys
import heapq
input = sys.stdin.readline
n = int(input())
heap = []

for i in range(n):
    a = int(input())
    if a == 0:
        if len(heap) == 0:
            print(0)
        else:
            print(heapq.heappop(heap)[1])
    else:
        heapq.heappush(heap,(abs(a),a))