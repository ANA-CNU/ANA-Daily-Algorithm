# 선대로 일반항 구함
# 0 또는 1일 경우 순서가 중요함

def mpow(n,y):
    p=n%C; res=1
    while y:
        if y%2: res=res*p%C
        p=p*p%C
        y//=2
    return res

C=10**9+7
P=int(input())
Q=int(input())
N=int(input())
K=int(input())
if K==N: print(1)
elif K==0: print(0)
elif Q==P: print(0)
elif Q==0: print(1)
else:
    if P==2*Q:
        print(K*mpow(N,C-2)%C)
    else:
        a=Q*mpow(P,C-2)%C
        b=a*mpow(1-a+C,C-2)%C
        num = 1 - mpow(b,K) + C
        den = 1 - mpow(b,N) + C
        print(num*mpow(den,C-2)%C)
