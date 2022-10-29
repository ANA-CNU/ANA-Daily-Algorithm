N, M = map(int, input().split())
L = [int(input()) for _ in range(N)]

start = 0
end = max(L)*M

while start<=end:
    mid = (start+end)//2

    tmp = 0
    for i in L:
        tmp += mid//i
    
    if tmp < M:
        start = mid+1
    else:
        end = mid-1

print(start)