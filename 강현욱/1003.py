import sys
input=sys.stdin.readline
ls=[0]*102
ls[0]=0
ls[1]=1
ls[2]=1
ls[3]=1
ls[4]=2
ls[5]=2
ls[6]=3
ls[7]=4
for j in range(4,102):
    ls[j]=+ls[j-2]+ls[j-3]
num=int(input())
for i in range(num):
    w=int(input())
    print(f'{ls[w]}')
    