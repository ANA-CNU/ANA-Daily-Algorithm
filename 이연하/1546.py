n= int(input())
score=list(map(int,input().split()))
m=max(score)

for i in range(n):
    score[i]=score[i]/m*100
    avg=sum(score)/n
print("%.2f"%avg)