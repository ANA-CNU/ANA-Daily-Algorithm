import sys

n = int(sys.stdin.readline())
ex = False
ans = 0

for i in range(n):
    s = sum(map(int, str(i)))
    ans = s + i

    if ans == n:
        ex = True
        ans = i
        break

print(ans if ex else 0)
