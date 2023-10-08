import sys


def check_explode():
    if ''.join(stack[len(stack) - len(bomb):len(stack)]) == bomb:
        for _ in range(len(bomb)):
            stack.pop()


string = sys.stdin.readline().strip()
bomb = sys.stdin.readline().strip()
stack = []

for s in string:
    stack.append(s)
    check_explode()

print(*stack if stack else 'FRULA', sep='')
