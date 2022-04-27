import sys
n, m = map(int, sys.stdin.readline().split())
numbers = [0]+list(map(int, sys.stdin.readline().split()))
prepix = [0] * m
for i in range(1, n+1):
    numbers[i] += numbers[i-1]
    prepix[numbers[i] % m] += 1
cnt = prepix[0]
for i in prepix:
    cnt += i*(i-1)//2
print(cnt)