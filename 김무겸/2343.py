N, M = map(int, input().split())
arr = list(map(int, input().split()))

start = max(arr)
end = sum(arr)

while start <= end:
    mid = (start + end) // 2
    count = 0
    sum = 0
    for a in arr:
        if sum + a > mid:
            sum = 0
            count += 1
        sum += a
    if sum != 0:
        count += 1
    if count > M:
        start = mid + 1
    else:
        end = mid - 1

print(start)

