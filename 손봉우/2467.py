N = int(input())
L = list(map(int, input().split()))

start, end = 0, len(L)-1
min_ = 2000000000
result = (L[start], L[end])

while start < end:
    val = L[start]+L[end]

    if abs(val) < min_:
        result = (L[start], L[end])
        min_ = abs(val)
    if val == 0:
        break
    if val > 0:
        end -= 1
    if val < 0:
        start += 1
     

print (result[0], result[1])
