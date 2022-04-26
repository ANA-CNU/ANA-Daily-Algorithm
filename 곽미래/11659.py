import sys
n, m = map(int, sys.stdin.readline().split())
numbers = [0] * (n+1)
for i, num in enumerate(list(map(int, sys.stdin.readline().split()))):
    numbers[i+1] = numbers[i] + num
for i in range(m):
    i, j = map(int, sys.stdin.readline().split())
    print(numbers[j] - numbers[i-1])