min, max = map(int, input().split())

N = max - min + 1
is_divisable = [False] * (max-min+1)

for i in range(2, int(max**0.5+1)):
    square = i**2
    for j in range((((min-1)//square)+1)*square, max+1, square):
        if not is_divisable[j-min] :
            is_divisable[j-min] = True
            N -= 1
print(N)