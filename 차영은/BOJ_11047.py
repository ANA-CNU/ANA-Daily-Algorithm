import sys

n, k = map(int, sys.stdin.readline().split())
coins = []
ans = 0

for i in range(n):
    coins.append(int(sys.stdin.readline()))

for i in coins[::-1]:
    if k // i != 0:
        cnt = k // i
        ans += cnt
        k -= i * cnt

print(ans)
