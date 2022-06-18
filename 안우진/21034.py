# BOJ 20296 보다 쉬운 문제
# 포함 배제로 풀음. 
# 0 1 2만 되서 포함배제 안써도 된다는데 생각해봐야겠다.

c=1000000007
def inv(k):
    res=1; p=k; y=c-2
    while y:
        if y%2: res=res*p%c
        y//=2
        p=p*p%c
    return res

def comb(a,b):
    if b<0 or a<0: return 0
    return f[a]*inv(f[b])%c*inv(f[a-b])%c
    
n,m=map(int,input().split())
t=n-2*(m+1)
if t>0:
    print(0)
elif t==0:
    print(1)
else:
    f=[1]*(n+m+1)
    for i in range(2,n+m+1):
        f[i]=f[i-1]*i%c
    ans=0
    k=n
    for i in range(m+1):
      if k<0: break
      ans+=((-1)**i)*comb(m+1,i)*comb(m+k,k)%c
      ans%=c
      k-=3
    print(ans)
