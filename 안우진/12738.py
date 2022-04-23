# 12015

n=int(input())
A=list(map(int,input().split()))
res=[-1000000001] # 최소값
def s(num):
    lo=0; hi=len(res)
    while lo+1<hi:
        mid=(lo+hi)//2
        if res[mid]<num: lo=mid
        else: hi=mid
    return lo
for i in range(n):
    if res[-1]<A[i]:
        res.append(A[i])
        continue
    res[s(A[i])+1]=A[i]
print(len(res)-1)
