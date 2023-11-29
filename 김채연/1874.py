n = int(input())
stack = []
top = 1
Out_list = []
res = True
for _ in range(n):
    num = int(input())
    while top <= num:
        stack.append(top)
        Out_list.append('+')
        top +=1
    if stack[-1] == num:
        stack.pop()
        Out_list.append('-')
    else:
        print('NO')
        res = False
        break
        

if res == True:
    for s in Out_list:
        print(s)
