# BOJ 20412
# 일차합동식 2개로 a와 c를 구하는 문제
# m이 소수이고 다른 수들이 m보다 작아서 쉬움
# ax==p (mod m) 을 구할 때 ax'==1 (mod m) 을 풀고
# x=x'*p 로 구하는 방식. 분할정복을 통한 거듭제곱 + 페르마의 소정리

def inv(n):
    p=n%m; res=1; r=m-2
    while r:
        if r%2: res=res*p%m
        p=p*p%m
        r//=2
    return res

m,s,x,y=map(int,input().split())
nx=inv(x)
c=inv(1-nx*s)*((x-(((nx*y)%m)*s)%m)%m)%m
a=nx*(y-c)%m
print(a,c)
