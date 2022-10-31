S = list(input())
T = list(input())

flag = False

while len(S) != len(T):
    if T[-1] == 'A':
        T.pop()
    elif T[-1] == 'B':
        T.pop()
        T = T[::-1]

if S==T:
    print (1)
else:
    print (0)