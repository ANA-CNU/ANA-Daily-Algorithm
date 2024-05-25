import sys
from collections import deque

# sys.stdin = open('tools/testcase.txt', 'r')
# sys.stdout = open('tools/output2.txt', 'w')

n, k = map(int, input().split())
sqrt_n = int(n ** 0.5)
arr = list(map(int, input().split()))
m = int(input())
queries = [list(map(lambda x: int(x) - 1, sys.stdin.readline().split())) for _ in range(m)]

# 각각의 수가 위치한 인덱스
indices_of = [deque() for _ in range(k + 1)]
# 가장 왼쪽 오른쪽 인덱스 간의 거리 모음
counter = [0] * (n + 2)
buckets = [0] * (sqrt_n + 10)
x, y = 0, -1
idx = 0
for q in sorted(queries, key=lambda x: (x[0] // sqrt_n, x[1])):
    # if idx % 100 == 0:
    #     print(idx)
    left, right = q
    # 최초 초기화
    if idx == 0:
        x = y = left
        indices_of[arr[x]].append(x)
    while y < right:
        y += 1
        lst = indices_of[arr[y]]
        lst.append(y)
        if len(lst) > 1:
            if len(lst) > 2:
                counter[lst[-2] - lst[0]] -= 1
                buckets[(lst[-2] - lst[0]) // sqrt_n] -= 1
            tmp = lst[-1] - lst[0]
            counter[tmp] += 1
            buckets[tmp // sqrt_n] += 1
    while y > right:
        lst = indices_of[arr[y]]
        if len(lst) > 1:
            if len(lst) > 2:
                counter[lst[-2] - lst[0]] += 1
                buckets[(lst[-2] - lst[0]) // sqrt_n] += 1
            tmp = lst[-1] - lst[0]
            counter[tmp] -= 1
            buckets[tmp // sqrt_n] -= 1
        pop = lst.pop()
        y -= 1
    while x > left:
        x -= 1
        lst = indices_of[arr[x]]
        lst.appendleft(x)
        if len(lst) > 1:
            if len(lst) > 2:
                counter[lst[-1] - lst[1]] -= 1
                buckets[(lst[-1] - lst[1]) // sqrt_n] -= 1
            tmp = lst[-1] - lst[0]
            counter[tmp] += 1
            buckets[tmp // sqrt_n] += 1
    while x < left:
        lst = indices_of[arr[x]]
        if len(lst) > 1:
            if len(lst) > 2:
                counter[lst[-1] - lst[1]] += 1
                buckets[(lst[-1] - lst[1]) // sqrt_n] += 1
            tmp = lst[-1] - lst[0]
            counter[tmp] -= 1
            buckets[tmp // sqrt_n] -= 1
        pop = lst.popleft()
        x += 1
    # 연산결과 저장
    ans = 0
    for i in range(len(buckets) - 1, -1, -1):
        if buckets[i] == 0:
            continue
        for j in range(sqrt_n, -1, -1):
            if len(counter) > i * sqrt_n + j and counter[i * sqrt_n + j] >= 1:
                ans = i * sqrt_n + j
                break
        break
    q.append(ans)
    idx += 1

print(*map(lambda x: x[-1], queries), sep='\n')