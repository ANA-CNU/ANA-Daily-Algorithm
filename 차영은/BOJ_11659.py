import sys

n, m = map(int, sys.stdin.readline().split())
arr = list(map(int, sys.stdin.readline().split()))
sum_arr = 0
prefix_sum = [0]

for i in arr:
    sum_arr += i
    prefix_sum.append(sum_arr)

for _ in range(m):
    s, e = map(int, sys.stdin.readline().split())
    print(prefix_sum[e] - prefix_sum[s - 1])
