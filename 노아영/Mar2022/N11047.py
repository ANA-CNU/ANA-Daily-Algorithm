import sys
n, k = map(int, sys.stdin.readline().split())
a_l = []
for _ in range(n):
    a = int(sys.stdin.readline())
    if a > k:
        continue
    a_l.append(a)

i, cnt = -1, 0
while True:
    cnt += k//a_l[i]
    k = k%a_l[i]
    i -= 1
    if abs(i) > len(a_l):
        break
print(cnt)