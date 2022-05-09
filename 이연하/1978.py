n = int(input())
a = list(map(int, input().split()))
b = 0

for i in a:
    c = 0
    if(i==1):
        continue
    for j in range(2,i+1):
        if(i%j==0):
            c=c+1
    if (c ==1):
        b=b+1
print(b)