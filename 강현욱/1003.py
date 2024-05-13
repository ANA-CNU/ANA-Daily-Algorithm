import sys
input=sys.stdin.readline
ls=[[0] *2 for j in range(41)]
ls[0][0]=1
ls[0][1]=0
ls[1][0]=0
ls[1][1]=1
for j in range(2,41):
    ls[j][0]=ls[j-1][0]+ls[j-2][0]
    ls[j][1]=ls[j-1][1]+ls[j-2][1]
num=int(input())
for i in range(num):
    w=int(input())
    print(f'{ls[w][0]} {ls[w][1]}')
    