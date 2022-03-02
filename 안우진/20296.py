# BOJ 20296
# 중복조합 부정방정식 포함 배제의 원리
# 분할정복을 통한 거듭제곱 및 페르마의 소정리
# 펙토리얼을 미리 계산해두고 활용

def inv(n):
    p=n; res=1; y=C-2
    while y:
        if y%2: res=res*p%C
        p=p*p%C
        y//=2
    return res
    
def comb(n,r):
    return (f[n]*inv(f[r])%C)*inv(f[n-r])%C

f=[1]*1001000
C=10**9+7
N,m,M,K=map(int,input().split())
K-=N*m; M-=m
for i in range(1,N+K):
    f[i]=(f[i-1]*i)%C
    
ans=0
for i in range(N):
    if K<0: break
    ans+=((-1)**i)*(comb(N,i)*comb(N+K-1,K)%C)
    ans=ans%C
    K-=M+1
print(ans)
