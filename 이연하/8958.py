n=int(input())
for i in range(n):
    a=list(input())
    count=0
    sum=0
    for i in a:
        if i=="O":
            count=count+1
            sum=sum+count
        else: count=0
    print(sum)