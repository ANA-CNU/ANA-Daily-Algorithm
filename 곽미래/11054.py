import sys
n = int(sys.stdin.readline())
numbers = list(map(int, sys.stdin.readline().split()))

dp_right = [0]*n
dp_left = [0]*n
for i in range(n):
    for j in range(i):
        if numbers[j] < numbers[i] and dp_right[j] > dp_right[i]:
            dp_right[i] = dp_right[j]
    dp_right[i] += 1
for i in range(n-1, -1, -1):
    for j in range(i, n):
        if numbers[j] < numbers[i] and dp_left[j] > dp_left[i]:
            dp_left[i] = dp_left[j]
    dp_left[i] += 1
for i in range(n):
    dp_left[i] += dp_right[i]
print(max(dp_left)-1)

