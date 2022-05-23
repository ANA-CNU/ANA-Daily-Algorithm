x,y=map(int,input().split())
for i in range(x,y+1):
    if i==1:
        continue
    for j in range(2,int(i**0.5)+1):
        if i%j==0:
            break
    else: print(i)