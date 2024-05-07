import sys
input = sys.stdin.readline
global enter
def bfs(ls,enter,start):
    enter[start]=True
    ls_bfs=[]
    ls_bfs.append(start)
    while ls_bfs:
        k=ls_bfs.pop(0)
        for j in ls[k]:
            if enter[j]!=True:
                enter[j]=True
                ls_bfs.append(j)
num, line = map(int,input().split())
ls=[[] for i in range(num+1)]
enter = [False]*(num+1)
for j in range(line):
    a,b=map(int,input().split())
    ls[a].append(b)
    ls[b].append(a)
count=0
for i in range(1,num+1):
    if enter[i]!=True:
        bfs(ls,enter,i)
        count+=1
print(count)