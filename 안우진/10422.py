# BOJ 10422
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
f=[1]*5001
C=10**9+7
for i in range(1,5001):
    f[i]=(f[i-1]*i)%C
    
for _ in range(int(r())):
    n=int(r())
    if n%2==1: print(0)
    else: print(comb(n,n//2)*inv(n//2+1)%C)
