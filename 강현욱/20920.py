import sys
input=sys.stdin.readline
a, b= map(int,input().split())
ls=list(map(int,input().split()))
sum=[0]*(a+1)
for k in range(len(ls)):
    sum[k+1]=sum[k]+ls[k]
    
for j in range(b):
    i,j=map(int,input().split())
    k=sum[j]-sum[i-1]
    print(k)


        
        
        
            



