num=int(input())
hansu=0

for i in range(1,num+1):
    if i<100:
        hansu=hansu+1
    else:
        n=list(map(int,str(i)))
        if n[0]-n[1]==n[1]-n[2]:
            hansu=hansu+1
        else:continue
print(hansu)
