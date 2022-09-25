import sys

k, n = map(int, sys.stdin.readline().strip().split())
arr = []

for _ in range(k):
    arr.append(int(sys.stdin.readline()))

start = 1
end = max(arr)

while start <= end:
    mid = (start + end) // 2
    num = 0

    for i in arr:
        num += i // mid

    if num >= n:
        start = mid + 1
    else:
        end = mid - 1

print(end)
