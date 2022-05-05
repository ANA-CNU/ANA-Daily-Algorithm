a,b=map(int,input().split())
ans=b-a+1
i=0
while b:
    b//=2
    ans+=b*(2**i)
    i+=1
a-=1
i=0
while a:
    a//=2
    ans-=a*(2**i)
    i+=1
print(ans)
