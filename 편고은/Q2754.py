grade = input()

if grade == 'F':
    score = 0.0
else:
    if grade[0] == 'A':
        score = 4
    elif grade[0] == 'B':
        score = 3
    elif grade[0] == 'C':
        score = 2
    elif grade[0] == 'D':
        score = 0

    if grade[1] == '+':
        score  += 0.3
    elif grade[1] == '0':
        score += 0.0
    elif grade[1] == '-':
        score -= 0.3

print(score)
