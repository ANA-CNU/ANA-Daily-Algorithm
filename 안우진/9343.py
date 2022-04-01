# BOJ 9343
# 카탈란 수

def inv(n):
    p=n; res=1; y=C-2
    while y:
        if y%2: res=res*p%C
        p=p*p%C
        y//=2
    return res
    
def comb(n,r):
    return (f[n]*inv(f[r])%C)*inv(f[n-r])%C

import sys; r=sys.stdin.readline
f=[1]*2000001
C=10**9+7
for i in range(1,2000001):
    f[i]=(f[i-1]*i)%C
    
for _ in range(int(r())):
    n=int(r())
    print(comb(2*n,n)*inv(n+1)%C)
