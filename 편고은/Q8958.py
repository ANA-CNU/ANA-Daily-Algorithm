test_case = int(input())

for i in range(test_case):
    quiz_ans = input()

    tmp = 0
    score_sum = 0

    for j in range(len(quiz_ans)):
        if quiz_ans[j] == "O":
            tmp += 1
            score_sum += tmp

        elif quiz_ans[j] == "X":
            tmp = 0

    print(score_sum)
