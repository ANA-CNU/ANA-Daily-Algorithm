import sys
n = int(sys.stdin.readline())
numbers = [int(sys.stdin.readline()) for _ in range(n)]
stk = []
cal = []
idx = 0
for i in range(1, n+1):
    stk.append(i)
    cal.append('+')

    while len(stk) != 0 and stk[-1] == numbers[idx]:
        stk.pop()
        idx += 1
        cal.append('-')

result = True
for i in range(len(stk)):
    if stk[-1] == numbers[idx]:
        stk.pop()
        idx += 1
        cal.append('-')
    else:
        result = False
        break
if result:
    print(*cal, sep='\n')
else:
    print('NO')