import sys

n, m = map(int, sys.stdin.readline().strip().split())
arr = list(map(int, sys.stdin.readline().strip().split()))

start = 1
end = max(arr)

while start <= end:
    mid = (start + end) // 2
    num = 0

    for i in arr:
        if mid <= i:
            num += i - mid

    if num >= m:
        start = mid + 1
    else:
        end = mid - 1

print(end)
