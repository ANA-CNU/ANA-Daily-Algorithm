import sys
n, k = map(int, sys.stdin.readline().split())
l = len(str(n))
t = [9*i*10**(i-1) for i in range(1, 10)]
ans = sum(t[:l-1])+(n-10**(l-1)+1)*l
if ans < k:
    print(-1)
else:
    if k < 10:
        print(k)
        exit()
    for i in range(1, 10):
        if sum(t[:i])-k > 0: 
            tmp = k-sum(t[:i-1])
            num = str(10**(i-1)+(tmp-1)//i)
            print(num[(tmp-1)%i])
            break
