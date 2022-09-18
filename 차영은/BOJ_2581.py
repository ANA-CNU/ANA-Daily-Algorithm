import sys

n = int(sys.stdin.readline())
m = int(sys.stdin.readline())
arr = []

for i in range(n, m + 1):
    sat = True
    for j in range(2, i):
        if i % j == 0:
            sat = False
            break

    if sat and i != 1:
        arr.append(i)

if arr:
    print(sum(arr))
    print(min(arr))
else:
    print(-1)
