num = int(input())

score_list = list(map(int, input().split()))

score_sum = 0
for i in score_list:
    score_sum += i / max(score_list) * 100 / num

print(score_sum)