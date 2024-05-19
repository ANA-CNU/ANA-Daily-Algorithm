import sys
input=sys.stdin.readline
from collections import deque
col, row = map(int,input().split())
tomato = []
for j in range(row):
    tomato.append(list(map(int,input().split())))
enter = [[False] * col for _ in range(row)]
queue=deque()
setup=deque()
count=0
dxdy=[[1,0],[-1,0],[0,1],[0,-1]]
tomato_none=tomato
for w in range(row):
    for e in range(col):
        if tomato[w][e]==1 and enter[w][e] == False:
            enter[w][e]=True
            queue.append([w,e])
while queue:
    while queue:
        setup.append(queue.popleft())
    count=count+1
    for i in range(len(setup)):
        a,b=setup.popleft()
        for n in range(4):
            a+=dxdy[n][0]
            b+=dxdy[n][1]
            if (a>=0 and a<row) and (b>=0 and b<col):
                if enter[a][b]==False and tomato[a][b]==0:
                    queue.append([a,b])
                    enter[a][b]=True
                    tomato[a][b]=1
            a-=dxdy[n][0]
            b-=dxdy[n][1]
izen=0
check=0
for m in range(row):
    for l in range(col):
        if enter[m][l]==False and tomato[m][l]==0:
            print(-1)
            izen=1
            break
        elif tomato_none[m][l]==0:
            check==1
    if izen==1:
        break
if izen==0:
    print(count-1)
if check==1:
    print(0)
    
            
    
    
    
    