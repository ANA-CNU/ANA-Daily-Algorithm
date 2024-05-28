import sys

t = int(sys.stdin.readline().strip())

for _ in range(t):
    n = int(sys.stdin.readline().rstrip())
    arr = list(map(int, sys.stdin.readline().split()))

    result = [0] * n
    numbers = []
    check = True

    for i in range(n-1, -1, -1):
        cur = arr[i] + 1  # cur

        cnt = 0  # cnt
        for number in numbers:
            if cur+cnt >= number:
                cnt += 1
            else:
                break

        cur += cnt

        if arr[i] > i:
            check = False

        result[i] = cur
        numbers.append(cur)
        numbers.sort()

    if not check:
        print("IMPOSSIBLE")
    else:
        print(*result)
