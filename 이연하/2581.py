m = int(input())
n = int(input())
alist=[]

for i in range(m, n+1):
    count = 0
    for j in range(1,i+1):
        if i%j ==0:
            count=count+1
            if count>2:
                break
    if count ==2:
        alist.append(i)
if len(alist) !=0:
    print(sum(alist))
    print(alist[0])
else:
    print('-1')
