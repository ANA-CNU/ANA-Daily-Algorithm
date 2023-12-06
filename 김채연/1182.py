import sys
input = sys.stdin.readline

n, s = map(int, input().split())
nums = list(map(int, input().split()))
res = []
cnt = 0

def back(idx):
    global cnt
    if sum(res)==s and len(res)!=0:
        cnt +=1

    for i in range(idx, n):
        res.append(nums[i])
        back(i+1)
        res.pop()

back(0)
print(cnt)
