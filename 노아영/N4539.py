import sys
n = int(sys.stdin.readline())
def r(x):
    if x<5:
        return 0
    else:
        return 1
for _ in range(n):
    x = list(sys.stdin.readline().strip())
    for i in range(len(x)-1, 0, -1):
        if r(int(x[i])):
            tmp = int(x[i-1])+1
            x[i-1] = str(tmp)
        x[i] = "0"
    print(''.join(x))
    