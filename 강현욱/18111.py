import sys
input=sys.stdin.readline
row,col,block=list(map(int,input().split()))
field=[]
for j in range(row):
    x=list(map(int,input().split()))
    field.extend(x)
result_sec = 99999999
result_h = 0
for u in range(256,-1,-1):
    sum_stack=0
    sum_cut=0
    clock_sum=0
    count=block
    for i in range(len(field)):
            if(u>=field[i]):
                sum_stack=sum_stack+(u-field[i])
                count=count-(u-field[i])
            else:
                sum_cut=sum_cut+(field[i]-u)
                count=count+(field[i]-u)
            clock_sum=sum_stack+sum_cut*2
    if(count<0):
            continue
    if clock_sum < result_sec:
        result_sec=clock_sum
        result_h=u
print(result_sec, result_h)