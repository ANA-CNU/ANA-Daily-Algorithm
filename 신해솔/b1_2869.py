import math


a, b, v = map(int, input().split())

progress = 0
day = 0

while progress < v:
    progress += a - b
    day += 1

print(day)
