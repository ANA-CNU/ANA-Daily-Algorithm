import sys
input = sys.stdin.readline
n = int(input())
stack = []
for _ in range(n):
    com = list(input().split())
    command = com[0]
    if command == 'push':
        stack.append(com[1])
    elif command == 'pop':
        if len(stack)!=0:
            print(stack.pop())
        else:
            print(-1)
    elif command == 'size':
        print(len(stack))
    elif command == 'empty':
        if len(stack)!=0:
            print(0)
        else:
            print(1)
    elif command == 'top':
        if len(stack)!=0:
            print(stack[len(stack)-1])
        else:
            print(-1)
