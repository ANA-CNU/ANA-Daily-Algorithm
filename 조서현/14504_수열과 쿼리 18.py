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
    if q[0] == 1:
        i, j, k = q[1] - 1, q[2] - 1, q[3]
        ans = 0
        for idx, bucket in enumerate(buckets):
            if idx * sqrt_n <= i < (idx + 1) * sqrt_n:
                # i랑 j 둘다 bucket 범위 안에 있을 경우
                if idx * sqrt_n <= j < (idx + 1) * sqrt_n:
                    # naive하게 계산
                    sub_arr = arr[i:j+1]
                    sub_arr.sort()
                    ans += len(sub_arr) - bisect_right(sub_arr, k)
                    break # j 범위까지가 마지막이므로 반복문 중단
                # i만 bucket 범위 안에 있을 경우
                else:
                    sub_arr = arr[i:(idx + 1) * sqrt_n]
                    sub_arr.sort()
                    ans += len(sub_arr) - bisect_right(sub_arr, k)
            # i는 아니지만 j는 bucket 범위 안에 있을 경우
            elif idx * sqrt_n <= j < (idx + 1) * sqrt_n:
                # naive하게 계산
                sub_arr = arr[idx*sqrt_n:j+1]
                sub_arr.sort()
                ans += len(sub_arr) - bisect_right(sub_arr, k)
                break # j 범위까지가 마지막이므로 반복문 중단
            # i와 j 사이에 bucket의 모든 인덱스가 포함될 경우
            elif i <= idx * sqrt_n and (idx + 1) * sqrt_n <= j:
                sub_arr = bucket
                ans += len(sub_arr) - bisect_right(sub_arr, k)
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