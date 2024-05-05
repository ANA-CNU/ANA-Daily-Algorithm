from collections import deque

s = input()
stack = deque()
for ch in s:
    if len(stack) > 0 and stack[-1] == 'A':
        if ch != 'P' or len(stack) < 3 or not (stack[-2] == 'P' and stack[-3] == 'P'):
            print('NP')
            exit()
        stack.pop()
        stack.pop()
    else:
        stack.append(ch)
if len(stack) == 1 and stack[0] == 'P':
    print('PPAP')
else:
    print('NP')