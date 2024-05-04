a1, a2 = map(int, input().split())
c = int(input())
n0 = int(input())

if a1 > c and a2 < 0:
    result = 0
else:
    result = 1 if a1*n0 + a2 <= c*n0 else 0

print(result)
