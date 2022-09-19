import sys

infix = sys.stdin.readline().strip()
infix += '$'
postfix = ''
stack = []
operator = ['+', '-', '*', '/']


def priority(op):
    if op == '+' or op == '-':
        return 1
    elif op == '*' or op == '/':
        return 2
    else:
        return 0


for i in infix:
    if i != '(' and i != ')' and i not in operator:
        postfix += i
    if i == '(':
        stack.append(i)
    elif i == ')':
        while stack and stack[-1] != '(':
            postfix += stack.pop()
        if stack:
            stack.pop()
    elif i in operator:
        while stack and priority(stack[-1]) >= priority(i):
            postfix += stack.pop()
        stack.append(i)
    elif i == '$':
        while stack:
            postfix += stack.pop()

print(postfix.replace('$', ''))
