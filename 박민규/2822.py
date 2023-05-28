# 백준 2822번 
score = []
sum = 0
num = []
for i in range(1,9):
    score.append((int(input()),i)) 
    # 점수랑 순서를 묶어서 풀면된다.

score.sort( reverse = True )

for j,k in score[:5]:
    sum += j
    num.append(k)

print(sum)
print(*sorted(num))
