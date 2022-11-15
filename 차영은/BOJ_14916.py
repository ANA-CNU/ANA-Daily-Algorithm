import sys

n = int(sys.stdin.readline())

if n < 5 and n % 2 != 0:
    print(-1)
    exit(0)

f_cnt = n // 5
t_cnt = 0
tmp = n - (f_cnt * 5)

if tmp % 2 != 0:
    f_cnt -= 1
    tmp += 5

t_cnt = tmp // 2
tot = (f_cnt * 5) + (t_cnt * 2)

print(f_cnt + t_cnt if tot == n else -1)
