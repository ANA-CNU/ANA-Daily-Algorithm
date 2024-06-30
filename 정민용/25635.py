import sys

n = int(sys.stdin.readline().rstrip())
arr = list(map(int, sys.stdin.readline().split()))
arr.sort()

res = 0
total_num = 0

for i, num in enumerate(arr):
    if i == n - 1:
        res += min(total_num+1, num)
        break

    res += num
    total_num += num

print(res)