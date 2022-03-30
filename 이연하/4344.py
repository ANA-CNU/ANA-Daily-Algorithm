c=int(input())

for i in range(c):
    score=list(map(int,input().split()))
    avg=sum(score[1:])/score[0] #score[1:]:점수, score[0]:학생수
    count=0

    for a in score[1:]:
        if a>avg:
            count=count+1

    pct=(count/score[0])*100
    print('%.3f' %pct +'%')