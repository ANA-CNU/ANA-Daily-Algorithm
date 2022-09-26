S = input()
B = list(input())

lastB = B[-1]
stack = []
lB = len(B)

for i in S:
    stack.append(i)
    if i==lastB:
        if stack[-lB:] == B:
            del stack[-lB:]
    
if len(stack)==0:
    print ('FRULA')
else:
    print (''.join(stack))