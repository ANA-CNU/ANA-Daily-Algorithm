import sys
input=sys.stdin.readline
num=int(input())
count=0
while num!=1:
    if num%6==0:
        num=num//3
        num=num//2
        count=+2        
    elif num%6==1:
        num=num-1
        count+=1
    elif num%6==2:
        num=num//2
        count+=1
    elif num%6==3:
        num=num//3
        count+=1
    elif num%6==4:
        num=num-1
        num=num//3
        count+=2
    else:
        num=num-1
        count+=1
print(count)