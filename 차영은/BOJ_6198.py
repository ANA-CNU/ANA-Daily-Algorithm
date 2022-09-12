import sys

n = int(sys.stdin.readline())
arr = [int(sys.stdin.readline().strip()) for _ in range(n)]
stk = []
tot = 0

for i in range(n):
    while stk and stk[-1] <= arr[i]:
        stk.pop()

    stk.append(arr[i])
    tot += len(stk) - 1

print(tot)
