#백준 2805번 나무자르기
import sys
input = sys.stdin.readline
n,m = map(int,input().split())

trees = list(map(int,input().split()))

start,end = 0,max(trees)
while start <= end:
    mid = (start+end)//2
    cnt = 0
    
    for i in trees:
        if i > mid:
            cnt += i - mid
    
    if cnt >= m: # 원하는 나무 높이 보다 더 짤렸을떄
        start = mid + 1
    else:    # 원하는 높이보다 덜 짤렸을때
        end = mid - 1

print(end)
print(cnt)