#백준 2110번
import sys
input = sys.stdin.readline

n,c = map(int,input().split())
x = []
for i in range(n):
    x.append(int(input()))
a = sorted(x)

start = 0  # 가장 작은 공유기 사이의 거리
end = a[-1] - a[0] # 가장 큰 공유기 사이의 거리
ans = 0 # 인접한 공유기 사이의 최대거리

while start <= end:
    mid = (start + end)//2
    cnt = 1 # 공유기를 설치가능한 집의 수
    b = a[0] # 현재 위치
    for i in range(1,n):
        if a[i] - b >= mid: # 현재 나와 i번째 집의 위치차이가 mid 이상인지 
            b = a[i]  # mid 보다 크면 현재 위치를 i번째 집으로 수정 
            cnt += 1  
    
    if cnt >= c:
        ans = mid
        start = mid + 1
    else:
        end = mid - 1
print(ans)