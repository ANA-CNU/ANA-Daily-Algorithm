import sys

n = int(sys.stdin.readline())
arr = list(map(int, sys.stdin.readline().strip().split()))
m = int(sys.stdin.readline())

start = 1
end = max(arr)

if sum(arr) <= m:
    print(end)
else:
    while start <= end:
        mid = (start + end) // 2
        num = 0

        for i in arr:
            if i >= mid:
                num += mid
            else:
                num += i

        if num <= m:
            start = mid + 1
        else:
            end = mid - 1

    print(end)
