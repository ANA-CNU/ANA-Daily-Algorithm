import sys
import heapq
input = sys.stdin.readline

ls=[]
count = int(input())
for j in range(count):
    num=int(input())
    if num>0:
        heapq.heappush(ls, (num,num))
    elif num==0:
        if len(ls)==0:
            print(0)
        else:
            print(heapq.heappop(ls)[1])
    else:
        heapq.heappush(ls, (-num,num))