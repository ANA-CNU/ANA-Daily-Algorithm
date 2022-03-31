import sys
n = int(sys.stdin.readline())
l = len(str(n))
t = [9*i*10**(i-1) for i in range(1, 9)]
print(sum(t[:l-1])+(n-10**(l-1)+1)*l)