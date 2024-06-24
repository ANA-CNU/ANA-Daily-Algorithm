import itertools
import math
import sys
from bisect import bisect_left, bisect_right

n = int(input())
sqrt_n = int(n ** 0.5)
arr = list(map(int, input().split()))
m = int(input())
queries = [list(map(int, sys.stdin.readline().split())) for _ in range(m)]
buckets = []
idx = 0
while idx < n:
    j = min(idx + sqrt_n, n)
    buckets.append(sorted(arr[idx:j]))
    idx += sqrt_n
# print(buckets)
# arr[1:4] => 1번부터 3번까지란 뜻

for q in queries:
    if q[0] == 2:
        i, j, k = q[1] - 1, q[2] - 1, q[3]
        ans = 0
        lower = math.ceil(i / sqrt_n)
        upper = math.floor((j + 1) / sqrt_n)
        for idx in range(lower, upper):
            ans += len(buckets[idx]) - bisect_right(buckets[idx], k)
        # i랑 j 둘다 하나의 bucket 범위 안에 있을 경우
        if lower * sqrt_n > j:
            for idx in range(i, j + 1):
                if arr[idx] > k:
                    ans += 1
        else:
            for idx in itertools.chain(range(i, lower * sqrt_n), range(upper * sqrt_n, j + 1)):
                if arr[idx] > k:
                    ans += 1
        print(ans)
    else:
        i, k = q[1] - 1, q[2]
        for idx, bucket in enumerate(buckets):
            # 찾으려는 i가 bucket 범위 안에 있다면
            if idx * sqrt_n <= i < (idx + 1) * sqrt_n:
                prev_v = arr[i] # 원래 값
                arr[i] = k # 기본 배열을 새로운 값으로 업데이트
                prev_idx = bisect_left(bucket, prev_v) # 원래 값이 정렬된 리스트에 있는 위치
                bucket[prev_idx] = k # bucket을 새로운 값으로 업데이트
                bucket.sort() # 재정렬
                break