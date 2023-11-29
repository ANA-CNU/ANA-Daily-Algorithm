import sys
r=sys.stdin.readline

def bitCount(x):
    if x==0: return 0
    return x%2 + bitCount(x//2)

n,k=map(int,r().split())
b=[0]*1024
for _ in range(n):
    res=0
    for e in r().rstrip():
        res |= (1 << int(e))
    b[res]+=1

ans=0
for i in range(1024):
    if b[i] == 0: continue
    if bitCount(i) == k:
        ans+=b[i]*(b[i]-1)//2
    for j in range(i+1,1024):
        if b[j] == 0: continue
        if bitCount(i|j) == k:
            ans+=b[i]*b[j]
print(ans)
