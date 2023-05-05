from collections import deque

string = list(input())

deq = deque()

answer = ""

operator = {'(': 1, '+': 2, '-': 2, '*': 3, '/': 3}

for i in string:
    if (i.isalpha()):
        answer += i
    elif (i == "("):
        deq.append(i)
    elif (i == ")"):
        while True:
            x = deq.pop()
            if (x == "("):
                break
            answer += x
    else:
        while deq and operator.get(deq[-1], 0) >= operator[i]:
            answer += deq.pop()
        deq.append(i)

for i in range(len(deq)):
    answer += deq.pop()
print(answer)

