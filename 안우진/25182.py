n=int(input())
c=10**9+7
t=n*(n+1)%c
f=1
for i in range(2,n+1):
    f=f*i%c
print((t*t%c*250000002%c+t*(2*n+1)%c*166666668%c)%c,f*f%c)
