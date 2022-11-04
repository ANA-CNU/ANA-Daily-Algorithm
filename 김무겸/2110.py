import math
import sys

input = sys.stdin.readline

N, C = map(int, input().split())
house = []
for _ in range(N):
    house.append(int(input()))
house.sort()


def func(x):
    cnt = 1
    prev_idx = 0
    for i in range(1, N):
        if house[i] - house[prev_idx] >= x:
            cnt += 1
            prev_idx = i
    return cnt >= C


start, end = 0, max(house) - min(house)
while start <= end:

    # 가장 인접한 공유기와의 거리를 최대로
    mid = (start + end) // 2
    if func(mid):
        start = mid + 1
    elif not func(mid):
        end = mid - 1

print(end)