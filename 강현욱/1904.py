import sys
from collections import deque
input=sys.stdin.readline
ls=deque()
ls.append(0)
ls.append(1)
ls.append(2)
num=int(input())
if num<=2:
    print(ls[num])
else:
    for j in range(3,num+1):
        ls.append(ls[1]%15746+ls[2]%15746)
        ls.popleft()
    print(ls.pop()%15746)