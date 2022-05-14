# C(k+n,n-1)
# n이 매우 크므로 펙토리얼 값을 효율적으로 계산하도록 함

k,n=map(int,input().split())
c=10**9+7
def inv(num):
    p=num; res=1; y=c-2
    while y:
        if y%2: res=res*p%c
        p=p*p%c
        y//=2
    return res
f=1
for i in range(k+n,n-1,-1):
    f=f*i%c
g=1
for i in range(2,k+2):
    g=g*i%c
print(f*inv(g)%c)
