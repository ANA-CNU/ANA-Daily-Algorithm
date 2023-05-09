#백준 1654번 랜선 자르기
#이분 탐색
import sys
input = sys.stdin.readline
k,n = map(int,input().split())
a = []
for i in range(k):
    a.append(int(input()))

left, right = 1, max(a)

while left <= right:
    mid = (left + right) // 2
    cnt = 0
    for lan in a:
        cnt += lan // mid

    if cnt >= n:
        left = mid + 1
    else:
        right = mid - 1

print(right)