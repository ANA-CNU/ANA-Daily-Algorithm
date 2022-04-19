import sys
from math import gcd, sqrt
n = int(sys.stdin.readline())
numbers = [int(sys.stdin.readline()) for _ in range(n)]
numbers.sort()

interval = [numbers[i] - numbers[i-1] for i in range(1, n)]
prev = interval[0]
gcd_list = []
for i in range(1, len(interval)):
    prev = gcd(prev, interval[i])

answer = []
for i in range(2, int(sqrt(prev))+1):
    if prev % i == 0:
        answer.append(i)
        answer.append(prev//i)
answer.append(prev)
answer = list(set(answer))
answer.sort()
print(*answer)