import sys
import heapq

n, k = map(int, sys.stdin.readline().split())
arr = list(map(int, sys.stdin.readline().split()))

# 시험관 배열 생성
heap = []
for i, v in enumerate(arr):
    heapq.heappush(heap, (-v, i + 1))

res = []
while heap:
    v, i = heapq.heappop(heap)

    if res and res[-1] == i and heap:
        # 최대 힙에서 가져온 수가 직전에 가져온 수와 동일한 경우
        nv, ni = heapq.heappop(heap)
        res.append(ni)
        if nv+1 < 0:
            heapq.heappush(heap, (nv+1, ni))
        heapq.heappush(heap, (v, i))    # 사용하지 않은 수는 다시 최대 힙에 삽입
    else:
        # 최대 힙에서 가져온 수와 직전에 가져온 수가 다른 경우
        res.append(i)
        if v+1 < 0:
            heapq.heappush(heap, (v+1, i))

# 조건에 맞는 시험관 배열 생성 가능 여부 확인
check = 1
last_val = res[0]
for val in res[1:]:
    if last_val == val:
        check = 0
        break
    last_val = val

# check : 해당 시험관 배열이 조건에 맞는지
if check:
    print(*res)
else:
    print(-1)
