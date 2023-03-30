string = list(input())

priority = {'(':0, ')':0, '+':1, '-':1, '*':2, '/':2}
operator = []
result = ''

for c in string:
    if c.isalpha():
        result += c
    elif c == '(':
        operator.append(c)
    elif c == ')':
        while operator:
            op = operator.pop()
            if op == '(':
                break
            result += op
    else:
        if operator:
            if priority[operator[-1]] < priority[c]:
                operator.append(c)
            else:
                while operator and priority[operator[-1]] >= priority[c]:
                    result += operator.pop()
                operator.append(c)
        else:
            operator.append(c)
while operator:
    result += operator.pop()

print (result)