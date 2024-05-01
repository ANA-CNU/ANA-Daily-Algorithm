import sys
input = sys.stdin.readline
num=int(input())
dance=['ChongChong']
for j in range(num):
    a,b=input().rstrip().split()
    if (a in dance) or (b in dance):
        if a in dance:
            dance.append(b)
        if b in dance:
            dance.append(a)
ls=set(dance)
print(len(ls))
    
    
