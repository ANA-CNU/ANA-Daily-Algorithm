import sys

N = int(input())
liq = list(map(int, input().split()))
liq.sort()
start, end = 0, N - 1 # index
ans, ans_len = [], sys.maxsize
while start < end:
    liqs = liq[start] + liq[end]
    if ans_len > abs(liqs):
        ans = [liq[start], liq[end]]
        ans_len = abs(liqs)

    if liqs < 0:
        start += 1
    else:
        end -= 1


print(*ans)