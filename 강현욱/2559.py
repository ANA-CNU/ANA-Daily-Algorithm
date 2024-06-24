import sys
input = sys.stdin.readline

lent, suc = map(int, input().split())
ls=list(map(int, input().rstrip().split()))

lsnew=[]

sum_ls = sum(ls[0:suc])

lsnew.append(sum_ls)

for j in range(suc,len(ls)):
    sum_ls=sum_ls+ls[j]-ls[j-suc]
    lsnew.append(sum_ls)
   

print(max(lsnew))
    
    
