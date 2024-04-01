import sys
table = {"A+": 4.5, "A0": 4.0, "B+": 3.5, "B0": 3.0,
         "C+": 2.5, "C0": 2.0, "D+": 1.5, "D0": 1.0, "F": 0.0, "P": None}

credit_list = []
grade_list = []
for i in range(20):
    _, credit, grade = map(str, sys.stdin.readline().split())
    if grade != "P":
        credit_list.append(float(credit))
        grade_list.append(table[grade])

total = [i*j for i, j in zip(credit_list, grade_list)]
result = sum(total) / sum(credit_list)
print(result)
