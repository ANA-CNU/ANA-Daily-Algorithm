# 11286
import heapq, sys

N = int(sys.stdin.readline())

heap = []

for _ in range(N):
    x = int(sys.stdin.readline())

    if x == 0:
        if not(heap):
            print(0)
        else:
            absVal, sign = heapq.heappop(heap)

            if sign > 0:
                print(absVal)
            else:
                print(-1 * absVal)

    else:
        if x > 0:
            heapq.heappush(heap, (abs(x), 1))

        else:
            heapq.heappush(heap, (abs(x), -1))
