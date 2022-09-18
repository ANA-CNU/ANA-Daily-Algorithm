import sys

n = list(map(int, sys.stdin.readline().strip()))
a = sum(n)
cnt = 0

while len(n) > 1:
    n = list(map(int, str(a)))
    a = sum(n)
    cnt += 1

print(cnt)
print('NO' if a % 3 != 0 or a == 0 else 'YES')
