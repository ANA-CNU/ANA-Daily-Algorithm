# 회의실 배정 - 1931

import sys

n = int(sys.stdin.readline())
wish_time = [tuple(map(int, sys.stdin.readline().split())) for _ in range(n)]
sorted_wish_time = sorted(wish_time, key=lambda x: (x[1], x[0]))
fixed_time = [sorted_wish_time.pop(0)]
for time in sorted_wish_time:
    if fixed_time[-1][1] <= time[0]:
        fixed_time.append(time)
print(len(fixed_time))